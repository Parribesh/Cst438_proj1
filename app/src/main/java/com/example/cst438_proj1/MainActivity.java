package com.example.cst438_proj1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.cst438_proj1.data.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);

        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);

  //     recyclerAdapter = new RecyclerAdapter();
//       recyclerView.setLayoutManager(new LinearLayoutManager(this));
  //    recyclerView.setAdapter(recyclerAdapter);



    }

}