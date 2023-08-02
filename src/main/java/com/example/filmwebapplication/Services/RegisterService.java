package com.example.filmwebapplication.Services;

import com.example.filmwebapplication.DTOs.UserRegisterDTO;
import com.example.filmwebapplication.Exceptions.InvalidArgumentsException;
import com.example.filmwebapplication.Models.User;
import com.example.filmwebapplication.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public void registerUser(UserRegisterDTO userRegistrationDTO) throws InvalidArgumentsException {
        if(userRegistrationDTO.getUsername()            == null ||
                userRegistrationDTO.getPassword()       == null ||
                userRegistrationDTO.getEmail()          == null ||
                userRegistrationDTO.getPhoneNumber()    == null)
            throw new InvalidArgumentsException();

        String hashedPassword = passwordEncoder.encode(userRegistrationDTO.getPassword());

        userRegistrationDTO.setPassword(hashedPassword);

        User user = new User(
                userRegistrationDTO.getUsername(),
                userRegistrationDTO.getPassword(),
                userRegistrationDTO.getEmail(),
                userRegistrationDTO.getPhoneNumber());

        userRepository.save(user);
    }
}
