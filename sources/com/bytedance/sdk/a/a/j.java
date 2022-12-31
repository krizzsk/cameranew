package com.bytedance.sdk.a.a;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
/* compiled from: GzipSource.java */
/* loaded from: classes.dex */
public final class j implements s {
    private final e b;
    private final Inflater c;

    /* renamed from: d  reason: collision with root package name */
    private final k f843d;
    private int a = 0;

    /* renamed from: e  reason: collision with root package name */
    private final CRC32 f844e = new CRC32();

    public j(s sVar) {
        if (sVar != null) {
            Inflater inflater = new Inflater(true);
            this.c = inflater;
            e a = l.a(sVar);
            this.b = a;
            this.f843d = new k(a, inflater);
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    private void b() throws IOException {
        this.b.a(10L);
        byte b = this.b.c().b(3L);
        boolean z = ((b >> 1) & 1) == 1;
        if (z) {
            a(this.b.c(), 0L, 10L);
        }
        a("ID1ID2", 8075, this.b.i());
        this.b.h(8L);
        if (((b >> 2) & 1) == 1) {
            this.b.a(2L);
            if (z) {
                a(this.b.c(), 0L, 2L);
            }
            long k2 = this.b.c().k();
            this.b.a(k2);
            if (z) {
                a(this.b.c(), 0L, k2);
            }
            this.b.h(k2);
        }
        if (((b >> 3) & 1) == 1) {
            long a = this.b.a((byte) 0);
            if (a != -1) {
                if (z) {
                    a(this.b.c(), 0L, a + 1);
                }
                this.b.h(a + 1);
            } else {
                throw new EOFException();
            }
        }
        if (((b >> 4) & 1) == 1) {
            long a2 = this.b.a((byte) 0);
            if (a2 != -1) {
                if (z) {
                    a(this.b.c(), 0L, a2 + 1);
                }
                this.b.h(a2 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (z) {
            a("FHCRC", this.b.k(), (short) this.f844e.getValue());
            this.f844e.reset();
        }
    }

    private void c() throws IOException {
        a("CRC", this.b.l(), (int) this.f844e.getValue());
        a("ISIZE", this.b.l(), (int) this.c.getBytesWritten());
    }

    @Override // com.bytedance.sdk.a.a.s
    public long a(c cVar, long j2) throws IOException {
        int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        if (i2 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j2);
        } else if (i2 == 0) {
            return 0L;
        } else {
            if (this.a == 0) {
                b();
                this.a = 1;
            }
            if (this.a == 1) {
                long j3 = cVar.b;
                long a = this.f843d.a(cVar, j2);
                if (a != -1) {
                    a(cVar, j3, a);
                    return a;
                }
                this.a = 2;
            }
            if (this.a == 2) {
                c();
                this.a = 3;
                if (!this.b.e()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1L;
        }
    }

    @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f843d.close();
    }

    @Override // com.bytedance.sdk.a.a.s
    public t a() {
        return this.b.a();
    }

    private void a(c cVar, long j2, long j3) {
        int i2;
        o oVar = cVar.a;
        while (true) {
            int i3 = oVar.c;
            int i4 = oVar.b;
            if (j2 < i3 - i4) {
                break;
            }
            j2 -= i3 - i4;
            oVar = oVar.f848f;
        }
        while (j3 > 0) {
            int min = (int) Math.min(oVar.c - i2, j3);
            this.f844e.update(oVar.a, (int) (oVar.b + j2), min);
            j3 -= min;
            oVar = oVar.f848f;
            j2 = 0;
        }
    }

    private void a(String str, int i2, int i3) throws IOException {
        if (i3 != i2) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i3), Integer.valueOf(i2)));
        }
    }
}
