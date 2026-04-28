package co.edu.cesde.ga.service.impl;

import co.edu.cesde.ga.model.User;
import co.edu.cesde.ga.repository.UserRepository;
import co.edu.cesde.ga.service.UserService;
import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        if (isInvalidUser(user)) return null;
        if (userRepository.existsByEmail(user.getEmail())) return null;
        return userRepository.create(user);
    }

    @Override
    public boolean update(User user) {
        if (isInvalidUser(user) || user.getUserId() <= 0) return false;
        return userRepository.update(user);
    }

    @Override
    public boolean delete(long userId) {
        if (userId <= 0) return false;
        return userRepository.delete(userId);
    }

    @Override
    public User findById(long userId) {
        if (userId <= 0) return null;
        return userRepository.findById(userId);
    }

    @Override
    public User findByEmail(String email) {
        if (email == null || email.isBlank()) return null;
        return userRepository.findByEmail(email);
    }

    @Override
    public User findByUsername(String username) {
        if (username == null || username.isBlank()) return null;
        return userRepository.findByUsername(username);
    }

    @Override
    public boolean existsByEmail(String email) {
        if (email == null || email.isBlank()) return false;
        return userRepository.existsByEmail(email);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    private boolean isInvalidUser(User user) {
        return user == null
                || !isNotBlank(user.getUsername())
                || !isNotBlank(user.getEmail())
                || !isNotBlank(user.getPasswordHash())
                || !isNotBlank(user.getStatus());
    }

    private boolean isNotBlank(String value) {
        return value != null && !value.trim().isEmpty();
    }
}