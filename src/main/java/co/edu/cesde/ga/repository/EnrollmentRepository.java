package co.edu.cesde.ga.repository;

import co.edu.cesde.ga.model.Enrollments;
import java.util.List;

public interface EnrollmentRepository {

    Enrollments create(Enrollments enrollment);

    List<Enrollments> findAll();

    Enrollments findById(long enrollmentId);

    boolean delete(long enrollmentId);

    int count();

    boolean update(Enrollments enrollment);
}