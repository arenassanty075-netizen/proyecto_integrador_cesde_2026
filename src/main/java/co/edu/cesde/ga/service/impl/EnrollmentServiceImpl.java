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
    public boolean existsById(Long enrollmentId) {
        return enrollmentRepository.existsById(enrollmentId);
    }

    @Override
    public List<Enrollment> findAll() {
        return enrollmentRepository.findAll();

    }

    @Override
    public Enrollment findById(Long enrollmentId) {
        if (enrollmentId == null || enrollmentId <= 0L){
            return null;
        }
        return enrollmentRepository.findById(enrollmentId);
    }

    @Override
    public Enrollment create(Enrollment enrollment) {
        if (!isValidEnrollment(enrollment) || enrollmentRepository.existsById(enrollment.getEnrollmentId())) {
            return null;
        }
        return enrollmentRepository.create(enrollment);
    }

    @Override
    public boolean update(Enrollment enrollment) {
        if (!enrollmentRepository.existsById(enrollment.getEnrollmentId())) {
            return false;
        }
        return enrollmentRepository.update(enrollment);

    }

    @Override
    public boolean delete(Long enrollmentId) {
        if (enrollmentId == null || enrollmentId <= 0L){
            return false;
        }
        return enrollmentRepository.delete(enrollmentId);

    }

    private boolean isValidEnrollment(Enrollment enrollment) {
        return enrollment != null
                || enrollment.getEnrollmentId() != null
                || enrollment.getStudentId() != null
                || enrollment.getGroupId() != null
                || enrollment.getPeriodId() != null
                || enrollment.getEnrolledAt() != null
                || enrollment.getStatus() != null
                || !enrollment.getStatus().trim().isEmpty();
    }

    private boolean isNotBlank(String value){return value != null && value.trim().isEmpty();}




}
