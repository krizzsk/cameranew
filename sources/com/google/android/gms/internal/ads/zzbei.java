package com.google.android.gms.internal.ads;

import android.view.View;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzbei implements View.OnAttachStateChangeListener {
    private final /* synthetic */ zzawz zzerl;
    private final /* synthetic */ zzbee zzern;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbei(zzbee zzbeeVar, zzawz zzawzVar) {
        this.zzern = zzbeeVar;
        this.zzerl = zzawzVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.zzern.zza(view, this.zzerl, 10);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }
}
