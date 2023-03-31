package com.corylab.wcalendar;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.corylab.wcalendar.databinding.FragmentFirstBinding;
import com.corylab.wcalendar.databinding.FragmentSecondBinding;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstance) {

        Bundle args = this.getArguments();
        String dateString = args.getString("lastCycle");

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM", Locale.US);
        try {
            Date date = dateFormat.parse(dateString);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DATE, 28);
            String resultDate = dateFormat.format(calendar.getTime());
            binding.transmittedText.setText("Дата начала следующего цикла: " + resultDate);
        }
        catch (Exception e) {
            binding.transmittedText.setText("Дата введена неверно");
            e.printStackTrace();
        }

        binding.returnButton.setOnClickListener((v) -> {
            Bundle result = new Bundle();
            result.putString("info", binding.transmittedText.getText().toString());
            getParentFragmentManager().setFragmentResult("results",
                    result);
            getParentFragmentManager().popBackStack();;
        });
    }
}