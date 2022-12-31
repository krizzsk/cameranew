package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.core.location.LocationRequestCompat;
/* compiled from: BUGLY */
/* loaded from: classes3.dex */
public final class aa implements Runnable {
    private final Handler a;
    private final String b;
    private long c;

    /* renamed from: d  reason: collision with root package name */
    private final long f7919d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f7920e = true;

    /* renamed from: f  reason: collision with root package name */
    private long f7921f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(Handler handler, String str, long j2) {
        this.a = handler;
        this.b = str;
        this.c = j2;
        this.f7919d = j2;
    }

    public final void a() {
        if (this.f7920e) {
            this.f7920e = false;
            this.f7921f = SystemClock.uptimeMillis();
            this.a.post(this);
        }
    }

    public final boolean b() {
        return !this.f7920e && SystemClock.uptimeMillis() > this.f7921f + this.c;
    }

    public final int c() {
        if (this.f7920e) {
            return 0;
        }
        return SystemClock.uptimeMillis() - this.f7921f < this.c ? 1 : 3;
    }

    public final String d() {
        return this.b;
    }

    public final Looper e() {
        return this.a.getLooper();
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7920e = true;
        this.c = this.f7919d;
    }

    public final void a(long j2) {
        this.c = LocationRequestCompat.PASSIVE_INTERVAL;
    }
}
