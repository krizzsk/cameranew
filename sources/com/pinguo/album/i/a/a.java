package com.pinguo.album.i.a;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.zip.Adler32;
/* compiled from: BlobCache.java */
/* loaded from: classes3.dex */
public class a implements Closeable {
    private RandomAccessFile a;
    private RandomAccessFile b;
    private RandomAccessFile c;

    /* renamed from: d  reason: collision with root package name */
    private FileChannel f6039d;

    /* renamed from: e  reason: collision with root package name */
    private MappedByteBuffer f6040e;

    /* renamed from: f  reason: collision with root package name */
    private int f6041f;

    /* renamed from: g  reason: collision with root package name */
    private int f6042g;

    /* renamed from: h  reason: collision with root package name */
    private int f6043h;

    /* renamed from: i  reason: collision with root package name */
    private int f6044i;

    /* renamed from: j  reason: collision with root package name */
    private int f6045j;

    /* renamed from: k  reason: collision with root package name */
    private int f6046k;

    /* renamed from: l  reason: collision with root package name */
    private RandomAccessFile f6047l;
    private RandomAccessFile m;
    private int n;
    private int o;
    private byte[] p = new byte[32];
    private byte[] q = new byte[20];
    private Adler32 r = new Adler32();
    private int s;
    private int t;

