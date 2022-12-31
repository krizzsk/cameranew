package com.facebook.imagepipeline.animated.b;
/* compiled from: AnimatedDrawableUtil.java */
/* loaded from: classes.dex */
public class a {
    public void a(int[] iArr) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (iArr[i2] < 11) {
                iArr[i2] = 100;
            }
        }
    }

    public int[] b(int[] iArr) {
        int[] iArr2 = new int[iArr.length];
        int i2 = 0;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            iArr2[i3] = i2;
            i2 += iArr[i3];
        }
        return iArr2;
    }

    public int c(int[] iArr) {
        int i2 = 0;
        for (int i3 : iArr) {
            i2 += i3;
        }
        return i2;
    }
}
