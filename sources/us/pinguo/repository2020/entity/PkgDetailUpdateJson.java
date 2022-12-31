package us.pinguo.repository2020.entity;

import kotlin.jvm.internal.o;
/* compiled from: PkgDetailUpdateData.kt */
/* loaded from: classes6.dex */
public final class PkgDetailUpdateJson {
    private final PkgDetailUpdateData[] data;
    private final String message;
    private final Integer status;

    public PkgDetailUpdateJson() {
        this(null, null, null, 7, null);
    }

    public PkgDetailUpdateJson(Integer num, String str, PkgDetailUpdateData[] pkgDetailUpdateDataArr) {
        this.status = num;
        this.message = str;
        this.data = pkgDetailUpdateDataArr;
    }

    public final PkgDetailUpdateData[] getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public /* synthetic */ PkgDetailUpdateJson(Integer num, String str, PkgDetailUpdateData[] pkgDetailUpdateDataArr, int i2, o oVar) {
        this((i2 & 1) != 0 ? null : num, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : pkgDetailUpdateDataArr);
    }
}
