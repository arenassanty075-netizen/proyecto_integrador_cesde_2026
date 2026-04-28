package co.edu.cesde.ga.service;

import co.edu.cesde.ga.model.Programs;
import java.util.List;

public interface ProgramService {
    Programs create(Programs program);
    boolean update(Programs program);
    boolean delete(Long programId);
    Programs findById(Long programId);
    Programs findByCode(String code);
    boolean existsByCode(String code);
    List<Programs> findAll();
}