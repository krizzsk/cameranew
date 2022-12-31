package kotlin.text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.h0;
import kotlin.sequences.SequencesKt___SequencesKt;
/* compiled from: Strings.kt */
/* loaded from: classes3.dex */
public class StringsKt__StringsKt extends t {

    /* compiled from: Strings.kt */
    /* loaded from: classes3.dex */
    public static final class a extends kotlin.collections.r {
        private int a;
        final /* synthetic */ CharSequence b;

        a(CharSequence charSequence) {
            this.b = charSequence;
        }

        @Override // kotlin.collections.r
        public char a() {
            CharSequence charSequence = this.b;
            int i2 = this.a;
            this.a = i2 + 1;
            return charSequence.charAt(i2);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a < this.b.length();
        }
    }

    public static boolean A(CharSequence charSequence, CharSequence other, boolean z) {
        int P;
        kotlin.jvm.internal.s.h(charSequence, "<this>");
        kotlin.jvm.internal.s.h(other, "other");
        if (other instanceof String) {
            P = P(charSequence, (String) other, 0, z, 2, null);
            if (P >= 0) {
                return true;
            }
        } else if (N(charSequence, other, 0, charSequence.length(), z, false, 16, null) >= 0) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ String A0(String str, char c, String str2, int i2, Object obj) {
        String z0;
        if ((i2 & 2) != 0) {
            str2 = str;
        }
        z0 = z0(str, c, str2);
        return z0;
    }

    public static /* synthetic */ boolean B(CharSequence charSequence, char c, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return z(charSequence, c, z);
    }

    public static final String B0(String str, char c, String missingDelimiterValue) {
        int O;
        kotlin.jvm.internal.s.h(str, "<this>");
        kotlin.jvm.internal.s.h(missingDelimiterValue, "missingDelimiterValue");
        O = O(str, c, 0, false, 6, null);
        if (O == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(0, O);
        kotlin.jvm.internal.s.g(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ boolean C(CharSequence charSequence, CharSequence charSequence2, boolean z, int i2, Object obj) {
        boolean A;
        if ((i2 & 2) != 0) {
            z = false;
        }
        A = A(charSequence, charSequence2, z);
        return A;
    }

    public static final String C0(String str, String delimiter, String missingDelimiterValue) {
        int P;
        kotlin.jvm.internal.s.h(str, "<this>");
        kotlin.jvm.internal.s.h(delimiter, "delimiter");
        kotlin.jvm.internal.s.h(missingDelimiterValue, "missingDelimiterValue");
        P = P(str, delimiter, 0, false, 6, null);
        if (P == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(0, P);
        kotlin.jvm.internal.s.g(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static final boolean D(CharSequence charSequence, char c, boolean z) {
        kotlin.jvm.internal.s.h(charSequence, "<this>");
        return charSequence.length() > 0 && c.d(charSequence.charAt(J(charSequence)), c, z);
    }

    public static /* synthetic */ String D0(String str, char c, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = str;
        }
        return B0(str, c, str2);
    }

    public static final boolean E(CharSequence charSequence, CharSequence suffix, boolean z) {
        boolean m;
        kotlin.jvm.internal.s.h(charSequence, "<this>");
        kotlin.jvm.internal.s.h(suffix, "suffix");
        if (!z && (charSequence instanceof String) && (suffix instanceof String)) {
            m = t.m((String) charSequence, (String) suffix, false, 2, null);
            return m;
        }
        return f0(charSequence, charSequence.length() - suffix.length(), suffix, 0, suffix.length(), z);
    }

    public static /* synthetic */ String E0(String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str3 = str;
        }
        return C0(str, str2, str3);
    }

    public static /* synthetic */ boolean F(CharSequence charSequence, char c, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return D(charSequence, c, z);
    }

    public static final String F0(String str, String delimiter, String missingDelimiterValue) {
        int V;
        kotlin.jvm.internal.s.h(str, "<this>");
        kotlin.jvm.internal.s.h(delimiter, "delimiter");
        kotlin.jvm.internal.s.h(missingDelimiterValue, "missingDelimiterValue");
        V = V(str, delimiter, 0, false, 6, null);
        if (V == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(0, V);
        kotlin.jvm.internal.s.g(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ boolean G(CharSequence charSequence, CharSequence charSequence2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return E(charSequence, charSequence2, z);
    }

    public static /* synthetic */ String G0(String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str3 = str;
        }
        return F0(str, str2, str3);
    }

    public static final Pair<Integer, String> H(CharSequence charSequence, Collection<String> collection, int i2, boolean z, boolean z2) {
        int c;
        kotlin.z.b f2;
        Object obj;
        Object obj2;
        int a2;
        if (!z && collection.size() == 1) {
            String str = (String) kotlin.collections.s.P(collection);
            int P = !z2 ? P(charSequence, str, i2, false, 4, null) : V(charSequence, str, i2, false, 4, null);
            if (P < 0) {
                return null;
            }
            return kotlin.k.a(Integer.valueOf(P), str);
        }
        if (z2) {
            c = kotlin.z.j.c(i2, J(charSequence));
            f2 = kotlin.z.j.f(c, 0);
        } else {
            a2 = kotlin.z.j.a(i2, 0);
            f2 = new kotlin.z.d(a2, charSequence.length());
        }
        if (charSequence instanceof String) {
            int a3 = f2.a();
            int b = f2.b();
            int c2 = f2.c();
            if ((c2 > 0 && a3 <= b) || (c2 < 0 && b <= a3)) {
                while (true) {
                    Iterator<T> it = collection.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj2 = null;
                            break;
                        }
                        obj2 = it.next();
                        String str2 = (String) obj2;
                        if (t.q(str2, 0, (String) charSequence, a3, str2.length(), z)) {
                            break;
                        }
                    }
                    String str3 = (String) obj2;
                    if (str3 == null) {
                        if (a3 == b) {
                            break;
                        }
                        a3 += c2;
                    } else {
                        return kotlin.k.a(Integer.valueOf(a3), str3);
                    }
                }
            }
        } else {
            int a4 = f2.a();
            int b2 = f2.b();
            int c3 = f2.c();
            if ((c3 > 0 && a4 <= b2) || (c3 < 0 && b2 <= a4)) {
                while (true) {
                    Iterator<T> it2 = collection.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it2.next();
                        String str4 = (String) obj;
                        if (f0(str4, 0, charSequence, a4, str4.length(), z)) {
                            break;
                        }
                    }
                    String str5 = (String) obj;
                    if (str5 == null) {
                        if (a4 == b2) {
                            break;
                        }
                        a4 += c3;
                    } else {
                        return kotlin.k.a(Integer.valueOf(a4), str5);
                    }
                }
            }
        }
        return null;
    }

    public static CharSequence H0(CharSequence charSequence) {
        kotlin.jvm.internal.s.h(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean c = b.c(charSequence.charAt(!z ? i2 : length));
            if (z) {
                if (!c) {
                    break;
                }
                length--;
            } else if (c) {
                i2++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(i2, length + 1);
    }

    public static kotlin.z.d I(CharSequence charSequence) {
        kotlin.jvm.internal.s.h(charSequence, "<this>");
        return new kotlin.z.d(0, charSequence.length() - 1);
    }

    public static CharSequence I0(CharSequence charSequence) {
        kotlin.jvm.internal.s.h(charSequence, "<this>");
        int length = charSequence.length() - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                if (!b.c(charSequence.charAt(length))) {
                    return charSequence.subSequence(0, length + 1);
                }
                if (i2 < 0) {
                    break;
                }
                length = i2;
            }
        }
        return "";
    }

    public static final int J(CharSequence charSequence) {
        kotlin.jvm.internal.s.h(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static CharSequence J0(CharSequence charSequence, char... chars) {
        boolean l2;
        kotlin.jvm.internal.s.h(charSequence, "<this>");
        kotlin.jvm.internal.s.h(chars, "chars");
        int length = charSequence.length() - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                l2 = kotlin.collections.n.l(chars, charSequence.charAt(length));
                if (!l2) {
                    return charSequence.subSequence(0, length + 1);
                }
                if (i2 < 0) {
                    break;
                }
                length = i2;
            }
        }
        return "";
    }

    public static final int K(CharSequence charSequence, char c, int i2, boolean z) {
        kotlin.jvm.internal.s.h(charSequence, "<this>");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(c, i2);
        }
        return Q(charSequence, new char[]{c}, i2, z);
    }

    public static String K0(String str, char... chars) {
        CharSequence charSequence;
        boolean l2;
        kotlin.jvm.internal.s.h(str, "<this>");
        kotlin.jvm.internal.s.h(chars, "chars");
        int length = str.length() - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                l2 = kotlin.collections.n.l(chars, str.charAt(length));
                if (!l2) {
                    charSequence = str.subSequence(0, length + 1);
                    break;
                } else if (i2 < 0) {
                    break;
                } else {
                    length = i2;
                }
            }
            return charSequence.toString();
        }
        charSequence = "";
        return charSequence.toString();
    }

    public static int L(CharSequence charSequence, String string, int i2, boolean z) {
        kotlin.jvm.internal.s.h(charSequence, "<this>");
        kotlin.jvm.internal.s.h(string, "string");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(string, i2);
        }
        return N(charSequence, string, i2, charSequence.length(), z, false, 16, null);
    }

