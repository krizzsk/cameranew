package us.pinguo.edit2020.bean;

import us.pinguo.edit2020.bean.x;
/* compiled from: StickerAdjustmentFunction.kt */
/* loaded from: classes4.dex */
public final class p0 implements x {
    private final String a;
    private final int b;
    private final int c;

    public p0(String key, int i2, int i3) {
        kotlin.jvm.internal.s.h(key, "key");
        this.a = key;
        this.b = i2;
        this.c = i3;
    }

    @Override // us.pinguo.edit2020.bean.x
    public boolean a() {
        return false;
    }

    @Override // us.pinguo.edit2020.bean.x
    public boolean b() {
        return x.a.a(this);
    }

    @Override // us.pinguo.edit2020.bean.x
    public String c() {
        return us.pinguo.edit2020.utils.d.k(this.b);
    }

    @Override // us.pinguo.edit2020.bean.x
    public int d() {
        return this.c;
    }

    @Override // us.pinguo.edit2020.bean.x
    public boolean e() {
        return false;
    }

    @Override // us.pinguo.edit2020.bean.x
    public String f() {
        return this.a;
    }
}
