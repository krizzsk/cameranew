package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import androidx.annotation.Nullable;
/* renamed from: com.facebook.ads.redexgen.X.Dv  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0807Dv {
    public final String A00;
    public final boolean A01;

    public C0807Dv(String str, boolean z) {
        this.A00 = str;
        this.A01 = z;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != C0807Dv.class) {
            return false;
        }
        C0807Dv c0807Dv = (C0807Dv) obj;
        return TextUtils.equals(this.A00, c0807Dv.A00) && this.A01 == c0807Dv.A01;
    }

    public final int hashCode() {
        int i2 = 1 * 31;
        String str = this.A00;
        int result = str == null ? 0 : str.hashCode();
        int result2 = (i2 + result) * 31;
        int result3 = this.A01 ? 1231 : 1237;
        return result2 + result3;
    }
}
