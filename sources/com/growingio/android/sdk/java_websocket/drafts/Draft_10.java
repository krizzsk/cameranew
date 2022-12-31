package com.growingio.android.sdk.java_websocket.drafts;

import com.growingio.android.sdk.java_websocket.WebSocket;
import com.growingio.android.sdk.java_websocket.drafts.Draft;
import com.growingio.android.sdk.java_websocket.exceptions.InvalidDataException;
import com.growingio.android.sdk.java_websocket.exceptions.InvalidFrameException;
import com.growingio.android.sdk.java_websocket.exceptions.InvalidHandshakeException;
import com.growingio.android.sdk.java_websocket.exceptions.LimitExedeedException;
import com.growingio.android.sdk.java_websocket.exceptions.NotSendableException;
import com.growingio.android.sdk.java_websocket.framing.CloseFrameBuilder;
import com.growingio.android.sdk.java_websocket.framing.FrameBuilder;
import com.growingio.android.sdk.java_websocket.framing.Framedata;
import com.growingio.android.sdk.java_websocket.framing.FramedataImpl1;
import com.growingio.android.sdk.java_websocket.handshake.ClientHandshake;
import com.growingio.android.sdk.java_websocket.handshake.ClientHandshakeBuilder;
import com.growingio.android.sdk.java_websocket.handshake.HandshakeBuilder;
import com.growingio.android.sdk.java_websocket.handshake.Handshakedata;
import com.growingio.android.sdk.java_websocket.handshake.ServerHandshake;
import com.growingio.android.sdk.java_websocket.handshake.ServerHandshakeBuilder;
import com.growingio.android.sdk.java_websocket.util.Base64;
import com.growingio.android.sdk.java_websocket.util.Charsetfunctions;
import com.tencent.connect.common.Constants;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
/* loaded from: classes2.dex */
public class Draft_10 extends Draft {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private ByteBuffer incompleteframe;
    private Framedata fragmentedframe = null;
    private final Random reuseableRandom = new Random();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class IncompleteException extends Throwable {
        private static final long serialVersionUID = 7330519489840500997L;
        private int preferedsize;

        public IncompleteException(int i2) {
            this.preferedsize = i2;
        }

        public int getPreferedSize() {
            return this.preferedsize;
        }
    }

    private byte fromOpcode(Framedata.Opcode opcode) {
        if (opcode == Framedata.Opcode.CONTINUOUS) {
            return (byte) 0;
        }
        if (opcode == Framedata.Opcode.TEXT) {
            return (byte) 1;
        }
        if (opcode == Framedata.Opcode.BINARY) {
            return (byte) 2;
        }
        if (opcode == Framedata.Opcode.CLOSING) {
            return (byte) 8;
        }
        if (opcode == Framedata.Opcode.PING) {
            return (byte) 9;
        }
        if (opcode == Framedata.Opcode.PONG) {
            return (byte) 10;
        }
        throw new RuntimeException("Don't know how to handle " + opcode.toString());
    }

