package us.pinguo.repository2020.database.sticker;

import java.util.Arrays;
import java.util.Objects;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: StickerDetail.kt */
/* loaded from: classes6.dex */
public final class StickerDetail implements NoProguard {
    private final String descript;
    private String display_zip_md5;
    private String display_zip_url;
    private final EffectPicInfo[] effect_pic_info;
    private final long file_size;
    private final String icon;
    private final StickerDetailItem[] items;
    private final String name;
    private final long off_time;
    private final long onsale_time;
    private final String origin_pic;
    private String package_zip;
    private String package_zip_md5;
    private final String pid;
    private final int type;
    private final DetailTypeCountInfo typeCountInfo;
    private final int unlock_type;
    private final int vip;
    private final String vip_banner;

    public StickerDetail(String pid, String descript, String name, String icon, String origin_pic, EffectPicInfo[] effect_pic_info, String package_zip, String package_zip_md5, String display_zip_url, String display_zip_md5, long j2, StickerDetailItem[] items, int i2, long j3, long j4, int i3, DetailTypeCountInfo typeCountInfo, int i4, String vip_banner) {
        s.h(pid, "pid");
        s.h(descript, "descript");
        s.h(name, "name");
        s.h(icon, "icon");
        s.h(origin_pic, "origin_pic");
        s.h(effect_pic_info, "effect_pic_info");
        s.h(package_zip, "package_zip");
        s.h(package_zip_md5, "package_zip_md5");
        s.h(display_zip_url, "display_zip_url");
        s.h(display_zip_md5, "display_zip_md5");
        s.h(items, "items");
        s.h(typeCountInfo, "typeCountInfo");
        s.h(vip_banner, "vip_banner");
        this.pid = pid;
        this.descript = descript;
        this.name = name;
        this.icon = icon;
        this.origin_pic = origin_pic;
        this.effect_pic_info = effect_pic_info;
        this.package_zip = package_zip;
        this.package_zip_md5 = package_zip_md5;
        this.display_zip_url = display_zip_url;
        this.display_zip_md5 = display_zip_md5;
        this.file_size = j2;
        this.items = items;
        this.type = i2;
        this.onsale_time = j3;
        this.off_time = j4;
        this.unlock_type = i3;
        this.typeCountInfo = typeCountInfo;
        this.vip = i4;
        this.vip_banner = vip_banner;
    }

    public final String component1() {
        return this.pid;
    }

    public final String component10() {
        return this.display_zip_md5;
    }

    public final long component11() {
        return this.file_size;
    }

    public final StickerDetailItem[] component12() {
        return this.items;
    }

    public final int component13() {
        return this.type;
    }

    public final long component14() {
        return this.onsale_time;
    }

    public final long component15() {
        return this.off_time;
    }

    public final int component16() {
        return this.unlock_type;
    }

    public final DetailTypeCountInfo component17() {
        return this.typeCountInfo;
    }

