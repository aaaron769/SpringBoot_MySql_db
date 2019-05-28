package student.demo.myController;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import student.demo.models.User;
import student.demo.service.UserService;


@RestController
public class UserController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @PostMapping("post")
    public void createNewUser(@Valid @RequestBody User user) {
        userService.addUser(user);

    }
    @PutMapping("update")
    public void changeExistingUser(@Valid @RequestBody User user) {
        userService.modifyUser(user);
    }

    @DeleteMapping("/removeUser/{id}")
    public void removeUser(@PathVariable(value = "id") long userId) {
        userService.removeUser(userId);
    }

    @GetMapping("/getUser/{id}")
    public User viewUserById(@PathVariable(value = "id") long userId) {
        return userService.getUserById(userId);
    }
    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){

        return userService.getAllUsers();

    }



}