package co.edu.cesde.ga.service;

import co.edu.cesde.ga.model.Student;

import java.util.List;

public interface StudentService {
    Student create(Student student);
    boolean update(Student studentUpdate);
    boolean delete(Long studentId);
    Student findById(Long studentId);

    Student findByDocumentNumber(String documentNumber);

    List<Student> findAll();
}
