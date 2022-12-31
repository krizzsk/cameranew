package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.drm.DrmInitData;
/* loaded from: assets/audience_network.dex */
public final class D2 {
    public static String[] A0A = {"3clh", "In2mDQuCVOg3ihkf16hWdIIfuM6sFv5F", "x02l2Vae1akitXdZsfkSin5rPssADgyF", "voDg", "hUzVtg6QDcg3AayaGyy4Y5hfj2RvIx7z", "AYA0HHhZRav1tOhmR967ChnIf", "RG8", "bQ6q4wCv1qa3psjbWrVNO9D1ADq5zdw2"};
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public C0782Cw A04;
    public DB A05;
    public final InterfaceC0771Cb A06;
    public final DD A07 = new DD();
    public final IV A09 = new IV(1);
    public final IV A08 = new IV();

    public D2(InterfaceC0771Cb interfaceC0771Cb) {
        this.A06 = interfaceC0771Cb;
    }

    private DC A00() {
        int i2 = this.A07.A07.A02;
        if (this.A07.A08 != null) {
            DD dd = this.A07;
            String[] strArr = A0A;
            if (strArr[1].charAt(10) != strArr[4].charAt(10)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0A;
            strArr2[1] = "mhitCTNVD2gTcCiZ9jaRAXWaAA0g9dMw";
            strArr2[4] = "MwiogHOaq0gqmibDd9x4nD1rPGRVV4il";
            return dd.A08;
        }
        return this.A05.A00(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A01() {
        if (!this.A07.A0A) {
            return;
        }
        IV iv = this.A07.A09;
        DC A00 = A00();
        if (A00.A00 != 0) {
            iv.A0Z(A00.A00);
        }
        if (this.A07.A0H[this.A01]) {
            iv.A0Z(iv.A0I() * 6);
        }
    }

    public final int A03() {
        IV iv;
        int length;
        if (this.A07.A0A) {
            DC A00 = A00();
            if (A00.A00 != 0) {
                iv = this.A07.A09;
                length = A00.A00;
            } else {
                byte[] bArr = A00.A04;
                String[] strArr = A0A;
                if (strArr[3].length() != strArr[0].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0A;
                strArr2[1] = "Pfb0S5CneQgYrjeMjOJgtR7T7eyOdr1R";
                strArr2[4] = "zLY8KEVp0MgNhcadjz3HGMWIKnjSbq4p";
                this.A08.A0b(bArr, bArr.length);
                iv = this.A08;
                length = bArr.length;
            }
            boolean[] zArr = this.A07.A0H;
            int vectorSize = this.A01;
            boolean z = zArr[vectorSize];
            byte[] bArr2 = this.A09.A00;
            int vectorSize2 = z ? 128 : 0;
            bArr2[0] = (byte) (vectorSize2 | length);
            this.A09.A0Y(0);
            this.A06.AE4(this.A09, 1);
            this.A06.AE4(iv, length);
            if (!z) {
                int vectorSize3 = length + 1;
                return vectorSize3;
            }
            IV iv2 = this.A07.A09;
            int A0I = iv2.A0I();
            iv2.A0Z(-2);
            int subsampleCount = A0I * 6;
            int i2 = subsampleCount + 2;
            this.A06.AE4(iv2, i2);
            int subsampleDataLength = length + 1;
            return subsampleDataLength + i2;
        }
        return 0;
    }

    public final void A04() {
        this.A07.A01();
        this.A01 = 0;
        this.A02 = 0;
        this.A00 = 0;
        this.A03 = 0;
    }

    public final void A05(long j2) {
        long A01 = A3.A01(j2);
        for (int i2 = this.A01; i2 < this.A07.A00 && this.A07.A00(i2) < A01; i2++) {
            boolean[] zArr = this.A07.A0I;
            String[] strArr = A0A;
            if (strArr[3].length() != strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0A;
            strArr2[1] = "yYyJ6pNJ0kgjmttu9OhrBT2GfQD0mn7b";
            strArr2[4] = "spdSEizAECgh3deYwyaUKu4kY7nul1tj";
            if (zArr[i2]) {
                this.A03 = i2;
            }
        }
    }

    public final void A06(DrmInitData drmInitData) {
        DC A00 = this.A05.A00(this.A07.A07.A02);
        this.A06.A5S(this.A05.A07.A0I(drmInitData.A02(A00 != null ? A00.A02 : null)));
    }

    public final void A07(DB db, C0782Cw c0782Cw) {
        this.A05 = (DB) I6.A01(db);
        this.A04 = (C0782Cw) I6.A01(c0782Cw);
        this.A06.A5S(db.A07);
        A04();
    }

    public final boolean A08() {
        this.A01++;
        this.A00++;
        int i2 = this.A00;
        int[] iArr = this.A07.A0E;
        int i3 = this.A02;
        if (i2 == iArr[i3]) {
            this.A02 = i3 + 1;
            String[] strArr = A0A;
            if (strArr[2].charAt(8) != strArr[7].charAt(8)) {
                throw new RuntimeException();
            }
            A0A[6] = "24SILmm";
            this.A00 = 0;
            return false;
        }
        return true;
    }
}
