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
import android.widget.Toast;

import com.corylab.wcalendar.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getParentFragmentManager().setFragmentResultListener("results",
                this, (requestKey, result) -> {
            String transmitted = result.getString("text2");
            binding.transmittedText.setText(transmitted);
        });


        Toast.makeText(getActivity(), "STATUS: CREATED", Toast.LENGTH_SHORT).show();
        Log.i("FirstFragment", "STATUS: CREATED");
    }

    @Override
    public void onStart() {
        super.onStart();

        Toast.makeText(getActivity(), "STATUS: STARTED", Toast.LENGTH_SHORT).show();
        Log.i("FirstFragment", "STATUS: STARTED");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();

        Toast.makeText(getActivity(), "STATUS: RESUMED", Toast.LENGTH_SHORT).show();
        Log.i("FirstFragment", "STATUS: RESUMED");
    }

    @Override
    public void onStop() {
        super.onStop();
        Toast.makeText(getActivity(), "STATUS: CREATED", Toast.LENGTH_SHORT).show();
        Log.i("FirstFragment", "STATUS: CREATED");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Toast.makeText(getActivity(), "STATUS: DESTROYED", Toast.LENGTH_SHORT).show();
        Log.i("FirstFragment", "STATUS: DESTROYED");
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstance) {
        binding.titleText.setText("Женский календарь");
        binding.editText.setHint("Введите текст");
        binding.grassImage.setImageResource(R.drawable.img_1);
        binding.button.setText(R.string.main_button);

        binding.intentButton.setOnClickListener(v -> {
            Log.i("clickButton","Кнопка нажата 2");

            Fragment fragment = new SecondFragment();
            Bundle args = new Bundle();
            args.putString("text1", binding.editText.getText().toString());
            fragment.setArguments(args);

            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container_view, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        });

        binding.button.setOnClickListener(v -> {
            Log.i("clickButton","Кнопка нажата");
        });
    }
}