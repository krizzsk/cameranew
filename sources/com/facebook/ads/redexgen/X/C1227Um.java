package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.source.TrackGroup;
/* renamed from: com.facebook.ads.redexgen.X.Um  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1227Um implements HC {
    public final float A00;
    public final float A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final long A05;
    public final HM A06;
    public final I9 A07;

    public C1227Um(HM hm) {
        this(hm, 10000, 25000, 25000, 0.75f, 0.75f, 2000L, I9.A00);
    }

    public C1227Um(HM hm, int i2, int i3, int i4, float f2, float f3, long j2, I9 i9) {
        this.A06 = hm;
        this.A03 = i2;
        this.A02 = i3;
        this.A04 = i4;
        this.A00 = f2;
        this.A01 = f3;
        this.A05 = j2;
        this.A07 = i9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.HC
    /* renamed from: A00 */
    public final BN A4S(TrackGroup trackGroup, int... iArr) {
        return new BN(trackGroup, iArr, this.A06, this.A03, this.A02, this.A04, this.A00, this.A01, this.A05, this.A07);
    }
}
