package co.edu.cesde.ga.repository;

import co.edu.cesde.ga.model.Student;
import java.util.List;

public interface StudentRepository {

    Student create(Student student);

    boolean existsByDocumentNumber(String documentNumber);

    Student findByDocumentNumber(String documentNumber);

    List<Student> findAll();

    Student findById(long studentId);

    boolean delete(long studentId);

    int count();

    boolean update(Student student);
}