package com.example.jessie.storytime.UI;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jessie.storytime.Model.Page;
import com.example.jessie.storytime.Model.Story;
import com.example.jessie.storytime.R;

public class StoryActivity extends AppCompatActivity {

    private String name;
    public static final String TAG = StoryActivity.class.getSimpleName();
    private Story mStory;
    private ImageView storyImageView;
    private TextView storyTextView;
    private Button choice1Button;
    private Button choice2Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        // Initialize our views
        storyImageView = (ImageView) findViewById(R.id.storyImageView);
        storyTextView = (TextView) findViewById(R.id.storyTextView);
        choice1Button = (Button) findViewById(R.id.choice1Button);
        choice2Button = (Button) findViewById(R.id.choice2Button);

        // Lets get the intent and extra that was used to start this activity
        Intent intent = getIntent();
        name = intent.getStringExtra(getString(R.string.key_name));

        // Null string handling
        if (name == null || name.isEmpty()){
            name = "Friend";
        }

        // Checking the intent - Testing
        Log.d(TAG, name);
        mStory = new Story();
        loadPage(0);
    }

    // method for loading the right page of the story
    private void loadPage(int pageNumber) {
        final Page page = mStory.getPage(pageNumber);
        Drawable image = ContextCompat.getDrawable(this,page.getImageId());
        storyImageView.setImageDrawable(image);

        // get the story text and stores it
        String pageText = getString(page.getTextId());

        // format pageText to replace the format strings with "name", if there are any,
        // then stores it back into pageText
        pageText = String.format(pageText, name);
        storyTextView.setText(pageText);

        // Check to see if we reached the end of the story
    if (page.isFinalPage()){
        choice1Button.setVisibility(View.INVISIBLE);
        choice2Button.setText(R.string.start_over_button);
        choice2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadPage(0);
            }
        });  
    } else {
        loadButton(page);
    }
}
    // Method to set the buttons up, make them functional, and hide them when needed
    private void loadButton(final Page page) {
        choice1Button.setVisibility(View.VISIBLE);
        choice1Button.setText(page.getChoice1().getTextId());
        choice1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nextPage = page.getChoice1().getNextPage();
                loadPage(nextPage);
            }
        });
        choice2Button.setVisibility(View.VISIBLE);
        choice2Button.setText(page.getChoice2().getTextId());
        choice2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nextPage = page.getChoice2().getNextPage();
                loadPage(nextPage);
            }
        });
    }
}
