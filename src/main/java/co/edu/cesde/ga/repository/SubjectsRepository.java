package co.edu.cesde.ga.repository;

import co.edu.cesde.ga.model.Subject;
import java.util.List;

public interface SubjectsRepository {

    Subject create(Subject subject);

    boolean existsByCode(String code);

    Subject findByCode(String code);

    List<Subject> findAll();

    boolean delete(String code);

    int count();

    boolean update(Subject subject);
}
