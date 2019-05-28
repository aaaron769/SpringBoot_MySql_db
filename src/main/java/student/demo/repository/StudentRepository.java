package student.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
;
import org.springframework.stereotype.Repository;
import student.demo.models.User;
@Repository
public interface StudentRepository extends JpaRepository<User,Long> {
}
