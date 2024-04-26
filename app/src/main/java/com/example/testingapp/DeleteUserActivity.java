package com.example.testingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.testingapp.Dao.UserDao;
import com.example.testingapp.Database.AppDatabase;
import com.example.testingapp.Model.User;

public class DeleteUserActivity extends AppCompatActivity {

    EditText id;
    Button delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_user);

        id = findViewById(R.id.uid);
        delete = findViewById(R.id.delete);

        AppDatabase db = AppDatabase.getInstance(this);

        UserDao userDao = db.userDao();
        delete.setOnClickListener(v -> {
            User user=new User();
            user.setUid(Integer.parseInt(id.getText().toString()));
            userDao.delete(user);
            Toast.makeText(DeleteUserActivity.this, "Successfully Deleted", Toast.LENGTH_SHORT).show();
        });
    }
}