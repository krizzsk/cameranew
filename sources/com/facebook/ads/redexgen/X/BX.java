package com.facebook.ads.redexgen.X;

import androidx.core.location.LocationRequestCompat;
import java.util.List;
/* loaded from: assets/audience_network.dex */
public abstract class BX extends WY implements GL {
    public static String[] A02 = {"", "mui60dwzFhaHNm2Uk6c71g13RzPqoL9o", "B0rzWlns", "IaExOe45iIyqIoKsg3ghGHNojNO5y7aX", "6x0KWKc5lmTcd6rSDKCIntspSHI5N7vM", "fpXFGNqhd64a2XzCiJ5Y2uwqVb67lOfi", "JEeTPk6X6cicZdwnLWr3cLjXKJNjxOw", "om0z9vsHwazWN6uDNjDMJ"};
    public long A00;
    public GL A01;

    public abstract void A08();

    @Override // com.facebook.ads.redexgen.X.AbstractC0749Be
    public final void A07() {
        super.A07();
        this.A01 = null;
    }

    public final void A09(long j2, GL gl, long j3) {
        super.A01 = j2;
        this.A01 = gl;
        if (j3 == LocationRequestCompat.PASSIVE_INTERVAL) {
            j3 = super.A01;
        }
        this.A00 = j3;
        if (A02[0].length() != 0) {
            throw new RuntimeException();
        }
        A02[1] = "xukRyz5yFwN1nVXA8Rs2f92E1X9llmA1";
    }

    @Override // com.facebook.ads.redexgen.X.GL
    public final List<GK> A67(long j2) {
        return this.A01.A67(j2 - this.A00);
    }

    @Override // com.facebook.ads.redexgen.X.GL
    public final long A6X(int i2) {
        return this.A01.A6X(i2) + this.A00;
    }

    @Override // com.facebook.ads.redexgen.X.GL
    public final int A6Y() {
        return this.A01.A6Y();
    }

    @Override // com.facebook.ads.redexgen.X.GL
    public final int A6v(long j2) {
        return this.A01.A6v(j2 - this.A00);
    }
}
