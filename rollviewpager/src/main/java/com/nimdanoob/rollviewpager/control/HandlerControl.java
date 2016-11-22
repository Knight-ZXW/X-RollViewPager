package com.nimdanoob.rollviewpager.control;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.nimdanoob.rollviewpager.TimerControl;
import com.nimdanoob.rollviewpager.TimerListener;

/**
 * Created by Zousfu on 2016/5/19. Email:nimdanoob@163.com
 */
public class HandlerControl implements TimerControl {
  public static final int START = 0x1;
  public static final int STOP = 0x2;
  public static final int PAUSE = 0x4;
  public static final int SHOW_NEXT = 0x5;
  private static final int RESUME = 0x3;
  private int interval = 2000;

  private TimerListener mListener;
  private Handler mHandler = new Handler() {
    @Override
    public void handleMessage(Message msg) {
      switch (msg.what) {
        case SHOW_NEXT:
          Log.w("msgHandler", "showNext");
          mListener.showNext();
          mHandler.sendEmptyMessageDelayed(SHOW_NEXT, interval);
          break;
        case PAUSE:
          Log.w("msgHandler", "pause");
          //remove all Message
          mHandler.removeCallbacksAndMessages(null);
          break;
        case START:
          Log.w("msgHandler", "start");
          mHandler.removeCallbacksAndMessages(null);
          mHandler.sendEmptyMessageDelayed(SHOW_NEXT, interval);
          break;
        case STOP:
          mHandler.removeCallbacksAndMessages(null);
          break;
        default:
          break;
      }
    }
  };

  @Override
  public void setInterval(int interval) {
    this.interval = interval;
  }

  @Override
  public void setListener(TimerListener mListener) {
    this.mListener = mListener;
  }

  @Override
  public void start() {
    Log.w("msgHandler", "start");
    mHandler.sendEmptyMessage(START);
  }

  @Override
  public void resume() {
    mHandler.sendEmptyMessage(RESUME);
  }

  @Override
  public void pause() {
    mHandler.sendEmptyMessage(PAUSE);
  }

  @Override
  public void stop() {
    mHandler.sendEmptyMessage(STOP);
  }
}
