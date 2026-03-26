package co.edu.cesde.ga.repository;


import co.edu.cesde.ga.model.Enrollments;

import java.util.List;

public interface EnrollmentRepository {

    Enrollments create(Enrollments enrollment);

    boolean existsById(long enrollmentId);

    Enrollments findById(long enrollmentId);

    List<Enrollments> findAll();

    boolean delete(long enrollmentId);

    int count();

    boolean update(Enrollments enrollment);
}