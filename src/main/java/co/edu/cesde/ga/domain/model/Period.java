package co.edu.cesde.ga.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "periods")
public class Period {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "period_id")
    private Long periodId;

    @NotBlank(message = "El nombre del periodo no puede ser nulo ni estar vacío")
    @Column(name = "name", nullable = false)
    private String name;

    @NotBlank(message = "La fecha de inicio no puede ser nula ni estar vacía")
    @Column(name = "start_date", nullable = false)
    private String startDate;

    @NotBlank(message = "La fecha de finalización no puede ser nula ni estar vacía")
    @Column(name = "end_date", nullable = false)
    private String endDate;

    public Period() {
    }

    public Period(Long periodId, String name, String startDate, String endDate) {
        this.periodId = periodId;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getPeriodId() {
        return periodId;
    }

    public void setPeriodId(Long periodId) {
        this.periodId = periodId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Period{" +
                "periodId=" + periodId +
                ", name='" + name + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}