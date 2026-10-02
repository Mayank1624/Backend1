package sample.webmvc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import sample.webmvc.entity.User;

@Controller
@ResponseBody
public class UserController {

    static Map<Integer, User> users = new HashMap<>();

    static {
        users.put(1, new User(1, "Atif", "Male", "Ballia"));
        users.put(2, new User(2, "Dilshad", "Male", "Dramanganj"));
        users.put(3, new User(3, "Vijay", "Male", "Khaga"));
        users.put(4, new User(4, "Abhishek", "Male", "Mirjapur"));
        users.put(5, new User(5, "Varun", "Male", "Ballia"));
    }

    @GetMapping
    public User greet() {
        System.out.println("UserController.greet");
        return new User(99, "Dummy", "No", "Planet not found");
    }

    @GetMapping("/{id}")
    public User pathVariable(@PathVariable("id") int id) {
        System.out.println("UserController.pathVariable : " + id);
        return users.get(id);
    }

    @GetMapping("/all-users")
    public Map<Integer, User> getAllUsers() {
        System.out.println("UserController.getAllUsers()");
        return users;
    }

    @PostMapping
    public User saveUser(@RequestBody User user) {
        System.out.println("UserController.saveUser");
        System.out.println(user);

        users.put(user.getId(), user);

        return user;
    }
}