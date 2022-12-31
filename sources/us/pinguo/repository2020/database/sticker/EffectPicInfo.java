package us.pinguo.repository2020.database.sticker;

import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: StickerDetail.kt */
/* loaded from: classes6.dex */
public final class EffectPicInfo implements NoProguard {
    private final String item_id;
    private final String name;
    private final String pic;

    public EffectPicInfo(String name, String item_id, String pic) {
        s.h(name, "name");
        s.h(item_id, "item_id");
        s.h(pic, "pic");
        this.name = name;
        this.item_id = item_id;
        this.pic = pic;
    }

    public static /* synthetic */ EffectPicInfo copy$default(EffectPicInfo effectPicInfo, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = effectPicInfo.name;
        }
        if ((i2 & 2) != 0) {
            str2 = effectPicInfo.item_id;
        }
        if ((i2 & 4) != 0) {
            str3 = effectPicInfo.pic;
        }
        return effectPicInfo.copy(str, str2, str3);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.item_id;
    }

    public final String component3() {
        return this.pic;
    }

    public final EffectPicInfo copy(String name, String item_id, String pic) {
        s.h(name, "name");
        s.h(item_id, "item_id");
        s.h(pic, "pic");
        return new EffectPicInfo(name, item_id, pic);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EffectPicInfo) {
            EffectPicInfo effectPicInfo = (EffectPicInfo) obj;
            return s.c(this.name, effectPicInfo.name) && s.c(this.item_id, effectPicInfo.item_id) && s.c(this.pic, effectPicInfo.pic);
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
        return (((this.name.hashCode() * 31) + this.item_id.hashCode()) * 31) + this.pic.hashCode();
    }

    public String toString() {
        return "EffectPicInfo(name=" + this.name + ", item_id=" + this.item_id + ", pic=" + this.pic + ')';
    }
}
