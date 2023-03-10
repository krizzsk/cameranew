package com.growingio.android.sdk.java_websocket;

import com.growingio.android.sdk.java_websocket.drafts.Draft;
import com.growingio.android.sdk.java_websocket.framing.Framedata;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.NotYetConnectedException;
/* loaded from: classes2.dex */
public interface WebSocket {
    public static final int DEFAULT_PORT = 80;
    public static final int DEFAULT_WSS_PORT = 443;

    /* loaded from: classes2.dex */
    public enum READYSTATE {
        NOT_YET_CONNECTED,
        CONNECTING,
        OPEN,
        CLOSING,
        CLOSED
    }

    /* loaded from: classes2.dex */
    public enum Role {
        CLIENT,
        SERVER
    }

    void close();

    void close(int i2);

    void close(int i2, String str);

    void closeConnection(int i2, String str);

    Draft getDraft();

    InetSocketAddress getLocalSocketAddress();

    READYSTATE getReadyState();

    InetSocketAddress getRemoteSocketAddress();

    String getResourceDescriptor();

    boolean hasBufferedData();

    boolean isClosed();

    boolean isClosing();

    boolean isConnecting();

    boolean isFlushAndClose();

    boolean isOpen();

    void send(String str) throws NotYetConnectedException;

    void send(ByteBuffer byteBuffer) throws IllegalArgumentException, NotYetConnectedException;

    void send(byte[] bArr) throws IllegalArgumentException, NotYetConnectedException;

    void sendFragmentedFrame(Framedata.Opcode opcode, ByteBuffer byteBuffer, boolean z);

    void sendFrame(Framedata framedata);
}
