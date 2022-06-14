package com.basketteamapi.basketteam.components.user;

import com.basketteamapi.basketteam.components.user.User;
import com.basketteamapi.basketteam.components.user.UserRepository;
import com.basketteamapi.basketteam.components.user.UserService;
import com.basketteamapi.basketteam.security.UserAuthToken;
import com.basketteamapi.basketteam.components.user.exceptions.UserNameIsBusyException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class UserServiceTest {
    @Mock
    private User user;

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService(
                userRepository,
                passwordEncoder
        );
    }

    @Test
    void createBasicToken() {

        Mockito.when(passwordEncoder.encode(user.getPassword())).thenReturn("");

        User result = userService.createBasicTokenAndPassword(user);

        Assertions.assertEquals(user, result);
    }

    @Test
    void addUser() {
        Mockito
            .when(userRepository.findByUsername(user.getUsername()))
            .thenReturn(null);

        Mockito.when(userRepository.save(user)).thenReturn(user);

        User result = userService.addUser(user);

        Assertions.assertEquals(user, result);
    }

    @Test
    void addUserFail() {
        Mockito
            .when(userRepository.findByUsername(user.getUsername()))
            .thenReturn(user);

        UserNameIsBusyException thrown = Assertions.assertThrows(
                UserNameIsBusyException.class,
                () -> {userService.addUser(user);}
        );

        Assertions.assertEquals(UserNameIsBusyException.class, thrown.getClass());
    }

    @Test
    void getUserByUserName() {
        Mockito
            .when(userRepository.findByUsername(user.getUsername()))
            .thenReturn(user);

        User result = userService.getUserByUserName(user.getUsername());

        Assertions.assertEquals(user, result);
    }

    @Test
    void getUserAuthToken() {
        User userTest = new User();
        userTest.setUsername("username");
        userTest.setPassword("password");

        String token = userTest.getUsername() + ":" + userTest.getPassword();

        UserAuthToken userAuthToken = new UserAuthToken(
                Base64.getEncoder().encodeToString(token.getBytes(StandardCharsets.UTF_8))
        );

        userTest.setBasic_token(userAuthToken.token);

        Assertions.assertEquals(userAuthToken.token, userService.getUserAuthToken(userTest).token);
    }
}