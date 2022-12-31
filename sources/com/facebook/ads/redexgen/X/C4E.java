package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.4E  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C4E extends GG implements GD {
    public static byte[] A01;
    public boolean A00;

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 58);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{70, 113, 106, 96, 104, 97, 36, 106, 107, 112, 36, 118, 97, 101, 96, 125};
    }

    public final synchronized void A06() {
        this.A00 = true;
    }

    public final synchronized boolean A07(AtomicReference<JSONObject> atomicReference, AtomicReference<JSONObject> atomicReference2) {
        if (A8U()) {
            if (!this.A00) {
                atomicReference2.set(A6c());
                return false;
            }
            atomicReference.set(A6F());
            atomicReference2.set(A6c());
            this.A00 = false;
            return true;
        }
        throw new IllegalStateException(A00(0, 16, 62));
    }
}
