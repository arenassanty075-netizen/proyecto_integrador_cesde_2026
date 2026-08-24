package co.edu.cesde.ga.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "grades")
@Getter
@Setter
@ToString
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grade_id")
    private Long gradeId;

    @NotNull(message = "El grupo de materia es obligatorio")
    @Column(name = "group_subject_id", nullable = false)
    private Long groupSubjectId;

    @NotNull(message = "El estudiante es obligatorio")
    @Column(name = "student_id", nullable = false)
    private Long studentId;

    @Min(value = 0, message = "La nota mínima es 0")
    @Max(value = 5, message = "La nota máxima es 5")
    @Column(name = "final_score", nullable = false)
    private int finalScore;

    @NotBlank(message = "La observación no puede ser nula ni estar vacía")
    @Column(name = "observation", nullable = false)
    private String observation;

    public Grade() {
    }

    public Grade(Long gradeId, Long groupSubjectId, Long studentId,
                 int finalScore, String observation) {
        this.gradeId = gradeId;
        this.groupSubjectId = groupSubjectId;
        this.studentId = studentId;
        this.finalScore = finalScore;
        this.observation = observation;
    }



    @Override
    public String toString() {
        return "Grade{" +
                "gradeId=" + gradeId +
                ", groupSubjectId=" + groupSubjectId +
                ", studentId=" + studentId +
                ", finalScore=" + finalScore +
                ", observation='" + observation + '\'' +
                '}';
    }
}