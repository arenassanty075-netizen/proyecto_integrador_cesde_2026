package co.edu.cesde.ga.repository;

import co.edu.cesde.ga.model.User;
import java.util.List;

public interface UserRepository {

    User create(User user);

    boolean existsByEmail(String email);

    User findByEmail(String email);

    User findByUsername(String username);

    List<User> findAll();

    User findById(long userId);

    boolean delete(long userId);

    int count();

    boolean update(User user);
}