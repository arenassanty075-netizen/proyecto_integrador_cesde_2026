package co.edu.cesde.ga.model;

public class GroupSubjects {

    private long groupSubjectId;
    private long groupId;
    private String subjectId; // 🔥 CAMBIO AQUÍ
    private long teacherId;

    public GroupSubjects() {
    }

    public GroupSubjects(long groupSubjectId, long groupId, String subjectId, long teacherId) {
        this.groupSubjectId = groupSubjectId;
        this.groupId = groupId;
        this.subjectId = subjectId;
        this.teacherId = teacherId;
    }

    public long getGroupSubjectId() {
        return groupSubjectId;
    }

    public void setGroupSubjectId(long groupSubjectId) {
        this.groupSubjectId = groupSubjectId;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }
}