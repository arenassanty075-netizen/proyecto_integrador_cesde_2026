package co.edu.cesde.ga.repository.impl;

import co.edu.cesde.ga.model.Role;
import co.edu.cesde.ga.repository.RoleRepository;

import java.util.ArrayList;
import java.util.List;

public class RoleRepositoryInMemory implements RoleRepository {

    private List<Role> roles;
    private long nextRoleId;

    public RoleRepositoryInMemory() {
        this.roles = new ArrayList<>();
        this.nextRoleId = 1L;
    }

    @Override
    public Role create(Role role) {
        if (role == null) return null;

        if (existsByName(role.getName())) return null;

        role.setRoleId(nextRoleId++);
        roles.add(role);
        return role;
    }

    @Override
    public boolean existsByName(String name) {
        if (name == null || name.isBlank()) return false;
        return findByName(name) != null;
    }

    @Override
    public Role findByName(String name) {
        if (name == null || name.isBlank()) return null;

        for (Role role : roles) {
            if (name.equals(role.getName())) return role;
        }
        return null;
    }

    @Override
    public List<Role> findAll() {
        return new ArrayList<>(roles);
    }

    @Override
    public Role findById(long roleId) {
        if (roleId <= 0) return null;

        for (Role role : roles) {
            if (roleId == role.getRoleId()) return role;
        }
        return null;
    }

    @Override
    public boolean delete(long roleId) {
        Role role = findById(roleId);
        if (role == null) return false;

        roles.remove(role);
        return true;
    }

    @Override
    public int count() {
        return roles.size();
    }

    @Override
    public boolean update(Role updatedRole) {
        if (updatedRole == null) return false;

        for (int i = 0; i < roles.size(); i++) {
            if (updatedRole.getRoleId() == roles.get(i).getRoleId()) {
                roles.set(i, updatedRole);
                return true;
            }
        }
        return false;
    }
}