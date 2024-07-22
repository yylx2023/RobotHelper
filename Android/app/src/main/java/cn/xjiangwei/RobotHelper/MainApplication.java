package cn.xjiangwei.RobotHelper;

import com.lzf.easyfloat.EasyFloat;
import com.lzf.easyfloat.enums.ShowPattern;
import com.lzf.easyfloat.interfaces.OnInvokeView;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.TextView;

import cn.xjiangwei.RobotHelper.Accessibility.HttpServer;
import cn.xjiangwei.RobotHelper.Service.Accessibility;


public class MainApplication extends Application {
    public static int sceenWidth = 0;
    public static int sceenHeight = 0;
    public static int dpi;
    private static MainApplication instance;

    public static MainApplication getInstance() {
        return instance;
    }

    @SuppressLint("HandlerLeak")
    private Handler uiHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if (null == tvLog) {
                return;
            }

            String content = tvLog.getText().toString();
            tvLog.setText(content + "\n" + msg.obj);
        }
    };

    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String text = intent.getStringExtra("log");

            uiHandler.obtainMessage(100, text).sendToTarget();
        }
    };

    private TextView tvLog;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        EasyFloat.with(this).setLayout(R.layout.floating, new OnInvokeView() {
            @Override
            public void invoke(View view) {
                tvLog = view.findViewById(R.id.tvItemFx);
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                    }
                });
            }
        }).setShowPattern(ShowPattern.ALL_TIME).show();

        IntentFilter filter = new IntentFilter("cc");
        LocalBroadcastManager.getInstance(this).registerReceiver(receiver, filter);
    }


    public static int sceenSize() {
        if (MainApplication.sceenWidth == 3120 && MainApplication.sceenHeight == 1440) {
            return 1;
        }
        return 2;
    }


    public boolean checkXposedHook() {
        return false;
    }

    public boolean checkAccessibilityService() {
        return Accessibility.DOM != null;
    }

    public boolean checkHttpServer() {
        return HttpServer.getInstance().isRuning();
    }
}
