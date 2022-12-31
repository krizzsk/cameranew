package com.facebook.ads.redexgen.X;

import android.util.Pair;
import androidx.annotation.Nullable;
/* loaded from: assets/audience_network.dex */
public final class AR {
    public static String[] A0C = {"L0u3smBC6U6OaYtXppAd31iOC3v5Qhxz", "mD", "DMmTpdJrujAgbmCwwmXMokmpSOB8XVVu", "Fa0SCWKpXCwAFqaC3HE", "LFAAfAeIJjtENyizMXbJJCIXxkMYQ2BS", "EOXOixXcPNGoqbhwUMphXmxbz6TL9K", "ydRMenJrqCbsHYuDZ17G4nGASKkEf2si", "4zZeHgY0eMzISLpxtPc37pmrQXWGSxn"};
    public int A00;
    public int A01;
    public long A02;
    public long A03;
    public AP A04;
    public AP A05;
    public AP A06;
    public AbstractC0733Ao A07;
    public Object A08;
    public boolean A09;
    public final C0731Am A0A = new C0731Am();
    public final C0732An A0B = new C0732An();

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private AQ A02(int i2, long j2, long j3) {
        FL fl = new FL(i2, j3);
        this.A07.A09(fl.A02, this.A0A);
        int A04 = this.A0A.A04(j2);
        long A09 = A04 == -1 ? Long.MIN_VALUE : this.A0A.A09(A04);
        boolean A0A = A0A(fl, A09);
        return new AQ(fl, j2, A09, -9223372036854775807L, A09 == Long.MIN_VALUE ? this.A0A.A07() : A09, A0A, A0B(fl, A0A));
    }

    private long A00(int i2) {
        int oldFrontPeriodIndex;
        Object obj = this.A07.A0A(i2, this.A0A, true).A03;
        int i3 = this.A0A.A00;
        Object obj2 = this.A08;
        if (obj2 != null && (oldFrontPeriodIndex = this.A07.A04(obj2)) != -1) {
            int oldFrontWindowIndex = this.A07.A09(oldFrontPeriodIndex, this.A0A).A00;
            if (oldFrontWindowIndex == i3) {
                return this.A03;
            }
        }
        for (AP A0E = A0E(); A0E != null; A0E = A0E.A01) {
            if (A0E.A09.equals(obj)) {
                return A0E.A02.A04.A03;
            }
        }
        for (AP A0E2 = A0E(); A0E2 != null; A0E2 = A0E2.A01) {
            int A04 = this.A07.A04(A0E2.A09);
            if (A04 != -1) {
                int holderWindowIndex = this.A07.A09(A04, this.A0A).A00;
                if (holderWindowIndex == i3) {
                    return A0E2.A02.A04.A03;
                }
            }
        }
        long j2 = this.A02;
        this.A02 = 1 + j2;
        return j2;
    }

    private AQ A01(int i2, int i3, int i4, long durationUs, long j2) {
        long j3;
        FL fl = new FL(i2, i3, i4, j2);
        boolean A0A = A0A(fl, Long.MIN_VALUE);
        boolean A0B = A0B(fl, A0A);
        long A0A2 = this.A07.A09(fl.A02, this.A0A).A0A(fl.A00, fl.A01);
        if (i4 == this.A0A.A02(i3)) {
            j3 = this.A0A.A06();
        } else {
            j3 = 0;
        }
        return new AQ(fl, j3, Long.MIN_VALUE, durationUs, A0A2, A0A, A0B);
    }

