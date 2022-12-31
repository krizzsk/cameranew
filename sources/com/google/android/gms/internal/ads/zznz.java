package com.google.android.gms.internal.ads;

import android.text.TextUtils;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zznz {
    public final int viewportHeight;
    public final int viewportWidth;
    private final String zzbha;
    private final String zzbhb;
    private final boolean zzbhc;
    private final boolean zzbhd;
    public final int zzbhe;
    public final int zzbhf;
    public final int zzbhg;
    public final boolean zzbhh;
    public final boolean zzbhi;
    public final boolean zzbhj;

    public zznz() {
        this(null, null, false, true, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, true, true, Integer.MAX_VALUE, Integer.MAX_VALUE, true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zznz.class == obj.getClass()) {
            zznz zznzVar = (zznz) obj;
            if (this.zzbhd == zznzVar.zzbhd && this.zzbhe == zznzVar.zzbhe && this.zzbhf == zznzVar.zzbhf && this.zzbhh == zznzVar.zzbhh && this.zzbhi == zznzVar.zzbhi && this.zzbhj == zznzVar.zzbhj && this.viewportWidth == zznzVar.viewportWidth && this.viewportHeight == zznzVar.viewportHeight && this.zzbhg == zznzVar.zzbhg && TextUtils.equals(null, null) && TextUtils.equals(null, null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = null;
        return (((((((((((((((((((str.hashCode() * 31) + str.hashCode()) * 31 * 31) + (this.zzbhd ? 1 : 0)) * 31) + this.zzbhe) * 31) + this.zzbhf) * 31) + this.zzbhg) * 31) + (this.zzbhh ? 1 : 0)) * 31) + (this.zzbhi ? 1 : 0)) * 31) + (this.zzbhj ? 1 : 0)) * 31) + this.viewportWidth) * 31) + this.viewportHeight;
    }

    private zznz(String str, String str2, boolean z, boolean z2, int i2, int i3, int i4, boolean z3, boolean z4, int i5, int i6, boolean z5) {
        this.zzbha = null;
        this.zzbhb = null;
        this.zzbhc = false;
        this.zzbhd = true;
        this.zzbhe = Integer.MAX_VALUE;
        this.zzbhf = Integer.MAX_VALUE;
        this.zzbhg = Integer.MAX_VALUE;
        this.zzbhh = true;
        this.zzbhi = true;
        this.viewportWidth = Integer.MAX_VALUE;
        this.viewportHeight = Integer.MAX_VALUE;
        this.zzbhj = true;
    }
}
