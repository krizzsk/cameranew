package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbaf implements zzdzl<T> {
    private final /* synthetic */ zzbae zzeiq;
    private final /* synthetic */ zzbac zzeir;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbaf(zzbad zzbadVar, zzbae zzbaeVar, zzbac zzbacVar) {
        this.zzeiq = zzbaeVar;
        this.zzeir = zzbacVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final void onSuccess(@Nullable T t) {
        this.zzeiq.zzg(t);
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final void zzb(Throwable th) {
        this.zzeir.run();
    }
}
