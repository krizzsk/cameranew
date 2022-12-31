package com.sina.weibo.sdk.net;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes3.dex */
public final class g implements f {
    private int code;
    private InputStream q;

    public g(int i2, InputStream inputStream) {
        this.code = i2;
        this.q = inputStream;
    }

    @Override // com.sina.weibo.sdk.net.f
    public final String j() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = this.q.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    String byteArrayOutputStream2 = byteArrayOutputStream.toString();
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream2;
                }
            }
        } catch (IOException e2) {
            throw e2;
        }
    }
}
