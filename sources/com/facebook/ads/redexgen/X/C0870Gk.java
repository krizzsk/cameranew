package com.facebook.ads.redexgen.X;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import java.util.Arrays;
import java.util.Map;
/* renamed from: com.facebook.ads.redexgen.X.Gk  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0870Gk {
    public static byte[] A00;
    public static String[] A01 = {"gehgTzpUAqg89EXiGGasdpNXUtk8k2dp", "VbYmpptfSIV8qdRodswF8V1n59zym7XK", "E44YX0wg", "TCU5yEG5ZIofchF4EQjDHlsQntmp46Yu", "EkmeYw2kQLbBECw2eANnaw7CzESY", "H", "OFssNajfj", "bi8IHmxX7dNFBPIWLmj9QBiFjZgAYPjN"};

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 92);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{60, 12, 11, 53, 27, 17, 49, 27, 17, 100, 31, 54, 99, 71, 15, 125, 51, 50, 98, 20};
    }

    static {
        A03();
    }

    public static C0874Go A00(C0874Go c0874Go, String[] strArr, Map<String, C0874Go> map) {
        if (c0874Go == null && strArr == null) {
            return null;
        }
        int i2 = 0;
        if (c0874Go == null && strArr.length == 1) {
            return map.get(strArr[0]);
        }
        if (c0874Go == null && strArr.length > 1) {
            C0874Go c0874Go2 = new C0874Go();
            int length = strArr.length;
            while (i2 < length) {
                String id = strArr[i2];
                c0874Go2.A0E(map.get(id));
                i2++;
            }
            return c0874Go2;
        } else if (c0874Go != null && strArr != null && strArr.length == 1) {
            return c0874Go.A0E(map.get(strArr[0]));
        } else {
            if (c0874Go != null && strArr != null && strArr.length > 1) {
                int length2 = strArr.length;
                while (i2 < length2) {
                    c0874Go.A0E(map.get(strArr[i2]));
                    i2++;
                }
                return c0874Go;
            }
            return c0874Go;
        }
    }

    public static String A02(String str) {
        String A012 = A01(0, 1, 106);
        String replaceAll = str.replaceAll(A01(1, 2, 93), A012).replaceAll(A01(4, 5, 103), A012);
        String A013 = A01(3, 1, 73);
        return replaceAll.replaceAll(A012, A013).replaceAll(A01(9, 11, 99), A013);
    }

    public static void A04(SpannableStringBuilder spannableStringBuilder) {
        int length = spannableStringBuilder.length() - 1;
        while (length >= 0 && spannableStringBuilder.charAt(length) == ' ') {
            length--;
        }
        if (length >= 0 && spannableStringBuilder.charAt(length) != '\n') {
            spannableStringBuilder.append('\n');
        }
    }

    public static void A05(SpannableStringBuilder spannableStringBuilder, int i2, int i3, C0874Go c0874Go) {
        if (c0874Go.A07() != -1) {
            spannableStringBuilder.setSpan(new StyleSpan(c0874Go.A07()), i2, i3, 33);
        }
        if (c0874Go.A0P()) {
            spannableStringBuilder.setSpan(new StrikethroughSpan(), i2, i3, 33);
        }
        if (c0874Go.A0Q()) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i2, i3, 33);
        }
        if (c0874Go.A0O()) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(c0874Go.A05()), i2, i3, 33);
        }
        if (c0874Go.A0N()) {
            spannableStringBuilder.setSpan(new BackgroundColorSpan(c0874Go.A04()), i2, i3, 33);
        }
        if (c0874Go.A0L() != null) {
            spannableStringBuilder.setSpan(new TypefaceSpan(c0874Go.A0L()), i2, i3, 33);
        }
        Layout.Alignment A08 = c0874Go.A08();
        String[] strArr = A01;
        if (strArr[0].charAt(0) == strArr[1].charAt(0)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[5] = "m";
        strArr2[2] = "ujiHtYdg";
        if (A08 != null) {
            spannableStringBuilder.setSpan(new AlignmentSpan.Standard(c0874Go.A08()), i2, i3, 33);
        }
        int A06 = c0874Go.A06();
        if (A06 == 1) {
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan((int) c0874Go.A03(), true), i2, i3, 33);
        } else if (A06 == 2) {
            spannableStringBuilder.setSpan(new RelativeSizeSpan(c0874Go.A03()), i2, i3, 33);
        } else if (A06 != 3) {
        } else {
            spannableStringBuilder.setSpan(new RelativeSizeSpan(c0874Go.A03() / 100.0f), i2, i3, 33);
        }
    }
}
