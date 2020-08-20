package com.springboot.project.domain.user;

import com.springboot.project.domain.board.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