    private static final int M(CharSequence charSequence, CharSequence charSequence2, int i2, int i3, boolean z, boolean z2) {
        int c;
        int a2;
        kotlin.z.b f2;
        int a3;
        int c2;
        if (!z2) {
            a3 = kotlin.z.j.a(i2, 0);
            c2 = kotlin.z.j.c(i3, charSequence.length());
            f2 = new kotlin.z.d(a3, c2);
        } else {
            c = kotlin.z.j.c(i2, J(charSequence));
            a2 = kotlin.z.j.a(i3, 0);
            f2 = kotlin.z.j.f(c, a2);
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int a4 = f2.a();
            int b = f2.b();
            int c3 = f2.c();
            if ((c3 <= 0 || a4 > b) && (c3 >= 0 || b > a4)) {
                return -1;
            }
            while (!t.q((String) charSequence2, 0, (String) charSequence, a4, charSequence2.length(), z)) {
                if (a4 == b) {
                    return -1;
                }
                a4 += c3;
            }
            return a4;
        }
        int a5 = f2.a();
        int b2 = f2.b();
        int c4 = f2.c();
        if ((c4 <= 0 || a5 > b2) && (c4 >= 0 || b2 > a5)) {
            return -1;
        }
        while (!f0(charSequence2, 0, charSequence, a5, charSequence2.length(), z)) {
            if (a5 == b2) {
                return -1;
            }
            a5 += c4;
        }
        return a5;
    }

