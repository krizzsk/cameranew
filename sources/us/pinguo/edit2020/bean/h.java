package us.pinguo.edit2020.bean;

import us.pinguo.edit2020.bean.x;
/* compiled from: BeautyFunction.kt */
/* loaded from: classes4.dex */
public final class h implements x {
    private final String a;
    private final int b;
    private final int c;

    public h(String str, int i2, int i3) {
        this.a = str;
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
        String string = us.pinguo.foundation.e.b().getString(this.c);
        kotlin.jvm.internal.s.g(string, "getAppContext().getString(name)");
        return string;
    }

    @Override // us.pinguo.edit2020.bean.x
    public int d() {
        return this.b;
    }

    @Override // us.pinguo.edit2020.bean.x
    public boolean e() {
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            return kotlin.jvm.internal.s.c(this.a, hVar.a) && this.b == hVar.b && this.c == hVar.c;
        }
        return false;
    }

    @Override // us.pinguo.edit2020.bean.x
    public String f() {
        String str = this.a;
        return str == null ? "" : str;
    }

    public final String g() {
        return this.a;
    }

    public final int h() {
        return this.c;
    }

    public int hashCode() {
        String str = this.a;
        return ((((str == null ? 0 : str.hashCode()) * 31) + this.b) * 31) + this.c;
    }

    public String toString() {
        return "BeautyFunction(key=" + ((Object) this.a) + ", icon=" + this.b + ", name=" + this.c + ')';
    }

    public /* synthetic */ h(String str, int i2, int i3, int i4, kotlin.jvm.internal.o oVar) {
        this((i4 & 1) != 0 ? null : str, i2, i3);
    }
}
