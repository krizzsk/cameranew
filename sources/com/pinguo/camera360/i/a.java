package com.pinguo.camera360.i;

import com.pinguo.camera360.vip.VipManager;
import java.util.Iterator;
import kotlin.collections.h0;
import kotlin.jvm.internal.s;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.t;
import kotlin.z.d;
/* compiled from: ProductPriceUtil.kt */
/* loaded from: classes3.dex */
public final class a {
    public static final String a(String sku, String yearStr) {
        String valueOf;
        d I;
        CharSequence j0;
        s.h(sku, "sku");
        s.h(yearStr, "yearStr");
        float t = VipManager.a.t(sku);
        float f2 = t / 12;
        if (!(f2 % ((float) 1) == 0.0f)) {
            valueOf = String.valueOf(((int) (f2 * 100)) / 100.0f);
        } else {
            valueOf = String.valueOf(f2);
        }
        String str = valueOf;
        I = StringsKt__StringsKt.I(yearStr);
        Iterator<Integer> it = I.iterator();
        String str2 = "";
        int i2 = -1;
        int i3 = -1;
        while (it.hasNext()) {
            int nextInt = ((h0) it).nextInt();
            if (Character.isDigit(yearStr.charAt(nextInt))) {
                if (i3 == -1) {
                    i3 = nextInt;
                }
                str2 = s.q(str2, Character.valueOf(yearStr.charAt(nextInt)));
                i2 = nextInt;
            }
        }
        int i4 = i2 + 1;
        String substring = yearStr.substring(i3, i4);
        s.g(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        if (substring.length() >= 3) {
            String substring2 = substring.substring(substring.length() - 3, substring.length() - 2);
            s.g(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
            if (s.c(substring2, ",")) {
                if (Float.parseFloat(str2) == t * ((float) 100)) {
                    str = t.v(str, ".", ",", false, 4, null);
                }
            }
        }
        j0 = StringsKt__StringsKt.j0(yearStr, i3, i4, str);
        return j0.toString();
    }
}
