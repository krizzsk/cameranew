package us.pinguo.edit2020.bean;

import android.content.Context;
import android.graphics.PointF;
/* compiled from: BodyShapingFunction.kt */
/* loaded from: classes4.dex */
public final class p extends k {
    private final float p;
    private final float q;
    private final float r;
    private final PointF s;
    private float t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(String key, String name, int i2, boolean z) {
        super(key, name, i2, z);
        kotlin.jvm.internal.s.h(key, "key");
        kotlin.jvm.internal.s.h(name, "name");
        Context b = us.pinguo.foundation.e.b();
        kotlin.jvm.internal.s.g(b, "getAppContext()");
        float b2 = us.pinguo.util.g.b(b, 38.0f);
        this.p = b2;
        Context b3 = us.pinguo.foundation.e.b();
        kotlin.jvm.internal.s.g(b3, "getAppContext()");
        this.q = us.pinguo.util.g.b(b3, 20.0f);
        Context b4 = us.pinguo.foundation.e.b();
        kotlin.jvm.internal.s.g(b4, "getAppContext()");
        this.r = us.pinguo.util.h.i(b4) * 0.5f;
        this.s = new PointF(Float.NaN, Float.NaN);
        this.t = b2;
    }

    public final PointF B() {
        return this.s;
    }

    public final float C() {
        return this.p;
    }

    public final float D() {
        return this.r;
    }

    public final float E() {
        return this.q;
    }

    public final float F() {
        return this.t;
    }

    public final void G(float f2) {
        this.t = f2;
    }
}
