package com.growingio.android.sdk.java_websocket.handshake;

import org.slf4j.Marker;
/* loaded from: classes2.dex */
public class HandshakeImpl1Client extends HandshakedataImpl1 implements ClientHandshakeBuilder {
    private String resourceDescriptor = Marker.ANY_MARKER;

    @Override // com.growingio.android.sdk.java_websocket.handshake.ClientHandshake
    public String getResourceDescriptor() {
        return this.resourceDescriptor;
    }

    @Override // com.growingio.android.sdk.java_websocket.handshake.ClientHandshakeBuilder
    public void setResourceDescriptor(String str) throws IllegalArgumentException {
        if (str != null) {
            this.resourceDescriptor = str;
            return;
        }
        throw new IllegalArgumentException("http resource descriptor must not be null");
    }
}
