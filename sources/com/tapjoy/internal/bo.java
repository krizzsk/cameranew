package com.tapjoy.internal;

import com.tapjoy.internal.bn;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/* loaded from: classes3.dex */
public final class bo extends bn {
    public static final bn.a a = new bn.a() { // from class: com.tapjoy.internal.bo.1
        @Override // com.tapjoy.internal.bn.a
        public final bn a(Reader reader) {
            return new bo(reader);
        }

        @Override // com.tapjoy.internal.bn.a
        public final bn a(String str) {
            return new bo(new StringReader(str));
        }
    };
    private final Reader c;

    /* renamed from: k  reason: collision with root package name */
    private bs f7327k;

    /* renamed from: l  reason: collision with root package name */
    private String f7328l;
    private String m;
    private int n;
    private int o;
    private boolean p;
    private final cj b = new cj();

    /* renamed from: d  reason: collision with root package name */
    private boolean f7320d = false;

    /* renamed from: e  reason: collision with root package name */
    private final char[] f7321e = new char[1024];

    /* renamed from: f  reason: collision with root package name */
    private int f7322f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f7323g = 0;

    /* renamed from: h  reason: collision with root package name */
    private int f7324h = 1;

    /* renamed from: i  reason: collision with root package name */
    private int f7325i = 1;

