package com.nimdanoob.xrollviewpager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.nimdanoob.rollviewpager.RollPagerView;
import com.nimdanoob.rollviewpager.adapter.LoopPagerAdapter;
import com.nimdanoob.rollviewpager.adapter.StaticPagerAdapter;
import com.nimdanoob.rollviewpager.hintview.IconHintView;

public class MainActivity extends AppCompatActivity {

    private RollPagerView mRollViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRollViewPager= (RollPagerView) findViewById(R.id.roll_view_pager);
        mRollViewPager.setAdapter(new TestLoopAdapter(mRollViewPager));
//        mRollViewPager.setAdapter(new TestNormalAdapter());
        mRollViewPager.setHintView(new IconHintView(this,R.drawable.point_focus,R.drawable.point_normal));
        //mRollViewPager.setHintView(new ColorPointHintView(this, Color.YELLOW,Color.WHITE));
        //mRollViewPager.setHintView(new TextHintView(this));

    }

    private class TestLoopAdapter extends LoopPagerAdapter {
        private int[] imgs = {
                R.drawable.img1,
                R.drawable.img2,
                R.drawable.img3,
                R.drawable.img4,
                R.drawable.img5,
        };

        public TestLoopAdapter(RollPagerView viewPager) {
            super(viewPager);
        }

        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
            view.setImageResource(imgs[position]);
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return view;
        }

        @Override
        public int getRealCount() {
            return imgs.length;
        }

    }

    private class TestNormalAdapter extends StaticPagerAdapter {
        private int[] imgs = {
                R.drawable.img1,
                R.drawable.img2,
                R.drawable.img3,
                R.drawable.img4,
        };


        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
            view.setImageResource(imgs[position]);
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return view;
        }


        @Override
        public int getCount() {
            return imgs.length;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mRollViewPager.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mRollViewPager.pause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mRollViewPager.stop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
