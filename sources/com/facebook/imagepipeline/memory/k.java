package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
/* compiled from: DefaultByteArrayPoolParams.java */
/* loaded from: classes.dex */
public class k {
    public static c0 a() {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sparseIntArray.put(16384, 5);
        return new c0(81920, 1048576, sparseIntArray);
    }
}
