package com.mob.tools.network;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class MultiPartInputStream extends InputStream {
    private int curIs;
    private ArrayList<InputStream> isList = new ArrayList<>();

    private boolean isEmpty() {
        ArrayList<InputStream> arrayList = this.isList;
        return arrayList == null || arrayList.size() <= 0;
    }

    public void addInputStream(InputStream inputStream) throws Throwable {
        this.isList.add(inputStream);
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        if (isEmpty()) {
            return 0;
        }
        return this.isList.get(this.curIs).available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Iterator<InputStream> it = this.isList.iterator();
        while (it.hasNext()) {
            it.next().close();
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (isEmpty()) {
            return -1;
        }
        int read = this.isList.get(this.curIs).read();
        while (read < 0) {
            int i2 = this.curIs + 1;
            this.curIs = i2;
            if (i2 >= this.isList.size()) {
                break;
            }
            read = this.isList.get(this.curIs).read();
        }
        return read;
    }

    @Override // java.io.InputStream
    public long skip(long j2) throws IOException {
        throw new IOException();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        if (isEmpty()) {
            return -1;
        }
        int read = this.isList.get(this.curIs).read(bArr, i2, i3);
        while (read < 0) {
            int i4 = this.curIs + 1;
            this.curIs = i4;
            if (i4 >= this.isList.size()) {
                break;
            }
            read = this.isList.get(this.curIs).read(bArr, i2, i3);
        }
        return read;
    }
}
