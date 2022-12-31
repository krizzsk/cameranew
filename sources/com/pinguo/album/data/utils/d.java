package com.pinguo.album.data.utils;

import com.pinguo.album.a;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
/* compiled from: BytesBufferPool.java */
/* loaded from: classes3.dex */
public class d {
    private final int a;
    private final int b;
    private final ArrayList<b> c;

    /* compiled from: BytesBufferPool.java */
    /* loaded from: classes3.dex */
    public static class b {
        public byte[] a;
        public int b;
        public int c;

        public void a(a.c cVar, InputStream inputStream) throws IOException {
            this.b = 0;
            this.c = 0;
            try {
                int length = this.a.length;
                while (true) {
                    int read = inputStream.read(this.a, this.c, Math.min(4096, length - this.c));
                    if (read < 0 || cVar.isCancelled()) {
                        break;
                    }
                    int i2 = this.c + read;
                    this.c = i2;
                    if (i2 == length) {
                        byte[] bArr = this.a;
                        byte[] bArr2 = new byte[bArr.length * 2];
                        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                        this.a = bArr2;
                        length = bArr2.length;
                    }
                }
            } finally {
                inputStream.close();
            }
        }

        private b(int i2) {
            this.a = new byte[i2];
        }
    }

    public d(int i2, int i3) {
        this.c = new ArrayList<>(i2);
        this.a = i2;
        this.b = i3;
    }

    public synchronized void a() {
        this.c.clear();
    }

    public synchronized b b() {
        int size;
        size = this.c.size();
        return size > 0 ? this.c.remove(size - 1) : new b(this.b);
    }

    public synchronized void c(b bVar) {
        if (bVar.a.length != this.b) {
            return;
        }
        if (this.c.size() < this.a) {
            bVar.b = 0;
            bVar.c = 0;
            this.c.add(bVar);
        }
    }
}
