package com.growingio.android.sdk.java_websocket.drafts;

import com.adjust.sdk.Constants;
import com.growingio.android.sdk.java_websocket.WebSocket;
import com.growingio.android.sdk.java_websocket.drafts.Draft;
import com.growingio.android.sdk.java_websocket.exceptions.IncompleteHandshakeException;
import com.growingio.android.sdk.java_websocket.exceptions.InvalidDataException;
import com.growingio.android.sdk.java_websocket.exceptions.InvalidFrameException;
import com.growingio.android.sdk.java_websocket.exceptions.InvalidHandshakeException;
import com.growingio.android.sdk.java_websocket.framing.CloseFrameBuilder;
import com.growingio.android.sdk.java_websocket.framing.Framedata;
import com.growingio.android.sdk.java_websocket.handshake.ClientHandshake;
import com.growingio.android.sdk.java_websocket.handshake.ClientHandshakeBuilder;
import com.growingio.android.sdk.java_websocket.handshake.HandshakeBuilder;
import com.growingio.android.sdk.java_websocket.handshake.Handshakedata;
import com.growingio.android.sdk.java_websocket.handshake.ServerHandshake;
import com.growingio.android.sdk.java_websocket.handshake.ServerHandshakeBuilder;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
/* loaded from: classes2.dex */
public class Draft_76 extends Draft_75 {
    private static final byte[] closehandshake = {-1, 0};
    private boolean failed = false;
    private final Random reuseableRandom = new Random();

