package com.tapjoy.internal;

import com.tapjoy.TJSpendCurrencyListener;
/* loaded from: classes3.dex */
public class TJSpendCurrencyListenerNative implements TJSpendCurrencyListener {
    private final long a;

    private TJSpendCurrencyListenerNative(long j2) {
        if (j2 != 0) {
            this.a = j2;
            return;
        }
        throw new IllegalArgumentException();
    }

    @ft
    static Object create(long j2) {
        return new TJSpendCurrencyListenerNative(j2);
    }

    private static native void onSpendCurrencyResponseFailureNative(long j2, String str);

    private static native void onSpendCurrencyResponseNative(long j2, String str, int i2);

    @Override // com.tapjoy.TJSpendCurrencyListener
    public void onSpendCurrencyResponse(String str, int i2) {
        onSpendCurrencyResponseNative(this.a, str, i2);
    }

    @Override // com.tapjoy.TJSpendCurrencyListener
    public void onSpendCurrencyResponseFailure(String str) {
        onSpendCurrencyResponseFailureNative(this.a, str);
    }
}
