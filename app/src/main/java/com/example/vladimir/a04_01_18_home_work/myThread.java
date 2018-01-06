package com.example.vladimir.a04_01_18_home_work;

import android.os.Handler;
import android.os.Message;

/**
 * Created by vladimir on 03/01/2018.
 */

public class myThread extends Thread {
    private Handler handler;

    public myThread(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void run() {
        try {
            handler.sendEmptyMessage(1);

            for (int i = 0; i < 100; i++) {
                Message msg = handler.obtainMessage(3, i+1, -1);
                handler.sendMessage(msg);
                sleep(50);
            }
            handler.sendEmptyMessage(2);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
