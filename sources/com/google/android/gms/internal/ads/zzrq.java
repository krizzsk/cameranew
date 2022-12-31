package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzrq implements ValueCallback<String> {
    private final /* synthetic */ zzrr zzbtu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzrq(zzrr zzrrVar) {
        this.zzbtu = zzrrVar;
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(String str) {
        zzrr zzrrVar = this.zzbtu;
        zzrrVar.zzbth.zza(zzrrVar.zzbtw, zzrrVar.zzbtx, str, zzrrVar.zzbty);
    }
}
