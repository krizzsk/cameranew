package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import javax.annotation.Nullable;
/* compiled from: PoolParams.java */
/* loaded from: classes.dex */
public class c0 {
    public final int a;
    public final int b;
    @Nullable
    public final SparseIntArray c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f2852d;

    /* renamed from: e  reason: collision with root package name */
    public final int f2853e;

    public c0(int i2, int i3, @Nullable SparseIntArray sparseIntArray) {
        this(i2, i3, sparseIntArray, 0, Integer.MAX_VALUE, -1);
    }

    public c0(int i2, int i3, @Nullable SparseIntArray sparseIntArray, int i4, int i5, int i6) {
        com.facebook.common.internal.h.i(i2 >= 0 && i3 >= i2);
        this.b = i2;
        this.a = i3;
        this.c = sparseIntArray;
        this.f2853e = i6;
    }
}
