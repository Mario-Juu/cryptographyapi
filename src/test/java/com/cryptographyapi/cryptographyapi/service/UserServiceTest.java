package com.cryptographyapi.cryptographyapi.service;

import com.cryptographyapi.cryptographyapi.domain.User;
import com.cryptographyapi.cryptographyapi.dto.UserDTO;
import com.cryptographyapi.cryptographyapi.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@TestComponent
class UserServiceTest {

    @Mock
    UserService service;

    @Mock
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Mock
    UserRepository userRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Should create user successfully")
    void saveUserSuccess() {
        String userDocument = "12345678900";
        String creditCard = "12345678900";
        User user = new User(1L, userDocument, creditCard, 1000L);

        user.setUserDocument(bCryptPasswordEncoder.encode(user.getUserDocument()));
        user.setCreditCardToken(bCryptPasswordEncoder.encode(user.getCreditCardToken()));
        assertNotEquals(user.getUserDocument(), userDocument);
        assertNotEquals(user.getCreditCardToken(), creditCard);
        userRepository.save(user);

        when(userRepository.save(any())).thenReturn(user);
        verify(userRepository, times(1)).save(any());
    }

    @Test
    @DisplayName("Should update user successfully")
    void updateUserSuccess() {
        String userDocument = "12345678900";
        String creditCard = "12345678900";
        User user = new User(1L, userDocument, creditCard, 1000L);

        user.setUserDocument(bCryptPasswordEncoder.encode(user.getUserDocument()));
        user.setCreditCardToken(bCryptPasswordEncoder.encode(user.getCreditCardToken()));
        assertNotEquals(user.getUserDocument(), userDocument);
        assertNotEquals(user.getCreditCardToken(), creditCard);
        userRepository.save(user);

        when(userRepository.save(any())).thenReturn(user);
        verify(userRepository, times(1)).save(any());

        UserDTO userDTO = new UserDTO("10", "10", 100L);
        service.updateUser(userDTO, user.getId());
        verify(service, times(1)).updateUser(userDTO, user.getId());

    }

    @Test
    @DisplayName("Should delete user successfully")
    void deleteUserSuccessful() {
        String userDocument = "12345678900";
        String creditCard = "12345678900";
        User user = new User(1L, userDocument, creditCard, 1000L);

        user.setUserDocument(bCryptPasswordEncoder.encode(user.getUserDocument()));
        user.setCreditCardToken(bCryptPasswordEncoder.encode(user.getCreditCardToken()));
        service.deleteUser(user.getId());
        verify(service, times(1)).deleteUser(user.getId());
    }
}