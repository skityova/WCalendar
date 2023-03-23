package com.corylab.wcalendar;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.corylab.wcalendar.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.titleText.setText("Женский календарь");
        binding.editText.setHint("Введите текст");
        binding.grassImage.setImageResource(R.drawable.img_1);
        binding.button.setText(R.string.main_button);

        MainActivity currentActivity = this;
        binding.intentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("clickButton","Кнопка нажата 2");
                Intent intent = new Intent(currentActivity, SecondActivity.class);
                intent.putExtra("text1", binding.editText.getText().toString());
                startActivity(intent);
            }
        });
    }

    ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    Intent intent = result.getData();
                    String results = intent.getStringExtra("text2");
                    binding.transmittedText.setText(results);
                }
            });

    public void onButtonClick(View view) {
        Log.i("clickButton","Кнопка нажата");
    }
}