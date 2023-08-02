package com.example.filmwebapplication.Controllers;

import com.example.filmwebapplication.Configurations.JWTTokenValidator;
import com.example.filmwebapplication.DTOs.MessageWithJWTToken;
import com.example.filmwebapplication.DTOs.UserLoginDTO;
import com.example.filmwebapplication.Exceptions.InvalidArgumentsException;
import com.example.filmwebapplication.Services.LoginService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private LoginService userLoginService;

    @Autowired
    private JWTTokenValidator jwtTokenValidator;

    @GetMapping("/login")
    public ResponseEntity<UserLoginDTO> loginGet() {
        UserLoginDTO user = new UserLoginDTO();
        user.setUsername("example_username");
        user.setPassword("example_password");

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<MessageWithJWTToken> loginPost(@NotNull @RequestBody UserLoginDTO userLoginDTO) {
        try {
            userLoginService.loginUser(userLoginDTO);
        } catch (InvalidArgumentsException e) {
            return new ResponseEntity<>(new MessageWithJWTToken("Invalid arguments!", null), HttpStatus.BAD_REQUEST);
        }

        String username = userLoginDTO.getUsername();

        MessageWithJWTToken returnMessage = new MessageWithJWTToken();
        returnMessage.setMessage("Login successful!");
        returnMessage.setJWTToken(jwtTokenValidator.generateToken(username));

        return new ResponseEntity<>(returnMessage, HttpStatus.ACCEPTED);
    }

}
