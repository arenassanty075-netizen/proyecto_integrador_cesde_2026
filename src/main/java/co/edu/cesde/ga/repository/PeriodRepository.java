package co.edu.cesde.ga.repository;

import co.edu.cesde.ga.model.Period;
import java.util.List;

public interface PeriodRepository {

    Period create(Period period);

    List<Period> findAll();

    Period findById(long periodId);

    boolean delete(long periodId);

    int count();

    boolean update(Period period);
}