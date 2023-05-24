package com.vinicius.school.repositories;

import com.vinicius.school.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
