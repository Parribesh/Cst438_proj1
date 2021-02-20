package com.example.cst438_proj1;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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
    private TextView results;
    private TextView topMsg;
    private Button backBtn;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        SeachCred search = new SeachCred("Teacher", "Salinas");
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_search_results);

        results = findViewById(R.id.result);
        topMsg = findViewById(R.id.welcomeMsg);
        backBtn = findViewById(R.id.backBtn);

        topMsg.setText("Results:");
        topMsg.setTextSize(20);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jooble.org/api")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PlaceHolderAPI jsonPlaceHolder = retrofit.create(PlaceHolderAPI.class);
        Call<List<SeachCred>> call = jsonPlaceHolder.getSearchInfo(API_KEY, search);

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
                    results.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<SeachCred>> call, Throwable t) {

            }
        });
        backBtn.setOnClickListener(view -> {
            Intent intent = new Intent(SearchResults.this, SearchJobs.class);
            startActivity(intent);
        });
    }
}
