package com.example.filmwebapplication.Controllers;

import com.example.filmwebapplication.Configurations.JWTTokenValidator;
import com.example.filmwebapplication.DTOs.MessageWithJWTToken;
import com.example.filmwebapplication.DTOs.UserRegisterDTO;
import com.example.filmwebapplication.Exceptions.InvalidArgumentsException;
import com.example.filmwebapplication.Services.RegisterService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @Autowired
    private JWTTokenValidator jwtTokenValidator;

    @GetMapping("/register")
    public ResponseEntity<UserRegisterDTO> registerGet() {
        UserRegisterDTO userRegistrationDTO = new UserRegisterDTO();
        userRegistrationDTO.setUsername("example_username");
        userRegistrationDTO.setPassword("example_password");
        userRegistrationDTO.setEmail("example@example.com");
        userRegistrationDTO.setPhoneNumber("+38112332226");

        return new ResponseEntity<UserRegisterDTO>(userRegistrationDTO, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<MessageWithJWTToken> registerPost(@NotNull @RequestBody UserRegisterDTO userRegistrationDTO) {
        String username = userRegistrationDTO.getUsername();
        String password = userRegistrationDTO.getPassword();

        try {
            registerService.registerUser(userRegistrationDTO);
        } catch(InvalidArgumentsException e) {
            return new ResponseEntity<>(new MessageWithJWTToken("Invalid arguments!", null), HttpStatus.BAD_REQUEST);
        }

        MessageWithJWTToken returnMessage = new MessageWithJWTToken();
        returnMessage.setMessage("Registration successful!");
        returnMessage.setJWTToken(jwtTokenValidator.generateToken(username));

        return new ResponseEntity<>(returnMessage, HttpStatus.ACCEPTED);
    }
}
