package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final /* synthetic */ class zzcpy implements Callable {
    private final zzcpt zzgqn;

    private zzcpy(zzcpt zzcptVar) {
        this.zzgqn = zzcptVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Callable zza(zzcpt zzcptVar) {
        return new zzcpy(zzcptVar);
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.zzgqn.getWritableDatabase();
    }
}
