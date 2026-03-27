package co.edu.cesde.ga.repository.impl;

import co.edu.cesde.ga.model.Grade;
import co.edu.cesde.ga.repository.GradesRepository;

import java.util.ArrayList;
import java.util.List;

public class GradesRepositoryInMemory implements GradesRepository {

    private List<Grade> grades;
    private long nextGradeId;

    public GradesRepositoryInMemory() {
        this.grades = new ArrayList<>();
        this.nextGradeId = 1L;
    }

    @Override
    public Grade create(Grade grade) {
        if (grade == null) {
            return null;
        }

        grade.setGradeId(nextGradeId++);
        grades.add(grade);
        return grade;
    }

    @Override
    public boolean existsById(long gradeId) {
        return findById(gradeId) != null;
    }

    @Override
    public Grade findById(long gradeId) {
        if (gradeId <= 0) {
            return null;
        }

        for (Grade grade : grades) {
            if (grade.getGradeId() == gradeId) {
                return grade;
            }
        }
        return null;
    }

    @Override
    public List<Grade> findAll() {
        return new ArrayList<>(grades);
    }

    @Override
    public boolean delete(long gradeId) {
        Grade grade = findById(gradeId);
        if (grade == null) return false;

        grades.remove(grade);
        return true;
    }

    @Override
    public int count() {
        return grades.size();
    }

    @Override
    public boolean update(Grade updatedGrade) {
        if (updatedGrade == null) return false;

        for (int i = 0; i < grades.size(); i++) {
            if (updatedGrade.getGradeId() == grades.get(i).getGradeId()) {
                grades.set(i, updatedGrade);
                return true;
            }
        }
        return false;
    }
}