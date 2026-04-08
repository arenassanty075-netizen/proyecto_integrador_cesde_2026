package co.edu.cesde.ga.service.impl;

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
        if (isInvalidStudet(student) || studentRepository.existsByDocumentNumber(student.getDocumentNumber())){
            return null;
        }
        return studentRepository.create(student);

    }
    @Override
    public boolean update(Student studentUpdate){
        if (studentRepository.existsByDocumentNumber(studentUpdate.getDocumentNumber())){
            return false;
        }
        if (isInvalidStudet(studentUpdate)|| studentUpdate.getStudentId() == null || studentUpdate.getStudentId()<=0L){
         return false;
        }
        return studentRepository.update(studentUpdate);

    }

    @Override
    public boolean delete(Long studentId){
        if(studentId == null || studentId <= 0l){
            return false;
        }
        return studentRepository.delete(studentId);
    }

    @Override
    public Student findById(Long studenId){
        if(studenId == null || studenId <= 0l){
            return null;
        }
        return studentRepository.findById(studenId);
    }

    @Override
    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    public boolean isInvalidStudet(Student student){

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
