package com.facebook.imagepipeline.common;

import androidx.annotation.Nullable;
/* compiled from: RotationOptions.java */
/* loaded from: classes.dex */
public class e {
    private static final e c = new e(-1, false);

    /* renamed from: d  reason: collision with root package name */
    private static final e f2719d = new e(-1, true);
    private final int a;
    private final boolean b;

    private e(int i2, boolean z) {
        this.a = i2;
        this.b = z;
    }

    public static e a() {
        return c;
    }

    public static e b() {
        return f2719d;
    }

    public boolean c() {
        return this.b;
    }

    public int d() {
        if (!f()) {
            return this.a;
        }
        throw new IllegalStateException("Rotation is set to use EXIF");
    }

    public boolean e() {
        return this.a != -2;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            return this.a == eVar.a && this.b == eVar.b;
        }
        return false;
    }

    public boolean f() {
        return this.a == -1;
    }

    public int hashCode() {
        return com.facebook.common.util.a.c(Integer.valueOf(this.a), Boolean.valueOf(this.b));
    }

    public String toString() {
        return String.format(null, "%d defer:%b", Integer.valueOf(this.a), Boolean.valueOf(this.b));
    }
}
