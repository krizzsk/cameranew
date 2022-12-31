package us.pinguo.repository2020.entity;

import java.util.ArrayList;
import java.util.Map;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: Material.kt */
/* loaded from: classes6.dex */
public class MaterialDetail implements NoProguard {
    private final String descript;
    private final String display_zip_md5;
    private final String display_zip_url;
    private final ArrayList<EffectPicInfo> effect_pic_info;
    private final Integer file_size;
    private final String icon;
    private final ArrayList<MaterialItem> items;
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

    public MaterialDetail(String str, String str2, String str3, String str4, String str5, ArrayList<EffectPicInfo> arrayList, String str6, String str7, String str8, String str9, Integer num, ArrayList<MaterialItem> arrayList2, Integer num2, Long l2, Long l3, Integer num3, Map<String, Integer> map, Integer num4, String str10) {
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

    public final ArrayList<MaterialItem> getItems() {
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
}
