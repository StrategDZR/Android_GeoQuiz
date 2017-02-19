package com.example.strategdzr.geoquiz;

/**
 * Created by StrategDZR on 21.01.2017
 */
class Question {
    private int mTextResId;
    private boolean mAnswerTrue;

    public Question(int textResId, boolean answerTrue) {
        mTextResId = textResId;
        mAnswerTrue = answerTrue;
    }

    public int getTextResId() {
        return mTextResId;
    }

// --Commented out by Inspection START (19.02.2017 12:43):
//    public void setTextResId(int textResId) {
//        mTextResId = textResId;
//    }
// --Commented out by Inspection STOP (19.02.2017 12:43)

    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

// --Commented out by Inspection START (19.02.2017 12:42):
//    public void setAnswerTrue(boolean answerTrue) {
//        mAnswerTrue = answerTrue;
//    }
// --Commented out by Inspection STOP (19.02.2017 12:42)
}
