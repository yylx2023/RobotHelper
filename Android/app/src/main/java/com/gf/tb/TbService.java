package com.gf.tb;

import com.topjohnwu.superuser.ipc.RootService;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

public class TbService extends RootService {

    class RootConnection implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


}
