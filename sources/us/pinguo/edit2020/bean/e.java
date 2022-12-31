package us.pinguo.edit2020.bean;

import us.pinguo.edit2020.bean.x;
/* compiled from: BackgroundBlurLensCustomizeFunction.kt */
/* loaded from: classes4.dex */
public final class e implements x {
    private final String a;
    private final int b;
    private final int c;

    /* renamed from: d  reason: collision with root package name */
    private final int f10183d;

    /* renamed from: e  reason: collision with root package name */
    private final int f10184e;

    /* renamed from: f  reason: collision with root package name */
    private final int f10185f;

    /* renamed from: g  reason: collision with root package name */
    private int f10186g;

    public e(String key, int i2, int i3, int i4, int i5, int i6) {
        kotlin.jvm.internal.s.h(key, "key");
        this.a = key;
        this.b = i2;
        this.c = i3;
        this.f10183d = i4;
        this.f10184e = i5;
        this.f10185f = i6;
        this.f10186g = i6;
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
        return (kotlin.jvm.internal.s.c(this.a, "background_blur_intensity") || this.f10186g == 0) ? false : true;
    }

    @Override // us.pinguo.edit2020.bean.x
    public String f() {
        return this.a;
    }

    public final int g() {
        return this.f10186g;
    }

    public final int h() {
        return this.f10185f;
    }

    public final int i() {
        return this.f10184e;
    }

    public final int j() {
        return this.f10183d;
    }

    public final void k(int i2) {
        this.f10186g = i2;
    }
}
