package us.pinguo.edit2020.bean;

import us.pinguo.edit2020.bean.x;
/* compiled from: LongLegFunction.kt */
/* loaded from: classes4.dex */
public final class b0 implements x {
    private final String a;
    private final String b;
    private final int c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f10164d;

    /* renamed from: e  reason: collision with root package name */
    private LongLegMode f10165e;

    /* renamed from: f  reason: collision with root package name */
    private float f10166f;

    /* renamed from: g  reason: collision with root package name */
    private float f10167g;

    /* renamed from: h  reason: collision with root package name */
    private float f10168h;

    /* renamed from: i  reason: collision with root package name */
    private float f10169i;

    /* renamed from: j  reason: collision with root package name */
    private int f10170j;

    /* renamed from: k  reason: collision with root package name */
    private float f10171k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f10172l;
    private kotlin.jvm.b.q<? super Float, ? super Float, ? super Integer, kotlin.u> m;

    public b0(String key, String name, int i2, boolean z, LongLegMode mode) {
        kotlin.jvm.internal.s.h(key, "key");
        kotlin.jvm.internal.s.h(name, "name");
        kotlin.jvm.internal.s.h(mode, "mode");
        this.a = key;
        this.b = name;
        this.c = i2;
        this.f10164d = z;
        this.f10165e = mode;
    }

    @Override // us.pinguo.edit2020.bean.x
    public boolean a() {
        return this.f10164d;
    }

    @Override // us.pinguo.edit2020.bean.x
    public boolean b() {
        return x.a.a(this);
    }

    @Override // us.pinguo.edit2020.bean.x
    public String c() {
        return this.b;
    }

    @Override // us.pinguo.edit2020.bean.x
    public int d() {
        return this.c;
    }

    @Override // us.pinguo.edit2020.bean.x
    public boolean e() {
        return this.f10170j != 0 || this.f10172l;
    }

    @Override // us.pinguo.edit2020.bean.x
    public String f() {
        return this.a;
    }

    public final float g() {
        return this.f10166f;
    }

    public final float h() {
        return this.f10167g;
    }

    public final float i() {
        return this.f10169i;
    }

    public final int j() {
        return this.f10170j;
    }

    public final LongLegMode k() {
        return this.f10165e;
    }

    public final kotlin.jvm.b.q<Float, Float, Integer, kotlin.u> l() {
        return this.m;
    }

    public final float m() {
        return this.f10171k;
    }

    public final boolean n() {
        return this.f10164d;
    }

    public final float o() {
        return this.f10168h;
    }

    public final void p(float f2) {
        this.f10166f = f2;
    }

    public final void q(float f2) {
        this.f10167g = f2;
    }

    public final void r(boolean z) {
        this.f10172l = z;
    }

    public final void s(float f2) {
        this.f10169i = f2;
    }

    public final void t(int i2) {
        this.f10170j = i2;
    }

    public final void u(LongLegMode longLegMode) {
        kotlin.jvm.internal.s.h(longLegMode, "<set-?>");
        this.f10165e = longLegMode;
    }

    public final void v(kotlin.jvm.b.q<? super Float, ? super Float, ? super Integer, kotlin.u> qVar) {
        this.m = qVar;
    }

    public final void w(float f2) {
        this.f10171k = f2;
    }

    public final void x(float f2) {
        this.f10168h = f2;
    }
}
