package co.edu.cesde.ga.service.impl;

import co.edu.cesde.ga.exceptions.DuplicateException;
import co.edu.cesde.ga.exceptions.InvalidDataException;
import co.edu.cesde.ga.exceptions.NotFoundException;
import co.edu.cesde.ga.domain.model.Teacher;
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

        if (teacher == null) {
            throw new InvalidDataException("El profesor no puede ser nulo");
        }

        if (isInvalidTeacher(teacher)) {
            throw new InvalidDataException("Datos del profesor inválidos");
        }

        if (teacherRepository.existsById(teacher.getTeacherId())) {
            throw new DuplicateException("Ya existe un profesor con ese ID");
        }

        return teacherRepository.create(teacher);
    }

    @Override
    public Teacher update(Teacher teacher) {

        if (teacher == null || teacher.getTeacherId() <= 0) {
            throw new InvalidDataException("ID inválido");
        }

        if (!teacherRepository.existsById(teacher.getTeacherId())) {
            throw new NotFoundException("Profesor no encontrado");
        }

        if (isInvalidTeacher(teacher)) {
            throw new InvalidDataException("Datos inválidos");
        }

        return teacherRepository.update(teacher);
    }

    @Override
    public boolean delete(Long id) {

        if (id == null || id <= 0L) {
            throw new InvalidDataException("ID inválido");
        }

        if (!teacherRepository.existsById(id)) {
            throw new NotFoundException("Profesor no encontrado");
        }

        return teacherRepository.delete(id);
    }

    @Override
    public Teacher findById(Long id) {

        if (id == null || id <= 0L) {
            throw new InvalidDataException("ID inválido");
        }

        Teacher teacher = teacherRepository.findById(id);

        if (teacher == null) {
            throw new NotFoundException("Profesor no encontrado");
        }

        return teacher;
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