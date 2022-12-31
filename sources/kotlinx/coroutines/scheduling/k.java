package kotlinx.coroutines.scheduling;

import java.util.concurrent.TimeUnit;
import kotlinx.coroutines.internal.d0;
import kotlinx.coroutines.internal.f0;
/* compiled from: Tasks.kt */
/* loaded from: classes3.dex */
public final class k {
    public static final long a;
    public static final int b;
    public static final int c;

    /* renamed from: d  reason: collision with root package name */
    public static final long f8810d;

    /* renamed from: e  reason: collision with root package name */
    public static g f8811e;

    static {
        long e2;
        int a2;
        int d2;
        int e3;
        int d3;
        long e4;
        e2 = f0.e("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 0L, 0L, 12, null);
        a = e2;
        f0.d("kotlinx.coroutines.scheduler.blocking.parallelism", 16, 0, 0, 12, null);
        a2 = kotlin.z.j.a(d0.a(), 2);
        d2 = f0.d("kotlinx.coroutines.scheduler.core.pool.size", a2, 1, 0, 8, null);
        b = d2;
        e3 = kotlin.z.j.e(d0.a() * 128, d2, 2097150);
        d3 = f0.d("kotlinx.coroutines.scheduler.max.pool.size", e3, 0, 2097150, 4, null);
        c = d3;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        e4 = f0.e("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 0L, 0L, 12, null);
        f8810d = timeUnit.toNanos(e4);
        f8811e = e.a;
    }
}
