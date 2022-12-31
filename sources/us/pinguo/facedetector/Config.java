package us.pinguo.facedetector;

import kotlin.jvm.internal.s;
/* compiled from: Config.kt */
/* loaded from: classes4.dex */
public final class Config {
    private int b;
    private Mode a = Mode.TRACKING_ROBUST;
    private int c = 256;

    /* compiled from: Config.kt */
    /* loaded from: classes4.dex */
    public enum Mode {
        STATIC_NORMAL,
        TRACKING_RECT,
        TRACKING_FAST,
        TRACKING_ROBUST
    }

    public final Mode a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public final int c() {
        return this.c;
    }

    public final void d(float f2) {
    }

    public final void e(Mode mode) {
        s.i(mode, "<set-?>");
        this.a = mode;
    }

    public final void f(int i2) {
        this.b = i2;
    }

    public final void g(int i2) {
        this.c = i2;
    }

    public final void h(boolean z) {
    }
}
