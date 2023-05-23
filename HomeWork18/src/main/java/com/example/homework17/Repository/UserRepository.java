package com.example.homework17.Repository;

import com.example.homework17.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
User findUsersByUsernameAndPassword(String username,String password);

@Query("select s from User s where s.email=?1")
User getUserByEmail(String email);

//    User findUsersByEmail(String email);
    List<User> findUsersByRole(String role);
    @Query("select e from User e where e.age>= ?1")
    List<User> getUserAgeAndAbove(Integer age);

}
