package com.example.testingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.testingapp.Dao.UserDao;
import com.example.testingapp.Database.AppDatabase;
import com.example.testingapp.Model.User;

public class UserActivity extends AppCompatActivity {

    TextView uid,fname,lname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        String id=getIntent().getStringExtra("id");

        AppDatabase db = AppDatabase.getInstance(this);

        UserDao userDao = db.userDao();

        User user = userDao.findByID(Integer.parseInt(id));

        uid = findViewById(R.id.userid);
        fname = findViewById(R.id.firstname);
        lname = findViewById(R.id.lastname);
        uid.setText(String.valueOf(user.getUid()));
        fname.setText(user.getFirstName());
        lname.setText(user.getLastName());
    }
}