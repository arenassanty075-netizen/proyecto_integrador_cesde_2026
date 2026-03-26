package co.edu.cesde.ga.repository;

import co.edu.cesde.ga.model.Grade;
import java.util.List;

public interface GradesRepository {

    Grade create(Grade grade);

    boolean existsById(long gradeId);

    Grade findById(long gradeId);

    List<Grade> findAll();

    boolean delete(long gradeId);

    int count();

    boolean update(Grade grade);
}
