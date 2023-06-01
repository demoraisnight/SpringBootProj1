package com.vinicius.school.repositories;

import com.vinicius.school.entities.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReplyRepository extends JpaRepository<Resource, Long> {
}
