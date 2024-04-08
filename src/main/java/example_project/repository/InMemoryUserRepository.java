package example_project.repository;

import example_project.User;

import java.util.ArrayList;
import java.util.List;

public class InMemoryUserRepository implements UserRepository {


    private final List<User> users = new ArrayList<>();
    private int currentId = 1;
    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User save(User user) {
        user.setId(currentId++);
        users.add(user);

        return user;
    }

    @Override
    public List<User> saveAll(List<User> users) {
        List<User> savedUsers = new ArrayList<>();

        for (User user : users) {
            User save = save(user);
            savedUsers.add(save);
        }

        return savedUsers;
    }

    @Override
    public boolean delete(int id) {
        User userToDelete = null;

        for (User user : users) {
            if (user.getId() == id) {
                userToDelete = user;
                break;
            }
        }

        if (userToDelete != null) {
            return users.remove(userToDelete);
        }

        return false;
    }

    @Override
    public User update(User updateUser) {
        for (User user : users) {
            if (user.getId().equals(updateUser.getId())) {
                user.setName(updateUser.getName());
                user.setAge(updateUser.getAge());
                user.setRace(updateUser.getRace());
                return user;
            }
        }
        return null;
    }

    @Override
    public User findById(int id) {
        return null;
    }
}
