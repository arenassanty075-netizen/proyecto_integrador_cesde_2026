package co.edu.cesde.ga.app;

import co.edu.cesde.ga.model.Person;
import co.edu.cesde.ga.model.Student;
import co.edu.cesde.ga.model.Teacher;


public class Main {

    public static void main(String[] args) {
        Person person = new Person();

        person.setUserId(1L);
        person.setCode("123456");
        person.setDocumentNumber("1036401402");
        person.setFirsName("Santiago");
        person.setLastName("Arenas");
        person.setStatus("Active");

        System.out.println("User Id: " + person.getUserId());
        System.out.println("User Code: " + person.getCode());
        System.out.println("User Document Number: " + person.getDocumentNumber());
        System.out.println("First Name: " + person.getFirsName());
        System.out.println("Last Name: " + person.getLastName());
        System.out.println("Status: " + person.getStatus());

        Student student = new Student();
        student.setUserId(1L);
        student.setCode("123456");
        student.setDocumentNumber("1036401402");
        student.setFirsName("Santiago");
        student.setLastName("Arenas");
        student.setStatus("Active");
        student.setBrithDate("05/06/1996");

        System.out.println("Student Id: " + student.getUserId());
        System.out.println("Student Code: " + student.getCode());
        System.out.println("Student Document Number: " + student.getDocumentNumber());
        System.out.println("First Name: " + student.getFirsName());
        System.out.println("Last Name: " + student.getLastName());
        System.out.println("Status: " + student.getStatus());
        System.out.println("Brith Date: " + student.getBrithDate());


        Teacher teacher = new Teacher();
        teacher.setUserId(1L);
        teacher.setCode("123456");
        teacher.setDocumentNumber("20202501");
        teacher.setFirsName("Pedro");
        teacher.setLastName("Ramirez");
        teacher.setStatus("Active");

        System.out.println("Teacher Id: " + teacher.getUserId());
        System.out.println("Teacher Code: " + teacher.getCode());
        System.out.println("Teacher Document Number: " + teacher.getDocumentNumber());
        System.out.println("First Name: " + teacher.getFirsName());
        System.out.println("Last Name: " + teacher.getLastName());
        System.out.println("Status: " + teacher.getStatus());

        Student student2 = new Student(2L,"23456","15423969" , "Banesa" , "Quintero" ,"Active", "24/02/1996");
        //USERS & ROLES

        co.edu.cesde.ga.model.User user = new co.edu.cesde.ga.model.User(1, "miguel", "miguel@mail.com", "123", "activo", "2026");
        co.edu.cesde.ga.model.Role role = new co.edu.cesde.ga.model.Role(1, "admin", "Administrador");

        co.edu.cesde.ga.model.UserRole userRole = new co.edu.cesde.ga.model.UserRole(user.getUserId(), role.getRoleId());

        System.out.println("\n=== USERS & ROLES ===");
        System.out.println("Usuario: " + user.getUsername());
        System.out.println("Rol: " + role.getName());
        System.out.println("Relación: " + userRole.getUserId() + " - " + userRole.getRoleId());



    }
}
