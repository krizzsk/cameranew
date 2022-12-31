package com.facebook.ads.redexgen.X;

import java.io.IOException;
/* renamed from: com.facebook.ads.redexgen.X.Ha  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0886Ha extends IOException {
    public final int A00;
    public final HV A01;

    public C0886Ha(IOException iOException, HV hv, int i2) {
        super(iOException);
        this.A01 = hv;
        this.A00 = i2;
    }

    public C0886Ha(String str, HV hv, int i2) {
        super(str);
        this.A01 = hv;
        this.A00 = i2;
    }

    public C0886Ha(String str, IOException iOException, HV hv, int i2) {
        super(str, iOException);
        this.A01 = hv;
        this.A00 = i2;
    }
}
