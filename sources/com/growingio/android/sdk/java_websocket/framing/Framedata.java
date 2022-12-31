package com.growingio.android.sdk.java_websocket.framing;

import com.growingio.android.sdk.java_websocket.exceptions.InvalidFrameException;
import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public interface Framedata {

    /* loaded from: classes2.dex */
    public enum Opcode {
        CONTINUOUS,
        TEXT,
        BINARY,
        PING,
        PONG,
        CLOSING
    }

    void append(Framedata framedata) throws InvalidFrameException;

    Opcode getOpcode();

    ByteBuffer getPayloadData();

    boolean getTransfereMasked();

    boolean isFin();
}
