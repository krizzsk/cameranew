package us.pinguo.repository2020.entity;

import java.util.ArrayList;
import java.util.Map;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: FilterDetailData.kt */
/* loaded from: classes6.dex */
public final class FilterDetailData implements NoProguard {
    private final String descript;
    private final String display_zip_md5;
    private final String display_zip_url;
    private final ArrayList<EffectPicInfo> effect_pic_info;
    private final Integer file_size;
    private final String icon;
    private final ArrayList<FilterZipItem> items;
    private final String name;
    private final Long off_time;
    private final Long onsale_time;
    private final String origin_pic;
    private final String package_zip;
    private final String package_zip_md5;
    private final String pid;
    private final Integer type;
    private final Map<String, Integer> typeCountInfo;
    private final Integer unlock_type;
    private final Integer vip;
    private final String vip_banner;

    public FilterDetailData(String str, String str2, String str3, String str4, String str5, ArrayList<EffectPicInfo> arrayList, String str6, String str7, String str8, String str9, Integer num, ArrayList<FilterZipItem> arrayList2, Integer num2, Long l2, Long l3, Integer num3, Map<String, Integer> map, Integer num4, String str10) {
        this.pid = str;
        this.descript = str2;
        this.name = str3;
        this.icon = str4;
        this.origin_pic = str5;
        this.effect_pic_info = arrayList;
        this.package_zip = str6;
        this.package_zip_md5 = str7;
        this.display_zip_url = str8;
        this.display_zip_md5 = str9;
        this.file_size = num;
        this.items = arrayList2;
        this.type = num2;
        this.onsale_time = l2;
        this.off_time = l3;
        this.unlock_type = num3;
        this.typeCountInfo = map;
        this.vip = num4;
        this.vip_banner = str10;
    }

    public final String component1() {
        return this.pid;
    }

    public final String component10() {
        return this.display_zip_md5;
    }

    public final Integer component11() {
        return this.file_size;
    }

    public final ArrayList<FilterZipItem> component12() {
        return this.items;
    }

    public final Integer component13() {
        return this.type;
    }

    public final Long component14() {
        return this.onsale_time;
    }

    public final Long component15() {
        return this.off_time;
    }

    public final Integer component16() {
        return this.unlock_type;
    }

    public final Map<String, Integer> component17() {
        return this.typeCountInfo;
    }

    public final Integer component18() {
        return this.vip;
    }

    public final String component19() {
        return this.vip_banner;
    }

    public final String component2() {
        return this.descript;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.icon;
    }

    public final String component5() {
        return this.origin_pic;
    }

    public final ArrayList<EffectPicInfo> component6() {
        return this.effect_pic_info;
    }

    public final String component7() {
        return this.package_zip;
    }

    public final String component8() {
        return this.package_zip_md5;
    }

    public final String component9() {
        return this.display_zip_url;
    }

    public final FilterDetailData copy(String str, String str2, String str3, String str4, String str5, ArrayList<EffectPicInfo> arrayList, String str6, String str7, String str8, String str9, Integer num, ArrayList<FilterZipItem> arrayList2, Integer num2, Long l2, Long l3, Integer num3, Map<String, Integer> map, Integer num4, String str10) {
        return new FilterDetailData(str, str2, str3, str4, str5, arrayList, str6, str7, str8, str9, num, arrayList2, num2, l2, l3, num3, map, num4, str10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FilterDetailData) {
            FilterDetailData filterDetailData = (FilterDetailData) obj;
            return s.c(this.pid, filterDetailData.pid) && s.c(this.descript, filterDetailData.descript) && s.c(this.name, filterDetailData.name) && s.c(this.icon, filterDetailData.icon) && s.c(this.origin_pic, filterDetailData.origin_pic) && s.c(this.effect_pic_info, filterDetailData.effect_pic_info) && s.c(this.package_zip, filterDetailData.package_zip) && s.c(this.package_zip_md5, filterDetailData.package_zip_md5) && s.c(this.display_zip_url, filterDetailData.display_zip_url) && s.c(this.display_zip_md5, filterDetailData.display_zip_md5) && s.c(this.file_size, filterDetailData.file_size) && s.c(this.items, filterDetailData.items) && s.c(this.type, filterDetailData.type) && s.c(this.onsale_time, filterDetailData.onsale_time) && s.c(this.off_time, filterDetailData.off_time) && s.c(this.unlock_type, filterDetailData.unlock_type) && s.c(this.typeCountInfo, filterDetailData.typeCountInfo) && s.c(this.vip, filterDetailData.vip) && s.c(this.vip_banner, filterDetailData.vip_banner);
        }
        return false;
    }

