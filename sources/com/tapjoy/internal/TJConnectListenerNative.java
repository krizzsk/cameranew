package com.tapjoy.internal;

import com.tapjoy.TJConnectListener;
/* loaded from: classes3.dex */
public class TJConnectListenerNative implements TJConnectListener {
    private final long a;

    private TJConnectListenerNative(long j2) {
        if (j2 != 0) {
            this.a = j2;
            return;
        }
        throw new IllegalArgumentException();
    }

    @ft
    static Object create(long j2) {
        return new TJConnectListenerNative(j2);
    }

    private static native void onConnectFailureNative(long j2);

    private static native void onConnectSuccessNative(long j2);

    @Override // com.tapjoy.TJConnectListener
    public void onConnectFailure() {
        onConnectFailureNative(this.a);
    }

    @Override // com.tapjoy.TJConnectListener
    public void onConnectSuccess() {
        onConnectSuccessNative(this.a);
    }
}
