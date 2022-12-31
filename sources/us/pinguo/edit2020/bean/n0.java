package us.pinguo.edit2020.bean;

import us.pinguo.repository2020.entity.BeautyEditData;
/* compiled from: SkinRefreshItem.kt */
/* loaded from: classes4.dex */
public class n0 implements x {
    private final BeautyEditData a;
    private Boolean b;
    private boolean c;

    public n0(BeautyEditData beautyData) {
        kotlin.jvm.internal.s.h(beautyData, "beautyData");
        this.a = beautyData;
        if (!kotlin.jvm.internal.s.c(beautyData.getBeautyKey(), "yunfu") || us.pinguo.foundation.j.e().i("key_initial_version_code", -1) >= 99210 || us.pinguo.repository2020.utils.o.b(us.pinguo.repository2020.utils.o.a, kotlin.jvm.internal.s.q(beautyData.getBeautyKey(), "_used"), false, null, 4, null)) {
            return;
        }
        this.c = true;
    }

    @Override // us.pinguo.edit2020.bean.x
    public boolean a() {
        return this.a.isVip();
    }

    @Override // us.pinguo.edit2020.bean.x
    public boolean b() {
        return this.c;
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
        Boolean bool = this.b;
        if (bool != null && !kotlin.jvm.internal.s.c(bool, Boolean.FALSE)) {
            Boolean bool2 = this.b;
            kotlin.jvm.internal.s.e(bool2);
            return bool2.booleanValue();
        }
        if (kotlin.jvm.internal.s.c(this.a.getBeautyKey(), "yunfu")) {
            if (this.a.getCurrentValue() > 0) {
                return true;
            }
        } else if (this.a.getCurrentValue() != this.a.getDefaultValue()) {
            return true;
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

    public final void h(boolean z) {
        this.b = Boolean.valueOf(z);
    }
}
