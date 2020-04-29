package com.itp.myapplication.adapter;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
;
import com.itp.myapplication.R;
import com.itp.myapplication.fragment.EntertainmentFragment;
//import com.itp.myapplication.fragment.SportsFragment;
//import com.itp.myapplication.fragment.Top_HeadlinesFragment;
//import com.itp.myapplication.fragment.BusinessFragment;
//import com.itp.myapplication.fragment.EntertainmentFragment;
//import com.itp.myapplication.fragment.ScienceFragment;
//import com.itp.myapplication.fragment.TechnologyFragment;
//import com.itp.myapplication.fragment.WorldFragment;

/**
 * Created by prans on 08-01-2018.
 */

public class CategoryAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        EntertainmentFragment fragment = null;
        switch (position) {
            case 0:
//                fragment = new Top_HeadlinesFragment();
//                break;
//            case 1:
//                fragment = new WorldFragment();
//                break;
//            case 2:
//                fragment = new TechnologyFragment();
//                break;
//            case 3:
//                fragment = new BusinessFragment();
//                break;
//            case 4:
//                fragment = new ScienceFragment();
//                break;
//            case 5:
//                fragment = new SportsFragment();
//                break;
            case 6:
                fragment = new EntertainmentFragment();
                break;
            default:
                break;
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 7;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String pageTitle = null;
        switch (position) {
//            case 0:
//                pageTitle = mContext.getString(R.string.category_headlines);
//                break;
//
//            case 1:
//                pageTitle = mContext.getString(R.string.category_world);
//                break;
//            case 2:
//                pageTitle = mContext.getString(R.string.category_technology);
//                break;
//            case 3:
//                pageTitle = mContext.getString(R.string.category_business);
//                break;
//            case 4:
//                pageTitle = mContext.getString(R.string.category_science);
//                break;
//            case 5:
//                pageTitle = mContext.getString(R.string.category_sports);
//                break;
//            case 6:
//                pageTitle = mContext.getString(R.string.category_entertainment);
//                break;
            default:
                break;
        }

        return null;
    }

}
