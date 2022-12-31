package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.Nullable;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
@TargetApi(21)
/* loaded from: assets/audience_network.dex */
public final class B1 {
    public static byte[] A02;
    public static final B1 A03;
    public final int A00;
    public final int[] A01;

    public static String A02(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 28);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A02 = new byte[]{-58, -70, Draft_75.CR, 15, 10, 10, 9, 12, 14, -1, -2, -33, 8, -3, 9, -2, 3, 8, 1, Draft_75.CR, -41, -75, -23, -40, -35, -29, -73, -43, -28, -43, -42, -35, -32, -35, -24, -35, -39, -25, -49, -31, -43, -20, -73, -36, -43, -30, -30, -39, -32, -73, -29, -23, -30, -24, -79, -72, -33, -20, -30, -16, -19, -25, -30, -84, -21, -29, -30, -25, -33, -84, -33, -31, -14, -25, -19, -20, -84, -58, -62, -53, -57, -35, -65, -45, -62, -57, -51, -35, -50, -54, -45, -59, -46, -33, -43, -29, -32, -38, -43, -97, -34, -42, -43, -38, -46, -97, -42, -23, -27, -29, -46, -97, -78, -58, -75, -70, -64, -48, -63, -67, -58, -72, -48, -60, -59, -78, -59, -74, -61, -48, -58, -44, -47, -53, -58, -112, -49, -57, -58, -53, -61, -112, -57, -38, -42, -44, -61, -112, -89, -80, -91, -79, -90, -85, -80, -87, -75, -39, -26, -36, -22, -25, -31, -36, -90, -27, -35, -36, -31, -39, -90, -35, -16, -20, -22, -39, -90, -59, -71, -48, -41, -69, -64, -71, -58, -58, -67, -60, -41, -69, -57, -51, -58, -52};
    }

    static {
        A03();
        A03 = new B1(new int[]{2}, 2);
    }

    public B1(int[] iArr, int i2) {
        if (iArr != null) {
            this.A01 = Arrays.copyOf(iArr, iArr.length);
            Arrays.sort(this.A01);
        } else {
            this.A01 = new int[0];
        }
        this.A00 = i2;
    }

    public static B1 A00(Context context) {
        return A01(context.registerReceiver(null, new IntentFilter(A02(56, 36, 98))));
    }

    @SuppressLint({"InlinedApi"})
    public static B1 A01(Intent intent) {
        if (intent == null || intent.getIntExtra(A02(92, 36, 85), 0) == 0) {
            return A03;
        }
        return new B1(intent.getIntArrayExtra(A02(128, 29, 70)), intent.getIntExtra(A02(157, 37, 92), 0));
    }

    public final boolean A04(int i2) {
        return Arrays.binarySearch(this.A01, i2) >= 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof B1) {
            B1 audioCapabilities = (B1) obj;
            return Arrays.equals(this.A01, audioCapabilities.A01) && this.A00 == audioCapabilities.A00;
        }
        return false;
    }

    public final int hashCode() {
        return this.A00 + (Arrays.hashCode(this.A01) * 31);
    }

    public final String toString() {
        return A02(21, 34, 88) + this.A00 + A02(0, 21, 126) + Arrays.toString(this.A01) + A02(55, 1, 63);
    }
}
