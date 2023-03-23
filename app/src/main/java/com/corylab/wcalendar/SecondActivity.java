package com.corylab.wcalendar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.corylab.wcalendar.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    ActivitySecondBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle argument = getIntent().getExtras();
        String text = argument.getString("text1");
        binding.transmittedText.setText(text);

        binding.intentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("text2", binding.editText.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}