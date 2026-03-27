package co.edu.cesde.ga.model;

public class Teacher extends Person {

    private long teacherId;

    public Teacher() {
    }

    public Teacher(Long userId, String code, String documentNumber,
                   String firstName, String lastName, String status) {
        super(userId, code, documentNumber, firstName, lastName, status);
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String getRole() {
        return "=== TEACHER INFO ===\n" +
                "ID: " + getUserId() + "\n" +
                "Código: " + getCode() + "\n" +
                "Documento: " + getDocumentNumber() + "\n" +
                "Nombre: " + getFirstName() + " " + getLastName() + "\n" +
                "Estado: " + getStatus();
    }
}