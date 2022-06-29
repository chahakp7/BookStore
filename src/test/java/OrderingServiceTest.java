import org.example.data.BookRepository;
import org.example.data.OrderRepository;
import org.example.data.UserRepository;
import org.example.model.Book;
import org.example.model.BookGenre;
import org.example.model.Order;
import org.example.model.User;
import org.example.service.AuthenticationService;
import org.example.service.BookService;
import org.example.service.OrderingService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class OrderingServiceTest {
    OrderingService mockOrderingService;
    OrderRepository mockOrderRepository;

    AuthenticationService mockAuthenticationService;
    UserRepository mockUserRepository;

    BookService mockBookService;
    BookRepository mockBookRepository;

    List<Book> mockBookList = new ArrayList<>();
    List<User> mockUserList = new ArrayList<>();
    List<Order> mockOrderList = new ArrayList<>();


    @BeforeEach
    public void setUp() throws Exception {
        mockUserRepository = mock(UserRepository.class);
        mockAuthenticationService = new AuthenticationService(mockUserRepository);

        mockBookRepository = mock(BookRepository.class);
        mockBookService = new BookService(mockBookRepository);

        mockOrderRepository = mock(OrderRepository.class);
        mockOrderingService = new OrderingService(mockOrderRepository, mockBookService, mockAuthenticationService);

        User shreeji = new User(123, "Shreeji", "Patel", "shreeji0312", "Password1", "shreeji0312@email.com", new ArrayList<>());
        User kenil = new User(456, "Kenil", "Lund", "kenil1212", "Password2", "kenil1212@email.com", new ArrayList<>());
        User yash = new User(789, "Yash", "Kalathiya", "yash1602", "Password3", "yash1602@email.com", new ArrayList<>());
        mockUserList.add(shreeji);
        mockUserList.add(kenil);
        mockUserList.add(yash);

        mockBookList.add(new Book(123, 152, "Fatal Impact", "Kenil Chovatiya", BookGenre.ACTION));
        mockBookList.add(new Book(456, 162, "Iron-man", "Shreeji Patel", BookGenre.COMIC));
        mockBookList.add(new Book(789, 185, "Greek History", "Yash Kalathiya", BookGenre.HISTORICAL));
        mockBookList.add(new Book(159, 195, "Stephen King", "Chahak Patel", BookGenre.HORROR));

        when(mockBookService.getAllBooks()).thenReturn(mockBookList);
        when(mockUserRepository.findAll()).thenReturn(mockUserList);
        for (User user : mockUserRepository.findAll()) {
            when(mockUserRepository.validate(user.getUserName(), user.getPassword())).thenReturn(true);
            when(mockUserRepository.findByUsername(user.getUserName())).thenReturn(user);
            when(mockUserRepository.findById(user.getUserId())).thenReturn(user);
        }

        Order order1 = new Order(mockBookList.get(0), shreeji, LocalDateTime.now());
        Order order2 = new Order(mockBookList.get(1), kenil, LocalDateTime.now());
        Order order3 = new Order(mockBookList.get(2), yash, LocalDateTime.now());
        Order order4 = new Order(mockBookList.get(3), shreeji, LocalDateTime.now());

        mockOrderList.add(order1);
        mockOrderList.add(order2);
        mockOrderList.add(order3);
        mockOrderList.add(order4);
        mockOrderList.add(order1);


        for (Order order : mockOrderList) {
            when(mockOrderRepository.findAll()).thenReturn(mockOrderList);
        }

    }


    @Test
    public void testPlaceOrder(){
        Assert.assertEquals(5, mockOrderingService.placeOrder(mockBookList.get(0), mockUserList.get(0)).getOrderId());
    }

    @Test
    public void testPlaceOrderSave() {
        Order mockOrder = mockOrderingService.placeOrder(mockBookList.get(0), mockUserList.get(0));
        verify(mockOrderRepository, times(1)).save(mockOrder);
    }

    @Test
    public void testGetOrdersForUser(){
        Assert.assertEquals(3, mockOrderingService.getOrdersForUser(mockUserList.get(0)).size());
    }

    @Test
    public void testGetOrdersForBook(){
        Assert.assertEquals(2, mockOrderingService.getOrdersForBook(mockBookList.get(0)).size());
    }

    @Test
    public void testPlaceOrderForInvalidUser(){
        User temp = new User(1234, "temp", "temp", "tempTemp", "temp123","temp@temp.com", new ArrayList<>() );
        Assert.assertThrows(Exception.class, () -> mockOrderingService.placeOrder(mockBookList.get(1), temp ));
    }

}
