package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.preference.PreferenceManager;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.Set;

public class MainActivity extends AppCompatActivity {

    public static final String GUSSES="setting_numberofGuesses";
    public static final String ANIMAL_TYPES="setting_animalsType";
    public static final String QUIZ_BACKGROUND_COLOR="setting_quiz_background_color";
    public static final String quiz_font="setting_quiz_font";

    private boolean issettingschanged=false;

    static Typeface Chunkfive;
    static Typeface FontleroyBrown;
    static Typeface WonderbarDemo;

    FirstFragment myAnimalQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Chunkfive=Typeface.createFromAsset(getAssets(),"fonts/Chunkfive.otf");
        FontleroyBrown=Typeface.createFromAsset(getAssets(),"fonts/FontleroyBrown.ttf");
        WonderbarDemo=Typeface.createFromAsset(getAssets(),"fonts/Wonderbar Demo.otf");

        PreferenceManager.setDefaultValues(MainActivity.this,R.xml.quiz_preference,false);

        PreferenceManager.getDefaultSharedPreferences(MainActivity.this)
                .registerOnSharedPreferenceChangeListener(settingsChangeListener);
//        myAnimalQuiz=(FirstFragment) getSupportFragmentManager().findFragmentById(R.id.animalQuizFragment);
//
//
//        myAnimalQuiz.modifyTypeOfAnimalsInQuiz(PreferenceManager.getDefaultSharedPreferences(MainActivity.this));
//        myAnimalQuiz.modifyQuizFont(PreferenceManager.getDefaultSharedPreferences(MainActivity.this));
//        myAnimalQuiz.modifyBGColor(PreferenceManager.getDefaultSharedPreferences(MainActivity.this));
//        myAnimalQuiz.resetAnimalQuiz();
//        issettingschanged = false;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent=new Intent(MainActivity.this,SettingsActivity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
    private SharedPreferences.OnSharedPreferenceChangeListener settingsChangeListener=new
            SharedPreferences.OnSharedPreferenceChangeListener() {
                @Override
                public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
//
//                    issettingschanged=true;
//                    if(key.equals(GUSSES)){
//                        myAnimalQuiz.modifyAnimalGuessRows(sharedPreferences);
//                        myAnimalQuiz.resetAnimalQuiz();
//                    }
//                    else if(key.equals(ANIMAL_TYPES)){
//                        Set<String> animalTypes =sharedPreferences.getStringSet(ANIMAL_TYPES,null);
//                        if(animalTypes!=null && animalTypes.size()>0)
//                        {
//                            myAnimalQuiz.modifyTypeOfAnimalsInQuiz(sharedPreferences);
//                            myAnimalQuiz.resetAnimalQuiz();
//                        }else{
//                            SharedPreferences.Editor editor= sharedPreferences.edit();
//                            animalTypes.add(getString(R.string.default_animal_type));
//                            editor.putStringSet(ANIMAL_TYPES,animalTypes);
//                            editor.apply();
//
//                            Toast.makeText(MainActivity.this,R.string.defaultanimaltypemessage,Toast.LENGTH_LONG).show();
//                        }
//                    }else if(key.equals(quiz_font)){
//                        myAnimalQuiz.modifyQuizFont(sharedPreferences);
//                        myAnimalQuiz.resetAnimalQuiz();
//                    }
//                    else if(key.equals(QUIZ_BACKGROUND_COLOR)){
//                        myAnimalQuiz.modifyBGColor(sharedPreferences);
//                        myAnimalQuiz.resetAnimalQuiz();
//                    }
//                    Toast.makeText(MainActivity.this,R.string.toast,Toast.LENGTH_SHORT).show();
                }
            };
}
