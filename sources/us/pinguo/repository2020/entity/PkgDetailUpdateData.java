package us.pinguo.repository2020.entity;

import kotlin.jvm.internal.o;
/* compiled from: PkgDetailUpdateData.kt */
/* loaded from: classes6.dex */
public final class PkgDetailUpdateData {
    private final String display_zip_md5;
    private final String display_zip_url;
    private final String package_zip_md5;
    private final String package_zip_url;
    private final String pid;

    public PkgDetailUpdateData() {
        this(null, null, null, null, null, 31, null);
    }

    public PkgDetailUpdateData(String str, String str2, String str3, String str4, String str5) {
        this.pid = str;
        this.display_zip_url = str2;
        this.display_zip_md5 = str3;
        this.package_zip_url = str4;
        this.package_zip_md5 = str5;
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

    public /* synthetic */ PkgDetailUpdateData(String str, String str2, String str3, String str4, String str5, int i2, o oVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : str4, (i2 & 16) != 0 ? null : str5);
    }
}
