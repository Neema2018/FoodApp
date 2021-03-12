package com.preciousneema.food;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;


public class FoodDetails extends AppCompatActivity {

    // now we will get data from intent and set to UI

    ImageView imageView;
    TextView itemName, itemPrice, itemRating;
    RatingBar ratingBar;

    String name, price, rating;
    Integer imageUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_details);

        Intent intent = getIntent();

        name = intent.getStringExtra("title");
        price = intent.getStringExtra("price");
        rating = intent.getStringExtra("description");
        imageUrl = intent.getIntExtra("photo",0);

        imageView = findViewById(R.id.imageView5);
        itemName = findViewById(R.id.name);
        itemPrice = findViewById(R.id.price);
        itemRating = findViewById(R.id.rating);
        ratingBar = findViewById(R.id.ratingBar);

        Glide.with(getApplicationContext()).load(imageUrl).into(imageView);
        itemName.setText(name);
        itemPrice.setText( price);
        itemRating.setText(rating);
        //ratingBar.setRating(Float.parseFloat(rating));

    }
}
