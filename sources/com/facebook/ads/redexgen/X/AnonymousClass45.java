package com.facebook.ads.redexgen.X;

import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.45  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class AnonymousClass45 {
    public static String[] A01 = {"1CU3iw4Trc3qggngkxP7P26jEGLrLZaR", "qcH7HKgKdAybLTWn0rmK7JyCE0S9C8rn", "oNJ0dA1Zpt4CixMfeWT18n5RxX88Y0E3", "FZ8N3xW3PfzdZjJWrErZ2QIuE13XuJtD", "DvPOKoiXqOiYMgjx6IqCziqOSBLzEcJY", "MpMZeZ7xc490HXAXJonG5r1KTyiIoUHH", "NGMd8PbmdSzgSLgNcWdVjgLa", "jY1Ixh6DMe9BpV8yAbg842YJP45AQ2Eb"};
    public final AnonymousClass44 A00;

    public AnonymousClass45(AnonymousClass44 anonymousClass44) {
        this.A00 = anonymousClass44;
    }

    private int A00(List<C05553h> list) {
        boolean z = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).A00 == 8) {
                if (z) {
                    return size;
                }
            } else {
                z = true;
            }
        }
        return -1;
    }

    private void A01(List<C05553h> list, int i2, int i3) {
        C05553h c05553h = list.get(i2);
        C05553h nextOp = list.get(i3);
        int i4 = nextOp.A00;
        if (i4 != 1) {
            if (i4 == 2) {
                A03(list, i2, c05553h, i3, nextOp);
                return;
            } else if (i4 == 4) {
                A04(list, i2, c05553h, i3, nextOp);
                return;
            } else {
                return;
            }
        }
        String[] strArr = A01;
        if (strArr[1].charAt(7) == strArr[5].charAt(7)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[0] = "aUQhN9RPINWHdtDS2haQB24BMlUHbr4B";
        strArr2[7] = "XOFwSchhjWWz78nEYYkf12AsjhBhdKRi";
        A02(list, i2, c05553h, i3, nextOp);
    }

    private void A02(List<C05553h> list, int i2, C05553h c05553h, int i3, C05553h c05553h2) {
        int i4 = 0;
        if (c05553h.A01 < c05553h2.A02) {
            i4 = 0 - 1;
        }
        if (c05553h.A02 < c05553h2.A02) {
            i4++;
        }
        if (c05553h2.A02 <= c05553h.A02) {
            c05553h.A02 += c05553h2.A01;
        }
        if (c05553h2.A02 <= c05553h.A01) {
            c05553h.A01 += c05553h2.A01;
        }
        c05553h2.A02 += i4;
        list.set(i2, c05553h2);
        list.set(i3, c05553h);
    }

    private final void A03(List<C05553h> list, int i2, C05553h c05553h, int i3, C05553h c05553h2) {
        boolean z;
        C05553h c05553h3 = null;
        boolean z2 = false;
        if (c05553h.A02 < c05553h.A01) {
            z = false;
            if (c05553h2.A02 == c05553h.A02 && c05553h2.A01 == c05553h.A01 - c05553h.A02) {
                z2 = true;
            }
        } else {
            z = true;
            if (c05553h2.A02 == c05553h.A01 + 1 && c05553h2.A01 == c05553h.A02 - c05553h.A01) {
                z2 = true;
            }
        }
        if (c05553h.A01 < c05553h2.A02) {
            c05553h2.A02--;
        } else if (c05553h.A01 < c05553h2.A02 + c05553h2.A01) {
            c05553h2.A01--;
            c05553h.A00 = 2;
            c05553h.A01 = 1;
            int i4 = c05553h2.A01;
            if (A01[6].length() == 11) {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[2] = "8AUTweiK2qHuqKAjuAP9RAHRjtqC9cI5";
            strArr[3] = "fxjAamJyQJjVOLb9u9QxKoC9co41mLuZ";
            if (i4 == 0) {
                list.remove(i3);
                this.A00.ADN(c05553h2);
                return;
            }
            return;
        }
        if (c05553h.A02 <= c05553h2.A02) {
            c05553h2.A02++;
        } else if (c05553h.A02 < c05553h2.A02 + c05553h2.A01) {
            c05553h3 = this.A00.A9c(2, c05553h.A02 + 1, (c05553h2.A02 + c05553h2.A01) - c05553h.A02, null);
            c05553h2.A01 = c05553h.A02 - c05553h2.A02;
        }
        if (z2) {
            list.set(i2, c05553h2);
            list.remove(i3);
            this.A00.ADN(c05553h);
            return;
        }
        if (z) {
            if (c05553h3 != null) {
                if (c05553h.A02 > c05553h3.A02) {
                    c05553h.A02 -= c05553h3.A01;
                }
                if (c05553h.A01 > c05553h3.A02) {
                    c05553h.A01 -= c05553h3.A01;
                }
            }
            if (c05553h.A02 > c05553h2.A02) {
                c05553h.A02 -= c05553h2.A01;
            }
            if (c05553h.A01 > c05553h2.A02) {
                c05553h.A01 -= c05553h2.A01;
            }
        } else {
            if (c05553h3 != null) {
                if (c05553h.A02 >= c05553h3.A02) {
                    c05553h.A02 -= c05553h3.A01;
                }
                if (c05553h.A01 >= c05553h3.A02) {
                    c05553h.A01 -= c05553h3.A01;
                }
            }
            if (c05553h.A02 >= c05553h2.A02) {
                c05553h.A02 -= c05553h2.A01;
            }
            if (c05553h.A01 >= c05553h2.A02) {
                c05553h.A01 -= c05553h2.A01;
            }
        }
        list.set(i2, c05553h2);
        String[] strArr2 = A01;
        if (strArr2[1].charAt(7) == strArr2[5].charAt(7)) {
            throw new RuntimeException();
        }
        String[] strArr3 = A01;
        strArr3[1] = "R1vl9Esi4EQuoIO0IEs3BYKA9Bp2yfIo";
        strArr3[5] = "ll7MLLjNdpT1F8Cd0W3dCYnGe1w6KT9M";
        if (c05553h.A02 != c05553h.A01) {
            list.set(i3, c05553h);
        } else {
            list.remove(i3);
        }
        if (c05553h3 != null) {
            list.add(i2, c05553h3);
        }
    }

    private final void A04(List<C05553h> list, int i2, C05553h c05553h, int i3, C05553h c05553h2) {
        C05553h c05553h3 = null;
        C05553h c05553h4 = null;
        if (c05553h.A01 < c05553h2.A02) {
            c05553h2.A02--;
        } else if (c05553h.A01 < c05553h2.A02 + c05553h2.A01) {
            c05553h2.A01--;
            c05553h3 = this.A00.A9c(4, c05553h.A02, 1, c05553h2.A03);
        }
        if (c05553h.A02 <= c05553h2.A02) {
            c05553h2.A02++;
        } else if (c05553h.A02 < c05553h2.A02 + c05553h2.A01) {
            int i4 = (c05553h2.A02 + c05553h2.A01) - c05553h.A02;
            c05553h4 = this.A00.A9c(4, c05553h.A02 + 1, i4, c05553h2.A03);
            c05553h2.A01 -= i4;
        }
        list.set(i3, c05553h);
        if (c05553h2.A01 > 0) {
            list.set(i2, c05553h2);
        } else {
            list.remove(i2);
            this.A00.ADN(c05553h2);
        }
        if (c05553h3 != null) {
            list.add(i2, c05553h3);
        }
        if (c05553h4 != null) {
            list.add(i2, c05553h4);
        }
    }

    public final void A05(List<C05553h> list) {
        while (true) {
            int A00 = A00(list);
            if (A00 != -1) {
                A01(list, A00, A00 + 1);
            } else {
                return;
            }
        }
    }
}
