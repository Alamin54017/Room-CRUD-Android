package com.example.testingapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testingapp.Model.User;
import com.example.testingapp.R;
import com.example.testingapp.UserActivity;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    Context context;
    List<User> list;

    public UserAdapter(Context context, List<User> list) {
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public UserAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.carddesign, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.UserViewHolder holder, int position) {
        holder.id.setText(String.valueOf(list.get(position).getUid()));
        holder.fname.setText(list.get(position).getFirstName());
        holder.lname.setText(list.get(position).getLastName());

        String id=String.valueOf(list.get(position).getUid());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, UserActivity.class).putExtra("id",id));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        TextView id,fname,lname;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.uid);
            fname = itemView.findViewById(R.id.fname);
            lname = itemView.findViewById(R.id.lname);
        }
    }
}
