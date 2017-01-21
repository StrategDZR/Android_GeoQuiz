package com.example.strategdzr.geoquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private TextView mQuestionTextView; //create fields
    private Button mTrueButton;
    private Button mFalseButton;
    private ImageButton mNextButton;
    private ImageButton mPrevButton;
    private Question[] mQuestionBank = new Question[]{
            new Question(R.string.q_oceans, true),
            new Question(R.string.q_mideast, false),
            new Question(R.string.q_africa, false),
            new Question(R.string.q_americas, true),
            new Question(R.string.q_asia, true),
    };
    private int mCurrentIndex = 0;

    private void checkAnswer(boolean userPressedTrue) { //show toast about correct or incorrect answer
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();
        int messageResId = 0;
        if (userPressedTrue == answerIsTrue) {
            messageResId = R.string.correct_toast;
        } else {
            messageResId = R.string.incorrect_toast;
        }
    }

    private void update_question() { //display text (in TextView) which find by textResId in array
        try {
            int question = mQuestionBank[mCurrentIndex].getTextResId();
            mQuestionTextView.setText(question);
        } catch (ArrayIndexOutOfBoundsException e) { //when try tap on PrevButton on first question
            e.printStackTrace();
            Toast.makeText(this, "No questions before!",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mTrueButton = (Button) findViewById(R.id.true_button); //init and find objects
        mFalseButton = (Button) findViewById(R.id.false_button);
        mNextButton = (ImageButton) findViewById(R.id.next_button);
        mPrevButton = (ImageButton) findViewById(R.id.prev_button);
        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);

        mTrueButton.setOnClickListener(new View.OnClickListener() { //set listeners
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                update_question();
            }
        });
        mPrevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex - 1) % mQuestionBank.length;
                update_question();
            }
        });
        mQuestionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                update_question();
            }
        });

        update_question();
    }
}
