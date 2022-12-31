package kotlin.collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
/* compiled from: _ArraysJvm.kt */
/* loaded from: classes3.dex */
public class m extends l {
    public static <T> List<T> b(T[] tArr) {
        kotlin.jvm.internal.s.h(tArr, "<this>");
        List<T> a = o.a(tArr);
        kotlin.jvm.internal.s.g(a, "asList(this)");
        return a;
    }

    public static byte[] c(byte[] bArr, byte[] destination, int i2, int i3, int i4) {
        kotlin.jvm.internal.s.h(bArr, "<this>");
        kotlin.jvm.internal.s.h(destination, "destination");
        System.arraycopy(bArr, i3, destination, i2, i4 - i3);
        return destination;
    }

    public static float[] d(float[] fArr, float[] destination, int i2, int i3, int i4) {
        kotlin.jvm.internal.s.h(fArr, "<this>");
        kotlin.jvm.internal.s.h(destination, "destination");
        System.arraycopy(fArr, i3, destination, i2, i4 - i3);
        return destination;
    }

    public static <T> T[] e(T[] tArr, T[] destination, int i2, int i3, int i4) {
        kotlin.jvm.internal.s.h(tArr, "<this>");
        kotlin.jvm.internal.s.h(destination, "destination");
        System.arraycopy(tArr, i3, destination, i2, i4 - i3);
        return destination;
    }

    public static /* synthetic */ Object[] f(Object[] objArr, Object[] objArr2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = objArr.length;
        }
        e(objArr, objArr2, i2, i3, i4);
        return objArr2;
    }

    public static <T> T[] g(T[] tArr, int i2, int i3) {
        kotlin.jvm.internal.s.h(tArr, "<this>");
        k.a(i3, tArr.length);
        T[] tArr2 = (T[]) Arrays.copyOfRange(tArr, i2, i3);
        kotlin.jvm.internal.s.g(tArr2, "copyOfRange(this, fromIndex, toIndex)");
        return tArr2;
    }

    public static void h(int[] iArr, int i2, int i3, int i4) {
        kotlin.jvm.internal.s.h(iArr, "<this>");
        Arrays.fill(iArr, i3, i4, i2);
    }

    public static <T> void i(T[] tArr, T t, int i2, int i3) {
        kotlin.jvm.internal.s.h(tArr, "<this>");
        Arrays.fill(tArr, i2, i3, t);
    }

    public static /* synthetic */ void j(Object[] objArr, Object obj, int i2, int i3, int i4, Object obj2) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = objArr.length;
        }
        i(objArr, obj, i2, i3);
    }

    public static <T> void k(T[] tArr, Comparator<? super T> comparator) {
        kotlin.jvm.internal.s.h(tArr, "<this>");
        kotlin.jvm.internal.s.h(comparator, "comparator");
        if (tArr.length > 1) {
            Arrays.sort(tArr, comparator);
        }
    }
}
