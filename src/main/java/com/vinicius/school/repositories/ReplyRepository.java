package com.vinicius.school.repositories;

import com.vinicius.school.entities.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Resource, Long> {
}
