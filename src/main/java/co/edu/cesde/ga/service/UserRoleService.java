package co.edu.cesde.ga.service;

import co.edu.cesde.ga.model.UserRole;
import java.util.List;

public interface UserRoleService {
    UserRole create(UserRole userRole);
    boolean delete(long userId, long roleId);
    boolean existsByUserIdAndRoleId(long userId, long roleId);
    List<UserRole> findByUserId(long userId);
    List<UserRole> findByRoleId(long roleId);
    List<UserRole> findAll();
}