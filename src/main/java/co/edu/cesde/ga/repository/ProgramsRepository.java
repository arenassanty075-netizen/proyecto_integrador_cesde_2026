package co.edu.cesde.ga.repository;

import co.edu.cesde.ga.model.Programs;

import java.util.List;


public interface ProgramsRepository {

    Programs create(Programs program);

    List<Programs> findAll();

    Programs findById(Long programId);

    Programs findByCode(String code);

    boolean update(Programs program);

    boolean delete(Long programId);

    boolean existsByCode(String code);

    int count();
}