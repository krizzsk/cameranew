package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzfl extends BroadcastReceiver {
    private final /* synthetic */ zzfj zzaar;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfl(zzfj zzfjVar) {
        this.zzaar = zzfjVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        VdsAgent.onBroadcastReceiver(this, context, intent);
        this.zzaar.zzcv();
    }
}
