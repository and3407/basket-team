package com.basketteamapi.basketteam.components.user;

import com.basketteamapi.basketteam.security.UserAuthToken;
import com.basketteamapi.basketteam.components.user.exceptions.UserNameIsBusyException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createBasicTokenAndPassword(User user) {
        user.setBasic_token((new UserAuthToken(user.getUsername() + ":" + user.getPassword())).token);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return user;
    }

    public User addUser(User user) {
        if (this.isExistUserByUserName(user.getUsername())) {
            throw new UserNameIsBusyException(user.getUsername());
        }

        return userRepository.save(user);
    }

    public User getUserByUserName(String name) {
        return userRepository.findByUsername(name);
    }

    public UserAuthToken getUserAuthToken(User user) {
        UserAuthToken userAuthToken = new UserAuthToken();
        userAuthToken.setToken(user.getBasic_token());

        return userAuthToken;
    }

    private Boolean isExistUserByUserName(String name) {
        return userRepository.findByUsername(name) != null;
    }
}
