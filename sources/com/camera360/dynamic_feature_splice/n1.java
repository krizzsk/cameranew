package com.camera360.dynamic_feature_splice;

import android.graphics.Bitmap;
import android.graphics.Point;
/* compiled from: Splices.kt */
/* loaded from: classes8.dex */
public final class n1 {
    private final String a;
    private final int b;
    private final Point c;

    /* renamed from: d  reason: collision with root package name */
    private final Bitmap f2197d;

    public n1(String path, int i2, Point size, Bitmap bitmap) {
        kotlin.jvm.internal.s.h(path, "path");
        kotlin.jvm.internal.s.h(size, "size");
        kotlin.jvm.internal.s.h(bitmap, "bitmap");
        this.a = path;
        this.b = i2;
        this.c = size;
        this.f2197d = bitmap;
    }

    public final Bitmap a() {
        return this.f2197d;
    }

    public final int b() {
        return this.b;
    }

    public final String c() {
        return this.a;
    }

    public final Point d() {
        return this.c;
    }
}
