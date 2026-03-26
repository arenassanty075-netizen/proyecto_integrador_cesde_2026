package co.edu.cesde.ga.repository;

import co.edu.cesde.ga.model.User;
import java.util.List;

public interface UserRepository {

    User create(User user);

    boolean existsById(long userId);

    User findById(long userId);

    List<User> findAll();

    boolean delete(long userId);

    int count();

    boolean update(User user);
}
