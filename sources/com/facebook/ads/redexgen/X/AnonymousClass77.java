package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum A04 uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:444)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:368)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:333)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:318)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:258)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* renamed from: com.facebook.ads.redexgen.X.77  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class AnonymousClass77 {
    public static byte[] A01;
    public static String[] A02 = {"fU4XiUh", "4ASLCGhodwv3fY7yqE", "BFhkWaiQLcBXUQO4Yi7KFwSjCE1nMNEL", "IBfibZ8IWoONy44J9jH8jZ0p3ibNlB3T", "FmTm3wR2K52Lz7zbwKhVmki4cB", "JxTEYV1Vluo7DhPyeTARHiExSqxbiuYf", "t7Mb3YBBhyhswQ5hXIhgNczDQ93Q9bzO", "oX4F1jUgCDnefIZx9v8TRjWfCJBhCFOT"};
    public static final /* synthetic */ AnonymousClass77[] A03;
    public static final AnonymousClass77 A04;
    public static final AnonymousClass77 A05;
    public static final AnonymousClass77 A06;
    public String A00;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        int i5 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A02[0].length() == 29) {
                throw new RuntimeException();
            }
            A02[1] = "";
            if (i5 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 17);
            i5++;
        }
    }

    public static void A01() {
        A01 = new byte[]{61, 52, 69, 81, 74, 67, 47, 51, 49, 42, 35, 79, 80, 87, 84, 36, 63, 54, 70, 25, 2, 11, 120, Byte.MAX_VALUE, 124};
    }

    static {
        A01();
        A06 = new AnonymousClass77(A00(19, 6, 91), 0, A00(8, 7, 115));
        A05 = new AnonymousClass77(A00(15, 4, 102), 1, A00(3, 5, 19));
        String A00 = A00(0, 3, 97);
        A04 = new AnonymousClass77(A00, 2, A00);
        A03 = new AnonymousClass77[]{A06, A05, A04};
    }

    public AnonymousClass77(String str, int i2, String str2) {
        this.A00 = str2;
    }

    public final String A02() {
        return this.A00;
    }

    public static AnonymousClass77 valueOf(String str) {
        return (AnonymousClass77) Enum.valueOf(AnonymousClass77.class, str);
    }

    public static AnonymousClass77[] values() {
        return (AnonymousClass77[]) A03.clone();
    }
}
