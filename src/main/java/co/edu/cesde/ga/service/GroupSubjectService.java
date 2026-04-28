package co.edu.cesde.ga.service;

import co.edu.cesde.ga.model.GroupSubjects;
import java.util.List;

public interface GroupSubjectService {
    GroupSubjects create(GroupSubjects groupSubject);
    boolean update(GroupSubjects groupSubject);
    boolean delete(Long groupId, String subjectId);
    GroupSubjects findByIds(Long groupId, String subjectId);
    boolean exists(Long groupId, String subjectId);
    List<GroupSubjects> findAll();
}