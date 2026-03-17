package repository;

import co.edu.cesde.ga.model.Student;
import java.util.List;

public interface studentRepository {

    // Crear o actualizar estudiante
    Student update(Student student);

    // Leer todos los estudiantes
    List<Student> findAll();

    // Buscar por id
    Student findById(int id);

    // Buscar por nombre
    Student findByName(String name);

    // Eliminar por id
    void deleteById(int id);
}