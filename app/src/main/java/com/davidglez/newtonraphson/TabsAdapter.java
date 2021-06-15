package com.davidglez.newtonraphson;

import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.davidglez.newtonraphson.Fragments.ExampleNewton1ragment;
import com.davidglez.newtonraphson.Fragments.ExampleNewton2Fragment;
import com.davidglez.newtonraphson.Fragments.ExampleNewton3ragment;

public class TabsAdapter extends FragmentPagerAdapter {

    private String[] tabTitle = new String[]{"Ejemplo 1", "Ejemplo 2", "Ejemplo 3"};

    public TabsAdapter(FragmentManager fm, int countTab) {
        super(fm);

    }
    public CharSequence getPageTitle(int position){
        return tabTitle[position];
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                ExampleNewton1ragment exam1 = new ExampleNewton1ragment();
                return exam1;
            case 1:
                ExampleNewton2Fragment exam2 = new ExampleNewton2Fragment();
                return exam2;
            case 2:
                ExampleNewton3ragment exam3 = new ExampleNewton3ragment();
                return exam3;
        }
        return null;
    }

    @Override
    public int getCount() {
        return tabTitle.length;
    }
}
