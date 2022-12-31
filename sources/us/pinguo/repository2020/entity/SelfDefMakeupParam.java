package us.pinguo.repository2020.entity;

import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: SelfDefMakeupParam.kt */
/* loaded from: classes6.dex */
public final class SelfDefMakeupParam implements NoProguard {
    private final String bundle;
    private final Color color;
    private final String deformation;
    private final String icon;

    public SelfDefMakeupParam(String str, Color color, String str2, String str3) {
        this.bundle = str;
        this.color = color;
        this.icon = str2;
        this.deformation = str3;
    }

    public static /* synthetic */ SelfDefMakeupParam copy$default(SelfDefMakeupParam selfDefMakeupParam, String str, Color color, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = selfDefMakeupParam.bundle;
        }
        if ((i2 & 2) != 0) {
            color = selfDefMakeupParam.color;
        }
        if ((i2 & 4) != 0) {
            str2 = selfDefMakeupParam.icon;
        }
        if ((i2 & 8) != 0) {
            str3 = selfDefMakeupParam.deformation;
        }
        return selfDefMakeupParam.copy(str, color, str2, str3);
    }

    public final String component1() {
        return this.bundle;
    }

    public final Color component2() {
        return this.color;
    }

    public final String component3() {
        return this.icon;
    }

    public final String component4() {
        return this.deformation;
    }

    public final SelfDefMakeupParam copy(String str, Color color, String str2, String str3) {
        return new SelfDefMakeupParam(str, color, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SelfDefMakeupParam) {
            SelfDefMakeupParam selfDefMakeupParam = (SelfDefMakeupParam) obj;
            return s.c(this.bundle, selfDefMakeupParam.bundle) && s.c(this.color, selfDefMakeupParam.color) && s.c(this.icon, selfDefMakeupParam.icon) && s.c(this.deformation, selfDefMakeupParam.deformation);
        }
        return false;
    }

    public final String getBundle() {
        return this.bundle;
    }

    public final Color getColor() {
        return this.color;
    }

    public final String getDeformation() {
        return this.deformation;
    }

    public final String getIcon() {
        return this.icon;
    }

    public int hashCode() {
        String str = this.bundle;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Color color = this.color;
        int hashCode2 = (hashCode + (color == null ? 0 : color.hashCode())) * 31;
        String str2 = this.icon;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.deformation;
        return hashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "SelfDefMakeupParam(bundle=" + ((Object) this.bundle) + ", color=" + this.color + ", icon=" + ((Object) this.icon) + ", deformation=" + ((Object) this.deformation) + ')';
    }
}
