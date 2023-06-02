package com.vinicius.school.repositories;


import com.vinicius.school.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {


    @Query(nativeQuery = true, value = "SELECT * FROM tb_course INNER JOIN tb_enrollment ON tb_enrollment.course_id = tb_course.id WHERE tb_enrollment.user_id = :userId ")
    List<Course> searchByEnrollment(Long userId);
}
