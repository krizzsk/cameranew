package us.pinguo.image.saver;

import kotlin.jvm.internal.o;
/* compiled from: Saver2020.kt */
/* loaded from: classes4.dex */
public final class b {
    private byte[] a;
    private int b;
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f11174d;

    public b(byte[] bArr, int i2, boolean z, boolean z2) {
        this.a = bArr;
        this.b = i2;
        this.c = z;
        this.f11174d = z2;
    }

    public final boolean a() {
        return this.f11174d;
    }

    public final byte[] b() {
        return this.a;
    }

    public final int c() {
        return this.b;
    }

    public final boolean d() {
        return this.c;
    }

    public final void e(boolean z) {
        this.f11174d = z;
    }

    public final void f(boolean z) {
        this.c = z;
    }

    public /* synthetic */ b(byte[] bArr, int i2, boolean z, boolean z2, int i3, o oVar) {
        this((i3 & 1) != 0 ? null : bArr, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? false : z, (i3 & 8) != 0 ? false : z2);
    }
}
