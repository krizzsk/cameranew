package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.concurrent.atomic.AtomicInteger;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbag implements zzdzl<T> {
    private final /* synthetic */ zzbad zzeis;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbag(zzbad zzbadVar) {
        this.zzeis = zzbadVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final void onSuccess(@Nullable T t) {
        AtomicInteger atomicInteger;
        atomicInteger = this.zzeis.zzeip;
        atomicInteger.set(1);
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final void zzb(Throwable th) {
        AtomicInteger atomicInteger;
        atomicInteger = this.zzeis.zzeip;
        atomicInteger.set(-1);
    }
}
