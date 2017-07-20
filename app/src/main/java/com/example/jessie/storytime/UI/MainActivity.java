package com.example.jessie.storytime.UI;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.jessie.storytime.R;

public class MainActivity extends AppCompatActivity {

    // Creating instance variables
    private EditText nameEditText;
    private Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instantiate variables
        nameEditText = (EditText) findViewById(R.id.nameEditText);
        startButton = (Button) findViewById(R.id.AdventureButton);

        // Listener for startButton
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                //Toast.makeText(MainActivity.this,name,Toast.LENGTH_LONG).show();
                startStory(name);
            }
        });
    }

    // Create a new onResume in order to clear the editText
    @Override
    protected void onResume() {
        super.onResume();
        nameEditText.setText("");
    }

    // Method for creating and sending an intent to another activity
    private void startStory(String name) {
        Intent intent = new Intent(this, StoryActivity.class);
        Resources resources = getResources();
        String key = resources.getString(R.string.key_name);
        intent.putExtra(key,name);
        startActivity(intent);
    }
}
