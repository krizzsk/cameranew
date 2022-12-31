package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public interface zzdzv extends ExecutorService {
    <T> zzdzw<T> zze(Callable<T> callable);

    zzdzw<?> zzg(Runnable runnable);
}
