package com.example.myapplication;




import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Random random = new Random();
    private TextView topNumberTextView;
    private TextView bottomNumberTextView;
    private TextView answerTextView;
    private TextView mis,tru;
    int sum1=0,sum2=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        topNumberTextView = findViewById(R.id.r1);
        bottomNumberTextView = findViewById(R.id.r2);
        answerTextView = findViewById(R.id.res);
        mis = findViewById(R.id.mis);
        tru = findViewById(R.id.tru);

        Button basicButton = findViewById(R.id.ez);
        Button mediumButton = findViewById(R.id.mid);
        Button professionalButton = findViewById(R.id.hard);




        basicButton.setOnClickListener(view -> generateRandomNumbers("BASIC"));
        mediumButton.setOnClickListener(view -> generateRandomNumbers("MEDIUM"));
        professionalButton.setOnClickListener(view -> generateRandomNumbers("PROFESSIONAL"));




    }

    private void generateRandomNumbers(String level) {
        int maxRange;
        int minRange;
        if(level.equals("BASIC")){

            maxRange=(int)(Math.random()*11);
            minRange=(int)(Math.random()*11);
            topNumberTextView.setText(String.valueOf(maxRange));
            bottomNumberTextView.setText(String.valueOf(minRange));
        }
        if(level.equals("MEDIUM")){
            maxRange=(int)((Math.random()*11)+10);
            minRange=(int)(Math.random()*11);
            topNumberTextView.setText(String.valueOf(maxRange));
            bottomNumberTextView.setText(String.valueOf(minRange));
        }
        if(level.equals("PROFESSIONAL")){
            maxRange=(int)((Math.random()*100)+10);
            minRange=(int)((Math.random()*100)+10);
            topNumberTextView.setText(String.valueOf(maxRange));
            bottomNumberTextView.setText(String.valueOf(minRange));

        }
    }



    public void chechAns(View view) {

        int userAnswer = Integer.parseInt(answerTextView.getText().toString());
        int correctAnswer = Integer.parseInt(topNumberTextView.getText().toString()) * Integer.parseInt(bottomNumberTextView.getText().toString());
        if(userAnswer==correctAnswer){
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
            sum1++;
            tru.setText(String.valueOf(sum1));
        }
        else {

            Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();
            sum2++;
            mis.setText(String.valueOf(sum2));
      }
}


}

