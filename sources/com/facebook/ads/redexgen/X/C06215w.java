package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
/* renamed from: com.facebook.ads.redexgen.X.5w  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C06215w {
    public static byte[] A03;
    public static String[] A04 = {"fwnF9NqGlDDvd3tmLjHzlBLQ0vKEWHbi", "JyVh64c57ZQhNNoyVwIaBwBMCWCp47TX", "NiVjB9zhlvCIBmozr5iuMf4XPmRpTykj", "aMEAUKQnrJbxe7", "r8tEg4U8ig5A4Tipsx9WF382DZkzVk0N", "", "NXFd2c7X4J9ga52f6GNSRbndM6EeYerJ", "Iv2mUp4tdjLGTNz"};
    public static final AtomicBoolean A05;
    @Nullable
    public XS A00;
    @Nullable
    public String A01;
    @VisibleForTesting
    public final C0992Li A02 = new C0992Li(300000000000L, new C1415al(this));

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 91);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A03 = new byte[]{114, 125, 114, Byte.MAX_VALUE, 124, 116, 42, 33, 48, 51, 43, 54, 47, 59, 48, 61, 52, 33, 75, 93, 75, 75, 81, 87, 86, 71, 76, 81, 85, 93};
    }

    static {
        A04();
        A05 = new AtomicBoolean(false);
    }

    public static C9E A00(XS xs) {
        if (JD.A0t(xs)) {
            return C9F.A01(A01(0, 6, 104), A01(18, 12, 67), A01(6, 12, 63));
        }
        C9E A00 = C9F.A00();
        String[] strArr = A04;
        if (strArr[2].charAt(0) != strArr[6].charAt(0)) {
            throw new RuntimeException();
        }
        A04[0] = "UkANKLN4N59lG96lj5R5seL3Uvk1PYyc";
        return A00;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A02() {
        XS xs;
        synchronized (this) {
            xs = this.A00;
        }
        if (xs == null) {
            return;
        }
        String A7T = C9H.A00().A01(xs, true).A7T(A00(xs));
        synchronized (this) {
            this.A01 = A7T;
        }
    }

    public static void A03() {
        A05.set(true);
    }

    public final synchronized String A06(XS xs) {
        this.A00 = xs;
        this.A00.A06().A9M();
        if (this.A00.A05().AEa() || ((A05.get() && JD.A1E(this.A00)) || this.A01 == null)) {
            A02();
            this.A02.A04().A03();
            A05.set(false);
        }
        this.A02.A06();
        return this.A01;
    }

    public final void A07() {
        this.A02.A05();
    }
}
