package com.facebook.ads.redexgen.X;

import androidx.recyclerview.widget.ItemTouchHelper;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class WI implements CP {
    public static byte[] A0F;
    public static String[] A0G = {"F9KwQMNMxiTjkayDhPM6gvDLkPvUNcLn", "Em4FZTw9NeUBCVsnasMEsqdbQrmSbGq", "", "tDq5h6G1X4d5RY1LfaFLZXWqT85DrCya", "B5R7X", "Y", "Zp00UWtElOmikRSXEs37FpNUTZ5eWL9Y", "wqRNyyxlEoRi9"};
    public static final CS A0H;
    public static final int A0I;
    public int A00;
    public int A02;
    public int A03;
    public long A05;
    public CR A06;
    public WK A07;
    public WF A08;
    public boolean A09;
    public final IV A0C = new IV(4);
    public final IV A0B = new IV(9);
    public final IV A0E = new IV(11);
    public final IV A0D = new IV();
    public final WH A0A = new WH();
    public int A01 = 1;
    public long A04 = -9223372036854775807L;

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0F, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 60);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A0F = new byte[]{-117, -111, -101};
    }

    static {
        A03();
        A0H = new WJ();
        A0I = C0923Il.A08(A01(0, 3, 9));
    }

    private IV A00(CQ cq) throws IOException, InterruptedException {
        if (this.A02 > this.A0D.A05()) {
            IV iv = this.A0D;
            iv.A0b(new byte[Math.max(iv.A05() * 2, this.A02)], 0);
        } else {
            this.A0D.A0Y(0);
        }
        this.A0D.A0X(this.A02);
        cq.readFully(this.A0D.A00, 0, this.A02);
        return this.A0D;
    }

    private void A02() {
        if (!this.A09) {
            this.A06.AEA(new WN(-9223372036854775807L));
            this.A09 = true;
        }
        if (this.A04 != -9223372036854775807L) {
            return;
        }
        this.A04 = this.A0A.A0D() == -9223372036854775807L ? -this.A05 : 0L;
    }

    private void A04(CQ cq) throws IOException, InterruptedException {
        cq.AEh(this.A00);
        this.A00 = 0;
        this.A01 = 3;
    }

    private boolean A05(CQ cq) throws IOException, InterruptedException {
        if (cq.ADI(this.A0B.A00, 0, 9, true)) {
            IV iv = this.A0B;
            if (A0G[4].length() != 15) {
                String[] strArr = A0G;
                strArr[3] = "xxv79KM5VyarLmUhQqEOMlbbyGFtPWOG";
                strArr[6] = "n0W8PrJEyrqWl4lCbLWkK9bcjvpbO2Fn";
                iv.A0Y(0);
                this.A0B.A0Z(4);
                int A0E = this.A0B.A0E();
                boolean z = (A0E & 4) != 0;
                boolean hasAudio = (A0E & 1) != 0;
                if (z && this.A07 == null) {
                    this.A07 = new WK(this.A06.AF1(8, 1));
                }
                if (hasAudio && this.A08 == null) {
                    this.A08 = new WF(this.A06.AF1(9, 2));
                }
                this.A06.A5A();
                this.A00 = (this.A0B.A08() - 9) + 4;
                this.A01 = 2;
                return true;
            }
            throw new RuntimeException();
        }
        return false;
    }

    private boolean A06(CQ cq) throws IOException, InterruptedException {
        boolean z = true;
        if (this.A03 == 8 && this.A07 != null) {
            A02();
            this.A07.A00(A00(cq), this.A04 + this.A05);
        } else if (this.A03 == 9 && this.A08 != null) {
            A02();
            this.A08.A00(A00(cq), this.A04 + this.A05);
        } else if (this.A03 == 18 && !this.A09) {
            this.A0A.A00(A00(cq), this.A05);
            long A0D = this.A0A.A0D();
            if (A0D != -9223372036854775807L) {
                this.A06.AEA(new WN(A0D));
                this.A09 = true;
            }
        } else {
            int i2 = this.A02;
            if (A0G[4].length() == 15) {
                throw new RuntimeException();
            }
            A0G[0] = "mShHrd4Vu2jNkvRJUK8UrhhXjzgbGKl1";
            cq.AEh(i2);
            z = false;
        }
        this.A00 = 4;
        this.A01 = 2;
        return z;
    }

    private boolean A07(CQ cq) throws IOException, InterruptedException {
        if (cq.ADI(this.A0E.A00, 0, 11, true)) {
            this.A0E.A0Y(0);
            this.A03 = this.A0E.A0E();
            this.A02 = this.A0E.A0G();
            this.A05 = this.A0E.A0G();
            this.A05 = ((this.A0E.A0E() << 24) | this.A05) * 1000;
            this.A0E.A0Z(3);
            this.A01 = 4;
            return true;
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.CP
    public final void A8A(CR cr) {
        this.A06 = cr;
    }

    @Override // com.facebook.ads.redexgen.X.CP
    public final int ADD(CQ cq, CW cw) throws IOException, InterruptedException {
        while (true) {
            int i2 = this.A01;
            if (i2 != 1) {
                if (i2 == 2) {
                    A04(cq);
                } else if (A0G[4].length() == 15) {
                    throw new RuntimeException();
                } else {
                    A0G[4] = "ncW0XwKX3pgCRaaT";
                    if (i2 != 3) {
                        if (i2 == 4) {
                            if (A06(cq)) {
                                if (A0G[0].charAt(18) != 'j') {
                                    A0G[7] = "5";
                                    return 0;
                                }
                                A0G[7] = "DR5iBP2XCUKx659t";
                                return 0;
                            }
                        } else {
                            throw new IllegalStateException();
                        }
                    } else if (!A07(cq)) {
                        return -1;
                    }
                }
            } else if (!A05(cq)) {
                return -1;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.CP
    public final void AE9(long j2, long j3) {
        this.A01 = 1;
        this.A04 = -9223372036854775807L;
        this.A00 = 0;
    }

    @Override // com.facebook.ads.redexgen.X.CP
    public final boolean AEj(CQ cq) throws IOException, InterruptedException {
        cq.ACp(this.A0C.A00, 0, 3);
        this.A0C.A0Y(0);
        if (this.A0C.A0G() != A0I) {
            return false;
        }
        cq.ACp(this.A0C.A00, 0, 2);
        this.A0C.A0Y(0);
        if ((this.A0C.A0I() & ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION) != 0) {
            return false;
        }
        cq.ACp(this.A0C.A00, 0, 4);
        this.A0C.A0Y(0);
        int A08 = this.A0C.A08();
        cq.ADr();
        cq.A3J(A08);
        cq.ACp(this.A0C.A00, 0, 4);
        this.A0C.A0Y(0);
        return this.A0C.A08() == 0;
    }
}
