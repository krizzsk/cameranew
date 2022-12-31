package com.tapjoy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.tapjoy.internal.hb;
/* loaded from: classes3.dex */
public class GCMReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        VdsAgent.onBroadcastReceiver(this, context, intent);
        boolean a = hb.b(context).a(intent);
        if (isOrderedBroadcast()) {
            setResult(-1, null, null);
            if (a) {
                abortBroadcast();
            }
        }
    }
}
