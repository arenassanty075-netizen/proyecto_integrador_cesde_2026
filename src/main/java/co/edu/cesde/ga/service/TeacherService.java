package co.edu.cesde.ga.service;

import co.edu.cesde.ga.model.Teacher;
import java.util.List;

public interface TeacherService {
    Teacher create(Teacher teacher);
    Teacher update(Teacher teacher);
    boolean delete(Long id);
    Teacher findById(Long id);
    Teacher findByName(String name);
    boolean existsById(Long id);
    List<Teacher> findAll();
}