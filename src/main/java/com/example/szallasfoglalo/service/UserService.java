package com.example.szallasfoglalo.service;

import com.example.szallasfoglalo.model.RoleEnum;
import com.example.szallasfoglalo.model.User;
import com.example.szallasfoglalo.model.dto.LoginDto;
import com.example.szallasfoglalo.model.dto.SignupDto;
import com.example.szallasfoglalo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User regist(SignupDto signupDto) {
        User user = new User();
        user.setEmail(signupDto.getEmail());
        user.setPassword(signupDto.getPassword());
        user.setFirstName(signupDto.getFirstName());
        user.setLastName(signupDto.getLastName());

        if (signupDto.getRoleEnum().equals(RoleEnum.USER.name())){
            user.setRoleEnum(RoleEnum.USER);
        } else user.setRoleEnum(RoleEnum.ACCOMMODATION);

        return userRepository.save(user);
    }

    public User login(LoginDto loginDto) {
        User user = userRepository.findByEmail(loginDto.getEmail()).orElse(null);
        if (user == null){
            throw new NullPointerException();
        }

        if (!user.getPassword().equals(loginDto.getPassword())){
            //EXCEPTIONOK KELLENEK
            throw new NullPointerException();
        }

        return user;
    }

    public User update(SignupDto signupDto, int id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null){
            throw new NullPointerException();
        }

        user.setEmail(signupDto.getEmail());
        user.setPassword(signupDto.getPassword());
        user.setFirstName(signupDto.getFirstName());
        user.setLastName(signupDto.getLastName());

        if (signupDto.getRoleEnum().equals(RoleEnum.USER.name())){
            user.setRoleEnum(RoleEnum.USER);
        } else user.setRoleEnum(RoleEnum.ACCOMMODATION);

        return userRepository.save(user);
    }

    public User getUserById(int userId) {
        User user = this.userRepository.findById(userId).orElse(null);
        if (user == null){
            throw new NullPointerException();
        }

        return user;
    }
}
