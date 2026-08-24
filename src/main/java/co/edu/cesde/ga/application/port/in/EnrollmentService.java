package co.edu.cesde.ga.application.port.in;

import co.edu.cesde.ga.domain.model.Enrollment;

import java.util.List;

public interface EnrollmentService {
    Enrollment create(Enrollment enrollment);

    boolean existsById(Long enrollmentId);

    Enrollment findById(Long enrollmentId);

    List<Enrollment> findAll();

    boolean delete(Long enrollmentId);

    boolean update(Enrollment enrollment);
}
