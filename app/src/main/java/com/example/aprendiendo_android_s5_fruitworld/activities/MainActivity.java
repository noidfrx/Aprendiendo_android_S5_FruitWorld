package com.example.aprendiendo_android_s5_fruitworld.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.aprendiendo_android_s5_fruitworld.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_fruit :{
                Toast.makeText(MainActivity.this, "ADD FRUIT", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.list :{
                Toast.makeText(MainActivity.this, "LIST VIEW", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.grid :{
                Toast.makeText(MainActivity.this, "GRID VIEW", Toast.LENGTH_SHORT).show();
                break;
            }
            default: break;
        }
        return super.onOptionsItemSelected(item);

    }
}