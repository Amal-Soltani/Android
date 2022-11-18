package com.example.mycourses.Database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.example.mycourses.DAO.CoursDAO;
import com.example.mycourses.DAO.UserDAO;
import com.example.mycourses.Entity.Cours;
import com.example.mycourses.Entity.User;

@Database(entities = {User.class}, version = 2, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {
    private static AppDataBase instance;

    public abstract UserDAO userDao();
    public abstract CoursDAO CoursDao();

    public static AppDataBase getAppDatabase(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class, "room_test_db")
                    .allowMainThreadQueries().fallbackToDestructiveMigration()
                    .build();
        }
        return instance;

    }



}
