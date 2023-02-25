package com.sparta.spartaminiproject.domain.user.controller;

import com.sparta.spartaminiproject.domain.user.dto.UserDto;
import com.sparta.spartaminiproject.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @Validated
    @PostMapping("/signup")
    public String signup(@RequestBody UserDto.SignupRequest signupRequest){
        userService.signup(signupRequest);
        return "회원가입 완료";
    }

//    @GetMapping("/login-page")
//    public ModelAndView loginPage() {
//        return new ModelAndView("login");
//    }

    @PostMapping("/login")
    public String login(@RequestBody UserDto.SignupRequest signupRequest){
        userService.login(signupRequest);
        return "로그인 완료";
    }
}
