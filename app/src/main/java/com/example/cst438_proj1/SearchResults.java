package com.example.cst438_proj1;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchResults extends AppCompatActivity {
    /**
     * Display jobs depending on criteria put in SearchJobs
     *
     */
    private static final String API_KEY = "c7971ef2-0941-46ac-a994-feab09d3f4b8";
    private String jobDesc;
    private String jobLocation;
    private TextView results;
    private TextView topMsg;
    private Button backBtn;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_search_results);

        Bundle searchInfo = getIntent().getExtras();
        results = findViewById(R.id.result);
        topMsg = findViewById(R.id.welcomeMsg);
        backBtn = findViewById(R.id.backBtn);
        jobDesc = searchInfo.getString("jobName");
        jobLocation = searchInfo.getString("jobLocation");
        topMsg.setText("Results:");
        topMsg.setTextSize(20);

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jobs.github.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        PlaceHolderAPI jsonPlaceHolder = retrofit.create(PlaceHolderAPI.class);
        Call<List<SeachCred>> call = jsonPlaceHolder.getSearchInfo(jobDesc, jobLocation);

        call.enqueue(new Callback<List<SeachCred>>() {
            @Override
            public void onResponse(Call<List<SeachCred>> call, Response<List<SeachCred>> response) {
                if(!response.isSuccessful()){
                    results.setText("Error: " + response.code());
                    return;
                }
                List<SeachCred> posts = response.body();
                for(SeachCred s : posts){
                    String content = "";
                    content += s.getJobName() + "\n";
                    content += s.getLocation() + "\n";
                    content += s.getDesc() + "\n";
                    results.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<SeachCred>> call, Throwable t) {
                results.setText(t.getMessage());
            }
        });
        backBtn.setOnClickListener(view -> {
            Intent intent = new Intent(SearchResults.this, SearchJobs.class);
            startActivity(intent);
        });
    }
}
