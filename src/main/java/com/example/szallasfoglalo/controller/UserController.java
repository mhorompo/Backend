package com.example.szallasfoglalo.controller;

import com.example.szallasfoglalo.model.User;
import com.example.szallasfoglalo.model.dto.LoginDto;
import com.example.szallasfoglalo.model.dto.SignupDto;
import com.example.szallasfoglalo.model.dto.UserUpdateDto;
import com.example.szallasfoglalo.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(value = "*", maxAge = 0)
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public User regist(@RequestBody SignupDto signupDto){
        return userService.regist(signupDto);
    }

    @PostMapping("/login")
    public User login(@RequestBody LoginDto loginDto){
        return userService.login(loginDto);
    }

    @PutMapping("/update/{id}")
    public User update(@RequestBody UserUpdateDto userUpdateDto, @PathVariable int id){
        return userService.update(userUpdateDto, id);
    }
}
