package com.example.mycourses.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.mycourses.Entity.User;

import java.util.List;

@Dao
public interface UserDAO {
    @Insert
    void insertOne(User user);

    @Delete
    void delete(User user);

    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT * FROM user WHERE login=(:login) and pwd=(:pwd)")
    User UserByLoginAndPWD(String login, String pwd);
}
