package com.example.cst438_proj1.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.cst438_proj1.User;

import java.util.List;

@Dao
public interface UserDAO {
    @Insert
    void insert(User... User);
    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(User... User);
    @Delete
    void delete(User User);
    @Query("SELECT * FROM " + UserDatabase.USER_TABLE)
    List<User> getUser();
    @Query("SELECT * FROM " + UserDatabase.USER_TABLE + " WHERE id = :id")
    User getUserById(int id);
    @Query("SELECT * FROM " + UserDatabase.USER_TABLE + " WHERE username = :username")
    User getUserByUsername(String username);

}