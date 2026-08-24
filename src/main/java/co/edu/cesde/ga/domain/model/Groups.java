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
@Table(name = "groups")
public class Groups {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Long groupId;

    @NotBlank(message = "El código del grupo no puede ser nulo ni estar vacío")
    @Column(name = "code", nullable = false)
    private String code;

    @NotNull(message = "El programa es obligatorio")
    @Column(name = "program_id", nullable = false)
    private Long programId;

    @NotNull(message = "El período es obligatorio")
    @Column(name = "period_id", nullable = false)
    private Long periodId;

    @NotBlank(message = "La jornada no puede ser nula ni estar vacía")
    @Column(name = "shift", nullable = false)
    private String shift;

    public Groups() {
    }

    public Groups(Long groupId, String code, Long programId, Long periodId, String shift) {
        this.groupId = groupId;
        this.code = code;
        this.programId = programId;
        this.periodId = periodId;
        this.shift = shift;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getProgramId() {
        return programId;
    }

    public void setProgramId(Long programId) {
        this.programId = programId;
    }

    public Long getPeriodId() {
        return periodId;
    }

    public void setPeriodId(Long periodId) {
        this.periodId = periodId;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    @Override
    public String toString() {
        return "Groups{" +
                "groupId=" + groupId +
                ", code='" + code + '\'' +
                ", programId=" + programId +
                ", periodId=" + periodId +
                ", shift='" + shift + '\'' +
                '}';
    }
}