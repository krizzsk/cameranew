package com.pinguo.camera360.adv.BroadCastManager;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
/* compiled from: ActiveRegistBroadcastManager.java */
/* loaded from: classes3.dex */
public class a {
    public static void a(Context context) {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme("package");
        context.registerReceiver(new InstallBroadCastReceiver(), intentFilter);
    }
}
