package com.facebook.ads.redexgen.X;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.bg  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1471bg implements AnonymousClass44 {
    public static byte[] A08;
    public static String[] A09 = {"X1JWoRd1RTsi5LXg3YfkE890Z0SkAp6s", "8cHG76lMVFwKxBGRg2kgut24eHhxfbd", "G9TzZa55JFGh4eGgvGtqHGY1m3qrW6LM", "T7A4lgHZzGr7V1uQcw7LfDSO4lerGRH7", "wT7nveBXif1G6UL4LkiEJi9kfhK", "XR1Jqmc9zxsTs7lfyBsyi3NvUHLKhP3K", "pVA6ZWYUVwE4UScIoRBBosOqE3FsfWwK", "nWmw"};
    public int A00;
    public C2X<C05553h> A01;
    public final InterfaceC05543g A02;
    public final AnonymousClass45 A03;
    public final Runnable A04;
    public final ArrayList<C05553h> A05;
    public final ArrayList<C05553h> A06;
    public final boolean A07;

    public static String A02(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A08, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 66);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A08 = new byte[]{-100, -75, -78, -75, -74, -66, -75, 103, -68, -73, -85, -88, -69, -84, 103, -74, -73, 103, -69, -64, -73, -84, 103, -83, -74, -71, 103, -44, -45, -47, -34, -123, -41, -54, -46, -44, -37, -54, -123, -58, -45, -55, -123, -38, -43, -55, -58, -39, -54, -123, -44, -43, -40, -123, -56, -58, -45, -123, -57, -54, -123, -55, -50, -40, -43, -58, -39, -56, -51, -54, -55, -123, -50, -45, -123, -53, -50, -41, -40, -39, -123, -43, -58, -40, -40, -24, -23, -103, -20, -31, -24, -18, -27, -35, -103, -37, -34, -103, -21, -34, -26, -24, -17, -34, -103, -24, -21, -103, -18, -23, -35, -38, -19, -34, -89, 30, 19, 26, 32, 23, 15, -53, 25, 26, 31, -53, 15, 20, 30, 27, 12, 31, 14, 19, -53, 12, 15, 15, -53, 26, 29, -53, 24, 26, 33, 16, -53, 17, 26, 29, -53, 27, 29, 16, -53, 23, 12, 36, 26, 32, 31};
    }

    static {
        A03();
    }

    public C1471bg(InterfaceC05543g interfaceC05543g) {
        this(interfaceC05543g, false);
    }

    public C1471bg(InterfaceC05543g interfaceC05543g, boolean z) {
        this.A01 = new C1485bw(30);
        this.A05 = new ArrayList<>();
        this.A06 = new ArrayList<>();
        this.A00 = 0;
        this.A02 = interfaceC05543g;
        this.A07 = z;
        this.A03 = new AnonymousClass45(this);
    }

    private int A00(int i2, int start) {
        int i3;
        int i4;
        for (int end = this.A06.size() - 1; end >= 0; end--) {
            C05553h c05553h = this.A06.get(end);
            if (c05553h.A00 == 8) {
                if (c05553h.A02 < c05553h.A01) {
                    i3 = c05553h.A02;
                    i4 = c05553h.A01;
                } else {
                    i3 = c05553h.A01;
                    i4 = c05553h.A02;
                }
                if (i2 >= i3 && i2 <= i4) {
                    if (i3 == c05553h.A02) {
                        if (start == 1) {
                            c05553h.A01++;
                        } else if (start == 2) {
                            c05553h.A01--;
                        }
                        i2++;
                    } else {
                        if (start == 1) {
                            c05553h.A02++;
                        } else if (start == 2) {
                            c05553h.A02--;
                        }
                        i2--;
                    }
                } else if (i2 < c05553h.A02) {
                    if (start == 1) {
                        c05553h.A02++;
                        c05553h.A01++;
                    } else if (start == 2) {
                        c05553h.A02--;
                        c05553h.A01--;
                    }
                }
            } else if (c05553h.A02 <= i2) {
                if (c05553h.A00 == 1) {
                    int i5 = c05553h.A01;
                    if (A09[7].length() != 4) {
                        throw new RuntimeException();
                    }
                    A09[7] = "N0sU";
                    i2 -= i5;
                } else if (c05553h.A00 == 2) {
                    i2 += c05553h.A01;
                }
            } else if (start == 1) {
                c05553h.A02++;
            } else if (start == 2) {
                c05553h.A02--;
            }
        }
        for (int size = this.A06.size() - 1; size >= 0; size--) {
            C05553h c05553h2 = this.A06.get(size);
            if (c05553h2.A00 == 8) {
                if (c05553h2.A01 == c05553h2.A02 || c05553h2.A01 < 0) {
                    this.A06.remove(size);
                    ADN(c05553h2);
                }
            } else if (c05553h2.A01 <= 0) {
                this.A06.remove(size);
                ADN(c05553h2);
            }
        }
        return i2;
    }

    private final int A01(int i2, int i3) {
        int size = this.A06.size();
        while (i3 < size) {
            C05553h c05553h = this.A06.get(i3);
            if (c05553h.A00 == 8) {
                if (c05553h.A02 == i2) {
                    i2 = c05553h.A01;
                } else {
                    if (c05553h.A02 < i2) {
                        i2--;
                    }
                    if (c05553h.A01 <= i2) {
                        i2++;
                    }
                }
            } else if (c05553h.A02 > i2) {
                continue;
            } else if (c05553h.A00 == 2) {
                if (i2 < c05553h.A02 + c05553h.A01) {
                    return -1;
                }
                i2 -= c05553h.A01;
            } else {
                int i4 = c05553h.A00;
                String[] strArr = A09;
                if (strArr[6].charAt(31) != strArr[5].charAt(31)) {
                    throw new RuntimeException();
                }
                A09[1] = "6d2Cvy1MfGwOem3AHh21iiz4RwVuOhP";
                if (i4 == 1) {
                    i2 += c05553h.A01;
                }
            }
            i3++;
        }
        return i2;
    }

    private void A04(C05553h c05553h) {
        A09(c05553h);
    }

    private void A05(C05553h c05553h) {
        A09(c05553h);
    }

    private void A06(C05553h c05553h) {
        int tmpEnd = c05553h.A02;
        int type = 0;
        int position = c05553h.A02 + c05553h.A01;
        char c = 65535;
        int i2 = c05553h.A02;
        while (i2 < position) {
            boolean z = false;
            if (this.A02.A5N(i2) != null || A0C(i2)) {
                if (c == 0) {
                    A08(A9c(2, tmpEnd, type, null));
                    z = true;
                }
                c = 1;
            } else {
                if (c == 1) {
                    C05553h newOp = A9c(2, tmpEnd, type, null);
                    A09(newOp);
                    z = true;
                }
                c = 0;
            }
            if (z) {
                i2 -= type;
                position -= type;
                type = 1;
            } else {
                type++;
            }
            i2++;
        }
        if (type != c05553h.A01) {
            ADN(c05553h);
            c05553h = A9c(2, tmpEnd, type, null);
        }
        if (c == 0) {
            A08(c05553h);
        } else {
            A09(c05553h);
        }
    }

    private void A07(C05553h c05553h) {
        int tmpEnd = c05553h.A02;
        int type = 0;
        int position = c05553h.A02 + c05553h.A01;
        char c = 65535;
        int i2 = c05553h.A02;
        while (true) {
            String[] strArr = A09;
            if (strArr[6].charAt(31) != strArr[5].charAt(31)) {
                throw new RuntimeException();
            }
            A09[0] = "QVMb2fRXyzWHiAZPpRD1aZXDVthvAAWC";
            if (i2 < position) {
                if (this.A02.A5N(i2) != null || A0C(i2)) {
                    if (c == 0) {
                        A08(A9c(4, tmpEnd, type, c05553h.A03));
                        type = 0;
                        tmpEnd = i2;
                    }
                    c = 1;
                } else {
                    if (c == 1) {
                        C05553h newOp = A9c(4, tmpEnd, type, c05553h.A03);
                        A09(newOp);
                        type = 0;
                        tmpEnd = i2;
                    }
                    c = 0;
                }
                type++;
                i2++;
            } else {
                if (type != c05553h.A01) {
                    Object obj = c05553h.A03;
                    ADN(c05553h);
                    c05553h = A9c(4, tmpEnd, type, obj);
                }
                if (c == 0) {
                    A08(c05553h);
                    return;
                } else {
                    A09(c05553h);
                    return;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void A08(com.facebook.ads.redexgen.X.C05553h r12) {
        /*
            Method dump skipped, instructions count: 243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1471bg.A08(com.facebook.ads.redexgen.X.3h):void");
    }

    private void A09(C05553h c05553h) {
        this.A06.add(c05553h);
        int i2 = c05553h.A00;
        if (i2 == 1) {
            this.A02.A9d(c05553h.A02, c05553h.A01);
        } else if (i2 == 2) {
            this.A02.A9g(c05553h.A02, c05553h.A01);
        } else if (i2 == 4) {
            this.A02.A9K(c05553h.A02, c05553h.A01, c05553h.A03);
        } else if (i2 == 8) {
            this.A02.A9e(c05553h.A02, c05553h.A01);
        } else {
            throw new IllegalArgumentException(A02(0, 27, 5) + c05553h);
        }
    }

    private final void A0A(C05553h c05553h, int i2) {
        this.A02.AAJ(c05553h);
        int i3 = c05553h.A00;
        if (i3 == 2) {
            this.A02.A9f(i2, c05553h.A01);
        } else if (i3 == 4) {
            this.A02.A9K(i2, c05553h.A01, c05553h.A03);
        } else {
            throw new IllegalArgumentException(A02(27, 58, 35));
        }
    }

    private final void A0B(List<C05553h> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            ADN(list.get(i2));
        }
        list.clear();
    }

    private boolean A0C(int i2) {
        int size = this.A06.size();
        for (int pos = 0; pos < size; pos++) {
            C05553h c05553h = this.A06.get(pos);
            if (c05553h.A00 == 8) {
                if (A01(c05553h.A01, pos + 1) == i2) {
                    return true;
                }
            } else {
                int i3 = c05553h.A00;
                if (A09[4].length() != 28) {
                    A09[7] = "h3FT";
                    if (i3 == 1) {
                        int i4 = c05553h.A02 + c05553h.A01;
                        for (int i5 = c05553h.A02; i5 < i4; i5++) {
                            if (A01(i5, pos + 1) == i2) {
                                return true;
                            }
                        }
                        continue;
                    } else {
                        continue;
                    }
                } else {
                    throw new RuntimeException();
                }
            }
        }
        return false;
    }

    public final int A0D(int i2) {
        return A01(i2, 0);
    }

    public final int A0E(int i2) {
        int size = this.A05.size();
        for (int i3 = 0; i3 < size; i3++) {
            C05553h c05553h = this.A05.get(i3);
            int i4 = c05553h.A00;
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 == 8) {
                        if (c05553h.A02 == i2) {
                            i2 = c05553h.A01;
                        } else {
                            if (c05553h.A02 < i2) {
                                i2--;
                            }
                            if (c05553h.A01 <= i2) {
                                i2++;
                            }
                        }
                    }
                } else if (c05553h.A02 > i2) {
                    continue;
                } else if (c05553h.A02 + c05553h.A01 > i2) {
                    return -1;
                } else {
                    i2 -= c05553h.A01;
                }
            } else if (c05553h.A02 <= i2) {
                i2 += c05553h.A01;
            }
        }
        return i2;
    }

    public final void A0F() {
        int size = this.A06.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.A02.AAL(this.A06.get(i2));
        }
        A0B(this.A06);
        this.A00 = 0;
    }

    public final void A0G() {
        A0F();
        int size = this.A05.size();
        for (int i2 = 0; i2 < size; i2++) {
            C05553h c05553h = this.A05.get(i2);
            int i3 = c05553h.A00;
            if (i3 == 1) {
                this.A02.AAL(c05553h);
                InterfaceC05543g interfaceC05543g = this.A02;
                int i4 = c05553h.A02;
                int i5 = c05553h.A01;
                interfaceC05543g.A9d(i4, i5);
            } else if (i3 == 2) {
                this.A02.AAL(c05553h);
                InterfaceC05543g interfaceC05543g2 = this.A02;
                int i6 = c05553h.A02;
                int i7 = c05553h.A01;
                if (A09[0].charAt(28) != 'A') {
                    A09[0] = "CM7MK7KhSxDopOj0YrHNMoPSB3hYAvlM";
                    interfaceC05543g2.A9f(i6, i7);
                } else {
                    A09[0] = "0a4GBd0juwjU6ZOPGBL8pgIRsQZTAwEC";
                    interfaceC05543g2.A9f(i6, i7);
                }
            } else if (i3 == 4) {
                this.A02.AAL(c05553h);
                InterfaceC05543g interfaceC05543g3 = this.A02;
                int i8 = c05553h.A02;
                int i9 = c05553h.A01;
                if (A09[0].charAt(28) != 'A') {
                    throw new RuntimeException();
                }
                A09[1] = "6Qpi3zwbHCTXm3nhA4JhLro11ECL3LU";
                interfaceC05543g3.A9K(i8, i9, c05553h.A03);
            } else if (i3 == 8) {
                this.A02.AAL(c05553h);
                InterfaceC05543g interfaceC05543g4 = this.A02;
                int i10 = c05553h.A02;
                int i11 = c05553h.A01;
                interfaceC05543g4.A9e(i10, i11);
            }
            Runnable runnable = this.A04;
            if (runnable != null) {
                runnable.run();
            }
        }
        A0B(this.A05);
        this.A00 = 0;
    }

    public final void A0H() {
        this.A03.A05(this.A05);
        int size = this.A05.size();
        for (int i2 = 0; i2 < size; i2++) {
            C05553h c05553h = this.A05.get(i2);
            int i3 = c05553h.A00;
            String[] strArr = A09;
            String str = strArr[6];
            String str2 = strArr[5];
            int i4 = str.charAt(31);
            if (i4 != str2.charAt(31)) {
                throw new RuntimeException();
            }
            A09[1] = "1BDdKJQJlsgxETOK14Gjs1hC7fjbuKK";
            if (i3 == 1) {
                A04(c05553h);
            } else if (i3 == 2) {
                A06(c05553h);
            } else if (i3 == 4) {
                A07(c05553h);
            } else if (i3 == 8) {
                A05(c05553h);
            }
            Runnable runnable = this.A04;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.A05.clear();
    }

    public final void A0I() {
        A0B(this.A05);
        A0B(this.A06);
        this.A00 = 0;
    }

    public final boolean A0J() {
        return this.A05.size() > 0;
    }

    public final boolean A0K() {
        return (this.A06.isEmpty() || this.A05.isEmpty()) ? false : true;
    }

    public final boolean A0L(int i2) {
        return (this.A00 & i2) != 0;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass44
    public final C05553h A9c(int i2, int i3, int i4, Object obj) {
        C05553h A2O = this.A01.A2O();
        if (A2O == null) {
            return new C05553h(i2, i3, i4, obj);
        }
        A2O.A00 = i2;
        A2O.A02 = i3;
        A2O.A01 = i4;
        A2O.A03 = obj;
        return A2O;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass44
    public final void ADN(C05553h c05553h) {
        if (!this.A07) {
            c05553h.A03 = null;
            this.A01.ADV(c05553h);
        }
    }
}
