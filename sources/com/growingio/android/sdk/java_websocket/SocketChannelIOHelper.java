package com.growingio.android.sdk.java_websocket;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
/* loaded from: classes2.dex */
public class SocketChannelIOHelper {
    /* JADX WARN: Removed duplicated region for block: B:39:0x0063 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean batch(com.growingio.android.sdk.java_websocket.WebSocketImpl r4, java.nio.channels.ByteChannel r5) throws java.io.IOException {
        /*
            java.util.concurrent.BlockingQueue<java.nio.ByteBuffer> r0 = r4.outQueue
            java.lang.Object r0 = r0.peek()
            java.nio.ByteBuffer r0 = (java.nio.ByteBuffer) r0
            r1 = 0
            if (r0 != 0) goto L1c
            boolean r0 = r5 instanceof com.growingio.android.sdk.java_websocket.WrappedByteChannel
            if (r0 == 0) goto L35
            r0 = r5
            com.growingio.android.sdk.java_websocket.WrappedByteChannel r0 = (com.growingio.android.sdk.java_websocket.WrappedByteChannel) r0
            boolean r2 = r0.isNeedWrite()
            if (r2 == 0) goto L36
            r0.writeMore()
            goto L36
        L1c:
            r5.write(r0)
            int r0 = r0.remaining()
            if (r0 <= 0) goto L26
            return r1
        L26:
            java.util.concurrent.BlockingQueue<java.nio.ByteBuffer> r0 = r4.outQueue
            r0.poll()
            java.util.concurrent.BlockingQueue<java.nio.ByteBuffer> r0 = r4.outQueue
            java.lang.Object r0 = r0.peek()
            java.nio.ByteBuffer r0 = (java.nio.ByteBuffer) r0
            if (r0 != 0) goto L1c
        L35:
            r0 = 0
        L36:
            if (r4 == 0) goto L6b
            java.util.concurrent.BlockingQueue<java.nio.ByteBuffer> r2 = r4.outQueue
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L6b
            boolean r2 = r4.isFlushAndClose()
            if (r2 == 0) goto L6b
            com.growingio.android.sdk.java_websocket.drafts.Draft r2 = r4.getDraft()
            if (r2 == 0) goto L6b
            com.growingio.android.sdk.java_websocket.drafts.Draft r2 = r4.getDraft()
            com.growingio.android.sdk.java_websocket.WebSocket$Role r2 = r2.getRole()
            if (r2 == 0) goto L6b
            com.growingio.android.sdk.java_websocket.drafts.Draft r2 = r4.getDraft()
            com.growingio.android.sdk.java_websocket.WebSocket$Role r2 = r2.getRole()
            com.growingio.android.sdk.java_websocket.WebSocket$Role r3 = com.growingio.android.sdk.java_websocket.WebSocket.Role.SERVER
            if (r2 != r3) goto L6b
            monitor-enter(r4)
            r4.closeConnection()     // Catch: java.lang.Throwable -> L68
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L68
            goto L6b
        L68:
            r5 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L68
            throw r5
        L6b:
            r4 = 1
            if (r0 == 0) goto L76
            com.growingio.android.sdk.java_websocket.WrappedByteChannel r5 = (com.growingio.android.sdk.java_websocket.WrappedByteChannel) r5
            boolean r5 = r5.isNeedWrite()
            if (r5 != 0) goto L77
        L76:
            r1 = 1
        L77:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.growingio.android.sdk.java_websocket.SocketChannelIOHelper.batch(com.growingio.android.sdk.java_websocket.WebSocketImpl, java.nio.channels.ByteChannel):boolean");
    }

    public static boolean read(ByteBuffer byteBuffer, WebSocketImpl webSocketImpl, ByteChannel byteChannel) throws IOException {
        byteBuffer.clear();
        int read = byteChannel.read(byteBuffer);
        byteBuffer.flip();
        if (read != -1) {
            return read != 0;
        }
        webSocketImpl.eot();
        return false;
    }

    public static boolean readMore(ByteBuffer byteBuffer, WebSocketImpl webSocketImpl, WrappedByteChannel wrappedByteChannel) throws IOException {
        byteBuffer.clear();
        int readMore = wrappedByteChannel.readMore(byteBuffer);
        byteBuffer.flip();
        if (readMore == -1) {
            webSocketImpl.eot();
            return false;
        }
        return wrappedByteChannel.isNeedRead();
    }
}
