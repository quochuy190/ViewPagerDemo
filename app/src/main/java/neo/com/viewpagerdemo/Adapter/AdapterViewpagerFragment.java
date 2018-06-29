package neo.com.viewpagerdemo.Adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Quốc Huy
 * @version 1.0.0
 * @description
 * @desc Developer NEO Company.
 * @created 6/29/2018
 * @updated 6/29/2018
 * @modified by
 * @updated on 6/29/2018
 * @since 1.0
 */
public class AdapterViewpagerFragment extends FragmentPagerAdapter {
    List<Fragment> mLisFragment = new ArrayList<>();
    List<String> mListTitle = new ArrayList<>();

    public AdapterViewpagerFragment(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return mLisFragment.get(i);
    }

    @Override
    public int getCount() {
        return mLisFragment.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mListTitle.get(position);
    }
    public void add_Fragment(Fragment fragment, String sTitle){
        if (fragment!=null){
            mLisFragment.add(fragment);
            mListTitle.add(sTitle);
        }
    }
}
