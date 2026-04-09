package co.edu.cesde.ga.service.impl;

import co.edu.cesde.ga.model.Enrollment;
import co.edu.cesde.ga.repository.EnrollmentRepository;
import co.edu.cesde.ga.service.EnrollmentService;
import java.util.List;

public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentServiceImpl(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    @Override
    public Enrollment create(Enrollment enrollment) {
        if (isInvalidEnrollment(enrollment) || enrollmentRepository.existsById(enrollment.getEnrollmentId())) {
            return null;
        }
        return enrollmentRepository.create(enrollment);
    }

    @Override
    public boolean update(Enrollment enrollment) {
        if (isInvalidEnrollment(enrollment) || enrollment.getEnrollmentId() == null || enrollment.getEnrollmentId() <= 0L) {
            return false;
        }
        if (!enrollmentRepository.existsById(enrollment.getEnrollmentId())) {
            return false;
        }
        return enrollmentRepository.update(enrollment);
    }

    @Override
    public boolean delete(Long enrollmentId) {
        if (enrollmentId == null || enrollmentId <= 0L) {
            return false;
        }
        return enrollmentRepository.delete(enrollmentId);
    }

    @Override
    public Enrollment findById(Long enrollmentId) {
        if (enrollmentId == null || enrollmentId <= 0L) {
            return null;
        }
        return enrollmentRepository.findById(enrollmentId);
    }

    @Override
    public List<Enrollment> findAll() {
        return enrollmentRepository.findAll();
    }

    @Override
    public boolean existsById(Long enrollmentId) {
        return enrollmentRepository.existsById(enrollmentId);
    }

    private boolean isInvalidEnrollment(Enrollment enrollment) {
        return enrollment == null
                || enrollment.getEnrollmentId() == null
                || enrollment.getStudentId() == null
                || enrollment.getGroupId() == null
                || enrollment.getPeriodId() == null
                || enrollment.getEnrolledAt() == null
                || !isNotBlank(enrollment.getStatus());
    }

    private boolean isNotBlank(String value) {
        return value != null && !value.trim().isEmpty();
    }
}
