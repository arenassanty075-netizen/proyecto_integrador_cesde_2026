package repository;

import co.edu.cesde.ga.model.Enrollments;
import java.util.List;

public interface EnrollmentRepository {

    Enrollments update(Enrollments enrollment); // crear o actualizar

    List<Enrollments> findAll(); // listar todos

    Enrollments findById(int enrollmentId); // buscar por id

    List<Enrollments> findByStudentId(int studentId); // buscar por estudiante

    List<Enrollments> findByGroupId(int groupId); // buscar por grupo

    List<Enrollments> findByPeriodId(int periodId); // 🔥 importante según tu tabla

    void delete(int enrollmentId); // eliminar
}