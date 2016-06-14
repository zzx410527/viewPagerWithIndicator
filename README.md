#ViewPagerwithIndicator

##demo
![](http://img.blog.csdn.net/20160614123323182?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center)

##Feature
可以指定ViewPagerWithIndicator相关属性
##Usage
在你的XML文件里面引用

    <com.zzx.library.ViewPagerWithIndicator
        app:round.enable="true"
        app:round.size="15dip"
        app:round.drawable="@drawable/background_rounded"
        app:round.color.default="@android:color/white"
        app:round.color.selected="@android:color/holo_blue_light"
        android:id="@+id/viewPagerWithIndicator"
        app:round.margin_top="5dp"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

        <com.zzx.library.ViewPagerWrapContent
            android:id="@+id/viewPager"
            android:layout_width="match_parent"
            android:layout_height="wrap_content" />
    </com.zzx.library.ViewPagerWithIndicator>


在代码里面引用：

	    mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mViewPagerWithIndicator = (ViewPagerWithIndicator) findViewById(R.id.viewPagerWithIndicator);
        mViewPager.setAdapter(new CustomViewPagerAdapter(this));
        mViewPagerWithIndicator.setViewPager(mViewPager);

## License

Copyright 2014 zzx

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.