package com.example.androidapplication;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.androidapplication.databinding.FragmentHelloBinding;

public class HelloFragment extends Fragment {
    FragmentManager fragmentManager;
    FragmentHelloBinding binding;
    MainActivity mainActivity;

    public HelloFragment(){
        super(R.layout.fragment_hello);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentManager = getParentFragmentManager();

        Toast.makeText(getContext(), "onCreateHelloFragment", Toast.LENGTH_LONG).show();
        Log.i("Fragment", "onCreateHelloFragment");

        fragmentManager.setFragmentResultListener("change HelloFragment", this, (requestKey, result) -> {
            String results = result.getString("resultText");
            binding.enterName.setText(results + "?");
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentHelloBinding.inflate(inflater, container, false);

        Toast.makeText(getContext(), "onCreateViewHelloFragment", Toast.LENGTH_LONG).show();
        Log.i("Fragment", "onCreateViewHelloFragment");

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toast.makeText(getContext(), "onViewCreatedHelloFragment", Toast.LENGTH_LONG).show();
        Log.i("Fragment", "onViewCreatedHelloFragment");

        binding.buttonHelloFragment.setOnClickListener(view1 -> {
            Bundle result = new Bundle();
            result.putString("resultText", binding.editTextTextPersonName4.getText().toString());
            fragmentManager.setFragmentResult("change ConfirmFragment", result);
            mainActivity.changeFragment(view1);
        });
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

        Toast.makeText(getContext(), "onViewStateRestoredHelloFragment", Toast.LENGTH_LONG).show();
        Log.i("Fragment", "onViewStateRestoredHelloFragment");
    }

    @Override
    public void onStart() {
        super.onStart();

        Toast.makeText(getContext(), "onStartHelloFragment", Toast.LENGTH_LONG).show();
        Log.i("Fragment", "onStartHelloFragment");
    }

    @Override
    public void onResume() {
        super.onResume();

        Toast.makeText(getContext(), "onResumetHelloFragment", Toast.LENGTH_LONG).show();
        Log.i("Fragment", "onResumetHelloFragment");
    }

    @Override
    public void onPause() {
        super.onPause();

        Toast.makeText(getContext(), "onPausetHelloFragment", Toast.LENGTH_LONG).show();
        Log.i("Fragment", "onPausetHelloFragment");
    }

    @Override
    public void onStop() {
        super.onStop();

        Toast.makeText(getContext(), "onStoptHelloFragment", Toast.LENGTH_LONG).show();
        Log.i("Fragment", "onStoptHelloFragment");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);


        Toast.makeText(getContext(), "onSaveInstanceStateHelloFragment", Toast.LENGTH_LONG).show();
        Log.i("Fragment", "onSaveInstanceStateHelloFragment");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        Toast.makeText(getContext(), "onDestroyViewStateHelloFragment", Toast.LENGTH_LONG).show();
        Log.i("Fragment", "onDestroyViewStateHelloFragment");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Toast.makeText(getContext(), "onDestroyHelloFragment", Toast.LENGTH_LONG).show();
        Log.i("Fragment", "onDestroyHelloFragment");
    }
}