package co.edu.cesde.ga.application.port.out;

import co.edu.cesde.ga.domain.model.Subject;
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
