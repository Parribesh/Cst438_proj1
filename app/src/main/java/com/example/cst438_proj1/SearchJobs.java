package com.example.cst438_proj1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SearchJobs extends AppCompatActivity {

    private static final String ACTIVITY_LABEL ="HOME_ACTIVITY_COM_PNEUP" ;

    private String keyword;
    private String location;
    private int radius;

    /**
     * Type in Search bar
     * Try to integrate dropdown menu 
     * switch to a view that shows results?
     */

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public static Intent getIntent(Context context, String value ){
        Intent intent = new Intent(context, SearchJobs.class);
        intent.putExtra(SearchJobs.ACTIVITY_LABEL, value);
        return intent;
    }
}
