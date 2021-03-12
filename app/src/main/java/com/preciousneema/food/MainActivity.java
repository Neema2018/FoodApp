package com.preciousneema.food;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.preciousneema.food.model.Food;
import com.preciousneema.food.retrofit.ApiInterface;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ApiInterface apiInterface;

    ListView popularListView, recommendedListView, allMenuListView;

//    PopularAdapter popularAdapter;
//    RecommendedAdapter recommendedAdapter;
//    AllMenuAdapter allMenuAdapter;
    CustomAdapter adapter1;
    CustomAdapter adapter2;
    CustomAdapter adapter3;
    ArrayList<Food> allFoods;
    ArrayList<Food> popularFoods;
    ArrayList<Food> recomendedFoods;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        apiInterface = RetrofitClient.getRetrofitInstance().create(ApiInterface.class);

//        Call<List<FoodData>> call = apiInterface.getAllData();
//        call.enqueue(new Callback<List<FoodData>>() {
//            @Override
//            public void onResponse(Call<List<FoodData>> call, Response<List<FoodData>> response) {
//
//                List<FoodData> foodDataList = response.body();
//
//
//                getPopularData(foodDataList.get(0).getPopular());
//
//                getRecommendedData(foodDataList.get(0).getRecommended());
//
//                getAllMenu(foodDataList.get(0).getAllmenu());
//
//            }
//
//            @Override
//            public void onFailure(Call<List<FoodData>> call, Throwable t) {
//                Toast.makeText(MainActivity.this, "Server is not responding.", Toast.LENGTH_SHORT).show();
//            }
//        });

        allFoods = new ArrayList<>();
        recomendedFoods = new ArrayList<>();
        popularFoods = new ArrayList<>();
        adapter1 = new CustomAdapter(this,allFoods);
        adapter2 = new CustomAdapter(this,recomendedFoods);
        adapter3 = new CustomAdapter(this,popularFoods);

        getAllMenu();
        getPopularData();
        getRecommendedData();

    }

    private void  getPopularData(){
        Food food1 = new Food("Nasi Goreng","Spicy","4.5","30","100","","",R.drawable.popular1);
        Food food2 = new Food("Rendang","Non-Spicy","4.5","30","100","","",R.drawable.popularfood2);
        Food food3 = new Food("Pece","Extra Mayo","4.5","30","100","","",R.drawable.popularfood3);
        Food food4 = new Food("Indomie","Extra Sauce","4.5","30","100","","",R.drawable.asiafood1);
        Food food5 = new Food("Chicken Pilau","Spiced","4.5","30","100","","",R.drawable.asiafood2);
        Food food6 = new Food("Chicken Pilau","Spiced","4.5","30","100","","",R.drawable.popularfood1);
        Food food7 = new Food("Chicken Pilau","Spiced","4.5","30","100","","",R.drawable.popular1);
        Food food8 = new Food("Chicken Pilau","Spiced","4.5","30","100","","",R.drawable.popularfood3);
        Food food9 = new Food("Chicken Pilau","Spiced","4.5","30","100","","",R.drawable.popularfood1);
        Food food10 = new Food("Chicken Pilau","Spiced","4.5","30","100","","",R.drawable.popularfood2);
        popularFoods.add(food1);
        popularFoods.add(food2);
        popularFoods.add(food3);
        popularFoods.add(food4);
        popularFoods.add(food5);
        popularFoods.add(food6);
        popularFoods.add(food7);
        popularFoods.add(food8);
        popularFoods.add(food9);
        popularFoods.add(food10);

        popularListView = findViewById(R.id.popular_recycler);
        popularListView.setAdapter(adapter3);
        popularListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String title = recomendedFoods.get(position).getName();
                String price = recomendedFoods.get(position).getPrice();
                String description = recomendedFoods.get(position).getDescription();
                int photo = recomendedFoods.get(position).getPhoto();

                Intent intent = new Intent(getBaseContext(), FoodDetails.class);
                intent.putExtra("title", title);
                intent.putExtra("price", price);
                intent.putExtra("description", description);
                intent.putExtra("photo", photo);
                startActivity(intent);
            }
        });


    }

    private void  getRecommendedData(){
        Food food1 = new Food("Nasi Goreng","Spicy","4.5","30","100","","",R.drawable.popular1);
        Food food2 = new Food("Rendang","Non-Spicy","4.5","30","100","","",R.drawable.popularfood2);
        Food food3 = new Food("Pece","Extra Mayo","4.5","30","100","","",R.drawable.popularfood3);
        Food food4 = new Food("Indomie","Extra Sauce","4.5","30","100","","",R.drawable.asiafood1);
        Food food5 = new Food("Chicken Pilau","Spiced","4.5","30","100","","",R.drawable.asiafood2);
        Food food6 = new Food("Chicken Pilau","Spiced","4.5","30","100","","",R.drawable.popularfood1);
        Food food7 = new Food("Chicken Pilau","Spiced","4.5","30","100","","",R.drawable.popular1);
        Food food8 = new Food("Chicken Pilau","Spiced","4.5","30","100","","",R.drawable.popularfood3);
        Food food9 = new Food("Chicken Pilau","Spiced","4.5","30","100","","",R.drawable.popularfood1);
        Food food10 = new Food("Chicken Pilau","Spiced","4.5","30","100","","",R.drawable.popularfood2);
        recomendedFoods.add(food1);
        recomendedFoods.add(food2);
        recomendedFoods.add(food3);
        recomendedFoods.add(food4);
        recomendedFoods.add(food5);
        recomendedFoods.add(food6);
        recomendedFoods.add(food7);
        recomendedFoods.add(food8);
        recomendedFoods.add(food9);
        recomendedFoods.add(food10);

        recommendedListView = findViewById(R.id.recommended_recycler);
        recommendedListView.setAdapter(adapter2);

        recommendedListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String title = recomendedFoods.get(position).getName();
                String price = recomendedFoods.get(position).getPrice();
                String description = recomendedFoods.get(position).getDescription();
                int photo = recomendedFoods.get(position).getPhoto();

                Intent intent = new Intent(getBaseContext(), FoodDetails.class);
                intent.putExtra("title", title);
                intent.putExtra("price", price);
                intent.putExtra("description", description);
                intent.putExtra("photo", photo);
                startActivity(intent);
            }
        });

    }

    private void  getAllMenu(){
        Food food1 = new Food("Nasi Goreng","Spicy","4.5","30","100","","",R.drawable.popular1);
        Food food2 = new Food("Rendang","Non-Spicy","4.5","30","100","","",R.drawable.popularfood2);
        Food food3 = new Food("Pece","Extra Mayo","4.5","30","100","","",R.drawable.popularfood3);
        Food food4 = new Food("Indomie","Extra Sauce","4.5","30","100","","",R.drawable.asiafood1);
        Food food5 = new Food("Chicken Pilau","Spiced","4.5","30","100","","",R.drawable.asiafood2);
        Food food6 = new Food("Chicken Pilau","Spiced","4.5","30","100","","",R.drawable.popularfood1);
        Food food7 = new Food("Chicken Pilau","Spiced","4.5","30","100","","",R.drawable.popular1);
        Food food8 = new Food("Chicken Pilau","Spiced","4.5","30","100","","",R.drawable.popularfood3);
        Food food9 = new Food("Chicken Pilau","Spiced","4.5","30","100","","",R.drawable.popularfood1);
        Food food10 = new Food("Chicken Pilau","Spiced","4.5","30","100","","",R.drawable.popularfood2);
        allFoods.add(food1);
        allFoods.add(food2);
        allFoods.add(food3);
        allFoods.add(food4);
        allFoods.add(food5);
        allFoods.add(food6);
        allFoods.add(food7);
        allFoods.add(food8);
        allFoods.add(food9);
        allFoods.add(food10);

        allMenuListView = findViewById(R.id.all_menu_recycler);
        allMenuListView.setAdapter(adapter1);

        allMenuListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String title = recomendedFoods.get(position).getName();
                String price = recomendedFoods.get(position).getPrice();
                String description = recomendedFoods.get(position).getDescription();
                int photo = recomendedFoods.get(position).getPhoto();

                Intent intent = new Intent(getBaseContext(), FoodDetails.class);
                intent.putExtra("title", title);
                intent.putExtra("price", price);
                intent.putExtra("description", description);
                intent.putExtra("photo", photo);
                startActivity(intent);
            }
        });


    }
}