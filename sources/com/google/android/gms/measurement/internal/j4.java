package com.google.android.gms.measurement.internal;

import androidx.annotation.NonNull;
import androidx.core.location.LocationRequestCompat;
import java.lang.Thread;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicLong;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class j4<V> extends FutureTask<V> implements Comparable<j4<V>> {
    private final long a;
    final boolean b;
    private final String c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ l4 f3845d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j4(l4 l4Var, Runnable runnable, boolean z, String str) {
        super(runnable, null);
        AtomicLong atomicLong;
        this.f3845d = l4Var;
        com.google.android.gms.common.internal.q.j(str);
        atomicLong = l4.f3858l;
        long andIncrement = atomicLong.getAndIncrement();
        this.a = andIncrement;
        this.c = str;
        this.b = z;
        if (andIncrement == LocationRequestCompat.PASSIVE_INTERVAL) {
            l4Var.a.a().m().a("Tasks index overflow");
        }
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(@NonNull Object obj) {
        j4 j4Var = (j4) obj;
        boolean z = this.b;
        if (z != j4Var.b) {
            return !z ? 1 : -1;
        }
        int i2 = (this.a > j4Var.a ? 1 : (this.a == j4Var.a ? 0 : -1));
        if (i2 < 0) {
            return -1;
        }
        if (i2 > 0) {
            return 1;
        }
        this.f3845d.a.a().n().b("Two tasks share the same index. index", Long.valueOf(this.a));
        return 0;
    }

    @Override // java.util.concurrent.FutureTask
    protected final void setException(Throwable th) {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler;
        this.f3845d.a.a().m().b(this.c, th);
        if ((th instanceof zzfe) && (defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler()) != null) {
            defaultUncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
        }
        super.setException(th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j4(l4 l4Var, Callable<V> callable, boolean z, String str) {
        super(callable);
        AtomicLong atomicLong;
        this.f3845d = l4Var;
        com.google.android.gms.common.internal.q.j("Task exception on worker thread");
        atomicLong = l4.f3858l;
        long andIncrement = atomicLong.getAndIncrement();
        this.a = andIncrement;
        this.c = "Task exception on worker thread";
        this.b = z;
        if (andIncrement == LocationRequestCompat.PASSIVE_INTERVAL) {
            l4Var.a.a().m().a("Tasks index overflow");
        }
    }
}
