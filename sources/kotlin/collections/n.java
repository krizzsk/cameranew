package kotlin.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
/* compiled from: _Arrays.kt */
/* loaded from: classes3.dex */
public class n extends m {
    public static char A(char[] cArr) {
        kotlin.jvm.internal.s.h(cArr, "<this>");
        int length = cArr.length;
        if (length != 0) {
            if (length == 1) {
                return cArr[0];
            }
            throw new IllegalArgumentException("Array has more than one element.");
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static <T> T B(T[] tArr) {
        kotlin.jvm.internal.s.h(tArr, "<this>");
        if (tArr.length == 1) {
            return tArr[0];
        }
        return null;
    }

    public static final <T> T[] C(T[] tArr, Comparator<? super T> comparator) {
        kotlin.jvm.internal.s.h(tArr, "<this>");
        kotlin.jvm.internal.s.h(comparator, "comparator");
        if (tArr.length == 0) {
            return tArr;
        }
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, tArr.length);
        kotlin.jvm.internal.s.g(tArr2, "copyOf(this, size)");
        m.k(tArr2, comparator);
        return tArr2;
    }

    public static <T> List<T> D(T[] tArr, Comparator<? super T> comparator) {
        List<T> b;
        kotlin.jvm.internal.s.h(tArr, "<this>");
        kotlin.jvm.internal.s.h(comparator, "comparator");
        b = m.b(C(tArr, comparator));
        return b;
    }

    public static <T> List<T> E(T[] tArr) {
        List<T> h2;
        List<T> e2;
        kotlin.jvm.internal.s.h(tArr, "<this>");
        int length = tArr.length;
        if (length == 0) {
            h2 = u.h();
            return h2;
        } else if (length != 1) {
            return F(tArr);
        } else {
            e2 = t.e(tArr[0]);
            return e2;
        }
    }

    public static final <T> List<T> F(T[] tArr) {
        kotlin.jvm.internal.s.h(tArr, "<this>");
        return new ArrayList(u.g(tArr));
    }

    public static boolean l(char[] cArr, char c) {
        kotlin.jvm.internal.s.h(cArr, "<this>");
        return u(cArr, c) >= 0;
    }

    public static <T> boolean m(T[] tArr, T t) {
        int v;
        kotlin.jvm.internal.s.h(tArr, "<this>");
        v = v(tArr, t);
        return v >= 0;
    }

    public static <T> List<T> n(T[] tArr) {
        kotlin.jvm.internal.s.h(tArr, "<this>");
        ArrayList arrayList = new ArrayList();
        o(tArr, arrayList);
        return arrayList;
    }

    public static final <C extends Collection<? super T>, T> C o(T[] tArr, C destination) {
        kotlin.jvm.internal.s.h(tArr, "<this>");
        kotlin.jvm.internal.s.h(destination, "destination");
        for (T t : tArr) {
            if (t != null) {
                destination.add(t);
            }
        }
        return destination;
    }

    public static <T> T p(T[] tArr) {
        kotlin.jvm.internal.s.h(tArr, "<this>");
        if (tArr.length == 0) {
            return null;
        }
        return tArr[0];
    }

    public static kotlin.z.d q(int[] iArr) {
        kotlin.jvm.internal.s.h(iArr, "<this>");
        return new kotlin.z.d(0, r(iArr));
    }

    public static final int r(int[] iArr) {
        kotlin.jvm.internal.s.h(iArr, "<this>");
        return iArr.length - 1;
    }

    public static <T> int s(T[] tArr) {
        kotlin.jvm.internal.s.h(tArr, "<this>");
        return tArr.length - 1;
    }

    public static <T> T t(T[] tArr, int i2) {
        int s;
        kotlin.jvm.internal.s.h(tArr, "<this>");
        if (i2 >= 0) {
            s = s(tArr);
            if (i2 <= s) {
                return tArr[i2];
            }
        }
        return null;
    }

    public static final int u(char[] cArr, char c) {
        kotlin.jvm.internal.s.h(cArr, "<this>");
        int length = cArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (c == cArr[i2]) {
                return i2;
            }
        }
        return -1;
    }

    public static <T> int v(T[] tArr, T t) {
        kotlin.jvm.internal.s.h(tArr, "<this>");
        int i2 = 0;
        if (t == null) {
            int length = tArr.length;
            while (i2 < length) {
                if (tArr[i2] == null) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }
        int length2 = tArr.length;
        while (i2 < length2) {
            if (kotlin.jvm.internal.s.c(t, tArr[i2])) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static final <T, A extends Appendable> A w(T[] tArr, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i2, CharSequence truncated, kotlin.jvm.b.l<? super T, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.s.h(tArr, "<this>");
        kotlin.jvm.internal.s.h(buffer, "buffer");
        kotlin.jvm.internal.s.h(separator, "separator");
        kotlin.jvm.internal.s.h(prefix, "prefix");
        kotlin.jvm.internal.s.h(postfix, "postfix");
        kotlin.jvm.internal.s.h(truncated, "truncated");
        buffer.append(prefix);
        int i3 = 0;
        for (T t : tArr) {
            i3++;
            if (i3 > 1) {
                buffer.append(separator);
            }
            if (i2 >= 0 && i3 > i2) {
                break;
            }
            kotlin.text.m.a(buffer, t, lVar);
        }
        if (i2 >= 0 && i3 > i2) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final <T> String x(T[] tArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i2, CharSequence truncated, kotlin.jvm.b.l<? super T, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.s.h(tArr, "<this>");
        kotlin.jvm.internal.s.h(separator, "separator");
        kotlin.jvm.internal.s.h(prefix, "prefix");
        kotlin.jvm.internal.s.h(postfix, "postfix");
        kotlin.jvm.internal.s.h(truncated, "truncated");
        StringBuilder sb = new StringBuilder();
        w(tArr, sb, separator, prefix, postfix, i2, truncated, lVar);
        String sb2 = sb.toString();
        kotlin.jvm.internal.s.g(sb2, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb2;
    }

    public static /* synthetic */ String y(Object[] objArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, kotlin.jvm.b.l lVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            charSequence = ", ";
        }
        String str = (i3 & 2) != 0 ? "" : charSequence2;
        String str2 = (i3 & 4) == 0 ? charSequence3 : "";
        int i4 = (i3 & 8) != 0 ? -1 : i2;
        if ((i3 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence5 = charSequence4;
        if ((i3 & 32) != 0) {
            lVar = null;
        }
        return x(objArr, charSequence, str, str2, i4, charSequence5, lVar);
    }

    public static <T extends Comparable<? super T>> T z(T[] tArr) {
        int s;
        kotlin.jvm.internal.s.h(tArr, "<this>");
        if (tArr.length == 0) {
            return null;
        }
        T t = tArr[0];
        s = s(tArr);
        h0 it = new kotlin.z.d(1, s).iterator();
        while (it.hasNext()) {
            T t2 = tArr[it.nextInt()];
            if (t.compareTo(t2) > 0) {
                t = t2;
            }
        }
        return t;
    }
}
