package com.vinicius.school.services;

import com.vinicius.school.dtos.CourseDTO;
import com.vinicius.school.dtos.EnrollmentDTO;
import com.vinicius.school.dtos.inputs.EnrollmentInputDTO;
import com.vinicius.school.entities.Course;
import com.vinicius.school.entities.Enrollment;
import com.vinicius.school.entities.User;
import com.vinicius.school.entities.pk.EnrollmentPK;
import com.vinicius.school.repositories.CourseRepository;
import com.vinicius.school.repositories.EnrollmentRepository;
import com.vinicius.school.repositories.UserRepository;
import com.vinicius.school.services.assembler.CourseInputDisassembler;
import com.vinicius.school.services.assembler.CourseModelAssembler;
import com.vinicius.school.services.exceptions.DatabaseException;
import com.vinicius.school.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository repository;

    @Autowired
    private UserService userService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private com.vinicius.school.services.assembler.EnrollmentModelAssembler enrollmentModelAssembler;

    @Autowired
    private com.vinicius.school.services.assembler.EnrollmentInputDisassembler enrollmentInputDisassembler;

    @Transactional(readOnly = true)
    public Page<EnrollmentDTO> findByIdCourseId(Long id, Pageable pageable) {
        Page<Enrollment> allCourseEnrollments = repository.findByIdCourseId(id, pageable);
        return new PageImpl<>(enrollmentModelAssembler.toCollectionModel(allCourseEnrollments.getContent()), pageable,
                allCourseEnrollments.getTotalElements());
    }
    @Transactional
    public EnrollmentDTO save(Long id, Long userId) {
        User user = userService.searchOrThrow(userId);
        Course course = courseService.searchOrThrow(id);
        Enrollment entity = new Enrollment();
        entity.setStudent(user);
        entity.setCourse(course);
        entity.setAvailable(true);
        entity.setEnrollMoment(Instant.now());
        entity = repository.save(entity);
        return enrollmentModelAssembler.toModel(entity);
    }

    @Transactional(readOnly = true)
    public Page<EnrollmentDTO> findAll(Pageable pageable) {
        Page<Enrollment> allEnrollments = repository.findAll(pageable);
        return new PageImpl<>(enrollmentModelAssembler.toCollectionModel(allEnrollments.getContent()), pageable,
                allEnrollments.getTotalElements());
    }

    @Transactional(readOnly = true)
    public EnrollmentDTO findById(Long userId, Long courseId) {
        Enrollment enrollment = searchOrThrow(userId,courseId);
        return enrollmentModelAssembler.toModel(enrollment);
    }

    @Transactional
    public EnrollmentDTO insert(Long userId, Long courseId) {

        User user = userService.searchOrThrow(userId);
        Course course = courseService.searchOrThrow(courseId);

        Enrollment entity = new Enrollment();

        entity.getId().setUser(user);
        entity.getId().setCourse(course);

        if (enrollmentExists(userId,courseId)){
            throw new DatabaseException("Enrollment already exists");
        }

        entity.setAvailable(true);
        entity.setEnrollMoment(Instant.now());
        entity = repository.save(entity);

        return enrollmentModelAssembler.toModel(entity);

    }

    @Transactional
    public EnrollmentDTO update(Long userId, Long courseId, Long newUserId, Long newCourseId) {
        Enrollment entity = searchOrThrow(userId,courseId);

        Enrollment newEntity = new Enrollment();
        if (enrollmentExists(newUserId,newCourseId)){
            throw new DatabaseException("Enrollment already exists");
        }
        newEntity.setAvailable(entity.isAvailable());
        newEntity.setStudent(userService.searchOrThrow(newUserId));
        newEntity.setCourse(courseService.searchOrThrow(newCourseId));
        newEntity.setEnrollMoment(Instant.now());

        repository.delete(entity);

        newEntity = repository.save(newEntity);
        return enrollmentModelAssembler.toModel(newEntity);
    }


    @Transactional
    public void deleteById(Long userId, Long courseId) {
        Enrollment entity = searchOrThrow(userId,courseId);
        repository.delete(entity);
    }

    @Transactional
    public EnrollmentDTO activate(Long userId, Long courseId) {
        Enrollment entity = searchOrThrow(userId,courseId);
        entity.setAvailable(true);
        entity = repository.save(entity);
        return enrollmentModelAssembler.toModel(entity);
    }

    @Transactional
    public EnrollmentDTO deactivate(Long userId, Long courseId) {
        Enrollment entity = searchOrThrow(userId,courseId);
        entity.setAvailable(false);
        entity = repository.save(entity);
        return enrollmentModelAssembler.toModel(entity);
    }



    public Enrollment searchOrThrow(Long userId, Long courseId){
       Enrollment enrollment = repository.findByIdCourseIdAndIdUserId(courseId, userId);

       if(enrollment == null){
       throw new ResourceNotFoundException("Enrollment not found");}

       return enrollment;
    }

    public boolean enrollmentExists(Long userId, Long courseId){
        Enrollment enrollment = repository.findByIdCourseIdAndIdUserId(courseId, userId);
        return enrollment != null;
    }

}
