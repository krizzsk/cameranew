package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class YM extends C06266b {
    public static byte[] A01;
    public final PowerManager A00;

    static {
        A03();
    }

    public static String A02(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 14);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A01 = new byte[]{101, 122, 98, 112, 103};
    }

    public YM(Context context, AnonymousClass61 anonymousClass61) {
        super(context, anonymousClass61);
        this.A00 = (PowerManager) context.getSystemService(A02(0, 5, 27));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"DeprecatedMethod"})
    public boolean A04() {
        if (Build.VERSION.SDK_INT >= 20) {
            this.A00.isInteractive();
        }
        return this.A00.isScreenOn();
    }

    public final InterfaceC06356k A0G() {
        return new YO(this);
    }

    @TargetApi(20)
    public final InterfaceC06356k A0H() {
        return new YP(this);
    }

    public final InterfaceC06356k A0I() {
        return new YN(this);
    }
}
