package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.protocol.AdErrorType;
/* loaded from: assets/audience_network.dex */
public final class K4 extends Exception {
    public final AdErrorType A00;
    public final String A01;

    public K4(AdErrorType adErrorType, String str) {
        this(adErrorType, str, null);
    }

    public K4(AdErrorType adErrorType, String str, Throwable th) {
        super(str, th);
        this.A00 = adErrorType;
        this.A01 = str;
    }

    public final AdErrorType A00() {
        return this.A00;
    }

    public final String A01() {
        return this.A01;
    }
}
