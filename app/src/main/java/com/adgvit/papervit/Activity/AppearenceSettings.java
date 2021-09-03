package com.adgvit.papervit.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.adgvit.papervit.R;

public class AppearenceSettings extends AppCompatActivity {

    ImageView backImageView;

    RadioButton deafult, light, dark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appearence_settings);

        SharedPreferences sharedPreferences1 = getSharedPreferences("com.adgvit.papervit.theme",MODE_PRIVATE);
        if(sharedPreferences1 != null)
        {
            if(sharedPreferences1.getString("CurrentTheme","").equals("Def"))
            {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
            }
            else if(sharedPreferences1.getString("CurrentTheme","").equals("Light"))
            {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
            else if(sharedPreferences1.getString("CurrentTheme","").equals("Dark"))
            {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
        }


//        Window window = getWindow();
//        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//        window.setStatusBarColor(getResources().getColor(R.color.backgroundLight));

        backImageView = findViewById(R.id.backImageView);
        backImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        deafult = findViewById(R.id.deafultButton);
        light = findViewById(R.id.lightButton);
        dark = findViewById(R.id.darkButton);

        SharedPreferences sharedPreferences = getSharedPreferences("AppTheme",MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();

        if(sharedPreferences != null)
        {
            if(sharedPreferences.getString("CurrentTheme","").equals("Def"))
            {
                deafult.setChecked(true);
            }
            else if(sharedPreferences.getString("CurrentTheme","").equals("Light"))
            {
                light.setChecked(true);
            }
            else if(sharedPreferences.getString("CurrentTheme","").equals("Dark"))
            {
                dark.setChecked(true);
            }
        }

        if (sharedPreferences.getString("CurrentTheme","").equals(""))
        {
            deafult.setChecked(true);
        }

        deafult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                light.setChecked(false);
                deafult.setChecked(true);
                dark.setChecked(false);

                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                myEdit.putString("theme", "sys_def");
                myEdit.apply();

            }
        });

        light.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                light.setChecked(true);
                deafult.setChecked(false);
                dark.setChecked(false);

                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                myEdit.putString("theme", "light");
                myEdit.apply();

            }
        });

        dark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                light.setChecked(false);
                deafult.setChecked(false);
                dark.setChecked(true);

                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                myEdit.putString("theme", "dark");
                myEdit.apply();

            }
        });

    }
}