    public final String getDescript() {
        return this.descript;
    }

    public final String getDisplay_zip_md5() {
        return this.display_zip_md5;
    }

    public final String getDisplay_zip_url() {
        return this.display_zip_url;
    }

    public final ArrayList<EffectPicInfo> getEffect_pic_info() {
        return this.effect_pic_info;
    }

    public final Integer getFile_size() {
        return this.file_size;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final ArrayList<FilterZipItem> getItems() {
        return this.items;
    }

    public final String getName() {
        return this.name;
    }

    public final Long getOff_time() {
        return this.off_time;
    }

    public final Long getOnsale_time() {
        return this.onsale_time;
    }

    public final String getOrigin_pic() {
        return this.origin_pic;
    }

    public final String getPackage_zip() {
        return this.package_zip;
    }

    public final String getPackage_zip_md5() {
        return this.package_zip_md5;
    }

    public final String getPid() {
        return this.pid;
    }

    public final Integer getType() {
        return this.type;
    }

    public final Map<String, Integer> getTypeCountInfo() {
        return this.typeCountInfo;
    }

    public final Integer getUnlock_type() {
        return this.unlock_type;
    }

    public final Integer getVip() {
        return this.vip;
    }

    public final String getVip_banner() {
        return this.vip_banner;
    }

    public int hashCode() {
        String str = this.pid;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.descript;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.name;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.icon;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.origin_pic;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        ArrayList<EffectPicInfo> arrayList = this.effect_pic_info;
        int hashCode6 = (hashCode5 + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        String str6 = this.package_zip;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.package_zip_md5;
        int hashCode8 = (hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.display_zip_url;
        int hashCode9 = (hashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.display_zip_md5;
        int hashCode10 = (hashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31;
        Integer num = this.file_size;
        int hashCode11 = (hashCode10 + (num == null ? 0 : num.hashCode())) * 31;
        ArrayList<FilterZipItem> arrayList2 = this.items;
        int hashCode12 = (hashCode11 + (arrayList2 == null ? 0 : arrayList2.hashCode())) * 31;
        Integer num2 = this.type;
        int hashCode13 = (hashCode12 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Long l2 = this.onsale_time;
        int hashCode14 = (hashCode13 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Long l3 = this.off_time;
        int hashCode15 = (hashCode14 + (l3 == null ? 0 : l3.hashCode())) * 31;
        Integer num3 = this.unlock_type;
        int hashCode16 = (hashCode15 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Map<String, Integer> map = this.typeCountInfo;
        int hashCode17 = (hashCode16 + (map == null ? 0 : map.hashCode())) * 31;
        Integer num4 = this.vip;
        int hashCode18 = (hashCode17 + (num4 == null ? 0 : num4.hashCode())) * 31;
        String str10 = this.vip_banner;
        return hashCode18 + (str10 != null ? str10.hashCode() : 0);
    }

    public String toString() {
        return "FilterDetailData(pid=" + ((Object) this.pid) + ", descript=" + ((Object) this.descript) + ", name=" + ((Object) this.name) + ", icon=" + ((Object) this.icon) + ", origin_pic=" + ((Object) this.origin_pic) + ", effect_pic_info=" + this.effect_pic_info + ", package_zip=" + ((Object) this.package_zip) + ", package_zip_md5=" + ((Object) this.package_zip_md5) + ", display_zip_url=" + ((Object) this.display_zip_url) + ", display_zip_md5=" + ((Object) this.display_zip_md5) + ", file_size=" + this.file_size + ", items=" + this.items + ", type=" + this.type + ", onsale_time=" + this.onsale_time + ", off_time=" + this.off_time + ", unlock_type=" + this.unlock_type + ", typeCountInfo=" + this.typeCountInfo + ", vip=" + this.vip + ", vip_banner=" + ((Object) this.vip_banner) + ')';
    }
}