    public static byte[] createChallenge(String str, String str2, byte[] bArr) throws InvalidHandshakeException {
        byte[] part = getPart(str);
        byte[] part2 = getPart(str2);
        try {
            return MessageDigest.getInstance(Constants.MD5).digest(new byte[]{part[0], part[1], part[2], part[3], part2[0], part2[1], part2[2], part2[3], bArr[0], bArr[1], bArr[2], bArr[3], bArr[4], bArr[5], bArr[6], bArr[7]});
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static String generateKey() {
        Random random = new Random();
        long nextInt = random.nextInt(12) + 1;
        String l2 = Long.toString((random.nextInt(Math.abs(new Long(4294967295L / nextInt).intValue())) + 1) * nextInt);
        int nextInt2 = random.nextInt(12) + 1;
        for (int i2 = 0; i2 < nextInt2; i2++) {
            int abs = Math.abs(random.nextInt(l2.length()));
            char nextInt3 = (char) (random.nextInt(95) + 33);
            if (nextInt3 >= '0' && nextInt3 <= '9') {
                nextInt3 = (char) (nextInt3 - 15);
            }
            l2 = new StringBuilder(l2).insert(abs, nextInt3).toString();
        }
        for (int i3 = 0; i3 < nextInt; i3++) {
            l2 = new StringBuilder(l2).insert(Math.abs(random.nextInt(l2.length() - 1) + 1), " ").toString();
        }
        return l2;
    }

    private static byte[] getPart(String str) throws InvalidHandshakeException {
        try {
            long parseLong = Long.parseLong(str.replaceAll("[^0-9]", ""));
            long length = str.split(" ").length - 1;
            if (length != 0) {
                long longValue = new Long(parseLong / length).longValue();
                return new byte[]{(byte) (longValue >> 24), (byte) ((longValue << 8) >> 24), (byte) ((longValue << 16) >> 24), (byte) ((longValue << 24) >> 24)};
            }
            throw new InvalidHandshakeException("invalid Sec-WebSocket-Key (/key2/)");
        } catch (NumberFormatException unused) {
            throw new InvalidHandshakeException("invalid Sec-WebSocket-Key (/key1/ or /key2/)");
        }
    }

    @Override // com.growingio.android.sdk.java_websocket.drafts.Draft_75, com.growingio.android.sdk.java_websocket.drafts.Draft
    public Draft.HandshakeState acceptHandshakeAsClient(ClientHandshake clientHandshake, ServerHandshake serverHandshake) {
        if (this.failed) {
            return Draft.HandshakeState.NOT_MATCHED;
        }
        try {
            if (serverHandshake.getFieldValue("Sec-WebSocket-Origin").equals(clientHandshake.getFieldValue("Origin")) && basicAccept(serverHandshake)) {
                byte[] content = serverHandshake.getContent();
                if (content != null && content.length != 0) {
                    if (Arrays.equals(content, createChallenge(clientHandshake.getFieldValue("Sec-WebSocket-Key1"), clientHandshake.getFieldValue("Sec-WebSocket-Key2"), clientHandshake.getContent()))) {
                        return Draft.HandshakeState.MATCHED;
                    }
                    return Draft.HandshakeState.NOT_MATCHED;
                }
                throw new IncompleteHandshakeException();
            }
            return Draft.HandshakeState.NOT_MATCHED;
        } catch (InvalidHandshakeException e2) {
            throw new RuntimeException("bad handshakerequest", e2);
        }
    }

    @Override // com.growingio.android.sdk.java_websocket.drafts.Draft_75, com.growingio.android.sdk.java_websocket.drafts.Draft
    public Draft.HandshakeState acceptHandshakeAsServer(ClientHandshake clientHandshake) {
        if (clientHandshake.getFieldValue("Upgrade").equals("WebSocket") && clientHandshake.getFieldValue("Connection").contains("Upgrade") && clientHandshake.getFieldValue("Sec-WebSocket-Key1").length() > 0 && !clientHandshake.getFieldValue("Sec-WebSocket-Key2").isEmpty() && clientHandshake.hasFieldValue("Origin")) {
            return Draft.HandshakeState.MATCHED;
        }
        return Draft.HandshakeState.NOT_MATCHED;
    }

    @Override // com.growingio.android.sdk.java_websocket.drafts.Draft_75, com.growingio.android.sdk.java_websocket.drafts.Draft
    public Draft copyInstance() {
        return new Draft_76();
    }

    @Override // com.growingio.android.sdk.java_websocket.drafts.Draft_75, com.growingio.android.sdk.java_websocket.drafts.Draft
    public ByteBuffer createBinaryFrame(Framedata framedata) {
        if (framedata.getOpcode() == Framedata.Opcode.CLOSING) {
            return ByteBuffer.wrap(closehandshake);
        }
        return super.createBinaryFrame(framedata);
    }

    @Override // com.growingio.android.sdk.java_websocket.drafts.Draft_75, com.growingio.android.sdk.java_websocket.drafts.Draft
    public Draft.CloseHandshakeType getCloseHandshakeType() {
        return Draft.CloseHandshakeType.ONEWAY;
    }

    @Override // com.growingio.android.sdk.java_websocket.drafts.Draft_75, com.growingio.android.sdk.java_websocket.drafts.Draft
    public ClientHandshakeBuilder postProcessHandshakeRequestAsClient(ClientHandshakeBuilder clientHandshakeBuilder) {
        clientHandshakeBuilder.put("Upgrade", "WebSocket");
        clientHandshakeBuilder.put("Connection", "Upgrade");
        clientHandshakeBuilder.put("Sec-WebSocket-Key1", generateKey());
        clientHandshakeBuilder.put("Sec-WebSocket-Key2", generateKey());
        if (!clientHandshakeBuilder.hasFieldValue("Origin")) {
            clientHandshakeBuilder.put("Origin", "random" + this.reuseableRandom.nextInt());
        }
        byte[] bArr = new byte[8];
        this.reuseableRandom.nextBytes(bArr);
        clientHandshakeBuilder.setContent(bArr);
        return clientHandshakeBuilder;
    }

    @Override // com.growingio.android.sdk.java_websocket.drafts.Draft_75, com.growingio.android.sdk.java_websocket.drafts.Draft
    public HandshakeBuilder postProcessHandshakeResponseAsServer(ClientHandshake clientHandshake, ServerHandshakeBuilder serverHandshakeBuilder) throws InvalidHandshakeException {
        serverHandshakeBuilder.setHttpStatusMessage("WebSocket Protocol Handshake");
        serverHandshakeBuilder.put("Upgrade", "WebSocket");
        serverHandshakeBuilder.put("Connection", clientHandshake.getFieldValue("Connection"));
        serverHandshakeBuilder.put("Sec-WebSocket-Origin", clientHandshake.getFieldValue("Origin"));
        serverHandshakeBuilder.put("Sec-WebSocket-Location", "ws://" + clientHandshake.getFieldValue("Host") + clientHandshake.getResourceDescriptor());
        String fieldValue = clientHandshake.getFieldValue("Sec-WebSocket-Key1");
        String fieldValue2 = clientHandshake.getFieldValue("Sec-WebSocket-Key2");
        byte[] content = clientHandshake.getContent();
        if (fieldValue != null && fieldValue2 != null && content != null && content.length == 8) {
            serverHandshakeBuilder.setContent(createChallenge(fieldValue, fieldValue2, content));
            return serverHandshakeBuilder;
        }
        throw new InvalidHandshakeException("Bad keys");
    }

    @Override // com.growingio.android.sdk.java_websocket.drafts.Draft_75, com.growingio.android.sdk.java_websocket.drafts.Draft
    public List<Framedata> translateFrame(ByteBuffer byteBuffer) throws InvalidDataException {
        byteBuffer.mark();
        List<Framedata> translateRegularFrame = super.translateRegularFrame(byteBuffer);
        if (translateRegularFrame == null) {
            byteBuffer.reset();
            List<Framedata> list = this.readyframes;
            this.readingState = true;
            if (this.currentFrame == null) {
                this.currentFrame = ByteBuffer.allocate(2);
                if (byteBuffer.remaining() <= this.currentFrame.remaining()) {
                    this.currentFrame.put(byteBuffer);
                    if (!this.currentFrame.hasRemaining()) {
                        if (Arrays.equals(this.currentFrame.array(), closehandshake)) {
                            list.add(new CloseFrameBuilder(1000));
                            return list;
                        }
                        throw new InvalidFrameException();
                    }
                    this.readyframes = new LinkedList();
                    return list;
                }
                throw new InvalidFrameException();
            }
            throw new InvalidFrameException();
        }
        return translateRegularFrame;
    }

    @Override // com.growingio.android.sdk.java_websocket.drafts.Draft
    public Handshakedata translateHandshake(ByteBuffer byteBuffer) throws InvalidHandshakeException {
        HandshakeBuilder translateHandshakeHttp = Draft.translateHandshakeHttp(byteBuffer, this.role);
        if ((translateHandshakeHttp.hasFieldValue("Sec-WebSocket-Key1") || this.role == WebSocket.Role.CLIENT) && !translateHandshakeHttp.hasFieldValue("Sec-WebSocket-Version")) {
            byte[] bArr = new byte[this.role == WebSocket.Role.SERVER ? 8 : 16];
            try {
                byteBuffer.get(bArr);
                translateHandshakeHttp.setContent(bArr);
            } catch (BufferUnderflowException unused) {
                throw new IncompleteHandshakeException(byteBuffer.capacity() + 16);
            }
        }
        return translateHandshakeHttp;
    }
}
