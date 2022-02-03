package com.pg.backend.quiz.dao;

import com.pg.backend.quiz.models.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<RoleModel,Long> {
}
