package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzfa extends BroadcastReceiver {
    private boolean zzyv = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfa(@NonNull Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        context.registerReceiver(this, intentFilter);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        VdsAgent.onBroadcastReceiver(this, context, intent);
        if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
            this.zzyv = true;
        } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            this.zzyv = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzcf() {
        return this.zzyv;
    }
}
