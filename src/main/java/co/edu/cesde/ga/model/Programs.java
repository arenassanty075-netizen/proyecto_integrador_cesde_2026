package co.edu.cesde.ga.model;

public class Programs {

    private long programId;
    private String code;
    private String name;

    public Programs(long programId, String code, String name) {
        this.programId = programId;
        this.code = code;
        this.name = name;
    }

    public long getProgramId() {
        return  programId;
    }

    public void setProgramId(long programId) {
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