package us.pinguo.edit2020.bean;

import us.pinguo.edit2020.bean.x;
import us.pinguo.edit2020.viewmodel.FunctionType;
/* compiled from: EditFunction.kt */
/* loaded from: classes4.dex */
public final class n implements x {
    private final String a;
    private final int b;
    private final int c;

    /* renamed from: d  reason: collision with root package name */
    private final FunctionType f10232d;

    public n(String key, int i2, int i3, FunctionType editType) {
        kotlin.jvm.internal.s.h(key, "key");
        kotlin.jvm.internal.s.h(editType, "editType");
        this.a = key;
        this.b = i2;
        this.c = i3;
        this.f10232d = editType;
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
        if (obj instanceof n) {
            n nVar = (n) obj;
            return kotlin.jvm.internal.s.c(this.a, nVar.a) && this.b == nVar.b && this.c == nVar.c && this.f10232d == nVar.f10232d;
        }
        return false;
    }

    @Override // us.pinguo.edit2020.bean.x
    public String f() {
        return "";
    }

    public final FunctionType g() {
        return this.f10232d;
    }

    public final String h() {
        return this.a;
    }

    public int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b) * 31) + this.c) * 31) + this.f10232d.hashCode();
    }

    public String toString() {
        return "EditFunction(key=" + this.a + ", nameId=" + this.b + ", iconId=" + this.c + ", editType=" + this.f10232d + ')';
    }
}
