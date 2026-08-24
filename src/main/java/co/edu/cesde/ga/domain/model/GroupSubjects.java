package co.edu.cesde.ga.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "group_subjects")
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

    public Long getGroupSubjectId() {
        return groupSubjectId;
    }

    public void setGroupSubjectId(Long groupSubjectId) {
        this.groupSubjectId = groupSubjectId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
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