package com.facebook.common.internal;
/* compiled from: Ints.java */
/* loaded from: classes.dex */
public class f {
    public static int a(int... iArr) {
        h.b(Boolean.valueOf(iArr.length > 0));
        int i2 = iArr[0];
        for (int i3 = 1; i3 < iArr.length; i3++) {
            if (iArr[i3] > i2) {
                i2 = iArr[i3];
            }
        }
        return i2;
    }
}
