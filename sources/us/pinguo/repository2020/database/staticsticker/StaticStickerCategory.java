package us.pinguo.repository2020.database.staticsticker;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
import us.pinguo.repository2020.entity.Material;
/* compiled from: StaticSticker.kt */
/* loaded from: classes6.dex */
public final class StaticStickerCategory extends Material implements NoProguard, Serializable {
    public static final a Companion = new a(null);
    public static final long serialVersionUID = -71;
    private final Long display_end_time;
    private final String display_md5;
    private final Long display_start_time;
    private final Integer is_display;
    private final Integer is_display_new;
    private final String market_product_id;
    private final String market_product_price;
    private final String[] sids;
    private final String store_icon;

    /* compiled from: StaticSticker.kt */
    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }
    }

    public StaticStickerCategory(String str, String str2, String str3, String str4, String[] strArr, Integer num, Integer num2, Long l2, Long l3, String str5, String str6, Integer num3, String str7, String str8, Long l4, Long l5) {
        super(str, str3, str2, str6, l4, l5, num3);
        this.store_icon = str4;
        this.sids = strArr;
        this.is_display = num;
        this.is_display_new = num2;
        this.display_start_time = l2;
        this.display_end_time = l3;
        this.display_md5 = str5;
        this.market_product_id = str7;
        this.market_product_price = str8;
    }

    public final boolean duringDisplayTime(long j2) {
        Long l2 = this.display_start_time;
        if (l2 == null) {
            return true;
        }
        long longValue = l2.longValue();
        Long l3 = this.display_end_time;
        if (l3 == null) {
            return true;
        }
        long longValue2 = l3.longValue();
        if (j2 == 0 || longValue <= 0 || longValue2 <= 0) {
            return true;
        }
        long j3 = 1000;
        return j2 >= longValue * j3 && j2 <= longValue2 * j3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (s.c(StaticStickerCategory.class, obj == null ? null : obj.getClass())) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type us.pinguo.repository2020.database.staticsticker.StaticStickerCategory");
            StaticStickerCategory staticStickerCategory = (StaticStickerCategory) obj;
            if (s.c(getPid(), staticStickerCategory.getPid()) && s.c(getName(), staticStickerCategory.getName()) && s.c(getIcon(), staticStickerCategory.getIcon()) && s.c(this.store_icon, staticStickerCategory.store_icon)) {
                String[] strArr = this.sids;
                if (strArr != null) {
                    String[] strArr2 = staticStickerCategory.sids;
                    if (strArr2 == null || !Arrays.equals(strArr, strArr2)) {
                        return false;
                    }
                } else if (staticStickerCategory.sids != null) {
                    return false;
                }
                return s.c(this.is_display, staticStickerCategory.is_display) && s.c(this.is_display_new, staticStickerCategory.is_display_new) && s.c(this.display_start_time, staticStickerCategory.display_start_time) && s.c(this.display_end_time, staticStickerCategory.display_end_time) && s.c(this.display_md5, staticStickerCategory.display_md5) && s.c(getDown_url(), staticStickerCategory.getDown_url()) && s.c(getVip(), staticStickerCategory.getVip()) && s.c(this.market_product_id, staticStickerCategory.market_product_id) && s.c(this.market_product_price, staticStickerCategory.market_product_price) && s.c(getOnsale_time(), staticStickerCategory.getOnsale_time()) && s.c(getOff_time(), staticStickerCategory.getOff_time());
            }
            return false;
        }
        return false;
    }

    public final Long getDisplay_end_time() {
        return this.display_end_time;
    }

    public final String getDisplay_md5() {
        return this.display_md5;
    }

    public final Long getDisplay_start_time() {
        return this.display_start_time;
    }

    public final String getMarket_product_id() {
        return this.market_product_id;
    }

    public final String getMarket_product_price() {
        return this.market_product_price;
    }

    public final String[] getSids() {
        return this.sids;
    }

    public final String getStore_icon() {
        return this.store_icon;
    }

    public int hashCode() {
        String pid = getPid();
        int hashCode = (pid == null ? 0 : pid.hashCode()) * 31;
        String name = getName();
        int hashCode2 = (hashCode + (name == null ? 0 : name.hashCode())) * 31;
        String icon = getIcon();
        int hashCode3 = (hashCode2 + (icon == null ? 0 : icon.hashCode())) * 31;
        String str = this.store_icon;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        String[] strArr = this.sids;
        int hashCode5 = (hashCode4 + (strArr == null ? 0 : Arrays.hashCode(strArr))) * 31;
        Integer num = this.is_display;
        int intValue = (hashCode5 + (num == null ? 0 : num.intValue())) * 31;
        Integer num2 = this.is_display_new;
        int intValue2 = (intValue + (num2 == null ? 0 : num2.intValue())) * 31;
        Long l2 = this.display_start_time;
        int hashCode6 = (intValue2 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Long l3 = this.display_end_time;
        int hashCode7 = (hashCode6 + (l3 == null ? 0 : l3.hashCode())) * 31;
        String str2 = this.display_md5;
        int hashCode8 = (hashCode7 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String down_url = getDown_url();
        int hashCode9 = (hashCode8 + (down_url == null ? 0 : down_url.hashCode())) * 31;
        Integer vip = getVip();
        int intValue3 = (hashCode9 + (vip == null ? 0 : vip.intValue())) * 31;
        String str3 = this.market_product_id;
        int hashCode10 = (intValue3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.market_product_price;
        int hashCode11 = (hashCode10 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Long onsale_time = getOnsale_time();
        int hashCode12 = (hashCode11 + (onsale_time == null ? 0 : onsale_time.hashCode())) * 31;
        Long off_time = getOff_time();
        return hashCode12 + (off_time != null ? off_time.hashCode() : 0);
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

    public final Integer is_display() {
        return this.is_display;
    }

    public final Integer is_display_new() {
        return this.is_display_new;
    }
}
