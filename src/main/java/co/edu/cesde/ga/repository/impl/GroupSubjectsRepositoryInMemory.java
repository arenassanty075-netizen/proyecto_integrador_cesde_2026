package co.edu.cesde.ga.repository.impl;

import co.edu.cesde.ga.model.GroupSubjects;
import co.edu.cesde.ga.repository.GroupSubjectsRepository;

import java.util.ArrayList;
import java.util.List;

public class GroupSubjectsRepositoryInMemory implements GroupSubjectsRepository {

    private List<GroupSubjects> groupSubjects;

    public GroupSubjectsRepositoryInMemory() {
        this.groupSubjects = new ArrayList<>();
    }

    @Override
    public GroupSubjects create(GroupSubjects groupSubject) {
        if (groupSubject == null) {
            return null;
        }

        if (exists(groupSubject.getGroupId(), groupSubject.getSubjectId())) {
            return null;
        }

        groupSubjects.add(groupSubject);
        return groupSubject;
    }

    @Override
    public boolean exists(Long groupId, String subjectId) {
        return findByIds(groupId, subjectId) != null;
    }

    @Override
    public GroupSubjects findByIds(Long groupId, String subjectId) {
        if (subjectId == null || subjectId.isBlank()) {
            return null;
        }

        for (GroupSubjects gs : groupSubjects) {
            if (gs.getGroupId() == groupId &&
                    subjectId.equals(gs.getSubjectId())) {
                return gs;
            }
        }
        return null;
    }

    @Override
    public List<GroupSubjects> findAll() {
        return new ArrayList<>(groupSubjects);
    }

    @Override
    public boolean delete(Long groupId, String subjectId) {
        GroupSubjects gs = findByIds(groupId, subjectId);
        if (gs == null) return false;

        groupSubjects.remove(gs);
        return true;
    }

    @Override
    public int count() {
        return groupSubjects.size();
    }

    @Override
    public boolean update(GroupSubjects updated) {
        if (updated == null) return false;

        for (int i = 0; i < groupSubjects.size(); i++) {
            GroupSubjects current = groupSubjects.get(i);

            if (current.getGroupId() == updated.getGroupId() &&
                    current.getSubjectId().equals(updated.getSubjectId())) {

                groupSubjects.set(i, updated);
                return true;
            }
        }
        return false;
    }
}
