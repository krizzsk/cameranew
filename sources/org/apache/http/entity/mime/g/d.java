package org.apache.http.entity.mime.g;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
/* compiled from: FileBody.java */
/* loaded from: classes3.dex */
public class d extends a {
    private final File b;
    private final String c;

    /* renamed from: d  reason: collision with root package name */
    private final String f8951d;

    public d(File file, String str, String str2, String str3) {
        super(str2);
        if (file != null) {
            this.b = file;
            if (str != null) {
                this.c = str;
            } else {
                this.c = file.getName();
            }
            this.f8951d = str3;
            return;
        }
        throw new IllegalArgumentException("File may not be null");
    }

    @Override // org.apache.http.entity.mime.g.c
    public String b() {
        return "binary";
    }

    @Override // org.apache.http.entity.mime.g.c
    public String c() {
        return this.f8951d;
    }

    @Override // org.apache.http.entity.mime.g.c
    public long getContentLength() {
        return this.b.length();
    }

    @Override // org.apache.http.entity.mime.g.b
    public String getFilename() {
        return this.c;
    }

    @Override // org.apache.http.entity.mime.g.b
    public void writeTo(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            FileInputStream fileInputStream = new FileInputStream(this.b);
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read != -1) {
                        outputStream.write(bArr, 0, read);
                    } else {
                        outputStream.flush();
                        return;
                    }
                }
            } finally {
                fileInputStream.close();
            }
        } else {
            throw new IllegalArgumentException("Output stream may not be null");
        }
    }

    public d(File file, String str, String str2) {
        this(file, null, str, str2);
    }

    public d(File file, String str) {
        this(file, str, null);
    }
}
