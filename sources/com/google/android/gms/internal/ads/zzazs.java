package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzazs extends ScheduledThreadPoolExecutor {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzazs(int i2, ThreadFactory threadFactory) {
        super(3, threadFactory);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        super.execute(zzdvh.zzayy().zzf(runnable));
    }
}
