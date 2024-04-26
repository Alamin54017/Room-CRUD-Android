package com.example.testingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.testingapp.Dao.UserDao;
import com.example.testingapp.Database.AppDatabase;
import com.example.testingapp.Model.User;

public class UpdateUserActivity extends AppCompatActivity {

    EditText id,fname,lname;
    Button update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user);

        id=findViewById(R.id.uid);
        fname=findViewById(R.id.fname);
        lname=findViewById(R.id.lname);
        update=findViewById(R.id.update);

        AppDatabase db = AppDatabase.getInstance(this);

        UserDao userDao = db.userDao();

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user=new User();
                user.setUid(Integer.parseInt(id.getText().toString()));
                user.setFirstName(fname.getText().toString());
                user.setLastName(lname.getText().toString());
                userDao.updateUser(user);
                Toast.makeText(UpdateUserActivity.this, "Successfully Updated", Toast.LENGTH_SHORT).show();
            }
        });


    }
}