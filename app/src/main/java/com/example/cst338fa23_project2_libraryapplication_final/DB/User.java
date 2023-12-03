package com.example.cst338fa23_project2_libraryapplication_final.DB;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.cst338fa23_project2_libraryapplication_final.DB.AppDatabase;

@Entity(tableName = AppDatabase.USER_TABLE)
public class User {
    @PrimaryKey(autoGenerate = true)
    private int mUserID;

    private String mUsername;
    private String mPassword;
    private boolean mAdmin;
    private boolean mRentStatus;

    public User(String username, String password, boolean admin) {
        mUsername = username;
        mPassword = password;
        mRentStatus = false;
        mAdmin = admin;
    }

    public int getUserID() {
        return mUserID;
    }

    public void setUserID(int userID) {
        mUserID = userID;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    public boolean isAdmin() {
        return mAdmin;
    }

    public void setAdmin(boolean admin) {
        mAdmin = admin;
    }

    public boolean isRentStatus() {
        return mRentStatus;
    }

    public void setRentStatus(boolean rentStatus) {
        mRentStatus = rentStatus;
    }

    @Override
    public String toString() {
        return "User{" +
                "UserID=" + mUserID +
                ", Username='" + mUsername + '\'' +
                ", Password='" + mPassword + '\'' +
                ", Admin=" + mAdmin +
                ", CurrentlyRenting=" + mRentStatus +
                '}';
    }
}

