package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcle {
    public static Set<zzbya<zzbsh>> zza(zzclo zzcloVar, Executor executor) {
        return zzc(zzcloVar, executor);
    }

    public static Set<zzbya<AppEventListener>> zzb(zzclo zzcloVar, Executor executor) {
        return zzc(zzcloVar, executor);
    }

    public static Set<zzbya<zzbtb>> zzc(zzclo zzcloVar, Executor executor) {
        return zzc(zzcloVar, executor);
    }

    public static Set<zzbya<zzbrr>> zzd(zzclo zzcloVar, Executor executor) {
        return zzc(zzcloVar, executor);
    }

    public static Set<zzbya<zzbrm>> zze(zzclo zzcloVar, Executor executor) {
        return zzc(zzcloVar, executor);
    }

    public static Set<zzbya<zzbse>> zzf(zzclo zzcloVar, Executor executor) {
        return zzc(zzcloVar, executor);
    }

    public static Set<zzbya<zzvc>> zzg(zzclo zzcloVar, Executor executor) {
        return zzc(zzcloVar, executor);
    }

    public static Set<zzbya<zzdrp>> zzh(zzclo zzcloVar, Executor executor) {
        return zzc(zzcloVar, executor);
    }

    public static Set<zzbya<zzbua>> zzi(zzclo zzcloVar, Executor executor) {
        return zzc(zzcloVar, executor);
    }

    private static <T> Set<zzbya<T>> zzc(T t, Executor executor) {
        if (zzadl.zzdee.get().booleanValue()) {
            return Collections.singleton(new zzbya(t, executor));
        }
        return Collections.emptySet();
    }
}
