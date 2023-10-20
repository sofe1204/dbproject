package com.example.demo.repository;

import com.example.demo.model.Movie;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {


    @Query(value="select * from users where user_username=? AND user_password=?",nativeQuery = true)
    Optional<User> findByUsernameAndPassword(String user_username, String user_password);

    @Query(value="select * from users where user_username=?",nativeQuery = true)
    Optional<User> findByUsername(String user_username);

//    @Query(value="select u.user_username,u.user_password from users as u where user_username=? AND user_password=?",nativeQuery = true)
//    List<User> findByUsernameAndPassword(String user_username, String user_password);
//
//    @Query(value="select u.user_username from users as u where user_username=?",nativeQuery = true)
//    Optional<User> findByUsername(String s);

}
