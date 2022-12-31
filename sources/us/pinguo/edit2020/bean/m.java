package us.pinguo.edit2020.bean;

import us.pinguo.edit2020.bean.x;
/* compiled from: CropFunction.kt */
/* loaded from: classes4.dex */
public final class m implements x {
    private final String a;
    private final int b;
    private final int c;

    public m(String key, int i2, int i3) {
        kotlin.jvm.internal.s.h(key, "key");
        this.a = key;
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
        if (obj instanceof m) {
            m mVar = (m) obj;
            return kotlin.jvm.internal.s.c(this.a, mVar.a) && this.b == mVar.b && this.c == mVar.c;
        }
        return false;
    }

    @Override // us.pinguo.edit2020.bean.x
    public String f() {
        return this.a;
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b) * 31) + this.c;
    }

    public String toString() {
        return "CropFunction(key=" + this.a + ", nameId=" + this.b + ", iconId=" + this.c + ')';
    }
}
