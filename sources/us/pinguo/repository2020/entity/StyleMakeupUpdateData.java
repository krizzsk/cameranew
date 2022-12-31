package us.pinguo.repository2020.entity;

import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: StyleMakeup.kt */
/* loaded from: classes6.dex */
public final class StyleMakeupUpdateData implements NoProguard {
    private String display_zip_md5;
    private String display_zip_url;
    private String package_zip_md5;
    private String package_zip_url;
    private String pid;

    public StyleMakeupUpdateData(String str, String str2, String str3, String str4, String str5) {
        this.pid = str;
        this.package_zip_url = str2;
        this.package_zip_md5 = str3;
        this.display_zip_url = str4;
        this.display_zip_md5 = str5;
    }

    public static /* synthetic */ StyleMakeupUpdateData copy$default(StyleMakeupUpdateData styleMakeupUpdateData, String str, String str2, String str3, String str4, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = styleMakeupUpdateData.pid;
        }
        if ((i2 & 2) != 0) {
            str2 = styleMakeupUpdateData.package_zip_url;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = styleMakeupUpdateData.package_zip_md5;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            str4 = styleMakeupUpdateData.display_zip_url;
        }
        String str8 = str4;
        if ((i2 & 16) != 0) {
            str5 = styleMakeupUpdateData.display_zip_md5;
        }
        return styleMakeupUpdateData.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.pid;
    }

    public final String component2() {
        return this.package_zip_url;
    }

    public final String component3() {
        return this.package_zip_md5;
    }

    public final String component4() {
        return this.display_zip_url;
    }

    public final String component5() {
        return this.display_zip_md5;
    }

    public final StyleMakeupUpdateData copy(String str, String str2, String str3, String str4, String str5) {
        return new StyleMakeupUpdateData(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StyleMakeupUpdateData) {
            StyleMakeupUpdateData styleMakeupUpdateData = (StyleMakeupUpdateData) obj;
            return s.c(this.pid, styleMakeupUpdateData.pid) && s.c(this.package_zip_url, styleMakeupUpdateData.package_zip_url) && s.c(this.package_zip_md5, styleMakeupUpdateData.package_zip_md5) && s.c(this.display_zip_url, styleMakeupUpdateData.display_zip_url) && s.c(this.display_zip_md5, styleMakeupUpdateData.display_zip_md5);
        }
        return false;
    }

    public final String getDisplay_zip_md5() {
        return this.display_zip_md5;
    }

    public final String getDisplay_zip_url() {
        return this.display_zip_url;
    }

    public final String getPackage_zip_md5() {
        return this.package_zip_md5;
    }

    public final String getPackage_zip_url() {
        return this.package_zip_url;
    }

    public final String getPid() {
        return this.pid;
    }

    public int hashCode() {
        String str = this.pid;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.package_zip_url;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.package_zip_md5;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.display_zip_url;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.display_zip_md5;
        return hashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public final void setDisplay_zip_md5(String str) {
        this.display_zip_md5 = str;
    }

    public final void setDisplay_zip_url(String str) {
        this.display_zip_url = str;
    }

    public final void setPackage_zip_md5(String str) {
        this.package_zip_md5 = str;
    }

    public final void setPackage_zip_url(String str) {
        this.package_zip_url = str;
    }

    public final void setPid(String str) {
        this.pid = str;
    }

    public String toString() {
        return "StyleMakeupUpdateData(pid=" + ((Object) this.pid) + ", package_zip_url=" + ((Object) this.package_zip_url) + ", package_zip_md5=" + ((Object) this.package_zip_md5) + ", display_zip_url=" + ((Object) this.display_zip_url) + ", display_zip_md5=" + ((Object) this.display_zip_md5) + ')';
    }
}
