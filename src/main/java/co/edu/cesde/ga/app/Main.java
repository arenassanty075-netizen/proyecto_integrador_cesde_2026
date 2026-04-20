package co.edu.cesde.ga.app;

import co.edu.cesde.ga.model.Person;
import co.edu.cesde.ga.model.Student;
import co.edu.cesde.ga.model.Teacher;
import co.edu.cesde.ga.repository.StudentRepository;
import co.edu.cesde.ga.repository.impl.StudentRepositoryInMemory;
import co.edu.cesde.ga.service.StudentService;
import co.edu.cesde.ga.service.impl.StudentServiceImpl;


public class Main {

    public static void main(String[] args) {
        StudentRepository studentRepository = new StudentRepositoryInMemory();
        StudentService studentService = new StudentServiceImpl(studentRepository);

        Student student = new Student(null, "01","1036401402", "Santiago", "Arenas", "Activo", "05/06/1996" );
        Student createdStudent = studentService.create(student);
        System.out.println("Estudiante creado: ");
        System.out.println(createdStudent);
    }

}




