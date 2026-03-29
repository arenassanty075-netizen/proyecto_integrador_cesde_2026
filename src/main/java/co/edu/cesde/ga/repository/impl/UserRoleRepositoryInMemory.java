package co.edu.cesde.ga.repository.impl;

import co.edu.cesde.ga.model.UserRole;
import co.edu.cesde.ga.repository.UserRoleRepository;

import java.util.ArrayList;
import java.util.List;

public class UserRoleRepositoryInMemory implements UserRoleRepository {

    private List<UserRole> userRoles;

    public UserRoleRepositoryInMemory() {
        this.userRoles = new ArrayList<>();
    }

    @Override
    public UserRole create(UserRole userRole) {
        if (userRole == null) return null;

        if (existsByUserIdAndRoleId(userRole.getUserId(), userRole.getRoleId())) return null;

        userRoles.add(userRole);
        return userRole;
    }

    @Override
    public boolean existsByUserIdAndRoleId(long userId, long roleId) {
        return findByUserId(userId).stream()
                .anyMatch(ur -> ur.getRoleId() == roleId);
    }

    @Override
    public List<UserRole> findByUserId(long userId) {
        if (userId <= 0) return new ArrayList<>();

        List<UserRole> result = new ArrayList<>();
        for (UserRole ur : userRoles) {
            if (ur.getUserId() == userId) result.add(ur);
        }
        return result;
    }

    @Override
    public List<UserRole> findByRoleId(long roleId) {
        if (roleId <= 0) return new ArrayList<>();

        List<UserRole> result = new ArrayList<>();
        for (UserRole ur : userRoles) {
            if (ur.getRoleId() == roleId) result.add(ur);
        }
        return result;
    }

    @Override
    public List<UserRole> findAll() {
        return new ArrayList<>(userRoles);
    }

    @Override
    public boolean delete(long userId, long roleId) {
        for (UserRole ur : userRoles) {
            if (ur.getUserId() == userId && ur.getRoleId() == roleId) {
                userRoles.remove(ur);
                return true;
            }
        }
        return false;
    }

    @Override
    public int count() {
        return userRoles.size();
    }
}