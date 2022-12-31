package com.google.gson.internal.k;

import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
/* compiled from: JsonTreeReader.java */
/* loaded from: classes2.dex */
public final class e extends com.google.gson.stream.a {
    private static final Reader u = new a();
    private static final Object v = new Object();
    private Object[] q;
    private int r;
    private String[] s;
    private int[] t;

    /* compiled from: JsonTreeReader.java */
    /* loaded from: classes2.dex */
    class a extends Reader {
        a() {
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i2, int i3) throws IOException {
            throw new AssertionError();
        }
    }

    public e(com.google.gson.k kVar) {
        super(u);
        this.q = new Object[32];
        this.r = 0;
        this.s = new String[32];
        this.t = new int[32];
        s0(kVar);
    }

    private String R() {
        return " at path " + getPath();
    }

    private void o0(JsonToken jsonToken) throws IOException {
        if (c0() == jsonToken) {
            return;
        }
        throw new IllegalStateException("Expected " + jsonToken + " but was " + c0() + R());
    }

    private Object p0() {
        return this.q[this.r - 1];
    }

    private Object q0() {
        Object[] objArr = this.q;
        int i2 = this.r - 1;
        this.r = i2;
        Object obj = objArr[i2];
        objArr[i2] = null;
        return obj;
    }

    private void s0(Object obj) {
        int i2 = this.r;
        Object[] objArr = this.q;
        if (i2 == objArr.length) {
            int i3 = i2 * 2;
            this.q = Arrays.copyOf(objArr, i3);
            this.t = Arrays.copyOf(this.t, i3);
            this.s = (String[]) Arrays.copyOf(this.s, i3);
        }
        Object[] objArr2 = this.q;
        int i4 = this.r;
        this.r = i4 + 1;
        objArr2[i4] = obj;
    }

    @Override // com.google.gson.stream.a
    public boolean N() throws IOException {
        JsonToken c0 = c0();
        return (c0 == JsonToken.END_OBJECT || c0 == JsonToken.END_ARRAY) ? false : true;
    }

    @Override // com.google.gson.stream.a
    public boolean S() throws IOException {
        o0(JsonToken.BOOLEAN);
        boolean i2 = ((com.google.gson.n) q0()).i();
        int i3 = this.r;
        if (i3 > 0) {
            int[] iArr = this.t;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
        }
        return i2;
    }

