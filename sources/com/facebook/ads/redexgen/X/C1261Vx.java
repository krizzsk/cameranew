package com.facebook.ads.redexgen.X;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Vx  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1261Vx implements DI {
    public static byte[] A0C;
    public static String[] A0D = {"IwWJ1rAHfmexjsebXRXcDPjaU73iSJJD", "Pfa9O7smeRLr", "YVPVKTJSUnoy1mID8h1JiHhyOv", "4YIcZCc9D0v6GYbVW55qq4", "MQGq3Ss0TGTuZcZl9hZWKHAs", "ClxO0wOPMkXGPeTsbkyLqOefUDvePx9Y", "eY8aqVMBTreysgzhCT0m33TuEQRECFok", "4vNP3Dy1WFFR"};
    public int A00;
    public long A01;
    public long A02;
    public long A03;
    public long A04;
    public long A05;
    public long A06;
    public long A07;
    public final long A08;
    public final long A09;
    public final DH A0A = new DH();
    public final DL A0B;

    public static String A09(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0C, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 110);
        }
        return new String(copyOfRange);
    }

    public static void A0A() {
        A0C = new byte[]{38, 7, 72, 7, 15, 15, 72, 24, 9, 15, Draft_75.CR, 72, 11, 9, 6, 72, 10, Draft_75.CR, 72, 14, 7, 29, 6, 12, 70};
    }

    static {
        A0A();
    }

    public C1261Vx(long j2, long j3, DL dl, int i2, long j4) {
        I6.A03(j2 >= 0 && j3 > j2);
        this.A0B = dl;
        this.A09 = j2;
        this.A08 = j3;
        if (i2 == j3 - j2) {
            this.A07 = j4;
            this.A00 = 3;
            return;
        }
        this.A00 = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long A00(long j2, long j3, long j4) {
        long j5 = this.A08;
        long j6 = this.A09;
        long j7 = j2 + ((((j5 - j6) * j3) / this.A07) - j4);
        if (j7 < j6) {
            j7 = this.A09;
        }
        long j8 = this.A08;
        if (j7 >= j8) {
            return j8 - 1;
        }
        return j7;
    }

    private final long A01(long j2, CQ cq) throws IOException, InterruptedException {
        if (this.A04 == this.A01) {
            return -(this.A05 + 2);
        }
        long A79 = cq.A79();
        if (A0D(cq, this.A01)) {
            this.A0A.A03(cq, false);
            cq.ADr();
            long j3 = j2 - this.A0A.A05;
            int i2 = this.A0A.A01 + this.A0A.A00;
            if (j3 >= 0) {
                String[] strArr = A0D;
                if (strArr[5].charAt(24) != strArr[0].charAt(24)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0D;
                strArr2[2] = "1HFKFqyQYawdfec4zhOWKwAEhw";
                strArr2[3] = "atngC4wrhlAL4xDnem6FNv";
                if (j3 <= 72000) {
                    cq.AEh(i2);
                    return -(this.A0A.A05 + 2);
                }
            }
            if (j3 < 0) {
                this.A01 = A79;
                this.A02 = this.A0A.A05;
            } else {
                long initialPosition = cq.A79();
                this.A04 = initialPosition + i2;
                this.A05 = this.A0A.A05;
                long initialPosition2 = this.A01;
                if ((initialPosition2 - this.A04) + i2 < 100000) {
                    cq.AEh(i2);
                    long initialPosition3 = this.A05;
                    return -(initialPosition3 + 2);
                }
            }
            long initialPosition4 = this.A01;
            long j4 = this.A04;
            if (initialPosition4 - j4 < 100000) {
                this.A01 = j4;
                return j4;
            }
            long A792 = cq.A79() - (i2 * (j3 > 0 ? 1L : 2L));
            long j5 = this.A01;
            long j6 = this.A04;
            long j7 = (j5 - j6) * j3;
            String[] strArr3 = A0D;
            String str = strArr3[5];
            String str2 = strArr3[0];
            int pageSize = str.charAt(24);
            if (pageSize != str2.charAt(24)) {
                long initialPosition5 = this.A02;
                return Math.min(Math.max(A792 + (j7 / (initialPosition5 - this.A05)), j6), this.A01 - 1);
            }
            String[] strArr4 = A0D;
            strArr4[1] = "HnyCEdH4by64";
            strArr4[7] = "f67XG71IQfud";
            return Math.min(Math.max(A792 + (j7 / (this.A02 - this.A05)), j6), this.A01 - 1);
        }
        long j8 = this.A04;
        if (j8 != A79) {
            return j8;
        }
        throw new IOException(A09(0, 25, 6));
    }

    private final long A02(CQ cq) throws IOException, InterruptedException {
        A0C(cq);
        this.A0A.A02();
        while ((this.A0A.A04 & 4) != 4 && cq.A79() < this.A08) {
            this.A0A.A03(cq, false);
            cq.AEh(this.A0A.A01 + this.A0A.A00);
        }
        return this.A0A.A05;
    }

    private final long A03(CQ cq, long j2, long j3) throws IOException, InterruptedException {
        this.A0A.A03(cq, false);
        while (this.A0A.A05 < j2) {
            cq.AEh(this.A0A.A01 + this.A0A.A00);
            j3 = this.A0A.A05;
            this.A0A.A03(cq, false);
        }
        cq.ADr();
        return j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.DI
    /* renamed from: A07 */
    public final C1262Vy A4Q() {
        if (this.A07 != 0) {
            return new C1262Vy(this);
        }
        return null;
    }

    private final void A0B() {
        this.A04 = this.A09;
        this.A01 = this.A08;
        this.A05 = 0L;
        this.A02 = this.A07;
    }

    private final void A0C(CQ cq) throws IOException, InterruptedException {
        if (A0D(cq, this.A08)) {
            return;
        }
        throw new EOFException();
    }

    private final boolean A0D(CQ cq, long j2) throws IOException, InterruptedException {
        long min = Math.min(3 + j2, this.A08);
        byte[] bArr = new byte[2048];
        int length = bArr.length;
        while (true) {
            if (cq.A79() + length > min && (length = (int) (min - cq.A79())) < 4) {
                return false;
            }
            cq.ACq(bArr, 0, length, false);
            for (int i2 = 0; i2 < length - 3; i2++) {
                if (bArr[i2] == 79 && bArr[i2 + 1] == 103 && bArr[i2 + 2] == 103 && bArr[i2 + 3] == 83) {
                    cq.AEh(i2);
                    return true;
                }
            }
            cq.AEh(length - 3);
        }
    }

    @Override // com.facebook.ads.redexgen.X.DI
    public final long ADE(CQ cq) throws IOException, InterruptedException {
        long A03;
        int i2 = this.A00;
        if (i2 == 0) {
            this.A03 = cq.A79();
            this.A00 = 1;
            long j2 = this.A08 - 65307;
            if (j2 > this.A03) {
                return j2;
            }
        } else if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    return -1L;
                }
                throw new IllegalStateException();
            }
            long j3 = this.A06;
            if (j3 == 0) {
                A03 = 0;
            } else {
                long A01 = A01(j3, cq);
                if (A01 >= 0) {
                    return A01;
                }
                A03 = A03(cq, this.A06, -(A01 + 2));
            }
            this.A00 = 3;
            return -(2 + A03);
        }
        this.A07 = A02(cq);
        this.A00 = 3;
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.X.DI
    public final long AEp(long j2) {
        int i2 = this.A00;
        I6.A03(i2 == 3 || i2 == 2);
        long j3 = 0;
        if (j2 != 0) {
            j3 = this.A0B.A04(j2);
        }
        this.A06 = j3;
        this.A00 = 2;
        A0B();
        long j4 = this.A06;
        String[] strArr = A0D;
        if (strArr[5].charAt(24) != strArr[0].charAt(24)) {
            throw new RuntimeException();
        }
        A0D[6] = "l4iEtEKEuRK6wb9mepvhy";
        return j4;
    }
}
