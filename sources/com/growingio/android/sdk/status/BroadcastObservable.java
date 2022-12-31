package com.growingio.android.sdk.status;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import com.growingio.android.sdk.base.event.ScreenStatusEvent;
import com.growingio.android.sdk.base.event.net.NetWorkChangedEvent;
import com.growingio.eventcenter.bus.EventBus;
/* loaded from: classes2.dex */
public class BroadcastObservable extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("android.intent.action.SCREEN_ON".equals(action)) {
            EventBus.getDefault().post(new ScreenStatusEvent(ScreenStatusEvent.ScreenStatusType.SCREEN_ON));
        } else if ("android.intent.action.SCREEN_OFF".equals(action)) {
            EventBus.getDefault().post(new ScreenStatusEvent(ScreenStatusEvent.ScreenStatusType.SCREEN_OFF));
        } else if ("android.intent.action.USER_PRESENT".equals(action)) {
            EventBus.getDefault().post(new ScreenStatusEvent(ScreenStatusEvent.ScreenStatusType.SCREEN_PRESENT));
        } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean z = true;
            if (Build.VERSION.SDK_INT < 21) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
                NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
                if (networkInfo.isConnected()) {
                    if (networkInfo2.isConnected()) {
                    }
                    z = false;
                }
                EventBus.getDefault().post(new NetWorkChangedEvent(z));
            }
            ConnectivityManager connectivityManager2 = (ConnectivityManager) context.getSystemService("connectivity");
            for (Network network : connectivityManager2.getAllNetworks()) {
                if (!connectivityManager2.getNetworkInfo(network).isConnected()) {
                }
            }
            z = false;
            EventBus.getDefault().post(new NetWorkChangedEvent(z));
            EventBus.getDefault().post(new NetWorkChangedEvent(z));
        }
    }
}
