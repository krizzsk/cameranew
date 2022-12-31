package us.pinguo.edit2020.bean;

import us.pinguo.edit2020.bean.x;
/* compiled from: AutoBeautifyFunction.kt */
/* loaded from: classes4.dex */
public final class c implements x {
    private final String a;
    private final String b;
    private final int c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f10173d;

    /* renamed from: e  reason: collision with root package name */
    private final int f10174e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f10175f;

    /* renamed from: g  reason: collision with root package name */
    private int f10176g;

    /* renamed from: h  reason: collision with root package name */
    private transient kotlin.jvm.b.l<? super Float, kotlin.u> f10177h;

    public c(String key, String name, int i2, boolean z, int i3, boolean z2) {
        kotlin.jvm.internal.s.h(key, "key");
        kotlin.jvm.internal.s.h(name, "name");
        this.a = key;
        this.b = name;
        this.c = i2;
        this.f10173d = z;
        this.f10174e = i3;
        this.f10175f = z2;
        this.f10176g = i3;
    }

    @Override // us.pinguo.edit2020.bean.x
    public boolean a() {
        return this.f10173d;
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
        return this.f10175f;
    }

    @Override // us.pinguo.edit2020.bean.x
    public String f() {
        return this.a;
    }

    public final int g() {
        return this.f10176g;
    }

    public final int h() {
        return this.f10174e;
    }

    public final kotlin.jvm.b.l<Float, kotlin.u> i() {
        return this.f10177h;
    }

    public final void j(boolean z) {
        this.f10175f = z;
    }

    public final void k(int i2) {
        this.f10176g = i2;
    }

    public final void l(kotlin.jvm.b.l<? super Float, kotlin.u> lVar) {
        this.f10177h = lVar;
    }
}
