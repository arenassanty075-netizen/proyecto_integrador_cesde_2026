package co.edu.cesde.ga.repository.impl;

import co.edu.cesde.ga.model.Enrollments;
import co.edu.cesde.ga.repository.EnrollmentRepository;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentRepositoryInMemory implements EnrollmentRepository {

    private List<Enrollments> enrollments;
    private long nextEnrollmentId;

    public EnrollmentRepositoryInMemory() {
        this.enrollments = new ArrayList<>();
        this.nextEnrollmentId = 1L;
    }

    @Override
    public Enrollments create(Enrollments enrollment) {
        if (enrollment == null) {
            return null;
        }

        enrollment.setEnrollmentId(nextEnrollmentId++);
        enrollments.add(enrollment);
        return enrollment;
    }

    @Override
    public boolean existsById(long enrollmentId) {
        return findById(enrollmentId) != null;
    }

    @Override
    public Enrollments findById(long enrollmentId) {
        if (enrollmentId <= 0) {
            return null;
        }

        for (Enrollments enrollment : enrollments) {
            if (enrollment.getEnrollmentId() == enrollmentId) {
                return enrollment;
            }
        }
        return null;
    }

    @Override
    public List<Enrollments> findAll() {
        return new ArrayList<>(enrollments);
    }

    @Override
    public boolean delete(long enrollmentId) {
        Enrollments enrollment = findById(enrollmentId);
        if (enrollment == null) return false;

        enrollments.remove(enrollment);
        return true;
    }

    @Override
    public int count() {
        return enrollments.size();
    }

    @Override
    public boolean update(Enrollments updatedEnrollment) {
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