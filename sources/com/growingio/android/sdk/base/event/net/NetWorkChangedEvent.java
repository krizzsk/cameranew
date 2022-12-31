package com.growingio.android.sdk.base.event.net;
/* loaded from: classes2.dex */
public class NetWorkChangedEvent {
    private boolean isConnected;

    public NetWorkChangedEvent(boolean z) {
        this.isConnected = z;
    }

    public boolean isConnected() {
        return this.isConnected;
    }
}
