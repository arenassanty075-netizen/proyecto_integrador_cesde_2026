package co.edu.cesde.ga.app.model;

public class Programs {

    private int programId;
    private String code;
    private String name;

    public Programs(int programId, String code, String name) {
        this.programId = programId;
        this.code = code;
        this.name = name;
    }

    public int getProgramId() {
        return programId;
    }

    public void setProgramId(int programId) {
        this.programId = programId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}