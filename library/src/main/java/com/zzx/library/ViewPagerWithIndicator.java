package com.zzx.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ViewPagerWithIndicator extends LinearLayout {


    private int mRoundSize;
    private int mMargin_top;
    private int mRoundDrawable;
    private int mRoundDefaultColor;
    private int mRoundSelectedColor;

    private ViewPager mViewPager = null;


    private LinearLayout roundedIndicatorContainer = null;

    /*
    ** Constructor
     */
    public ViewPagerWithIndicator(Context context) {
        this(context, null);
    }

    public ViewPagerWithIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.ViewPagerWithIndicator, 0, 0);
        try {
            mRoundSize = a.getLayoutDimension(R.styleable.ViewPagerWithIndicator_round_size, ViewGroup.LayoutParams.WRAP_CONTENT);
            mMargin_top = a.getLayoutDimension(R.styleable.ViewPagerWithIndicator_round_margin_top, 10);
            mRoundDrawable = a.getResourceId(R.styleable.ViewPagerWithIndicator_round_drawable, 0);
            mRoundDefaultColor = a.getColor(R.styleable.ViewPagerWithIndicator_round_color_default, Color.TRANSPARENT);
            mRoundSelectedColor = a.getColor(R.styleable.ViewPagerWithIndicator_round_color_selected, Color.GREEN);
        } finally {
            a.recycle();
        }
        init();
    }

    /*
    ** Public method
     */
    public void setViewPager(@NonNull final ViewPager viewPager) {
        if (viewPager.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }

        mViewPager = viewPager;
        //Init roundedIndicator container
        roundedIndicatorContainer = new LinearLayout(getContext());
        roundedIndicatorContainer.setOrientation(LinearLayout.HORIZONTAL);

        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        params.setMargins(0, 10, 0, 0);
        roundedIndicatorContainer.setLayoutParams(params);
        this.addView(roundedIndicatorContainer);
        populateView();

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                updateRoundIndicator();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    /*
    ** Private method
     */
    private void init() {
        this.setOrientation(LinearLayout.VERTICAL);
        this.setGravity(Gravity.CENTER);
        //Init roundedIndicator container
      /*  roundedIndicatorContainer = new LinearLayout(getContext());
        roundedIndicatorContainer.setOrientation(LinearLayout.HORIZONTAL);

        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        roundedIndicatorContainer.setLayoutParams(params);

        this.addView(roundedIndicatorContainer);*/
    }

    private void populateView() {

        //populate roundedIndicator container
        LayoutParams params = new LayoutParams(mRoundSize, mRoundSize);

        for (int i = 0; i < mViewPager.getAdapter().getCount(); i++) {
            ImageView roundIndicator = new ImageView(getContext());
            roundIndicator.setBackgroundResource(mRoundDrawable);
            roundIndicator.setLayoutParams(params);

            roundedIndicatorContainer.addView(roundIndicator);
        }
        updateRoundIndicator();
    }


    private void updateRoundIndicator() {
        //TODO avoid loop over every element (store last updated)
        for (int i = 0; i < mViewPager.getAdapter().getCount(); i++) {
            View view = roundedIndicatorContainer.getChildAt(i);
            GradientDrawable background = (GradientDrawable) view.getBackground();
            background.setColor(i == mViewPager.getCurrentItem() ? mRoundSelectedColor : mRoundDefaultColor);
        }
    }


}