    @Override // com.google.gson.stream.a
    public double T() throws IOException {
        JsonToken c0 = c0();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (c0 != jsonToken && c0 != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + c0 + R());
        }
        double j2 = ((com.google.gson.n) p0()).j();
        if (!O() && (Double.isNaN(j2) || Double.isInfinite(j2))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + j2);
        }
        q0();
        int i2 = this.r;
        if (i2 > 0) {
            int[] iArr = this.t;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return j2;
    }

    @Override // com.google.gson.stream.a
    public int U() throws IOException {
        JsonToken c0 = c0();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (c0 != jsonToken && c0 != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + c0 + R());
        }
        int a2 = ((com.google.gson.n) p0()).a();
        q0();
        int i2 = this.r;
        if (i2 > 0) {
            int[] iArr = this.t;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return a2;
    }

    @Override // com.google.gson.stream.a
    public long V() throws IOException {
        JsonToken c0 = c0();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (c0 != jsonToken && c0 != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + c0 + R());
        }
        long k2 = ((com.google.gson.n) p0()).k();
        q0();
        int i2 = this.r;
        if (i2 > 0) {
            int[] iArr = this.t;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return k2;
    }

    @Override // com.google.gson.stream.a
    public String W() throws IOException {
        o0(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) p0()).next();
        String str = (String) entry.getKey();
        this.s[this.r - 1] = str;
        s0(entry.getValue());
        return str;
    }

    @Override // com.google.gson.stream.a
    public void Y() throws IOException {
        o0(JsonToken.NULL);
        q0();
        int i2 = this.r;
        if (i2 > 0) {
            int[] iArr = this.t;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public String a0() throws IOException {
        JsonToken c0 = c0();
        JsonToken jsonToken = JsonToken.STRING;
        if (c0 != jsonToken && c0 != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + c0 + R());
        }
        String m = ((com.google.gson.n) q0()).m();
        int i2 = this.r;
        if (i2 > 0) {
            int[] iArr = this.t;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return m;
    }

    @Override // com.google.gson.stream.a
    public JsonToken c0() throws IOException {
        if (this.r == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object p0 = p0();
        if (p0 instanceof Iterator) {
            boolean z = this.q[this.r - 2] instanceof com.google.gson.m;
            Iterator it = (Iterator) p0;
            if (!it.hasNext()) {
                return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            } else if (z) {
                return JsonToken.NAME;
            } else {
                s0(it.next());
                return c0();
            }
        } else if (p0 instanceof com.google.gson.m) {
            return JsonToken.BEGIN_OBJECT;
        } else {
            if (p0 instanceof com.google.gson.h) {
                return JsonToken.BEGIN_ARRAY;
            }
            if (p0 instanceof com.google.gson.n) {
                com.google.gson.n nVar = (com.google.gson.n) p0;
                if (nVar.q()) {
                    return JsonToken.STRING;
                }
                if (nVar.n()) {
                    return JsonToken.BOOLEAN;
                }
                if (nVar.p()) {
                    return JsonToken.NUMBER;
                }
                throw new AssertionError();
            } else if (p0 instanceof com.google.gson.l) {
                return JsonToken.NULL;
            } else {
                if (p0 == v) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    @Override // com.google.gson.stream.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.q = new Object[]{v};
        this.r = 1;
    }

    @Override // com.google.gson.stream.a
    public void d() throws IOException {
        o0(JsonToken.BEGIN_ARRAY);
        s0(((com.google.gson.h) p0()).iterator());
        this.t[this.r - 1] = 0;
    }

    @Override // com.google.gson.stream.a
    public String getPath() {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i2 = 0;
        while (i2 < this.r) {
            Object[] objArr = this.q;
            if (objArr[i2] instanceof com.google.gson.h) {
                i2++;
                if (objArr[i2] instanceof Iterator) {
                    sb.append('[');
                    sb.append(this.t[i2]);
                    sb.append(']');
                }
            } else if (objArr[i2] instanceof com.google.gson.m) {
                i2++;
                if (objArr[i2] instanceof Iterator) {
                    sb.append('.');
                    String[] strArr = this.s;
                    if (strArr[i2] != null) {
                        sb.append(strArr[i2]);
                    }
                }
            }
            i2++;
        }
        return sb.toString();
    }

    @Override // com.google.gson.stream.a
    public void m0() throws IOException {
        if (c0() == JsonToken.NAME) {
            W();
            this.s[this.r - 2] = "null";
        } else {
            q0();
            int i2 = this.r;
            if (i2 > 0) {
                this.s[i2 - 1] = "null";
            }
        }
        int i3 = this.r;
        if (i3 > 0) {
            int[] iArr = this.t;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
        }
    }

    public void r0() throws IOException {
        o0(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) p0()).next();
        s0(entry.getValue());
        s0(new com.google.gson.n((String) entry.getKey()));
    }

    @Override // com.google.gson.stream.a
    public void t() throws IOException {
        o0(JsonToken.BEGIN_OBJECT);
        s0(((com.google.gson.m) p0()).j().iterator());
    }

    @Override // com.google.gson.stream.a
    public String toString() {
        return e.class.getSimpleName();
    }

    @Override // com.google.gson.stream.a
    public void y() throws IOException {
        o0(JsonToken.END_ARRAY);
        q0();
        q0();
        int i2 = this.r;
        if (i2 > 0) {
            int[] iArr = this.t;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public void z() throws IOException {
        o0(JsonToken.END_OBJECT);
        q0();
        q0();
        int i2 = this.r;
        if (i2 > 0) {
            int[] iArr = this.t;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }
}
