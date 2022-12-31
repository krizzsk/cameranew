package com.mob.tools.network;

import com.mob.tools.utils.Data;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class ByteArrayPart extends HTTPPart {
    private BufferedByteArrayOutputStream buffer;

    public ByteArrayPart append(byte[] bArr) throws Throwable {
        if (this.buffer == null) {
            this.buffer = new BufferedByteArrayOutputStream(bArr.length);
        }
        this.buffer.write(bArr);
        this.buffer.flush();
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mob.tools.network.HTTPPart
    public InputStream getInputStream() throws Throwable {
        BufferedByteArrayOutputStream bufferedByteArrayOutputStream = this.buffer;
        if (bufferedByteArrayOutputStream == null) {
            return new ByteArrayInputStream(new byte[0]);
        }
        byte[] buffer = bufferedByteArrayOutputStream.getBuffer();
        if (buffer != null && this.buffer.size() > 0) {
            return new ByteArrayInputStream(buffer, 0, this.buffer.size());
        }
        return new ByteArrayInputStream(new byte[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mob.tools.network.HTTPPart
    public long length() throws Throwable {
        BufferedByteArrayOutputStream bufferedByteArrayOutputStream = this.buffer;
        if (bufferedByteArrayOutputStream == null) {
            return 0L;
        }
        return bufferedByteArrayOutputStream.size();
    }

    public String toString() {
        byte[] buffer;
        BufferedByteArrayOutputStream bufferedByteArrayOutputStream = this.buffer;
        if (bufferedByteArrayOutputStream == null || (buffer = bufferedByteArrayOutputStream.getBuffer()) == null) {
            return null;
        }
        return Data.byteToHex(buffer, 0, this.buffer.size());
    }
}
