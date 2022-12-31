package com.pinguo.album.common;

import android.app.IntentService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* loaded from: classes3.dex */
public class PackagesMonitor extends BroadcastReceiver {

    /* loaded from: classes3.dex */
    public static class AsyncService extends IntentService {
        public AsyncService() {
            super("GalleryPackagesMonitorAsync");
        }

        @Override // android.app.IntentService
        protected void onHandleIntent(Intent intent) {
            PackagesMonitor.b(this, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, Intent intent) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        int i2 = defaultSharedPreferences.getInt("packages-version", 1);
        SharedPreferences.Editor edit = defaultSharedPreferences.edit();
        edit.putInt("packages-version", i2 + 1);
        edit.apply();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        VdsAgent.onBroadcastReceiver(this, context, intent);
        intent.setClass(context, AsyncService.class);
        context.startService(intent);
    }
}
