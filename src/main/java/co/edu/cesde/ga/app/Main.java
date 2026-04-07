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

        StudentRepositoryInMemory studentRepository = new StudentRepositoryInMemory() ;
        StudentService studentService = new StudentServiceImpl(studentRepository);


        Student student = new Student(null, null, "123456789", "Juan", "Ramirez", "Activo", "12-05-2000");
        studentService.create(student);
        System.out.println("Estudiante creado con exito");

        Student student1= new Student(null, null, "32146987", "Carlos", "Perez", "Activo", "02-01-2000");
        studentService.create(student1);
        System.out.println("Estudiante creado");

    studentService.findAll().forEach(System.out::println);


    }
}




