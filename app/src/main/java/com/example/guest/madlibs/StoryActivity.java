package com.example.guest.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class StoryActivity extends AppCompatActivity {
    public static final String TAG = StoryActivity.class.getSimpleName();
    @Bind(R.id.storyTextView) TextView mStoryTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String [] userWords = intent.getStringArrayExtra("userWords");
        mStoryTextView.setText("One day " + userWords[2] + " was " + userWords[1] + " and they saw a " + userWords[0] + " cat. The cat cast a spell and turned " + userWords[2] + " " + userWords[3] + ".");
        Log.i(TAG, userWords[0]);
    }
}
