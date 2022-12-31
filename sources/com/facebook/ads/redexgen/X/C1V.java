package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum A05 uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:444)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:368)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:333)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:318)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:258)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* renamed from: com.facebook.ads.redexgen.X.1V  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C1V {
    public static byte[] A01;
    public static final /* synthetic */ C1V[] A02;
    public static final C1V A03;
    public static final C1V A04;
    public static final C1V A05;
    public final String A00;

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 32);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{24, 23, 18, 27, 1, 14, 12, 27, 29, 31, 29, 22, 27, 3, 1, 28, 11, 10, 12, 3, 1, 22, 16, 18, 16, 27, 22, 119, 101, 98, 118, 105, 101, 119, Byte.MAX_VALUE, 112, 114, 101, 99, 97, 99, 104, 101};
    }

    static {
        A02();
        String A012 = A01(27, 16, 0);
        A05 = new C1V(A012, 0, A012);
        String A013 = A01(13, 14, 115);
        A04 = new C1V(A013, 1, A013);
        String A014 = A01(0, 13, 126);
        A03 = new C1V(A014, 2, A014);
        A02 = new C1V[]{A05, A04, A03};
    }

    public C1V(String str, int i2, String str2) {
        this.A00 = str2;
    }

    public static C1V A00(String str) {
        C1V[] values;
        for (C1V c1v : values()) {
            if (c1v.A00.equalsIgnoreCase(str)) {
                return c1v;
            }
        }
        return A03;
    }

    public static C1V valueOf(String str) {
        return (C1V) Enum.valueOf(C1V.class, str);
    }

    public static C1V[] values() {
        return (C1V[]) A02.clone();
    }
}
