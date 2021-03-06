package io.ramenergy.Dao;

import io.ramenergy.Entity.User;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Created by lwown on 20/4/2017.
 */
@Repository
public class UserDao {
    private List<User> users = new ArrayList<>(Arrays.asList(
            new User("a", "b", "ab", "a@b.com", "secret"),
            new User("c", "d", "cd", "c@d.com", "secret"),
            new User("e", "f", "ef", "e@f.com", "secret"),
            new User("g", "h", "gh", "g@h.com", "secret2c")
    ));

    public List<User> getAllUsers() {
        return users;
    }

    public User getUser(String username) {
        return users.stream().filter(u -> u.getUserName().equals(username)).findFirst().get();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void updateUser(String username, User user) {
        for (int i = 0; i < users.size(); i++) {
            User u = users.get(i);
            if (u.getUserName().equals(username)) {
                users.set(i, user);
                return;
            }
        }
    }

    public void deleteUser(String username) {
        users.removeIf(u -> u.getUserName().equals(username));
    }

}
