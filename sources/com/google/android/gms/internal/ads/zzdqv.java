package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzdqv<E> {
    private static final zzdzw<?> zzhps = zzdzk.zzag(null);
    private final ScheduledExecutorService zzfth;
    private final zzdzv zzghl;
    private final zzdrh<E> zzhpt;

    public zzdqv(zzdzv zzdzvVar, ScheduledExecutorService scheduledExecutorService, zzdrh<E> zzdrhVar) {
        this.zzghl = zzdzvVar;
        this.zzfth = scheduledExecutorService;
        this.zzhpt = zzdrhVar;
    }

    public static /* synthetic */ zzdrh zzc(zzdqv zzdqvVar) {
        return zzdqvVar.zzhpt;
    }

    public final <I> zzdrb<I> zza(E e2, zzdzw<I> zzdzwVar) {
        return new zzdrb<>(this, e2, zzdzwVar, Collections.singletonList(zzdzwVar), zzdzwVar);
    }

    public final zzdqz zzt(E e2) {
        return new zzdqz(this, e2);
    }

    public abstract String zzu(E e2);

    public final zzdqx zza(E e2, zzdzw<?>... zzdzwVarArr) {
        return new zzdqx(this, e2, Arrays.asList(zzdzwVarArr));
    }
}
