package co.edu.cesde.ga.service.impl;

import co.edu.cesde.ga.model.Teacher;
import co.edu.cesde.ga.repository.TeacherRepository;
import co.edu.cesde.ga.service.TeacherService;
import java.util.List;

public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Teacher create(Teacher teacher) {
        if (isInvalidTeacher(teacher)) return null;
        if (teacherRepository.existsById(teacher.getTeacherId())) return null;
        return teacherRepository.create(teacher);
    }

    @Override
    public Teacher update(Teacher teacher) {
        if (isInvalidTeacher(teacher)) return null;
        if (!teacherRepository.existsById(teacher.getTeacherId())) return null;
        return teacherRepository.update(teacher);
    }

    @Override
    public boolean delete(Long id) {
        if (id == null || id <= 0L) return false;
        return teacherRepository.delete(id);
    }

    @Override
    public Teacher findById(Long id) {
        if (id == null || id <= 0L) return null;
        return teacherRepository.findById(id);
    }

    @Override
    public Teacher findByName(String name) {
        if (name == null || name.isBlank()) return null;
        return teacherRepository.findByName(name);
    }

    @Override
    public boolean existsById(Long id) {
        if (id == null || id <= 0L) return false;
        return teacherRepository.existsById(id);
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    private boolean isInvalidTeacher(Teacher teacher) {
        return teacher == null
                || !isNotBlank(teacher.getDocumentNumber())
                || !isNotBlank(teacher.getFirstName())
                || !isNotBlank(teacher.getLastName())
                || !isNotBlank(teacher.getStatus());
    }

    private boolean isNotBlank(String value) {
        return value != null && !value.trim().isEmpty();
    }
}