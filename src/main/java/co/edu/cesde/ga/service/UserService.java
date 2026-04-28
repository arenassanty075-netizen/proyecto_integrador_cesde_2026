package co.edu.cesde.ga.service;

import co.edu.cesde.ga.model.User;
import java.util.List;

public interface UserService {
    User create(User user);
    boolean update(User user);
    boolean delete(long userId);
    User findById(long userId);
    User findByEmail(String email);
    User findByUsername(String username);
    boolean existsByEmail(String email);
    List<User> findAll();
}