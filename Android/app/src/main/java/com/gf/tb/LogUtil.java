package com.gf.tb;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

import cn.xjiangwei.RobotHelper.MainApplication;

public class LogUtil {

    public static void sendLog(String text) {
        Intent intent = new Intent("cc");
        intent.putExtra("log", text);
        LocalBroadcastManager.getInstance(MainApplication.getInstance()).sendBroadcast(intent);
    }
}
