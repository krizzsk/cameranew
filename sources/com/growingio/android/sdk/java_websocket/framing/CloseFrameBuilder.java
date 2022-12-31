package com.growingio.android.sdk.java_websocket.framing;

import com.growingio.android.sdk.java_websocket.exceptions.InvalidDataException;
import com.growingio.android.sdk.java_websocket.exceptions.InvalidFrameException;
import com.growingio.android.sdk.java_websocket.framing.Framedata;
import com.growingio.android.sdk.java_websocket.util.Charsetfunctions;
import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public class CloseFrameBuilder extends FramedataImpl1 implements CloseFrame {
    static final ByteBuffer emptybytebuffer = ByteBuffer.allocate(0);
    private int code;
    private String reason;

    public CloseFrameBuilder() {
        super(Framedata.Opcode.CLOSING);
        setFin(true);
    }

    private void initCloseCode() throws InvalidFrameException {
        this.code = CloseFrame.NOCODE;
        ByteBuffer payloadData = super.getPayloadData();
        payloadData.mark();
        if (payloadData.remaining() >= 2) {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.position(2);
            allocate.putShort(payloadData.getShort());
            allocate.position(0);
            int i2 = allocate.getInt();
            this.code = i2;
            if (i2 == 1006 || i2 == 1015 || i2 == 1005 || i2 > 4999 || i2 < 1000 || i2 == 1004) {
                throw new InvalidFrameException("closecode must not be sent over the wire: " + this.code);
            }
        }
        payloadData.reset();
    }

    private void initMessage() throws InvalidDataException {
        if (this.code == 1005) {
            this.reason = Charsetfunctions.stringUtf8(super.getPayloadData());
            return;
        }
        ByteBuffer payloadData = super.getPayloadData();
        int position = payloadData.position();
        try {
            try {
                payloadData.position(payloadData.position() + 2);
                this.reason = Charsetfunctions.stringUtf8(payloadData);
            } catch (IllegalArgumentException e2) {
                throw new InvalidFrameException(e2);
            }
        } finally {
            payloadData.position(position);
        }
    }

    private void setCodeAndMessage(int i2, String str) throws InvalidDataException {
        String str2 = "";
        if (str == null) {
            str = "";
        }
        if (i2 == 1015) {
            i2 = CloseFrame.NOCODE;
        } else {
            str2 = str;
        }
        if (i2 == 1005) {
            if (str2.length() > 0) {
                throw new InvalidDataException(1002, "A close frame must have a closecode if it has a reason");
            }
            return;
        }
        byte[] utf8Bytes = Charsetfunctions.utf8Bytes(str2);
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i2);
        allocate.position(2);
        ByteBuffer allocate2 = ByteBuffer.allocate(utf8Bytes.length + 2);
        allocate2.put(allocate);
        allocate2.put(utf8Bytes);
        allocate2.rewind();
        setPayload(allocate2);
    }

    @Override // com.growingio.android.sdk.java_websocket.framing.CloseFrame
    public int getCloseCode() {
        return this.code;
    }

    @Override // com.growingio.android.sdk.java_websocket.framing.CloseFrame
    public String getMessage() {
        return this.reason;
    }

    @Override // com.growingio.android.sdk.java_websocket.framing.FramedataImpl1, com.growingio.android.sdk.java_websocket.framing.Framedata
    public ByteBuffer getPayloadData() {
        if (this.code == 1005) {
            return emptybytebuffer;
        }
        return super.getPayloadData();
    }

    @Override // com.growingio.android.sdk.java_websocket.framing.FramedataImpl1, com.growingio.android.sdk.java_websocket.framing.FrameBuilder
    public void setPayload(ByteBuffer byteBuffer) throws InvalidDataException {
        super.setPayload(byteBuffer);
        initCloseCode();
        initMessage();
    }

    @Override // com.growingio.android.sdk.java_websocket.framing.FramedataImpl1
    public String toString() {
        return super.toString() + "code: " + this.code;
    }

    public CloseFrameBuilder(int i2) throws InvalidDataException {
        super(Framedata.Opcode.CLOSING);
        setFin(true);
        setCodeAndMessage(i2, "");
    }

    public CloseFrameBuilder(int i2, String str) throws InvalidDataException {
        super(Framedata.Opcode.CLOSING);
        setFin(true);
        setCodeAndMessage(i2, str);
    }
}
