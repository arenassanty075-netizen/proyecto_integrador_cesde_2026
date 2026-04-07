package co.edu.cesde.ga.service.impl;

import co.edu.cesde.ga.model.Student;
import co.edu.cesde.ga.repository.impl.StudentRepositoryInMemory;
import co.edu.cesde.ga.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private final StudentRepositoryInMemory studentRepositoryInMemory;

    public StudentServiceImpl(StudentRepositoryInMemory studentRepositoryInMemory) {
        this.studentRepositoryInMemory = studentRepositoryInMemory;
    }

    @Override
    public Student create(Student student) {
        if (isInvalidStudent(student) || studentRepositoryInMemory.existsByDocumentNumber(student.getDocumentNumber())) {
            return null;
        }
        return studentRepositoryInMemory.create(student);
    }

    @Override
    public boolean update(Student studentUpdate) {
        if (isInvalidStudent(studentUpdate)
                || studentUpdate.getStudentId() == null
                || studentUpdate.getStudentId() <= 0L) {
            return false;
        }
        if (!studentRepositoryInMemory.existsByDocumentNumber(studentUpdate.getDocumentNumber())) {
            return false;
        }
        return studentRepositoryInMemory.update(studentUpdate);
    }

    @Override
    public boolean delete(Long studentId) {
        if (studentId == null || studentId <= 0L) {
            return false;
        }
        return studentRepositoryInMemory.delete(studentId);
    }

    @Override
    public Student findById(Long studentId) {
        if (studentId == null || studentId <= 0L) {
            return null;
        }
        return studentRepositoryInMemory.findById(studentId);
    }

    @Override
    public Student findByDocumentNumber(String documentNumber) {
        if (isNotBlank(documentNumber)) {
            return null;
        }
        return studentRepositoryInMemory.findByDocumentNumber(documentNumber);
    }

    @Override
    public List<Student> findAll() {
        return studentRepositoryInMemory.findAll();
    }

    public boolean isInvalidStudent(Student student) {
        return student == null
                || isNotBlank(student.getDocumentNumber())
                || isNotBlank(student.getFirstName())
                || isNotBlank(student.getLastName())
                || isNotBlank(student.getBirthDate())
                || student.getStatus() == null;
    }

    private boolean isNotBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}