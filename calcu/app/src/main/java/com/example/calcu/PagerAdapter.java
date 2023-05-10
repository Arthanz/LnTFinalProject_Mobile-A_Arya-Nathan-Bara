package com.example.calcu;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class PagerAdapter extends FragmentStateAdapter {
    // Declare two ArrayLists to hold the fragments and their titles
    private ArrayList<Fragment> fragmentList = new ArrayList<>();
    private ArrayList<String> fragmentTitleList = new ArrayList<>();

    // Constructor that takes a FragmentActivity as a parameter
    public PagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    // Method to add a fragment to the list
    public void addFragment(Fragment fragment, String title) {
        fragmentList.add(fragment);
        fragmentTitleList.add(title);
    }

    // Overridden method to create a new fragment for a given position
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragmentList.get(position);
    }

    // Overridden method to get the number of fragments in the list
    @Override
    public int getItemCount() {
        return fragmentList.size();
    }

    // Method to get the title of a fragment at a given position
    public String getPageTitle(int position) {
        return fragmentTitleList.get(position);
    }

}
