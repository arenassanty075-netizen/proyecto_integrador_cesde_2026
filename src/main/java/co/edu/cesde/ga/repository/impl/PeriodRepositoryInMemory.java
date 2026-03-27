package co.edu.cesde.ga.repository.impl;

import co.edu.cesde.ga.model.Period;
import co.edu.cesde.ga.repository.PeriodRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PeriodRepositoryInMemory implements PeriodRepository {

    // Lista sincronizada para seguridad en hilos (opcional)
    private final List<Period> periods = Collections.synchronizedList(new ArrayList<>());

    @Override
    public Period create(Period period) {
        // Evitamos IDs duplicados
        if (findById(period.getPeriodId()) == null) {
            periods.add(period);
            return period;
        }
        return null; // ya existe
    }

    @Override
    public List<Period> findAll() {
        return new ArrayList<>(periods); // devolvemos copia
    }

    @Override
    public Period findById(long periodId) {
        for (Period p : periods) {
            if (p.getPeriodId() == periodId) {
                return p;
            }
        }
        return null; // no encontrado
    }

    @Override
    public boolean delete(long periodId) {
        return periods.removeIf(p -> p.getPeriodId() == periodId);
    }

    @Override
    public int count() {
        return periods.size();
    }

    @Override
    public boolean update(Period period) {
        for (int i = 0; i < periods.size(); i++) {
            if (periods.get(i).getPeriodId() == period.getPeriodId()) {
                periods.set(i, period);
                return true;
            }
        }
        return false; // no encontrado
    }
}