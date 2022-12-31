package us.pinguo.repository2020.database.sticker;

import java.util.Arrays;
import java.util.Objects;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: Sticker.kt */
/* loaded from: classes6.dex */
public final class StickerCategory implements NoProguard {
    private final String banner;
    private boolean hasFreshSticker;
    private String icon;
    private final String name;
    private final long off_time;
    private final long onsale_time;
    private final String[] package_ids;
    private final int priority;
    private final String share_id;
    private final String topic_id;
    private int type;
    private final int unlock_type;
    private final int vip;

    public StickerCategory(int i2, String topic_id, int i3, String icon, String banner, String name, String[] package_ids, String share_id, int i4, int i5, long j2, long j3) {
        s.h(topic_id, "topic_id");
        s.h(icon, "icon");
        s.h(banner, "banner");
        s.h(name, "name");
        s.h(package_ids, "package_ids");
        s.h(share_id, "share_id");
        this.type = i2;
        this.topic_id = topic_id;
        this.unlock_type = i3;
        this.icon = icon;
        this.banner = banner;
        this.name = name;
        this.package_ids = package_ids;
        this.share_id = share_id;
        this.priority = i4;
        this.vip = i5;
        this.onsale_time = j2;
        this.off_time = j3;
    }

    public final int component1() {
        return this.type;
    }

    public final int component10() {
        return this.vip;
    }

    public final long component11() {
        return this.onsale_time;
    }

    public final long component12() {
        return this.off_time;
    }

    public final String component2() {
        return this.topic_id;
    }

    public final int component3() {
        return this.unlock_type;
    }

    public final String component4() {
        return this.icon;
    }

    public final String component5() {
        return this.banner;
    }

    public final String component6() {
        return this.name;
    }

    public final String[] component7() {
        return this.package_ids;
    }

    public final String component8() {
        return this.share_id;
    }

    public final int component9() {
        return this.priority;
    }

    public final StickerCategory copy(int i2, String topic_id, int i3, String icon, String banner, String name, String[] package_ids, String share_id, int i4, int i5, long j2, long j3) {
        s.h(topic_id, "topic_id");
        s.h(icon, "icon");
        s.h(banner, "banner");
        s.h(name, "name");
        s.h(package_ids, "package_ids");
        s.h(share_id, "share_id");
        return new StickerCategory(i2, topic_id, i3, icon, banner, name, package_ids, share_id, i4, i5, j2, j3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (s.c(StickerCategory.class, obj == null ? null : obj.getClass())) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type us.pinguo.repository2020.database.sticker.StickerCategory");
            StickerCategory stickerCategory = (StickerCategory) obj;
            return this.type == stickerCategory.type && s.c(this.topic_id, stickerCategory.topic_id) && this.unlock_type == stickerCategory.unlock_type && s.c(this.icon, stickerCategory.icon) && s.c(this.banner, stickerCategory.banner) && s.c(this.name, stickerCategory.name) && Arrays.equals(this.package_ids, stickerCategory.package_ids) && s.c(this.share_id, stickerCategory.share_id) && this.priority == stickerCategory.priority && this.vip == stickerCategory.vip && this.onsale_time == stickerCategory.onsale_time && this.off_time == stickerCategory.off_time;
        }
        return false;
    }

    public final String getBanner() {
        return this.banner;
    }

    public final boolean getHasFreshSticker() {
        return this.hasFreshSticker;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getName() {
        return this.name;
    }

    public final long getOff_time() {
        return this.off_time;
    }

    public final long getOnsale_time() {
        return this.onsale_time;
    }

    public final String[] getPackage_ids() {
        return this.package_ids;
    }

    public final int getPriority() {
        return this.priority;
    }

    public final String getShare_id() {
        return this.share_id;
    }

    public final String getTopic_id() {
        return this.topic_id;
    }

    public final int getType() {
        return this.type;
    }

    public final int getUnlock_type() {
        return this.unlock_type;
    }

    public final int getVip() {
        return this.vip;
    }

    public int hashCode() {
        return (((((((((((((((((((((this.type * 31) + this.topic_id.hashCode()) * 31) + this.unlock_type) * 31) + this.icon.hashCode()) * 31) + this.banner.hashCode()) * 31) + this.name.hashCode()) * 31) + Arrays.hashCode(this.package_ids)) * 31) + this.share_id.hashCode()) * 31) + this.priority) * 31) + this.vip) * 31) + defpackage.c.a(this.onsale_time)) * 31) + defpackage.c.a(this.off_time);
    }

    public final boolean isValid(long j2) {
        if (j2 != 0) {
            long j3 = this.onsale_time;
            if (j3 > 0) {
                long j4 = this.off_time;
                if (j4 > 0) {
                    long j5 = 1000;
                    if (j2 < j3 * j5 || j2 > j4 * j5) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public final boolean isVip() {
        return this.vip != 0;
    }

    public final void setHasFreshSticker(boolean z) {
        this.hasFreshSticker = z;
    }

    public final void setIcon(String str) {
        s.h(str, "<set-?>");
        this.icon = str;
    }

    public final void setType(int i2) {
        this.type = i2;
    }

    public String toString() {
        return "StickerCategory(type=" + this.type + ", topic_id=" + this.topic_id + ", unlock_type=" + this.unlock_type + ", icon=" + this.icon + ", banner=" + this.banner + ", name=" + this.name + ", package_ids=" + Arrays.toString(this.package_ids) + ", share_id=" + this.share_id + ", priority=" + this.priority + ", vip=" + this.vip + ", onsale_time=" + this.onsale_time + ", off_time=" + this.off_time + ')';
    }
}
