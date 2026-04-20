package co.edu.cesde.ga.app;

import co.edu.cesde.ga.model.Student;
import co.edu.cesde.ga.repository.StudentRepository;
import co.edu.cesde.ga.repository.impl.StudentRepositoryInMemory;
import co.edu.cesde.ga.service.StudentService;
import co.edu.cesde.ga.service.impl.StudentServiceImpl;

import co.edu.cesde.ga.model.Groups;
import co.edu.cesde.ga.repository.GroupRepository;
import co.edu.cesde.ga.repository.impl.GroupRepositoryInMemory;
import co.edu.cesde.ga.service.GroupsService;
import co.edu.cesde.ga.service.impl.GroupServiceImpl;

public class Main {

    public static void main(String[] args) {

        // 🔹 STUDENT
        StudentRepository studentRepository = new StudentRepositoryInMemory();
        StudentService studentService = new StudentServiceImpl(studentRepository);

        Student student = new Student(null, "01","1036401402", "Santiago", "Arenas", "Activo", "05/06/1996");
        Student createdStudent = studentService.create(student);

        System.out.println("Estudiante creado:");
        System.out.println(createdStudent);

        // 🔹 GROUP
        GroupRepository repo = new GroupRepositoryInMemory();
        GroupsService service = new GroupServiceImpl(repo);

        Groups g = new Groups(null, "A1", 1L, 1L, "Mañana");
        service.create(g);

        System.out.println("Grupos:");
        System.out.println(service.findAll());
    }
}