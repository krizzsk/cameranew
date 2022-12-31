package org.apache.http.entity.mime.g;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
/* compiled from: StringBody.java */
/* loaded from: classes3.dex */
public class e extends a {
    private final byte[] b;
    private final Charset c;

    public e(String str, String str2, Charset charset) throws UnsupportedEncodingException {
        super(str2);
        if (str != null) {
            charset = charset == null ? Charset.forName("US-ASCII") : charset;
            this.b = str.getBytes(charset.name());
            this.c = charset;
            return;
        }
        throw new IllegalArgumentException("Text may not be null");
    }

    public static e d(String str, String str2, Charset charset) throws IllegalArgumentException {
        try {
            return new e(str, str2, charset);
        } catch (UnsupportedEncodingException e2) {
            throw new IllegalArgumentException("Charset " + charset + " is not supported", e2);
        }
    }

    @Override // org.apache.http.entity.mime.g.c
    public String b() {
        return "8bit";
    }

    @Override // org.apache.http.entity.mime.g.c
    public String c() {
        return this.c.name();
    }

    @Override // org.apache.http.entity.mime.g.c
    public long getContentLength() {
        return this.b.length;
    }

    @Override // org.apache.http.entity.mime.g.b
    public String getFilename() {
        return null;
    }

    @Override // org.apache.http.entity.mime.g.b
    public void writeTo(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.b);
            byte[] bArr = new byte[4096];
            while (true) {
                int read = byteArrayInputStream.read(bArr);
                if (read != -1) {
                    outputStream.write(bArr, 0, read);
                } else {
                    outputStream.flush();
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException("Output stream may not be null");
        }
    }
}
