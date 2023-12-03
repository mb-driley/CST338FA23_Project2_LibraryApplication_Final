package com.example.cst338fa23_project2_libraryapplication_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.cst338fa23_project2_libraryapplication_final.DB.User;
import com.example.cst338fa23_project2_libraryapplication_final.DB.UserDAO;
import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {

    private static UserDAO mUserDAO;
    private static User mUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static Intent intentFactory(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    public static Intent intentFactory(Context context, int passedInUserID) {
        Intent intent = new Intent(context, MainActivity.class);
        mUser = mUserDAO.getUserByID(passedInUserID);
        return intent;
    }
}