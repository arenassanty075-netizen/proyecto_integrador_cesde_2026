package co.edu.cesde.ga.application.service.impl;

import co.edu.cesde.ga.exceptions.DuplicateException;
import co.edu.cesde.ga.exceptions.InvalidDataException;
import co.edu.cesde.ga.exceptions.NotFoundException;
import co.edu.cesde.ga.domain.model.UserRole;
import co.edu.cesde.ga.application.port.out.UserRoleRepository;
import co.edu.cesde.ga.application.port.in.UserRoleService;
import java.util.List;

public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }


    @Override
    public UserRole create(UserRole userRole) {

        if (userRole == null) {
            throw new InvalidDataException("La relación usuario-rol no puede ser nula");
        }

        if (isInvalidUserRole(userRole)) {
            throw new InvalidDataException("Datos inválidos");
        }

        if (userRoleRepository.existsByUserIdAndRoleId(
                userRole.getUserId(),
                userRole.getRoleId())) {

            throw new DuplicateException("El usuario ya tiene ese rol");
        }

        return userRoleRepository.create(userRole);
    }

    @Override
    public boolean delete(Long userId, Long roleId) {

        if (userId <= 0 || roleId <= 0) {
            throw new InvalidDataException("IDs inválidos");
        }

        if (!userRoleRepository.existsByUserIdAndRoleId(userId, roleId)) {
            throw new NotFoundException("Relación usuario-rol no encontrada");
        }

        return userRoleRepository.delete(userId, roleId);
    }


    @Override
    public boolean existsByUserIdAndRoleId(Long userId, Long roleId) {
        if (userId <= 0 || roleId <= 0) {
            throw new InvalidDataException("IDs inválidos");
        }

        return userRoleRepository.existsByUserIdAndRoleId(userId, roleId);
    }

    @Override
    public List<UserRole> findByUserId(Long userId) {

        if (userId <= 0) {
            throw new InvalidDataException("User ID inválido");
        }

        List<UserRole> userRoles = userRoleRepository.findByUserId(userId);

        if (userRoles == null || userRoles.isEmpty()) {
            throw new NotFoundException("No se encontraron roles para el usuario");
        }

        return userRoles;
    }


    @Override
    public List<UserRole> findByRoleId(Long roleId) {

        if (roleId <= 0) {
            throw new InvalidDataException("Role ID inválido");
        }

        List<UserRole> userRoles = userRoleRepository.findByRoleId(roleId);

        if (userRoles == null || userRoles.isEmpty()) {
            throw new NotFoundException("No se encontraron usuarios con ese rol");
        }

        return userRoles;
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