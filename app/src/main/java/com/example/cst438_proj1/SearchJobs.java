package com.example.cst438_proj1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class SearchJobs extends AppCompatActivity {

    private static final String ACTIVITY_LABEL ="HOME_ACTIVITY_COM_PNEUP" ;

    private String jobName;
    private String location;
    private int radius;
    private Button searchButton;

    private TextView mJobTitle;
    private TextView mLocation;
    /**
     * Type in Search bar
     * Try to integrate dropdown menu 
     * switch to a view that shows results?
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_jobs);
        
        mJobTitle = findViewById(R.id.jobTitle);
        mLocation = findViewById(R.id.locationName);
        searchButton = findViewById(R.id.searchBtn);
        
        searchButton.setOnClickListener(view -> {
            jobName = mJobTitle.getText().toString();
            location = mLocation.getText().toString();
            if(jobName == "" || location == ""){
                statusMessages("Missing search credentials!");
            }
            Intent intent = new Intent(SearchJobs.this, SearchResults.class);
            intent.putExtra("jobName", jobName);
            intent.putExtra("jobLocation", location);
            startActivity(intent);
        });
    }

    public static Intent getIntent(Context context, String value ) {
        Intent intent = new Intent(context, SearchJobs.class);
        intent.putExtra(SearchJobs.ACTIVITY_LABEL, value);
        return intent;
    }

    private void statusMessages(String message){
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}
