package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.4m  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C05864m {
    public static byte[] A02;
    public static String[] A03 = {"WXpxlTya5H7kpLIT7UUfzIgXOYds4Vfk", "JVDNa5tAOP", "C1CZfaM4quGDjTOWU4x6KBGTC5pPu33J", "VymAVHyd", "K8p7KG0zsDoAf7GmBTiUCUpdPzk9iS4o", "MydLOSuorekD0WEADrXIrTB2aFx1Ufvf", "1zIVUT6Fxq52O6VZbnoN9TsXnO1jN3fj", "z9Q03TMU5lxkReREt3I6AE4mCa6N3G46"};
    @VisibleForTesting
    public final C1486bx<AbstractC05784e, C05844k> A00 = new C1486bx<>();
    @VisibleForTesting
    public final C2Q<AbstractC05784e> A01 = new C2Q<>();

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 71);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{-99, -59, -61, -60, 112, -64, -62, -65, -58, -71, -76, -75, 112, -74, -68, -79, -73, 112, -96, -94, -107, 112, -65, -62, 112, -96, -97, -93, -92};
    }

    static {
        A02();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0041, code lost:
        if (r5 != 0) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0043, code lost:
        r3.A00 &= r9 ^ (-1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x004b, code lost:
        if (r9 != 4) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004d, code lost:
        r5 = r3.A02;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x004f, code lost:
        r6 = r3.A00;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005e, code lost:
        if (com.facebook.ads.redexgen.X.C05864m.A03[5].charAt(20) == 'R') goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0060, code lost:
        r2 = com.facebook.ads.redexgen.X.C05864m.A03;
        r2[0] = "LDlhycQGZBtlD6IMRSONBH11SqKxQWfy";
        r2[6] = "DCgYh9gvbnrpKHe96mnmPCff01xTtOfJ";
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x006e, code lost:
        if ((r6 & 12) != 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0070, code lost:
        r7.A00.A0A(r4);
        com.facebook.ads.redexgen.X.C05844k.A02(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0078, code lost:
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0079, code lost:
        r2 = com.facebook.ads.redexgen.X.C05864m.A03;
        r2[7] = "9mfdPnfY5V3FVy8Q2gQ6uDsmmOIXndsz";
        r2[2] = "ekMjHGebRREBiMI4gT56rHDvbCCByAvd";
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0087, code lost:
        if ((r6 & 12) != 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x008a, code lost:
        r2 = com.facebook.ads.redexgen.X.C05864m.A03;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x009e, code lost:
        if (r2[7].charAt(19) == r2[2].charAt(19)) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a5, code lost:
        throw new java.lang.RuntimeException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a6, code lost:
        r2 = com.facebook.ads.redexgen.X.C05864m.A03;
        r2[1] = "AZoo0ocwP6";
        r2[3] = "Mxzo3dXJ";
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00b2, code lost:
        if (r9 != 8) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00b4, code lost:
        r5 = r3.A01;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00c3, code lost:
        if (r5 != 0) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00d5, code lost:
        throw new java.lang.IllegalArgumentException(A01(0, 29, 9));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.facebook.ads.redexgen.X.C4H A00(com.facebook.ads.redexgen.X.AbstractC05784e r8, int r9) {
        /*
            Method dump skipped, instructions count: 221
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C05864m.A00(com.facebook.ads.redexgen.X.4e, int):com.facebook.ads.redexgen.X.4H");
    }

    @Nullable
    public final C4H A03(AbstractC05784e abstractC05784e) {
        return A00(abstractC05784e, 8);
    }

    @Nullable
    public final C4H A04(AbstractC05784e abstractC05784e) {
        return A00(abstractC05784e, 4);
    }

    public final AbstractC05784e A05(long j2) {
        return this.A01.A08(j2);
    }

    public final void A06() {
        this.A00.clear();
        this.A01.A09();
    }

    public final void A07() {
        C05844k.A01();
    }

    public final void A08(long j2, AbstractC05784e abstractC05784e) {
        this.A01.A0B(j2, abstractC05784e);
    }

    public final void A09(AbstractC05784e abstractC05784e) {
        C05844k c05844k = this.A00.get(abstractC05784e);
        if (c05844k == null) {
            c05844k = C05844k.A00();
            this.A00.put(abstractC05784e, c05844k);
        }
        c05844k.A00 |= 1;
    }

    public final void A0A(AbstractC05784e abstractC05784e) {
        C05844k c05844k = this.A00.get(abstractC05784e);
        if (c05844k == null) {
            return;
        }
        c05844k.A00 &= -2;
    }

    public final void A0B(AbstractC05784e abstractC05784e) {
        int A06 = this.A01.A06() - 1;
        while (true) {
            if (A06 < 0) {
                break;
            } else if (abstractC05784e == this.A01.A07(A06)) {
                this.A01.A0A(A06);
                break;
            } else {
                A06--;
            }
        }
        C05844k remove = this.A00.remove(abstractC05784e);
        if (remove != null) {
            C05844k.A02(remove);
        }
    }

    public final void A0C(AbstractC05784e abstractC05784e) {
        A0A(abstractC05784e);
    }

    public final void A0D(AbstractC05784e abstractC05784e, C4H c4h) {
        C05844k c05844k = this.A00.get(abstractC05784e);
        if (c05844k == null) {
            c05844k = C05844k.A00();
            this.A00.put(abstractC05784e, c05844k);
        }
        c05844k.A00 |= 2;
        c05844k.A02 = c4h;
    }

    public final void A0E(AbstractC05784e abstractC05784e, C4H c4h) {
        C05844k c05844k = this.A00.get(abstractC05784e);
        if (c05844k == null) {
            c05844k = C05844k.A00();
            this.A00.put(abstractC05784e, c05844k);
        }
        c05844k.A01 = c4h;
        c05844k.A00 |= 8;
    }

    public final void A0F(AbstractC05784e abstractC05784e, C4H c4h) {
        C05844k c05844k = this.A00.get(abstractC05784e);
        if (c05844k == null) {
            c05844k = C05844k.A00();
            this.A00.put(abstractC05784e, c05844k);
        }
        c05844k.A02 = c4h;
        c05844k.A00 |= 4;
    }

    public final void A0G(InterfaceC05854l interfaceC05854l) {
        for (int size = this.A00.size() - 1; size >= 0; size--) {
            AbstractC05784e A09 = this.A00.A09(size);
            C05844k A0A = this.A00.A0A(size);
            if ((A0A.A00 & 3) == 3) {
                interfaceC05854l.AF7(A09);
            } else if ((A0A.A00 & 1) != 0) {
                if (A0A.A02 == null) {
                    interfaceC05854l.AF7(A09);
                } else {
                    C4H c4h = A0A.A02;
                    C4H c4h2 = A0A.A01;
                    if (A03[5].charAt(20) == 'R') {
                        throw new RuntimeException();
                    }
                    String[] strArr = A03;
                    strArr[1] = "fJVAe19tdP";
                    strArr[3] = "3fJsXDGb";
                    interfaceC05854l.AD5(A09, c4h, c4h2);
                }
            } else if ((A0A.A00 & 14) == 14) {
                interfaceC05854l.AD3(A09, A0A.A02, A0A.A01);
            } else if ((A0A.A00 & 12) == 12) {
                interfaceC05854l.AD7(A09, A0A.A02, A0A.A01);
            } else if ((A0A.A00 & 4) != 0) {
                interfaceC05854l.AD5(A09, A0A.A02, null);
            } else if ((A0A.A00 & 8) != 0) {
                interfaceC05854l.AD3(A09, A0A.A02, A0A.A01);
            }
            C05844k.A02(A0A);
        }
    }

    public final boolean A0H(AbstractC05784e abstractC05784e) {
        C05844k c05844k = this.A00.get(abstractC05784e);
        return (c05844k == null || (c05844k.A00 & 1) == 0) ? false : true;
    }

    public final boolean A0I(AbstractC05784e abstractC05784e) {
        C05844k c05844k = this.A00.get(abstractC05784e);
        return (c05844k == null || (c05844k.A00 & 4) == 0) ? false : true;
    }
}
