package kotlin.text;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Indent.kt */
/* loaded from: classes3.dex */
public class StringsKt__IndentKt extends m {
    private static final kotlin.jvm.b.l<String, String> b(String str) {
        return str.length() == 0 ? StringsKt__IndentKt$getIndentFunction$1.INSTANCE : new StringsKt__IndentKt$getIndentFunction$2(str);
    }

    private static final int c(String str) {
        int length = str.length();
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = -1;
                break;
            } else if (!b.c(str.charAt(i2))) {
                break;
            } else {
                i2++;
            }
        }
        return i2 == -1 ? str.length() : i2;
    }

    public static final String d(String str, String newIndent) {
        String L0;
        kotlin.jvm.internal.s.h(str, "<this>");
        kotlin.jvm.internal.s.h(newIndent, "newIndent");
        List<String> Y = StringsKt__StringsKt.Y(str);
        ArrayList<String> arrayList = new ArrayList();
        for (Object obj : Y) {
            if (!l.p((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(kotlin.collections.s.o(arrayList, 10));
        for (String str2 : arrayList) {
            arrayList2.add(Integer.valueOf(c(str2)));
        }
        Integer num = (Integer) kotlin.collections.s.N(arrayList2);
        int i2 = 0;
        int intValue = num != null ? num.intValue() : 0;
        int length = str.length() + (newIndent.length() * Y.size());
        kotlin.jvm.b.l<String, String> b = b(newIndent);
        int i3 = kotlin.collections.s.i(Y);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : Y) {
            int i4 = i2 + 1;
            String str3 = null;
            if (i2 >= 0) {
                String str4 = (String) obj2;
                if (((i2 != 0 && i2 != i3) || !l.p(str4)) && ((L0 = v.L0(str4, intValue)) == null || (str3 = b.invoke(L0)) == null)) {
                    str3 = str4;
                }
                if (str3 != null) {
                    arrayList3.add(str3);
                }
                i2 = i4;
            } else {
                kotlin.collections.s.n();
                throw null;
            }
        }
        StringBuilder sb = new StringBuilder(length);
        kotlin.collections.s.H(arrayList3, sb, "\n", null, null, 0, null, null, 124, null);
        String sb2 = sb.toString();
        kotlin.jvm.internal.s.g(sb2, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return sb2;
    }

    public static String e(String str) {
        kotlin.jvm.internal.s.h(str, "<this>");
        return d(str, "");
    }
}
