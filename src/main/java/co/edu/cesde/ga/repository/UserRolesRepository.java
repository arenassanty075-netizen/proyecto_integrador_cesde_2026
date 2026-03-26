package co.edu.cesde.ga.repository;

import co.edu.cesde.ga.model.UserRole;
import java.util.List;

public interface UserRolesRepository {

    UserRole create(UserRole userRole);

    boolean exists(long userId, long roleId);

    UserRole findByIds(long userId, long roleId);

    List<UserRole> findAll();

    boolean delete(long userId, long roleId);

    int count();

    boolean update(UserRole userRole);
}
