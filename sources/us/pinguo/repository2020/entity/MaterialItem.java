package us.pinguo.repository2020.entity;

import us.pinguo.foundation.utils.NoProguard;
/* compiled from: Material.kt */
/* loaded from: classes6.dex */
public class MaterialItem implements NoProguard {
    private final String display_zip_md5;
    private final String display_zip_url;
    private final String id;
    private final Boolean is_cloud_effect;
    private final String sub_type;
    private final String zip_md5;
    private final String zip_url;

    public MaterialItem(String str, String str2, Boolean bool, String str3, String str4, String str5, String str6) {
        this.id = str;
        this.sub_type = str2;
        this.is_cloud_effect = bool;
        this.zip_url = str3;
        this.zip_md5 = str4;
        this.display_zip_url = str5;
        this.display_zip_md5 = str6;
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

    public final Boolean is_cloud_effect() {
        return this.is_cloud_effect;
    }
}
