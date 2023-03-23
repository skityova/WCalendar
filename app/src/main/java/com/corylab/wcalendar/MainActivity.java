package com.corylab.wcalendar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.corylab.wcalendar.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.titleText.setText("Женский календарь");
        binding.editText.setHint("Введите текст");
        binding.grassImage.setImageResource(R.drawable.img_1);
        binding.button.setText(R.string.main_button);
        binding.intentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("clickButton","Кнопка нажата 2");
            }
        });
    }

    public void onButtonClick(View view) {
        Log.i("clickButton","Кнопка нажата");
    }
}