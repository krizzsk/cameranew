package us.pinguo.edit2020.bean;

import us.pinguo.edit2020.bean.x;
/* compiled from: AdjustFunction.kt */
/* loaded from: classes4.dex */
public class a implements x {
    private final String a;
    private final String b;
    private final int c;

    /* renamed from: d  reason: collision with root package name */
    private final int f10158d;

    /* renamed from: e  reason: collision with root package name */
    private final int f10159e;

    /* renamed from: f  reason: collision with root package name */
    private final int f10160f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f10161g;

    /* renamed from: h  reason: collision with root package name */
    private int f10162h;

    /* renamed from: i  reason: collision with root package name */
    private kotlin.jvm.b.a<kotlin.u> f10163i;

    public a(String key, String name, int i2, int i3, int i4, int i5, boolean z) {
        kotlin.jvm.internal.s.h(key, "key");
        kotlin.jvm.internal.s.h(name, "name");
        this.a = key;
        this.b = name;
        this.c = i2;
        this.f10158d = i3;
        this.f10159e = i4;
        this.f10160f = i5;
        this.f10161g = z;
        this.f10162h = i3;
    }

    @Override // us.pinguo.edit2020.bean.x
    public boolean a() {
        return this.f10161g;
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
        return this.f10162h != 0;
    }

    @Override // us.pinguo.edit2020.bean.x
    public String f() {
        return this.a;
    }

    public final int g() {
        return this.f10162h;
    }

    public final int h() {
        return this.f10158d;
    }

    public final int i() {
        return this.f10160f;
    }

    public final int j() {
        return this.f10159e;
    }

    public final kotlin.jvm.b.a<kotlin.u> k() {
        return this.f10163i;
    }

    public final void l(int i2) {
        this.f10162h = i2;
    }

    public final void m(kotlin.jvm.b.a<kotlin.u> aVar) {
        this.f10163i = aVar;
    }
}
