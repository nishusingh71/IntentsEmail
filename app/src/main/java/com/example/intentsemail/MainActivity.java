package com.example.intentsemail;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.app.usage.UsageEvents;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.CalendarContract;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.time.Instant;

public class MainActivity extends AppCompatActivity {
    EditText editTextSearch;
    Button buttonSearcher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextSearch=findViewById(R.id.edit_search);
        buttonSearcher=findViewById(R.id.button_search);

        buttonSearcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchWeb();
            }
        });
    }
    private void searchWeb() {
        String query=editTextSearch.getText().toString();
        Intent intentSearch=new Intent(Intent.ACTION_WEB_SEARCH);
        intentSearch.putExtra(SearchManager.QUERY,query);
        if (intentSearch.resolveActivity(getPackageManager()) != null) {
            startActivity(intentSearch);
        }
    }
}