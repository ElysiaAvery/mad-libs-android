package com.example.guest.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    @Bind(R.id.noun) EditText mNoun;
    @Bind(R.id.verb) EditText mVerb;
    @Bind(R.id.name) EditText mName;
    @Bind(R.id.color) EditText mColor;
    @Bind(R.id.submitWords) Button mSubmitWords;
    private EditText [] wordTypes = new EditText [] {mNoun, mVerb, mName, mColor};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mSubmitWords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String noun = mNoun.getText().toString();
                String verb = mVerb.getText().toString();
                String name = mName.getText().toString();
                String color = mColor.getText().toString();
                String [] userWords = new String [] {noun, verb, name, color};
                Intent intent = new Intent(MainActivity.this, StoryActivity.class);
                intent.putExtra("userWords", userWords);
                startActivity(intent);
                mNoun.setText("");
                mVerb.setText("");
                mName.setText("");
                mColor.setText("");
            }
        });
    }
}
