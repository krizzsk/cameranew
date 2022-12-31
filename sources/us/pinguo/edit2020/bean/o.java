package us.pinguo.edit2020.bean;

import us.pinguo.edit2020.bean.x;
import us.pinguo.u3dengine.edit.UnityEditCaller;
/* compiled from: EliminationFunction.kt */
/* loaded from: classes4.dex */
public final class o implements x {
    private final String a;
    private final int b;
    private final int c;

    /* renamed from: d  reason: collision with root package name */
    private final UnityEditCaller.RemoveSpot.BrushMode f10233d;

    /* renamed from: e  reason: collision with root package name */
    private final int f10234e;

    /* renamed from: f  reason: collision with root package name */
    private final int f10235f;

    /* renamed from: g  reason: collision with root package name */
    private int f10236g;

    /* renamed from: h  reason: collision with root package name */
    private int f10237h;

    /* renamed from: i  reason: collision with root package name */
    private int f10238i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f10239j;

    public o(String key, int i2, int i3, UnityEditCaller.RemoveSpot.BrushMode brushMode) {
        kotlin.jvm.internal.s.h(key, "key");
        kotlin.jvm.internal.s.h(brushMode, "brushMode");
        this.a = key;
        this.b = i2;
        this.c = i3;
        this.f10233d = brushMode;
        this.f10234e = 50;
        this.f10235f = 100;
        this.f10236g = 50;
        this.f10237h = 100;
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
        return this.f10239j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof o) {
            o oVar = (o) obj;
            return kotlin.jvm.internal.s.c(this.a, oVar.a) && this.b == oVar.b && this.c == oVar.c && this.f10233d == oVar.f10233d;
        }
        return false;
    }

    @Override // us.pinguo.edit2020.bean.x
    public String f() {
        return this.a;
    }

    public final UnityEditCaller.RemoveSpot.BrushMode g() {
        return this.f10233d;
    }

    public final int h() {
        return this.f10237h;
    }

    public int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b) * 31) + this.c) * 31) + this.f10233d.hashCode();
    }

    public final int i() {
        return this.f10236g;
    }

    public final int j() {
        return this.f10235f;
    }

    public final int k() {
        return this.f10234e;
    }

    public final int l() {
        return this.f10238i;
    }

    public final void m(boolean z) {
        this.f10239j = z;
    }

    public final void n(int i2) {
        this.f10237h = i2;
    }

    public final void o(int i2) {
        this.f10236g = i2;
    }

    public final void p(int i2) {
        this.f10238i = i2;
    }

    public String toString() {
        return "EliminationFunction(key=" + this.a + ", nameId=" + this.b + ", iconId=" + this.c + ", brushMode=" + this.f10233d + ')';
    }
}
