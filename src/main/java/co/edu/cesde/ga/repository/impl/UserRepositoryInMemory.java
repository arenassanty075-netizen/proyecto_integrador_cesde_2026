package co.edu.cesde.ga.repository.impl;

import co.edu.cesde.ga.model.User;
import co.edu.cesde.ga.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryInMemory implements UserRepository {

    private List<User> users;
    private long nextUserId;

    public UserRepositoryInMemory() {
        this.users = new ArrayList<>();
        this.nextUserId = 1L;
    }

    @Override
    public User create(User user) {
        if (user == null) return null;

        if (existsByEmail(user.getEmail())) return null;

        user.setUserId(nextUserId++);
        users.add(user);
        return user;
    }

    @Override
    public boolean existsByEmail(String email) {
        if (email == null || email.isBlank()) return false;
        return findByEmail(email) != null;
    }

    @Override
    public User findByEmail(String email) {
        if (email == null || email.isBlank()) return null;

        for (User user : users) {
            if (email.equals(user.getEmail())) return user;
        }
        return null;
    }

    @Override
    public User findByUsername(String username) {
        if (username == null || username.isBlank()) return null;

        for (User user : users) {
            if (username.equals(user.getUsername())) return user;
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    @Override
    public User findById(long userId) {
        if (userId <= 0) return null;

        for (User user : users) {
            if (userId == user.getUserId()) return user;
        }
        return null;
    }

    @Override
    public boolean delete(long userId) {
        User user = findById(userId);
        if (user == null) return false;

        users.remove(user);
        return true;
    }

    @Override
    public int count() {
        return users.size();
    }

    @Override
    public boolean update(User updatedUser) {
        if (updatedUser == null) return false;

        for (int i = 0; i < users.size(); i++) {
            if (updatedUser.getUserId() == users.get(i).getUserId()) {
                users.set(i, updatedUser);
                return true;
            }
        }
        return false;
    }
}