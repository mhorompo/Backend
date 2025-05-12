package com.example.szallasfoglalo.service;

import com.example.szallasfoglalo.exception.AuthenticationException;
import com.example.szallasfoglalo.model.RoleEnum;
import com.example.szallasfoglalo.model.User;
import com.example.szallasfoglalo.model.dto.LoginDto;
import com.example.szallasfoglalo.model.dto.SignupDto;
import com.example.szallasfoglalo.model.dto.UserUpdateDto;
import com.example.szallasfoglalo.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User regist(SignupDto signupDto) {
        if (signupDto == null)
            throw new AuthenticationException("Data is missing");

        if (userRepository.existsByEmail(signupDto.getEmail()))
            throw new AuthenticationException("Email already in use");

        User user = new User();
        user.setEmail(signupDto.getEmail());
        user.setFirstName(signupDto.getFirstName());
        user.setLastName(signupDto.getLastName());

        user.setPassword(BCrypt.hashpw(signupDto.getPassword(), BCrypt.gensalt()));

        if (signupDto.getRoleEnum().equals(RoleEnum.USER.name())) {
            user.setRoleEnum(RoleEnum.USER);
        } else user.setRoleEnum(RoleEnum.ACCOMMODATION);

        return userRepository.save(user);
    }

    public User login(LoginDto loginDto) {
        User user = userRepository.findByEmail(loginDto.getEmail()).orElse(null);
        if (user == null) {
            throw new AuthenticationException("Invalid Email address");
        }
        if (!BCrypt.checkpw(loginDto.getPassword(), user.getPassword())) {
            throw new AuthenticationException("Invalid password");
        }

        return user;
    }

    public User update(UserUpdateDto userUpdateDto, int id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new AuthenticationException("Invalid Email address");
        }

        user.setEmail(userUpdateDto.getEmail());
        user.setFirstName(userUpdateDto.getFirstName());
        user.setLastName(userUpdateDto.getLastName());

        if (!BCrypt.checkpw(userUpdateDto.getOldPass(), user.getPassword())) {
            throw new AuthenticationException("Invalid password");
        }

        user.setPassword(BCrypt.hashpw(userUpdateDto.getPassword(), BCrypt.gensalt()));

        return userRepository.save(user);
    }

    public User getUserById(int userId) {
        User user = this.userRepository.findById(userId).orElse(null);
        if (user == null) {
            throw new AuthenticationException("Invalid Email address");
        }

        return user;
    }
}
