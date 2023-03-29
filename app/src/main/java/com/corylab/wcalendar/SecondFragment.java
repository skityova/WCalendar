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
        String text = args.getString("text1");
        binding.transmittedText.setText(text);

        binding.intentButton.setOnClickListener((v) -> {
            Bundle result = new Bundle();
            result.putString("text2", binding.editText.getText().toString());
            getParentFragmentManager().setFragmentResult("results",
                    result);
            getParentFragmentManager().popBackStack();;
        });
    }
}