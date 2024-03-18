package com.cryptographyapi.cryptographyapi.controller;

import com.cryptographyapi.cryptographyapi.domain.User;
import com.cryptographyapi.cryptographyapi.dto.UserDTO;
import com.cryptographyapi.cryptographyapi.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<List<User>> findAll(){
        List<User> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/document")
    public ResponseEntity<Optional<User>> findByUserDocument(@RequestBody String userDocument) {
        Optional<User> user = userService.findByUserDocument(userDocument);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/creditcardtoken")
    public ResponseEntity<Optional<User>>  findByCreditCardToken(@RequestBody String creditCardToken) {
        Optional<User> user = userService.findByCreditCardToken(creditCardToken);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> findById(@PathVariable Long id){
        Optional<User> user = userService.findById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<User> saveUser(@RequestBody UserDTO userDTO){
        User user = userService.saveUser(userDTO);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<User> editUser(@RequestBody UserDTO userDTO){
        User user = userService.updateUser(userDTO);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/")
    public ResponseEntity<Optional<User>> deleteUser(@RequestBody String userDocument){
        Optional<User> user = userService.deleteUser(userDocument);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
