package co.edu.cesde.ga.service;

import co.edu.cesde.ga.model.Groups;

import java.util.List;

public interface GroupsService {
    Groups create(Groups groups);

    boolean existsById(Long groupsId);

    Groups findById(Long groupsId);

    List<Groups> findAll();

    boolean delete(Long groupsId);

    boolean update(Groups groups);

}
