package us.pinguo.edit2020.model;

import java.util.concurrent.CountDownLatch;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
/* compiled from: EditRender.kt */
/* loaded from: classes4.dex */
public final class b {
    private final int a;
    private final int b;
    private final int c;

    /* renamed from: d  reason: collision with root package name */
    private final CountDownLatch f10547d;

    public b(int i2, int i3, int i4, CountDownLatch lock) {
        s.h(lock, "lock");
        this.a = i2;
        this.b = i3;
        this.c = i4;
        this.f10547d = lock;
    }

    public final int a() {
        return this.c;
    }

    public final CountDownLatch b() {
        return this.f10547d;
    }

    public final int c() {
        return this.a;
    }

    public final int d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            return this.a == bVar.a && this.b == bVar.b && this.c == bVar.c && s.c(this.f10547d, bVar.f10547d);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.f10547d.hashCode();
    }

    public String toString() {
        return "GLRenderInfo(tid=" + this.a + ", width=" + this.b + ", height=" + this.c + ", lock=" + this.f10547d + ')';
    }

    public /* synthetic */ b(int i2, int i3, int i4, CountDownLatch countDownLatch, int i5, o oVar) {
        this(i2, i3, i4, (i5 & 8) != 0 ? new CountDownLatch(1) : countDownLatch);
    }
}
