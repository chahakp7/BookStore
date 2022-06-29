import org.example.data.BookRepository;
import org.example.model.Book;
import org.example.model.BookGenre;
import org.example.service.BookService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static org.mockito.Mockito.*;


public class BookServiceTest {
    BookService mockBookService;
    BookRepository mockBookRepository;
    List<Book> mockBookList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        mockBookRepository = mock(BookRepository.class);
        mockBookService = new BookService(mockBookRepository);
        Book book1 = new Book(123, 152, "Fatal Impact", "Kenil Chovatiya", BookGenre.ACTION);
        Book book2 = new Book(456, 162, "Iron-man", "Shreeji Patel", BookGenre.COMIC);
        Book book3 = new Book(789, 185, "Greek History", "Yash Kalathiya", BookGenre.HISTORICAL);
        Book book4 = new Book(159, 195, "Stephen King", "Chahak Patel", BookGenre.HORROR);
        mockBookList.add(book1);
        mockBookList.add(book2);
        mockBookList.add(book3);
        mockBookList.add(book4);
        when(mockBookService.getAllBooks()).thenReturn(mockBookList);
    }

    @Test
    public void testGetAllBook() {
        Assert.assertEquals(4, mockBookList.size());
    }

    @Test
    public void testGetBooksOfGenre() {
        Assert.assertEquals(mockBookList.stream()
                .filter(i -> i.getBookGenre() == BookGenre.HISTORICAL)
                .collect(Collectors.toList()), mockBookService.getBooksOfGenre(BookGenre.HISTORICAL));
    }

    @Test
    public void testSearchBookByTitle() {
        Assert.assertEquals(1, mockBookService.searchBookByTitle("Iron-man").size());
    }

    @Test
    public void testSearchBooksByAuthorName() {
        Assert.assertEquals(1, mockBookService.searchBooksByAuthorName("Shreeji Patel")
                .size());
    }

    @Test
    public void testFindByIdValidId() throws Exception {
        Assert.assertEquals(123 , mockBookService.findById(123).getItemId());
    }

    @Test
    public void testFindByIdInvalidId(){
        Assert.assertThrows(Exception.class, () ->
                mockBookService.findById(654));
    }
}
