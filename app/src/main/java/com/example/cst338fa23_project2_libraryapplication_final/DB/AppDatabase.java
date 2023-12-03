package com.example.cst338fa23_project2_libraryapplication_final.DB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public static final String DB_NAME = "User.db";
    public static final String USER_TABLE = "user_table";
    private static volatile AppDatabase instance;
    private static final Object LOCK = new Object();
    public abstract UserDAO UserDAO();

    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            synchronized (LOCK) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, DB_NAME).build();
                }
            }
        }

        return instance;
    }
    public UserDAO getUserDAO() {return UserDAO();}
}
