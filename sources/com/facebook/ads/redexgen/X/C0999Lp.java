package com.facebook.ads.redexgen.X;

import android.content.Context;
import androidx.annotation.Nullable;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* renamed from: com.facebook.ads.redexgen.X.Lp  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0999Lp {
    public static byte[] A00;
    public static final Pattern A01;

    public static String A02(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 124);
        }
        return new String(copyOfRange);
    }

    public static void A07() {
        A00 = new byte[]{89, 45, 2, 90, 16, 5, 45, 2, 90, 42, 16, 92, 11, 95, 44, 90, 88, 42, 48, 92, 43, 44, 95, 91, 120, 78, 73, 73, 94, 85, 79, 27, 72, 79, 90, 88, 80, 27, 79, 73, 90, 88, 94, 33, 45, 47, 108, 36, 35, 33, 39, 32, 45, 45, 41, 108, 35, 38, 49};
    }

    static {
        A07();
        A01 = Pattern.compile(A02(0, 24, 13));
    }

    public static String A00() {
        return A06(new Exception(A02(24, 19, 71)), -1, -1, false);
    }

    public static String A01(int i2) {
        if (i2 <= 0) {
            return null;
        }
        float rate = i2;
        if (new Random().nextFloat() >= 1.0f / rate) {
            return null;
        }
        return A00();
    }

    public static String A03(Context context, @Nullable Throwable th) {
        return A06(th, JD.A0G(context), JD.A01(context), JD.A11(context));
    }

    public static String A04(String str) {
        Matcher matcher = A01.matcher(str);
        if (matcher.matches()) {
            return matcher.group(1);
        }
        return str;
    }

    public static String A06(@Nullable Throwable th, int i2, int i3, boolean z) {
        String A02 = A02(0, 0, 122);
        if (th == null) {
            return A02;
        }
        try {
            TO to = new TO();
            InterfaceC0997Ln interfaceC0997Ln = to;
            if (i3 >= 0) {
                interfaceC0997Ln = new TM(interfaceC0997Ln, i3);
            }
            if (i2 >= 0) {
                interfaceC0997Ln = new TL(interfaceC0997Ln, i2, i2);
            }
            if (z) {
                interfaceC0997Ln = new TN(interfaceC0997Ln);
            }
            TP tp = new TP(to, 1, interfaceC0997Ln);
            th.printStackTrace(new PrintWriter(new C0998Lo(tp)));
            tp.flush();
            return to.toString();
        } catch (Exception unused) {
            return A02;
        }
    }

    public static boolean A08(C0996Lm c0996Lm) {
        String A02 = c0996Lm.A02();
        if (A02 == null) {
            return false;
        }
        if (A0A(A02)) {
            return true;
        }
        for (String str : c0996Lm.A01()) {
            if (A0A(str)) {
                return true;
            }
        }
        for (String str2 : c0996Lm.A00()) {
            if (A0A(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean A0A(String str) {
        return str.contains(A02(43, 16, 62));
    }
}
