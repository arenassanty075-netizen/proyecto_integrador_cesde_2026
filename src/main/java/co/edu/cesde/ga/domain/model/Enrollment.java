package co.edu.cesde.ga.domain.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "enrollments")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enrollment_id_pk")
    private Long enrollmentId;

    @Column(name = "student_id", nullable = false)
    private Long studentId;

    @Column(name = "group_id", nullable = false)
    private Long groupId;

    @Column(name = "period_id", nullable = false)
    private Long periodId;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "enrollment_created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "enrollment_updated_at")
    private LocalDateTime updatedAt;

    public Enrollment() {
    }

    public Enrollment(Long enrollmentId, Long studentId, Long groupId,
                      Long periodId, String status) {
        this.enrollmentId = enrollmentId;
        this.studentId = studentId;
        this.groupId = groupId;
        this.periodId = periodId;
        this.status = status;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Long getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(Long enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getPeriodId() {
        return periodId;
    }

    public void setPeriodId(Long periodId) {
        this.periodId = periodId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        createdAt = now;
        updatedAt = now;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "=== ENROLLMENT INFO ===\n" +
                "ID: " + enrollmentId + "\n" +
                "Student ID: " + studentId + "\n" +
                "Group ID: " + groupId + "\n" +
                "Period ID: " + periodId + "\n" +
                "Estado: " + status;
    }
}