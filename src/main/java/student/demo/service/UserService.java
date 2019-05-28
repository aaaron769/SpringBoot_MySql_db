package student.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import student.demo.models.User;


@Service("userService")
public class UserService {

    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;

    @Transactional
    public User getUserById(long userId) {
        return userDao.selectUserById(userId);
    }

    @Transactional
    public void addUser(User user) {
        userDao.insertUser(user);
    }

    @Transactional
    public void modifyUser(User user) {
        userDao.updateUser(user);
    }

    @Transactional
    public void removeUser(long userId) {
        userDao.deleteUser(userId);

    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}