package co.edu.cesde.ga.repository;

import co.edu.cesde.ga.model.UserRole;
import java.util.List;

public interface UserRoleRepository {

    UserRole create(UserRole userRole);

    boolean existsByUserIdAndRoleId(long userId, long roleId);

    List<UserRole> findByUserId(long userId);

    List<UserRole> findByRoleId(long roleId);

    List<UserRole> findAll();

    boolean delete(long userId, long roleId);

    int count();
}