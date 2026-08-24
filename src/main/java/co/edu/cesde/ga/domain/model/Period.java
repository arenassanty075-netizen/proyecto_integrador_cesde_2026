package co.edu.cesde.ga.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "periods")
@Getter
@Setter
@ToString

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