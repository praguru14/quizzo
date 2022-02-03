package com.pg.backend.quiz.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userRoleId;

    @ManyToOne(fetch = FetchType.EAGER)
    private UserModel user;

    @ManyToOne
    private RoleModel role;

    public UserRole() {
    }

    public UserRole(Long userRoleId, UserModel user, RoleModel role) {
        this.userRoleId = userRoleId;
        this.user = user;
        this.role = role;
    }
}
