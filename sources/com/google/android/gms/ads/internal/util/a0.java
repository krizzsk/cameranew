package com.google.android.gms.ads.internal.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.internal.ads.zzaze;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class a0 extends BroadcastReceiver {
    private a0(zzj zzjVar) {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        VdsAgent.onBroadcastReceiver(this, context, intent);
        zzaze.zzzz();
        zzb.zzaj(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ a0(zzj zzjVar, w wVar) {
        this(zzjVar);
    }
}
