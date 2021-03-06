package com.example.ember.disaster_checklist_v2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class home_page extends AppCompatActivity {
    private static final String TAG = "home_page";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Log.d(TAG, "onCreate: Starting.");
        Button checklist = findViewById(R.id.checklist_button);
        checklist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: CLicked Checklist.");
                Intent intent = new Intent(home_page.this, itemRecyclerView.class);
                startActivity(intent);
            }
        });
        Button newList = findViewById(R.id.addItemsButton);
        newList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: CLicked new list.");
                Intent intent = new Intent(home_page.this, personalized_list.class);
                startActivity(intent);
            }
        });
        Button clear = findViewById(R.id.clear_Data);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences mPreference = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

                Log.d(TAG, "clear: clearing");
                SharedPreferences.Editor preferencesEditor = mPreference.edit();
                preferencesEditor.putBoolean("clear", false);
                preferencesEditor.clear();
                preferencesEditor.apply();
            }
        });
        Button quantity = findViewById(R.id.quantity);
        quantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: CLicked how many.");
                Intent intent = new Intent(home_page.this, Quantity.class);
                startActivity(intent);
            }
        });
    }
}
