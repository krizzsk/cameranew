package com.bytedance.sdk.a.a;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
/* compiled from: InflaterSource.java */
/* loaded from: classes.dex */
public final class k implements s {
    private final e a;
    private final Inflater b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f845d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar, Inflater inflater) {
        if (eVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater != null) {
            this.a = eVar;
            this.b = inflater;
            return;
        }
        throw new IllegalArgumentException("inflater == null");
    }

    private void c() throws IOException {
        int i2 = this.c;
        if (i2 == 0) {
            return;
        }
        int remaining = i2 - this.b.getRemaining();
        this.c -= remaining;
        this.a.h(remaining);
    }

    @Override // com.bytedance.sdk.a.a.s
    public long a(c cVar, long j2) throws IOException {
        o e2;
        int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        if (i2 >= 0) {
            if (this.f845d) {
                throw new IllegalStateException("closed");
            }
            if (i2 == 0) {
                return 0L;
            }
            while (true) {
                boolean b = b();
                try {
                    e2 = cVar.e(1);
                    int inflate = this.b.inflate(e2.a, e2.c, (int) Math.min(j2, 8192 - e2.c));
                    if (inflate > 0) {
                        e2.c += inflate;
                        long j3 = inflate;
                        cVar.b += j3;
                        return j3;
                    } else if (this.b.finished() || this.b.needsDictionary()) {
                        break;
                    } else if (b) {
                        throw new EOFException("source exhausted prematurely");
                    }
                } catch (DataFormatException e3) {
                    throw new IOException(e3);
                }
            }
            c();
            if (e2.b == e2.c) {
                cVar.a = e2.b();
                p.a(e2);
                return -1L;
            }
            return -1L;
        }
        throw new IllegalArgumentException("byteCount < 0: " + j2);
    }

    public final boolean b() throws IOException {
        if (this.b.needsInput()) {
            c();
            if (this.b.getRemaining() == 0) {
                if (this.a.e()) {
                    return true;
                }
                o oVar = this.a.c().a;
                int i2 = oVar.c;
                int i3 = oVar.b;
                int i4 = i2 - i3;
                this.c = i4;
                this.b.setInput(oVar.a, i3, i4);
                return false;
            }
            throw new IllegalStateException("?");
        }
        return false;
    }

    @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f845d) {
            return;
        }
        this.b.end();
        this.f845d = true;
        this.a.close();
    }

    @Override // com.bytedance.sdk.a.a.s
    public t a() {
        return this.a.a();
    }
}
