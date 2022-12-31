package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzqu extends BroadcastReceiver {
    private final /* synthetic */ zzqs zzbrs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzqu(zzqs zzqsVar) {
        this.zzbrs = zzqsVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        VdsAgent.onBroadcastReceiver(this, context, intent);
        this.zzbrs.zzbr(3);
    }
}
