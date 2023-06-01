package com.vinicius.school.services;

import com.vinicius.school.dtos.ContentDTO;
import com.vinicius.school.dtos.LessonDTO;
import com.vinicius.school.dtos.TaskDTO;
import com.vinicius.school.dtos.inputs.ContentInputDTO;
import com.vinicius.school.dtos.inputs.TaskInputDTO;
import com.vinicius.school.dtos.partials.SectionPartialDTO;
import com.vinicius.school.entities.Content;
import com.vinicius.school.entities.Lesson;
import com.vinicius.school.entities.Task;
import com.vinicius.school.repositories.ContentRepository;
import com.vinicius.school.repositories.LessonRepository;
import com.vinicius.school.repositories.TaskRepository;
import com.vinicius.school.services.assembler.LessonInputDisassembler;
import com.vinicius.school.services.assembler.LessonModelAssembler;
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

@Service
public class LessonService {

    @Autowired
    private LessonRepository repository;

    @Autowired
    private ContentRepository contentRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private SectionService sectionService;

    @Autowired
    private LessonModelAssembler lessonModelAssembler;

    @Autowired
    private LessonInputDisassembler lessonInputDisassembler;

    @Transactional(readOnly = true)
    public Page<LessonDTO> findAll(Pageable pageable) {
        Page<Lesson> todosLessons = repository.findAll(pageable);
        return new PageImpl<>(lessonModelAssembler.toCollectionModel(todosLessons.getContent()), pageable,
                todosLessons.getTotalElements());
    }

    @Transactional(readOnly = true)
    public Object findById(Long id) {
        Lesson lesson = searchOrThrow(id);

        if(lesson.getClass().equals(Content.class)){
            Content content = searchOrThrowContent(id);
            ContentDTO dto = new ContentDTO();
            dto.setId(content.getId());
            dto.setTitle(content.getTitle());
            dto.setVideoUri(content.getVideoUri());
            dto.setPosition(content.getPosition());
            dto.setTextContent(content.getTextContent());
            SectionPartialDTO sectionPartialDTO = new SectionPartialDTO();
            sectionPartialDTO.setPosition(content.getSection().getPosition());
            sectionPartialDTO.setTitle(content.getSection().getTitle());
            dto.setSection(sectionPartialDTO);

            return dto;
        }else{
            Task task = searchOrThrowTask(id);
            TaskDTO dto = new TaskDTO();
            dto.setId(task.getId());
            dto.setTitle(task.getTitle());
            dto.setPosition(task.getPosition());
            dto.setDescription(task.getDescription());
            dto.setApprovalCount(task.getApprovalCount());
            dto.setWeight(task.getWeight());
            dto.setQuestionCount(task.getQuestionCount());
            SectionPartialDTO sectionPartialDTO = new SectionPartialDTO();
            sectionPartialDTO.setPosition(task.getSection().getPosition());
            sectionPartialDTO.setTitle(task.getSection().getTitle());
            dto.setSection(sectionPartialDTO);

            return dto;
        }

    }

    @Transactional
    public TaskDTO insertTask(TaskInputDTO lessonInput) {
        Task lesson = new Task();
        lesson.setTitle(lessonInput.getTitle());
        lesson.setPosition(lessonInput.getPosition());
        lesson.setSection(sectionService.searchOrThrow(lessonInput.getSection().getId()));

        lesson.setDescription(lessonInput.getDescription());
        lesson.setApprovalCount(lessonInput.getApprovalCount());
        lesson.setQuestionCount(lessonInput.getQuestionCount());
        lesson.setWeight(lessonInput.getWeight());


        lesson = repository.save(lesson);
        return new TaskDTO(lesson);
    }

    @Transactional
    public ContentDTO insertContent(ContentInputDTO lessonInput) {
        Content lesson = new Content();
        lesson.setTitle(lessonInput.getTitle());
        lesson.setPosition(lessonInput.getPosition());
        lesson.setSection(sectionService.searchOrThrow(lessonInput.getSection().getId()));

        lesson.setTextContent(lessonInput.getTextContent());
        lesson.setVideoUri(lessonInput.getVideoUri());

        lesson = repository.save(lesson);
        return new ContentDTO(lesson);
    }

    //  @Transactional
    //  public LessonDTO update(Long id,
    //                        LessonInputDTO lessonInput) {
    //       Optional<Lesson> obj = repository.findById(id);
    //      Lesson lesson = obj.get();
    //       lessonInputDisassembler.copyToDomainObject(lessonInput, lesson);
    //       lesson = repository.save(lesson);
    //      return lessonModelAssembler.toModel(lesson);
    //  }

    @Transactional
    public void deleteById(Long id) {
        try {
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }

    }

    public Lesson searchOrThrow(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Entity Not Found"));
    }

    public Content searchOrThrowContent(Long id) {
        return contentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Entity Not Found"));
    }

    public Task searchOrThrowTask(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Entity Not Found"));
    }
}
