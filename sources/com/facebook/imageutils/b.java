package com.facebook.imageutils;

import android.graphics.ColorSpace;
import android.util.Pair;
import javax.annotation.Nullable;
/* compiled from: ImageMetaData.java */
/* loaded from: classes.dex */
public class b {
    @Nullable
    private final Pair<Integer, Integer> a;
    @Nullable
    private final ColorSpace b;

    public b(int i2, int i3, @Nullable ColorSpace colorSpace) {
        this.a = (i2 == -1 || i3 == -1) ? null : new Pair<>(Integer.valueOf(i2), Integer.valueOf(i3));
        this.b = colorSpace;
    }

    @Nullable
    public ColorSpace a() {
        return this.b;
    }

    @Nullable
    public Pair<Integer, Integer> b() {
        return this.a;
    }
}
