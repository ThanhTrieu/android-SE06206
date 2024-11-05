package com.example.campusexpensese06206.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.campusexpensese06206.BudgetFragment;
import com.example.campusexpensese06206.ExpensesFragment;
import com.example.campusexpensese06206.HomeFragment;
import com.example.campusexpensese06206.SettingFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0){
            return new HomeFragment();
        } else if (position == 1) {
            return new ExpensesFragment();
        } else if (position == 2) {
            return new BudgetFragment();
        } else if (position == 3) {
            return new SettingFragment();
        } else {
            return new HomeFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
