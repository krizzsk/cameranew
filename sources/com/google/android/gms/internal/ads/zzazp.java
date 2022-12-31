package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.e;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzazp {
    public static final zzdzv zzeic;
    public static final zzdzv zzeid;
    public static final zzdzv zzeie;
    public static final ScheduledExecutorService zzeif;
    public static final zzdzv zzeig;
    public static final zzdzv zzeih;

    static {
        ExecutorService threadPoolExecutor;
        ThreadPoolExecutor threadPoolExecutor2;
        ThreadPoolExecutor threadPoolExecutor3;
        if (e.a()) {
            threadPoolExecutor = zzdvd.zzayx().zza(zzfa("Default"), zzdvm.zzhvh);
        } else {
            threadPoolExecutor = new ThreadPoolExecutor(2, Integer.MAX_VALUE, 10L, TimeUnit.SECONDS, new SynchronousQueue(), zzfa("Default"));
        }
        zzeic = zza(threadPoolExecutor);
        if (e.a()) {
            threadPoolExecutor2 = zzdvd.zzayx().zza(5, zzfa("Loader"), zzdvm.zzhvg);
        } else {
            ThreadPoolExecutor threadPoolExecutor4 = new ThreadPoolExecutor(5, 5, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), zzfa("Loader"));
            threadPoolExecutor4.allowCoreThreadTimeOut(true);
            threadPoolExecutor2 = threadPoolExecutor4;
        }
        zzeid = zza(threadPoolExecutor2);
        if (e.a()) {
            threadPoolExecutor3 = zzdvd.zzayx().zzb(zzfa("Activeview"), zzdvm.zzhvg);
        } else {
            ThreadPoolExecutor threadPoolExecutor5 = new ThreadPoolExecutor(1, 1, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), zzfa("Activeview"));
            threadPoolExecutor5.allowCoreThreadTimeOut(true);
            threadPoolExecutor3 = threadPoolExecutor5;
        }
        zzeie = zza(threadPoolExecutor3);
        zzeif = new zzazs(3, zzfa("Schedule"));
        zzeig = zza(new zzazu());
        zzeih = zza(zzdzy.zzbaf());
    }

    private static zzdzv zza(Executor executor) {
        return new zzazt(executor, null);
    }

    private static ThreadFactory zzfa(String str) {
        return new zzazr(str);
    }
}
