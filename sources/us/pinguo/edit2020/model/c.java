package us.pinguo.edit2020.model;

import java.util.concurrent.CountDownLatch;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
/* compiled from: EditRender.kt */
/* loaded from: classes4.dex */
public final class c {
    private final int a;
    private final int b;
    private final int c;

    /* renamed from: d  reason: collision with root package name */
    private final float f10548d;

    /* renamed from: e  reason: collision with root package name */
    private final CountDownLatch f10549e;

    public c(int i2, int i3, int i4, float f2, CountDownLatch lock) {
        s.h(lock, "lock");
        this.a = i2;
        this.b = i3;
        this.c = i4;
        this.f10548d = f2;
        this.f10549e = lock;
    }

    public final float a() {
        return this.f10548d;
    }

    public final int b() {
        return this.c;
    }

    public final CountDownLatch c() {
        return this.f10549e;
    }

    public final int d() {
        return this.a;
    }

    public final int e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.a == cVar.a && this.b == cVar.b && this.c == cVar.c && s.c(Float.valueOf(this.f10548d), Float.valueOf(cVar.f10548d)) && s.c(this.f10549e, cVar.f10549e);
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.a * 31) + this.b) * 31) + this.c) * 31) + Float.floatToIntBits(this.f10548d)) * 31) + this.f10549e.hashCode();
    }

    public String toString() {
        return "SpotDetectInfo(tid=" + this.a + ", width=" + this.b + ", height=" + this.c + ", eyeLength=" + this.f10548d + ", lock=" + this.f10549e + ')';
    }

    public /* synthetic */ c(int i2, int i3, int i4, float f2, CountDownLatch countDownLatch, int i5, o oVar) {
        this(i2, i3, i4, f2, (i5 & 16) != 0 ? new CountDownLatch(1) : countDownLatch);
    }
}