    @Nullable
    private AQ A03(AP ap, long j2) {
        long j3;
        AQ aq = ap.A02;
        if (aq.A06) {
            int A03 = this.A07.A03(aq.A04.A02, this.A0A, this.A0B, this.A01, this.A09);
            if (A03 == -1) {
                return null;
            }
            int i2 = this.A07.A0A(A03, this.A0A, true).A00;
            Object obj = this.A0A.A03;
            long j4 = aq.A04.A03;
            if (this.A07.A0B(i2, this.A0B).A00 == A03) {
                long windowSequenceNumber = ap.A07();
                Pair<Integer, Long> A08 = this.A07.A08(this.A0B, this.A0A, i2, -9223372036854775807L, Math.max(0L, (windowSequenceNumber + aq.A01) - j2));
                if (A08 == null) {
                    return null;
                }
                Object nextPeriodUid = A08.first;
                A03 = ((Integer) nextPeriodUid).intValue();
                Object nextPeriodUid2 = A08.second;
                j3 = ((Long) nextPeriodUid2).longValue();
                Object nextPeriodUid3 = ap.A01;
                if (nextPeriodUid3 != null && ap.A01.A09.equals(obj)) {
                    j4 = ap.A01.A02.A04.A03;
                } else {
                    j4 = this.A02;
                    long startPositionUs = j4 + 1;
                    this.A02 = startPositionUs;
                }
            } else {
                j3 = 0;
            }
            return A06(A07(A03, j3, j4), j3, j3);
        }
        FL currentPeriodId = aq.A04;
        this.A07.A09(currentPeriodId.A02, this.A0A);
        if (currentPeriodId.A01()) {
            int adGroupIndex = currentPeriodId.A00;
            int A01 = this.A0A.A01(adGroupIndex);
            if (A01 == -1) {
                return null;
            }
            int adCountInCurrentAdGroup = this.A0A.A03(adGroupIndex, currentPeriodId.A01);
            if (adCountInCurrentAdGroup < A01) {
                if (!this.A0A.A0E(adGroupIndex, adCountInCurrentAdGroup)) {
                    return null;
                }
                return A01(currentPeriodId.A02, adGroupIndex, adCountInCurrentAdGroup, aq.A00, currentPeriodId.A03);
            }
            return A02(currentPeriodId.A02, aq.A00, currentPeriodId.A03);
        }
        long j5 = aq.A02;
        if (A0C[6].charAt(23) != 'A') {
            throw new RuntimeException();
        }
        A0C[1] = "6G";
        if (j5 != Long.MIN_VALUE) {
            int A05 = this.A0A.A05(aq.A02);
            if (A05 == -1) {
                return A02(currentPeriodId.A02, aq.A02, currentPeriodId.A03);
            }
            int A02 = this.A0A.A02(A05);
            if (!this.A0A.A0E(A05, A02)) {
                return null;
            }
            return A01(currentPeriodId.A02, A05, A02, aq.A02, currentPeriodId.A03);
        }
        int A00 = this.A0A.A00();
        if (A00 == 0) {
            return null;
        }
        int i3 = A00 - 1;
        if (this.A0A.A09(i3) != Long.MIN_VALUE || this.A0A.A0D(i3)) {
            return null;
        }
        int adGroupCount = this.A0A.A02(i3);
        if (!this.A0A.A0E(i3, adGroupCount)) {
            return null;
        }
        long A07 = this.A0A.A07();
        int i4 = currentPeriodId.A02;
        long contentDurationUs = currentPeriodId.A03;
        return A01(i4, i3, adGroupCount, A07, contentDurationUs);
    }

    private AQ A04(AQ aq, FL fl) {
        long A07;
        long j2 = aq.A03;
        long endPositionUs = aq.A02;
        boolean A0A = A0A(fl, endPositionUs);
        boolean A0B = A0B(fl, A0A);
        this.A07.A09(fl.A02, this.A0A);
        boolean isLastInPeriod = fl.A01();
        if (isLastInPeriod) {
            A07 = this.A0A.A0A(fl.A00, fl.A01);
        } else if (A0C[2].charAt(30) != 'V') {
            throw new RuntimeException();
        } else {
            A0C[2] = "zTzAUiYM1BrQqeObFTyCKDEgqKKR2HVC";
            A07 = endPositionUs == Long.MIN_VALUE ? this.A0A.A07() : endPositionUs;
        }
        return new AQ(fl, j2, endPositionUs, aq.A00, A07, A0A, A0B);
    }

    private AQ A05(AT at) {
        return A06(at.A04, at.A01, at.A02);
    }

