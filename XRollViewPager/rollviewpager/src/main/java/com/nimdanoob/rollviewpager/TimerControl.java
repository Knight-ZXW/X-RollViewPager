package com.nimdanoob.rollviewpager;

/**
 * Created by Zousfu on 2016/5/19.
 * Email:nimdanoob@163.com
 */
public interface TimerControl {
     void start();
     void resume();
     void pause();
     void stop();

    void setInterval(int delay);

    void setListener(TimerListener timerListener);
}
