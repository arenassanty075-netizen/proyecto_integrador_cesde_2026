package co.edu.cesde.ga.service.impl;

import co.edu.cesde.ga.exceptions.DuplicateException;
import co.edu.cesde.ga.exceptions.InvalidDataException;
import co.edu.cesde.ga.exceptions.NotFoundException;
import co.edu.cesde.ga.model.Student;
import co.edu.cesde.ga.service.StudentService;
import co.edu.cesde.ga.repository.StudentRepository;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student create(Student student){

        if (student == null) {
            throw new InvalidDataException("El estudiante no puede ser nulo");
        }

        if (student.getFirstName() == null || student.getFirstName().trim().isEmpty()) {
            throw new InvalidDataException("El nombre es obligatorio");
        }

        if (student.getDocumentNumber() == null || student.getDocumentNumber().trim().isEmpty()) {
            throw new InvalidDataException("El documento es obligatorio");
        }

        if (studentRepository.existsByDocumentNumber(student.getDocumentNumber())) {
            throw new DuplicateException("Ya existe un estudiante con ese documento");
        }

        return studentRepository.create(student);
    }

    @Override
    public boolean update(Student studentUpdate){

        if (studentUpdate == null || studentUpdate.getStudentId() == null || studentUpdate.getStudentId() <= 0L) {
            throw new InvalidDataException("ID inválido");
        }

        Student existing = studentRepository.findById(studentUpdate.getStudentId());

        if (existing == null) {
            throw new NotFoundException("Estudiante no encontrado con ID: " + studentUpdate.getStudentId());
        }

        if (studentUpdate.getFirstName() == null || studentUpdate.getFirstName().trim().isEmpty()) {
            throw new InvalidDataException("Nombre obligatorio");
        }

        if (studentUpdate.getDocumentNumber() == null || studentUpdate.getDocumentNumber().trim().isEmpty()) {
            throw new InvalidDataException("Documento obligatorio");
        }

        Student duplicate = studentRepository.findByDocumentNumber(studentUpdate.getDocumentNumber());

        if (duplicate != null && !duplicate.getStudentId().equals(studentUpdate.getStudentId())) {
            throw new DuplicateException("Documento ya pertenece a otro estudiante");
        }

        return studentRepository.update(studentUpdate);
    }

    @Override
    public boolean delete(Long studentId){

        if (studentId == null || studentId <= 0L) {
            throw new InvalidDataException("ID inválido");
        }

        Student student = studentRepository.findById(studentId);

        if (student == null) {
            throw new NotFoundException("Estudiante no encontrado con el ID: " + studentId);
        }

        return studentRepository.delete(studentId);
    }
    @Override
    public Student findById(Long studentId){

        if (studentId == null || studentId <= 0L) {
            throw new InvalidDataException("ID inválido");
        }

        Student student = studentRepository.findById(studentId);

        if (student == null) {
            throw new NotFoundException("Estudiante no encontrado con el ID: " + studentId);
        }

        return student;
    }

    @Override
    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    public boolean isInvalidStudent(Student student){

        return student == null
               || !isNotBlank(student.getDocumentNumber())
               || !isNotBlank(student.getFirstName())
               || !isNotBlank(student.getLastName())
               || !isNotBlank(student.getBirthDate())
                || student.getStatus() == null;


    }

    private boolean isNotBlank(String value) {
        return value != null && !value.trim().isEmpty();
    }

}
