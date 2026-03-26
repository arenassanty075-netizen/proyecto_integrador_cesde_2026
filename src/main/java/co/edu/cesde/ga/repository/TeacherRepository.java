package co.edu.cesde.ga.repository;

import co.edu.cesde.ga.model.Teacher;
import java.util.List;

public interface TeacherRepository {

    // Crear profesor
    Teacher create(Teacher teacher);

    // Actualizar profesor
    Teacher update(Teacher teacher);

    // Listar todos los profesores
    List<Teacher> findAll();

    // Buscar por id
    Teacher findById(int id);

    // Buscar por nombre
    Teacher findByName(String name);

    // Validar si existe por id
    boolean existsById(int id);

    // Eliminar por id
    boolean delete(int id);

    // Contar registros
    int count();
}