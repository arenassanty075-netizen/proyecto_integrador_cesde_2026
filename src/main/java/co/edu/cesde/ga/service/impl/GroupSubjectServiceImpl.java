package co.edu.cesde.ga.service.impl;

import co.edu.cesde.ga.model.GroupSubjects;
import co.edu.cesde.ga.repository.GroupSubjectsRepository;
import co.edu.cesde.ga.service.GroupSubjectService;
import java.util.List;

public class GroupSubjectServiceImpl implements GroupSubjectService {

    private final GroupSubjectsRepository groupSubjectsRepository;

    public GroupSubjectServiceImpl(GroupSubjectsRepository groupSubjectsRepository) {
        this.groupSubjectsRepository = groupSubjectsRepository;
    }

    @Override
    public GroupSubjects create(GroupSubjects groupSubject) {
        if (isInvalidGroupSubject(groupSubject)) return null;
        if (groupSubjectsRepository.exists(groupSubject.getGroupId(), groupSubject.getSubjectId())) return null;
        return groupSubjectsRepository.create(groupSubject);
    }

    @Override
    public boolean update(GroupSubjects groupSubject) {
        if (isInvalidGroupSubject(groupSubject)) return false;
        if (!groupSubjectsRepository.exists(groupSubject.getGroupId(), groupSubject.getSubjectId())) return false;
        return groupSubjectsRepository.update(groupSubject);
    }

    @Override
    public boolean delete(Long groupId, String subjectId) {
        if (groupId == null || groupId <= 0L || !isNotBlank(subjectId)) return false;
        return groupSubjectsRepository.delete(groupId, subjectId);
    }

    @Override
    public GroupSubjects findByIds(Long groupId, String subjectId) {
        if (groupId == null || groupId <= 0L || !isNotBlank(subjectId)) return null;
        return groupSubjectsRepository.findByIds(groupId, subjectId);
    }

    @Override
    public boolean exists(Long groupId, String subjectId) {
        if (groupId == null || groupId <= 0L || !isNotBlank(subjectId)) return false;
        return groupSubjectsRepository.exists(groupId, subjectId);
    }

    @Override
    public List<GroupSubjects> findAll() {
        return groupSubjectsRepository.findAll();
    }

    private boolean isInvalidGroupSubject(GroupSubjects groupSubject) {
        return groupSubject == null
                || groupSubject.getGroupId() == null
                || groupSubject.getGroupId() <= 0L
                || !isNotBlank(groupSubject.getSubjectId())
                || groupSubject.getTeacherId() <= 0L;
    }

    private boolean isNotBlank(String value) {
        return value != null && !value.trim().isEmpty();
    }
}