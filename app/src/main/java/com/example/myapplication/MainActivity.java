package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private final static String PREFS_KEY = "shared_prefs";
    private final static String BUTTON_PRESSED = "button_pressed";
    private final static String BUTTON_PRESSED2 = "button2_pressed";
    private final static String BUTTON_PRESSED3 = "button3_pressed";


    private SharedPreferences prefs;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        prefs = getSharedPreferences(PREFS_KEY, Context.MODE_PRIVATE);


        notificaitons();


        boolean first = prefs.getBoolean("first", true);
        if(first) {
            prefs.edit().putBoolean(BUTTON_PRESSED, false).apply();
              prefs.edit().putBoolean(BUTTON_PRESSED2, false).apply();
               prefs.edit().putBoolean(BUTTON_PRESSED3, true).apply();

            prefs.edit().putBoolean("first", false).apply();

        }



        }
   // start();

    public void start(){
            final Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

            final Button btn = findViewById(R.id.btnMorn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btn.setBackground(getResources().getDrawable(R.drawable.button_background));
                    btn.setEnabled(false);
                    prefs.edit().putBoolean(BUTTON_PRESSED, true).apply();
                    if (vibe != null) {
                        vibe.vibrate(100);
                    }

                }
            });

            final Button btn2 = findViewById(R.id.eveBtn);
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btn2.setBackground(getResources().getDrawable(R.drawable.button_background));
                    btn2.setEnabled(false);

                    prefs.edit().putBoolean(BUTTON_PRESSED2, true).apply();
                    if (vibe != null) {
                        vibe.vibrate(100);
                    }


                }
            });
            Button btn3 = findViewById(R.id.resetBtn);
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btn.setEnabled(true);
                    btn.setBackground(getResources().getDrawable(R.drawable.button_on));
                    btn2.setEnabled(true);
                    btn2.setBackground(getResources().getDrawable(R.drawable.button_on));
                    prefs.edit().putBoolean(BUTTON_PRESSED, false).apply();
                    prefs.edit().putBoolean(BUTTON_PRESSED2, false).apply();

                }
            });

            if(prefs.getBoolean(BUTTON_PRESSED, true)){
                btn.setBackground(getResources().getDrawable(R.drawable.button_background));
                btn.setEnabled(false);
                prefs.edit().putBoolean(BUTTON_PRESSED3, false).apply();


            }
            if(prefs.getBoolean(BUTTON_PRESSED2, true)) {
                btn2.setBackground(getResources().getDrawable(R.drawable.button_background));
                btn2.setEnabled(false);
                prefs.edit().putBoolean(BUTTON_PRESSED3, false).apply();
            }
            if(prefs.getBoolean(BUTTON_PRESSED3, true)){
                btn.setBackground(getResources().getDrawable(R.drawable.button_on));
                btn.setEnabled(true);
                btn2.setEnabled(true);
                btn2.setBackground(getResources().getDrawable(R.drawable.button_on));
                prefs.edit().putBoolean(BUTTON_PRESSED, false).apply();
                prefs.edit().putBoolean(BUTTON_PRESSED2, false).apply();
            }
    }

    public void notificaitons(){


    }



    }


