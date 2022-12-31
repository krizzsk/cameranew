package us.pinguo.repository2020.entity;

import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: FilterZipItem.kt */
/* loaded from: classes6.dex */
public final class FilterZipItem implements NoProguard {
    private final String display_zip_md5;
    private final String display_zip_url;
    private final String id;
    private final Boolean is_cloud_effect;
    private final String sub_type;
    private final String zip_md5;
    private final String zip_url;

    public FilterZipItem(String str, String str2, Boolean bool, String str3, String str4, String str5, String str6) {
        this.id = str;
        this.sub_type = str2;
        this.is_cloud_effect = bool;
        this.zip_url = str3;
        this.zip_md5 = str4;
        this.display_zip_url = str5;
        this.display_zip_md5 = str6;
    }

    public static /* synthetic */ FilterZipItem copy$default(FilterZipItem filterZipItem, String str, String str2, Boolean bool, String str3, String str4, String str5, String str6, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = filterZipItem.id;
        }
        if ((i2 & 2) != 0) {
            str2 = filterZipItem.sub_type;
        }
        String str7 = str2;
        if ((i2 & 4) != 0) {
            bool = filterZipItem.is_cloud_effect;
        }
        Boolean bool2 = bool;
        if ((i2 & 8) != 0) {
            str3 = filterZipItem.zip_url;
        }
        String str8 = str3;
        if ((i2 & 16) != 0) {
            str4 = filterZipItem.zip_md5;
        }
        String str9 = str4;
        if ((i2 & 32) != 0) {
            str5 = filterZipItem.display_zip_url;
        }
        String str10 = str5;
        if ((i2 & 64) != 0) {
            str6 = filterZipItem.display_zip_md5;
        }
        return filterZipItem.copy(str, str7, bool2, str8, str9, str10, str6);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.sub_type;
    }

    public final Boolean component3() {
        return this.is_cloud_effect;
    }

    public final String component4() {
        return this.zip_url;
    }

    public final String component5() {
        return this.zip_md5;
    }

    public final String component6() {
        return this.display_zip_url;
    }

    public final String component7() {
        return this.display_zip_md5;
    }

    public final FilterZipItem copy(String str, String str2, Boolean bool, String str3, String str4, String str5, String str6) {
        return new FilterZipItem(str, str2, bool, str3, str4, str5, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FilterZipItem) {
            FilterZipItem filterZipItem = (FilterZipItem) obj;
            return s.c(this.id, filterZipItem.id) && s.c(this.sub_type, filterZipItem.sub_type) && s.c(this.is_cloud_effect, filterZipItem.is_cloud_effect) && s.c(this.zip_url, filterZipItem.zip_url) && s.c(this.zip_md5, filterZipItem.zip_md5) && s.c(this.display_zip_url, filterZipItem.display_zip_url) && s.c(this.display_zip_md5, filterZipItem.display_zip_md5);
        }
        return false;
    }

    public final String getDisplay_zip_md5() {
        return this.display_zip_md5;
    }

    public final String getDisplay_zip_url() {
        return this.display_zip_url;
    }

    public final String getId() {
        return this.id;
    }

    public final String getSub_type() {
        return this.sub_type;
    }

    public final String getZip_md5() {
        return this.zip_md5;
    }

    public final String getZip_url() {
        return this.zip_url;
    }

    public int hashCode() {
        String str = this.id;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.sub_type;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.is_cloud_effect;
        int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str3 = this.zip_url;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.zip_md5;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.display_zip_url;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.display_zip_md5;
        return hashCode6 + (str6 != null ? str6.hashCode() : 0);
    }

    public final Boolean is_cloud_effect() {
        return this.is_cloud_effect;
    }

    public String toString() {
        return "FilterZipItem(id=" + ((Object) this.id) + ", sub_type=" + ((Object) this.sub_type) + ", is_cloud_effect=" + this.is_cloud_effect + ", zip_url=" + ((Object) this.zip_url) + ", zip_md5=" + ((Object) this.zip_md5) + ", display_zip_url=" + ((Object) this.display_zip_url) + ", display_zip_md5=" + ((Object) this.display_zip_md5) + ')';
    }
}
