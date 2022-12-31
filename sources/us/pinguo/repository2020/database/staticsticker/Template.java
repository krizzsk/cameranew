package us.pinguo.repository2020.database.staticsticker;

import java.util.Arrays;
import java.util.Objects;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
import us.pinguo.repository2020.entity.Material;
/* compiled from: StaticSticker.kt */
/* loaded from: classes6.dex */
public final class Template extends Material implements NoProguard {
    private final String market_product_id;
    private final String market_product_price;
    private final String popup_icon;
    private final StaticStickerDetail[] stickers;
    private final String tid;

    public Template(String str, String str2, String str3, String str4, String str5, Integer num, String str6, String str7, StaticStickerDetail[] staticStickerDetailArr, Long l2, Long l3) {
        super(str2, str4, str3, null, l2, l3, num);
        this.tid = str;
        this.popup_icon = str5;
        this.market_product_id = str6;
        this.market_product_price = str7;
        this.stickers = staticStickerDetailArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (s.c(Template.class, obj == null ? null : obj.getClass())) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type us.pinguo.repository2020.database.staticsticker.Template");
            Template template = (Template) obj;
            if (s.c(this.tid, template.tid) && s.c(getPid(), template.getPid()) && s.c(getName(), template.getName()) && s.c(getIcon(), template.getIcon()) && s.c(this.popup_icon, template.popup_icon) && s.c(getVip(), template.getVip()) && s.c(this.market_product_id, template.market_product_id) && s.c(this.market_product_price, template.market_product_price)) {
                StaticStickerDetail[] staticStickerDetailArr = this.stickers;
                if (staticStickerDetailArr != null) {
                    StaticStickerDetail[] staticStickerDetailArr2 = template.stickers;
                    if (staticStickerDetailArr2 == null || !Arrays.equals(staticStickerDetailArr, staticStickerDetailArr2)) {
                        return false;
                    }
                } else if (template.stickers != null) {
                    return false;
                }
                return s.c(getOnsale_time(), template.getOnsale_time()) && s.c(getOff_time(), template.getOff_time());
            }
            return false;
        }
        return false;
    }

    public final String getMarket_product_id() {
        return this.market_product_id;
    }

    public final String getMarket_product_price() {
        return this.market_product_price;
    }

    public final String getPopup_icon() {
        return this.popup_icon;
    }

    public final StaticStickerDetail[] getStickers() {
        return this.stickers;
    }

    public final String getTid() {
        return this.tid;
    }

    public int hashCode() {
        String str = this.tid;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String pid = getPid();
        int hashCode2 = (hashCode + (pid == null ? 0 : pid.hashCode())) * 31;
        String name = getName();
        int hashCode3 = (hashCode2 + (name == null ? 0 : name.hashCode())) * 31;
        String icon = getIcon();
        int hashCode4 = (hashCode3 + (icon == null ? 0 : icon.hashCode())) * 31;
        String str2 = this.popup_icon;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer vip = getVip();
        int intValue = (hashCode5 + (vip == null ? 0 : vip.intValue())) * 31;
        String str3 = this.market_product_id;
        int hashCode6 = (intValue + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.market_product_price;
        int hashCode7 = (hashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        StaticStickerDetail[] staticStickerDetailArr = this.stickers;
        int hashCode8 = (hashCode7 + (staticStickerDetailArr == null ? 0 : Arrays.hashCode(staticStickerDetailArr))) * 31;
        Long onsale_time = getOnsale_time();
        int hashCode9 = (hashCode8 + (onsale_time == null ? 0 : onsale_time.hashCode())) * 31;
        Long off_time = getOff_time();
        return hashCode9 + (off_time != null ? off_time.hashCode() : 0);
    }

    public final boolean isValid(long j2) {
        Long onsale_time = getOnsale_time();
        if (onsale_time == null) {
            return false;
        }
        long longValue = onsale_time.longValue();
        Long off_time = getOff_time();
        if (off_time == null) {
            return false;
        }
        long longValue2 = off_time.longValue();
        if (j2 != 0 && longValue > 0 && longValue2 > 0) {
            long j3 = 1000;
            if (j2 < longValue * j3 || j2 > longValue2 * j3) {
                return false;
            }
        }
        return true;
    }
}
