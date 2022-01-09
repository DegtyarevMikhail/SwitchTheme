package ru.gb.switchtheme;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.switchmaterial.SwitchMaterial;

public class ActivityHome<intent> extends AppCompatActivity {

    private static String cTheme;

    //Variables
    SwitchMaterial mySwitch;
    ThemeSharedPref sharedpref;

    private MaterialButton MainButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        //Checking that state true or false from SharedPref
        sharedpref = new ThemeSharedPref(this);

        setTheme(sharedpref.isNightMode()? R.style.ThemeNight : R.style.ThemeDay);
        super.onCreate(savedInstanceState);

        //Displaying the layout after setting the theme
        setContentView(R.layout.activity_home);

        MainButton = findViewById(R.id.go_Button);
        MainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityHome.this, MainActivity.class);
                startActivity(intent);
            }
        });


        mySwitch= findViewById(R.id.mySwitch);
        if (sharedpref.isNightMode()) {
            mySwitch.setChecked(true);
        }

        //Checking the toggle state and saving it to the SharedPref
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    sharedpref.setNightModeState(true);
                    restartApp();
                }
                else {
                    sharedpref.setNightModeState(false);
                    restartApp();
                }
            }
        });
    }

    //Method to restart the app
    public void restartApp() {
        Intent restartApp = new Intent(getApplicationContext(), ActivityHome.class);
        startActivity(restartApp);
        finish();
    }






}