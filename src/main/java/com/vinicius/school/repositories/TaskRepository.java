package com.vinicius.school.repositories;


import com.vinicius.school.entities.Content;
import com.vinicius.school.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
