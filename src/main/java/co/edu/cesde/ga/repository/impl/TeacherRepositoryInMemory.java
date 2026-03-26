package co.edu.cesde.ga.repository.impl;

import co.edu.cesde.ga.model.Teacher;
import co.edu.cesde.ga.repository.TeacherRepository;

import java.util.ArrayList;
import java.util.List;

public class TeacherRepositoryInMemory implements TeacherRepository {

    private final List<Teacher> teachers = new ArrayList<>();
    private int nextId = 1; // Para asignar IDs automáticamente

    @Override
    public Teacher create(Teacher teacher) {
        teacher.setId(nextId++);
        teachers.add(teacher);
        return teacher;
    }

    @Override
    public Teacher update(Teacher teacher) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == teacher.getId()) {
                teachers.set(i, teacher);
                return teacher;
            }
        }
        return null; // Si no se encuentra el ID
    }

    @Override
    public List<Teacher> findAll() {
        return new ArrayList<>(teachers); // Devolver copia para no modificar la lista original
    }

    @Override
    public Teacher findById(int id) {
        for (Teacher t : teachers) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    @Override
    public Teacher findByName(String name) {
        for (Teacher t : teachers) {
            if (t.getFirstName().equalsIgnoreCase(name) || t.getLastName().equalsIgnoreCase(name)) {
                return t;
            }
        }
        return null;
    }

    @Override
    public boolean existsById(int id) {
        return findById(id) != null;
    }

    @Override
    public boolean delete(int id) {
        return teachers.removeIf(t -> t.getId() == id);
    }

    @Override
    public int count() {
        return teachers.size();
    }
}