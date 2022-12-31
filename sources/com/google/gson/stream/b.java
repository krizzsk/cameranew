package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Objects;
/* compiled from: JsonWriter.java */
/* loaded from: classes2.dex */
public class b implements Closeable, Flushable {

    /* renamed from: j  reason: collision with root package name */
    private static final String[] f4977j = new String[128];

    /* renamed from: k  reason: collision with root package name */
    private static final String[] f4978k;
    private final Writer a;
    private int[] b = new int[32];
    private int c = 0;

    /* renamed from: d  reason: collision with root package name */
    private String f4979d;

    /* renamed from: e  reason: collision with root package name */
    private String f4980e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f4981f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f4982g;

    /* renamed from: h  reason: collision with root package name */
    private String f4983h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f4984i;

    static {
        for (int i2 = 0; i2 <= 31; i2++) {
            f4977j[i2] = String.format("\\u%04x", Integer.valueOf(i2));
        }
        String[] strArr = f4977j;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        f4978k = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public b(Writer writer) {
        V(6);
        this.f4980e = ":";
        this.f4984i = true;
        Objects.requireNonNull(writer, "out == null");
        this.a = writer;
    }

    private void R() throws IOException {
        if (this.f4979d == null) {
            return;
        }
        this.a.write(10);
        int i2 = this.c;
        for (int i3 = 1; i3 < i2; i3++) {
            this.a.write(this.f4979d);
        }
    }

    private b T(int i2, char c) throws IOException {
        t();
        V(i2);
        this.a.write(c);
        return this;
    }

    private int U() {
        int i2 = this.c;
        if (i2 != 0) {
            return this.b[i2 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void V(int i2) {
        int i3 = this.c;
        int[] iArr = this.b;
        if (i3 == iArr.length) {
            this.b = Arrays.copyOf(iArr, i3 * 2);
        }
        int[] iArr2 = this.b;
        int i4 = this.c;
        this.c = i4 + 1;
        iArr2[i4] = i2;
    }

    private void W(int i2) {
        this.b[this.c - 1] = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void b0(java.lang.String r9) throws java.io.IOException {
        /*
            r8 = this;
            boolean r0 = r8.f4982g
            if (r0 == 0) goto L7
            java.lang.String[] r0 = com.google.gson.stream.b.f4978k
            goto L9
        L7:
            java.lang.String[] r0 = com.google.gson.stream.b.f4977j
        L9:
            java.io.Writer r1 = r8.a
            r2 = 34
            r1.write(r2)
            int r1 = r9.length()
            r3 = 0
            r4 = 0
        L16:
            if (r3 >= r1) goto L45
            char r5 = r9.charAt(r3)
            r6 = 128(0x80, float:1.794E-43)
            if (r5 >= r6) goto L25
            r5 = r0[r5]
            if (r5 != 0) goto L32
            goto L42
        L25:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L2c
            java.lang.String r5 = "\\u2028"
            goto L32
        L2c:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L42
            java.lang.String r5 = "\\u2029"
        L32:
            if (r4 >= r3) goto L3b
            java.io.Writer r6 = r8.a
            int r7 = r3 - r4
            r6.write(r9, r4, r7)
        L3b:
            java.io.Writer r4 = r8.a
            r4.write(r5)
            int r4 = r3 + 1
        L42:
            int r3 = r3 + 1
            goto L16
        L45:
            if (r4 >= r1) goto L4d
            java.io.Writer r0 = r8.a
            int r1 = r1 - r4
            r0.write(r9, r4, r1)
        L4d:
            java.io.Writer r9 = r8.a
            r9.write(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.b.b0(java.lang.String):void");
    }

    private void d() throws IOException {
        int U = U();
        if (U == 5) {
            this.a.write(44);
        } else if (U != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        R();
        W(4);
    }

    private void h0() throws IOException {
        if (this.f4983h != null) {
            d();
            b0(this.f4983h);
            this.f4983h = null;
        }
    }

    private void t() throws IOException {
        int U = U();
        if (U == 1) {
            W(2);
            R();
        } else if (U == 2) {
            this.a.append(',');
            R();
        } else if (U != 4) {
            if (U != 6) {
                if (U == 7) {
                    if (!this.f4981f) {
                        throw new IllegalStateException("JSON must have only one top-level value.");
                    }
                } else {
                    throw new IllegalStateException("Nesting problem.");
                }
            }
            W(7);
        } else {
            this.a.append((CharSequence) this.f4980e);
            W(5);
        }
    }

    private b x(int i2, int i3, char c) throws IOException {
        int U = U();
        if (U != i3 && U != i2) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.f4983h == null) {
            this.c--;
            if (U == i3) {
                R();
            }
            this.a.write(c);
            return this;
        }
        throw new IllegalStateException("Dangling name: " + this.f4983h);
    }

    public final boolean A() {
        return this.f4984i;
    }

    public final boolean N() {
        return this.f4982g;
    }

    public boolean O() {
        return this.f4981f;
    }

    public b Q(String str) throws IOException {
        Objects.requireNonNull(str, "name == null");
        if (this.f4983h == null) {
            if (this.c != 0) {
                this.f4983h = str;
                return this;
            }
            throw new IllegalStateException("JsonWriter is closed.");
        }
        throw new IllegalStateException();
    }

    public b S() throws IOException {
        if (this.f4983h != null) {
            if (this.f4984i) {
                h0();
            } else {
                this.f4983h = null;
                return this;
            }
        }
        t();
        this.a.write("null");
        return this;
    }

    public final void X(boolean z) {
        this.f4982g = z;
    }

    public final void Y(String str) {
        if (str.length() == 0) {
            this.f4979d = null;
            this.f4980e = ":";
            return;
        }
        this.f4979d = str;
        this.f4980e = ": ";
    }

    public final void Z(boolean z) {
        this.f4981f = z;
    }

    public final void a0(boolean z) {
        this.f4984i = z;
    }

    public b c0(long j2) throws IOException {
        h0();
        t();
        this.a.write(Long.toString(j2));
        return this;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.a.close();
        int i2 = this.c;
        if (i2 <= 1 && (i2 != 1 || this.b[i2 - 1] == 7)) {
            this.c = 0;
            return;
        }
        throw new IOException("Incomplete document");
    }

    public b d0(Boolean bool) throws IOException {
        if (bool == null) {
            return S();
        }
        h0();
        t();
        this.a.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public b e0(Number number) throws IOException {
        if (number == null) {
            return S();
        }
        h0();
        String obj = number.toString();
        if (!this.f4981f && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        t();
        this.a.append((CharSequence) obj);
        return this;
    }

    public b f0(String str) throws IOException {
        if (str == null) {
            return S();
        }
        h0();
        t();
        b0(str);
        return this;
    }

    public void flush() throws IOException {
        if (this.c != 0) {
            this.a.flush();
            return;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public b g0(boolean z) throws IOException {
        h0();
        t();
        this.a.write(z ? "true" : "false");
        return this;
    }

    public b v() throws IOException {
        h0();
        T(1, '[');
        return this;
    }

    public b w() throws IOException {
        h0();
        T(3, '{');
        return this;
    }

    public b y() throws IOException {
        x(1, 2, ']');
        return this;
    }

    public b z() throws IOException {
        x(3, 5, '}');
        return this;
    }
}
