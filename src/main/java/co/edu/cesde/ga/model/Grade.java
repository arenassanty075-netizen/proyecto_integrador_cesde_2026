package co.edu.cesde.ga.model;

public class Grade {
    private long gradeId;
    private long groupSubjectId;
    private long studentId;
    private int finalScore;
    private String observation;

    public Grade() {
    }

    public Grade(long gradeId, long groupSubjectId, long studentId, int finalScore, String observation) {
        this.gradeId = gradeId;
        this.groupSubjectId = groupSubjectId;
        this.studentId = studentId;
        this.finalScore = finalScore;
        this.observation = observation;
    }

    public long getGradeId() { return gradeId; }
    public void setGradeId(long gradeId) { this.gradeId = gradeId; }

    public long getGroupSubjectId() { return groupSubjectId; }
    public void setGroupSubjectId(long groupSubjectId) { this.groupSubjectId = groupSubjectId; }

    public long getStudentId() { return studentId; }
    public void setStudentId(long studentId) { this.studentId = studentId; }

    public int getFinalScore() { return finalScore; }
    public void setFinalScore(int finalScore) { this.finalScore = finalScore; }

    public String getObservation() { return observation; }
    public void setObservation(String observation) { this.observation = observation; }

    @Override
    public String toString() {
        return "Grade { gradeId=" + gradeId + ", groupSubjectId=" + groupSubjectId + ", studentId=" + studentId + ", finalScore=" + finalScore + ", observation=" + observation + " }";
    }
}