    private AQ A06(FL fl, long j2, long j3) {
        this.A07.A09(fl.A02, this.A0A);
        if (fl.A01()) {
            if (!this.A0A.A0E(fl.A00, fl.A01)) {
                return null;
            }
            return A01(fl.A02, fl.A00, fl.A01, j2, fl.A03);
        }
        return A02(fl.A02, j3, fl.A03);
    }

    private FL A07(int i2, long j2, long j3) {
        this.A07.A09(i2, this.A0A);
        int A05 = this.A0A.A05(j2);
        if (A05 == -1) {
            return new FL(i2, j3);
        }
        return new FL(i2, A05, this.A0A.A02(A05), j3);
    }

    private boolean A08() {
        AP A0E = A0E();
        if (A0E == null) {
            return true;
        }
        while (true) {
            int A03 = this.A07.A03(A0E.A02.A04.A02, this.A0A, this.A0B, this.A01, this.A09);
            while (A0E.A01 != null && !A0E.A02.A06) {
                A0E = A0E.A01;
            }
            if (A03 == -1 || A0E.A01 == null || A0E.A01.A02.A04.A02 != A03) {
                break;
            }
            A0E = A0E.A01;
        }
        boolean A0S = A0S(A0E);
        A0E.A02 = A04(A0E.A02, A0E.A02.A04);
        if (A0S) {
            boolean A0P = A0P();
            if (A0C[7].length() != 31) {
                throw new RuntimeException();
            }
            String[] strArr = A0C;
            strArr[3] = "GuDKwHudSgXHMcEdzJg";
            strArr[5] = "TrxgVcYEVqGsLQMDNrMk5TDxlvQhmk";
            return !A0P;
        }
        return true;
    }

    private boolean A09(AP ap, AQ aq) {
        AQ aq2 = ap.A02;
        return aq2.A03 == aq.A03 && aq2.A02 == aq.A02 && aq2.A04.equals(aq.A04);
    }

    private boolean A0A(FL fl, long j2) {
        int A00 = this.A07.A09(fl.A02, this.A0A).A00();
        if (A00 == 0) {
            return true;
        }
        int i2 = A00 - 1;
        boolean A01 = fl.A01();
        if (this.A0A.A09(i2) != Long.MIN_VALUE) {
            return !A01 && j2 == Long.MIN_VALUE;
        }
        int postrollAdCount = this.A0A.A01(i2);
        if (postrollAdCount == -1) {
            return false;
        }
        if (A01 && fl.A00 == i2 && fl.A01 == postrollAdCount + (-1)) {
            return true;
        }
        return !A01 && this.A0A.A02(i2) == postrollAdCount;
    }

    private boolean A0B(FL fl, boolean z) {
        return !this.A07.A0B(this.A07.A09(fl.A02, this.A0A).A00, this.A0B).A08 && this.A07.A0F(fl.A02, this.A0A, this.A0B, this.A01, this.A09) && z;
    }

    public final AP A0C() {
        AP ap = this.A05;
        if (ap != null) {
            if (ap == this.A06) {
                this.A06 = ap.A01;
            }
            this.A05.A0D();
            this.A00--;
            if (this.A00 == 0) {
                this.A04 = null;
                this.A08 = this.A05.A09;
                this.A03 = this.A05.A02.A04.A03;
            }
            this.A05 = this.A05.A01;
        } else {
            AP ap2 = this.A04;
            this.A05 = ap2;
            this.A06 = ap2;
        }
        return this.A05;
    }

    public final AP A0D() {
        AP ap = this.A06;
        I6.A04((ap == null || ap.A01 == null) ? false : true);
        if (A0C[7].length() != 31) {
            throw new RuntimeException();
        }
        String[] strArr = A0C;
        strArr[4] = "7koWfuH1ta1EVLUWQFGgmnLKJoN2uwxl";
        strArr[0] = "1LlHzPavDhI1SmiN1gPMgWkfsuEkohyV";
        this.A06 = this.A06.A01;
        return this.A06;
    }

    public final AP A0E() {
        return A0P() ? this.A05 : this.A04;
    }

    public final AP A0F() {
        return this.A04;
    }

    public final AP A0G() {
        return this.A05;
    }

    public final AP A0H() {
        return this.A06;
    }

