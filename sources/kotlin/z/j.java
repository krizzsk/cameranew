package kotlin.z;

import java.util.NoSuchElementException;
import kotlin.jvm.internal.s;
import kotlin.random.Random;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _Ranges.kt */
/* loaded from: classes3.dex */
public class j extends i {
    public static int a(int i2, int i3) {
        return i2 < i3 ? i3 : i2;
    }

    public static long b(long j2, long j3) {
        return j2 < j3 ? j3 : j2;
    }

    public static int c(int i2, int i3) {
        return i2 > i3 ? i3 : i2;
    }

    public static long d(long j2, long j3) {
        return j2 > j3 ? j3 : j2;
    }

    public static int e(int i2, int i3, int i4) {
        if (i3 <= i4) {
            return i2 < i3 ? i3 : i2 > i4 ? i4 : i2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i4 + " is less than minimum " + i3 + '.');
    }

    public static b f(int i2, int i3) {
        return b.f8689d.a(i2, i3, -1);
    }

    public static int g(d dVar, Random random) {
        s.h(dVar, "<this>");
        s.h(random, "random");
        try {
            return kotlin.random.d.f(random, dVar);
        } catch (IllegalArgumentException e2) {
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    public static d h(int i2, int i3) {
        if (i3 <= Integer.MIN_VALUE) {
            return d.f8691e.a();
        }
        return new d(i2, i3 - 1);
    }
}