    static /* synthetic */ int N(CharSequence charSequence, CharSequence charSequence2, int i2, int i3, boolean z, boolean z2, int i4, Object obj) {
        return M(charSequence, charSequence2, i2, i3, z, (i4 & 16) != 0 ? false : z2);
    }

    public static /* synthetic */ int O(CharSequence charSequence, char c, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return K(charSequence, c, i2, z);
    }

    public static /* synthetic */ int P(CharSequence charSequence, String str, int i2, boolean z, int i3, Object obj) {
        int L;
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        L = L(charSequence, str, i2, z);
        return L;
    }

    public static final int Q(CharSequence charSequence, char[] chars, int i2, boolean z) {
        int a2;
        boolean z2;
        char A;
        kotlin.jvm.internal.s.h(charSequence, "<this>");
        kotlin.jvm.internal.s.h(chars, "chars");
        if (!z && chars.length == 1 && (charSequence instanceof String)) {
            A = kotlin.collections.n.A(chars);
            return ((String) charSequence).indexOf(A, i2);
        }
        a2 = kotlin.z.j.a(i2, 0);
        h0 it = new kotlin.z.d(a2, J(charSequence)).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            char charAt = charSequence.charAt(nextInt);
            int length = chars.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    z2 = false;
                    continue;
                    break;
                } else if (c.d(chars[i3], charAt, z)) {
                    z2 = true;
                    continue;
                    break;
                } else {
                    i3++;
                }
            }
            if (z2) {
                return nextInt;
            }
        }
        return -1;
    }

    public static final kotlin.collections.r R(CharSequence charSequence) {
        kotlin.jvm.internal.s.h(charSequence, "<this>");
        return new a(charSequence);
    }

    public static final int S(CharSequence charSequence, char c, int i2, boolean z) {
        kotlin.jvm.internal.s.h(charSequence, "<this>");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(c, i2);
        }
        return W(charSequence, new char[]{c}, i2, z);
    }

    public static final int T(CharSequence charSequence, String string, int i2, boolean z) {
        kotlin.jvm.internal.s.h(charSequence, "<this>");
        kotlin.jvm.internal.s.h(string, "string");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(string, i2);
        }
        return M(charSequence, string, i2, 0, z, true);
    }

    public static /* synthetic */ int U(CharSequence charSequence, char c, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = J(charSequence);
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return S(charSequence, c, i2, z);
    }

    public static /* synthetic */ int V(CharSequence charSequence, String str, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = J(charSequence);
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return T(charSequence, str, i2, z);
    }

    public static final int W(CharSequence charSequence, char[] chars, int i2, boolean z) {
        int c;
        char A;
        kotlin.jvm.internal.s.h(charSequence, "<this>");
        kotlin.jvm.internal.s.h(chars, "chars");
        if (!z && chars.length == 1 && (charSequence instanceof String)) {
            A = kotlin.collections.n.A(chars);
            return ((String) charSequence).lastIndexOf(A, i2);
        }
        for (c = kotlin.z.j.c(i2, J(charSequence)); -1 < c; c--) {
            char charAt = charSequence.charAt(c);
            int length = chars.length;
            boolean z2 = false;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                } else if (c.d(chars[i3], charAt, z)) {
                    z2 = true;
                    break;
                } else {
                    i3++;
                }
            }
            if (z2) {
                return c;
            }
        }
        return -1;
    }

    public static final kotlin.sequences.e<String> X(CharSequence charSequence) {
        kotlin.jvm.internal.s.h(charSequence, "<this>");
        return r0(charSequence, new String[]{"\r\n", "\n", "\r"}, false, 0, 6, null);
    }

    public static final List<String> Y(CharSequence charSequence) {
        List<String> n;
        kotlin.jvm.internal.s.h(charSequence, "<this>");
        n = SequencesKt___SequencesKt.n(X(charSequence));
        return n;
    }

    public static final CharSequence Z(CharSequence charSequence, int i2, char c) {
        kotlin.jvm.internal.s.h(charSequence, "<this>");
        if (i2 >= 0) {
            if (i2 <= charSequence.length()) {
                return charSequence.subSequence(0, charSequence.length());
            }
            StringBuilder sb = new StringBuilder(i2);
            h0 it = new kotlin.z.d(1, i2 - charSequence.length()).iterator();
            while (it.hasNext()) {
                it.nextInt();
                sb.append(c);
            }
            sb.append(charSequence);
            return sb;
        }
        throw new IllegalArgumentException("Desired length " + i2 + " is less than zero.");
    }

    public static String a0(String str, int i2, char c) {
        kotlin.jvm.internal.s.h(str, "<this>");
        return Z(str, i2, c).toString();
    }

    private static final kotlin.sequences.e<kotlin.z.d> b0(CharSequence charSequence, char[] cArr, int i2, boolean z, int i3) {
        k0(i3);
        return new e(charSequence, i2, i3, new StringsKt__StringsKt$rangesDelimitedBy$1(cArr, z));
    }

    private static final kotlin.sequences.e<kotlin.z.d> c0(CharSequence charSequence, String[] strArr, int i2, boolean z, int i3) {
        List b;
        k0(i3);
        b = kotlin.collections.m.b(strArr);
        return new e(charSequence, i2, i3, new StringsKt__StringsKt$rangesDelimitedBy$2(b, z));
    }

    static /* synthetic */ kotlin.sequences.e d0(CharSequence charSequence, char[] cArr, int i2, boolean z, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        if ((i4 & 8) != 0) {
            i3 = 0;
        }
        return b0(charSequence, cArr, i2, z, i3);
    }

    static /* synthetic */ kotlin.sequences.e e0(CharSequence charSequence, String[] strArr, int i2, boolean z, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        if ((i4 & 8) != 0) {
            i3 = 0;
        }
        return c0(charSequence, strArr, i2, z, i3);
    }

    public static final boolean f0(CharSequence charSequence, int i2, CharSequence other, int i3, int i4, boolean z) {
        kotlin.jvm.internal.s.h(charSequence, "<this>");
        kotlin.jvm.internal.s.h(other, "other");
        if (i3 < 0 || i2 < 0 || i2 > charSequence.length() - i4 || i3 > other.length() - i4) {
            return false;
        }
        for (int i5 = 0; i5 < i4; i5++) {
            if (!c.d(charSequence.charAt(i2 + i5), other.charAt(i3 + i5), z)) {
                return false;
            }
        }
        return true;
    }

    public static String g0(String str, CharSequence prefix) {
        kotlin.jvm.internal.s.h(str, "<this>");
        kotlin.jvm.internal.s.h(prefix, "prefix");
        if (v0(str, prefix, false, 2, null)) {
            String substring = str.substring(prefix.length());
            kotlin.jvm.internal.s.g(substring, "this as java.lang.String).substring(startIndex)");
            return substring;
        }
        return str;
    }

    public static CharSequence h0(CharSequence charSequence, CharSequence suffix) {
        kotlin.jvm.internal.s.h(charSequence, "<this>");
        kotlin.jvm.internal.s.h(suffix, "suffix");
        if (G(charSequence, suffix, false, 2, null)) {
            return charSequence.subSequence(0, charSequence.length() - suffix.length());
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    public static String i0(String str, CharSequence suffix) {
        kotlin.jvm.internal.s.h(str, "<this>");
        kotlin.jvm.internal.s.h(suffix, "suffix");
        if (G(str, suffix, false, 2, null)) {
            String substring = str.substring(0, str.length() - suffix.length());
            kotlin.jvm.internal.s.g(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }
        return str;
    }

    public static CharSequence j0(CharSequence charSequence, int i2, int i3, CharSequence replacement) {
        kotlin.jvm.internal.s.h(charSequence, "<this>");
        kotlin.jvm.internal.s.h(replacement, "replacement");
        if (i3 >= i2) {
            StringBuilder sb = new StringBuilder();
            sb.append(charSequence, 0, i2);
            kotlin.jvm.internal.s.g(sb, "this.append(value, startIndex, endIndex)");
            sb.append(replacement);
            sb.append(charSequence, i3, charSequence.length());
            kotlin.jvm.internal.s.g(sb, "this.append(value, startIndex, endIndex)");
            return sb;
        }
        throw new IndexOutOfBoundsException("End index (" + i3 + ") is less than start index (" + i2 + ").");
    }

    public static final void k0(int i2) {
        if (i2 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2).toString());
    }

    public static final List<String> l0(CharSequence charSequence, char[] delimiters, boolean z, int i2) {
        Iterable<kotlin.z.d> g2;
        int o;
        kotlin.jvm.internal.s.h(charSequence, "<this>");
        kotlin.jvm.internal.s.h(delimiters, "delimiters");
        if (delimiters.length == 1) {
            return n0(charSequence, String.valueOf(delimiters[0]), z, i2);
        }
        g2 = SequencesKt___SequencesKt.g(d0(charSequence, delimiters, 0, z, i2, 2, null));
        o = kotlin.collections.v.o(g2, 10);
        ArrayList arrayList = new ArrayList(o);
        for (kotlin.z.d dVar : g2) {
            arrayList.add(w0(charSequence, dVar));
        }
        return arrayList;
    }

    public static final List<String> m0(CharSequence charSequence, String[] delimiters, boolean z, int i2) {
        Iterable<kotlin.z.d> g2;
        int o;
        kotlin.jvm.internal.s.h(charSequence, "<this>");
        kotlin.jvm.internal.s.h(delimiters, "delimiters");
        if (delimiters.length == 1) {
            String str = delimiters[0];
            if (!(str.length() == 0)) {
                return n0(charSequence, str, z, i2);
            }
        }
        g2 = SequencesKt___SequencesKt.g(e0(charSequence, delimiters, 0, z, i2, 2, null));
        o = kotlin.collections.v.o(g2, 10);
        ArrayList arrayList = new ArrayList(o);
        for (kotlin.z.d dVar : g2) {
            arrayList.add(w0(charSequence, dVar));
        }
        return arrayList;
    }

    private static final List<String> n0(CharSequence charSequence, String str, boolean z, int i2) {
        int L;
        List<String> e2;
        k0(i2);
        int i3 = 0;
        L = L(charSequence, str, 0, z);
        if (L != -1 && i2 != 1) {
            boolean z2 = i2 > 0;
            ArrayList arrayList = new ArrayList(z2 ? kotlin.z.j.c(i2, 10) : 10);
            do {
                arrayList.add(charSequence.subSequence(i3, L).toString());
                i3 = str.length() + L;
                if (z2 && arrayList.size() == i2 - 1) {
                    break;
                }
                L = L(charSequence, str, i3, z);
            } while (L != -1);
            arrayList.add(charSequence.subSequence(i3, charSequence.length()).toString());
            return arrayList;
        }
        e2 = kotlin.collections.t.e(charSequence.toString());
        return e2;
    }

    public static /* synthetic */ List o0(CharSequence charSequence, char[] cArr, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = false;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return l0(charSequence, cArr, z, i2);
    }

    public static /* synthetic */ List p0(CharSequence charSequence, String[] strArr, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = false;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return m0(charSequence, strArr, z, i2);
    }

    public static final kotlin.sequences.e<String> q0(CharSequence charSequence, String[] delimiters, boolean z, int i2) {
        kotlin.sequences.e<String> l2;
        kotlin.jvm.internal.s.h(charSequence, "<this>");
        kotlin.jvm.internal.s.h(delimiters, "delimiters");
        l2 = SequencesKt___SequencesKt.l(e0(charSequence, delimiters, 0, z, i2, 2, null), new StringsKt__StringsKt$splitToSequence$1(charSequence));
        return l2;
    }

    public static /* synthetic */ kotlin.sequences.e r0(CharSequence charSequence, String[] strArr, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = false;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return q0(charSequence, strArr, z, i2);
    }

    public static final boolean s0(CharSequence charSequence, char c, boolean z) {
        kotlin.jvm.internal.s.h(charSequence, "<this>");
        return charSequence.length() > 0 && c.d(charSequence.charAt(0), c, z);
    }

    public static final boolean t0(CharSequence charSequence, CharSequence prefix, boolean z) {
        boolean x;
        kotlin.jvm.internal.s.h(charSequence, "<this>");
        kotlin.jvm.internal.s.h(prefix, "prefix");
        if (!z && (charSequence instanceof String) && (prefix instanceof String)) {
            x = t.x((String) charSequence, (String) prefix, false, 2, null);
            return x;
        }
        return f0(charSequence, 0, prefix, 0, prefix.length(), z);
    }

    public static /* synthetic */ boolean u0(CharSequence charSequence, char c, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return s0(charSequence, c, z);
    }

    public static /* synthetic */ boolean v0(CharSequence charSequence, CharSequence charSequence2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return t0(charSequence, charSequence2, z);
    }

    public static final String w0(CharSequence charSequence, kotlin.z.d range) {
        kotlin.jvm.internal.s.h(charSequence, "<this>");
        kotlin.jvm.internal.s.h(range, "range");
        return charSequence.subSequence(range.getStart().intValue(), range.getEndInclusive().intValue() + 1).toString();
    }

    public static final String x0(String str, String delimiter, String missingDelimiterValue) {
        int P;
        kotlin.jvm.internal.s.h(str, "<this>");
        kotlin.jvm.internal.s.h(delimiter, "delimiter");
        kotlin.jvm.internal.s.h(missingDelimiterValue, "missingDelimiterValue");
        P = P(str, delimiter, 0, false, 6, null);
        if (P == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(P + delimiter.length(), str.length());
        kotlin.jvm.internal.s.g(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String y0(String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str3 = str;
        }
        return x0(str, str2, str3);
    }

    public static final boolean z(CharSequence charSequence, char c, boolean z) {
        int O;
        kotlin.jvm.internal.s.h(charSequence, "<this>");
        O = O(charSequence, c, 0, z, 2, null);
        return O >= 0;
    }

    public static String z0(String str, char c, String missingDelimiterValue) {
        int U;
        kotlin.jvm.internal.s.h(str, "<this>");
        kotlin.jvm.internal.s.h(missingDelimiterValue, "missingDelimiterValue");
        U = U(str, c, 0, false, 6, null);
        if (U == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(U + 1, str.length());
        kotlin.jvm.internal.s.g(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }
}
