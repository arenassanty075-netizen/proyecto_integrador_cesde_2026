package co.edu.cesde.ga.service.impl;

import co.edu.cesde.ga.model.UserRole;
import co.edu.cesde.ga.repository.UserRoleRepository;
import co.edu.cesde.ga.service.UserRoleService;
import java.util.List;

public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public UserRole create(UserRole userRole) {
        if (isInvalidUserRole(userRole)) return null;
        if (userRoleRepository.existsByUserIdAndRoleId(userRole.getUserId(), userRole.getRoleId())) return null;
        return userRoleRepository.create(userRole);
    }

    @Override
    public boolean delete(long userId, long roleId) {
        if (userId <= 0 || roleId <= 0) return false;
        return userRoleRepository.delete(userId, roleId);
    }

    @Override
    public boolean existsByUserIdAndRoleId(long userId, long roleId) {
        if (userId <= 0 || roleId <= 0) return false;
        return userRoleRepository.existsByUserIdAndRoleId(userId, roleId);
    }

    @Override
    public List<UserRole> findByUserId(long userId) {
        if (userId <= 0) return null;
        return userRoleRepository.findByUserId(userId);
    }

    @Override
    public List<UserRole> findByRoleId(long roleId) {
        if (roleId <= 0) return null;
        return userRoleRepository.findByRoleId(roleId);
    }

    @Override
    public List<UserRole> findAll() {
        return userRoleRepository.findAll();
    }

    private boolean isInvalidUserRole(UserRole userRole) {
        return userRole == null
                || userRole.getUserId() <= 0
                || userRole.getRoleId() <= 0;
    }
}