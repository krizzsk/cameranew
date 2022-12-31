package us.pinguo.repository2020.database.sticker;

import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: StickerDetail.kt */
/* loaded from: classes6.dex */
public final class StickerDetailItem implements NoProguard {
    private final String display_zip_md5;
    private final String display_zip_url;
    private final String id;
    private final boolean is_cloud_effect;
    private final String sub_type;
    private final String zip_md5;
    private final String zip_url;

    public StickerDetailItem(String id, String sub_type, boolean z, String zip_url, String zip_md5, String display_zip_url, String display_zip_md5) {
        s.h(id, "id");
        s.h(sub_type, "sub_type");
        s.h(zip_url, "zip_url");
        s.h(zip_md5, "zip_md5");
        s.h(display_zip_url, "display_zip_url");
        s.h(display_zip_md5, "display_zip_md5");
        this.id = id;
        this.sub_type = sub_type;
        this.is_cloud_effect = z;
        this.zip_url = zip_url;
        this.zip_md5 = zip_md5;
        this.display_zip_url = display_zip_url;
        this.display_zip_md5 = display_zip_md5;
    }

    public static /* synthetic */ StickerDetailItem copy$default(StickerDetailItem stickerDetailItem, String str, String str2, boolean z, String str3, String str4, String str5, String str6, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = stickerDetailItem.id;
        }
        if ((i2 & 2) != 0) {
            str2 = stickerDetailItem.sub_type;
        }
        String str7 = str2;
        if ((i2 & 4) != 0) {
            z = stickerDetailItem.is_cloud_effect;
        }
        boolean z2 = z;
        if ((i2 & 8) != 0) {
            str3 = stickerDetailItem.zip_url;
        }
        String str8 = str3;
        if ((i2 & 16) != 0) {
            str4 = stickerDetailItem.zip_md5;
        }
        String str9 = str4;
        if ((i2 & 32) != 0) {
            str5 = stickerDetailItem.display_zip_url;
        }
        String str10 = str5;
        if ((i2 & 64) != 0) {
            str6 = stickerDetailItem.display_zip_md5;
        }
        return stickerDetailItem.copy(str, str7, z2, str8, str9, str10, str6);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.sub_type;
    }

    public final boolean component3() {
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

    public final StickerDetailItem copy(String id, String sub_type, boolean z, String zip_url, String zip_md5, String display_zip_url, String display_zip_md5) {
        s.h(id, "id");
        s.h(sub_type, "sub_type");
        s.h(zip_url, "zip_url");
        s.h(zip_md5, "zip_md5");
        s.h(display_zip_url, "display_zip_url");
        s.h(display_zip_md5, "display_zip_md5");
        return new StickerDetailItem(id, sub_type, z, zip_url, zip_md5, display_zip_url, display_zip_md5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StickerDetailItem) {
            StickerDetailItem stickerDetailItem = (StickerDetailItem) obj;
            return s.c(this.id, stickerDetailItem.id) && s.c(this.sub_type, stickerDetailItem.sub_type) && this.is_cloud_effect == stickerDetailItem.is_cloud_effect && s.c(this.zip_url, stickerDetailItem.zip_url) && s.c(this.zip_md5, stickerDetailItem.zip_md5) && s.c(this.display_zip_url, stickerDetailItem.display_zip_url) && s.c(this.display_zip_md5, stickerDetailItem.display_zip_md5);
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

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.id.hashCode() * 31) + this.sub_type.hashCode()) * 31;
        boolean z = this.is_cloud_effect;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        return ((((((((hashCode + i2) * 31) + this.zip_url.hashCode()) * 31) + this.zip_md5.hashCode()) * 31) + this.display_zip_url.hashCode()) * 31) + this.display_zip_md5.hashCode();
    }

    public final boolean is_cloud_effect() {
        return this.is_cloud_effect;
    }

    public String toString() {
        return "StickerDetailItem(id=" + this.id + ", sub_type=" + this.sub_type + ", is_cloud_effect=" + this.is_cloud_effect + ", zip_url=" + this.zip_url + ", zip_md5=" + this.zip_md5 + ", display_zip_url=" + this.display_zip_url + ", display_zip_md5=" + this.display_zip_md5 + ')';
    }
}
