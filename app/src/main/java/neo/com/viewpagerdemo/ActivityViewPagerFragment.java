package neo.com.viewpagerdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import neo.com.viewpagerdemo.Adapter.AdapterViewpagerFragment;
import neo.com.viewpagerdemo.Fragment.Fragment_One;
import neo.com.viewpagerdemo.Fragment.Fragment_Two;

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
public class ActivityViewPagerFragment extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;
    AdapterViewpagerFragment adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager_fragment);
        init();
        initViewPager();
    }

    private void initViewPager() {
        adapter = new AdapterViewpagerFragment(getSupportFragmentManager());
        adapter.add_Fragment(new Fragment_One(),"FragmentOne");
        adapter.add_Fragment(new Fragment_Two(), "FragmentTwo");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void init() {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
    }
}
