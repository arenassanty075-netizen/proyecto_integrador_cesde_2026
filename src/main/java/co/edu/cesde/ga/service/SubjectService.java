package co.edu.cesde.ga.service;

import co.edu.cesde.ga.model.Subject;
import java.util.List;

public interface SubjectService {
    Subject create(Subject subject);
    boolean update(Subject subject);
    boolean delete(String code);
    Subject findByCode(String code);
    boolean existsByCode(String code);
    List<Subject> findAll();
}