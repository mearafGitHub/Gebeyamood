package com.example.gebeya_mood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;


public class MoodPromptActivity extends AppCompatActivity {

    //@BindView(R.id.happyMood)
    private ImageButton happyMood;
   // @BindView(R.id.sadMood)
    private ImageButton sadMood;
   // @BindView(R.id.mehMood)
    private ImageButton mehMood;
   // @BindView(R.id.angryMood)
    private ImageButton angryMood;
  //  @BindView(R.id.whateverMood)
    private ImageButton whateverMood;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_prompt);

        happyMood = findViewById(R.id.happyMood);
        sadMood = findViewById(R.id.sadMood);
        mehMood = findViewById(R.id.mehMood);
        angryMood = findViewById(R.id.angryMood);
        whateverMood = findViewById(R.id.whateverMood);

        happyMood.setOnClickListener(v -> Toast.makeText(MoodPromptActivity.this, "Glad you are Happy.", Toast.LENGTH_LONG).show());

        sadMood.setOnClickListener(v -> Toast.makeText(MoodPromptActivity.this, "sorry you are Sad.", Toast.LENGTH_LONG).show());

        mehMood.setOnClickListener(v -> Toast.makeText(MoodPromptActivity.this, "Oh, you are bord.", Toast.LENGTH_LONG).show());

        angryMood.setOnClickListener(v -> Toast.makeText(MoodPromptActivity.this, "Angry? What's it", Toast.LENGTH_LONG).show());

        whateverMood.setOnClickListener(v -> Toast.makeText(MoodPromptActivity.this, "Whatever ?", Toast.LENGTH_LONG).show());

    }
}
