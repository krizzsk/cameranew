package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public interface zzdve {
    ExecutorService zza(int i2, ThreadFactory threadFactory, int i3);

    ExecutorService zza(ThreadFactory threadFactory, int i2);

    ExecutorService zzb(ThreadFactory threadFactory, int i2);

    ScheduledExecutorService zzb(int i2, ThreadFactory threadFactory, int i3);

    ExecutorService zzel(int i2);

    ExecutorService zzem(int i2);
}
