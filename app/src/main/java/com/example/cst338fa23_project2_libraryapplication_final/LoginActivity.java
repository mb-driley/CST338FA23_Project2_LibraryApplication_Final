package com.example.cst338fa23_project2_libraryapplication_final;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.cst338fa23_project2_libraryapplication_final.DB.User;
import com.example.cst338fa23_project2_libraryapplication_final.DB.UserDAO;
import com.example.myapplication.R;

public class LoginActivity extends AppCompatActivity {
    private EditText mUsernameField, mPasswordField;
    private String mUsername, mPassword;
    private Button mLoginButton;
    private UserDAO mUserDAO;
    private User mUser;
    private User mTestNormUser = new User("testuser1", "testuser1", false);
    private User mTestAdminUser = new User("admin2", "admin2", true);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
}