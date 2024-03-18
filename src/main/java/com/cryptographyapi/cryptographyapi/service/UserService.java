package com.cryptographyapi.cryptographyapi.service;

import com.cryptographyapi.cryptographyapi.domain.User;
import com.cryptographyapi.cryptographyapi.dto.UserDTO;
import com.cryptographyapi.cryptographyapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User saveUser(UserDTO userDTO) {
        User user = new User();
        user.setUserDocument(bCryptPasswordEncoder.encode(userDTO.userDocument()));
        user.setCreditCardToken(bCryptPasswordEncoder.encode(userDTO.creditCardToken()));
        user.setValue(userDTO.value());
        userRepository.save(user);
        return user;
    }

    public Optional<User> findByUserDocument(String userDocument) {
        return Optional.ofNullable(userRepository.findByUserDocument(userDocument));
    }

    public Optional<User> findByCreditCardToken(String creditCardToken) {
        return Optional.ofNullable(userRepository.findByCreditCardToken(creditCardToken));
    }

    public User updateUser(UserDTO userDTO){
        User user = userRepository.findByUserDocument(userDTO.userDocument());
        user.setCreditCardToken(bCryptPasswordEncoder.encode(userDTO.creditCardToken()));
        user.setValue(userDTO.value());
        userRepository.save(user);
        return user;
    }

    public Optional<User> deleteUser(String userDocument){
        Optional<User> user = Optional.ofNullable(userRepository.findByUserDocument(userDocument));
        user.ifPresent(value -> userRepository.delete(value));
        return user;
    }

    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }


}
