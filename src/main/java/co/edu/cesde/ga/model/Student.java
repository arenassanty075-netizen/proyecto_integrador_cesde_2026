package co.edu.cesde.ga.model;

public class Student extends Person {

    private Long studentId;
    private String birthDate;

    public Student() {
    }

    public Student(Long userId, String code, String documentNumber,
                   String firstName, String lastName, String status,
                   String birthDate) {
        super(userId, code, documentNumber, firstName, lastName, status);
        this.birthDate = birthDate;
    }

    @Override
    public String getRole() {
        return "Student";
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
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
                "ID: " + getStudentId() + "\n" + // 🔥 corregido (antes getUserId)
                "Código: " + getCode() + "\n" +
                "Documento: " + getDocumentNumber() + "\n" +
                "Nombre: " + getFirstName() + " " + getLastName() + "\n" +
                "Fecha Nacimiento: " + birthDate + "\n" +
                "Estado: " + getStatus();
    }
}