package com.springboot.project.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthoritiesRepository extends JpaRepository<Authorities, String> {
}
