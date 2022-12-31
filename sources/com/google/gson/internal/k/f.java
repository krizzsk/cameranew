package com.google.gson.internal.k;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
/* compiled from: JsonTreeWriter.java */
/* loaded from: classes2.dex */
public final class f extends com.google.gson.stream.b {
    private static final Writer o = new a();
    private static final com.google.gson.n p = new com.google.gson.n("closed");

    /* renamed from: l  reason: collision with root package name */
    private final List<com.google.gson.k> f4951l;
    private String m;
    private com.google.gson.k n;

    /* compiled from: JsonTreeWriter.java */
    /* loaded from: classes2.dex */
    class a extends Writer {
        a() {
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i2, int i3) {
            throw new AssertionError();
        }
    }

    public f() {
        super(o);
        this.f4951l = new ArrayList();
        this.n = com.google.gson.l.a;
    }

    private com.google.gson.k j0() {
        List<com.google.gson.k> list = this.f4951l;
        return list.get(list.size() - 1);
    }

    private void k0(com.google.gson.k kVar) {
        if (this.m != null) {
            if (!kVar.f() || A()) {
                ((com.google.gson.m) j0()).i(this.m, kVar);
            }
            this.m = null;
        } else if (this.f4951l.isEmpty()) {
            this.n = kVar;
        } else {
            com.google.gson.k j0 = j0();
            if (j0 instanceof com.google.gson.h) {
                ((com.google.gson.h) j0).i(kVar);
                return;
            }
            throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b Q(String str) throws IOException {
        if (!this.f4951l.isEmpty() && this.m == null) {
            if (j0() instanceof com.google.gson.m) {
                this.m = str;
                return this;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b S() throws IOException {
        k0(com.google.gson.l.a);
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b c0(long j2) throws IOException {
        k0(new com.google.gson.n(Long.valueOf(j2)));
        return this;
    }

    @Override // com.google.gson.stream.b, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f4951l.isEmpty()) {
            this.f4951l.add(p);
            return;
        }
        throw new IOException("Incomplete document");
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b d0(Boolean bool) throws IOException {
        if (bool == null) {
            S();
            return this;
        }
        k0(new com.google.gson.n(bool));
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b e0(Number number) throws IOException {
        if (number == null) {
            S();
            return this;
        }
        if (!O()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        k0(new com.google.gson.n(number));
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b f0(String str) throws IOException {
        if (str == null) {
            S();
            return this;
        }
        k0(new com.google.gson.n(str));
        return this;
    }

    @Override // com.google.gson.stream.b, java.io.Flushable
    public void flush() throws IOException {
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b g0(boolean z) throws IOException {
        k0(new com.google.gson.n(Boolean.valueOf(z)));
        return this;
    }

    public com.google.gson.k i0() {
        if (this.f4951l.isEmpty()) {
            return this.n;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.f4951l);
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b v() throws IOException {
        com.google.gson.h hVar = new com.google.gson.h();
        k0(hVar);
        this.f4951l.add(hVar);
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b w() throws IOException {
        com.google.gson.m mVar = new com.google.gson.m();
        k0(mVar);
        this.f4951l.add(mVar);
        return this;
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b y() throws IOException {
        if (!this.f4951l.isEmpty() && this.m == null) {
            if (j0() instanceof com.google.gson.h) {
                List<com.google.gson.k> list = this.f4951l;
                list.remove(list.size() - 1);
                return this;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.stream.b
    public com.google.gson.stream.b z() throws IOException {
        if (!this.f4951l.isEmpty() && this.m == null) {
            if (j0() instanceof com.google.gson.m) {
                List<com.google.gson.k> list = this.f4951l;
                list.remove(list.size() - 1);
                return this;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }
}
