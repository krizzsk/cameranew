package com.bytedance.sdk.openadsdk.core.video.a.a;

import com.bytedance.sdk.a.b.ab;
import com.bytedance.sdk.a.b.v;
import com.bytedance.sdk.a.b.y;
import com.bytedance.sdk.openadsdk.utils.o;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import us.pinguo.common.network.common.header.PGTransHeader;
/* compiled from: VideoCacheImpl.java */
/* loaded from: classes.dex */
public class b implements a {
    public File a;
    private RandomAccessFile b;

    /* renamed from: d  reason: collision with root package name */
    private String f1772d;

    /* renamed from: e  reason: collision with root package name */
    private volatile InputStream f1773e;

    /* renamed from: g  reason: collision with root package name */
    private long f1775g;

    /* renamed from: i  reason: collision with root package name */
    private volatile boolean f1777i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f1778j;

    /* renamed from: k  reason: collision with root package name */
    private String f1779k;
    private volatile long c = -2147483648L;

    /* renamed from: f  reason: collision with root package name */
    private final Object f1774f = new Object();

    /* renamed from: h  reason: collision with root package name */
    private volatile boolean f1776h = false;

    public b(String str, String str2, File file) {
        this.f1775g = 0L;
        this.f1777i = false;
        this.f1772d = str;
        this.f1779k = str2;
        try {
            this.a = file;
            boolean f2 = f();
            this.f1778j = this.f1778j;
            this.b = new RandomAccessFile(this.a, f2 ? "r" : "rw");
            this.f1775g = e();
            if (f2) {
                return;
            }
            this.f1777i = true;
            d();
        } catch (IOException unused) {
            o.c("VideoCacheImpl", "Error using file " + file + " as disc cache");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() throws IOException {
        if (f()) {
            return;
        }
        try {
            synchronized (this.f1774f) {
                File file = new File(this.a.getParentFile(), this.a.getName().substring(0, this.a.getName().length() - 9));
                if (this.a.renameTo(file)) {
                    this.a = file;
                    RandomAccessFile randomAccessFile = this.b;
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                    this.b = new RandomAccessFile(this.a, "r");
                } else {
                    throw new IOException("Error renaming file " + this.a + " to " + file + " for completion!");
                }
            }
        } catch (IOException e2) {
            throw new IOException("Error opening " + this.a + " as disc cache", e2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.a.a.a
    public long b() throws IOException {
        if (f()) {
            this.c = e();
        } else {
            synchronized (this.f1774f) {
                while (this.c == -2147483648L) {
                    try {
                        o.c("VideoCacheImpl", "length: wait");
                        this.f1774f.wait(5L);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        throw new IOException("total length InterruptException");
                    }
                }
            }
        }
        return this.c;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.a.a.a
    public boolean c() {
        return this.f1777i;
    }

    public void d() {
        com.bytedance.sdk.openadsdk.i.a.a().b().execute(new com.bytedance.sdk.openadsdk.i.b() { // from class: com.bytedance.sdk.openadsdk.core.video.a.a.b.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    try {
                        try {
                            b bVar = b.this;
                            bVar.f1773e = bVar.a(bVar.e());
                            if (b.this.f1773e == null) {
                                com.bytedance.sdk.openadsdk.core.video.a.a.b(b.this.f1779k);
                                try {
                                    if (b.this.f1773e != null) {
                                        b.this.f1773e.close();
                                    }
                                    if (b.this.e() == b.this.c) {
                                        b.this.g();
                                        b.this.f1777i = false;
                                    }
                                    if (!b.this.f1776h || b.this.b == null) {
                                        return;
                                    }
                                    b.this.b.close();
                                    return;
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                    return;
                                }
                            }
                            byte[] bArr = new byte[16384];
                            long j2 = 0;
                            loop0: while (true) {
                                int i2 = 0;
                                do {
                                    int read = b.this.f1773e.read(bArr, i2, 16384 - i2);
                                    if (read == -1) {
                                        break loop0;
                                    }
                                    i2 += read;
                                    j2 += read;
                                    if (j2 % 16384 == 0) {
                                        break;
                                    }
                                } while (j2 != b.this.c - b.this.f1775g);
                                synchronized (b.this.f1774f) {
                                    b.this.a(bArr, i2);
                                }
                            }
                            com.bytedance.sdk.openadsdk.core.video.a.a.b(b.this.f1779k);
                            if (b.this.f1773e != null) {
                                b.this.f1773e.close();
                            }
                            if (b.this.e() == b.this.c) {
                                b.this.g();
                                b.this.f1777i = false;
                            }
                            if (!b.this.f1776h || b.this.b == null) {
                                return;
                            }
                            b.this.b.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    } catch (IOException e4) {
                        e4.printStackTrace();
                        com.bytedance.sdk.openadsdk.core.video.a.a.b(b.this.f1779k);
                        if (b.this.f1773e != null) {
                            b.this.f1773e.close();
                        }
                        if (b.this.e() == b.this.c) {
                            b.this.g();
                            b.this.f1777i = false;
                        }
                        if (!b.this.f1776h || b.this.b == null) {
                            return;
                        }
                        b.this.b.close();
                    }
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.core.video.a.a.b(b.this.f1779k);
                    try {
                        if (b.this.f1773e != null) {
                            b.this.f1773e.close();
                        }
                        if (b.this.e() == b.this.c) {
                            b.this.g();
                            b.this.f1777i = false;
                        }
                        if (b.this.f1776h && b.this.b != null) {
                            b.this.b.close();
                        }
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                    throw th;
                }
            }
        });
    }

    public long e() throws IOException {
        try {
            return this.b.length();
        } catch (IOException e2) {
            throw new IOException("Error reading length of file " + this.a, e2);
        }
    }

    public boolean f() {
        return !this.a.getName().endsWith(".download");
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.a.a.a
    public int a(long j2, byte[] bArr, int i2, int i3) throws IOException {
        try {
            try {
            } catch (IOException e2) {
                throw new IOException(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", Integer.valueOf(i3), Integer.valueOf(i2), Long.valueOf(e()), Integer.valueOf(bArr.length)), e2);
            }
        } catch (InterruptedException e3) {
            e3.printStackTrace();
        }
        if (j2 == this.c) {
            return -1;
        }
        int i4 = 0;
        while (!this.f1776h) {
            synchronized (this.f1774f) {
                if (j2 < e()) {
                    o.c("VideoCacheImpl", "read:  read " + j2 + " success");
                    this.b.seek(j2);
                    i4 = this.b.read(bArr, i2, i3);
                } else {
                    o.c("VideoCacheImpl", "read: wait at " + j2 + "  file size = " + e());
                    this.f1774f.wait(33L);
                }
            }
            if (i4 > 0) {
                return i4;
            }
        }
        return -1;
    }

    public void a(byte[] bArr, int i2) throws IOException {
        try {
            this.b.seek(e());
            this.b.write(bArr, 0, i2);
            this.f1774f.notifyAll();
            o.c("VideoCacheImpl", "append:  pisition =" + e() + "  length =" + i2);
        } catch (IOException e2) {
            throw new IOException(String.format("Error writing %d bytes to %s from buffer with size %d", Integer.valueOf(i2), this.b, Integer.valueOf(bArr.length)), e2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.a.a.a
    public void a() throws IOException {
        try {
            if (!this.f1777i) {
                this.b.close();
            }
            this.f1776h = true;
        } catch (IOException e2) {
            throw new IOException("Error closing file " + this.a, e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public InputStream a(long j2) throws IOException {
        v vVar = new v();
        y.a aVar = new y.a();
        ab g2 = vVar.a(aVar.a("RANGE", "bytes=" + j2 + PGTransHeader.CONNECTOR).a(this.f1772d).a().d()).a().g();
        if (g2 != null) {
            this.c = g2.a() + j2;
            return g2.b();
        }
        return null;
    }
}
