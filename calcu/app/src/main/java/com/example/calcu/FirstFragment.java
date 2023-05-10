package com.example.calcu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.calcu.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment using the data binding library
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        // Return the root view of the inflated layout
        return binding.getRoot();

    }
    // This method is called after the view hierarchy of the fragment is inflated
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Set the binding to null to avoid memory leaks when the view is destroyed
        binding = null;
    }

}
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
         // Set a click listener on the button in the layout
        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Use the Navigation component to navigate to the SecondFragment
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }