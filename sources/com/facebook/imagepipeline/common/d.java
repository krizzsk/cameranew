package com.facebook.imagepipeline.common;

import com.facebook.common.internal.h;
import javax.annotation.Nullable;
/* compiled from: ResizeOptions.java */
/* loaded from: classes.dex */
public class d {
    public final int a;
    public final int b;
    public final float c;

    /* renamed from: d  reason: collision with root package name */
    public final float f2718d;

    public d(int i2, int i3) {
        this(i2, i3, 2048.0f);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            return this.a == dVar.a && this.b == dVar.b;
        }
        return false;
    }

    public int hashCode() {
        return com.facebook.common.util.a.a(this.a, this.b);
    }

    public String toString() {
        return String.format(null, "%dx%d", Integer.valueOf(this.a), Integer.valueOf(this.b));
    }

    public d(int i2, int i3, float f2) {
        this(i2, i3, f2, 0.6666667f);
    }

    public d(int i2, int i3, float f2, float f3) {
        h.b(Boolean.valueOf(i2 > 0));
        h.b(Boolean.valueOf(i3 > 0));
        this.a = i2;
        this.b = i3;
        this.c = f2;
        this.f2718d = f3;
    }
}
