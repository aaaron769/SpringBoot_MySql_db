package student.demo.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//import com.geekylearner.userRestApi.entity.User;
import student.demo.models.User;
import student.demo.repository.StudentRepository;

@Repository("userDao")
public class UserDao {

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private StudentRepository studentRepository;

    public User selectUserById(long userId) {
        return entityManager.find(User.class, userId);
    }

    public void insertUser(User user) {
        entityManager.persist(user);
    }

    public void updateUser(User user) {

        User userToUpdate = selectUserById(user.getUserId());

        userToUpdate.setUserName(user.getUserName());
        userToUpdate.setUserEmail(user.getUserEmail());
        userToUpdate.setUserPhoneNo(user.getUserPhoneNo());

        entityManager.flush();
    }

    public void deleteUser(long userId) {
        entityManager.remove(selectUserById(userId));
    }


    public List<User> getAllUsers() {
        return studentRepository.findAll();
    }
}