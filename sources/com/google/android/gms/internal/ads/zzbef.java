package com.google.android.gms.internal.ads;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbef implements Runnable {
    private final /* synthetic */ View val$view;
    private final /* synthetic */ zzawz zzerl;
    private final /* synthetic */ int zzerm;
    private final /* synthetic */ zzbee zzern;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbef(zzbee zzbeeVar, View view, zzawz zzawzVar, int i2) {
        this.zzern = zzbeeVar;
        this.val$view = view;
        this.zzerl = zzawzVar;
        this.zzerm = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzern.zza(this.val$view, this.zzerl, this.zzerm - 1);
    }
}
