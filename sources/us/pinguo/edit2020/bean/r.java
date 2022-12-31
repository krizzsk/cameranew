package us.pinguo.edit2020.bean;

import us.pinguo.edit2020.bean.x;
import us.pinguo.repository2020.entity.BeautyEditData;
/* compiled from: FacialFeaturesItem.kt */
/* loaded from: classes4.dex */
public final class r implements x {
    private final BeautyEditData a;

    public r(BeautyEditData beautyData) {
        kotlin.jvm.internal.s.h(beautyData, "beautyData");
        this.a = beautyData;
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
        return (obj instanceof r) && kotlin.jvm.internal.s.c(this.a, ((r) obj).a);
    }

    @Override // us.pinguo.edit2020.bean.x
    public String f() {
        return this.a.getBeautyKey();
    }

    public final BeautyEditData g() {
        return this.a;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "FacialFeaturesItem(beautyData=" + this.a + ')';
    }
}
