package co.edu.cesde.ga.service.impl;

import co.edu.cesde.ga.exceptions.DuplicateException;
import co.edu.cesde.ga.exceptions.InvalidDataException;
import co.edu.cesde.ga.exceptions.NotFoundException;
import co.edu.cesde.ga.model.Period;
import co.edu.cesde.ga.repository.PeriodRepository;
import co.edu.cesde.ga.service.PeriodService;

import java.util.List;

public class PeriodServiceImpl implements PeriodService {

    private final PeriodRepository periodRepository;

    public PeriodServiceImpl(PeriodRepository periodRepository) {
        this.periodRepository = periodRepository;
    }

    @Override
    public Period create(Period period) {

        if (period == null) {
            throw new InvalidDataException("El periodo no puede ser nulo");
        }

        if (isInvalidPeriod(period)) {
            throw new InvalidDataException("Datos inválidos");
        }

        if (periodRepository.existsById(period.getPeriodId())) {
            throw new DuplicateException("Ya existe un periodo con ese ID");
        }

        return periodRepository.create(period);
    }

    @Override
    public boolean update(Period period) {

        if (period == null || period.getPeriodId() == null || period.getPeriodId() <= 0L) {
            throw new InvalidDataException("ID inválido");
        }

        if (!periodRepository.existsById(period.getPeriodId())) {
            throw new NotFoundException("Periodo no encontrado");
        }

        if (isInvalidPeriod(period)) {
            throw new InvalidDataException("Datos inválidos");
        }

        return periodRepository.update(period);
    }


    @Override
    public boolean delete(Long periodId) {

        if (periodId == null || periodId <= 0L) {
            throw new InvalidDataException("ID inválido");
        }

        if (!periodRepository.existsById(periodId)) {
            throw new NotFoundException("Periodo no encontrado");
        }

        return periodRepository.delete(periodId);
    }

    @Override
    public Period findById(Long periodId) {

        if (periodId == null || periodId <= 0L) {
            throw new InvalidDataException("ID inválido");
        }

        Period period = periodRepository.findById(periodId);

        if (period == null) {
            throw new NotFoundException("Periodo no encontrado");
        }

        return period;
    }

    @Override
    public List<Period> findAll() {
        return periodRepository.findAll();
    }

    @Override
    public boolean existsById(Long periodId) {

        if (periodId == null || periodId <= 0L) {
            throw new InvalidDataException("ID inválido");
        }

        return periodRepository.existsById(periodId);
    }

    private boolean isInvalidPeriod(Period period) {
        return period == null
                || period.getPeriodId() == null
                || period.getPeriodId() <= 0L
                || !isNotBlank(period.getName())
                || !isNotBlank(period.getStartDate())
                || !isNotBlank(period.getEndDate());
    }

    private boolean isNotBlank(String value) {
        return value != null && !value.trim().isEmpty();
    }
}