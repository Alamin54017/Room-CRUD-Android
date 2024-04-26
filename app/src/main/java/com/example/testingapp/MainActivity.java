package com.example.testingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.testingapp.Dao.UserDao;
import com.example.testingapp.Database.AppDatabase;
import com.example.testingapp.Model.User;

public class MainActivity extends AppCompatActivity {

    EditText fname,Lname;
    Button add,view,update,delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fname = findViewById(R.id.editTextText);
        Lname = findViewById(R.id.editTextText2);
        add=findViewById(R.id.button);
        view = findViewById(R.id.button2);
        update = findViewById(R.id.button4);
        delete = findViewById(R.id.button5);
        AppDatabase db = AppDatabase.getInstance(this);

        UserDao userDao = db.userDao();

        add.setOnClickListener(v -> {
                   if(fname.getText().toString().isEmpty() || Lname.getText().toString().isEmpty()){
                       Toast.makeText(getApplicationContext(),"Please enter all fields",Toast.LENGTH_SHORT).show();
                   }
                   else {
                       userDao.insertAll(new User(fname.getText().toString(),Lname.getText().toString()));
                       Toast.makeText(MainActivity.this, "Successfully Added", Toast.LENGTH_LONG).show();
                   }
                });

        view.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this,AllUserActivity.class));
                });


        update.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this,UpdateUserActivity.class));
        });

        delete.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this,DeleteUserActivity.class));
        });

        /*List<User> users = userDao.getAll();

        TextView text=findViewById(R.id.text);
        text.setText(users.get(0).getFirstName().toString());*/





        

    }

}