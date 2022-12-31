package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
/* renamed from: com.facebook.ads.redexgen.X.Qx  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1134Qx {
    @Nullable
    public static InterfaceC1114Qd A00;
    public static byte[] A01;
    public static String[] A02 = {"b", "jWWIi2TrnHAAyoG5itvaKpzBpE6rwsKb", "4piz2zd6PBPCOA5LKuru6huyc0Gk9hmI", "ThWxRwfxtMClt6xxWNEGrvPqHoOGiBgN", "VC0ltrZe3ujZ5yBmE9F34w5pTHRf8GMT", "g0Z7XyqsbnnTrD4DkPgr08gcmreNHhpx", "VVYGWntGozQ2sTcwE1XxLnyTeGzWkyyX", "XVqTwdXEkxL4UUDwn3dakWK60VTsxJd5"};
    public static final Set<String> A03;
    public static final Set<String> A04;
    public static final AtomicBoolean A05;

    public static String A05(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 56);
        }
        return new String(copyOfRange);
    }

    public static void A07() {
        A01 = new byte[]{36, 121, 104, 23, 81, 81, 30, 99, 22, 103, Byte.MAX_VALUE, 85, 116, 20, 73, 126, 19, 74, 72, 66, 77, 20, 78, 81, 86, 20, 115, 73, 85, 77, 27, 44, 9, 86, 113, 76, 80, 116, 73, 92, 87, 72, 84, 17, 109, 87, 92, 126, 82, 76, 72, 8, 83, 108, 82, 21, 67, 104, 73, 7, 48, 14, 124, 116, 29, 56, 9, 120, 53, 0, 15, 40, 32, 37, 120, 62, 60, 56, 53, 61, Draft_75.CR, 9, 47, 54, 20, 3, 41, Draft_75.CR, 113, 70, 1, 42, 59, 56, 32, 61, 36, 38, 33, 40, 111, 45, 42, 41, 32, 61, 42, 111, 38, 33, 38, 59, 110, 125, Byte.MAX_VALUE, 125, 108, 19, 68, 75, Byte.MAX_VALUE, 71, 65, 110, 67, 14, 81, 68, 112, 119, 65, 75, 92, 112, 109, 16, 76, 85, 66, 104, 24, 47, 72, 64, 91, 89, 69, 72, 71, 76, 118, 68, 70, 77, 76, 118, 70, 71, 57, 50, 35, 32, 56, 37, 60, 29, 6, 51, 91, 46, 59, 7, 59, 3, 42, 80, 57, 92, 63, 63, 60, Draft_75.CR, 42, 25, 38, 27, 47, 33, 81, 5, 15, 56, 84, 99};
    }

    static {
        A07();
        A03 = new HashSet();
        A04 = new HashSet();
        A03.add(A05(3, 29, 30));
        A04.add(A05(165, 29, 81));
        A04.add(A05(32, 29, 2));
        A04.add(A05(61, 29, 116));
        A04.add(A05(113, 29, 29));
        A05 = new AtomicBoolean();
    }

    public static InterfaceC1116Qf A00(C8J c8j) {
        return A03(true, c8j);
    }

    public static InterfaceC1116Qf A01(C8J c8j) {
        return A02(true, c8j);
    }

    public static InterfaceC1116Qf A02(boolean z, C8J c8j) {
        C1120Qj c1120Qj = new C1120Qj();
        C1123Qm A042 = A04(c8j);
        if (!A0B(c8j)) {
            c1120Qj.A02(A04);
            c1120Qj.A01(A03);
        }
        if (LJ.A04()) {
            Map<String, String> A022 = LJ.A02();
            String[] strArr = A02;
            if (strArr[2].charAt(7) == strArr[1].charAt(7)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[5] = "6CjO7LbqJIONUadrRHmx0RuGBypxStir";
            strArr2[3] = "VKsjD9ddp6JrHwn0FL0Df9QGs7RhJ4JT";
            A042.A08(A022);
        }
        return AbstractC1118Qh.A00().A01(c1120Qj.A00(A042.A09()).A03(z).A04(c8j.A03().A8H()).A05(), c8j.A06(), MA.A01());
    }

    public static InterfaceC1116Qf A03(boolean z, C8J c8j) {
        return AbstractC1118Qh.A00().A01(new C1120Qj().A03(z).A00(A04(c8j).A09()).A04(c8j.A03().A8H()).A05(), c8j.A06(), MA.A01());
    }

    public static C1123Qm A04(C8J c8j) {
        A08(c8j);
        C1123Qm c1123Qm = new C1123Qm();
        if (A0B(c8j)) {
            c1123Qm.A02(360000).A04(120000);
        } else {
            int A07 = JD.A07(c8j);
            if (A02[4].charAt(20) == 'k') {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[2] = "dD0oPHmij4s2ObzR7OPOejAtm2pYkwQj";
            strArr[1] = "6BD1tyrnooF6YeHGpiFkkFGNAjU2pFFN";
            c1123Qm.A02(A07);
        }
        c1123Qm.A03(JD.A08(c8j)).A04(JD.A09(c8j)).A05(JD.A0A(c8j)).A06(JD.A0B(c8j));
        synchronized (C1134Qx.class) {
            if (A00 != null && (A00 instanceof InterfaceC1114Qd)) {
                c1123Qm.A07(A00);
            }
        }
        return c1123Qm;
    }

    public static void A06() {
        A05.set(true);
    }

    public static void A08(C8J c8j) {
        if (!A05.get()) {
            c8j.A06().A8q(A05(158, 7, 111), C06808m.A1o, new C06818n(A05(90, 23, 119)));
        }
    }

    public static synchronized void A09(InterfaceC1114Qd interfaceC1114Qd) {
        synchronized (C1134Qx.class) {
            A00 = interfaceC1114Qd;
        }
    }

    public static boolean A0A(C8J c8j) {
        int i2 = Build.VERSION.SDK_INT;
        String A052 = A05(142, 16, 17);
        if (i2 < 17) {
            return Settings.System.getInt(c8j.getContentResolver(), A052, 0) != 0;
        }
        int i3 = Settings.Global.getInt(c8j.getContentResolver(), A052, 0);
        if (A02[0].length() != 1) {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[2] = "6SlcDzdssqL5L6jmaJN4q0YtRJ9ZiIN0";
        strArr[1] = "IhCDgNyX5tEXKuNPsF1SGphg5lyX1n5g";
        return i3 != 0;
    }

    public static boolean A0B(C8J c8j) {
        String urlPrefix = c8j.A03().A7e();
        return !TextUtils.isEmpty(urlPrefix) && urlPrefix.endsWith(A05(0, 3, 50));
    }
}
