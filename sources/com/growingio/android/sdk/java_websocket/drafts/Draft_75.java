package com.growingio.android.sdk.java_websocket.drafts;

import com.growingio.android.sdk.java_websocket.drafts.Draft;
import com.growingio.android.sdk.java_websocket.exceptions.InvalidDataException;
import com.growingio.android.sdk.java_websocket.exceptions.InvalidFrameException;
import com.growingio.android.sdk.java_websocket.exceptions.InvalidHandshakeException;
import com.growingio.android.sdk.java_websocket.exceptions.LimitExedeedException;
import com.growingio.android.sdk.java_websocket.exceptions.NotSendableException;
import com.growingio.android.sdk.java_websocket.framing.Framedata;
import com.growingio.android.sdk.java_websocket.framing.FramedataImpl1;
import com.growingio.android.sdk.java_websocket.handshake.ClientHandshake;
import com.growingio.android.sdk.java_websocket.handshake.ClientHandshakeBuilder;
import com.growingio.android.sdk.java_websocket.handshake.HandshakeBuilder;
import com.growingio.android.sdk.java_websocket.handshake.ServerHandshake;
import com.growingio.android.sdk.java_websocket.handshake.ServerHandshakeBuilder;
import com.growingio.android.sdk.java_websocket.util.Charsetfunctions;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
/* loaded from: classes2.dex */
public class Draft_75 extends Draft {
    public static final byte CR = 13;
    public static final byte END_OF_FRAME = -1;
    public static final byte LF = 10;
    public static final byte START_OF_FRAME = 0;
    protected ByteBuffer currentFrame;
    protected boolean readingState = false;
    protected List<Framedata> readyframes = new LinkedList();
    private final Random reuseableRandom = new Random();

    @Override // com.growingio.android.sdk.java_websocket.drafts.Draft
    public Draft.HandshakeState acceptHandshakeAsClient(ClientHandshake clientHandshake, ServerHandshake serverHandshake) {
        return (clientHandshake.getFieldValue("WebSocket-Origin").equals(serverHandshake.getFieldValue("Origin")) && basicAccept(serverHandshake)) ? Draft.HandshakeState.MATCHED : Draft.HandshakeState.NOT_MATCHED;
    }

    @Override // com.growingio.android.sdk.java_websocket.drafts.Draft
    public Draft.HandshakeState acceptHandshakeAsServer(ClientHandshake clientHandshake) {
        if (clientHandshake.hasFieldValue("Origin") && basicAccept(clientHandshake)) {
            return Draft.HandshakeState.MATCHED;
        }
        return Draft.HandshakeState.NOT_MATCHED;
    }

    @Override // com.growingio.android.sdk.java_websocket.drafts.Draft
    public Draft copyInstance() {
        return new Draft_75();
    }

    @Override // com.growingio.android.sdk.java_websocket.drafts.Draft
    public ByteBuffer createBinaryFrame(Framedata framedata) {
        if (framedata.getOpcode() == Framedata.Opcode.TEXT) {
            ByteBuffer payloadData = framedata.getPayloadData();
            ByteBuffer allocate = ByteBuffer.allocate(payloadData.remaining() + 2);
            allocate.put((byte) 0);
            payloadData.mark();
            allocate.put(payloadData);
            payloadData.reset();
            allocate.put((byte) -1);
            allocate.flip();
            return allocate;
        }
        throw new RuntimeException("only text frames supported");
    }

    public ByteBuffer createBuffer() {
        return ByteBuffer.allocate(Draft.INITIAL_FAMESIZE);
    }

    @Override // com.growingio.android.sdk.java_websocket.drafts.Draft
    public List<Framedata> createFrames(ByteBuffer byteBuffer, boolean z) {
        throw new RuntimeException("not yet implemented");
    }

    @Override // com.growingio.android.sdk.java_websocket.drafts.Draft
    public Draft.CloseHandshakeType getCloseHandshakeType() {
        return Draft.CloseHandshakeType.NONE;
    }

    public ByteBuffer increaseBuffer(ByteBuffer byteBuffer) throws LimitExedeedException, InvalidDataException {
        byteBuffer.flip();
        ByteBuffer allocate = ByteBuffer.allocate(checkAlloc(byteBuffer.capacity() * 2));
        allocate.put(byteBuffer);
        return allocate;
    }

