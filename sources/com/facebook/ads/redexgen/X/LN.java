package com.facebook.ads.redexgen.X;

import android.content.Context;
import com.facebook.ads.internal.settings.AdInternalSettings;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class LN {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 118);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{-60, -52, 8, Draft_75.CR, 23, 20, 16, 5, 29, 9, 8, -60, 10, 19, 22, -60, 24, 9, 23, 24, -60, 5, 8, 23, -60, 19, 18, 16, 29, -51};
    }

    public static void A02(Context context, String str) {
        if (AdInternalSettings.isTestMode(context)) {
            String str2 = str + A00(0, 30, 46);
        }
    }
}