    @Nullable
    public final AQ A0I(long j2, AT at) {
        AP ap = this.A04;
        if (ap == null) {
            return A05(at);
        }
        return A03(ap, j2);
    }

    public final AQ A0J(AQ aq, int i2) {
        return A04(aq, aq.A04.A00(i2));
    }

    public final V3 A0K(InterfaceC0727Ah[] interfaceC0727AhArr, HG hg, HJ hj, FN fn, Object obj, AQ aq) {
        long A07;
        AP ap = this.A04;
        if (ap != null) {
            A07 = ap.A07() + this.A04.A02.A01;
        } else {
            A07 = aq.A03;
        }
        AP ap2 = new AP(interfaceC0727AhArr, A07, hg, hj, fn, obj, aq);
        if (this.A04 != null) {
            I6.A04(A0P());
            this.A04.A01 = ap2;
        }
        this.A08 = null;
        this.A04 = ap2;
        this.A00++;
        return ap2.A08;
    }

    public final FL A0L(int i2, long j2) {
        return A07(i2, j2, A00(i2));
    }

    public final void A0M(long j2) {
        AP ap = this.A04;
        if (ap != null) {
            ap.A0G(j2);
        }
    }

    public final void A0N(AbstractC0733Ao abstractC0733Ao) {
        this.A07 = abstractC0733Ao;
    }

    public final void A0O(boolean z) {
        AP A0E = A0E();
        if (A0E != null) {
            this.A08 = z ? A0E.A09 : null;
            this.A03 = A0E.A02.A04.A03;
            A0E.A0D();
            A0S(A0E);
        } else if (!z) {
            this.A08 = null;
        }
        this.A05 = null;
        this.A04 = null;
        this.A06 = null;
        this.A00 = 0;
    }

    public final boolean A0P() {
        return this.A05 != null;
    }

    public final boolean A0Q() {
        AP ap = this.A04;
        return ap == null || (!ap.A02.A05 && this.A04.A0H() && this.A04.A02.A01 != -9223372036854775807L && this.A00 < 100);
    }

    public final boolean A0R(int i2) {
        this.A01 = i2;
        return A08();
    }

    public final boolean A0S(AP ap) {
        I6.A04(ap != null);
        boolean z = false;
        this.A04 = ap;
        while (ap.A01 != null) {
            ap = ap.A01;
            if (ap == this.A06) {
                this.A06 = this.A05;
                z = true;
            }
            ap.A0D();
            this.A00--;
        }
        this.A04.A01 = null;
        return z;
    }

    public final boolean A0T(V3 v3) {
        AP ap = this.A04;
        return ap != null && ap.A08 == v3;
    }

    public final boolean A0U(FL fl, long j2) {
        int i2 = fl.A02;
        AP ap = null;
        for (AP A0E = A0E(); A0E != null; A0E = A0E.A01) {
            if (ap == null) {
                A0E.A02 = A0J(A0E.A02, i2);
            } else {
                if (i2 != -1) {
                    Object obj = A0E.A09;
                    if (A0C[2].charAt(30) != 'V') {
                        throw new RuntimeException();
                    }
                    String[] strArr = A0C;
                    strArr[4] = "cRCq0i1JCmFgPvSHr0NI30IAvGtOkPUO";
                    strArr[0] = "aqPjT6JpLbsnsfh6iIpVbm4IivKwupA2";
                    if (obj.equals(this.A07.A0A(i2, this.A0A, true).A03)) {
                        AQ A03 = A03(ap, j2);
                        if (A03 == null) {
                            return true ^ A0S(ap);
                        }
                        A0E.A02 = A0J(A0E.A02, i2);
                        if (!A09(A0E, A03)) {
                            return true ^ A0S(ap);
                        }
                    }
                }
                return true ^ A0S(ap);
            }
            if (A0E.A02.A06) {
                i2 = this.A07.A03(i2, this.A0A, this.A0B, this.A01, this.A09);
            }
            ap = A0E;
        }
        return true;
    }

    public final boolean A0V(boolean z) {
        this.A09 = z;
        return A08();
    }
}
