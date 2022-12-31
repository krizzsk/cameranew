package us.pinguo.repository2020.entity;

import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: EffectPicInfo.kt */
/* loaded from: classes6.dex */
public final class EffectPicInfo implements NoProguard {
    private final String item_id;
    private final String name;
    private final String pic;

    public EffectPicInfo(String str, String str2, String str3) {
        this.item_id = str;
        this.name = str2;
        this.pic = str3;
    }

    public static /* synthetic */ EffectPicInfo copy$default(EffectPicInfo effectPicInfo, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = effectPicInfo.item_id;
        }
        if ((i2 & 2) != 0) {
            str2 = effectPicInfo.name;
        }
        if ((i2 & 4) != 0) {
            str3 = effectPicInfo.pic;
        }
        return effectPicInfo.copy(str, str2, str3);
    }

    public final String component1() {
        return this.item_id;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.pic;
    }

    public final EffectPicInfo copy(String str, String str2, String str3) {
        return new EffectPicInfo(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EffectPicInfo) {
            EffectPicInfo effectPicInfo = (EffectPicInfo) obj;
            return s.c(this.item_id, effectPicInfo.item_id) && s.c(this.name, effectPicInfo.name) && s.c(this.pic, effectPicInfo.pic);
        }
        return false;
    }

    public final String getItem_id() {
        return this.item_id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPic() {
        return this.pic;
    }

    public int hashCode() {
        String str = this.item_id;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.pic;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "EffectPicInfo(item_id=" + ((Object) this.item_id) + ", name=" + ((Object) this.name) + ", pic=" + ((Object) this.pic) + ')';
    }
}
