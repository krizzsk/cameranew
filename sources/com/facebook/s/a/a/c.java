package com.facebook.s.a.a;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.facebook.s.a.a.a;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
/* compiled from: AnimationBackendDelegateWithInactivityCheck.java */
/* loaded from: classes.dex */
public class c<T extends com.facebook.s.a.a.a> extends com.facebook.s.a.a.b<T> {
    private final com.facebook.common.time.b b;
    private final ScheduledExecutorService c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f3156d;

    /* renamed from: e  reason: collision with root package name */
    private long f3157e;

    /* renamed from: f  reason: collision with root package name */
    private long f3158f;

    /* renamed from: g  reason: collision with root package name */
    private long f3159g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private b f3160h;

    /* renamed from: i  reason: collision with root package name */
    private final Runnable f3161i;

    /* compiled from: AnimationBackendDelegateWithInactivityCheck.java */
    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (c.this) {
                c.this.f3156d = false;
                if (c.this.p()) {
                    if (c.this.f3160h != null) {
                        c.this.f3160h.h();
                    }
                } else {
                    c.this.q();
                }
            }
        }
    }

    /* compiled from: AnimationBackendDelegateWithInactivityCheck.java */
    /* loaded from: classes.dex */
    public interface b {
        void h();
    }

    private c(@Nullable T t, @Nullable b bVar, com.facebook.common.time.b bVar2, ScheduledExecutorService scheduledExecutorService) {
        super(t);
        this.f3156d = false;
        this.f3158f = 2000L;
        this.f3159g = 1000L;
        this.f3161i = new a();
        this.f3160h = bVar;
        this.b = bVar2;
        this.c = scheduledExecutorService;
    }

    public static <T extends com.facebook.s.a.a.a & b> com.facebook.s.a.a.b<T> n(T t, com.facebook.common.time.b bVar, ScheduledExecutorService scheduledExecutorService) {
        return o(t, (b) t, bVar, scheduledExecutorService);
    }

    public static <T extends com.facebook.s.a.a.a> com.facebook.s.a.a.b<T> o(T t, b bVar, com.facebook.common.time.b bVar2, ScheduledExecutorService scheduledExecutorService) {
        return new c(t, bVar, bVar2, scheduledExecutorService);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p() {
        return this.b.now() - this.f3157e > this.f3158f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void q() {
        if (!this.f3156d) {
            this.f3156d = true;
            this.c.schedule(this.f3161i, this.f3159g, TimeUnit.MILLISECONDS);
        }
    }

    @Override // com.facebook.s.a.a.b, com.facebook.s.a.a.a
    public boolean g(Drawable drawable, Canvas canvas, int i2) {
        this.f3157e = this.b.now();
        boolean g2 = super.g(drawable, canvas, i2);
        q();
        return g2;
    }
}
