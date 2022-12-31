package com.google.zxing.oned;

import com.google.zxing.FormatException;
/* compiled from: UPCEANReader.java */
/* loaded from: classes2.dex */
public abstract class o extends l {
    static final int[] a = {1, 1, 1};
    static final int[] b = {1, 1, 1, 1, 1};
    static final int[] c = {1, 1, 1, 1, 1, 1};

    /* renamed from: d  reason: collision with root package name */
    static final int[][] f5036d;

    /* renamed from: e  reason: collision with root package name */
    static final int[][] f5037e;

    static {
        int[][] iArr = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
        f5036d = iArr;
        int[][] iArr2 = new int[20];
        f5037e = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, 10);
        for (int i2 = 10; i2 < 20; i2++) {
            int[] iArr3 = f5036d[i2 - 10];
            int[] iArr4 = new int[iArr3.length];
            for (int i3 = 0; i3 < iArr3.length; i3++) {
                iArr4[i3] = iArr3[(iArr3.length - i3) - 1];
            }
            f5037e[i2] = iArr4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(CharSequence charSequence) throws FormatException {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i2 = length - 1;
        return b(charSequence.subSequence(0, i2)) == Character.digit(charSequence.charAt(i2), 10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(CharSequence charSequence) throws FormatException {
        int length = charSequence.length();
        int i2 = 0;
        for (int i3 = length - 1; i3 >= 0; i3 -= 2) {
            int charAt = charSequence.charAt(i3) - '0';
            if (charAt < 0 || charAt > 9) {
                throw FormatException.getFormatInstance();
            }
            i2 += charAt;
        }
        int i4 = i2 * 3;
        for (int i5 = length - 2; i5 >= 0; i5 -= 2) {
            int charAt2 = charSequence.charAt(i5) - '0';
            if (charAt2 < 0 || charAt2 > 9) {
                throw FormatException.getFormatInstance();
            }
            i4 += charAt2;
        }
        return (1000 - i4) % 10;
    }
}
