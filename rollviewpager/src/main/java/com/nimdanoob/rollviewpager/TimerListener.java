package com.nimdanoob.rollviewpager;

/**
 * Created by Zousfu on 2016/5/19.
 * Email:nimdanoob@163.com
 */
public interface TimerListener {
    /**
     * 计时器一次循环
     */
    public void showNext();

    /**
     * 开始计时
     */
    public void onStart();

    /**
     *计时器暂停
     */
    public void onPause();

    /**
     *停止，只会被调用一次，表示计时器被销毁了
     */
    public void onStop();


}
