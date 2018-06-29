package neo.com.viewpagerdemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import neo.com.viewpagerdemo.Adapter.AdapterImaViewPager;

public class MainViewPager extends AppCompatActivity {
    AdapterImaViewPager customPagerAdapter;
    ViewPager viewPager;
    TabLayout tabLayout;
    TextView txt_top, txt_skip;
    private Integer[] imgs1 = {
            R.drawable.introscreen1,
            R.drawable.introscreen2,
            R.drawable.introscreen3,
            R.drawable.introscreen4,
            R.drawable.introscreen5
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        init();
        initViewpager();
        initEvent();
    }

    private void init() {
        viewPager = (ViewPager) findViewById(R.id.id_viewpager_images);
        tabLayout = (TabLayout) findViewById(R.id.id_tablayout);
        txt_top = (TextView) findViewById(R.id.txt_top);
        txt_skip = findViewById(R.id.txt_skip);
        //txt_top.setVisibility(View.INVISIBLE);
    }

    private void initViewpager() {
        customPagerAdapter = new AdapterImaViewPager(MainViewPager.this, imgs1);
        viewPager.setAdapter(customPagerAdapter);
        // Xu li cho TabLayout
        tabLayout = (TabLayout) findViewById(R.id.id_tablayout);
        tabLayout.setupWithViewPager(viewPager);
        // Lắng nghe sự kiện khi viewpager thay đổi
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if (position == imgs1.length - 1) {
                    txt_top.setVisibility(View.VISIBLE);
                } else {
                    if (txt_top.getVisibility() == View.VISIBLE) {
                        txt_top.setVisibility(View.INVISIBLE);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initEvent() {
        txt_top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Perform scrolling to position
                new Handler().post(new Runnable() {
                    @Override
                    public void run() {
                        viewPager.setCurrentItem(0, true);
                    }
                });
            }
        });
        txt_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainViewPager.this, MainActivity.class);
                startActivity(intent);
                // lu vao data app
                /*SharedPreferences sharedPreferences = getSharedPreferences("save", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("ok", true);
                editor.commit();*/
            }
        });

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        customPagerAdapter = null;
        imgs1 = null;
    }

}
