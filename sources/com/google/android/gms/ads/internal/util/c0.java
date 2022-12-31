package com.google.android.gms.ads.internal.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class c0 extends BroadcastReceiver {
    private final /* synthetic */ zzj a;

    private c0(zzj zzjVar) {
        this.a = zzjVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        VdsAgent.onBroadcastReceiver(this, context, intent);
        if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
            this.a.c = true;
        } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            this.a.c = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ c0(zzj zzjVar, w wVar) {
        this(zzjVar);
    }
}
