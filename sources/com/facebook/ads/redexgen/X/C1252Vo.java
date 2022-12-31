package com.facebook.ads.redexgen.X;

import java.io.IOException;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Vo  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1252Vo implements CP {
    public static byte[] A04;
    public static String[] A05 = {"P5w0t5YmbfCx1ojda5KKDsEMO6jqUmnr", "UdOatSKcJailVD", "", "xAiF", "epl8GGi5jyNsT2QZHjLNLopZqyhNzplR", "TY8pRi4pa4JcG30Kuv61m", "fOMFGQDuqjq2usuY2YJ2oGF", "ObZwfJQfEiVxl"};
    public static final CS A06;
    public static final int A07;
    public boolean A00;
    public final long A01;
    public final C1251Vn A02;
    public final IV A03;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 57);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{15, 2, 117};
    }

    static {
        A01();
        A06 = new C1253Vp();
        A07 = C0923Il.A08(A00(0, 3, 127));
    }

    public C1252Vo() {
        this(0L);
    }

    public C1252Vo(long j2) {
        this.A01 = j2;
        this.A02 = new C1251Vn();
        this.A03 = new IV(2786);
    }

    @Override // com.facebook.ads.redexgen.X.CP
    public final void A8A(CR cr) {
        this.A02.A4T(cr, new C0795Dj(0, 1));
        cr.A5A();
        cr.AEA(new WN(-9223372036854775807L));
    }

    @Override // com.facebook.ads.redexgen.X.CP
    public final int ADD(CQ cq, CW cw) throws IOException, InterruptedException {
        int read = cq.read(this.A03.A00, 0, 2786);
        if (read == -1) {
            return -1;
        }
        this.A03.A0Y(0);
        this.A03.A0X(read);
        if (!this.A00) {
            this.A02.ACm(this.A01, true);
            this.A00 = true;
        }
        this.A02.A46(this.A03);
        return 0;
    }

    @Override // com.facebook.ads.redexgen.X.CP
    public final void AE9(long j2, long j3) {
        this.A00 = false;
        this.A02.AE8();
    }

    @Override // com.facebook.ads.redexgen.X.CP
    public final boolean AEj(CQ cq) throws IOException, InterruptedException {
        IV iv = new IV(10);
        int i2 = 0;
        while (true) {
            cq.ACp(iv.A00, 0, 10);
            if (A05[7].length() != 13) {
                throw new RuntimeException();
            }
            A05[5] = "IuOldmz1qGC5b";
            iv.A0Y(0);
            if (iv.A0G() != A07) {
                cq.ADr();
                cq.A3J(i2);
                int startPosition = i2;
                int i3 = 0;
                while (true) {
                    cq.ACp(iv.A00, 0, 5);
                    iv.A0Y(0);
                    if (iv.A0I() != 2935) {
                        i3 = 0;
                        cq.ADr();
                        startPosition++;
                        if (startPosition - i2 >= 8192) {
                            return false;
                        }
                        cq.A3J(startPosition);
                    } else {
                        i3++;
                        if (A05[5].length() != 29) {
                            String[] strArr = A05;
                            strArr[3] = "a4rI";
                            strArr[6] = "EnE3h5gngskpWhoTVRGnZEO";
                            if (i3 >= 4) {
                                return true;
                            }
                        } else if (i3 >= 4) {
                            return true;
                        }
                        int A052 = C0742Ax.A05(iv.A00);
                        if (A052 == -1) {
                            return false;
                        }
                        int syncBytes = A052 - 5;
                        cq.A3J(syncBytes);
                    }
                }
            } else {
                iv.A0Z(3);
                int A0D = iv.A0D();
                int syncBytes2 = A0D + 10;
                i2 += syncBytes2;
                cq.A3J(A0D);
            }
        }
    }
}
