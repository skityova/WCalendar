package com.corylab.wcalendar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView titleText = (TextView) findViewById(R.id.title_text);
        titleText.setText("Женский календарь");

        EditText editText = (EditText) findViewById(R.id.editText);
        editText.setHint("Введите текст");

        ImageView flowerCircle = (ImageView) findViewById(R.id.flower_circle);
        flowerCircle.setImageResource(R.drawable.img_1);

        Button button = (Button) findViewById(R.id.button);
        button.setText(R.string.main_button);

        Button intentButton = (Button) findViewById(R.id.intent_button);
        intentButton.setOnClickListener(new View.OnClickListener() {
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