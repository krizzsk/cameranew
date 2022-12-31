package com.mob.tools.network;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public class BufferedByteArrayOutputStream extends ByteArrayOutputStream {
    public BufferedByteArrayOutputStream() {
    }

    public byte[] getBuffer() {
        return ((ByteArrayOutputStream) this).buf;
    }

    public int getBufferSize() {
        return ((ByteArrayOutputStream) this).buf.length;
    }

    public boolean switchBuffer(byte[] bArr) {
        if (bArr == null || bArr.length != ((ByteArrayOutputStream) this).buf.length) {
            return false;
        }
        ((ByteArrayOutputStream) this).buf = bArr;
        return true;
    }

    public void write(ByteBuffer byteBuffer) throws IOException {
        write(byteBuffer, byteBuffer.limit());
    }

    public BufferedByteArrayOutputStream(int i2) {
        super(i2);
    }

    public void write(ByteBuffer byteBuffer, int i2) throws IOException {
        byte[] bArr = ((ByteArrayOutputStream) this).buf;
        int length = bArr.length;
        int i3 = ((ByteArrayOutputStream) this).count;
        if (length - i3 >= i2) {
            byteBuffer.get(bArr, i3, i2);
            ((ByteArrayOutputStream) this).count += i2;
            return;
        }
        byte[] bArr2 = new byte[i2];
        byteBuffer.get(bArr2);
        write(bArr2);
    }
}
