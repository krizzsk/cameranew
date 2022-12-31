package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
/* loaded from: assets/audience_network.dex */
public final class AU {
    public static final AU A04 = new AU(1.0f);
    public final float A00;
    public final float A01;
    public final boolean A02;
    public final int A03;

    public AU(float f2) {
        this(f2, 1.0f, false);
    }

    public AU(float f2, float f3, boolean z) {
        I6.A03(f2 > 0.0f);
        I6.A03(f3 > 0.0f);
        this.A01 = f2;
        this.A00 = f3;
        this.A02 = z;
        this.A03 = Math.round(1000.0f * f2);
    }

    public final long A00(long j2) {
        return this.A03 * j2;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AU au = (AU) obj;
        return this.A01 == au.A01 && this.A00 == au.A00 && this.A02 == au.A02;
    }

    public final int hashCode() {
        int result = Float.floatToRawIntBits(this.A00);
        return (((((17 * 31) + Float.floatToRawIntBits(this.A01)) * 31) + result) * 31) + (this.A02 ? 1 : 0);
    }
}
