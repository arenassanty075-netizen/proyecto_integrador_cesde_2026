package co.edu.cesde.ga.service;

import co.edu.cesde.ga.model.Enrollment;

import java.util.List;

public interface EnrollmentService {
    Enrollment create(Enrollment enrollment);

    boolean existsById(Long enrollmentId);

    Enrollment findById(Long enrollmentId);

    List<Enrollment> findAll();

    boolean delete(Long enrollmentId);

    boolean update(Enrollment enrollment);
}
