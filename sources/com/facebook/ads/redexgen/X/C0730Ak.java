package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import androidx.core.location.LocationRequestCompat;
/* renamed from: com.facebook.ads.redexgen.X.Ak  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0730Ak {
    public final long A00;
    public final long A01;
    public static final C0730Ak A04 = new C0730Ak(0, 0);
    public static final C0730Ak A02 = new C0730Ak(LocationRequestCompat.PASSIVE_INTERVAL, LocationRequestCompat.PASSIVE_INTERVAL);
    public static final C0730Ak A06 = new C0730Ak(LocationRequestCompat.PASSIVE_INTERVAL, 0);
    public static final C0730Ak A05 = new C0730Ak(0, LocationRequestCompat.PASSIVE_INTERVAL);
    public static final C0730Ak A03 = A04;

    public C0730Ak(long j2, long j3) {
        I6.A03(j2 >= 0);
        I6.A03(j3 >= 0);
        this.A01 = j2;
        this.A00 = j3;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0730Ak c0730Ak = (C0730Ak) obj;
        return this.A01 == c0730Ak.A01 && this.A00 == c0730Ak.A00;
    }

    public final int hashCode() {
        return (((int) this.A01) * 31) + ((int) this.A00);
    }
}
