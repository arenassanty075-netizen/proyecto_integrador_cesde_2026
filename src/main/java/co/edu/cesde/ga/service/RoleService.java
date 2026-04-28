package co.edu.cesde.ga.service;

import co.edu.cesde.ga.model.Role;
import java.util.List;

public interface RoleService {
    Role create(Role role);
    boolean update(Role role);
    boolean delete(long roleId);
    Role findById(long roleId);
    Role findByName(String name);
    boolean existsByName(String name);
    List<Role> findAll();
}