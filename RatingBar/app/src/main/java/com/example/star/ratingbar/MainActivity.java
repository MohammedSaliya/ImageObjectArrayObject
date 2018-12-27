package com.example.star.ratingbar;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RatingBar rating;
    Button rat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rating = findViewById(R.id.rating);

        rat = findViewById(R.id.rat);

        rating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {


                LayerDrawable stars = (LayerDrawable) rating.getProgressDrawable();
                stars.getDrawable(2).setColorFilter(Color.LTGRAY, PorterDuff.Mode.SRC_ATOP);

                Toast.makeText(MainActivity.this,
                        "Rating changed, current rating " + ratingBar.getRating(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        rat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ratingbar = String.valueOf(rating.getRating());
                Toast.makeText(getApplicationContext(), ratingbar, Toast.LENGTH_LONG).show();
            }
        });
    }
}
