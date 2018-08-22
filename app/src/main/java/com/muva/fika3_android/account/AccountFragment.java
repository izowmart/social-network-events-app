package com.muva.fika3_android.account;


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

/**
 * A simple {@link Fragment} subclass.
 */
public class AccountFragment extends Fragment {
    ViewPager mViewPager;
    TabLayout tabLayout;
    AccountFragment.SectionsPagerAdapter mSectionsPagerAdapter;

//    public void setmSectionsPagerAdapter(SectionsPagerAdapter mSectionsPagerAdapter) {
//        this.mSectionsPagerAdapter = mSectionsPagerAdapter;
//    }

    public AccountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_account, container, false);
        mViewPager = rootView.findViewById(R.id.account_container);
        tabLayout = rootView.findViewById(R.id.account_tabs);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getChildFragmentManager());
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
        return rootView;
    }

    public static class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new FollowingFragment();
            } else {
                return new FollowersFragment();
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
    }

}
