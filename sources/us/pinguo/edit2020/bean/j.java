package us.pinguo.edit2020.bean;

import us.pinguo.edit2020.bean.x;
/* compiled from: BlurringFunction.kt */
/* loaded from: classes4.dex */
public final class j implements x {
    private final String a;
    private final String b;
    private final boolean c;

    /* renamed from: d  reason: collision with root package name */
    private final int f10205d;

    /* renamed from: e  reason: collision with root package name */
    private final int f10206e;

    /* renamed from: f  reason: collision with root package name */
    private final int f10207f;

    /* renamed from: g  reason: collision with root package name */
    private final int f10208g;

    /* renamed from: h  reason: collision with root package name */
    private final BlurringType f10209h;

    /* renamed from: i  reason: collision with root package name */
    private final l0 f10210i;

    /* renamed from: j  reason: collision with root package name */
    private final int f10211j;

    /* renamed from: k  reason: collision with root package name */
    private int f10212k;

    /* renamed from: l  reason: collision with root package name */
    private final int f10213l;
    private int m;
    private kotlin.jvm.b.t<? super Boolean, ? super j, ? super Float, ? super Float, ? super Float, ? super Float, kotlin.u> n;

    public j(String key, String name, boolean z, int i2, int i3, int i4, int i5, BlurringType type) {
        kotlin.jvm.internal.s.h(key, "key");
        kotlin.jvm.internal.s.h(name, "name");
        kotlin.jvm.internal.s.h(type, "type");
        this.a = key;
        this.b = name;
        this.c = z;
        this.f10205d = i2;
        this.f10206e = i3;
        this.f10207f = i4;
        this.f10208g = i5;
        this.f10209h = type;
        this.f10210i = new l0(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        this.f10211j = 50;
        this.f10213l = 50;
    }

    @Override // us.pinguo.edit2020.bean.x
    public boolean a() {
        return this.c;
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
        return -1;
    }

    @Override // us.pinguo.edit2020.bean.x
    public boolean e() {
        return (this.f10212k == 0 && this.m == 0) ? false : true;
    }

    @Override // us.pinguo.edit2020.bean.x
    public String f() {
        return this.a;
    }

    public final int g() {
        return this.f10213l;
    }

    public final int h() {
        return this.f10211j;
    }

    public final int i() {
        return this.f10208g;
    }

    public final int j() {
        return this.f10207f;
    }

    public final int k() {
        return this.m;
    }

    public final l0 l() {
        return this.f10210i;
    }

    public final kotlin.jvm.b.t<Boolean, j, Float, Float, Float, Float, kotlin.u> m() {
        return this.n;
    }

    public final int n() {
        return this.f10206e;
    }

    public final int o() {
        return this.f10205d;
    }

    public final int p() {
        return this.f10212k;
    }

    public final BlurringType q() {
        return this.f10209h;
    }

    public final void r(int i2) {
        this.m = i2;
    }

    public final void s(kotlin.jvm.b.t<? super Boolean, ? super j, ? super Float, ? super Float, ? super Float, ? super Float, kotlin.u> tVar) {
        this.n = tVar;
    }

    public final void t(int i2) {
        this.f10212k = i2;
    }
}
