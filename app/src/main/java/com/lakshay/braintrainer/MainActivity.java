package com.lakshay.braintrainer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    long x;
    int c=0;
    int y=0;
    int a,b;
    int location,incorrect;
    ArrayList<Integer> answers = new ArrayList<Integer>();
    Random rand = new Random();

    public void start(View view){
        c=0;
        y=0;
        final TextView timer = (TextView) findViewById(R.id.Timer);
        final TextView message = (TextView) findViewById(R.id.message);
        final Button playagain = (Button) findViewById(R.id.playagain);
        final Button option1 = (Button) findViewById(R.id.option1);
        final Button option2 = (Button) findViewById(R.id.option2);
        final Button option3 = (Button) findViewById(R.id.option3);
        final Button option4 = (Button) findViewById(R.id.option4);
        TextView question = (TextView) findViewById(R.id.Question);
        final TextView score = (TextView) findViewById(R.id.Score);
        option1.setEnabled(true);
        option2.setEnabled(true);
        option3.setEnabled(true);
        option4.setEnabled(true);
        new CountDownTimer(30100,1000){

            @Override
            public void onTick(long l) {
                x=(l/1000);
                if(x>9)
                    timer.setText(String.valueOf((int) x)+"s");
                else
                    timer.setText("  "+String.valueOf((int) x)+"s");
            }

            @Override
            public void onFinish() {
                message.setText("Your Final Score is "+score.getText());
                playagain.setText("Play Again");
                message.setVisibility(View.VISIBLE);
                playagain.setVisibility(View.VISIBLE);
                option1.setEnabled(false);
                option2.setEnabled(false);
                option3.setEnabled(false);
                option4.setEnabled(false);
                playagain.setEnabled(true);

            }


        }.start();
        score.setText("0");
        playagain.setEnabled(false);
        message.setVisibility(View.INVISIBLE);
        playagain.setVisibility(View.INVISIBLE);

        a=rand.nextInt(100);
        b=rand.nextInt(100);
        location = rand.nextInt(4);
        answers.clear();
        for(int i=0;i<4;i++)
        {
            if(i==location)
            {
                answers.add(a+b);
            }
            else{
                incorrect = rand.nextInt(200);
                while(incorrect==a+b)
                {
                    incorrect = rand.nextInt(200);
                }
                answers.add(incorrect);
            }
        }
        question.setText(String.valueOf(a)+"+"+String.valueOf(b));
        option1.setText(String.valueOf(answers.get(0)));
        option2.setText(String.valueOf(answers.get(1)));
        option3.setText(String.valueOf(answers.get(2)));
        option4.setText(String.valueOf(answers.get(3)));
    }
    public void game(View view)
    {
        Button option1 = (Button) findViewById(R.id.option1);
        Button option2 = (Button) findViewById(R.id.option2);
        Button option3 = (Button) findViewById(R.id.option3);
        Button option4 = (Button) findViewById(R.id.option4);
        TextView question = (TextView) findViewById(R.id.Question);
        TextView correct = (TextView) findViewById(R.id.message);
        TextView score = (TextView) findViewById(R.id.Score);
        if(view.getTag().toString().equals(Integer.toString(location)))
        {
            correct.setText("Correct!");
            y++;
        }
        else
            correct.setText("Incorrect");
        c++;
        score.setText(String.valueOf(y));
        correct.setVisibility(View.VISIBLE);
        answers.clear();
        a=rand.nextInt(100);
        b=rand.nextInt(100);
        location = rand.nextInt(4);
        for(int i=0;i<4;i++)
        {







            if(i==location)
            {
                answers.add(a+b);
            }
            else{
                incorrect = rand.nextInt(200);
                while(incorrect==a+b)
                {
                    incorrect = rand.nextInt(200);
                }
                answers.add(incorrect);
            }
        }
        question.setText(String.valueOf(a)+"+"+String.valueOf(b));
        option1.setText(String.valueOf(answers.get(0)));
        option2.setText(String.valueOf(answers.get(1)));
        option3.setText(String.valueOf(answers.get(2)));
        option4.setText(String.valueOf(answers.get(3)));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
