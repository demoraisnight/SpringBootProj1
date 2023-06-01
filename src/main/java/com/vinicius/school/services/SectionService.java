package com.vinicius.school.services;

import com.vinicius.school.dtos.SectionDTO;
import com.vinicius.school.dtos.inputs.SectionInputDTO;
import com.vinicius.school.entities.Section;
import com.vinicius.school.repositories.SectionRepository;
import com.vinicius.school.services.assembler.SectionInputDisassembler;
import com.vinicius.school.services.assembler.SectionModelAssembler;
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
public class SectionService {
    
    @Autowired
    private SectionRepository repository;

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private SectionModelAssembler sectionModelAssembler;

    @Autowired
    private SectionInputDisassembler sectionInputDisassembler;

    @Transactional(readOnly = true)
    public Page<SectionDTO> findAll(Pageable pageable) {
        Page<Section> todosSections = repository.findAll(pageable);
        return new PageImpl<>(sectionModelAssembler.toCollectionModel(todosSections.getContent()), pageable,
                todosSections.getTotalElements());
    }

    @Transactional(readOnly = true)
    public SectionDTO findById(Long id) {
        return sectionModelAssembler.toModel(searchOrThrow(id));
    }

    @Transactional
    public SectionDTO insert(SectionInputDTO sectionInput) {
        Section section = sectionInputDisassembler.toDomainObject(sectionInput);
        section.setResource(resourceService.searchOrThrow(sectionInput.getResource().getId()));
        if(sectionInput.getPrerequisite() == null){
            section.setPrerequisite(null);
        }else{
            section.setPrerequisite(searchOrThrow(sectionInput.getResource().getId()));
        }
        section = repository.save(section);
        return sectionModelAssembler.toModel(section);

      }

      @Transactional
      public SectionDTO update(Long id,
                            SectionInputDTO sectionInput) {
        Section section = searchOrThrow(id);
        sectionInputDisassembler.copyToDomainObject(sectionInput, section);
        section.setResource(resourceService.searchOrThrow(sectionInput.getResource().getId()));
        if(sectionInput.getPrerequisite() == null){
            section.setPrerequisite(null);
        }else{
            section.setPrerequisite(searchOrThrow(sectionInput.getResource().getId()));
        }
        section = repository.save(section);
        return sectionModelAssembler.toModel(section);
      }

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

    public Section searchOrThrow(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Entity Not Found"));
    }
}
