package com.google.android.gms.internal.ads;

import android.view.View;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzro implements Runnable {
    private final /* synthetic */ View zzbtg;
    private final /* synthetic */ zzrp zzbth;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzro(zzrp zzrpVar, View view) {
        this.zzbth = zzrpVar;
        this.zzbtg = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzbth.zzj(this.zzbtg);
    }
}
