package com.example.finalprojectandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;



public class MainActivity extends AppCompatActivity {
ArrayList<Question> questions=new ArrayList<>();
String correctOption,selectedOption;
ArrayList<Integer> randoms;
int qindex=0,track=0,score=0;
    Button btnNextQuestion,btnOption1,btnOption2,btnOption3,btnOption4;
    TextView txtQuestion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         txtQuestion=findViewById(R.id.lblQuestion);
         btnOption1=findViewById(R.id.btnOption1);
         btnOption2=findViewById(R.id.btnOption2);
         btnOption3=findViewById(R.id.btnOption3);
         btnOption4=findViewById(R.id.btnOption4);
        btnNextQuestion=findViewById(R.id.btnNextQuestion);
        generateRandomNumbers();

    fillData();
        showQuestion();
btnOption1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        selectedOption=btnOption1.getText().toString();
        btnOption2.setVisibility(View.INVISIBLE);
        btnOption3.setVisibility(View.INVISIBLE);
        btnOption4.setVisibility(View.INVISIBLE);
        validateAnswer();
    }
});btnOption2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedOption=btnOption2.getText().toString();
                btnOption1.setVisibility(View.INVISIBLE);
                btnOption3.setVisibility(View.INVISIBLE);
                btnOption4.setVisibility(View.INVISIBLE);
                validateAnswer();

            }
        });
btnOption3.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        selectedOption=btnOption3.getText().toString();
        btnOption2.setVisibility(View.INVISIBLE);
        btnOption1.setVisibility(View.INVISIBLE);
        btnOption4.setVisibility(View.INVISIBLE);
        validateAnswer();
    }
});
btnOption4.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        selectedOption=btnOption4.getText().toString();
        btnOption2.setVisibility(View.INVISIBLE);
        btnOption3.setVisibility(View.INVISIBLE);
        btnOption1.setVisibility(View.INVISIBLE);
        validateAnswer();
    }
});
btnNextQuestion.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        track += 1;
        if (track < 5) {
            btnOption1.setVisibility(View.VISIBLE);
            btnOption2.setVisibility(View.VISIBLE);
            btnOption3.setVisibility(View.VISIBLE);
            btnOption4.setVisibility(View.VISIBLE);
            showQuestion();
        }else {
            btnOption1.setVisibility(View.INVISIBLE);
            btnOption2.setVisibility(View.INVISIBLE);
            btnOption3.setVisibility(View.INVISIBLE);
            btnOption4.setVisibility(View.INVISIBLE);
txtQuestion.setText("Score: "+score);
switch (score){
    case 0:
        btnNextQuestion.setText("Please try again");
        break;
    case 1:
        btnNextQuestion.setText("Please try again");

        break;
    case 2:
        btnNextQuestion.setText("Please try again");

        break;
    case 3:
        btnNextQuestion.setText("Good job");

        break;

    case 4:
        btnNextQuestion.setText("Excellent work");

        break;
    case 5:
        btnNextQuestion.setText("You are genius");

        break;
    default:
        break;
}
        }
    }
});
    }

    private void showQuestion() {
        if (track < 5) {
            System.out.println(track);
            qindex = (randoms.get(track));
            txtQuestion.setText(questions.get((qindex) - 1).getQuestion());
            btnOption1.setText(questions.get((qindex) - 1).getOp1());
            btnOption2.setText(questions.get((qindex) - 1).getOp2());
            btnOption3.setText(questions.get((qindex) - 1).getOp3());
            btnOption4.setText(questions.get((qindex) - 1).getOp4());
            correctOption = questions.get((qindex) - 1).getOpC();
            btnNextQuestion.setVisibility(View.INVISIBLE);

        }
    }
    private void generateRandomNumbers() {
        Random randNum = new Random();
        Set<Integer>set = new LinkedHashSet<Integer>();

        while (set.size() < 5) {
            set.add(randNum.nextInt(10)+1);
        }
        System.out.println("Random numbers with no duplicates = "+set);
       randoms=new ArrayList<>(set);`

    }

    private void validateAnswer() {
        btnNextQuestion.setVisibility(View.VISIBLE);
        if (correctOption.equals(selectedOption)){
            score+=1;
            Toast.makeText(MainActivity.this, "Correct Answer", Toast.LENGTH_SHORT).show();


        }
else{
            Toast.makeText(MainActivity.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
        }
    }


    private void fillData() {
        questions.add(new Question("Which company does Mark Zukenberg own","facebook","twitter","google","tesla","facebook"));
        questions.add(new Question("Which company does elon musk own","facebook","twitter","google","tesla","tesla"));
        questions.add(new Question("Which company does Steave jobs owns","Apple","twitter","google","samsung","Apple"));
        questions.add(new Question("Which company does bill gates owns","facebook","microsoft","google","telsa","microsoft"));
        questions.add(new Question("Which company does warren Buffett owns","facebook","twitter","Gillet","nokia","Gillet"));
        questions.add(new Question("Which company does  larry page owns","facebook","twitter","google","telsa","google"));
        questions.add(new Question("Which company does jack dorsey owns","facebook","twitter","google","telsa","twitter"));
        questions.add(new Question("Which company does rathan tata owns","facebook","twitter","google","tata","tata"));
        questions.add(new Question("Which company does mukesh ambhani owns","reliance","twitter","tata","Gillet","reliance"));
        questions.add(new Question("Which company does jack ma owns","reliance","twitter","ali baba","telsa","ali baba"));

    }

}