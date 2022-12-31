package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdzy {
    public static zzdzv zza(ExecutorService executorService) {
        if (executorService instanceof zzdzv) {
            return (zzdzv) executorService;
        }
        if (executorService instanceof ScheduledExecutorService) {
            return new zzdzz((ScheduledExecutorService) executorService);
        }
        return new zzeaa(executorService);
    }

    public static Executor zzbaf() {
        return zzdzd.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor zza(Executor executor, zzdyk<?> zzdykVar) {
        zzdwl.checkNotNull(executor);
        zzdwl.checkNotNull(zzdykVar);
        return executor == zzdzd.INSTANCE ? executor : new zzdzx(executor, zzdykVar);
    }
}
