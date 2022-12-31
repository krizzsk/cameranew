package us.pinguo.repository2020.entity;

import java.util.Map;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: Package.kt */
/* loaded from: classes6.dex */
public final class Package implements NoProguard {
    private final Integer camera_support;
    private final Long category_off_time;
    private final Long category_onsale_time;
    private final String icon;
    private final Integer icon_tag;
    private final String icon_tag_pic;
    private final Integer music_tag;
    private final String name;
    private final Long off_time;
    private final Long onsale_time;
    private final PayInfo pay_info;
    private final String pid;
    private final Integer position;
    private final String sid;
    private final Integer tagContent;
    private final Long tagOffTime;
    private final Long tagOnTime;
    private final Integer type;
    private final Map<String, Integer> typeCountInfo;
    private final Integer unity_engine_filter;
    private final Integer unlock_type;
    private Integer vip;
    private final String vip_banner;

    public Package(String str, String str2, String str3, Integer num, Long l2, Long l3, Integer num2, Integer num3, Map<String, Integer> map, PayInfo payInfo, Integer num4, Integer num5, String str4, Long l4, Long l5, String str5, String str6, Integer num6, Integer num7, Integer num8, Integer num9, Long l6, Long l7) {
        this.pid = str;
        this.icon = str2;
        this.name = str3;
        this.type = num;
        this.onsale_time = l2;
        this.off_time = l3;
        this.unlock_type = num2;
        this.position = num3;
        this.typeCountInfo = map;
        this.pay_info = payInfo;
        this.music_tag = num4;
        this.icon_tag = num5;
        this.icon_tag_pic = str4;
        this.category_onsale_time = l4;
        this.category_off_time = l5;
        this.sid = str5;
        this.vip_banner = str6;
        this.vip = num6;
        this.unity_engine_filter = num7;
        this.camera_support = num8;
        this.tagContent = num9;
        this.tagOnTime = l6;
        this.tagOffTime = l7;
    }

    public final String component1() {
        return this.pid;
    }

    public final PayInfo component10() {
        return this.pay_info;
    }

    public final Integer component11() {
        return this.music_tag;
    }

    public final Integer component12() {
        return this.icon_tag;
    }

    public final String component13() {
        return this.icon_tag_pic;
    }

    public final Long component14() {
        return this.category_onsale_time;
    }

    public final Long component15() {
        return this.category_off_time;
    }

    public final String component16() {
        return this.sid;
    }

    public final String component17() {
        return this.vip_banner;
    }

    public final Integer component18() {
        return this.vip;
    }

    public final Integer component19() {
        return this.unity_engine_filter;
    }

    public final String component2() {
        return this.icon;
    }

    public final Integer component20() {
        return this.camera_support;
    }

    public final Integer component21() {
        return this.tagContent;
    }

    public final Long component22() {
        return this.tagOnTime;
    }

    public final Long component23() {
        return this.tagOffTime;
    }

    public final String component3() {
        return this.name;
    }

    public final Integer component4() {
        return this.type;
    }

    public final Long component5() {
        return this.onsale_time;
    }

    public final Long component6() {
        return this.off_time;
    }

    public final Integer component7() {
        return this.unlock_type;
    }

    public final Integer component8() {
        return this.position;
    }

    public final Map<String, Integer> component9() {
        return this.typeCountInfo;
    }

    public final Package copy(String str, String str2, String str3, Integer num, Long l2, Long l3, Integer num2, Integer num3, Map<String, Integer> map, PayInfo payInfo, Integer num4, Integer num5, String str4, Long l4, Long l5, String str5, String str6, Integer num6, Integer num7, Integer num8, Integer num9, Long l6, Long l7) {
        return new Package(str, str2, str3, num, l2, l3, num2, num3, map, payInfo, num4, num5, str4, l4, l5, str5, str6, num6, num7, num8, num9, l6, l7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Package) {
            Package r5 = (Package) obj;
            return s.c(this.pid, r5.pid) && s.c(this.icon, r5.icon) && s.c(this.name, r5.name) && s.c(this.type, r5.type) && s.c(this.onsale_time, r5.onsale_time) && s.c(this.off_time, r5.off_time) && s.c(this.unlock_type, r5.unlock_type) && s.c(this.position, r5.position) && s.c(this.typeCountInfo, r5.typeCountInfo) && s.c(this.pay_info, r5.pay_info) && s.c(this.music_tag, r5.music_tag) && s.c(this.icon_tag, r5.icon_tag) && s.c(this.icon_tag_pic, r5.icon_tag_pic) && s.c(this.category_onsale_time, r5.category_onsale_time) && s.c(this.category_off_time, r5.category_off_time) && s.c(this.sid, r5.sid) && s.c(this.vip_banner, r5.vip_banner) && s.c(this.vip, r5.vip) && s.c(this.unity_engine_filter, r5.unity_engine_filter) && s.c(this.camera_support, r5.camera_support) && s.c(this.tagContent, r5.tagContent) && s.c(this.tagOnTime, r5.tagOnTime) && s.c(this.tagOffTime, r5.tagOffTime);
        }
        return false;
    }

    public final Integer getCamera_support() {
        return this.camera_support;
    }

    public final Long getCategory_off_time() {
        return this.category_off_time;
    }

