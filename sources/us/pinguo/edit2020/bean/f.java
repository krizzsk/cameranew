package us.pinguo.edit2020.bean;

import us.pinguo.edit2020.R;
import us.pinguo.edit2020.bean.x;
import us.pinguo.repository2020.database.background.Background;
/* compiled from: BackgroundReplacementFunction.kt */
/* loaded from: classes4.dex */
public final class f implements x {
    private final Background a;
    private int c;

    /* renamed from: f  reason: collision with root package name */
    private volatile int f10189f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f10190g;
    private int b = 1;

    /* renamed from: d  reason: collision with root package name */
    private int f10187d = 50;

    /* renamed from: e  reason: collision with root package name */
    private String f10188e = "";

    public f(Background background) {
        this.a = background;
    }

    @Override // us.pinguo.edit2020.bean.x
    public boolean a() {
        Background background = this.a;
        return background != null && background.getVip() == 1;
    }

    @Override // us.pinguo.edit2020.bean.x
    public boolean b() {
        return x.a.a(this);
    }

    @Override // us.pinguo.edit2020.bean.x
    public String c() {
        String name;
        Background background = this.a;
        return (background == null || (name = background.getName()) == null) ? "original" : name;
    }

    @Override // us.pinguo.edit2020.bean.x
    public int d() {
        if (this.a == null) {
            return R.drawable.ic_background_null;
        }
        return -1;
    }

    @Override // us.pinguo.edit2020.bean.x
    public boolean e() {
        return this.f10190g;
    }

    @Override // us.pinguo.edit2020.bean.x
    public String f() {
        String pid;
        Background background = this.a;
        return (background == null || (pid = background.getPid()) == null) ? "original" : pid;
    }

    public final int g() {
        return this.b;
    }

    public final Background h() {
        return this.a;
    }

    public final String i() {
        return this.f10188e;
    }

    public final int j() {
        return this.c;
    }

    public final int k() {
        return this.f10187d;
    }

    public final int l() {
        return this.f10189f;
    }

    public final boolean m() {
        return this.f10190g && a();
    }

    public final void n(int i2) {
        this.b = i2;
    }

    public final void o(boolean z) {
        this.f10190g = z;
    }

    public final void p(String str) {
        kotlin.jvm.internal.s.h(str, "<set-?>");
        this.f10188e = str;
    }

    public final void q(int i2) {
        this.c = i2;
    }

    public final void r(int i2) {
        this.f10187d = i2;
    }

    public final void s(int i2) {
        this.f10189f = i2;
    }
}
