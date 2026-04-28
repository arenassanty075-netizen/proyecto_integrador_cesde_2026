package co.edu.cesde.ga.app;

import co.edu.cesde.ga.model.*;
import co.edu.cesde.ga.repository.impl.*;
import co.edu.cesde.ga.service.impl.*;
import java.time.LocalDateTime;


public class Main {

    public static void main(String[] args) {

        // 🔹 PROGRAM
        ProgramsRepositoryInMemory programsRepository = new ProgramsRepositoryInMemory();
        ProgramServiceImpl programService = new ProgramServiceImpl(programsRepository);

        Programs program = new Programs(1L, "PRG01", "Ingeniería de Sistemas");
        programService.create(program);
        System.out.println("=== PROGRAMAS ===");
        System.out.println(programService.findAll());

        // 🔹 SUBJECT
        SubjectsRepositoryInMemory subjectsRepository = new SubjectsRepositoryInMemory();
        SubjectServiceImpl subjectService = new SubjectServiceImpl(subjectsRepository);

        Subject subject = new Subject(1L, "MAT01", "Matemáticas", 3, 1L);
        subjectService.create(subject);
        System.out.println("=== MATERIAS ===");
        System.out.println(subjectService.findAll());

        // 🔹 ROLE
        RoleRepositoryInMemory roleRepository = new RoleRepositoryInMemory();
        RoleServiceImpl roleService = new RoleServiceImpl(roleRepository);

        Role role = new Role(1L, "ADMIN", "Administrador del sistema");
        roleService.create(role);
        System.out.println("=== ROLES ===");
        System.out.println(roleService.findAll());

        // 🔹 USER
        UserRepositoryInMemory userRepository = new UserRepositoryInMemory();
        UserServiceImpl userService = new UserServiceImpl(userRepository);

        User user = new User(1, "sebas14737", "sebas@gmail.com", "pass123", "Activo", "2026-01-01");        userService.create(user);
        System.out.println("=== USUARIOS ===");
        System.out.println(userService.findAll());

        // 🔹 USER ROLE
        UserRoleRepositoryInMemory userRoleRepository = new UserRoleRepositoryInMemory();
        UserRoleServiceImpl userRoleService = new UserRoleServiceImpl(userRoleRepository);

        UserRole userRole = new UserRole(1, 1);
        userRoleService.create(userRole);
        System.out.println("=== USER ROLES ===");
        System.out.println(userRoleService.findAll());

        // 🔹 PERIOD
        PeriodRepositoryInMemory periodRepository = new PeriodRepositoryInMemory();

        Period period = new Period(1L, "2026-1", "2026-01-01", "2026-06-30");
        periodRepository.create(period);
        System.out.println("=== PERIODOS ===");
        System.out.println(periodRepository.findAll());

        // 🔹 STUDENT
        StudentRepositoryInMemory studentRepository = new StudentRepositoryInMemory();
        StudentServiceImpl studentService = new StudentServiceImpl(studentRepository);

        Student student = new Student(null, "01", "1036401402", "Santiago", "Arenas", "Activo", "05/06/1996");
        Student createdStudent = studentService.create(student);
        System.out.println("=== ESTUDIANTES ===");
        System.out.println(createdStudent);

        // 🔹 TEACHER
        TeacherRepositoryInMemory teacherRepository = new TeacherRepositoryInMemory();
        TeacherServiceImpl teacherService = new TeacherServiceImpl(teacherRepository);

        Teacher teacher = new Teacher(1L, "TCH01", "123456789", "Carlos", "Pérez", "Activo");
        teacherService.create(teacher);
        System.out.println("=== PROFESORES ===");
        System.out.println(teacherService.findAll());

        // 🔹 GROUP
        GroupRepositoryInMemory groupRepository = new GroupRepositoryInMemory();
        GroupServiceImpl groupService = new GroupServiceImpl(groupRepository);

        Groups group = new Groups(null, "A1", 1L, 1L, "Mañana");
        groupService.create(group);
        System.out.println("=== GRUPOS ===");
        System.out.println(groupService.findAll());

        // 🔹 GROUP SUBJECT
        GroupSubjectsRepositoryInMemory groupSubjectsRepository = new GroupSubjectsRepositoryInMemory();
        GroupSubjectServiceImpl groupSubjectService = new GroupSubjectServiceImpl(groupSubjectsRepository);

        GroupSubjects groupSubject = new GroupSubjects(1L, 1L, "MAT01", 1L);
        groupSubjectService.create(groupSubject);
        System.out.println("=== GROUP SUBJECTS ===");
        System.out.println(groupSubjectService.findAll());

        // 🔹 ENROLLMENT
        EnrollmentRepositoryInMemory enrollmentRepository = new EnrollmentRepositoryInMemory();
        EnrollmentServiceImpl enrollmentService = new EnrollmentServiceImpl(enrollmentRepository);

        Enrollment enrollment = new Enrollment(null, 1L, 1L, 1L, "Activo", LocalDateTime.now());
        enrollmentService.create(enrollment);
        System.out.println("=== MATRÍCULAS ===");
        System.out.println(enrollmentService.findAll());

        // 🔹 GRADE
        GradesRepositoryInMemory gradesRepository = new GradesRepositoryInMemory();
        GradesServiceImpl gradesService = new GradesServiceImpl(gradesRepository);

        Grade grade = new Grade(1L, 1L, 1L, 45, "Buen desempeño");
        gradesService.create(grade);
        System.out.println("=== NOTAS ===");
        System.out.println(gradesService.findAll());
    }
}