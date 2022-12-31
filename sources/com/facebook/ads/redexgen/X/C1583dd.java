package com.facebook.ads.redexgen.X;

import android.graphics.Rect;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.common.callercontext.ContextChain;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* renamed from: com.facebook.ads.redexgen.X.dd  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1583dd {
    @Nullable
    public InterfaceC1586dg A00;
    @Nullable
    public InterfaceC1584de A01;
    public C1571dR A02;
    public final InterfaceC1593dn A03;
    @Nullable
    public final InterfaceC1585df A04;

    public C1583dd(InterfaceC1593dn interfaceC1593dn, @Nullable InterfaceC1585df interfaceC1585df) {
        this.A03 = interfaceC1593dn;
        this.A04 = interfaceC1585df;
    }

    public static C1583dd A00() {
        return new C1583dd(new G5(), null);
    }

    private void A01(AbstractC1587dh abstractC1587dh, InterfaceC1591dl interfaceC1591dl, G3 g3) {
        this.A02 = C1571dR.A00(abstractC1587dh, interfaceC1591dl, g3);
        InterfaceC1586dg interfaceC1586dg = this.A00;
        if (interfaceC1586dg != null) {
            this.A02.A03(interfaceC1586dg);
        }
        InterfaceC1584de interfaceC1584de = this.A01;
        if (interfaceC1584de != null) {
            this.A02.A04(interfaceC1584de);
        }
    }

    public final void A02(View view) {
        this.A02.A01(view);
    }

    public final void A03(View view, C1589dj c1589dj) {
        this.A02.A02(view, c1589dj);
    }

    public final void A04(AbstractC1587dh abstractC1587dh, View view) {
        G4 g4 = new G4(view, this.A03);
        final InterfaceC1585df interfaceC1585df = this.A04;
        A01(abstractC1587dh, g4, new G3(interfaceC1585df) { // from class: com.facebook.ads.redexgen.X.3Z
            public static byte[] A07;
            public static String[] A08 = {"okBgSYhQGmV0QyU32992deBLR6XrdaZQ", ExifInterface.LONGITUDE_EAST, "ZDdZ5rthnspWTI3gzSJHBR7aYCyAxUsq", "EsXM2pc2I6J3hYC1V9OQRTCtALa8wmqB", "DKA0ex9266tXplnV6PUb8C0vdYHWYjG4", "tBgdKBpc94v7LWesC8aTGIaQqZdJYwjy", "iZindrm9v6DBRttH7DMzAa7", "d9237vu9oQoOcpvZwewcjFUDz74P7MIA"};
            public static final String A09;
            public long A00;
            @Nullable
            public InterfaceC1586dg A01;
            @Nullable
            public final InterfaceC1585df A02;
            public final Map<String, C1575dV> A06 = new HashMap();
            public final C1576dW A04 = new C1576dW();
            public final C1576dW A03 = new C1576dW();
            public final List<Rect> A05 = new ArrayList(1);

            public static String A02(int i2, int i3, int i4) {
                byte[] copyOfRange = Arrays.copyOfRange(A07, i2, i2 + i3);
                for (int i5 = 0; i5 < copyOfRange.length; i5++) {
                    copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 91);
                }
                return new String(copyOfRange);
            }

            public static void A03() {
                A07 = new byte[]{41, 21, 20, 14, 93, 11, 20, 24, 10, Draft_75.CR, 18, 20, 19, 9, 93, 21, 28, 14, 93, 19, 18, 9, 93, 31, 24, 24, 19, 93, 16, 24, 28, 14, 8, 15, 24, 25, 93, 18, 15, 93, 20, 14, 93, 28, 93, 26, 15, 18, 8, Draft_75.CR, 93, 10, 21, 20, 30, 21, 93, 10, 20, 17, 17, 93, 19, 24, 11, 24, 15, 93, 15, 24, 9, 8, 15, 19, 93, 28, 93, 16, 24, 28, 14, 8, 15, 24, 16, 24, 19, 9, 93, 14, 20, 19, 30, 24, 93, 20, 9, 90, 14, 93, 16, 28, 25, 24, 93, 8, Draft_75.CR, 93, 18, 27, 93, 14, 8, 31, 11, 20, 24, 10, 14, 93, 9, 21, 28, 9, 93, 30, 18, 8, 17, 25, 93, 31, 24, 93, 18, 27, 27, 14, 30, 15, 24, 24, 19, 118, 125, 111, 75, 123, 121, 118, 63, 36, 61, 61, 113, 39, 56, 52, 38, 113, 33, 35, 62, 33, 52, 35, 37, 40, 113, 55, 62, 35, 113, 35, 52, 60, 62, 39, 52, 53, 113, 56, 37, 52, 60, 113, 125, 97, 104, 122, 92, 107, 126, 97, 124, 122};
            }

            static {
                A03();
                A09 = C3Z.class.getSimpleName();
            }

            {
                this.A02 = interfaceC1585df;
            }

            public static Rect A00(@Nullable C1575dV c1575dV) {
                Rect rect;
                Rect rect2;
                Rect rect3;
                Rect rect4;
                Rect rect5;
                if (c1575dV != null) {
                    rect = c1575dV.A02;
                    if (rect.top != Integer.MIN_VALUE) {
                        rect2 = c1575dV.A02;
                        if (rect2.left != Integer.MIN_VALUE) {
                            rect3 = c1575dV.A02;
                            String[] strArr = A08;
                            if (strArr[1].length() == strArr[6].length()) {
                                throw new RuntimeException();
                            }
                            String[] strArr2 = A08;
                            strArr2[1] = ContextChain.TAG_PRODUCT;
                            strArr2[6] = "Kr6mbDoiLKwWSgNyXDF2oJW";
                            if (rect3.right != Integer.MIN_VALUE) {
                                rect4 = c1575dV.A02;
                                if (rect4.bottom != Integer.MIN_VALUE) {
                                    rect5 = c1575dV.A02;
                                    return rect5;
                                }
                            }
                        }
                    }
                }
                throw new IllegalStateException(A02(0, 143, 38));
            }

            private C1575dV A01(C1589dj c1589dj, Rect rect, Rect rect2) {
                boolean A06;
                Rect rect3;
                List list;
                C1575dV c1575dV = this.A06.get(c1589dj.A03);
                A06 = this.A04.A06(c1589dj);
                if (A06) {
                    if (c1575dV != null) {
                        c1575dV.A01 = EnumC1579dZ.A04;
                    } else {
                        c1575dV = C1575dV.A03(this.A00);
                        this.A06.put(c1589dj.A03, c1575dV);
                    }
                }
                rect3 = c1575dV.A02;
                rect3.set(rect2);
                list = c1575dV.A03;
                list.add(new Rect(rect));
                return c1575dV;
            }

            private void A04(C1576dW c1576dW) {
                Collection<C1589dj> A01;
                List list;
                A01 = c1576dW.A01();
                for (C1589dj c1589dj : A01) {
                    C1575dV c1575dV = this.A06.get(c1589dj.A03);
                    if (c1575dV == null) {
                        InterfaceC1585df interfaceC1585df2 = this.A02;
                        String[] strArr = A08;
                        if (strArr[0].charAt(8) == strArr[2].charAt(8)) {
                            throw new RuntimeException();
                        }
                        String[] strArr2 = A08;
                        strArr2[0] = "dCpYPRypiVOHB4OlkAqBqk8EySqTLE1k";
                        strArr2[2] = "r3sjB169HJX8vOmMpko73ANLsggTEmi2";
                        if (interfaceC1585df2 != null) {
                            String str = A02(150, 36, 10) + c1589dj.A03;
                            throw new NullPointerException(A02(186, 10, 85));
                        }
                    } else {
                        c1575dV.A01 = EnumC1579dZ.A03;
                        list = c1575dV.A03;
                        list.clear();
                        c1589dj.A03(this);
                    }
                }
            }

            private void A05(C1576dW c1576dW) {
                Collection<C1589dj> A00;
                A00 = c1576dW.A00();
                for (C1589dj c1589dj : A00) {
                    c1589dj.A03(this);
                }
            }

            @Override // com.facebook.ads.redexgen.X.G3
            public final void A3I(C1589dj c1589dj, Rect rect, Rect rect2) {
                boolean A06;
                List list;
                Rect rect3;
                List list2;
                A01(c1589dj, rect, rect2);
                C1589dj c1589dj2 = c1589dj.A00;
                if (c1589dj2 == C1589dj.A06) {
                    return;
                }
                A06 = this.A03.A06(c1589dj2);
                C1575dV c1575dV = this.A06.get(c1589dj2.A03);
                if (A06) {
                    if (c1575dV == null) {
                        c1575dV = C1575dV.A03(this.A00);
                        rect3 = c1575dV.A02;
                        rect3.set(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
                        this.A06.put(c1589dj2.A03, c1575dV);
                    } else {
                        list2 = c1575dV.A03;
                        list2.clear();
                        c1575dV.A01 = EnumC1579dZ.A04;
                    }
                }
                list = c1575dV.A03;
                list.add(new Rect(rect));
            }

            @Override // com.facebook.ads.redexgen.X.G3
            public final void A3o(long j2, List<Rect> list) {
                Collection<C1589dj> A01;
                Collection<C1589dj> A012;
                List list2;
                this.A00 = j2;
                this.A05.clear();
                for (Rect rect : list) {
                    this.A05.add(new Rect(rect));
                }
                A01 = this.A04.A01();
                for (C1589dj c1589dj : A01) {
                    this.A06.remove(c1589dj.A03);
                }
                A012 = this.A03.A01();
                for (C1589dj c1589dj2 : A012) {
                    this.A06.remove(c1589dj2.A03);
                }
                for (C1575dV c1575dV : this.A06.values()) {
                    list2 = c1575dV.A03;
                    list2.clear();
                }
                this.A04.A04();
                this.A03.A04();
            }

            @Override // com.facebook.ads.redexgen.X.G3
            public final void A5B() {
                Collection A00;
                Collection A002;
                A05(this.A04);
                A04(this.A04);
                A05(this.A03);
                A04(this.A03);
                if (this.A01 != null) {
                    String obj = toString();
                    List<Rect> list = this.A05;
                    A00 = this.A04.A00();
                    A002 = this.A03.A00();
                    new C1574dU(obj, this, list, A00, A002);
                    throw new NullPointerException(A02(143, 7, 67));
                }
            }

            @Override // com.facebook.ads.redexgen.X.InterfaceC1578dY
            public final void A6f(C1589dj c1589dj, Rect rect) {
                List<Rect> list;
                rect.setEmpty();
                list = this.A06.get(c1589dj.A03).A03;
                for (Rect rect2 : list) {
                    rect.union(rect2);
                }
            }

            @Override // com.facebook.ads.redexgen.X.InterfaceC1578dY
            public final EnumC1579dZ A7g(C1589dj c1589dj) {
                EnumC1579dZ enumC1579dZ;
                enumC1579dZ = this.A06.get(c1589dj.A03).A01;
                return enumC1579dZ;
            }

            @Override // com.facebook.ads.redexgen.X.InterfaceC1578dY
            public final void A7h(Rect rect) {
                rect.setEmpty();
                for (Rect rect2 : this.A05) {
                    rect.union(rect2);
                }
            }

            @Override // com.facebook.ads.redexgen.X.InterfaceC1578dY
            public final float A7i(C1589dj c1589dj) {
                List<Rect> list;
                C1575dV c1575dV = this.A06.get(c1589dj.A03);
                if (c1575dV != null) {
                    Rect A00 = A00(c1575dV);
                    int height = A00.height() * A00.width();
                    int i2 = 0;
                    list = c1575dV.A03;
                    for (Rect rect : list) {
                        int totalPossibleArea = rect.height();
                        int totalVisibleArea = rect.width();
                        i2 += totalPossibleArea * totalVisibleArea;
                    }
                    return i2 / height;
                }
                return 0.0f;
            }

            @Override // com.facebook.ads.redexgen.X.G3
            public final void AEY(@Nullable InterfaceC1586dg interfaceC1586dg) {
                this.A01 = interfaceC1586dg;
            }
        });
    }
}
