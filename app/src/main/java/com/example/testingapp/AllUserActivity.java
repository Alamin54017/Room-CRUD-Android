package com.example.testingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.testingapp.Adapter.UserAdapter;
import com.example.testingapp.Dao.UserDao;
import com.example.testingapp.Database.AppDatabase;
import com.example.testingapp.Model.User;

import java.util.ArrayList;
import java.util.List;

public class AllUserActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    UserAdapter userAdapter;
    User user;
    List<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_user);
        recyclerView = findViewById(R.id.recycler);
        userList=new ArrayList<>();
        userAdapter = new UserAdapter(this, userList);
        recyclerView.setAdapter(userAdapter);

        AppDatabase db = AppDatabase.getInstance(this);

        UserDao userDao = db.userDao();

        userList.addAll( userDao.getAll());
        //userAdapter.notifyDataSetChanged();
    }
}