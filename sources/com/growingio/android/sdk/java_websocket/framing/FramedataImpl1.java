package com.growingio.android.sdk.java_websocket.framing;

import com.growingio.android.sdk.java_websocket.exceptions.InvalidDataException;
import com.growingio.android.sdk.java_websocket.exceptions.InvalidFrameException;
import com.growingio.android.sdk.java_websocket.framing.Framedata;
import com.growingio.android.sdk.java_websocket.util.Charsetfunctions;
import java.nio.ByteBuffer;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class FramedataImpl1 implements FrameBuilder {
    protected static byte[] emptyarray = new byte[0];
    protected boolean fin;
    protected Framedata.Opcode optcode;
    protected boolean transferemasked;
    private ByteBuffer unmaskedpayload;

    public FramedataImpl1() {
    }

    @Override // com.growingio.android.sdk.java_websocket.framing.Framedata
    public void append(Framedata framedata) throws InvalidFrameException {
        ByteBuffer payloadData = framedata.getPayloadData();
        if (this.unmaskedpayload == null) {
            this.unmaskedpayload = ByteBuffer.allocate(payloadData.remaining());
            payloadData.mark();
            this.unmaskedpayload.put(payloadData);
            payloadData.reset();
        } else {
            payloadData.mark();
            ByteBuffer byteBuffer = this.unmaskedpayload;
            byteBuffer.position(byteBuffer.limit());
            ByteBuffer byteBuffer2 = this.unmaskedpayload;
            byteBuffer2.limit(byteBuffer2.capacity());
            if (payloadData.remaining() > this.unmaskedpayload.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(payloadData.remaining() + this.unmaskedpayload.capacity());
                this.unmaskedpayload.flip();
                allocate.put(this.unmaskedpayload);
                allocate.put(payloadData);
                this.unmaskedpayload = allocate;
            } else {
                this.unmaskedpayload.put(payloadData);
            }
            this.unmaskedpayload.rewind();
            payloadData.reset();
        }
        this.fin = framedata.isFin();
    }

    @Override // com.growingio.android.sdk.java_websocket.framing.Framedata
    public Framedata.Opcode getOpcode() {
        return this.optcode;
    }

    @Override // com.growingio.android.sdk.java_websocket.framing.Framedata
    public ByteBuffer getPayloadData() {
        return this.unmaskedpayload;
    }

    @Override // com.growingio.android.sdk.java_websocket.framing.Framedata
    public boolean getTransfereMasked() {
        return this.transferemasked;
    }

    @Override // com.growingio.android.sdk.java_websocket.framing.Framedata
    public boolean isFin() {
        return this.fin;
    }

    @Override // com.growingio.android.sdk.java_websocket.framing.FrameBuilder
    public void setFin(boolean z) {
        this.fin = z;
    }

    @Override // com.growingio.android.sdk.java_websocket.framing.FrameBuilder
    public void setOptcode(Framedata.Opcode opcode) {
        this.optcode = opcode;
    }

    @Override // com.growingio.android.sdk.java_websocket.framing.FrameBuilder
    public void setPayload(ByteBuffer byteBuffer) throws InvalidDataException {
        this.unmaskedpayload = byteBuffer;
    }

    @Override // com.growingio.android.sdk.java_websocket.framing.FrameBuilder
    public void setTransferemasked(boolean z) {
        this.transferemasked = z;
    }

    public String toString() {
        return "Framedata{ optcode:" + getOpcode() + ", fin:" + isFin() + ", payloadlength:[pos:" + this.unmaskedpayload.position() + ", len:" + this.unmaskedpayload.remaining() + "], payload:" + Arrays.toString(Charsetfunctions.utf8Bytes(new String(this.unmaskedpayload.array()))) + "}";
    }

    public FramedataImpl1(Framedata.Opcode opcode) {
        this.optcode = opcode;
        this.unmaskedpayload = ByteBuffer.wrap(emptyarray);
    }

    public FramedataImpl1(Framedata framedata) {
        this.fin = framedata.isFin();
        this.optcode = framedata.getOpcode();
        this.unmaskedpayload = framedata.getPayloadData();
        this.transferemasked = framedata.getTransfereMasked();
    }
}
