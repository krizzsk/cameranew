package com.facebook.ads.redexgen.X;

import android.app.KeyguardManager;
import android.content.Context;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Ys  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1334Ys extends C06266b {
    public static byte[] A01;
    public final KeyguardManager A00;

    static {
        A03();
    }

    public static String A02(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 7);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A01 = new byte[]{-57, -63, -43, -61, -47, -67, -50, -64};
    }

    public C1334Ys(Context context, AnonymousClass61 anonymousClass61) {
        super(context, anonymousClass61);
        this.A00 = (KeyguardManager) context.getSystemService(A02(0, 8, 85));
    }

    public final InterfaceC06356k A0G() {
        return new C1338Yw(this);
    }

    public final InterfaceC06356k A0H() {
        return new C1337Yv(this);
    }

    public final InterfaceC06356k A0I() {
        return new C1336Yu(this);
    }

    public final InterfaceC06356k A0J() {
        return new C1335Yt(this);
    }
}
