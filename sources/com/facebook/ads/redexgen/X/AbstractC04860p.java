package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.Map;
/* renamed from: com.facebook.ads.redexgen.X.0p  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC04860p {
    public static byte[] A04;
    public static String[] A05 = {"OqcLT37Xtir4oyEfNmT1h4Rk4YkQZZDY", "Uwe5RI", "pL0dXLjcEL0YvPTfwlaTsWSX1DbaAkE5", "xtw7OOYBvYdKgcW8WzcZrKA0PDZy4bwg", "f918FI", "0rYE8aKdqB5alUcDRGHr7byWf0zxjLED", "HJdrWZ0hD1uhwEG", "W2AWehjS6wPr2mpVEIqcODXDVwSDQEbA"};
    public boolean A00;
    public final XT A01;
    public final AbstractC04870q A02;
    public final QZ A03;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 37);
            String[] strArr = A05;
            if (strArr[7].charAt(19) == strArr[3].charAt(19)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A05;
            strArr2[5] = "ralyQsFIfJjHchT6ijaCYOn7xcrh9SYP";
            strArr2[0] = "lf1tsTh5P7IODA8hmkOKCVUdKtrYifbk";
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{-126, -90, -87, -85, -98, -84, -84, -94, -88, -89, 89, -91, -88, -96, -96, -98, -99};
    }

    public abstract void A06(Map<String, String> map);

    static {
        A01();
    }

    public AbstractC04860p(XT xt, AbstractC04870q abstractC04870q, QZ qz) {
        this.A01 = xt;
        this.A02 = abstractC04870q;
        this.A03 = qz;
    }

    public final void A02() {
        if (this.A00) {
            return;
        }
        AbstractC04870q abstractC04870q = this.A02;
        if (abstractC04870q != null) {
            abstractC04870q.A00();
        }
        A06(new C1055Nu().A03(this.A03).A05());
        this.A00 = true;
        LN.A02(this.A01, A00(0, 17, 20));
        AbstractC04870q abstractC04870q2 = this.A02;
    }
}
