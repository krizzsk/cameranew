package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.source.TrackGroupArray;
/* loaded from: assets/audience_network.dex */
public final class AT {
    public final int A00;
    public final long A01;
    public final long A02;
    public final AbstractC0733Ao A03;
    public final FL A04;
    public final TrackGroupArray A05;
    public final HH A06;
    @Nullable
    public final Object A07;
    public final boolean A08;
    public volatile long A09;
    public volatile long A0A;

    public AT(AbstractC0733Ao abstractC0733Ao, long j2, TrackGroupArray trackGroupArray, HH hh) {
        this(abstractC0733Ao, null, new FL(0), j2, -9223372036854775807L, 1, false, trackGroupArray, hh);
    }

    public AT(AbstractC0733Ao abstractC0733Ao, @Nullable Object obj, FL fl, long j2, long j3, int i2, boolean z, TrackGroupArray trackGroupArray, HH hh) {
        this.A03 = abstractC0733Ao;
        this.A07 = obj;
        this.A04 = fl;
        this.A02 = j2;
        this.A01 = j3;
        this.A0A = j2;
        this.A09 = j2;
        this.A00 = i2;
        this.A08 = z;
        this.A05 = trackGroupArray;
        this.A06 = hh;
    }

    public static void A00(AT at, AT at2) {
        at2.A0A = at.A0A;
        at2.A09 = at.A09;
    }

    public final AT A01(int i2) {
        AT at = new AT(this.A03, this.A07, this.A04.A00(i2), this.A02, this.A01, this.A00, this.A08, this.A05, this.A06);
        A00(this, at);
        return at;
    }

    public final AT A02(int i2) {
        AT at = new AT(this.A03, this.A07, this.A04, this.A02, this.A01, i2, this.A08, this.A05, this.A06);
        A00(this, at);
        return at;
    }

    public final AT A03(AbstractC0733Ao abstractC0733Ao, Object obj) {
        AT at = new AT(abstractC0733Ao, obj, this.A04, this.A02, this.A01, this.A00, this.A08, this.A05, this.A06);
        A00(this, at);
        return at;
    }

    public final AT A04(FL fl, long j2, long j3) {
        long j4 = j3;
        AbstractC0733Ao abstractC0733Ao = this.A03;
        Object obj = this.A07;
        if (!fl.A01()) {
            j4 = -9223372036854775807L;
        }
        return new AT(abstractC0733Ao, obj, fl, j2, j4, this.A00, this.A08, this.A05, this.A06);
    }

    public final AT A05(TrackGroupArray trackGroupArray, HH hh) {
        AT at = new AT(this.A03, this.A07, this.A04, this.A02, this.A01, this.A00, this.A08, trackGroupArray, hh);
        A00(this, at);
        return at;
    }

    public final AT A06(boolean z) {
        AT at = new AT(this.A03, this.A07, this.A04, this.A02, this.A01, this.A00, z, this.A05, this.A06);
        A00(this, at);
        return at;
    }
}
