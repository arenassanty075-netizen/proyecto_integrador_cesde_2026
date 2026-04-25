package co.edu.cesde.ga.model;

public class Subject {
    private long subjectId;
    private String code;
    private String name;
    private int credits;
    private long programId;

    public Subject() {
    }

    public Subject(long subjectId, String code, String name, int credits, long programId) {
        this.subjectId = subjectId;
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.programId = programId;
    }

    public long getSubjectId() { return subjectId; }
    public void setSubjectId(long subjectId) { this.subjectId = subjectId; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getCredits() { return credits; }
    public void setCredits(int credits) { this.credits = credits; }

    public long getProgramId() { return programId; }
    public void setProgramId(long programId) { this.programId = programId; }

    @Override
    public String toString() {
        return "Subject { subjectId=" + subjectId + ", code=" + code + ", name=" + name + ", credits=" + credits + ", programId=" + programId + " }";
    }
}