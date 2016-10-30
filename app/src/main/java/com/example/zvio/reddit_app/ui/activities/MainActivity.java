package com.example.zvio.reddit_app.ui.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.zvio.reddit_app.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button buttonWalpapers, buttonGifs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonWalpapers = (Button)findViewById(R.id.buttonWallpapers);
        buttonGifs = (Button)findViewById(R.id.buttonGifs);

        buttonGifs.setOnClickListener(this);
        buttonWalpapers.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.buttonGifs:
                break;
            case R.id.buttonWallpapers:

                startActivity(new Intent(this,Wallpapers_Activity.class));
                break;
        }
    }
}
