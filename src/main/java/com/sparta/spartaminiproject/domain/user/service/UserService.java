package com.sparta.spartaminiproject.domain.user.service;

import com.sparta.spartaminiproject.domain.user.dto.UserDto;
import com.sparta.spartaminiproject.domain.user.entity.User;
import com.sparta.spartaminiproject.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void signup(UserDto.SignupRequest signupRequest){
        String userId = signupRequest.getUserId();
        String password = signupRequest.getPassword();
        String dormitory = signupRequest.getDormitory();

        //중복 확인
        Optional<User> check = userRepository.findByUserId(userId);
        if (check.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자가 존재합니다.");
        }
        User user = new User(userId, password, dormitory);
        userRepository.save(user);
    }

    @Transactional
    public void login(UserDto.SignupRequest signupRequest){
        String userId = signupRequest.getUserId();
        String password = signupRequest.getPassword();
        String dormitory = signupRequest.getDormitory();

        //중복 확인
        Optional<User> check = userRepository.findByUserId(userId);
        if (check.isEmpty()) {
            throw new IllegalArgumentException("등록된 사용자가 없습니다.");
        }
        // 3. 비밀번호가 Client 에게 받은 비밀번호와 일치하는지 확인.
        if (!check.get().getPassword().equals(password)) {
            throw new IllegalArgumentException("비밀번호와 일치하지 않습니다.");
        }
        User user = new User(userId, password, dormitory);
        userRepository.save(user);
    }
}
