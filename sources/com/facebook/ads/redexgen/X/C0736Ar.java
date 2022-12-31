package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
/* renamed from: com.facebook.ads.redexgen.X.Ar  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0736Ar {
    public final int A00;
    public final FL A01;

    public C0736Ar(int i2, FL fl) {
        this.A00 = i2;
        this.A01 = fl;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0736Ar c0736Ar = (C0736Ar) obj;
        return this.A00 == c0736Ar.A00 && this.A01.equals(c0736Ar.A01);
    }

    public final int hashCode() {
        return (this.A00 * 31) + this.A01.hashCode();
    }
}
