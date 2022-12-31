package us.pinguo.edit2020.bean;

import us.pinguo.edit2020.bean.x;
import us.pinguo.repository2020.entity.BeautyEditData;
/* compiled from: SkinRefreshItem.kt */
/* loaded from: classes4.dex */
public final class m0 implements x {
    private final BeautyEditData a;
    private boolean b;

    public m0(BeautyEditData beautyData, boolean z) {
        kotlin.jvm.internal.s.h(beautyData, "beautyData");
        this.a = beautyData;
        this.b = z;
    }

    @Override // us.pinguo.edit2020.bean.x
    public boolean a() {
        return this.a.isVip();
    }

    @Override // us.pinguo.edit2020.bean.x
    public boolean b() {
        return x.a.a(this);
    }

    @Override // us.pinguo.edit2020.bean.x
    public String c() {
        String string = us.pinguo.foundation.e.b().getString(this.a.getBeautyName());
        kotlin.jvm.internal.s.g(string, "getAppContext().getString(beautyData.beautyName)");
        return string;
    }

    @Override // us.pinguo.edit2020.bean.x
    public int d() {
        return this.a.getBeautyIcon();
    }

    @Override // us.pinguo.edit2020.bean.x
    public boolean e() {
        return this.a.getCurrentValue() != this.a.getDefaultValue();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof m0) {
            m0 m0Var = (m0) obj;
            return kotlin.jvm.internal.s.c(this.a, m0Var.a) && this.b == m0Var.b;
        }
        return false;
    }

    @Override // us.pinguo.edit2020.bean.x
    public String f() {
        return this.a.getBeautyKey();
    }

    public final BeautyEditData g() {
        return this.a;
    }

    public final boolean h() {
        return this.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        boolean z = this.b;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        return hashCode + i2;
    }

    public final void i(boolean z) {
        this.b = z;
    }

    public String toString() {
        return "SkinColorChooseItem(beautyData=" + this.a + ", isSelected=" + this.b + ')';
    }

    public /* synthetic */ m0(BeautyEditData beautyEditData, boolean z, int i2, kotlin.jvm.internal.o oVar) {
        this(beautyEditData, (i2 & 2) != 0 ? false : z);
    }
}
