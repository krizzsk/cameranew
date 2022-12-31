package com.danikula.videocache.p;

import com.danikula.videocache.ProxyCacheException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* compiled from: FileCache.java */
/* loaded from: classes.dex */
public class b implements com.danikula.videocache.a {
    private final a a;
    public File b;
    private RandomAccessFile c;

    public b(File file, a aVar) throws ProxyCacheException {
        File file2;
        try {
            if (aVar != null) {
                this.a = aVar;
                d.b(file.getParentFile());
                boolean exists = file.exists();
                if (exists) {
                    file2 = file;
                } else {
                    File parentFile = file.getParentFile();
                    file2 = new File(parentFile, file.getName() + ".download");
                }
                this.b = file2;
                this.c = new RandomAccessFile(this.b, exists ? "r" : "rw");
                return;
            }
            throw new NullPointerException();
        } catch (IOException e2) {
            throw new ProxyCacheException("Error using file " + file + " as disc cache", e2);
        }
    }

    private boolean a(File file) {
        return file.getName().endsWith(".download");
    }

    @Override // com.danikula.videocache.a
    public synchronized long available() throws ProxyCacheException {
        try {
        } catch (IOException e2) {
            throw new ProxyCacheException("Error reading length of file " + this.b, e2);
        }
        return (int) this.c.length();
    }

    @Override // com.danikula.videocache.a
    public synchronized void close() throws ProxyCacheException {
        try {
            this.c.close();
            this.a.a(this.b);
        } catch (IOException e2) {
            throw new ProxyCacheException("Error closing file " + this.b, e2);
        }
    }

    @Override // com.danikula.videocache.a
    public synchronized void complete() throws ProxyCacheException {
        if (d()) {
            return;
        }
        close();
        File file = new File(this.b.getParentFile(), this.b.getName().substring(0, this.b.getName().length() - 9));
        if (this.b.renameTo(file)) {
            this.b = file;
            try {
                this.c = new RandomAccessFile(this.b, "r");
                this.a.a(this.b);
                return;
            } catch (IOException e2) {
                throw new ProxyCacheException("Error opening " + this.b + " as disc cache", e2);
            }
        }
        throw new ProxyCacheException("Error renaming file " + this.b + " to " + file + " for completion!");
    }

    @Override // com.danikula.videocache.a
    public synchronized boolean d() {
        return !a(this.b);
    }

    @Override // com.danikula.videocache.a
    public synchronized void e(byte[] bArr, int i2) throws ProxyCacheException {
        try {
            if (!d()) {
                this.c.seek(available());
                this.c.write(bArr, 0, i2);
            } else {
                throw new ProxyCacheException("Error append cache: cache file " + this.b + " is completed!");
            }
        } catch (IOException e2) {
            throw new ProxyCacheException(String.format("Error writing %d bytes to %s from buffer with size %d", Integer.valueOf(i2), this.c, Integer.valueOf(bArr.length)), e2);
        }
    }

    @Override // com.danikula.videocache.a
    public synchronized int f(byte[] bArr, long j2, int i2) throws ProxyCacheException {
        try {
            this.c.seek(j2);
        } catch (IOException e2) {
            throw new ProxyCacheException(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(available()), Integer.valueOf(bArr.length)), e2);
        }
        return this.c.read(bArr, 0, i2);
    }
}