    /* renamed from: j  reason: collision with root package name */
    private final List f7326j = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tapjoy.internal.bo$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[bq.values().length];
            a = iArr;
            try {
                iArr[bq.EMPTY_DOCUMENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[bq.EMPTY_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[bq.NONEMPTY_ARRAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[bq.EMPTY_OBJECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[bq.DANGLING_NAME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[bq.NONEMPTY_OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[bq.NONEMPTY_DOCUMENT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[bq.CLOSED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public bo(Reader reader) {
        a(bq.EMPTY_DOCUMENT);
        this.p = false;
        Objects.requireNonNull(reader, "in == null");
        this.c = reader;
    }

    private void A() {
        char c;
        do {
            if (this.f7322f >= this.f7323g && !a(1)) {
                return;
            }
            char[] cArr = this.f7321e;
            int i2 = this.f7322f;
            this.f7322f = i2 + 1;
            c = cArr[i2];
            if (c == '\r') {
                return;
            }
        } while (c != '\n');
    }

    private void a(bs bsVar) {
        k();
        if (this.f7327k == bsVar) {
            t();
            return;
        }
        throw new IllegalStateException("Expected " + bsVar + " but was " + k());
    }

    private void b(bq bqVar) {
        List list = this.f7326j;
        list.set(list.size() - 1, bqVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0050, code lost:
        z();
     */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String c(boolean r8) {
        /*
            r7 = this;
            r0 = -1
            r7.n = r0
            r0 = 0
            r7.o = r0
            r1 = 0
            r3 = r1
        L8:
            r2 = 0
        L9:
            int r4 = r7.f7322f
            int r5 = r4 + r2
            int r6 = r7.f7323g
            if (r5 >= r6) goto L54
            char[] r5 = r7.f7321e
            int r4 = r4 + r2
            char r4 = r5[r4]
            r5 = 9
            if (r4 == r5) goto L67
            r5 = 10
            if (r4 == r5) goto L67
            r5 = 12
            if (r4 == r5) goto L67
            r5 = 13
            if (r4 == r5) goto L67
            r5 = 32
            if (r4 == r5) goto L67
            r5 = 35
            if (r4 == r5) goto L50
            r5 = 44
            if (r4 == r5) goto L67
            r5 = 47
            if (r4 == r5) goto L50
            r5 = 61
            if (r4 == r5) goto L50
            r5 = 123(0x7b, float:1.72E-43)
            if (r4 == r5) goto L67
            r5 = 125(0x7d, float:1.75E-43)
            if (r4 == r5) goto L67
            r5 = 58
            if (r4 == r5) goto L67
            r5 = 59
            if (r4 == r5) goto L50
            switch(r4) {
                case 91: goto L67;
                case 92: goto L50;
                case 93: goto L67;
                default: goto L4d;
            }
        L4d:
            int r2 = r2 + 1
            goto L9
        L50:
            r7.z()
            goto L67
        L54:
            char[] r4 = r7.f7321e
            int r4 = r4.length
            if (r2 >= r4) goto L69
            int r4 = r2 + 1
            boolean r4 = r7.a(r4)
            if (r4 != 0) goto L9
            char[] r4 = r7.f7321e
            int r5 = r7.f7323g
            r4[r5] = r0
        L67:
            r0 = r2
            goto L88
        L69:
            if (r3 != 0) goto L70
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
        L70:
            char[] r4 = r7.f7321e
            int r5 = r7.f7322f
            r3.append(r4, r5, r2)
            int r4 = r7.o
            int r4 = r4 + r2
            r7.o = r4
            int r4 = r7.f7322f
            int r4 = r4 + r2
            r7.f7322f = r4
            r2 = 1
            boolean r2 = r7.a(r2)
            if (r2 != 0) goto L8
        L88:
            if (r8 == 0) goto L91
            if (r3 != 0) goto L91
            int r8 = r7.f7322f
            r7.n = r8
            goto Lb0
        L91:
            boolean r8 = r7.p
            if (r8 == 0) goto L98
            java.lang.String r1 = "skipped!"
            goto Lb0
        L98:
            if (r3 != 0) goto La5
            com.tapjoy.internal.cj r8 = r7.b
            char[] r1 = r7.f7321e
            int r2 = r7.f7322f
            java.lang.String r1 = r8.a(r1, r2, r0)
            goto Lb0
        La5:
            char[] r8 = r7.f7321e
            int r1 = r7.f7322f
            r3.append(r8, r1, r0)
            java.lang.String r1 = r3.toString()
        Lb0:
            int r8 = r7.o
            int r8 = r8 + r0
            r7.o = r8
            int r8 = r7.f7322f
            int r8 = r8 + r0
            r7.f7322f = r8
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.bo.c(boolean):java.lang.String");
    }

    private IOException d(String str) {
        throw new bu(str + " at line " + w() + " column " + x());
    }

    private bs t() {
        k();
        bs bsVar = this.f7327k;
        this.f7327k = null;
        this.m = null;
        this.f7328l = null;
        return bsVar;
    }

    private bq u() {
        List list = this.f7326j;
        return (bq) list.remove(list.size() - 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x0185  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.tapjoy.internal.bs v() {
        /*
            Method dump skipped, instructions count: 437
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.bo.v():com.tapjoy.internal.bs");
    }

    private int w() {
        int i2 = this.f7324h;
        for (int i3 = 0; i3 < this.f7322f; i3++) {
            if (this.f7321e[i3] == '\n') {
                i2++;
            }
        }
        return i2;
    }

    private int x() {
        int i2 = this.f7325i;
        for (int i3 = 0; i3 < this.f7322f; i3++) {
            i2 = this.f7321e[i3] == '\n' ? 1 : i2 + 1;
        }
        return i2;
    }

    private int y() {
        int i2;
        while (true) {
            boolean z = true;
            if (this.f7322f >= this.f7323g && !a(1)) {
                throw new EOFException("End of input");
            }
            char[] cArr = this.f7321e;
            int i3 = this.f7322f;
            int i4 = i3 + 1;
            this.f7322f = i4;
            char c = cArr[i3];
            if (c != '\t' && c != '\n' && c != '\r' && c != ' ') {
                if (c == '#') {
                    z();
                    A();
                } else if (c != '/') {
                    return c;
                } else {
                    if (i4 == this.f7323g && !a(1)) {
                        return c;
                    }
                    z();
                    char[] cArr2 = this.f7321e;
                    int i5 = this.f7322f;
                    char c2 = cArr2[i5];
                    if (c2 == '*') {
                        this.f7322f = i5 + 1;
                        while (true) {
                            if (this.f7322f + 2 > this.f7323g && !a(2)) {
                                z = false;
                                break;
                            }
                            while (i2 < 2) {
                                i2 = this.f7321e[this.f7322f + i2] == "*/".charAt(i2) ? i2 + 1 : 0;
                            }
                            break;
                            this.f7322f++;
                        }
                        if (z) {
                            this.f7322f += 2;
                        } else {
                            throw d("Unterminated comment");
                        }
                    } else if (c2 != '/') {
                        return c;
                    } else {
                        this.f7322f = i5 + 1;
                        A();
                    }
                }
            }
        }
    }

    private void z() {
        if (!this.f7320d) {
            throw d("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    @Override // com.tapjoy.internal.bp, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.m = null;
        this.f7327k = null;
        this.f7326j.clear();
        this.f7326j.add(bq.CLOSED);
        this.c.close();
    }

    @Override // com.tapjoy.internal.bp
    public final void f() {
        a(bs.BEGIN_ARRAY);
    }

    @Override // com.tapjoy.internal.bp
    public final void g() {
        a(bs.END_ARRAY);
    }

    @Override // com.tapjoy.internal.bp
    public final void h() {
        a(bs.BEGIN_OBJECT);
    }

    @Override // com.tapjoy.internal.bp
    public final void i() {
        a(bs.END_OBJECT);
    }

    @Override // com.tapjoy.internal.bp
    public final boolean j() {
        k();
        bs bsVar = this.f7327k;
        return (bsVar == bs.END_OBJECT || bsVar == bs.END_ARRAY) ? false : true;
    }

    @Override // com.tapjoy.internal.bp
    public final bs k() {
        bs bsVar;
        bs bsVar2 = this.f7327k;
        if (bsVar2 != null) {
            return bsVar2;
        }
        int[] iArr = AnonymousClass2.a;
        List list = this.f7326j;
        switch (iArr[((bq) list.get(list.size() - 1)).ordinal()]) {
            case 1:
                b(bq.NONEMPTY_DOCUMENT);
                bs v = v();
                if (this.f7320d || (bsVar = this.f7327k) == bs.BEGIN_ARRAY || bsVar == bs.BEGIN_OBJECT) {
                    return v;
                }
                throw new IOException("Expected JSON document to start with '[' or '{' but was " + this.f7327k);
            case 2:
                return a(true);
            case 3:
                return a(false);
            case 4:
                return b(true);
            case 5:
                int y = y();
                if (y != 58) {
                    if (y == 61) {
                        z();
                        if (this.f7322f < this.f7323g || a(1)) {
                            char[] cArr = this.f7321e;
                            int i2 = this.f7322f;
                            if (cArr[i2] == '>') {
                                this.f7322f = i2 + 1;
                            }
                        }
                    } else {
                        throw d("Expected ':'");
                    }
                }
                b(bq.NONEMPTY_OBJECT);
                return v();
            case 6:
                return b(false);
            case 7:
                try {
                    bs v2 = v();
                    if (this.f7320d) {
                        return v2;
                    }
                    throw d("Expected EOF");
                } catch (EOFException unused) {
                    bs bsVar3 = bs.END_DOCUMENT;
                    this.f7327k = bsVar3;
                    return bsVar3;
                }
            case 8:
                throw new IllegalStateException("JsonReader is closed");
            default:
                throw new AssertionError();
        }
    }

    @Override // com.tapjoy.internal.bp
    public final String l() {
        k();
        if (this.f7327k == bs.NAME) {
            String str = this.f7328l;
            t();
            return str;
        }
        throw new IllegalStateException("Expected a name but was " + k());
    }

    @Override // com.tapjoy.internal.bp
    public final String m() {
        k();
        bs bsVar = this.f7327k;
        if (bsVar != bs.STRING && bsVar != bs.NUMBER) {
            throw new IllegalStateException("Expected a string but was " + k());
        }
        String str = this.m;
        t();
        return str;
    }

    @Override // com.tapjoy.internal.bp
    public final boolean n() {
        k();
        if (this.f7327k == bs.BOOLEAN) {
            boolean z = this.m == "true";
            t();
            return z;
        }
        throw new IllegalStateException("Expected a boolean but was " + this.f7327k);
    }

    @Override // com.tapjoy.internal.bp
    public final void o() {
        k();
        if (this.f7327k == bs.NULL) {
            t();
            return;
        }
        throw new IllegalStateException("Expected null but was " + this.f7327k);
    }

    @Override // com.tapjoy.internal.bp
    public final double p() {
        k();
        bs bsVar = this.f7327k;
        if (bsVar != bs.STRING && bsVar != bs.NUMBER) {
            throw new IllegalStateException("Expected a double but was " + this.f7327k);
        }
        double parseDouble = Double.parseDouble(this.m);
        t();
        return parseDouble;
    }

    @Override // com.tapjoy.internal.bp
    public final long q() {
        long j2;
        k();
        bs bsVar = this.f7327k;
        if (bsVar != bs.STRING && bsVar != bs.NUMBER) {
            throw new IllegalStateException("Expected a long but was " + this.f7327k);
        }
        try {
            j2 = Long.parseLong(this.m);
        } catch (NumberFormatException unused) {
            double parseDouble = Double.parseDouble(this.m);
            long j3 = (long) parseDouble;
            if (j3 != parseDouble) {
                throw new NumberFormatException(this.m);
            }
            j2 = j3;
        }
        t();
        return j2;
    }

    @Override // com.tapjoy.internal.bp
    public final int r() {
        int i2;
        k();
        bs bsVar = this.f7327k;
        if (bsVar != bs.STRING && bsVar != bs.NUMBER) {
            throw new IllegalStateException("Expected an int but was " + this.f7327k);
        }
        try {
            i2 = Integer.parseInt(this.m);
        } catch (NumberFormatException unused) {
            double parseDouble = Double.parseDouble(this.m);
            int i3 = (int) parseDouble;
            if (i3 != parseDouble) {
                throw new NumberFormatException(this.m);
            }
            i2 = i3;
        }
        t();
        return i2;
    }

    @Override // com.tapjoy.internal.bp
    public final void s() {
        k();
        bs bsVar = this.f7327k;
        if (bsVar != bs.END_ARRAY && bsVar != bs.END_OBJECT) {
            this.p = true;
            int i2 = 0;
            do {
                try {
                    bs t = t();
                    if (t != bs.BEGIN_ARRAY && t != bs.BEGIN_OBJECT) {
                        if (t == bs.END_ARRAY || t == bs.END_OBJECT) {
                            i2--;
                            continue;
                        }
                    }
                    i2++;
                } finally {
                    this.p = false;
                }
            } while (i2 != 0);
            return;
        }
        throw new IllegalStateException("Expected a value but was " + this.f7327k);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(bo.class.getSimpleName());
        sb.append(" near ");
        StringBuilder sb2 = new StringBuilder();
        int min = Math.min(this.f7322f, 20);
        sb2.append(this.f7321e, this.f7322f - min, min);
        sb2.append(this.f7321e, this.f7322f, Math.min(this.f7323g - this.f7322f, 20));
        sb.append((Object) sb2);
        return sb.toString();
    }

    private bs b(boolean z) {
        if (z) {
            if (y() != 125) {
                this.f7322f--;
            } else {
                u();
                bs bsVar = bs.END_OBJECT;
                this.f7327k = bsVar;
                return bsVar;
            }
        } else {
            int y = y();
            if (y != 44 && y != 59) {
                if (y == 125) {
                    u();
                    bs bsVar2 = bs.END_OBJECT;
                    this.f7327k = bsVar2;
                    return bsVar2;
                }
                throw d("Unterminated object");
            }
        }
        int y2 = y();
        if (y2 != 34) {
            if (y2 != 39) {
                z();
                this.f7322f--;
                String c = c(false);
                this.f7328l = c;
                if (c.length() == 0) {
                    throw d("Expected name");
                }
                b(bq.DANGLING_NAME);
                bs bsVar3 = bs.NAME;
                this.f7327k = bsVar3;
                return bsVar3;
            }
            z();
        }
        this.f7328l = a((char) y2);
        b(bq.DANGLING_NAME);
        bs bsVar32 = bs.NAME;
        this.f7327k = bsVar32;
        return bsVar32;
    }

    private void a(bq bqVar) {
        this.f7326j.add(bqVar);
    }

    private bs a(boolean z) {
        if (z) {
            b(bq.NONEMPTY_ARRAY);
        } else {
            int y = y();
            if (y != 44) {
                if (y != 59) {
                    if (y == 93) {
                        u();
                        bs bsVar = bs.END_ARRAY;
                        this.f7327k = bsVar;
                        return bsVar;
                    }
                    throw d("Unterminated array");
                }
                z();
            }
        }
        int y2 = y();
        if (y2 != 44 && y2 != 59) {
            if (y2 != 93) {
                this.f7322f--;
                return v();
            } else if (z) {
                u();
                bs bsVar2 = bs.END_ARRAY;
                this.f7327k = bsVar2;
                return bsVar2;
            }
        }
        z();
        this.f7322f--;
        this.m = "null";
        bs bsVar3 = bs.NULL;
        this.f7327k = bsVar3;
        return bsVar3;
    }

    private boolean a(int i2) {
        int i3;
        int i4;
        int i5;
        int i6 = 0;
        while (true) {
            i3 = this.f7322f;
            if (i6 >= i3) {
                break;
            }
            if (this.f7321e[i6] == '\n') {
                this.f7324h++;
                this.f7325i = 1;
            } else {
                this.f7325i++;
            }
            i6++;
        }
        int i7 = this.f7323g;
        if (i7 != i3) {
            int i8 = i7 - i3;
            this.f7323g = i8;
            char[] cArr = this.f7321e;
            System.arraycopy(cArr, i3, cArr, 0, i8);
        } else {
            this.f7323g = 0;
        }
        this.f7322f = 0;
        do {
            Reader reader = this.c;
            char[] cArr2 = this.f7321e;
            int i9 = this.f7323g;
            int read = reader.read(cArr2, i9, cArr2.length - i9);
            if (read == -1) {
                return false;
            }
            i4 = this.f7323g + read;
            this.f7323g = i4;
            if (this.f7324h == 1 && (i5 = this.f7325i) == 1 && i4 > 0 && this.f7321e[0] == 65279) {
                this.f7322f++;
                this.f7325i = i5 - 1;
                continue;
            }
        } while (i4 < i2);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x00ba, code lost:
        if (r0 != null) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00bc, code lost:
        r0 = new java.lang.StringBuilder();
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00c1, code lost:
        r0.append(r6.f7321e, r1, r6.f7322f - r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String a(char r7) {
        /*
            Method dump skipped, instructions count: 216
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.bo.a(char):java.lang.String");
    }
}