    /* compiled from: BlobCache.java */
    /* renamed from: com.pinguo.album.i.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0232a {
        public long a;
        public byte[] b;
        public int c;
    }

    public a(String str, int i2, int i3, boolean z, int i4) throws IOException {
        this.a = new RandomAccessFile(str + ".idx", "rw");
        this.b = new RandomAccessFile(str + ".0", "rw");
        this.c = new RandomAccessFile(str + ".1", "rw");
        this.f6046k = i4;
        if (z || !N()) {
            T(i2, i3);
            if (N()) {
                return;
            }
            t();
            throw new IOException("unable to load index");
        }
    }

    private void A(long j2, byte[] bArr, int i2) throws IOException {
        byte[] bArr2 = this.q;
        int d2 = d(bArr);
        Z(bArr2, 0, j2);
        Y(bArr2, 8, d2);
        Y(bArr2, 12, this.f6045j);
        Y(bArr2, 16, i2);
        this.f6047l.write(bArr2);
        this.f6047l.write(bArr, 0, i2);
        this.f6040e.putLong(this.s, j2);
        this.f6040e.putInt(this.s + 8, this.f6045j);
        int i3 = this.f6045j + i2 + 20;
        this.f6045j = i3;
        Y(this.p, 20, i3);
    }

    private boolean N() {
        try {
            this.a.seek(0L);
            this.b.seek(0L);
            this.c.seek(0L);
            byte[] bArr = this.p;
            if (this.a.read(bArr) != 32) {
                us.pinguo.common.log.a.s("cannot read header", new Object[0]);
                return false;
            } else if (R(bArr, 0) != -1289277392) {
                us.pinguo.common.log.a.s("cannot read header magic", new Object[0]);
                return false;
            } else if (R(bArr, 24) != this.f6046k) {
                us.pinguo.common.log.a.s("version mismatch", new Object[0]);
                return false;
            } else {
                this.f6041f = R(bArr, 4);
                this.f6042g = R(bArr, 8);
                this.f6043h = R(bArr, 12);
                this.f6044i = R(bArr, 16);
                this.f6045j = R(bArr, 20);
                if (e(bArr, 0, 28) != R(bArr, 28)) {
                    us.pinguo.common.log.a.s("header checksum does not match", new Object[0]);
                    return false;
                }
                int i2 = this.f6041f;
                if (i2 <= 0) {
                    us.pinguo.common.log.a.s("invalid max entries", new Object[0]);
                    return false;
                }
                int i3 = this.f6042g;
                if (i3 <= 0) {
                    us.pinguo.common.log.a.s("invalid max bytes", new Object[0]);
                    return false;
                }
                int i4 = this.f6043h;
                if (i4 != 0 && i4 != 1) {
                    us.pinguo.common.log.a.s("invalid active region", new Object[0]);
                    return false;
                }
                int i5 = this.f6044i;
                if (i5 >= 0 && i5 <= i2) {
                    int i6 = this.f6045j;
                    if (i6 >= 4 && i6 <= i3) {
                        if (this.a.length() != (this.f6041f * 12 * 2) + 32) {
                            us.pinguo.common.log.a.s("invalid index file length", new Object[0]);
                            return false;
                        }
                        byte[] bArr2 = new byte[4];
                        if (this.b.read(bArr2) != 4) {
                            us.pinguo.common.log.a.s("cannot read data file magic", new Object[0]);
                            return false;
                        } else if (R(bArr2, 0) != -1121680112) {
                            us.pinguo.common.log.a.s("invalid data file magic", new Object[0]);
                            return false;
                        } else if (this.c.read(bArr2) != 4) {
                            us.pinguo.common.log.a.s("cannot read data file magic", new Object[0]);
                            return false;
                        } else if (R(bArr2, 0) != -1121680112) {
                            us.pinguo.common.log.a.s("invalid data file magic", new Object[0]);
                            return false;
                        } else {
                            FileChannel channel = this.a.getChannel();
                            this.f6039d = channel;
                            MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0L, this.a.length());
                            this.f6040e = map;
                            map.order(ByteOrder.LITTLE_ENDIAN);
                            U();
                            return true;
                        }
                    }
                    us.pinguo.common.log.a.s("invalid active bytes", new Object[0]);
                    return false;
                }
                us.pinguo.common.log.a.s("invalid active entries", new Object[0]);
                return false;
            }
        } catch (IOException e2) {
            us.pinguo.common.log.a.e("loadIndex failed.", e2);
            return false;
        }
    }

    private boolean Q(long j2, int i2) {
        int i3 = this.f6041f;
        int i4 = (int) (j2 % i3);
        if (i4 < 0) {
            i4 += i3;
        }
        int i5 = i4;
        while (true) {
            int i6 = (i5 * 12) + i2;
            long j3 = this.f6040e.getLong(i6);
            int i7 = this.f6040e.getInt(i6 + 8);
            if (i7 == 0) {
                this.s = i6;
                return false;
            } else if (j3 == j2) {
                this.s = i6;
                this.t = i7;
                return true;
            } else {
                i5++;
                if (i5 >= this.f6041f) {
                    i5 = 0;
                }
                if (i5 == i4) {
                    us.pinguo.common.log.a.s("corrupted index: clear the slot.", new Object[0]);
                    this.f6040e.putInt((i5 * 12) + i2 + 8, 0);
                }
            }
        }
    }

    static int R(byte[] bArr, int i2) {
        return ((bArr[i2 + 3] & Draft_75.END_OF_FRAME) << 24) | (bArr[i2] & Draft_75.END_OF_FRAME) | ((bArr[i2 + 1] & Draft_75.END_OF_FRAME) << 8) | ((bArr[i2 + 2] & Draft_75.END_OF_FRAME) << 16);
    }

    static long S(byte[] bArr, int i2) {
        long j2 = bArr[i2 + 7] & Draft_75.END_OF_FRAME;
        for (int i3 = 6; i3 >= 0; i3--) {
            j2 = (j2 << 8) | (bArr[i2 + i3] & Draft_75.END_OF_FRAME);
        }
        return j2;
    }

    private void T(int i2, int i3) throws IOException {
        this.a.setLength(0L);
        this.a.setLength((i2 * 12 * 2) + 32);
        this.a.seek(0L);
        byte[] bArr = this.p;
        Y(bArr, 0, -1289277392);
        Y(bArr, 4, i2);
        Y(bArr, 8, i3);
        Y(bArr, 12, 0);
        Y(bArr, 16, 0);
        Y(bArr, 20, 4);
        Y(bArr, 24, this.f6046k);
        Y(bArr, 28, e(bArr, 0, 28));
        this.a.write(bArr);
        this.b.setLength(0L);
        this.c.setLength(0L);
        this.b.seek(0L);
        this.c.seek(0L);
        Y(bArr, 0, -1121680112);
        this.b.write(bArr, 0, 4);
        this.c.write(bArr, 0, 4);
    }

    private void U() throws IOException {
        int i2 = this.f6043h;
        RandomAccessFile randomAccessFile = i2 == 0 ? this.b : this.c;
        this.f6047l = randomAccessFile;
        this.m = i2 == 1 ? this.b : this.c;
        randomAccessFile.setLength(this.f6045j);
        this.f6047l.seek(this.f6045j);
        this.n = 32;
        this.o = 32;
        if (this.f6043h == 0) {
            this.o = 32 + (this.f6041f * 12);
        } else {
            this.n = 32 + (this.f6041f * 12);
        }
    }

    private void X() {
        byte[] bArr = this.p;
        Y(bArr, 28, e(bArr, 0, 28));
        this.f6040e.position(0);
        this.f6040e.put(this.p);
    }

    static void Y(byte[] bArr, int i2, int i3) {
        for (int i4 = 0; i4 < 4; i4++) {
            bArr[i2 + i4] = (byte) (i3 & 255);
            i3 >>= 8;
        }
    }

    static void Z(byte[] bArr, int i2, long j2) {
        for (int i3 = 0; i3 < 8; i3++) {
            bArr[i2 + i3] = (byte) (255 & j2);
            j2 >>= 8;
        }
    }

    private void j(int i2) {
        byte[] bArr = new byte[1024];
        this.f6040e.position(i2);
        int i3 = this.f6041f * 12;
        while (i3 > 0) {
            int min = Math.min(i3, 1024);
            this.f6040e.put(bArr, 0, min);
            i3 -= min;
        }
    }

    private void t() {
        u(this.f6039d);
        u(this.a);
        u(this.b);
        u(this.c);
    }

    static void u(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Throwable unused) {
        }
    }

    private static void v(String str) {
        try {
            new File(str).delete();
        } catch (Throwable unused) {
        }
    }

    public static void w(String str) {
        v(str + ".idx");
        v(str + ".0");
        v(str + ".1");
    }

    private void x() throws IOException {
        int i2 = 1 - this.f6043h;
        this.f6043h = i2;
        this.f6044i = 0;
        this.f6045j = 4;
        Y(this.p, 12, i2);
        Y(this.p, 16, this.f6044i);
        Y(this.p, 20, this.f6045j);
        X();
        U();
        j(this.n);
        W();
    }

    private boolean y(RandomAccessFile randomAccessFile, int i2, C0232a c0232a) throws IOException {
        byte[] bArr = this.q;
        long filePointer = randomAccessFile.getFilePointer();
        try {
            randomAccessFile.seek(i2);
            if (randomAccessFile.read(bArr) != 20) {
                us.pinguo.common.log.a.s("cannot read blob header", new Object[0]);
                return false;
            }
            long S = S(bArr, 0);
            if (S == 0) {
                return false;
            }
            if (S != c0232a.a) {
                us.pinguo.common.log.a.s("blob key does not match: " + S, new Object[0]);
                return false;
            }
            int R = R(bArr, 8);
            int R2 = R(bArr, 12);
            if (R2 != i2) {
                us.pinguo.common.log.a.s("blob offset does not match: " + R2, new Object[0]);
                return false;
            }
            int R3 = R(bArr, 16);
            if (R3 >= 0 && R3 <= (this.f6042g - i2) - 20) {
                byte[] bArr2 = c0232a.b;
                if (bArr2 == null || bArr2.length < R3) {
                    c0232a.b = new byte[R3];
                }
                byte[] bArr3 = c0232a.b;
                c0232a.c = R3;
                if (randomAccessFile.read(bArr3, 0, R3) != R3) {
                    us.pinguo.common.log.a.s("cannot read blob data", new Object[0]);
                    return false;
                } else if (e(bArr3, 0, R3) != R) {
                    us.pinguo.common.log.a.s("blob checksum does not match: " + R, new Object[0]);
                    return false;
                } else {
                    return true;
                }
            }
            us.pinguo.common.log.a.s("invalid blob length: " + R3, new Object[0]);
            return false;
        } catch (Throwable th) {
            try {
                us.pinguo.common.log.a.e("getBlob failed.", th);
                return false;
            } finally {
                randomAccessFile.seek(filePointer);
            }
        }
    }

    public boolean O(C0232a c0232a) throws IOException {
        if (Q(c0232a.a, this.n) && y(this.f6047l, this.t, c0232a)) {
            return true;
        }
        int i2 = this.s;
        if (Q(c0232a.a, this.o) && y(this.m, this.t, c0232a)) {
            int i3 = c0232a.c;
            if (this.f6045j + 20 + i3 <= this.f6042g && this.f6044i * 2 < this.f6041f) {
                this.s = i2;
                try {
                    A(c0232a.a, c0232a.b, i3);
                    int i4 = this.f6044i + 1;
                    this.f6044i = i4;
                    Y(this.p, 16, i4);
                    X();
                } catch (Throwable unused) {
                    us.pinguo.common.log.a.e("cannot copy over", new Object[0]);
                }
            }
            return true;
        }
        return false;
    }

    public void V() {
        W();
        try {
            this.b.getFD().sync();
        } catch (Throwable th) {
            us.pinguo.common.log.a.s("sync data file 0 failed", th);
        }
        try {
            this.c.getFD().sync();
        } catch (Throwable th2) {
            us.pinguo.common.log.a.s("sync data file 1 failed", th2);
        }
    }

    public void W() {
        try {
            this.f6040e.force();
        } catch (Throwable th) {
            us.pinguo.common.log.a.s("sync index failed", th);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        V();
        t();
    }

    int d(byte[] bArr) {
        this.r.reset();
        this.r.update(bArr);
        return (int) this.r.getValue();
    }

    int e(byte[] bArr, int i2, int i3) {
        this.r.reset();
        this.r.update(bArr, i2, i3);
        return (int) this.r.getValue();
    }

    public void z(long j2, byte[] bArr) throws IOException {
        int length = bArr.length + 24;
        int i2 = this.f6042g;
        if (length <= i2) {
            if (this.f6045j + 20 + bArr.length > i2 || this.f6044i * 2 >= this.f6041f) {
                x();
            }
            if (!Q(j2, this.n)) {
                int i3 = this.f6044i + 1;
                this.f6044i = i3;
                Y(this.p, 16, i3);
            }
            A(j2, bArr, bArr.length);
            X();
            return;
        }
        throw new RuntimeException("blob is too large!");
    }
}
