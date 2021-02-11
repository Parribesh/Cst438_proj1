package com.example.cst438_proj1.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {User.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {
    public static final String DB_NAME = "USER_DATABASE";
    public static final String USER_TABLE = "USER_TABLE";

    public abstract UserDAO getUserDAO();
    private static UserDatabase INSTANCE;

    public static UserDatabase getInMemoryDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.inMemoryDatabaseBuilder(context, UserDatabase.class).allowMainThreadQueries().build();
        }
        return INSTANCE;
    }

}

