package co.edu.cesde.ga.service.impl;

import co.edu.cesde.ga.model.Role;
import co.edu.cesde.ga.repository.RoleRepository;
import co.edu.cesde.ga.service.RoleService;
import java.util.List;

public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role create(Role role) {
        if (isInvalidRole(role)) return null;
        if (roleRepository.existsByName(role.getName())) return null;
        return roleRepository.create(role);
    }

    @Override
    public boolean update(Role role) {
        if (isInvalidRole(role) || role.getRoleId() <= 0) return false;
        return roleRepository.update(role);
    }

    @Override
    public boolean delete(long roleId) {
        if (roleId <= 0) return false;
        return roleRepository.delete(roleId);
    }

    @Override
    public Role findById(long roleId) {
        if (roleId <= 0) return null;
        return roleRepository.findById(roleId);
    }

    @Override
    public Role findByName(String name) {
        if (name == null || name.isBlank()) return null;
        return roleRepository.findByName(name);
    }

    @Override
    public boolean existsByName(String name) {
        if (name == null || name.isBlank()) return false;
        return roleRepository.existsByName(name);
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    private boolean isInvalidRole(Role role) {
        return role == null
                || !isNotBlank(role.getName())
                || !isNotBlank(role.getDescription());
    }

    private boolean isNotBlank(String value) {
        return value != null && !value.trim().isEmpty();
    }
}