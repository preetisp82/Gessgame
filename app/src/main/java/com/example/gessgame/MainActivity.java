package com.example.gessgame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int randumnum;
    public void Onclick(View view){
        EditText editText= findViewById(R.id.editTextNumber);
        int enterdnum=Integer.parseInt(editText.getText().toString());
        String message;

        if(enterdnum < randumnum){
            message = "Enter Higher Number";
        }
        else if (enterdnum > randumnum){
            message = "Enter Lower Number";
        }
        else {
            message = "U got it right";
            Button playagainbutton = findViewById(R.id.button2);
            playagainbutton.setVisibility(View.VISIBLE);
            playagainbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    generaterandomnum();
                    Onclick(v);
                    playagainbutton.setVisibility(View.INVISIBLE);
                }
            });
        }
        Snackbar.make(view,message,Snackbar.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generaterandomnum();

        Button playagainbutton = findViewById(R.id.button2);
        playagainbutton.setVisibility(View.INVISIBLE);

    }
    public static class ShowSnackBar {
        public static void show(Context context, String message, View view) {
            InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show();
        }
    }

    private void generaterandomnum() {
        Random random = new Random();
        randumnum = random.nextInt(20)+1;
    }
}