package com.vinicius.school.repositories;

import com.vinicius.school.entities.Enrollment;
import com.vinicius.school.entities.pk.EnrollmentPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, EnrollmentPK> {
}
