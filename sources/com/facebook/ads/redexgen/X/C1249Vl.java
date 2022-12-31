package com.facebook.ads.redexgen.X;

import java.io.IOException;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Vl  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1249Vl implements CP {
    public static byte[] A04;
    public static String[] A05 = {"6Yd3MlxO6zs0On0JMF5Pwnois3aNTjpE", "MmQBoaYzrmdPmtEAYQ3R1Y6Mcsh6By7B", "7RUBoC8KCwVWfiCX9SWb", "GS41ND25W7ytYawGpGonJQP9IOOENLXr", "lL4oomLzy5vPLaNFQ0K", "J26", "emQAR3GMgLzBn72fJq6a", "GcSIxJRAUXsHB0u2DOmppTTbOqtsj228"};
    public static final CS A06;
    public static final int A07;
    public boolean A00;
    public final long A01;
    public final Vk A02;
    public final IV A03;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 120);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{27, 22, 97};
    }

    static {
        A01();
        A06 = new C1250Vm();
        A07 = C0923Il.A08(A00(0, 3, 42));
    }

    public C1249Vl() {
        this(0L);
    }

    public C1249Vl(long j2) {
        this.A01 = j2;
        this.A02 = new Vk(true);
        this.A03 = new IV(200);
    }

    @Override // com.facebook.ads.redexgen.X.CP
    public final void A8A(CR cr) {
        this.A02.A4T(cr, new C0795Dj(0, 1));
        cr.A5A();
        cr.AEA(new WN(-9223372036854775807L));
    }

    @Override // com.facebook.ads.redexgen.X.CP
    public final int ADD(CQ cq, CW cw) throws IOException, InterruptedException {
        int read = cq.read(this.A03.A00, 0, 200);
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
        IU iu = new IU(iv.A00);
        int validFramesCount = 0;
        while (true) {
            cq.ACp(iv.A00, 0, 10);
            iv.A0Y(0);
            if (iv.A0G() != A07) {
                break;
            }
            iv.A0Z(3);
            int A0D = iv.A0D();
            int length = A0D + 10;
            validFramesCount += length;
            cq.A3J(A0D);
        }
        cq.ADr();
        cq.A3J(validFramesCount);
        int i2 = validFramesCount;
        int i3 = 0;
        if (A05[4].length() == 20) {
            throw new RuntimeException();
        }
        A05[1] = "mY90xJHLqPMDpFXgmiZe2UkYD68ZyI7P";
        int i4 = 0;
        while (true) {
            cq.ACp(iv.A00, 0, 2);
            iv.A0Y(0);
            int validFramesSize = iv.A0I();
            if ((65526 & validFramesSize) != 65520) {
                i4 = 0;
                i3 = 0;
                cq.ADr();
                i2++;
                if (i2 - validFramesCount >= 8192) {
                    return false;
                }
                cq.A3J(i2);
            } else {
                i4++;
                if (i4 >= 4 && i3 > 188) {
                    return true;
                }
                cq.ACp(iv.A00, 0, 4);
                iu.A07(14);
                int A042 = iu.A04(13);
                if (A042 <= 6) {
                    return false;
                }
                int syncBytes = A042 - 6;
                cq.A3J(syncBytes);
                i3 += A042;
            }
        }
    }
}
