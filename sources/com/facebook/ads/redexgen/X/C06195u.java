package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.5u  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C06195u {
    public static boolean A04;
    public static byte[] A05;
    public static final String A06;
    public final C06205v A00;
    public final C06215w A01;
    public final XS A02;
    public final R4 A03;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 114);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{46, 56, 19, 41, 52, 56, 62, 45, 63};
    }

    static {
        A01();
        A06 = C06195u.class.getSimpleName();
    }

    public C06195u(XS xs, GC gc, C06205v c06205v, C06215w c06215w) {
        this.A02 = xs;
        this.A03 = gc.A4M(R5.A06);
        this.A00 = c06205v;
        this.A01 = c06215w;
        this.A03.A3E(new C1416am(this));
        A02();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void A02() {
        if (C0974Kn.A02(this)) {
            return;
        }
        if (!this.A03.A8U()) {
            this.A02.A03().A8H();
            return;
        }
        String optString = this.A03.A6F().optString(A00(0, 9, 62));
        if (!TextUtils.isEmpty(optString)) {
            this.A00.A04(this.A02, optString);
            if (!A04 || JD.A0g(this.A02)) {
                A04 = true;
                this.A01.A07();
            }
        }
    }
}
