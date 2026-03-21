package repository;

import co.edu.cesde.ga.model.Period;
import java.util.List;

public interface periodRepository {

    Period update(Period period); // crear o actualizar

    List<Period> findAll(); // listar todos

    Period findById(int periodId); // buscar por id

    void delete(int periodId); // eliminar
}
