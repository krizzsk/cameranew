package com.facebook.imagepipeline.common;

import com.facebook.common.internal.h;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
/* compiled from: BytesRange.java */
@Immutable
/* loaded from: classes.dex */
public class a {
    public final int a;
    public final int b;

    public a(int i2, int i3) {
        this.a = i2;
        this.b = i3;
    }

    public static a b(int i2) {
        h.b(Boolean.valueOf(i2 >= 0));
        return new a(i2, Integer.MAX_VALUE);
    }

    public static a c(int i2) {
        h.b(Boolean.valueOf(i2 > 0));
        return new a(0, i2);
    }

    private static String d(int i2) {
        return i2 == Integer.MAX_VALUE ? "" : Integer.toString(i2);
    }

    public boolean a(@Nullable a aVar) {
        return aVar != null && this.a <= aVar.a && this.b >= aVar.b;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return this.a == aVar.a && this.b == aVar.b;
        }
        return false;
    }

    public int hashCode() {
        return com.facebook.common.util.a.a(this.a, this.b);
    }

    public String toString() {
        return String.format(null, "%s-%s", d(this.a), d(this.b));
    }
}