    @Override // com.growingio.android.sdk.java_websocket.drafts.Draft
    public ClientHandshakeBuilder postProcessHandshakeRequestAsClient(ClientHandshakeBuilder clientHandshakeBuilder) throws InvalidHandshakeException {
        clientHandshakeBuilder.put("Upgrade", "WebSocket");
        clientHandshakeBuilder.put("Connection", "Upgrade");
        if (!clientHandshakeBuilder.hasFieldValue("Origin")) {
            clientHandshakeBuilder.put("Origin", "random" + this.reuseableRandom.nextInt());
        }
        return clientHandshakeBuilder;
    }

    @Override // com.growingio.android.sdk.java_websocket.drafts.Draft
    public HandshakeBuilder postProcessHandshakeResponseAsServer(ClientHandshake clientHandshake, ServerHandshakeBuilder serverHandshakeBuilder) throws InvalidHandshakeException {
        serverHandshakeBuilder.setHttpStatusMessage("Web Socket Protocol Handshake");
        serverHandshakeBuilder.put("Upgrade", "WebSocket");
        serverHandshakeBuilder.put("Connection", clientHandshake.getFieldValue("Connection"));
        serverHandshakeBuilder.put("WebSocket-Origin", clientHandshake.getFieldValue("Origin"));
        serverHandshakeBuilder.put("WebSocket-Location", "ws://" + clientHandshake.getFieldValue("Host") + clientHandshake.getResourceDescriptor());
        return serverHandshakeBuilder;
    }

    @Override // com.growingio.android.sdk.java_websocket.drafts.Draft
    public void reset() {
        this.readingState = false;
        this.currentFrame = null;
    }

    @Override // com.growingio.android.sdk.java_websocket.drafts.Draft
    public List<Framedata> translateFrame(ByteBuffer byteBuffer) throws InvalidDataException {
        List<Framedata> translateRegularFrame = translateRegularFrame(byteBuffer);
        if (translateRegularFrame != null) {
            return translateRegularFrame;
        }
        throw new InvalidDataException(1002);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<Framedata> translateRegularFrame(ByteBuffer byteBuffer) throws InvalidDataException {
        while (byteBuffer.hasRemaining()) {
            byte b = byteBuffer.get();
            if (b == 0) {
                if (!this.readingState) {
                    this.readingState = true;
                } else {
                    throw new InvalidFrameException("unexpected START_OF_FRAME");
                }
            } else if (b == -1) {
                if (this.readingState) {
                    ByteBuffer byteBuffer2 = this.currentFrame;
                    if (byteBuffer2 != null) {
                        byteBuffer2.flip();
                        FramedataImpl1 framedataImpl1 = new FramedataImpl1();
                        framedataImpl1.setPayload(this.currentFrame);
                        framedataImpl1.setFin(true);
                        framedataImpl1.setOptcode(Framedata.Opcode.TEXT);
                        this.readyframes.add(framedataImpl1);
                        this.currentFrame = null;
                        byteBuffer.mark();
                    }
                    this.readingState = false;
                } else {
                    throw new InvalidFrameException("unexpected END_OF_FRAME");
                }
            } else if (!this.readingState) {
                return null;
            } else {
                ByteBuffer byteBuffer3 = this.currentFrame;
                if (byteBuffer3 == null) {
                    this.currentFrame = createBuffer();
                } else if (!byteBuffer3.hasRemaining()) {
                    this.currentFrame = increaseBuffer(this.currentFrame);
                }
                this.currentFrame.put(b);
            }
        }
        List<Framedata> list = this.readyframes;
        this.readyframes = new LinkedList();
        return list;
    }

    @Override // com.growingio.android.sdk.java_websocket.drafts.Draft
    public List<Framedata> createFrames(String str, boolean z) {
        FramedataImpl1 framedataImpl1 = new FramedataImpl1();
        try {
            framedataImpl1.setPayload(ByteBuffer.wrap(Charsetfunctions.utf8Bytes(str)));
            framedataImpl1.setFin(true);
            framedataImpl1.setOptcode(Framedata.Opcode.TEXT);
            framedataImpl1.setTransferemasked(z);
            return Collections.singletonList(framedataImpl1);
        } catch (InvalidDataException e2) {
            throw new NotSendableException(e2);
        }
    }
}
