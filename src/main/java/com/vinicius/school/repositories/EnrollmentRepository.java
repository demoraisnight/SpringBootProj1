package com.vinicius.school.repositories;

import com.vinicius.school.entities.Enrollment;
import com.vinicius.school.entities.pk.EnrollmentPK;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface EnrollmentRepository extends JpaRepository<Enrollment, EnrollmentPK> {

    Page<Enrollment> findByIdCourseId(Long course, Pageable pageable);

    Enrollment findByIdCourseIdAndIdUserId(Long idCourse, Long idUser);

    void deleteByIdCourseIdAndIdUserId(Long idCourse, Long idUser);

}
