package com.example.guest.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    @Bind(R.id.adjective) EditText mAdjective;
    @Bind(R.id.gerund) EditText mGerund;
    @Bind(R.id.name) EditText mName;
    @Bind(R.id.color) EditText mColor;
    @Bind(R.id.submitWords) Button mSubmitWords;
    int radioValue=0;

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_story1:
                if (checked)
                    radioValue = 0;
                break;
            case R.id.radio_story2:
                if (checked)
                    radioValue = 1;
                break;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mSubmitWords.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String adjective = mAdjective.getText().toString();
                String gerund = mGerund.getText().toString();
                String name = mName.getText().toString();
                String color = mColor.getText().toString();
                if (adjective.matches("") || gerund.matches("") || name.matches("") || color.matches("")) {
                    Toast.makeText(MainActivity.this, "You forgot a field!", Toast.LENGTH_SHORT).show();
                    return;
                }
                String [] userWords = new String [] {adjective, gerund, name, color};
                Intent intent = new Intent(MainActivity.this, StoryActivity.class);
                intent.putExtra("userWords", userWords);
                intent.putExtra("radioValue", radioValue);
                startActivity(intent);
                mAdjective.setText("");
                mGerund.setText("");
                mName.setText("");
                mColor.setText("");
            }
        });
    }
}
