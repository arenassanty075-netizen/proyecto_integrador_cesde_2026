package co.edu.cesde.ga.service;

import co.edu.cesde.ga.model.Period;
import java.util.List;

public interface PeriodService {
    Period create(Period period);

    List<Period> findAll();

    Period findById(Long periodId);

    boolean update(Period period);

    boolean delete(Long periodId);

    boolean existsById(Long periodId);
}
