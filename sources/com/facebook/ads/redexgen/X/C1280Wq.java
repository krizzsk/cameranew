package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Wq  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1280Wq implements IM {
    public static byte[] A04;
    @Nullable
    public InterfaceC1277Wn A00;
    @Nullable
    public IM A01;
    public final A6 A02;
    public final UH A03;

    static {
        A02();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 59);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A04 = new byte[]{95, 103, 126, 102, 123, 98, 126, 119, 50, 96, 119, 124, 118, 119, 96, 119, 96, 50, Byte.MAX_VALUE, 119, 118, 123, 115, 50, 113, 126, 125, 113, 121, 97, 50, 119, 124, 115, 112, 126, 119, 118, 60};
    }

    public C1280Wq(A6 a6, I9 i9) {
        this.A02 = a6;
        this.A03 = new UH(i9);
    }

    private void A01() {
        this.A03.A02(this.A01.A7B());
        AU playbackParameters = this.A01.A78();
        if (!playbackParameters.equals(this.A03.A78())) {
            this.A03.AET(playbackParameters);
            this.A02.ABZ(playbackParameters);
        }
    }

    private boolean A03() {
        InterfaceC1277Wn interfaceC1277Wn = this.A00;
        return (interfaceC1277Wn == null || interfaceC1277Wn.A8J() || (!this.A00.A8U() && this.A00.A7w())) ? false : true;
    }

    public final long A04() {
        if (A03()) {
            A01();
            return this.A01.A7B();
        }
        return this.A03.A7B();
    }

    public final void A05() {
        this.A03.A00();
    }

    public final void A06() {
        this.A03.A01();
    }

    public final void A07(long j2) {
        this.A03.A02(j2);
    }

    public final void A08(InterfaceC1277Wn interfaceC1277Wn) {
        if (interfaceC1277Wn == this.A00) {
            this.A01 = null;
            this.A00 = null;
        }
    }

    public final void A09(InterfaceC1277Wn interfaceC1277Wn) throws A9 {
        IM im;
        IM A6r = interfaceC1277Wn.A6r();
        if (A6r != null && A6r != (im = this.A01)) {
            if (im == null) {
                this.A01 = A6r;
                this.A00 = interfaceC1277Wn;
                this.A01.AET(this.A03.A78());
                A01();
                return;
            }
            throw A9.A02(new IllegalStateException(A00(0, 39, 41)));
        }
    }

    @Override // com.facebook.ads.redexgen.X.IM
    public final AU A78() {
        IM im = this.A01;
        if (im != null) {
            return im.A78();
        }
        return this.A03.A78();
    }

    @Override // com.facebook.ads.redexgen.X.IM
    public final long A7B() {
        if (A03()) {
            return this.A01.A7B();
        }
        return this.A03.A7B();
    }

    @Override // com.facebook.ads.redexgen.X.IM
    public final AU AET(AU au) {
        IM im = this.A01;
        if (im != null) {
            au = im.AET(au);
        }
        this.A03.AET(au);
        this.A02.ABZ(au);
        return au;
    }
}