    public final int component18() {
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

    public final EffectPicInfo[] component6() {
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

    public final StickerDetail copy(String pid, String descript, String name, String icon, String origin_pic, EffectPicInfo[] effect_pic_info, String package_zip, String package_zip_md5, String display_zip_url, String display_zip_md5, long j2, StickerDetailItem[] items, int i2, long j3, long j4, int i3, DetailTypeCountInfo typeCountInfo, int i4, String vip_banner) {
        s.h(pid, "pid");
        s.h(descript, "descript");
        s.h(name, "name");
        s.h(icon, "icon");
        s.h(origin_pic, "origin_pic");
        s.h(effect_pic_info, "effect_pic_info");
        s.h(package_zip, "package_zip");
        s.h(package_zip_md5, "package_zip_md5");
        s.h(display_zip_url, "display_zip_url");
        s.h(display_zip_md5, "display_zip_md5");
        s.h(items, "items");
        s.h(typeCountInfo, "typeCountInfo");
        s.h(vip_banner, "vip_banner");
        return new StickerDetail(pid, descript, name, icon, origin_pic, effect_pic_info, package_zip, package_zip_md5, display_zip_url, display_zip_md5, j2, items, i2, j3, j4, i3, typeCountInfo, i4, vip_banner);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (s.c(StickerDetail.class, obj == null ? null : obj.getClass())) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type us.pinguo.repository2020.database.sticker.StickerDetail");
            StickerDetail stickerDetail = (StickerDetail) obj;
            return s.c(this.pid, stickerDetail.pid) && s.c(this.descript, stickerDetail.descript) && s.c(this.name, stickerDetail.name) && s.c(this.icon, stickerDetail.icon) && s.c(this.origin_pic, stickerDetail.origin_pic) && Arrays.equals(this.effect_pic_info, stickerDetail.effect_pic_info) && s.c(this.package_zip, stickerDetail.package_zip) && s.c(this.package_zip_md5, stickerDetail.package_zip_md5) && s.c(this.display_zip_url, stickerDetail.display_zip_url) && s.c(this.display_zip_md5, stickerDetail.display_zip_md5) && this.file_size == stickerDetail.file_size && Arrays.equals(this.items, stickerDetail.items) && this.type == stickerDetail.type && this.onsale_time == stickerDetail.onsale_time && this.off_time == stickerDetail.off_time && this.unlock_type == stickerDetail.unlock_type && s.c(this.typeCountInfo, stickerDetail.typeCountInfo) && this.vip == stickerDetail.vip && s.c(this.vip_banner, stickerDetail.vip_banner);
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

    public final EffectPicInfo[] getEffect_pic_info() {
        return this.effect_pic_info;
    }

    public final long getFile_size() {
        return this.file_size;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final StickerDetailItem[] getItems() {
        return this.items;
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

    public final int getType() {
        return this.type;
    }

    public final DetailTypeCountInfo getTypeCountInfo() {
        return this.typeCountInfo;
    }

    public final int getUnlock_type() {
        return this.unlock_type;
    }

    public final int getVip() {
        return this.vip;
    }

    public final String getVip_banner() {
        return this.vip_banner;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((this.pid.hashCode() * 31) + this.descript.hashCode()) * 31) + this.name.hashCode()) * 31) + this.icon.hashCode()) * 31) + this.origin_pic.hashCode()) * 31) + Arrays.hashCode(this.effect_pic_info)) * 31) + this.package_zip.hashCode()) * 31) + this.package_zip_md5.hashCode()) * 31) + this.display_zip_url.hashCode()) * 31) + this.display_zip_md5.hashCode()) * 31) + defpackage.c.a(this.file_size)) * 31) + this.type) * 31) + defpackage.c.a(this.onsale_time)) * 31) + defpackage.c.a(this.off_time)) * 31) + this.unlock_type) * 31) + this.typeCountInfo.hashCode()) * 31) + this.vip) * 31) + this.vip_banner.hashCode();
    }

    public final void setDisplay_zip_md5(String str) {
        s.h(str, "<set-?>");
        this.display_zip_md5 = str;
    }

    public final void setDisplay_zip_url(String str) {
        s.h(str, "<set-?>");
        this.display_zip_url = str;
    }

    public final void setPackage_zip(String str) {
        s.h(str, "<set-?>");
        this.package_zip = str;
    }

    public final void setPackage_zip_md5(String str) {
        s.h(str, "<set-?>");
        this.package_zip_md5 = str;
    }

    public String toString() {
        return "StickerDetail(pid=" + this.pid + ", descript=" + this.descript + ", name=" + this.name + ", icon=" + this.icon + ", origin_pic=" + this.origin_pic + ", effect_pic_info=" + Arrays.toString(this.effect_pic_info) + ", package_zip=" + this.package_zip + ", package_zip_md5=" + this.package_zip_md5 + ", display_zip_url=" + this.display_zip_url + ", display_zip_md5=" + this.display_zip_md5 + ", file_size=" + this.file_size + ", items=" + Arrays.toString(this.items) + ", type=" + this.type + ", onsale_time=" + this.onsale_time + ", off_time=" + this.off_time + ", unlock_type=" + this.unlock_type + ", typeCountInfo=" + this.typeCountInfo + ", vip=" + this.vip + ", vip_banner=" + this.vip_banner + ')';
    }
}
