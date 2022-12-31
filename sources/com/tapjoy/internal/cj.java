package com.tapjoy.internal;
/* loaded from: classes3.dex */
public final class cj {
    private final String[] a = new String[512];

    public final String a(char[] cArr, int i2, int i3) {
        boolean z = false;
        int i4 = 0;
        for (int i5 = i2; i5 < i2 + i3; i5++) {
            i4 = (i4 * 31) + cArr[i5];
        }
        int i6 = ((i4 >>> 20) ^ (i4 >>> 12)) ^ i4;
        String[] strArr = this.a;
        int length = (i6 ^ ((i6 >>> 7) ^ (i6 >>> 4))) & (strArr.length - 1);
        String str = strArr[length];
        if (str != null) {
            if (str.length() == i3) {
                int i7 = 0;
                while (true) {
                    if (i7 >= i3) {
                        z = true;
                        break;
                    } else if (cArr[i2 + i7] != str.charAt(i7)) {
                        break;
                    } else {
                        i7++;
                    }
                }
            }
            if (z) {
                return str;
            }
        }
        String str2 = new String(cArr, i2, i3);
        this.a[length] = str2;
        return str2;
    }
}
