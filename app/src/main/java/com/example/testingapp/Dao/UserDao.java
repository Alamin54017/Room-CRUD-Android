package com.example.testingapp.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.testingapp.Model.User;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    User findByName(String first, String last);


    @Insert
    void insertAll(User... user);

    @Delete
    void delete(User user);

    @Query("SELECT * FROM user WHERE uid = :id")
    User findByID(int id);

    @Update
    void updateUser(User... user);

}
