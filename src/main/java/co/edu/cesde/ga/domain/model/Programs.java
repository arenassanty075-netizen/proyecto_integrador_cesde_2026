package co.edu.cesde.ga.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "programs")
@Getter
@Setter
@ToString

public class Programs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long programId;

    @NotBlank
    private String code;

    @NotBlank
    private String name;

    public Programs() {
    }

    public Programs(Long programId, String code, String name) {
        this.programId = programId;
        this.code = code;
        this.name = name;
    }



    @Override
    public String toString() {
        return "Program { programId=" + programId +
                ", code=" + code +
                ", name=" + name + " }";
    }
}