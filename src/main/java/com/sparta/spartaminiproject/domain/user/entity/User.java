package com.sparta.spartaminiproject.domain.user.entity;

import com.sparta.spartaminiproject.common.entity.Timestamped;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
public class User extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = true)
    private String dormitory;

    public User(String userId, String password, String dormitory) {
        this.userId = userId;
        this.password = password;
        this.dormitory = dormitory;
    }
}
