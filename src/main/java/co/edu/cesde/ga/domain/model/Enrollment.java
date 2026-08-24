package co.edu.cesde.ga.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "enrollments")
@Getter
@Setter
@ToString
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