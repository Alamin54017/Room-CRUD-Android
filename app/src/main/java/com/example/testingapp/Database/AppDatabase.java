package com.example.testingapp.Database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.testingapp.Dao.UserDao;
import com.example.testingapp.Model.User;

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();

    static public AppDatabase getInstance(Context context) {
        return Room.databaseBuilder(context,
                AppDatabase.class, "MyDatabase").allowMainThreadQueries().build();    }

}
