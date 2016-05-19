package com.nimdanoob.rollviewpager.control;

import android.os.Handler;
import android.os.Message;

import com.nimdanoob.rollviewpager.RollControl;

/**
 * Created by Zousfu on 2016/5/19.
 * Email:nimdanoob@163.com
 */
public class HandlerControl implements RollControl{
    private int interval;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
    public static final int START = 0x1;
    public static final int STOP =0x2;
    public static final int PAUSE = 0x3;
    public static final int SHOW_NEXT =0x4;
    public static final int SHOW_PREV = 0x5;
    @Override
    public void showNext() {

    }

    @Override
    public void showPrev() {

    }

    @Override
    public void start() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void stop() {

    }
}
