package com.adjust.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* loaded from: classes.dex */
public class AdjustReferrerReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        VdsAgent.onBroadcastReceiver(this, context, intent);
        String stringExtra = intent.getStringExtra("referrer");
        if (stringExtra == null) {
            return;
        }
        Adjust.getDefaultInstance().sendReferrer(stringExtra, context);
    }
}
