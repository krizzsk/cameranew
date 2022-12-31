package kotlin.collections.builders;

import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.s;
/* compiled from: ListBuilder.kt */
/* loaded from: classes3.dex */
public final class b {
    public static final <E> E[] d(int i2) {
        if (i2 >= 0) {
            return (E[]) new Object[i2];
        }
        throw new IllegalArgumentException("capacity must be non-negative.".toString());
    }

    public static final <T> T[] e(T[] tArr, int i2) {
        s.h(tArr, "<this>");
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, i2);
        s.g(tArr2, "copyOf(this, newSize)");
        s.f(tArr2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.builders.ListBuilderKt.copyOfUninitializedElements>");
        return tArr2;
    }

    public static final <E> void f(E[] eArr, int i2) {
        s.h(eArr, "<this>");
        eArr[i2] = null;
    }

    public static final <E> void g(E[] eArr, int i2, int i3) {
        s.h(eArr, "<this>");
        while (i2 < i3) {
            f(eArr, i2);
            i2++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> boolean h(T[] tArr, int i2, int i3, List<?> list) {
        if (i3 != list.size()) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!s.c(tArr[i2 + i4], list.get(i4))) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> int i(T[] tArr, int i2, int i3) {
        int i4 = 1;
        for (int i5 = 0; i5 < i3; i5++) {
            T t = tArr[i2 + i5];
            i4 = (i4 * 31) + (t != null ? t.hashCode() : 0);
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> String j(T[] tArr, int i2, int i3) {
        StringBuilder sb = new StringBuilder((i3 * 3) + 2);
        sb.append("[");
        for (int i4 = 0; i4 < i3; i4++) {
            if (i4 > 0) {
                sb.append(", ");
            }
            sb.append(tArr[i2 + i4]);
        }
        sb.append("]");
        String sb2 = sb.toString();
        s.g(sb2, "sb.toString()");
        return sb2;
    }
}
