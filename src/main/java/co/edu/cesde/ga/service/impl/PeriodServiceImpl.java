package co.edu.cesde.ga.service.impl;

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
        if (isInvalidPeriod(period) || periodRepository.existsById(period.getPeriodId())) {
            return null;
        }
        return periodRepository.create(period);
    }

    @Override
    public boolean update(Period period) {
        if (isInvalidPeriod(period) || period.getPeriodId() == null || period.getPeriodId() <= 0L) {
            return false;
        }
        if (!periodRepository.existsById(period.getPeriodId())) {
            return false;
        }
        return periodRepository.update(period);
    }

    @Override
    public boolean delete(Long periodId) {
        if (periodId == null || periodId <= 0L) {
            return false;
        }
        return periodRepository.delete(periodId);
    }

    @Override
    public Period findById(Long periodId) {
        if (periodId == null || periodId <= 0L) {
            return null;
        }
        return periodRepository.findById(periodId);
    }

    @Override
    public List<Period> findAll() {
        return periodRepository.findAll();
    }

    @Override
    public boolean existsById(Long periodId) {
        return periodRepository.existsById(periodId);
    }

    private boolean isInvalidPeriod(Period period) {
        return period == null
                || period.getPeriodId() == null
                || !isNotBlank(period.getName())
                || !isNotBlank(period.getStartDate())
                || !isNotBlank(period.getEndDate());
    }

    private boolean isNotBlank(String value) {
        return value != null && !value.trim().isEmpty();
    }
}