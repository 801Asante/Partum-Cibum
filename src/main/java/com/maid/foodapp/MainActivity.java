package com.maid.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerCategories;
    RecyclerView recyclerItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerCategories = findViewById(R.id.recycler_categories);
        recyclerItems = findViewById(R.id.recycler_food);

        setCategories();
        setFoodItem(0);


    }


    private void setCategories() {
        List<FoodCategory> data = new ArrayList<>();

        FoodCategory foodCategory = new FoodCategory("Burger",R.drawable.ic_burger);
        FoodCategory foodCategory2 = new FoodCategory("Chicken",R.drawable.ic_chicken);
        FoodCategory foodCategory3 = new FoodCategory("Pizza",R.drawable.ic_pizza);
        FoodCategory foodCategory4 = new FoodCategory("Burger",R.drawable.ic_chicken);

        data.add(foodCategory);
        data.add(foodCategory2);
        data.add(foodCategory3);
        data.add(foodCategory4);

        FoodCategoryAdapter foodCategoryAdapter = new FoodCategoryAdapter(data, MainActivity.this, new FoodCategoryAdapter.OnCategoryClick() {
            @Override
            public void onClick(int pos) {
                setFoodItem(pos);
            }
        });

        recyclerCategories.setLayoutManager(new LinearLayoutManager(MainActivity.this, RecyclerView.HORIZONTAL,false));
        recyclerCategories.setAdapter(foodCategoryAdapter);
        foodCategoryAdapter.notifyDataSetChanged();
    }

    private void setFoodItem(int pos){
        List<FoodItem> foodItems = new ArrayList<>();
        switch (pos) {
            case 2:
                FoodItem foodItem = new FoodItem("Pizza",4.5f,14,R.drawable.pizza_1);
                FoodItem foodItem2 = new FoodItem("Pizza one ",5f,14,R.drawable.pizza_2);
                FoodItem foodItem3 = new FoodItem("Pizza two",4f,14,R.drawable.pizza_3);
                FoodItem foodItem4 = new FoodItem("Pizza",3.5f,14,R.drawable.pizza_4);

                foodItems.add(foodItem);
                foodItems.add(foodItem2);
                foodItems.add(foodItem3);
                foodItems.add(foodItem4);
                break;
            case 1:
                FoodItem foodItem5 = new FoodItem("Chicken",4.5f,14,R.drawable.grill_chicken_1);
                FoodItem foodItem6 = new FoodItem("Chicken one ",5f,14,R.drawable.grill_chicken_2);
                FoodItem foodItem7 = new FoodItem("Chicken two",4f,14,R.drawable.grill_chicken_3);
                FoodItem foodItem8 = new FoodItem("Chicken",3.5f,14,R.drawable.grill_chicken_2);

                foodItems.add(foodItem5);
                foodItems.add(foodItem6);
                foodItems.add(foodItem7);
                foodItems.add(foodItem8);
                break;
            case 0:
                FoodItem foodItem9 = new FoodItem("Burger",4.5f,14,R.drawable.burger_two);
                FoodItem foodItem10 = new FoodItem("Burger one ",5f,14,R.drawable.burger);
                FoodItem foodItem11 = new FoodItem("Burger two",4f,14,R.drawable.burger_two);
                FoodItem foodItem12 = new FoodItem("Burger",3.5f,14,R.drawable.burger);
                foodItems.add(foodItem9);
                foodItems.add(foodItem10);
                foodItems.add(foodItem11);
                foodItems.add(foodItem12);
                break;
        }

        FoodAdapter foodAdapter = new FoodAdapter(foodItems);
        recyclerItems.setLayoutManager(new LinearLayoutManager(MainActivity.this,RecyclerView.HORIZONTAL,false));

        recyclerItems.setAdapter(foodAdapter);
    }
}