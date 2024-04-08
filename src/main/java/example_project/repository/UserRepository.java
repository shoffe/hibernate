package example_project.repository;

import example_project.User;
import java.util.List;

public interface UserRepository {
    List<User> findAll();

    User save(User user);

    List<User> saveAll(List<User> users);

    boolean delete(int id);

    User update(User user);

    User findById(int id);
}
