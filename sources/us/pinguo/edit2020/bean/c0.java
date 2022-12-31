package us.pinguo.edit2020.bean;

import us.pinguo.edit2020.bean.x;
/* compiled from: ManualMattingFunction.kt */
/* loaded from: classes4.dex */
public final class c0 implements x {
    private final String a;
    private final int b;
    private final int c;

    /* renamed from: d  reason: collision with root package name */
    private int f10178d;

    /* renamed from: e  reason: collision with root package name */
    private int f10179e;

    /* renamed from: f  reason: collision with root package name */
    private int f10180f;

    /* renamed from: g  reason: collision with root package name */
    private int f10181g;

    public c0(String key, int i2, int i3) {
        kotlin.jvm.internal.s.h(key, "key");
        this.a = key;
        this.b = i2;
        this.c = i3;
        this.f10178d = 25;
        this.f10179e = 50;
        this.f10180f = 40;
        this.f10181g = 50;
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
        String string = us.pinguo.foundation.e.b().getString(this.b);
        kotlin.jvm.internal.s.g(string, "getAppContext().getString(nameId)");
        return string;
    }

    @Override // us.pinguo.edit2020.bean.x
    public int d() {
        return this.c;
    }

    @Override // us.pinguo.edit2020.bean.x
    public boolean e() {
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c0) {
            c0 c0Var = (c0) obj;
            return kotlin.jvm.internal.s.c(this.a, c0Var.a) && this.b == c0Var.b && this.c == c0Var.c;
        }
        return false;
    }

    @Override // us.pinguo.edit2020.bean.x
    public String f() {
        return this.a;
    }

    public final int g() {
        return this.f10179e;
    }

    public final int h() {
        return this.f10178d;
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b) * 31) + this.c;
    }

    public final int i() {
        return this.f10181g;
    }

    public final int j() {
        return this.f10180f;
    }

    public final String k() {
        return this.a;
    }

    public final void l(int i2) {
        this.f10179e = i2;
    }

    public final void m(int i2) {
        this.f10178d = i2;
    }

    public final void n(int i2) {
        this.f10181g = i2;
    }

    public final void o(int i2) {
        this.f10180f = i2;
    }

    public String toString() {
        return "ManualMattingFunction(key=" + this.a + ", nameId=" + this.b + ", iconId=" + this.c + ')';
    }
}
