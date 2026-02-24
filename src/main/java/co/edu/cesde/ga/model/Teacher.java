package co.edu.cesde.ga.model;

public class Teacher  extends Person{
    public Teacher() {
    }

    public Teacher(Long userId, String code, String documentNumber, String firsName, String lastName, String status) {
        super(userId, code, documentNumber, firsName, lastName, status);
    }
}
