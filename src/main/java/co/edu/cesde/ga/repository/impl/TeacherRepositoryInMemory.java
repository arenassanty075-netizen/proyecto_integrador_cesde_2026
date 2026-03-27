package co.edu.cesde.ga.repository.impl;

import co.edu.cesde.ga.model.Teacher;
import co.edu.cesde.ga.repository.TeacherRepository;

import java.util.ArrayList;
import java.util.List;

public class TeacherRepositoryInMemory implements TeacherRepository {

    private List<Teacher> teachers;
    private long nextTeacherId;

    public TeacherRepositoryInMemory() {
        this.teachers = new ArrayList<>();
        this.nextTeacherId = 1L;
    }

    @Override
    public Teacher create(Teacher teacher) {
        if (teacher == null) {
            return null;
        }

        if (existsByDocumentNumber(teacher.getDocumentNumber())) {
            return null;
        }

        teacher.setTeacherId(nextTeacherId++);
        teachers.add(teacher);
        return teacher;
    }

    // 🔥 VALIDAR SI EXISTE POR DOCUMENTO
    public boolean existsByDocumentNumber(String documentNumber) {
        if (documentNumber == null || documentNumber.isBlank()) {
            return false;
        }
        return findByDocumentNumber(documentNumber) != null;
    }

    // 🔥 BUSCAR POR DOCUMENTO
    public Teacher findByDocumentNumber(String documentNumber) {
        if (documentNumber == null || documentNumber.isBlank()) {
            return null;
        }

        for (Teacher teacher : teachers) {
            if (documentNumber.equals(teacher.getDocumentNumber())) {
                return teacher;
            }
        }
        return null;
    }

    @Override
    public List<Teacher> findAll() {
        return new ArrayList<>(teachers);
    }

    @Override
    public Teacher findById(Long id) {
        if (id == null || id <= 0) {
            return null;
        }

        for (Teacher teacher : teachers) {
            if (id.equals(teacher.getUserId())) {
                return teacher;
            }
        }
        return null;
    }

    @Override
    public Teacher findByName(String name) {
        if (name == null || name.isBlank()) {
            return null;
        }

        for (Teacher teacher : teachers) {
            if (name.equalsIgnoreCase(teacher.getFirstName())) {
                return teacher;
            }
        }
        return null;
    }

    @Override
    public boolean existsById(Long id) {
        return findById(id) != null;
    }

    @Override
    public boolean delete(Long id) {
        Teacher teacher = findById(id);
        if (teacher == null) return false;

        teachers.remove(teacher);
        return true;
    }

    @Override
    public int count() {
        return teachers.size();
    }

    @Override
    public Teacher update(Teacher updatedTeacher) {
        if (updatedTeacher == null) return null;

        for (int i = 0; i < teachers.size(); i++) {
            if (updatedTeacher.getTeacherId() == teachers.get(i).getTeacherId()) {
                teachers.set(i, updatedTeacher);
                return updatedTeacher;
            }
        }
        return null;
    }
}