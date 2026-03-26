package co.edu.cesde.ga.repository;

import co.edu.cesde.ga.model.Enrollments;
import java.util.List;

public interface EnrollmentRepository {

<<<<<<< HEAD
    Enrollments update(Enrollments enrollment); // crear o actualizar

    List<Enrollments> findAll(); // listar todos

    Enrollments findById(int enrollmentId); // buscar por id

    List<Enrollments> findByStudentId(int studentId); // buscar por estudiante

    List<Enrollments> findByGroupId(int groupId); // buscar por grupo

    List<Enrollments> findByPeriodId(int periodId); // 🔥 importante según tu tabla

    void delete(int enrollmentId); // eliminar
=======
    Enrollments create(Enrollments enrollment);

    List<Enrollments> findAll();

    Enrollments findById(long enrollmentId);

    boolean delete(long enrollmentId);

    int count();

    boolean update(Enrollments enrollment);
>>>>>>> 4fe2b9a5301e9cd6682c1fabce1d2db4bebdc293
}