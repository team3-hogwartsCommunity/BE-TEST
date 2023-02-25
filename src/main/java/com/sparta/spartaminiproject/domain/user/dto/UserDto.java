package com.sparta.spartaminiproject.domain.user.dto;

import lombok.Getter;

public class UserDto {

    @Getter
    public static class SignupRequest{

        private String userId;
        private String password;
        private String dormitory;
    }

    public static class LoginRequest{
        private String userId;
        private String password;
    }
}
