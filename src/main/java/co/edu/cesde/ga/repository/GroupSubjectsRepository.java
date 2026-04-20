package co.edu.cesde.ga.repository;

import co.edu.cesde.ga.model.GroupSubjects;
import java.util.List;

public interface GroupSubjectsRepository {

    GroupSubjects create(GroupSubjects groupSubject);

    boolean exists(Long groupId, String subjectId);

    GroupSubjects findByIds(Long groupId, String subjectId);

    List<GroupSubjects> findAll();

    boolean delete(Long groupId, String subjectId);

    int count();

    boolean update(GroupSubjects groupSubject);
}