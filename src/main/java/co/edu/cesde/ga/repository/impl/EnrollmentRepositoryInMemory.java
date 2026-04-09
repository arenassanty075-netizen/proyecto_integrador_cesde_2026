package co.edu.cesde.ga.repository.impl;

import co.edu.cesde.ga.model.Enrollment;
import co.edu.cesde.ga.repository.EnrollmentRepository;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentRepositoryInMemory implements EnrollmentRepository {

    private List<Enrollment> enrollments;
    private Long nextEnrollmentId;

    public EnrollmentRepositoryInMemory() {
        this.enrollments = new ArrayList<>();
        this.nextEnrollmentId = 1L;
    }

    @Override
    public Enrollment create(Enrollment enrollment) {
        if (enrollment == null) {
            return null;
        }

        enrollment.setEnrollmentId(nextEnrollmentId++);
        enrollments.add(enrollment);
        return enrollment;
    }

    @Override
    public boolean existsById(Long enrollmentId) {
        return findById(enrollmentId) != null;
    }

    @Override
    public Enrollment findById(Long enrollmentId) {
        if (enrollmentId <= 0) {
            return null;
        }

        for (Enrollment enrollment : enrollments) {
            if (enrollment.getEnrollmentId() == enrollmentId) {
                return enrollment;
            }
        }
        return null;
    }

    @Override
    public List<Enrollment> findAll() {
        return new ArrayList<>(enrollments);
    }

    @Override
    public boolean delete(Long enrollmentId) {
        Enrollment enrollment = findById(enrollmentId);
        if (enrollment == null) return false;

        enrollments.remove(enrollment);
        return true;
    }

    @Override
    public int count() {
        return enrollments.size();
    }

    @Override
    public boolean update(Enrollment updatedEnrollment) {
        if (updatedEnrollment == null) return false;

        for (int i = 0; i < enrollments.size(); i++) {
            if (updatedEnrollment.getEnrollmentId() == enrollments.get(i).getEnrollmentId()) {
                enrollments.set(i, updatedEnrollment);
                return true;
            }
        }
        return false;
    }
}