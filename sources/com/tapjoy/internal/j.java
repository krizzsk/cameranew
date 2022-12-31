package com.tapjoy.internal;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* loaded from: classes3.dex */
public class j extends BroadcastReceiver {
    /* JADX INFO: Access modifiers changed from: protected */
    public final int a(Context context, Intent intent) {
        int i2 = 0;
        try {
            Bundle bundle = context.getPackageManager().getReceiverInfo(new ComponentName(context, getClass()), 128).metaData;
            if (bundle != null) {
                for (String str : bundle.keySet()) {
                    String string = bundle.getString(str);
                    if (string != null) {
                        try {
                            Object newInstance = Class.forName(string).newInstance();
                            if (newInstance instanceof BroadcastReceiver) {
                                BroadcastReceiver broadcastReceiver = (BroadcastReceiver) newInstance;
                                Intent intent2 = new Intent(intent);
                                intent2.setComponent(new ComponentName(context, string));
                                broadcastReceiver.onReceive(context, intent2);
                                i2++;
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException unused2) {
        }
        return i2;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        VdsAgent.onBroadcastReceiver(this, context, intent);
        a(context, intent);
    }
}
