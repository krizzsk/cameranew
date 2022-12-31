package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import androidx.annotation.VisibleForTesting;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes.dex */
public class JobScheduler {
    private final Executor a;
    private final d b;

    /* renamed from: e  reason: collision with root package name */
    private final int f2866e;
    private final Runnable c = new a();

    /* renamed from: d  reason: collision with root package name */
    private final Runnable f2865d = new b();
    @GuardedBy("this")
    @Nullable
    @VisibleForTesting

    /* renamed from: f  reason: collision with root package name */
    com.facebook.imagepipeline.image.e f2867f = null;
    @GuardedBy("this")
    @VisibleForTesting

    /* renamed from: g  reason: collision with root package name */
    int f2868g = 0;
    @GuardedBy("this")
    @VisibleForTesting

    /* renamed from: h  reason: collision with root package name */
    JobState f2869h = JobState.IDLE;
    @GuardedBy("this")
    @VisibleForTesting

    /* renamed from: i  reason: collision with root package name */
    long f2870i = 0;
    @GuardedBy("this")
    @VisibleForTesting

    /* renamed from: j  reason: collision with root package name */
    long f2871j = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes.dex */
    public enum JobState {
        IDLE,
        QUEUED,
        RUNNING,
        RUNNING_AND_PENDING
    }

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.d();
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            JobScheduler.this.j();
        }
    }

    /* loaded from: classes.dex */
    static /* synthetic */ class c {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[JobState.values().length];
            a = iArr;
            try {
                iArr[JobState.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[JobState.QUEUED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[JobState.RUNNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[JobState.RUNNING_AND_PENDING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(com.facebook.imagepipeline.image.e eVar, int i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes.dex */
    public static class e {
        private static ScheduledExecutorService a;

        static ScheduledExecutorService a() {
            if (a == null) {
                a = Executors.newSingleThreadScheduledExecutor();
            }
            return a;
        }
    }

    public JobScheduler(Executor executor, d dVar, int i2) {
        this.a = executor;
        this.b = dVar;
        this.f2866e = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        com.facebook.imagepipeline.image.e eVar;
        int i2;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            eVar = this.f2867f;
            i2 = this.f2868g;
            this.f2867f = null;
            this.f2868g = 0;
            this.f2869h = JobState.RUNNING;
            this.f2871j = uptimeMillis;
        }
        try {
            if (i(eVar, i2)) {
                this.b.a(eVar, i2);
            }
        } finally {
            com.facebook.imagepipeline.image.e.h(eVar);
            g();
        }
    }

    private void e(long j2) {
        Runnable a2 = com.facebook.imagepipeline.d.a.a(this.f2865d, "JobScheduler_enqueueJob");
        if (j2 > 0) {
            e.a().schedule(a2, j2, TimeUnit.MILLISECONDS);
        } else {
            a2.run();
        }
    }

    private void g() {
        long j2;
        boolean z;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            if (this.f2869h == JobState.RUNNING_AND_PENDING) {
                j2 = Math.max(this.f2871j + this.f2866e, uptimeMillis);
                z = true;
                this.f2870i = uptimeMillis;
                this.f2869h = JobState.QUEUED;
            } else {
                this.f2869h = JobState.IDLE;
                j2 = 0;
                z = false;
            }
        }
        if (z) {
            e(j2 - uptimeMillis);
        }
    }

    private static boolean i(@Nullable com.facebook.imagepipeline.image.e eVar, int i2) {
        return com.facebook.imagepipeline.producers.b.d(i2) || com.facebook.imagepipeline.producers.b.m(i2, 4) || com.facebook.imagepipeline.image.e.Z(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.a.execute(com.facebook.imagepipeline.d.a.a(this.c, "JobScheduler_submitJob"));
    }

    public void c() {
        com.facebook.imagepipeline.image.e eVar;
        synchronized (this) {
            eVar = this.f2867f;
            this.f2867f = null;
            this.f2868g = 0;
        }
        com.facebook.imagepipeline.image.e.h(eVar);
    }

    public synchronized long f() {
        return this.f2871j - this.f2870i;
    }

    public boolean h() {
        long max;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            boolean z = false;
            if (i(this.f2867f, this.f2868g)) {
                int i2 = c.a[this.f2869h.ordinal()];
                if (i2 != 1) {
                    if (i2 == 3) {
                        this.f2869h = JobState.RUNNING_AND_PENDING;
                    }
                    max = 0;
                } else {
                    max = Math.max(this.f2871j + this.f2866e, uptimeMillis);
                    this.f2870i = uptimeMillis;
                    this.f2869h = JobState.QUEUED;
                    z = true;
                }
                if (z) {
                    e(max - uptimeMillis);
                }
                return true;
            }
            return false;
        }
    }

    public boolean k(@Nullable com.facebook.imagepipeline.image.e eVar, int i2) {
        com.facebook.imagepipeline.image.e eVar2;
        if (i(eVar, i2)) {
            synchronized (this) {
                eVar2 = this.f2867f;
                this.f2867f = com.facebook.imagepipeline.image.e.e(eVar);
                this.f2868g = i2;
            }
            com.facebook.imagepipeline.image.e.h(eVar2);
            return true;
        }
        return false;
    }
}
