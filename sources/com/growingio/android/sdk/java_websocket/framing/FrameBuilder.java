package com.growingio.android.sdk.java_websocket.framing;

import com.growingio.android.sdk.java_websocket.exceptions.InvalidDataException;
import com.growingio.android.sdk.java_websocket.framing.Framedata;
import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public interface FrameBuilder extends Framedata {
    void setFin(boolean z);

    void setOptcode(Framedata.Opcode opcode);

    void setPayload(ByteBuffer byteBuffer) throws InvalidDataException;

    void setTransferemasked(boolean z);
}
