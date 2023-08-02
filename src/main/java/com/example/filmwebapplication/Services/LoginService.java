package com.example.filmwebapplication.Services;

import com.example.filmwebapplication.DTOs.UserLoginDTO;
import com.example.filmwebapplication.Exceptions.InvalidArgumentsException;
import com.example.filmwebapplication.Models.User;
import com.example.filmwebapplication.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public PasswordEncoder passwordEncoder;

    public void loginUser(UserLoginDTO userLoginDTO) throws InvalidArgumentsException {
        if(userLoginDTO.getPassword() == null || userLoginDTO.getUsername() == null) throw new InvalidArgumentsException();

        String username = userLoginDTO.getUsername();
        String password = userLoginDTO.getPassword();

        User userByUsername = userRepository.findByUsername(username);

        if(userByUsername == null) throw new InvalidArgumentsException();

        if(!passwordEncoder.matches(password, userByUsername.getPassword())) throw new InvalidArgumentsException();
    }
}
