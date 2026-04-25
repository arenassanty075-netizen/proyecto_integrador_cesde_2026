package co.edu.cesde.ga.service.impl;

import co.edu.cesde.ga.model.Subject;
import co.edu.cesde.ga.repository.SubjectsRepository;
import co.edu.cesde.ga.service.SubjectService;
import java.util.List;

public class SubjectServiceImpl implements SubjectService {

    private final SubjectsRepository subjectsRepository;

    public SubjectServiceImpl(SubjectsRepository subjectsRepository) {
        this.subjectsRepository = subjectsRepository;
    }

    @Override
    public Subject create(Subject subject) {
        if (isInvalidSubject(subject)) return null;
        if (subjectsRepository.existsByCode(subject.getCode())) return null;
        return subjectsRepository.create(subject);
    }

    @Override
    public boolean update(Subject subject) {
        if (isInvalidSubject(subject)) return false;
        if (!subjectsRepository.existsByCode(subject.getCode())) return false;
        return subjectsRepository.update(subject);
    }

    @Override
    public boolean delete(String code) {
        if (code == null || code.isBlank()) return false;
        return subjectsRepository.delete(code);
    }

    @Override
    public Subject findByCode(String code) {
        if (code == null || code.isBlank()) return null;
        return subjectsRepository.findByCode(code);
    }

    @Override
    public boolean existsByCode(String code) {
        if (code == null || code.isBlank()) return false;
        return subjectsRepository.existsByCode(code);
    }

    @Override
    public List<Subject> findAll() {
        return subjectsRepository.findAll();
    }

    private boolean isInvalidSubject(Subject subject) {
        return subject == null
                || !isNotBlank(subject.getCode())
                || !isNotBlank(subject.getName())
                || subject.getCredits() <= 0
                || subject.getProgramId() <= 0L;
    }

    private boolean isNotBlank(String value) {
        return value != null && !value.trim().isEmpty();
    }
}