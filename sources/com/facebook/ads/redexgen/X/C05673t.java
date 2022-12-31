package com.facebook.ads.redexgen.X;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.3t  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C05673t {
    public static byte[] A06;
    public static String[] A07 = {"xh4Y4QcmM1wa5ldyXwFix7", "nmU7", "oStcn17TrhEMCT80qINsWqFBzeEgJkSk", "ejnuP30nVsgr2lyZF", "TwVj4lrjiRaSjHpnKGXYnUPcFE6raeBX", "wQpR2en2jkfHgW4", "pxsGGNitIZPjAkQbFzIWarOMOhpj3cU0", "7"};
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public AbstractC05784e A04;
    public AbstractC05784e A05;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A06, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            byte b = (byte) ((copyOfRange[i5] - i4) - 94);
            if (A07[0].length() == 11) {
                throw new RuntimeException();
            }
            A07[4] = "AHVWCXL94tyjuu8jVJzYXjJpXDntUCwP";
            copyOfRange[i5] = b;
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A06 = new byte[]{-52, -64, 6, 18, 15, Draft_75.CR, -8, -35, -103, -115, -45, -33, -36, -38, -58, -86, -18, -30, 48, 39, 57, 10, 49, 46, 38, 39, 52, -1, -77, -89, -5, -10, -33, -60, -70, -82, 2, -3, -25, -53, -52, -15, -22, -9, -16, -18, -46, -9, -17, -8, 4, -8, -11, -19, -47, -8, -11, -19, -18, -5, -58};
    }

    static {
        A01();
    }

    public C05673t(AbstractC05784e abstractC05784e, AbstractC05784e abstractC05784e2) {
        this.A05 = abstractC05784e;
        this.A04 = abstractC05784e2;
    }

    public C05673t(AbstractC05784e abstractC05784e, AbstractC05784e abstractC05784e2, int i2, int i3, int i4, int i5) {
        this(abstractC05784e, abstractC05784e2);
        this.A00 = i2;
        this.A01 = i3;
        this.A02 = i4;
        this.A03 = i5;
    }

    public final String toString() {
        return A00(40, 21, 43) + this.A05 + A00(16, 12, 100) + this.A04 + A00(0, 8, 66) + this.A00 + A00(8, 8, 15) + this.A01 + A00(28, 6, 41) + this.A02 + A00(34, 6, 48) + this.A03 + '}';
    }
}
