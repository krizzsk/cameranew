package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.media.AudioAttributes;
import androidx.annotation.Nullable;
/* loaded from: assets/audience_network.dex */
public final class B0 {
    public static final B0 A04 = new C0744Az().A00();
    public AudioAttributes A00;
    public final int A01;
    public final int A02;
    public final int A03;

    public B0(int i2, int i3, int i4) {
        this.A01 = i2;
        this.A02 = i3;
        this.A03 = i4;
    }

    @TargetApi(21)
    public final AudioAttributes A00() {
        if (this.A00 == null) {
            this.A00 = new AudioAttributes.Builder().setContentType(this.A01).setFlags(this.A02).setUsage(this.A03).build();
        }
        return this.A00;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        B0 b0 = (B0) obj;
        return this.A01 == b0.A01 && this.A02 == b0.A02 && this.A03 == b0.A03;
    }

    public final int hashCode() {
        int result = this.A02;
        return (((((17 * 31) + this.A01) * 31) + result) * 31) + this.A03;
    }
}
