package co.edu.cesde.ga.model;

import java.time.LocalDateTime;

public class Enrollments {
    private long enrollmentId;
    private long studentId;
    private long groupId;
    private long periodId;
    private String status;
    private LocalDateTime enrolledAt;

    public  Enrollments() {}

    public Enrollments(Long enrollmentId, Long studentId, Long groupId, Long periodId, String status, LocalDateTime enrolledAt) {
        this.enrollmentId = enrollmentId;
        this.studentId = studentId;
        this.groupId = groupId;
        this.periodId = periodId;
        this.status = status;
        this.enrolledAt = enrolledAt;

    }

    public long getEnrollmentId() {
        return enrollmentId;
    }

    public long getStudentId() {
        return studentId;
    }

    public long getGroupId() {
        return groupId;
    }

    public long getPeriodId() {
        return periodId;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getEnrolledAt() {
        return enrolledAt;
    }

    public void setEnrollmentId(long enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public void setPeriodId(long periodId) {
        this.periodId = periodId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setEnrolledAt(LocalDateTime enrolledAt) {
        this.enrolledAt = enrolledAt;
    }
}
