package com.example.cst338fa23_project2_libraryapplication_final;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                mUserDAO.insert(mTestNormUser);
                mUserDAO.insert(mTestAdminUser);
                return null;
            }

            protected void onPostExecute(Void result) {
                //AppDatabase.clearDatabase(mAppDatabase);
                getDatabase();
                wireUpDisplay();
                loggingIn();
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

    private boolean checkForUserInDatabase() {
        mUser = mUserDAO.getUserByUsername(mUsername);
        if (mUser == null) {
            mUsernameField.setError("No user: " + mUsername + " found");
            return false;
        }

        return true;
    }

    private boolean validatePassword() {return mUser.getPassword().equals(mPassword);}

    private void loggingIn() {
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getValuesFromDisplay();
                if (checkForUserInDatabase()) {
                    if (!validatePassword()) {
                        mPasswordField.setError("Invalid Password");
                    }

                    else {
                        if (mUser.isAdmin()) {
                            Toast.makeText(LoginActivity.this,
                                    "Correct Password & is Admin", Toast.LENGTH_SHORT).show();
                        }

                        else {
                            Toast.makeText(LoginActivity.this,
                                    "Correct password, but not admin", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
    }
}