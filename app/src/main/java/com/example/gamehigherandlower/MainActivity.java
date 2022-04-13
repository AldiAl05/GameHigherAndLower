package com.example.gamehigherandlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        Random rand = new Random();
        randomNumber = rand.nextInt(20) + 1; //untuk batas sampai 20
    }

    int randomNumber;

    public void randomNumberGenerator() { //untuk repeat game
        Random rand = new Random();
        randomNumber = rand.nextInt(20) + 1;
    }


    public void onGuess (View view) {
        String message = "";
        try {
            EditText editTextNumber = (EditText) findViewById(R.id.editTextNumber);
            int guessedNumber = Integer.parseInt(editTextNumber.getText().toString());

            if (guessedNumber < 1 || guessedNumber > 20) {
                message = "kamu harus memasukan angka dari 1 sampai 20 !!";
            } else if (guessedNumber < randomNumber) {
                message = "Nilai terlalu rendah !!!";
            } else if (guessedNumber > randomNumber) {
                message = "Nilai terlalu tinggi !!!";
            }else {
                message = "You Got Me !!!";
                randomNumberGenerator(); //pengaplikasian yang berulang sampai bertemu dengan solusinya
            }
        } catch (Exception e){
            message = "tidak boleh kosong";
        } finally {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }
}
