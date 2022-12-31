package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.ads.zzbw;
import com.google.android.gms.tasks.a;
import com.google.android.gms.tasks.g;
import com.google.android.gms.tasks.j;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdsy {
    private static volatile zzbw.zza.zzc zzhsm = zzbw.zza.zzc.UNKNOWN;
    private final Context context;
    private final Executor executor;
    private final g<zztz> zzhsl;

    private zzdsy(@NonNull Context context, @NonNull Executor executor, @NonNull g<zztz> gVar) {
        this.context = context;
        this.executor = executor;
        this.zzhsl = gVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(zzbw.zza.zzc zzcVar) {
        zzhsm = zzcVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ zztz zzcj(Context context) throws Exception {
        return new zztz(context, "GLAS", null);
    }

    public final g<Boolean> zzb(int i2, long j2, String str) {
        return zza(i2, j2, null, null, null, str);
    }

    public final g<Boolean> zzg(int i2, String str) {
        return zza(i2, 0L, null, null, null, str);
    }

    public final g<Boolean> zzh(int i2, long j2) {
        return zza(i2, j2, null, null, null, null);
    }

    public static zzdsy zza(@NonNull final Context context, @NonNull Executor executor) {
        return new zzdsy(context, executor, j.c(executor, new Callable(context) { // from class: com.google.android.gms.internal.ads.zzdta
            private final Context zzcmi;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzcmi = context;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzdsy.zzcj(this.zzcmi);
            }
        }));
    }

    public final g<Boolean> zza(int i2, long j2, Exception exc) {
        return zza(i2, j2, exc, null, null, null);
    }

    public final g<Boolean> zza(int i2, long j2, String str, Map<String, String> map) {
        return zza(i2, j2, null, str, null, null);
    }

    private final g<Boolean> zza(final int i2, long j2, Exception exc, String str, Map<String, String> map, String str2) {
        final zzbw.zza.zzb zzd = zzbw.zza.zzs().zzo(this.context.getPackageName()).zzd(j2);
        zzd.zzb(zzhsm);
        if (exc != null) {
            zzd.zzp(zzdwv.zza(exc)).zzq(exc.getClass().getName());
        }
        if (str2 != null) {
            zzd.zzr(str2);
        }
        if (str != null) {
            zzd.zzs(str);
        }
        return this.zzhsl.f(this.executor, new a(zzd, i2) { // from class: com.google.android.gms.internal.ads.zzdsz
            private final int zzefe;
            private final zzbw.zza.zzb zzhsn;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhsn = zzd;
                this.zzefe = i2;
            }

            @Override // com.google.android.gms.tasks.a
            public final Object then(g gVar) {
                return zzdsy.zza(this.zzhsn, this.zzefe, gVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ Boolean zza(zzbw.zza.zzb zzbVar, int i2, g gVar) throws Exception {
        if (gVar.n()) {
            zzud zzf = ((zztz) gVar.j()).zzf(((zzbw.zza) ((zzelb) zzbVar.zzbiw())).toByteArray());
            zzf.zzbv(i2);
            zzf.log();
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
