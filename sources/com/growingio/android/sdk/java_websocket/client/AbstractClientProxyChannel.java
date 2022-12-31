package com.growingio.android.sdk.java_websocket.client;

import com.growingio.android.sdk.java_websocket.AbstractWrappedByteChannel;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
/* loaded from: classes2.dex */
public abstract class AbstractClientProxyChannel extends AbstractWrappedByteChannel {
    protected final ByteBuffer proxyHandshake;

    public AbstractClientProxyChannel(ByteChannel byteChannel) {
        super(byteChannel);
        try {
            this.proxyHandshake = ByteBuffer.wrap(buildHandShake().getBytes("ASCII"));
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }

    public abstract String buildHandShake();

    @Override // com.growingio.android.sdk.java_websocket.AbstractWrappedByteChannel, java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (!this.proxyHandshake.hasRemaining()) {
            return super.write(byteBuffer);
        }
        return super.write(this.proxyHandshake);
    }
}
