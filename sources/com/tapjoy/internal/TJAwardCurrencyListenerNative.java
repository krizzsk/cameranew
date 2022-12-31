package com.tapjoy.internal;

import com.tapjoy.TJAwardCurrencyListener;
/* loaded from: classes3.dex */
public class TJAwardCurrencyListenerNative implements TJAwardCurrencyListener {
    private final long a;

    private TJAwardCurrencyListenerNative(long j2) {
        if (j2 != 0) {
            this.a = j2;
            return;
        }
        throw new IllegalArgumentException();
    }

    @ft
    static Object create(long j2) {
        return new TJAwardCurrencyListenerNative(j2);
    }

    private static native void onAwardCurrencyResponseFailureNative(long j2, String str);

    private static native void onAwardCurrencyResponseNative(long j2, String str, int i2);

    @Override // com.tapjoy.TJAwardCurrencyListener
    public void onAwardCurrencyResponse(String str, int i2) {
        onAwardCurrencyResponseNative(this.a, str, i2);
    }

    @Override // com.tapjoy.TJAwardCurrencyListener
    public void onAwardCurrencyResponseFailure(String str) {
        onAwardCurrencyResponseFailureNative(this.a, str);
    }
}
