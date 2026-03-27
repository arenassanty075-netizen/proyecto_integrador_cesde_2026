package co.edu.cesde.ga.repository.impl;

import co.edu.cesde.ga.model.Groups;
import co.edu.cesde.ga.repository.GroupRepository;

import java.util.ArrayList;
import java.util.List;

public class GroupRepositoryInMemory implements GroupRepository {

    private List<Groups> groups;
    private long nextGroupId;

    public GroupRepositoryInMemory() {
        this.groups = new ArrayList<>();
        this.nextGroupId = 1L;
    }

    @Override
    public Groups create(Groups group) {
        if (group == null) {
            return null;
        }

        group.setGroupId(nextGroupId++);
        groups.add(group);
        return group;
    }

    @Override
    public List<Groups> findAll() {
        return new ArrayList<>(groups);
    }

    @Override
    public Groups findById(Long groupId) {
        if (groupId == null || groupId <= 0) {
            return null;
        }

        for (Groups group : groups) {
            if (groupId.equals(group.getGroupId())) {
                return group;
            }
        }
        return null;
    }

    @Override
    public List<Groups> findByProgramId(Long programId) {
        List<Groups> result = new ArrayList<>();

        if (programId == null) {
            return result;
        }

        for (Groups group : groups) {
            if (programId.equals(group.getProgramId())) {
                result.add(group);
            }
        }
        return result;
    }

    @Override
    public boolean update(Groups updatedGroup) {
        if (updatedGroup == null) return false;

        for (int i = 0; i < groups.size(); i++) {
            if (updatedGroup.getGroupId() == groups.get(i).getGroupId()) {
                groups.set(i, updatedGroup);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(Long groupId) {
        Groups group = findById(groupId);
        if (group == null) return false;

        groups.remove(group);
        return true;
    }

    @Override
    public int count() {
        return groups.size();
    }
}