package co.edu.cesde.ga.repository;
import co.edu.cesde.ga.model.Teacher;
import java.util.List;
public interface TeacherRepository {





    // Crear o actualizar profesor
    Teacher update(Teacher teacher);

    // Listar todos los profesores
    List<Teacher> findAll();

    // Buscar por id
    Teacher findById(int id);

    // Buscar por nombre
    Teacher findByName(String name);

    // Eliminar por id
    boolean delete(int id);
}