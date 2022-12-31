package com.tapjoy.internal;

import com.tapjoy.TJEarnedCurrencyListener;
/* loaded from: classes3.dex */
public class TJEarnedCurrencyListenerNative implements TJEarnedCurrencyListener {
    private final long a;

    private TJEarnedCurrencyListenerNative(long j2) {
        if (j2 != 0) {
            this.a = j2;
            return;
        }
        throw new IllegalArgumentException();
    }

    @ft
    static Object create(long j2) {
        return new TJEarnedCurrencyListenerNative(j2);
    }

    private static native void onEarnedCurrencyNative(long j2, String str, int i2);

    @Override // com.tapjoy.TJEarnedCurrencyListener
    public void onEarnedCurrency(String str, int i2) {
        onEarnedCurrencyNative(this.a, str, i2);
    }
}
