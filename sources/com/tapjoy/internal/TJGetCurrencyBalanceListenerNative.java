package com.tapjoy.internal;

import com.tapjoy.TJGetCurrencyBalanceListener;
/* loaded from: classes3.dex */
public class TJGetCurrencyBalanceListenerNative implements TJGetCurrencyBalanceListener {
    private final long a;

    private TJGetCurrencyBalanceListenerNative(long j2) {
        if (j2 != 0) {
            this.a = j2;
            return;
        }
        throw new IllegalArgumentException();
    }

    @ft
    static Object create(long j2) {
        return new TJGetCurrencyBalanceListenerNative(j2);
    }

    private static native void onGetCurrencyBalanceResponseFailureNative(long j2, String str);

    private static native void onGetCurrencyBalanceResponseNative(long j2, String str, int i2);

    @Override // com.tapjoy.TJGetCurrencyBalanceListener
    public void onGetCurrencyBalanceResponse(String str, int i2) {
        onGetCurrencyBalanceResponseNative(this.a, str, i2);
    }

    @Override // com.tapjoy.TJGetCurrencyBalanceListener
    public void onGetCurrencyBalanceResponseFailure(String str) {
        onGetCurrencyBalanceResponseFailureNative(this.a, str);
    }
}
