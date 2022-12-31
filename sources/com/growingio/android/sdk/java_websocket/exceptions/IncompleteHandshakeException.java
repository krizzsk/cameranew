package com.growingio.android.sdk.java_websocket.exceptions;
/* loaded from: classes2.dex */
public class IncompleteHandshakeException extends RuntimeException {
    private static final long serialVersionUID = 7906596804233893092L;
    private int newsize;

    public IncompleteHandshakeException(int i2) {
        this.newsize = i2;
    }

    public int getPreferedSize() {
        return this.newsize;
    }

    public IncompleteHandshakeException() {
        this.newsize = 0;
    }
}
