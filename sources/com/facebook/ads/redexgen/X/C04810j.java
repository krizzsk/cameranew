package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
/* renamed from: com.facebook.ads.redexgen.X.0j  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C04810j {
    public static byte[] A00;
    public static String[] A01 = {"4Fi3cRKjKwjo", "pfwDmZC0EgnSHGG3akphHDiSxRpjxWfc", "OwKyFlCBYoW0NHpoiuFf2exuC", "FTixXnraWBf7yQ9sseM6khJqknPB2", "87lno6sBf8EnLpq9v2WrftgOrdI4V", "hcLSbPhFObKmfxN2jEGb0Jf71EM4", "MV7VLhl", "AE1L1nhQpeYYJvXkfFkincgpQRIdvuit"};

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 56);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{101, 64, 4, 77, 87, 4, 77, 74, 82, 69, 72, 77, 64, 69, 80, 65, 64, 4, 83, 77, 80, 76, 75, 81, 80, 4, 80, 75, 79, 65, 74, 10, 10, 27, 2};
    }

    static {
        A02();
    }

    /* JADX WARN: Incorrect condition in loop: B:9:0x0014 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.Collection<java.lang.String> A01(org.json.JSONArray r3) {
        /*
            if (r3 == 0) goto L8
            int r0 = r3.length()
            if (r0 != 0) goto La
        L8:
            r0 = 0
            return r0
        La:
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
            r1 = 0
        L10:
            int r0 = r3.length()
            if (r1 >= r0) goto L20
            java.lang.String r0 = r3.optString(r1)
            r2.add(r0)
            int r1 = r1 + 1
            goto L10
        L20:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C04810j.A01(org.json.JSONArray):java.util.Collection");
    }

    public static boolean A03(XT xt, InterfaceC04800i interfaceC04800i, JT jt) {
        EnumC04790h A6l = interfaceC04800i.A6l();
        if (A6l == null || A6l == EnumC04790h.A03) {
            return false;
        }
        boolean z = false;
        Collection<String> A6K = interfaceC04800i.A6K();
        if (A6K == null || A6K.isEmpty()) {
            return false;
        }
        Iterator<String> it = A6K.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String packageName = it.next();
            if (C0989Lf.A04(xt, packageName)) {
                z = true;
                break;
            }
        }
        if (z != (A6l == EnumC04790h.A02)) {
            return false;
        }
        String A61 = interfaceC04800i.A61();
        boolean isEmpty = TextUtils.isEmpty(A61);
        String[] strArr = A01;
        if (strArr[7].charAt(25) != strArr[1].charAt(25)) {
            throw new RuntimeException();
        }
        A01[2] = "Y0XUyINdugWnNFuKX72emGLWk";
        if (!isEmpty) {
            jt.A8w(A61, null);
            return true;
        }
        InterfaceC06798l A06 = xt.A06();
        int i2 = C06808m.A0R;
        String packageName2 = A00(0, 32, 28);
        C06818n c06818n = new C06818n(packageName2);
        String packageName3 = A00(32, 3, 83);
        A06.A8q(packageName3, i2, c06818n);
        return true;
    }
}
