package co.edu.cesde.ga.repository;

import co.edu.cesde.ga.model.Role;
import java.util.List;

public interface RoleRepository {

    Role create(Role role);

    boolean existsById(long roleId);

    Role findById(long roleId);

    List<Role> findAll();

    boolean delete(long roleId);

    int count();

    boolean update(Role role);
}
