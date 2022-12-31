package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdrb<O> {
    private final E zzhpu;
    @Nullable
    private final String zzhpv;
    private final List<zzdzw<?>> zzhpx;
    final /* synthetic */ zzdqv zzhpy;
    private final zzdzw<?> zzhpz;
    private final zzdzw<O> zzhqa;

    private zzdrb(zzdqv zzdqvVar, E e2, String str, zzdzw<?> zzdzwVar, List<zzdzw<?>> list, zzdzw<O> zzdzwVar2) {
        this.zzhpy = zzdqvVar;
        this.zzhpu = e2;
        this.zzhpv = str;
        this.zzhpz = zzdzwVar;
        this.zzhpx = list;
        this.zzhqa = zzdzwVar2;
    }

    public final <O2> zzdrb<O2> zza(zzdyu<O, O2> zzdyuVar) {
        return zza(zzdyuVar, zzdqv.zza(this.zzhpy));
    }

    public final zzdqw<E, O> zzaxj() {
        E e2 = this.zzhpu;
        String str = this.zzhpv;
        if (str == null) {
            str = this.zzhpy.zzu(e2);
        }
        final zzdqw<E, O> zzdqwVar = new zzdqw<>(e2, str, this.zzhqa);
        zzdqv.zzc(this.zzhpy).zza(zzdqwVar);
        zzdzw<?> zzdzwVar = this.zzhpz;
        Runnable runnable = new Runnable(this, zzdqwVar) { // from class: com.google.android.gms.internal.ads.zzdrf
            private final zzdrb zzhqd;
            private final zzdqw zzhqe;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhqd = this;
                this.zzhqe = zzdqwVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzdrh zzdrhVar;
                zzdrb zzdrbVar = this.zzhqd;
                zzdqw zzdqwVar2 = this.zzhqe;
                zzdrhVar = zzdrbVar.zzhpy.zzhpt;
                zzdrhVar.zzb(zzdqwVar2);
            }
        };
        zzdzv zzdzvVar = zzazp.zzeih;
        zzdzwVar.addListener(runnable, zzdzvVar);
        zzdzk.zza(zzdqwVar, new zzdri(this, zzdqwVar), zzdzvVar);
        return zzdqwVar;
    }

    public final <O2> zzdrb<O2> zzb(final zzdqu<O, O2> zzdquVar) {
        return zza(new zzdyu(zzdquVar) { // from class: com.google.android.gms.internal.ads.zzdre
            private final zzdqu zzhqc;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhqc = zzdquVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdyu
            public final zzdzw zzf(Object obj) {
                return zzdzk.zzag(this.zzhqc.apply(obj));
            }
        });
    }

    public final <O2> zzdrb<O2> zze(final zzdzw<O2> zzdzwVar) {
        return zza(new zzdyu(zzdzwVar) { // from class: com.google.android.gms.internal.ads.zzdrd
            private final zzdzw zzgig;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgig = zzdzwVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdyu
            public final zzdzw zzf(Object obj) {
                return this.zzgig;
            }
        }, zzazp.zzeih);
    }

    public final zzdrb<O> zzgu(String str) {
        return new zzdrb<>(this.zzhpy, this.zzhpu, str, this.zzhpz, this.zzhpx, this.zzhqa);
    }

    public final zzdrb<O> zzv(E e2) {
        return this.zzhpy.zza((zzdqv) e2, zzaxj());
    }

    private final <O2> zzdrb<O2> zza(zzdyu<O, O2> zzdyuVar, Executor executor) {
        return new zzdrb<>(this.zzhpy, this.zzhpu, this.zzhpv, this.zzhpz, this.zzhpx, zzdzk.zzb(this.zzhqa, zzdyuVar, executor));
    }

    public final <T extends Throwable> zzdrb<O> zza(Class<T> cls, final zzdqu<T, O> zzdquVar) {
        return zza(cls, new zzdyu(zzdquVar) { // from class: com.google.android.gms.internal.ads.zzdrg
            private final zzdqu zzhqc;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhqc = zzdquVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdyu
            public final zzdzw zzf(Object obj) {
                return zzdzk.zzag(this.zzhqc.apply((Throwable) obj));
            }
        });
    }

    public final <T extends Throwable> zzdrb<O> zza(Class<T> cls, zzdyu<T, O> zzdyuVar) {
        zzdqv zzdqvVar = this.zzhpy;
        return new zzdrb<>(zzdqvVar, this.zzhpu, this.zzhpv, this.zzhpz, this.zzhpx, zzdzk.zzb(this.zzhqa, cls, zzdyuVar, zzdqv.zza(zzdqvVar)));
    }

    public final zzdrb<O> zza(long j2, TimeUnit timeUnit) {
        zzdqv zzdqvVar = this.zzhpy;
        return new zzdrb<>(zzdqvVar, this.zzhpu, this.zzhpv, this.zzhpz, this.zzhpx, zzdzk.zza(this.zzhqa, j2, timeUnit, zzdqv.zzb(zzdqvVar)));
    }
}
