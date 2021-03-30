package com.groupsale.Lootlo;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class FragmentAdapter extends FragmentStatePagerAdapter {

    private final int Tabcount;

    FragmentAdapter(FragmentManager fragmentManager, int CountTabs) {
        super(fragmentManager);
        this.Tabcount = CountTabs;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Deal();

            case 1:
                return new Join();

            case 2:
                return new Rewards();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return Tabcount;
    }
}
