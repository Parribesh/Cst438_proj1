package com.example.cst438_proj1;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SearchResults extends AppCompatActivity {
    /**
     * Display jobs depending on criteria put in SearchJobs
     *
     */
    private TextView results;
    private TextView topMsg;
    private Button backBtn;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_search_results);

        results = findViewById(R.id.result);
        topMsg = findViewById(R.id.welcomeMsg);
        backBtn = findViewById(R.id.backBtn);

        topMsg.setText("Results:");
        topMsg.setTextSize(20);

        backBtn.setOnClickListener(view -> {
            Intent intent = new Intent(SearchResults.this, SearchJobs.class);
            startActivity(intent);
        });
    }
}
