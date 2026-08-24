package co.edu.cesde.ga.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long studentId;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(name = "document_number", nullable = false, unique = true)
    private String documentNumber;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String status;

    @Column(name = "birth_date")
    private String birthDate;

    public Student() {
    }

    public Student(Long studentId, String code, String documentNumber,
                   String firstName, String lastName, String status,
                   String birthDate) {
        this.studentId = studentId;
        this.code = code;
        this.documentNumber = documentNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
        this.birthDate = birthDate;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "=== STUDENT INFO ===\n" +
                "ID: " + studentId + "\n" +
                "Código: " + code + "\n" +
                "Documento: " + documentNumber + "\n" +
                "Nombre: " + firstName + " " + lastName + "\n" +
                "Fecha Nacimiento: " + birthDate + "\n" +
                "Estado: " + status;
    }
}