package com.facebook.ads.redexgen.X;

import java.io.IOException;
/* loaded from: assets/audience_network.dex */
public final class A9 extends Exception {
    public final int A00;
    public final int A01;

    public A9(int i2, String str, Throwable th, int i3) {
        super(str, th);
        this.A01 = i2;
        this.A00 = i3;
    }

    public static A9 A00(IOException iOException) {
        return new A9(0, null, iOException, -1);
    }

    public static A9 A01(Exception exc, int i2) {
        return new A9(1, null, exc, i2);
    }

    public static A9 A02(RuntimeException runtimeException) {
        return new A9(2, null, runtimeException, -1);
    }
}
