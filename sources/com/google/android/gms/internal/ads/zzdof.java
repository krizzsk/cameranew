package com.google.android.gms.internal.ads;

import java.util.Deque;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingDeque;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdof<T> {
    private final zzdzv zzghl;
    @GuardedBy("this")
    private final Deque<zzdzw<T>> zzhlo = new LinkedBlockingDeque();
    private final Callable<T> zzhlp;

    public zzdof(Callable<T> callable, zzdzv zzdzvVar) {
        this.zzhlp = callable;
        this.zzghl = zzdzvVar;
    }

    public final synchronized void ensureSize(int i2) {
        int size = i2 - this.zzhlo.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.zzhlo.add(this.zzghl.zze(this.zzhlp));
        }
    }

    public final synchronized zzdzw<T> zzavm() {
        ensureSize(1);
        return this.zzhlo.poll();
    }

    public final synchronized void zzd(zzdzw<T> zzdzwVar) {
        this.zzhlo.addFirst(zzdzwVar);
    }
}
