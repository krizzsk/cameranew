package com.tapjoy.internal;

import com.tapjoy.TJVideoListener;
/* loaded from: classes3.dex */
public class TJVideoListenerNative implements TJVideoListener {
    private final long a;

    private TJVideoListenerNative(long j2) {
        if (j2 != 0) {
            this.a = j2;
            return;
        }
        throw new IllegalArgumentException();
    }

    @ft
    static Object create(long j2) {
        return new TJVideoListenerNative(j2);
    }

    private static native void onVideoCompleteNative(long j2);

    private static native void onVideoErrorNative(long j2, int i2);

    private static native void onVideoStartNative(long j2);

    @Override // com.tapjoy.TJVideoListener
    public void onVideoComplete() {
        onVideoCompleteNative(this.a);
    }

    @Override // com.tapjoy.TJVideoListener
    public void onVideoError(int i2) {
        onVideoErrorNative(this.a, i2);
    }

    @Override // com.tapjoy.TJVideoListener
    public void onVideoStart() {
        onVideoStartNative(this.a);
    }
}
