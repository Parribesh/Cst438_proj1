package com.example.cst438_proj1;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SearchResults extends AppCompatActivity {
    /**
     * Display jobs depending on criteria put in SearchJobs
     *
     */
    private TextView results;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_search_results);

    }
}
