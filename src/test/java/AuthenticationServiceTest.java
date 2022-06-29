import org.example.data.UserRepository;
import org.example.model.User;
import org.example.service.AuthenticationService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;


import static org.mockito.Mockito.*;

public class AuthenticationServiceTest {
    AuthenticationService mockAuthenticationService;
    UserRepository mockUserRepository;
    List<User> mockUserList = new ArrayList<>();


    @BeforeEach
    public void setUp() {
        mockUserRepository = mock(UserRepository.class);
        mockAuthenticationService = new AuthenticationService(mockUserRepository);
        User shreeji = new User(123, "Shreeji", "Patel", "shreeji0312", "Password1", "shreeji0312@email.com", new ArrayList<>());
        User kenil = new User(456, "Kenil", "Lund", "kenil1212", "Password2", "kenil1212@email.com", new ArrayList<>());
        User yash = new User(789, "Yash", "Kalathiya", "yash1602", "Password3", "yash1602@email.com", new ArrayList<>());
        mockUserList.add(shreeji);
        mockUserList.add(kenil);
        mockUserList.add(yash);
        when(mockUserRepository.findById(shreeji.getUserId())).thenReturn(shreeji);
    }

    @Test
    public void testAuthenticateMethodWithValidUserNameAndPassword() throws Exception {
        mockAuthenticationService.authenticate("shreeji0312", "Password1");
        verify(mockUserRepository, times(1)).validate("shreeji0312", "Password1");
    }

    @Test
    public void testAuthenticateMethodWithInvalidUserNameAndPassword() throws Exception {
        Assert.assertEquals(null, mockAuthenticationService.authenticate("chahak", "Password4"));
    }

    @Test
    public void testFindByIdWithValidId() throws Exception {
        Assert.assertEquals( 123 , mockAuthenticationService.findById(123).getUserId());
    }

    @Test
    public void testFindByIdWithInvalidId(){
        Assert.assertThrows(Exception.class, () -> mockAuthenticationService.findById(159));
    }

}
