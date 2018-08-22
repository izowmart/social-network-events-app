package com.muva.fika3_android.search;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.muva.fika3_android.MainActivity;
import com.muva.fika3_android.R;
import com.muva.fika3_android.home.VenuesFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {
    ViewPager mViewPager;
    TabLayout tabLayout;
    SearchFragment.SectionsPagerAdapter mSectionsPagerAdapter;

    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_search, container, false);
        mViewPager = rootView.findViewById(R.id.search_container);
        tabLayout = rootView.findViewById(R.id.search_tabs);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getChildFragmentManager());
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
        return rootView;
    }

    public static class SectionsPagerAdapter extends FragmentPagerAdapter {

        SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new PeopleFragment();
            } else if (position == 1) {
                return new VenuesFragment();
            } else {
                return new EventsFragment();
            }
        }

        @Override
        public int getCount() {
            return 3;
        }
    }

}