    public final Long getCategory_onsale_time() {
        return this.category_onsale_time;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final Integer getIcon_tag() {
        return this.icon_tag;
    }

    public final String getIcon_tag_pic() {
        return this.icon_tag_pic;
    }

    public final Integer getMusic_tag() {
        return this.music_tag;
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

    public final PayInfo getPay_info() {
        return this.pay_info;
    }

    public final String getPid() {
        return this.pid;
    }

    public final Integer getPosition() {
        return this.position;
    }

    public final String getSid() {
        return this.sid;
    }

    public final Integer getTagContent() {
        return this.tagContent;
    }

    public final Long getTagOffTime() {
        return this.tagOffTime;
    }

    public final Long getTagOnTime() {
        return this.tagOnTime;
    }

    public final Integer getType() {
        return this.type;
    }

    public final Map<String, Integer> getTypeCountInfo() {
        return this.typeCountInfo;
    }

    public final Integer getUnity_engine_filter() {
        return this.unity_engine_filter;
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
        String str2 = this.icon;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.name;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.type;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        Long l2 = this.onsale_time;
        int hashCode5 = (hashCode4 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Long l3 = this.off_time;
        int hashCode6 = (hashCode5 + (l3 == null ? 0 : l3.hashCode())) * 31;
        Integer num2 = this.unlock_type;
        int hashCode7 = (hashCode6 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.position;
        int hashCode8 = (hashCode7 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Map<String, Integer> map = this.typeCountInfo;
        int hashCode9 = (hashCode8 + (map == null ? 0 : map.hashCode())) * 31;
        PayInfo payInfo = this.pay_info;
        int hashCode10 = (hashCode9 + (payInfo == null ? 0 : payInfo.hashCode())) * 31;
        Integer num4 = this.music_tag;
        int hashCode11 = (hashCode10 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.icon_tag;
        int hashCode12 = (hashCode11 + (num5 == null ? 0 : num5.hashCode())) * 31;
        String str4 = this.icon_tag_pic;
        int hashCode13 = (hashCode12 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Long l4 = this.category_onsale_time;
        int hashCode14 = (hashCode13 + (l4 == null ? 0 : l4.hashCode())) * 31;
        Long l5 = this.category_off_time;
        int hashCode15 = (hashCode14 + (l5 == null ? 0 : l5.hashCode())) * 31;
        String str5 = this.sid;
        int hashCode16 = (hashCode15 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.vip_banner;
        int hashCode17 = (hashCode16 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Integer num6 = this.vip;
        int hashCode18 = (hashCode17 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Integer num7 = this.unity_engine_filter;
        int hashCode19 = (hashCode18 + (num7 == null ? 0 : num7.hashCode())) * 31;
        Integer num8 = this.camera_support;
        int hashCode20 = (hashCode19 + (num8 == null ? 0 : num8.hashCode())) * 31;
        Integer num9 = this.tagContent;
        int hashCode21 = (hashCode20 + (num9 == null ? 0 : num9.hashCode())) * 31;
        Long l6 = this.tagOnTime;
        int hashCode22 = (hashCode21 + (l6 == null ? 0 : l6.hashCode())) * 31;
        Long l7 = this.tagOffTime;
        return hashCode22 + (l7 != null ? l7.hashCode() : 0);
    }

    public final void setVip(Integer num) {
        this.vip = num;
    }

    public String toString() {
        return "Package(pid=" + ((Object) this.pid) + ", icon=" + ((Object) this.icon) + ", name=" + ((Object) this.name) + ", type=" + this.type + ", onsale_time=" + this.onsale_time + ", off_time=" + this.off_time + ", unlock_type=" + this.unlock_type + ", position=" + this.position + ", typeCountInfo=" + this.typeCountInfo + ", pay_info=" + this.pay_info + ", music_tag=" + this.music_tag + ", icon_tag=" + this.icon_tag + ", icon_tag_pic=" + ((Object) this.icon_tag_pic) + ", category_onsale_time=" + this.category_onsale_time + ", category_off_time=" + this.category_off_time + ", sid=" + ((Object) this.sid) + ", vip_banner=" + ((Object) this.vip_banner) + ", vip=" + this.vip + ", unity_engine_filter=" + this.unity_engine_filter + ", camera_support=" + this.camera_support + ", tagContent=" + this.tagContent + ", tagOnTime=" + this.tagOnTime + ", tagOffTime=" + this.tagOffTime + ')';
    }

    public /* synthetic */ Package(String str, String str2, String str3, Integer num, Long l2, Long l3, Integer num2, Integer num3, Map map, PayInfo payInfo, Integer num4, Integer num5, String str4, Long l4, Long l5, String str5, String str6, Integer num6, Integer num7, Integer num8, Integer num9, Long l6, Long l7, int i2, o oVar) {
        this(str, str2, str3, num, l2, l3, num2, num3, map, payInfo, num4, num5, str4, l4, l5, str5, str6, (i2 & 131072) != 0 ? 0 : num6, (i2 & 262144) != 0 ? 0 : num7, (i2 & 524288) != 0 ? 1 : num8, (i2 & 1048576) != 0 ? 0 : num9, (i2 & 2097152) != 0 ? 0L : l6, (i2 & 4194304) != 0 ? 0L : l7);
    }
}
