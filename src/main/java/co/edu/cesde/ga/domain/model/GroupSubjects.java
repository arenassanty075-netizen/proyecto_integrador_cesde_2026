package co.edu.cesde.ga.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "group_subjects")
@Getter
@Setter
@ToString
public class GroupSubjects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_subject_id")
    private Long groupSubjectId;

    @NotNull(message = "El grupo es obligatorio")
    @Column(name = "group_id", nullable = false)
    private Long groupId;

    @NotBlank(message = "La materia es obligatoria")
    @Column(name = "subject_id", nullable = false)
    private String subjectId;

    @NotNull(message = "El profesor es obligatorio")
    @Column(name = "teacher_id", nullable = false)
    private Long teacherId;

    public GroupSubjects() {
    }

    public GroupSubjects(Long groupSubjectId, Long groupId,
                         String subjectId, Long teacherId) {
        this.groupSubjectId = groupSubjectId;
        this.groupId = groupId;
        this.subjectId = subjectId;
        this.teacherId = teacherId;
    }



    @Override
    public String toString() {
        return "GroupSubjects{" +
                "groupSubjectId=" + groupSubjectId +
                ", groupId=" + groupId +
                ", subjectId='" + subjectId + '\'' +
                ", teacherId=" + teacherId +
                '}';
    }
}