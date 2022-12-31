package us.pinguo.repository2020.database.sticker;

import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: StickerDetail.kt */
/* loaded from: classes6.dex */
public final class StickerUpdateData implements NoProguard {
    private final String display_zip_md5;
    private final String display_zip_url;
    private final String package_zip_md5;
    private final String package_zip_url;
    private final String pid;

    public StickerUpdateData(String pid, String package_zip_url, String package_zip_md5, String display_zip_url, String display_zip_md5) {
        s.h(pid, "pid");
        s.h(package_zip_url, "package_zip_url");
        s.h(package_zip_md5, "package_zip_md5");
        s.h(display_zip_url, "display_zip_url");
        s.h(display_zip_md5, "display_zip_md5");
        this.pid = pid;
        this.package_zip_url = package_zip_url;
        this.package_zip_md5 = package_zip_md5;
        this.display_zip_url = display_zip_url;
        this.display_zip_md5 = display_zip_md5;
    }

    public static /* synthetic */ StickerUpdateData copy$default(StickerUpdateData stickerUpdateData, String str, String str2, String str3, String str4, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = stickerUpdateData.pid;
        }
        if ((i2 & 2) != 0) {
            str2 = stickerUpdateData.package_zip_url;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = stickerUpdateData.package_zip_md5;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            str4 = stickerUpdateData.display_zip_url;
        }
        String str8 = str4;
        if ((i2 & 16) != 0) {
            str5 = stickerUpdateData.display_zip_md5;
        }
        return stickerUpdateData.copy(str, str6, str7, str8, str5);
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

    public final StickerUpdateData copy(String pid, String package_zip_url, String package_zip_md5, String display_zip_url, String display_zip_md5) {
        s.h(pid, "pid");
        s.h(package_zip_url, "package_zip_url");
        s.h(package_zip_md5, "package_zip_md5");
        s.h(display_zip_url, "display_zip_url");
        s.h(display_zip_md5, "display_zip_md5");
        return new StickerUpdateData(pid, package_zip_url, package_zip_md5, display_zip_url, display_zip_md5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StickerUpdateData) {
            StickerUpdateData stickerUpdateData = (StickerUpdateData) obj;
            return s.c(this.pid, stickerUpdateData.pid) && s.c(this.package_zip_url, stickerUpdateData.package_zip_url) && s.c(this.package_zip_md5, stickerUpdateData.package_zip_md5) && s.c(this.display_zip_url, stickerUpdateData.display_zip_url) && s.c(this.display_zip_md5, stickerUpdateData.display_zip_md5);
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
        return (((((((this.pid.hashCode() * 31) + this.package_zip_url.hashCode()) * 31) + this.package_zip_md5.hashCode()) * 31) + this.display_zip_url.hashCode()) * 31) + this.display_zip_md5.hashCode();
    }

    public String toString() {
        return "StickerUpdateData(pid=" + this.pid + ", package_zip_url=" + this.package_zip_url + ", package_zip_md5=" + this.package_zip_md5 + ", display_zip_url=" + this.display_zip_url + ", display_zip_md5=" + this.display_zip_md5 + ')';
    }
}
