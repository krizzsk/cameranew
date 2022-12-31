package com.google.android.play.core.assetpacks;

import androidx.annotation.Nullable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Objects;
/* loaded from: classes2.dex */
public final class k2 extends InputStream {
    private final Enumeration<File> a;
    @Nullable
    private InputStream b;

    public k2(Enumeration<File> enumeration) throws IOException {
        this.a = enumeration;
        d();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        super.close();
        InputStream inputStream = this.b;
        if (inputStream != null) {
            inputStream.close();
            this.b = null;
        }
    }

    final void d() throws IOException {
        InputStream inputStream = this.b;
        if (inputStream != null) {
            inputStream.close();
        }
        this.b = this.a.hasMoreElements() ? new FileInputStream(this.a.nextElement()) : null;
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        while (true) {
            InputStream inputStream = this.b;
            if (inputStream == null) {
                return -1;
            }
            int read = inputStream.read();
            if (read != -1) {
                return read;
            }
            d();
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        if (this.b == null) {
            return -1;
        }
        Objects.requireNonNull(bArr);
        if (i2 < 0 || i3 < 0 || i3 > bArr.length - i2) {
            throw new IndexOutOfBoundsException();
        }
        if (i3 != 0) {
            do {
                int read = this.b.read(bArr, i2, i3);
                if (read > 0) {
                    return read;
                }
                d();
            } while (this.b != null);
            return -1;
        }
        return 0;
    }
}
