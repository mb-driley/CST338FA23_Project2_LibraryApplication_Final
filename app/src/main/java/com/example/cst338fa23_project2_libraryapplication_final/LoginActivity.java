package com.example.cst338fa23_project2_libraryapplication_final;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.cst338fa23_project2_libraryapplication_final.DB.AppDatabase;
import com.example.cst338fa23_project2_libraryapplication_final.DB.User;
import com.example.cst338fa23_project2_libraryapplication_final.DB.UserDAO;
import com.example.myapplication.R;

public class LoginActivity extends AppCompatActivity {
    private EditText mUsernameField, mPasswordField;
    private String mUsername, mPassword;
    private Button mLoginButton;
    private UserDAO mUserDAO;
    private User mUser;
    private final User mTestNormUser = new User("testuser1", "testuser1", false);
    private final User mTestAdminUser = new User("admin2", "admin2", true);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        AppDatabase mAppDatabase = AppDatabase.getInstance(this);
        mUserDAO = mAppDatabase.UserDAO();

        getDatabase();
        wireUpDisplay();

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void...voids) {
                mUserDAO.insert(mTestNormUser);
                mUserDAO.insert(mTestAdminUser);
                return null;
            }
        }.execute();

    }

    private void getDatabase() {
        mUserDAO = AppDatabase.getInstance(this).UserDAO();
    }

    private void wireUpDisplay() {
        mUsernameField = findViewById(R.id.loginUsernameEditText);
        mPasswordField = findViewById(R.id.loginPasswordEditText);
        mLoginButton = findViewById(R.id.loginButton);
    }

    private void getValuesFromDisplay() {
        mUsername = mUsernameField.getText().toString();
        mPassword = mPasswordField.getText().toString();
    }
}