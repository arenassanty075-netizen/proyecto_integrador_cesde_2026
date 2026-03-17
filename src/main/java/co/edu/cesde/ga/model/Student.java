package co.edu.cesde.ga.model;

public class Student  extends Person{
    private String birthDate;
    public Student(){

    }

    public Student(Long userId, String code, String documentNumber, String firsName, String lastName, String status, String brithDate) {
        super(userId, code, documentNumber, firsName, lastName, status);
        this.birthDate = brithDate;
    }

    public String getBrithDate() {
        return birthDate;
    }
    public void setBrithDate(String brithDate) {
        this.birthDate = brithDate;

    }

}
