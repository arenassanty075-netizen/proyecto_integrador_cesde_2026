package co.edu.cesde.ga.model;

public class Student  extends Person{
    private String brithDate;
    public Student(){

    }

    public Student(Long userId, String code, String documentNumber, String firsName, String lastName, String status, String brithDate) {
        super(userId, code, documentNumber, firsName, lastName, status);
        this.brithDate = brithDate;
    }

    public String getBrithDate() {
        return brithDate;
    }
    public void setBrithDate(String brithDate) {
        this.brithDate = brithDate;

    }

}
