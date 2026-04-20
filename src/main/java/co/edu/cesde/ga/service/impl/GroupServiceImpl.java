package co.edu.cesde.ga.service.impl;

import co.edu.cesde.ga.model.Groups;
import co.edu.cesde.ga.repository.GroupRepository;
import co.edu.cesde.ga.service.GroupsService;

import java.util.List;

public class GroupServiceImpl implements GroupsService {

    private final GroupRepository groupRepository;

    public GroupServiceImpl(GroupRepository groupRepository){
        this.groupRepository = groupRepository;
    }

    @Override
    public Groups create(Groups groups){
        if (isInvalidGroups(groups) || groupRepository.existsById(groups.getGroupId())){
            return null;
        }
        return groupRepository.create(groups);
    }

    @Override
    public boolean update(Groups groups){
        if (isInvalidGroups(groups) || groups.getGroupId() == null || groups.getGroupId() <= 0L){
            return false;
        }
        if (!groupRepository.existsById(groups.getGroupId())){
            return false;
        }
        return groupRepository.update(groups);
    }

    @Override
    public boolean delete(Long groupsId){
        if (groupsId == null || groupsId <= 0L){
            return false;
        }
        return groupRepository.delete(groupsId);
    }

    @Override
    public Groups findById(Long groupsId){
        if (groupsId == null || groupsId <= 0L){
            return null;
        }
        return groupRepository.findById(groupsId);
    }

    @Override
    public List<Groups> findAll(){
        return groupRepository.findAll();
    }

    @Override
    public boolean existsById(Long groupsId){
        return groupRepository.existsById(groupsId);
    }

    private boolean isInvalidGroups(Groups groups){
        return groups == null
                || groups.getProgramId() == null
                || groups.getPeriodId() == null
                || groups.getShift() == null
                || !isNotBlank(groups.getCode());
    }

    private boolean isNotBlank(String value){
        return value != null && !value.trim().isEmpty();
    }
}
