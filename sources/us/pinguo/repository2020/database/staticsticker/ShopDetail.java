package us.pinguo.repository2020.database.staticsticker;

import java.util.Arrays;
import java.util.Objects;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: ShopDetail.kt */
/* loaded from: classes6.dex */
public final class ShopDetail implements NoProguard {
    private final Banner[] banners;
    private final String desc;
    private final String display_md5;
    private final String down_url;
    private final IconBig icon_big;
    private final String market_product_id;
    private final String market_product_price;
    private final String name;
    private final String pid;
    private final String[] sids;
    private final Integer vip;

    public ShopDetail(String str, String str2, String str3, IconBig iconBig, Banner[] bannerArr, String str4, String str5, String[] strArr, Integer num, String str6, String market_product_price) {
        s.h(market_product_price, "market_product_price");
        this.pid = str;
        this.name = str2;
        this.desc = str3;
        this.icon_big = iconBig;
        this.banners = bannerArr;
        this.display_md5 = str4;
        this.down_url = str5;
        this.sids = strArr;
        this.vip = num;
        this.market_product_id = str6;
        this.market_product_price = market_product_price;
    }

    public final String component1() {
        return this.pid;
    }

    public final String component10() {
        return this.market_product_id;
    }

    public final String component11() {
        return this.market_product_price;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.desc;
    }

    public final IconBig component4() {
        return this.icon_big;
    }

    public final Banner[] component5() {
        return this.banners;
    }

    public final String component6() {
        return this.display_md5;
    }

    public final String component7() {
        return this.down_url;
    }

    public final String[] component8() {
        return this.sids;
    }

    public final Integer component9() {
        return this.vip;
    }

    public final ShopDetail copy(String str, String str2, String str3, IconBig iconBig, Banner[] bannerArr, String str4, String str5, String[] strArr, Integer num, String str6, String market_product_price) {
        s.h(market_product_price, "market_product_price");
        return new ShopDetail(str, str2, str3, iconBig, bannerArr, str4, str5, strArr, num, str6, market_product_price);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (s.c(ShopDetail.class, obj == null ? null : obj.getClass())) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type us.pinguo.repository2020.database.staticsticker.ShopDetail");
            ShopDetail shopDetail = (ShopDetail) obj;
            if (s.c(this.pid, shopDetail.pid) && s.c(this.name, shopDetail.name) && s.c(this.desc, shopDetail.desc) && s.c(this.icon_big, shopDetail.icon_big)) {
                Banner[] bannerArr = this.banners;
                if (bannerArr != null) {
                    Banner[] bannerArr2 = shopDetail.banners;
                    if (bannerArr2 == null || !Arrays.equals(bannerArr, bannerArr2)) {
                        return false;
                    }
                } else if (shopDetail.banners != null) {
                    return false;
                }
                if (s.c(this.display_md5, shopDetail.display_md5) && s.c(this.down_url, shopDetail.down_url)) {
                    String[] strArr = this.sids;
                    if (strArr != null) {
                        String[] strArr2 = shopDetail.sids;
                        if (strArr2 == null || !Arrays.equals(strArr, strArr2)) {
                            return false;
                        }
                    } else if (shopDetail.sids != null) {
                        return false;
                    }
                    return s.c(this.vip, shopDetail.vip) && s.c(this.market_product_id, shopDetail.market_product_id) && s.c(this.market_product_price, shopDetail.market_product_price);
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public final Banner[] getBanners() {
        return this.banners;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getDisplay_md5() {
        return this.display_md5;
    }

    public final String getDown_url() {
        return this.down_url;
    }

    public final IconBig getIcon_big() {
        return this.icon_big;
    }

    public final String getMarket_product_id() {
        return this.market_product_id;
    }

    public final String getMarket_product_price() {
        return this.market_product_price;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPid() {
        return this.pid;
    }

    public final String[] getSids() {
        return this.sids;
    }

    public final Integer getVip() {
        return this.vip;
    }

    public int hashCode() {
        String str = this.pid;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.desc;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        IconBig iconBig = this.icon_big;
        int hashCode4 = (hashCode3 + (iconBig == null ? 0 : iconBig.hashCode())) * 31;
        Banner[] bannerArr = this.banners;
        int hashCode5 = (hashCode4 + (bannerArr == null ? 0 : Arrays.hashCode(bannerArr))) * 31;
        String str4 = this.display_md5;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.down_url;
        int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String[] strArr = this.sids;
        int hashCode8 = (hashCode7 + (strArr == null ? 0 : Arrays.hashCode(strArr))) * 31;
        Integer num = this.vip;
        int intValue = (hashCode8 + (num == null ? 0 : num.intValue())) * 31;
        String str6 = this.market_product_id;
        return ((intValue + (str6 != null ? str6.hashCode() : 0)) * 31) + this.market_product_price.hashCode();
    }

    public String toString() {
        return "ShopDetail(pid=" + ((Object) this.pid) + ", name=" + ((Object) this.name) + ", desc=" + ((Object) this.desc) + ", icon_big=" + this.icon_big + ", banners=" + Arrays.toString(this.banners) + ", display_md5=" + ((Object) this.display_md5) + ", down_url=" + ((Object) this.down_url) + ", sids=" + Arrays.toString(this.sids) + ", vip=" + this.vip + ", market_product_id=" + ((Object) this.market_product_id) + ", market_product_price=" + this.market_product_price + ')';
    }
}
