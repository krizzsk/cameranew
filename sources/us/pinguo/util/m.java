package us.pinguo.util;

import android.util.Log;
/* compiled from: FpsCounter.kt */
/* loaded from: classes6.dex */
public final class m {
    private boolean a;
    private long b = 1000;
    private long c;

    /* renamed from: d  reason: collision with root package name */
    private long f12481d;

    /* renamed from: e  reason: collision with root package name */
    private long f12482e;

    /* renamed from: f  reason: collision with root package name */
    private long f12483f;

    public m(boolean z) {
        c(z);
        Log.d("FpsCounter", kotlin.jvm.internal.s.q("FpsCounter.isEnable=", Boolean.valueOf(this.a)));
    }

    public final void a() {
        if (this.a) {
            if (this.f12483f != 0 && this.f12482e != 0) {
                long currentTimeMillis = System.currentTimeMillis();
                long j2 = currentTimeMillis - this.f12481d;
                long j3 = this.f12483f + 1;
                this.f12483f = j3;
                if (j2 >= this.b) {
                    us.pinguo.common.log.a.r("FpsCounter", "currentFps:" + (((j3 - this.c) * 1000) / j2) + ", averageFps:" + ((j3 * 1000) / (currentTimeMillis - this.f12482e)) + ", frameCount:" + this.f12483f, new Object[0]);
                    this.f12481d = currentTimeMillis;
                    this.c = this.f12483f;
                    return;
                }
                return;
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            this.f12482e = currentTimeMillis2;
            this.f12481d = currentTimeMillis2;
            this.c = 0L;
            this.f12483f++;
        }
    }

    public final void b() {
        this.c = 0L;
        this.f12481d = 0L;
        this.f12482e = 0L;
        this.f12483f = 0L;
    }

    public final void c(boolean z) {
        if (this.a != z) {
            b();
            this.a = z;
        }
    }
}
