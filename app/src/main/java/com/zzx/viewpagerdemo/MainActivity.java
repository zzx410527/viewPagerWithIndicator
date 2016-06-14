package com.zzx.viewpagerdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.zzx.library.ViewPagerWithIndicator;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private ViewPagerWithIndicator mViewPagerWithIndicator;
    FragmentManager mFragmentManager;

    /*
    ** Life cycle
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.detach(null);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mViewPagerWithIndicator = (ViewPagerWithIndicator) findViewById(R.id.viewPagerWithIndicator);
        mViewPager.setAdapter(new CustomViewPagerAdapter(this));
        mViewPagerWithIndicator.setViewPager(mViewPager);
    }

  

    private class ViewPagerStatusAdapter extends FragmentStatePagerAdapter {

        public ViewPagerStatusAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return null;
        }

        @Override
        public int getCount() {
            return 0;
        }
    }

    /*
    ** Simple viewPager implementation
     */
    private static class ViewPagerAdapter extends FragmentPagerAdapter {

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return null;
        }

        @Override
        public int getCount() {
            return 0;
        }
    }

    private static class CustomViewPagerAdapter extends PagerAdapter {

        @NonNull
        final Context mContext;

        public CustomViewPagerAdapter(@NonNull final Context context) {
            mContext = context;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {


            ImageView imageView = new ImageView(mContext);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            //该代码仅仅是为了测试使用，实际开发不需要这么写
            switch (position) {
                case 0:
                    imageView.setImageResource(R.drawable.tu1);
                    break;
                case 1:
                    imageView.setImageResource(R.drawable.tu2);
                    break;
                case 2:
                    imageView.setImageResource(R.drawable.tu3);
                    break;
            }
            container.addView(imageView);
            return imageView;
        }
    }
}
