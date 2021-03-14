package sk.stuba.fei.uim.project.Functionality.Service;

import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.project.User.User;

import java.util.Map;
import java.util.Optional;

@Service
public interface UserService {

    void addUser(User user);

    Map<Integer, User> getUserList();


    Optional<User> findUserById(int id);

   // Optional<User> findUserByName(String name);

}
