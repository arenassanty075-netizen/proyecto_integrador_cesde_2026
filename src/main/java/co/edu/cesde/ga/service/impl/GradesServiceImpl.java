
package co.edu.cesde.ga.service.impl;

import co.edu.cesde.ga.model.Grade;
import co.edu.cesde.ga.repository.GradesRepository;
import co.edu.cesde.ga.service.GradesService;
import java.util.List;

public class GradesServiceImpl implements GradesService {

    private final GradesRepository gradesRepository;

    public GradesServiceImpl(GradesRepository gradesRepository) {
        this.gradesRepository = gradesRepository;
    }

    @Override
    public Grade create(Grade grade) {
        if (isInvalidGrade(grade)) return null;
        return gradesRepository.create(grade);
    }

    @Override
    public boolean update(Grade grade) {
        if (isInvalidGrade(grade) || grade.getGradeId() <= 0L) return false;
        return gradesRepository.update(grade);
    }

    @Override
    public boolean delete(long gradeId) {
        if (gradeId <= 0L) return false;
        return gradesRepository.delete(gradeId);
    }

    @Override
    public Grade findById(long gradeId) {
        if (gradeId <= 0L) return null;
        return gradesRepository.findById(gradeId);
    }

    @Override
    public List<Grade> findAll() {
        return gradesRepository.findAll();
    }

    private boolean isInvalidGrade(Grade grade) {
        return grade == null
                || grade.getGroupSubjectId() <= 0L
                || grade.getStudentId() <= 0L
                || grade.getFinalScore() <= 0
                || !isNotBlank(grade.getObservation());
    }

    private boolean isNotBlank(String value) {
        return value != null && !value.trim().isEmpty();
    }
}