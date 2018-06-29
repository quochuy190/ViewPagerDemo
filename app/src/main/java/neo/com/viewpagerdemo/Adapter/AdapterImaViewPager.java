package neo.com.viewpagerdemo.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

import neo.com.viewpagerdemo.R;

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
public class AdapterImaViewPager extends PagerAdapter {
    private Activity mContext;
    private Integer[] ints;

    public AdapterImaViewPager(Activity mContext, Integer[] ints) {
        this.mContext = mContext;
        this.ints = ints;
    }

    @Override
    public int getCount() {
        return ints.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (LinearLayout) object;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = mContext.getLayoutInflater().inflate(R.layout.lt_item_grid, container, false);

        ImageView imageView = view.findViewById(R.id.imageView);
        Glide.with(mContext).load(ints[position]).into(imageView);
        container.addView(view);
        return view;
    }
}
