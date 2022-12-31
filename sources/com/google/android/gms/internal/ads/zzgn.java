package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzgn implements Callable {
    private final String TAG = getClass().getSimpleName();
    private final String className;
    protected final zzcf.zza.zzb zzabb;
    private final String zzabj;
    protected Method zzabl;
    private final int zzabo;
    private final int zzabp;
    protected final zzfc zzwc;

    public zzgn(zzfc zzfcVar, String str, String str2, zzcf.zza.zzb zzbVar, int i2, int i3) {
        this.zzwc = zzfcVar;
        this.className = str;
        this.zzabj = str2;
        this.zzabb = zzbVar;
        this.zzabo = i2;
        this.zzabp = i3;
    }

    protected abstract void zzcw() throws IllegalAccessException, InvocationTargetException;

    @Override // java.util.concurrent.Callable
    /* renamed from: zzcy */
    public Void call() throws Exception {
        long nanoTime;
        Method zza;
        int i2;
        try {
            nanoTime = System.nanoTime();
            zza = this.zzwc.zza(this.className, this.zzabj);
            this.zzabl = zza;
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
        if (zza == null) {
            return null;
        }
        zzcw();
        zzdw zzcl = this.zzwc.zzcl();
        if (zzcl != null && (i2 = this.zzabo) != Integer.MIN_VALUE) {
            zzcl.zza(this.zzabp, i2, (System.nanoTime() - nanoTime) / 1000);
        }
        return null;
    }
}
