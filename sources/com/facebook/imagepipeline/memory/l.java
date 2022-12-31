package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
/* compiled from: DefaultFlexByteArrayPoolParams.java */
/* loaded from: classes.dex */
public class l {
    public static final int a = Runtime.getRuntime().availableProcessors();

    public static SparseIntArray a(int i2, int i3, int i4) {
        SparseIntArray sparseIntArray = new SparseIntArray();
        while (i2 <= i3) {
            sparseIntArray.put(i2, i4);
            i2 *= 2;
        }
        return sparseIntArray;
    }

    public static c0 b() {
        int i2 = a;
        return new c0(4194304, i2 * 4194304, a(131072, 4194304, i2), 131072, 4194304, i2);
    }
}
