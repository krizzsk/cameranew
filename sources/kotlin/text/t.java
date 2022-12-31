package kotlin.text;

import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.h0;
/* compiled from: StringsJVM.kt */
/* loaded from: classes3.dex */
public class t extends s {
    public static boolean l(String str, String suffix, boolean z) {
        kotlin.jvm.internal.s.h(str, "<this>");
        kotlin.jvm.internal.s.h(suffix, "suffix");
        if (!z) {
            return str.endsWith(suffix);
        }
        return q(str, str.length() - suffix.length(), suffix, 0, suffix.length(), true);
    }

    public static /* synthetic */ boolean m(String str, String str2, boolean z, int i2, Object obj) {
        boolean l2;
        if ((i2 & 2) != 0) {
            z = false;
        }
        l2 = l(str, str2, z);
        return l2;
    }

    public static boolean n(String str, String str2, boolean z) {
        if (str == null) {
            return str2 == null;
        } else if (!z) {
            return str.equals(str2);
        } else {
            return str.equalsIgnoreCase(str2);
        }
    }

    public static /* synthetic */ boolean o(String str, String str2, boolean z, int i2, Object obj) {
        boolean n;
        if ((i2 & 2) != 0) {
            z = false;
        }
        n = n(str, str2, z);
        return n;
    }

    public static boolean p(CharSequence charSequence) {
        kotlin.z.d I;
        boolean z;
        kotlin.jvm.internal.s.h(charSequence, "<this>");
        if (charSequence.length() != 0) {
            I = StringsKt__StringsKt.I(charSequence);
            if (!(I instanceof Collection) || !((Collection) I).isEmpty()) {
                Iterator<Integer> it = I.iterator();
                while (it.hasNext()) {
                    if (!b.c(charSequence.charAt(((h0) it).nextInt()))) {
                        z = false;
                        break;
                    }
                }
            }
            z = true;
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public static final boolean q(String str, int i2, String other, int i3, int i4, boolean z) {
        kotlin.jvm.internal.s.h(str, "<this>");
        kotlin.jvm.internal.s.h(other, "other");
        if (!z) {
            return str.regionMatches(i2, other, i3, i4);
        }
        return str.regionMatches(z, i2, other, i3, i4);
    }

    public static String r(CharSequence charSequence, int i2) {
        kotlin.jvm.internal.s.h(charSequence, "<this>");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i2 + '.').toString());
        } else if (i2 != 0) {
            if (i2 != 1) {
                int length = charSequence.length();
                if (length != 0) {
                    if (length != 1) {
                        StringBuilder sb = new StringBuilder(charSequence.length() * i2);
                        h0 it = new kotlin.z.d(1, i2).iterator();
                        while (it.hasNext()) {
                            it.nextInt();
                            sb.append(charSequence);
                        }
                        String sb2 = sb.toString();
                        kotlin.jvm.internal.s.g(sb2, "{\n                    va…tring()\n                }");
                        return sb2;
                    }
                    char charAt = charSequence.charAt(0);
                    char[] cArr = new char[i2];
                    for (int i3 = 0; i3 < i2; i3++) {
                        cArr[i3] = charAt;
                    }
                    return new String(cArr);
                }
                return "";
            }
            return charSequence.toString();
        } else {
            return "";
        }
    }

    public static final String s(String str, char c, char c2, boolean z) {
        kotlin.jvm.internal.s.h(str, "<this>");
        if (!z) {
            String replace = str.replace(c, c2);
            kotlin.jvm.internal.s.g(replace, "this as java.lang.String…replace(oldChar, newChar)");
            return replace;
        }
        StringBuilder sb = new StringBuilder(str.length());
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (c.d(charAt, c, z)) {
                charAt = c2;
            }
            sb.append(charAt);
        }
        String sb2 = sb.toString();
        kotlin.jvm.internal.s.g(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public static String t(String str, String oldValue, String newValue, boolean z) {
        int L;
        int a;
        kotlin.jvm.internal.s.h(str, "<this>");
        kotlin.jvm.internal.s.h(oldValue, "oldValue");
        kotlin.jvm.internal.s.h(newValue, "newValue");
        int i2 = 0;
        L = StringsKt__StringsKt.L(str, oldValue, 0, z);
        if (L < 0) {
            return str;
        }
        int length = oldValue.length();
        a = kotlin.z.j.a(length, 1);
        int length2 = (str.length() - length) + newValue.length();
        if (length2 >= 0) {
            StringBuilder sb = new StringBuilder(length2);
            do {
                sb.append((CharSequence) str, i2, L);
                sb.append(newValue);
                i2 = L + length;
                if (L >= str.length()) {
                    break;
                }
                L = StringsKt__StringsKt.L(str, oldValue, L + a, z);
            } while (L > 0);
            sb.append((CharSequence) str, i2, str.length());
            String sb2 = sb.toString();
            kotlin.jvm.internal.s.g(sb2, "stringBuilder.append(this, i, length).toString()");
            return sb2;
        }
        throw new OutOfMemoryError();
    }

    public static /* synthetic */ String u(String str, char c, char c2, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return s(str, c, c2, z);
    }

    public static /* synthetic */ String v(String str, String str2, String str3, boolean z, int i2, Object obj) {
        String t;
        if ((i2 & 4) != 0) {
            z = false;
        }
        t = t(str, str2, str3, z);
        return t;
    }

    public static final boolean w(String str, String prefix, boolean z) {
        kotlin.jvm.internal.s.h(str, "<this>");
        kotlin.jvm.internal.s.h(prefix, "prefix");
        if (!z) {
            return str.startsWith(prefix);
        }
        return q(str, 0, prefix, 0, prefix.length(), z);
    }

    public static /* synthetic */ boolean x(String str, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return w(str, str2, z);
    }
}