    private String generateFinalKey(String str) {
        try {
            return Base64.encodeBytes(MessageDigest.getInstance("SHA1").digest((str.trim() + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").getBytes()));
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static int readVersion(Handshakedata handshakedata) {
        String fieldValue = handshakedata.getFieldValue("Sec-WebSocket-Version");
        if (fieldValue.length() > 0) {
            try {
                return new Integer(fieldValue.trim()).intValue();
            } catch (NumberFormatException unused) {
            }
        }
        return -1;
    }

    private byte[] toByteArray(long j2, int i2) {
        byte[] bArr = new byte[i2];
        int i3 = (i2 * 8) - 8;
        for (int i4 = 0; i4 < i2; i4++) {
            bArr[i4] = (byte) (j2 >>> (i3 - (i4 * 8)));
        }
        return bArr;
    }

    private Framedata.Opcode toOpcode(byte b) throws InvalidFrameException {
        if (b != 0) {
            if (b != 1) {
                if (b != 2) {
                    switch (b) {
                        case 8:
                            return Framedata.Opcode.CLOSING;
                        case 9:
                            return Framedata.Opcode.PING;
                        case 10:
                            return Framedata.Opcode.PONG;
                        default:
                            throw new InvalidFrameException("unknow optcode " + ((int) b));
                    }
                }
                return Framedata.Opcode.BINARY;
            }
            return Framedata.Opcode.TEXT;
        }
        return Framedata.Opcode.CONTINUOUS;
    }

    @Override // com.growingio.android.sdk.java_websocket.drafts.Draft
    public Draft.HandshakeState acceptHandshakeAsClient(ClientHandshake clientHandshake, ServerHandshake serverHandshake) throws InvalidHandshakeException {
        if (clientHandshake.hasFieldValue("Sec-WebSocket-Key") && serverHandshake.hasFieldValue("Sec-WebSocket-Accept")) {
            if (generateFinalKey(clientHandshake.getFieldValue("Sec-WebSocket-Key")).equals(serverHandshake.getFieldValue("Sec-WebSocket-Accept"))) {
                return Draft.HandshakeState.MATCHED;
            }
            return Draft.HandshakeState.NOT_MATCHED;
        }
        return Draft.HandshakeState.NOT_MATCHED;
    }

    @Override // com.growingio.android.sdk.java_websocket.drafts.Draft
    public Draft.HandshakeState acceptHandshakeAsServer(ClientHandshake clientHandshake) throws InvalidHandshakeException {
        int readVersion = readVersion(clientHandshake);
        if (readVersion == 7 || readVersion == 8) {
            return basicAccept(clientHandshake) ? Draft.HandshakeState.MATCHED : Draft.HandshakeState.NOT_MATCHED;
        }
        return Draft.HandshakeState.NOT_MATCHED;
    }

    @Override // com.growingio.android.sdk.java_websocket.drafts.Draft
    public Draft copyInstance() {
        return new Draft_10();
    }

    @Override // com.growingio.android.sdk.java_websocket.drafts.Draft
    public ByteBuffer createBinaryFrame(Framedata framedata) {
        ByteBuffer payloadData = framedata.getPayloadData();
        int i2 = 0;
        boolean z = this.role == WebSocket.Role.CLIENT;
        int i3 = payloadData.remaining() <= 125 ? 1 : payloadData.remaining() <= 65535 ? 2 : 8;
        ByteBuffer allocate = ByteBuffer.allocate((i3 > 1 ? i3 + 1 : i3) + 1 + (z ? 4 : 0) + payloadData.remaining());
        allocate.put((byte) (((byte) (framedata.isFin() ? -128 : 0)) | fromOpcode(framedata.getOpcode())));
        byte[] byteArray = toByteArray(payloadData.remaining(), i3);
        if (i3 == 1) {
            allocate.put((byte) (byteArray[0] | (z ? Byte.MIN_VALUE : (byte) 0)));
        } else if (i3 == 2) {
            allocate.put((byte) ((z ? Byte.MIN_VALUE : (byte) 0) | 126));
            allocate.put(byteArray);
        } else if (i3 == 8) {
            allocate.put((byte) ((z ? Byte.MIN_VALUE : (byte) 0) | Byte.MAX_VALUE));
            allocate.put(byteArray);
        } else {
            throw new RuntimeException("Size representation not supported/specified");
        }
        if (z) {
            ByteBuffer allocate2 = ByteBuffer.allocate(4);
            allocate2.putInt(this.reuseableRandom.nextInt());
            allocate.put(allocate2.array());
            while (payloadData.hasRemaining()) {
                allocate.put((byte) (payloadData.get() ^ allocate2.get(i2 % 4)));
                i2++;
            }
        } else {
            allocate.put(payloadData);
        }
        allocate.flip();
        return allocate;
    }

    @Override // com.growingio.android.sdk.java_websocket.drafts.Draft
    public List<Framedata> createFrames(ByteBuffer byteBuffer, boolean z) {
        FramedataImpl1 framedataImpl1 = new FramedataImpl1();
        try {
            framedataImpl1.setPayload(byteBuffer);
            framedataImpl1.setFin(true);
            framedataImpl1.setOptcode(Framedata.Opcode.BINARY);
            framedataImpl1.setTransferemasked(z);
            return Collections.singletonList(framedataImpl1);
        } catch (InvalidDataException e2) {
            throw new NotSendableException(e2);
        }
    }

    @Override // com.growingio.android.sdk.java_websocket.drafts.Draft
    public Draft.CloseHandshakeType getCloseHandshakeType() {
        return Draft.CloseHandshakeType.TWOWAY;
    }

    @Override // com.growingio.android.sdk.java_websocket.drafts.Draft
    public ClientHandshakeBuilder postProcessHandshakeRequestAsClient(ClientHandshakeBuilder clientHandshakeBuilder) {
        clientHandshakeBuilder.put("Upgrade", "websocket");
        clientHandshakeBuilder.put("Connection", "Upgrade");
        clientHandshakeBuilder.put("Sec-WebSocket-Version", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO);
        byte[] bArr = new byte[16];
        this.reuseableRandom.nextBytes(bArr);
        clientHandshakeBuilder.put("Sec-WebSocket-Key", Base64.encodeBytes(bArr));
        return clientHandshakeBuilder;
    }

    @Override // com.growingio.android.sdk.java_websocket.drafts.Draft
    public HandshakeBuilder postProcessHandshakeResponseAsServer(ClientHandshake clientHandshake, ServerHandshakeBuilder serverHandshakeBuilder) throws InvalidHandshakeException {
        serverHandshakeBuilder.put("Upgrade", "websocket");
        serverHandshakeBuilder.put("Connection", clientHandshake.getFieldValue("Connection"));
        serverHandshakeBuilder.setHttpStatusMessage("Switching Protocols");
        String fieldValue = clientHandshake.getFieldValue("Sec-WebSocket-Key");
        if (fieldValue != null) {
            serverHandshakeBuilder.put("Sec-WebSocket-Accept", generateFinalKey(fieldValue));
            return serverHandshakeBuilder;
        }
        throw new InvalidHandshakeException("missing Sec-WebSocket-Key");
    }

    @Override // com.growingio.android.sdk.java_websocket.drafts.Draft
    public void reset() {
        this.incompleteframe = null;
    }

    @Override // com.growingio.android.sdk.java_websocket.drafts.Draft
    public List<Framedata> translateFrame(ByteBuffer byteBuffer) throws LimitExedeedException, InvalidDataException {
        LinkedList linkedList = new LinkedList();
        if (this.incompleteframe != null) {
            try {
                byteBuffer.mark();
                int remaining = byteBuffer.remaining();
                int remaining2 = this.incompleteframe.remaining();
                if (remaining2 > remaining) {
                    this.incompleteframe.put(byteBuffer.array(), byteBuffer.position(), remaining);
                    byteBuffer.position(byteBuffer.position() + remaining);
                    return Collections.emptyList();
                }
                this.incompleteframe.put(byteBuffer.array(), byteBuffer.position(), remaining2);
                byteBuffer.position(byteBuffer.position() + remaining2);
                linkedList.add(translateSingleFrame((ByteBuffer) this.incompleteframe.duplicate().position(0)));
                this.incompleteframe = null;
            } catch (IncompleteException e2) {
                this.incompleteframe.limit();
                ByteBuffer allocate = ByteBuffer.allocate(checkAlloc(e2.getPreferedSize()));
                this.incompleteframe.rewind();
                allocate.put(this.incompleteframe);
                this.incompleteframe = allocate;
                return translateFrame(byteBuffer);
            }
        }
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                linkedList.add(translateSingleFrame(byteBuffer));
            } catch (IncompleteException e3) {
                byteBuffer.reset();
                ByteBuffer allocate2 = ByteBuffer.allocate(checkAlloc(e3.getPreferedSize()));
                this.incompleteframe = allocate2;
                allocate2.put(byteBuffer);
            }
        }
        return linkedList;
    }

    public Framedata translateSingleFrame(ByteBuffer byteBuffer) throws IncompleteException, InvalidDataException {
        FrameBuilder framedataImpl1;
        int remaining = byteBuffer.remaining();
        int i2 = 2;
        if (remaining >= 2) {
            byte b = byteBuffer.get();
            boolean z = (b >> 8) != 0;
            byte b2 = (byte) ((b & Byte.MAX_VALUE) >> 4);
            if (b2 == 0) {
                byte b3 = byteBuffer.get();
                boolean z2 = (b3 & Byte.MIN_VALUE) != 0;
                int i3 = (byte) (b3 & Byte.MAX_VALUE);
                Framedata.Opcode opcode = toOpcode((byte) (b & 15));
                if (z || !(opcode == Framedata.Opcode.PING || opcode == Framedata.Opcode.PONG || opcode == Framedata.Opcode.CLOSING)) {
                    if (i3 < 0 || i3 > 125) {
                        if (opcode == Framedata.Opcode.PING || opcode == Framedata.Opcode.PONG || opcode == Framedata.Opcode.CLOSING) {
                            throw new InvalidFrameException("more than 125 octets");
                        }
                        if (i3 != 126) {
                            i2 = 10;
                            if (remaining >= 10) {
                                byte[] bArr = new byte[8];
                                for (int i4 = 0; i4 < 8; i4++) {
                                    bArr[i4] = byteBuffer.get();
                                }
                                long longValue = new BigInteger(bArr).longValue();
                                if (longValue > 2147483647L) {
                                    throw new LimitExedeedException("Payloadsize is to big...");
                                }
                                i3 = (int) longValue;
                            } else {
                                throw new IncompleteException(10);
                            }
                        } else if (remaining >= 4) {
                            i3 = new BigInteger(new byte[]{0, byteBuffer.get(), byteBuffer.get()}).intValue();
                            i2 = 4;
                        } else {
                            throw new IncompleteException(4);
                        }
                    }
                    int i5 = i2 + (z2 ? 4 : 0) + i3;
                    if (remaining >= i5) {
                        ByteBuffer allocate = ByteBuffer.allocate(checkAlloc(i3));
                        if (z2) {
                            byte[] bArr2 = new byte[4];
                            byteBuffer.get(bArr2);
                            for (int i6 = 0; i6 < i3; i6++) {
                                allocate.put((byte) (byteBuffer.get() ^ bArr2[i6 % 4]));
                            }
                        } else {
                            allocate.put(byteBuffer.array(), byteBuffer.position(), allocate.limit());
                            byteBuffer.position(byteBuffer.position() + allocate.limit());
                        }
                        if (opcode == Framedata.Opcode.CLOSING) {
                            framedataImpl1 = new CloseFrameBuilder();
                        } else {
                            framedataImpl1 = new FramedataImpl1();
                            framedataImpl1.setFin(z);
                            framedataImpl1.setOptcode(opcode);
                        }
                        allocate.flip();
                        framedataImpl1.setPayload(allocate);
                        return framedataImpl1;
                    }
                    throw new IncompleteException(i5);
                }
                throw new InvalidFrameException("control frames may no be fragmented");
            }
            throw new InvalidFrameException("bad rsv " + ((int) b2));
        }
        throw new IncompleteException(2);
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
