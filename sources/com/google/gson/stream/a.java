package com.google.gson.stream;

import com.google.gson.internal.e;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;
/* compiled from: JsonReader.java */
/* loaded from: classes2.dex */
public class a implements Closeable {
    private static final char[] p = ")]}'\n".toCharArray();
    private final Reader a;
    private boolean b = false;
    private final char[] c = new char[1024];

    /* renamed from: d  reason: collision with root package name */
    private int f4968d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f4969e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f4970f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f4971g = 0;

    /* renamed from: h  reason: collision with root package name */
    int f4972h = 0;

    /* renamed from: i  reason: collision with root package name */
    private long f4973i;

    /* renamed from: j  reason: collision with root package name */
    private int f4974j;

    /* renamed from: k  reason: collision with root package name */
    private String f4975k;

    /* renamed from: l  reason: collision with root package name */
    private int[] f4976l;
    private int m;
    private String[] n;
    private int[] o;

    /* compiled from: JsonReader.java */
    /* renamed from: com.google.gson.stream.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0191a extends e {
        C0191a() {
        }

        @Override // com.google.gson.internal.e
        public void a(a aVar) throws IOException {
            if (aVar instanceof com.google.gson.internal.k.e) {
                ((com.google.gson.internal.k.e) aVar).r0();
                return;
            }
            int i2 = aVar.f4972h;
            if (i2 == 0) {
                i2 = aVar.x();
            }
            if (i2 == 13) {
                aVar.f4972h = 9;
            } else if (i2 == 12) {
                aVar.f4972h = 8;
            } else if (i2 == 14) {
                aVar.f4972h = 10;
            } else {
                throw new IllegalStateException("Expected a name but was " + aVar.c0() + aVar.R());
            }
        }
    }

    static {
        e.a = new C0191a();
    }

    public a(Reader reader) {
        int[] iArr = new int[32];
        this.f4976l = iArr;
        this.m = 0;
        this.m = 0 + 1;
        iArr[0] = 6;
        this.n = new String[32];
        this.o = new int[32];
        Objects.requireNonNull(reader, "in == null");
        this.a = reader;
    }

    private boolean A(int i2) throws IOException {
        int i3;
        int i4;
        char[] cArr = this.c;
        int i5 = this.f4971g;
        int i6 = this.f4968d;
        this.f4971g = i5 - i6;
        int i7 = this.f4969e;
        if (i7 != i6) {
            int i8 = i7 - i6;
            this.f4969e = i8;
            System.arraycopy(cArr, i6, cArr, 0, i8);
        } else {
            this.f4969e = 0;
        }
        this.f4968d = 0;
        do {
            Reader reader = this.a;
            int i9 = this.f4969e;
            int read = reader.read(cArr, i9, cArr.length - i9);
            if (read == -1) {
                return false;
            }
            i3 = this.f4969e + read;
            this.f4969e = i3;
            if (this.f4970f == 0 && (i4 = this.f4971g) == 0 && i3 > 0 && cArr[0] == 65279) {
                this.f4968d++;
                this.f4971g = i4 + 1;
                i2++;
                continue;
            }
        } while (i3 < i2);
        return true;
    }

    private boolean Q(char c) throws IOException {
        if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') {
            return false;
        }
        if (c != '#') {
            if (c == ',') {
                return false;
            }
            if (c != '/' && c != '=') {
                if (c == '{' || c == '}' || c == ':') {
                    return false;
                }
                if (c != ';') {
                    switch (c) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        v();
        return false;
    }

    private int X(boolean z) throws IOException {
        char[] cArr = this.c;
        int i2 = this.f4968d;
        int i3 = this.f4969e;
        while (true) {
            if (i2 == i3) {
                this.f4968d = i2;
                if (!A(1)) {
                    if (z) {
                        throw new EOFException("End of input" + R());
                    }
                    return -1;
                }
                i2 = this.f4968d;
                i3 = this.f4969e;
            }
            int i4 = i2 + 1;
            char c = cArr[i2];
            if (c == '\n') {
                this.f4970f++;
                this.f4971g = i4;
            } else if (c != ' ' && c != '\r' && c != '\t') {
                if (c == '/') {
                    this.f4968d = i4;
                    if (i4 == i3) {
                        this.f4968d = i4 - 1;
                        boolean A = A(2);
                        this.f4968d++;
                        if (!A) {
                            return c;
                        }
                    }
                    v();
                    int i5 = this.f4968d;
                    char c2 = cArr[i5];
                    if (c2 == '*') {
                        this.f4968d = i5 + 1;
                        if (j0("*/")) {
                            i2 = this.f4968d + 2;
                            i3 = this.f4969e;
                        } else {
                            n0("Unterminated comment");
                            throw null;
                        }
                    } else if (c2 != '/') {
                        return c;
                    } else {
                        this.f4968d = i5 + 1;
                        k0();
                        i2 = this.f4968d;
                        i3 = this.f4969e;
                    }
                } else if (c == '#') {
                    this.f4968d = i4;
                    v();
                    k0();
                    i2 = this.f4968d;
                    i3 = this.f4969e;
                } else {
                    this.f4968d = i4;
                    return c;
                }
            }
            i2 = i4;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005d, code lost:
        if (r2 != null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005f, code lost:
        r2 = new java.lang.StringBuilder(java.lang.Math.max((r3 - r4) * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006d, code lost:
        r2.append(r0, r4, r3 - r4);
        r10.f4968d = r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String Z(char r11) throws java.io.IOException {
        /*
            r10 = this;
            char[] r0 = r10.c
            r1 = 0
            r2 = r1
        L4:
            int r3 = r10.f4968d
            int r4 = r10.f4969e
        L8:
            r5 = r4
            r4 = r3
        La:
            r6 = 16
            r7 = 1
            if (r3 >= r5) goto L5d
            int r8 = r3 + 1
            char r3 = r0[r3]
            if (r3 != r11) goto L29
            r10.f4968d = r8
            int r8 = r8 - r4
            int r8 = r8 - r7
            if (r2 != 0) goto L21
            java.lang.String r11 = new java.lang.String
            r11.<init>(r0, r4, r8)
            return r11
        L21:
            r2.append(r0, r4, r8)
            java.lang.String r11 = r2.toString()
            return r11
        L29:
            r9 = 92
            if (r3 != r9) goto L50
            r10.f4968d = r8
            int r8 = r8 - r4
            int r8 = r8 - r7
            if (r2 != 0) goto L41
            int r2 = r8 + 1
            int r2 = r2 * 2
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            int r2 = java.lang.Math.max(r2, r6)
            r3.<init>(r2)
            r2 = r3
        L41:
            r2.append(r0, r4, r8)
            char r3 = r10.g0()
            r2.append(r3)
            int r3 = r10.f4968d
            int r4 = r10.f4969e
            goto L8
        L50:
            r6 = 10
            if (r3 != r6) goto L5b
            int r3 = r10.f4970f
            int r3 = r3 + r7
            r10.f4970f = r3
            r10.f4971g = r8
        L5b:
            r3 = r8
            goto La
        L5d:
            if (r2 != 0) goto L6d
            int r2 = r3 - r4
            int r2 = r2 * 2
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            int r2 = java.lang.Math.max(r2, r6)
            r5.<init>(r2)
            r2 = r5
        L6d:
            int r5 = r3 - r4
            r2.append(r0, r4, r5)
            r10.f4968d = r3
            boolean r3 = r10.A(r7)
            if (r3 == 0) goto L7b
            goto L4
        L7b:
            java.lang.String r11 = "Unterminated string"
            r10.n0(r11)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.a.Z(char):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x004a, code lost:
        v();
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String b0() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = 0
        L3:
            int r3 = r6.f4968d
            int r4 = r3 + r2
            int r5 = r6.f4969e
            if (r4 >= r5) goto L4e
            char[] r4 = r6.c
            int r3 = r3 + r2
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L5c
            r4 = 10
            if (r3 == r4) goto L5c
            r4 = 12
            if (r3 == r4) goto L5c
            r4 = 13
            if (r3 == r4) goto L5c
            r4 = 32
            if (r3 == r4) goto L5c
            r4 = 35
            if (r3 == r4) goto L4a
            r4 = 44
            if (r3 == r4) goto L5c
            r4 = 47
            if (r3 == r4) goto L4a
            r4 = 61
            if (r3 == r4) goto L4a
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L5c
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L5c
            r4 = 58
            if (r3 == r4) goto L5c
            r4 = 59
            if (r3 == r4) goto L4a
            switch(r3) {
                case 91: goto L5c;
                case 92: goto L4a;
                case 93: goto L5c;
                default: goto L47;
            }
        L47:
            int r2 = r2 + 1
            goto L3
        L4a:
            r6.v()
            goto L5c
        L4e:
            char[] r3 = r6.c
            int r3 = r3.length
            if (r2 >= r3) goto L5e
            int r3 = r2 + 1
            boolean r3 = r6.A(r3)
            if (r3 == 0) goto L5c
            goto L3
        L5c:
            r0 = r2
            goto L7e
        L5e:
            if (r1 != 0) goto L6b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r1.<init>(r3)
        L6b:
            char[] r3 = r6.c
            int r4 = r6.f4968d
            r1.append(r3, r4, r2)
            int r3 = r6.f4968d
            int r3 = r3 + r2
            r6.f4968d = r3
            r2 = 1
            boolean r2 = r6.A(r2)
            if (r2 != 0) goto L2
        L7e:
            if (r1 != 0) goto L8a
            java.lang.String r1 = new java.lang.String
            char[] r2 = r6.c
            int r3 = r6.f4968d
            r1.<init>(r2, r3, r0)
            goto L95
        L8a:
            char[] r2 = r6.c
            int r3 = r6.f4968d
            r1.append(r2, r3, r0)
            java.lang.String r1 = r1.toString()
        L95:
            int r2 = r6.f4968d
            int r2 = r2 + r0
            r6.f4968d = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.a.b0():java.lang.String");
    }

    private int d0() throws IOException {
        int i2;
        String str;
        String str2;
        char c = this.c[this.f4968d];
        if (c == 't' || c == 'T') {
            i2 = 5;
            str = "true";
            str2 = "TRUE";
        } else if (c == 'f' || c == 'F') {
            i2 = 6;
            str = "false";
            str2 = "FALSE";
        } else if (c != 'n' && c != 'N') {
            return 0;
        } else {
            i2 = 7;
            str = "null";
            str2 = "NULL";
        }
        int length = str.length();
        for (int i3 = 1; i3 < length; i3++) {
            if (this.f4968d + i3 >= this.f4969e && !A(i3 + 1)) {
                return 0;
            }
            char c2 = this.c[this.f4968d + i3];
            if (c2 != str.charAt(i3) && c2 != str2.charAt(i3)) {
                return 0;
            }
        }
        if ((this.f4968d + length < this.f4969e || A(length + 1)) && Q(this.c[this.f4968d + length])) {
            return 0;
        }
        this.f4968d += length;
        this.f4972h = i2;
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0095, code lost:
        if (Q(r14) != false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0097, code lost:
        if (r9 != 2) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0099, code lost:
        if (r10 == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x009f, code lost:
        if (r11 != Long.MIN_VALUE) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00a1, code lost:
        if (r13 == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a7, code lost:
        if (r11 != 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00a9, code lost:
        if (r13 != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00ab, code lost:
        if (r13 == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00ae, code lost:
        r11 = -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00af, code lost:
        r18.f4973i = r11;
        r18.f4968d += r8;
        r18.f4972h = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00ba, code lost:
        return 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00bb, code lost:
        if (r9 == 2) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00be, code lost:
        if (r9 == 4) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00c1, code lost:
        if (r9 != 7) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00c4, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00c6, code lost:
        r18.f4974j = r8;
        r18.f4972h = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00cc, code lost:
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00cd, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int e0() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.a.e0():int");
    }

    private void f0(int i2) {
        int i3 = this.m;
        int[] iArr = this.f4976l;
        if (i3 == iArr.length) {
            int i4 = i3 * 2;
            this.f4976l = Arrays.copyOf(iArr, i4);
            this.o = Arrays.copyOf(this.o, i4);
            this.n = (String[]) Arrays.copyOf(this.n, i4);
        }
        int[] iArr2 = this.f4976l;
        int i5 = this.m;
        this.m = i5 + 1;
        iArr2[i5] = i2;
    }

    private char g0() throws IOException {
        int i2;
        int i3;
        if (this.f4968d == this.f4969e && !A(1)) {
            n0("Unterminated escape sequence");
            throw null;
        }
        char[] cArr = this.c;
        int i4 = this.f4968d;
        int i5 = i4 + 1;
        this.f4968d = i5;
        char c = cArr[i4];
        if (c == '\n') {
            this.f4970f++;
            this.f4971g = i5;
        } else if (c != '\"' && c != '\'' && c != '/' && c != '\\') {
            if (c != 'b') {
                if (c != 'f') {
                    if (c != 'n') {
                        if (c != 'r') {
                            if (c != 't') {
                                if (c == 'u') {
                                    if (i5 + 4 > this.f4969e && !A(4)) {
                                        n0("Unterminated escape sequence");
                                        throw null;
                                    }
                                    char c2 = 0;
                                    int i6 = this.f4968d;
                                    int i7 = i6 + 4;
                                    while (i6 < i7) {
                                        char c3 = this.c[i6];
                                        char c4 = (char) (c2 << 4);
                                        if (c3 < '0' || c3 > '9') {
                                            if (c3 >= 'a' && c3 <= 'f') {
                                                i2 = c3 - 'a';
                                            } else if (c3 < 'A' || c3 > 'F') {
                                                throw new NumberFormatException("\\u" + new String(this.c, this.f4968d, 4));
                                            } else {
                                                i2 = c3 - 'A';
                                            }
                                            i3 = i2 + 10;
                                        } else {
                                            i3 = c3 - '0';
                                        }
                                        c2 = (char) (c4 + i3);
                                        i6++;
                                    }
                                    this.f4968d += 4;
                                    return c2;
                                }
                                n0("Invalid escape sequence");
                                throw null;
                            }
                            return '\t';
                        }
                        return '\r';
                    }
                    return '\n';
                }
                return '\f';
            }
            return '\b';
        }
        return c;
    }

    private void i0(char c) throws IOException {
        char[] cArr = this.c;
        do {
            int i2 = this.f4968d;
            int i3 = this.f4969e;
            while (i2 < i3) {
                int i4 = i2 + 1;
                char c2 = cArr[i2];
                if (c2 == c) {
                    this.f4968d = i4;
                    return;
                } else if (c2 == '\\') {
                    this.f4968d = i4;
                    g0();
                    i2 = this.f4968d;
                    i3 = this.f4969e;
                } else {
                    if (c2 == '\n') {
                        this.f4970f++;
                        this.f4971g = i4;
                    }
                    i2 = i4;
                }
            }
            this.f4968d = i2;
        } while (A(1));
        n0("Unterminated string");
        throw null;
    }

    private boolean j0(String str) throws IOException {
        int length = str.length();
        while (true) {
            if (this.f4968d + length > this.f4969e && !A(length)) {
                return false;
            }
            char[] cArr = this.c;
            int i2 = this.f4968d;
            if (cArr[i2] != '\n') {
                for (int i3 = 0; i3 < length; i3++) {
                    if (this.c[this.f4968d + i3] != str.charAt(i3)) {
                        break;
                    }
                }
                return true;
            }
            this.f4970f++;
            this.f4971g = i2 + 1;
            this.f4968d++;
        }
    }

    private void k0() throws IOException {
        char c;
        do {
            if (this.f4968d >= this.f4969e && !A(1)) {
                return;
            }
            char[] cArr = this.c;
            int i2 = this.f4968d;
            int i3 = i2 + 1;
            this.f4968d = i3;
            c = cArr[i2];
            if (c == '\n') {
                this.f4970f++;
                this.f4971g = i3;
                return;
            }
        } while (c != '\r');
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0048, code lost:
        v();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void l0() throws java.io.IOException {
        /*
            r4 = this;
        L0:
            r0 = 0
        L1:
            int r1 = r4.f4968d
            int r2 = r1 + r0
            int r3 = r4.f4969e
            if (r2 >= r3) goto L51
            char[] r2 = r4.c
            int r1 = r1 + r0
            char r1 = r2[r1]
            r2 = 9
            if (r1 == r2) goto L4b
            r2 = 10
            if (r1 == r2) goto L4b
            r2 = 12
            if (r1 == r2) goto L4b
            r2 = 13
            if (r1 == r2) goto L4b
            r2 = 32
            if (r1 == r2) goto L4b
            r2 = 35
            if (r1 == r2) goto L48
            r2 = 44
            if (r1 == r2) goto L4b
            r2 = 47
            if (r1 == r2) goto L48
            r2 = 61
            if (r1 == r2) goto L48
            r2 = 123(0x7b, float:1.72E-43)
            if (r1 == r2) goto L4b
            r2 = 125(0x7d, float:1.75E-43)
            if (r1 == r2) goto L4b
            r2 = 58
            if (r1 == r2) goto L4b
            r2 = 59
            if (r1 == r2) goto L48
            switch(r1) {
                case 91: goto L4b;
                case 92: goto L48;
                case 93: goto L4b;
                default: goto L45;
            }
        L45:
            int r0 = r0 + 1
            goto L1
        L48:
            r4.v()
        L4b:
            int r1 = r4.f4968d
            int r1 = r1 + r0
            r4.f4968d = r1
            return
        L51:
            int r1 = r1 + r0
            r4.f4968d = r1
            r0 = 1
            boolean r0 = r4.A(r0)
            if (r0 != 0) goto L0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.a.l0():void");
    }

    private IOException n0(String str) throws IOException {
        throw new MalformedJsonException(str + R());
    }

    private void v() throws IOException {
        if (this.b) {
            return;
        }
        n0("Use JsonReader.setLenient(true) to accept malformed JSON");
        throw null;
    }

    private void w() throws IOException {
        X(true);
        int i2 = this.f4968d - 1;
        this.f4968d = i2;
        char[] cArr = p;
        if (i2 + cArr.length > this.f4969e && !A(cArr.length)) {
            return;
        }
        int i3 = 0;
        while (true) {
            char[] cArr2 = p;
            if (i3 < cArr2.length) {
                if (this.c[this.f4968d + i3] != cArr2[i3]) {
                    return;
                }
                i3++;
            } else {
                this.f4968d += cArr2.length;
                return;
            }
        }
    }

    public boolean N() throws IOException {
        int i2 = this.f4972h;
        if (i2 == 0) {
            i2 = x();
        }
        return (i2 == 2 || i2 == 4) ? false : true;
    }

    public final boolean O() {
        return this.b;
    }

    String R() {
        return " at line " + (this.f4970f + 1) + " column " + ((this.f4968d - this.f4971g) + 1) + " path " + getPath();
    }

    public boolean S() throws IOException {
        int i2 = this.f4972h;
        if (i2 == 0) {
            i2 = x();
        }
        if (i2 == 5) {
            this.f4972h = 0;
            int[] iArr = this.o;
            int i3 = this.m - 1;
            iArr[i3] = iArr[i3] + 1;
            return true;
        } else if (i2 == 6) {
            this.f4972h = 0;
            int[] iArr2 = this.o;
            int i4 = this.m - 1;
            iArr2[i4] = iArr2[i4] + 1;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + c0() + R());
        }
    }

    public double T() throws IOException {
        int i2 = this.f4972h;
        if (i2 == 0) {
            i2 = x();
        }
        if (i2 == 15) {
            this.f4972h = 0;
            int[] iArr = this.o;
            int i3 = this.m - 1;
            iArr[i3] = iArr[i3] + 1;
            return this.f4973i;
        }
        if (i2 == 16) {
            this.f4975k = new String(this.c, this.f4968d, this.f4974j);
            this.f4968d += this.f4974j;
        } else if (i2 == 8 || i2 == 9) {
            this.f4975k = Z(i2 == 8 ? '\'' : '\"');
        } else if (i2 == 10) {
            this.f4975k = b0();
        } else if (i2 != 11) {
            throw new IllegalStateException("Expected a double but was " + c0() + R());
        }
        this.f4972h = 11;
        double parseDouble = Double.parseDouble(this.f4975k);
        if (!this.b && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + parseDouble + R());
        }
        this.f4975k = null;
        this.f4972h = 0;
        int[] iArr2 = this.o;
        int i4 = this.m - 1;
        iArr2[i4] = iArr2[i4] + 1;
        return parseDouble;
    }

    public int U() throws IOException {
        int i2 = this.f4972h;
        if (i2 == 0) {
            i2 = x();
        }
        if (i2 == 15) {
            long j2 = this.f4973i;
            int i3 = (int) j2;
            if (j2 == i3) {
                this.f4972h = 0;
                int[] iArr = this.o;
                int i4 = this.m - 1;
                iArr[i4] = iArr[i4] + 1;
                return i3;
            }
            throw new NumberFormatException("Expected an int but was " + this.f4973i + R());
        }
        if (i2 == 16) {
            this.f4975k = new String(this.c, this.f4968d, this.f4974j);
            this.f4968d += this.f4974j;
        } else if (i2 != 8 && i2 != 9 && i2 != 10) {
            throw new IllegalStateException("Expected an int but was " + c0() + R());
        } else {
            if (i2 == 10) {
                this.f4975k = b0();
            } else {
                this.f4975k = Z(i2 == 8 ? '\'' : '\"');
            }
            try {
                int parseInt = Integer.parseInt(this.f4975k);
                this.f4972h = 0;
                int[] iArr2 = this.o;
                int i5 = this.m - 1;
                iArr2[i5] = iArr2[i5] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }
        this.f4972h = 11;
        double parseDouble = Double.parseDouble(this.f4975k);
        int i6 = (int) parseDouble;
        if (i6 == parseDouble) {
            this.f4975k = null;
            this.f4972h = 0;
            int[] iArr3 = this.o;
            int i7 = this.m - 1;
            iArr3[i7] = iArr3[i7] + 1;
            return i6;
        }
        throw new NumberFormatException("Expected an int but was " + this.f4975k + R());
    }

    public long V() throws IOException {
        int i2 = this.f4972h;
        if (i2 == 0) {
            i2 = x();
        }
        if (i2 == 15) {
            this.f4972h = 0;
            int[] iArr = this.o;
            int i3 = this.m - 1;
            iArr[i3] = iArr[i3] + 1;
            return this.f4973i;
        }
        if (i2 == 16) {
            this.f4975k = new String(this.c, this.f4968d, this.f4974j);
            this.f4968d += this.f4974j;
        } else if (i2 != 8 && i2 != 9 && i2 != 10) {
            throw new IllegalStateException("Expected a long but was " + c0() + R());
        } else {
            if (i2 == 10) {
                this.f4975k = b0();
            } else {
                this.f4975k = Z(i2 == 8 ? '\'' : '\"');
            }
            try {
                long parseLong = Long.parseLong(this.f4975k);
                this.f4972h = 0;
                int[] iArr2 = this.o;
                int i4 = this.m - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        this.f4972h = 11;
        double parseDouble = Double.parseDouble(this.f4975k);
        long j2 = (long) parseDouble;
        if (j2 == parseDouble) {
            this.f4975k = null;
            this.f4972h = 0;
            int[] iArr3 = this.o;
            int i5 = this.m - 1;
            iArr3[i5] = iArr3[i5] + 1;
            return j2;
        }
        throw new NumberFormatException("Expected a long but was " + this.f4975k + R());
    }

    public String W() throws IOException {
        String Z;
        int i2 = this.f4972h;
        if (i2 == 0) {
            i2 = x();
        }
        if (i2 == 14) {
            Z = b0();
        } else if (i2 == 12) {
            Z = Z('\'');
        } else if (i2 == 13) {
            Z = Z('\"');
        } else {
            throw new IllegalStateException("Expected a name but was " + c0() + R());
        }
        this.f4972h = 0;
        this.n[this.m - 1] = Z;
        return Z;
    }

    public void Y() throws IOException {
        int i2 = this.f4972h;
        if (i2 == 0) {
            i2 = x();
        }
        if (i2 == 7) {
            this.f4972h = 0;
            int[] iArr = this.o;
            int i3 = this.m - 1;
            iArr[i3] = iArr[i3] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + c0() + R());
    }

    public String a0() throws IOException {
        String str;
        int i2 = this.f4972h;
        if (i2 == 0) {
            i2 = x();
        }
        if (i2 == 10) {
            str = b0();
        } else if (i2 == 8) {
            str = Z('\'');
        } else if (i2 == 9) {
            str = Z('\"');
        } else if (i2 == 11) {
            str = this.f4975k;
            this.f4975k = null;
        } else if (i2 == 15) {
            str = Long.toString(this.f4973i);
        } else if (i2 == 16) {
            str = new String(this.c, this.f4968d, this.f4974j);
            this.f4968d += this.f4974j;
        } else {
            throw new IllegalStateException("Expected a string but was " + c0() + R());
        }
        this.f4972h = 0;
        int[] iArr = this.o;
        int i3 = this.m - 1;
        iArr[i3] = iArr[i3] + 1;
        return str;
    }

    public JsonToken c0() throws IOException {
        int i2 = this.f4972h;
        if (i2 == 0) {
            i2 = x();
        }
        switch (i2) {
            case 1:
                return JsonToken.BEGIN_OBJECT;
            case 2:
                return JsonToken.END_OBJECT;
            case 3:
                return JsonToken.BEGIN_ARRAY;
            case 4:
                return JsonToken.END_ARRAY;
            case 5:
            case 6:
                return JsonToken.BOOLEAN;
            case 7:
                return JsonToken.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonToken.STRING;
            case 12:
            case 13:
            case 14:
                return JsonToken.NAME;
            case 15:
            case 16:
                return JsonToken.NUMBER;
            case 17:
                return JsonToken.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f4972h = 0;
        this.f4976l[0] = 8;
        this.m = 1;
        this.a.close();
    }

    public void d() throws IOException {
        int i2 = this.f4972h;
        if (i2 == 0) {
            i2 = x();
        }
        if (i2 == 3) {
            f0(1);
            this.o[this.m - 1] = 0;
            this.f4972h = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + c0() + R());
    }

    public String getPath() {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i2 = this.m;
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = this.f4976l[i3];
            if (i4 == 1 || i4 == 2) {
                sb.append('[');
                sb.append(this.o[i3]);
                sb.append(']');
            } else if (i4 == 3 || i4 == 4 || i4 == 5) {
                sb.append('.');
                String[] strArr = this.n;
                if (strArr[i3] != null) {
                    sb.append(strArr[i3]);
                }
            }
        }
        return sb.toString();
    }

    public final void h0(boolean z) {
        this.b = z;
    }

    public void m0() throws IOException {
        int i2 = 0;
        do {
            int i3 = this.f4972h;
            if (i3 == 0) {
                i3 = x();
            }
            if (i3 == 3) {
                f0(1);
            } else if (i3 == 1) {
                f0(3);
            } else {
                if (i3 == 4) {
                    this.m--;
                } else if (i3 == 2) {
                    this.m--;
                } else {
                    if (i3 == 14 || i3 == 10) {
                        l0();
                    } else if (i3 == 8 || i3 == 12) {
                        i0('\'');
                    } else if (i3 == 9 || i3 == 13) {
                        i0('\"');
                    } else if (i3 == 16) {
                        this.f4968d += this.f4974j;
                    }
                    this.f4972h = 0;
                }
                i2--;
                this.f4972h = 0;
            }
            i2++;
            this.f4972h = 0;
        } while (i2 != 0);
        int[] iArr = this.o;
        int i4 = this.m;
        int i5 = i4 - 1;
        iArr[i5] = iArr[i5] + 1;
        this.n[i4 - 1] = "null";
    }

    public void t() throws IOException {
        int i2 = this.f4972h;
        if (i2 == 0) {
            i2 = x();
        }
        if (i2 == 1) {
            f0(3);
            this.f4972h = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + c0() + R());
    }

    public String toString() {
        return getClass().getSimpleName() + R();
    }

    int x() throws IOException {
        int X;
        int[] iArr = this.f4976l;
        int i2 = this.m;
        int i3 = iArr[i2 - 1];
        if (i3 == 1) {
            iArr[i2 - 1] = 2;
        } else if (i3 == 2) {
            int X2 = X(true);
            if (X2 != 44) {
                if (X2 != 59) {
                    if (X2 == 93) {
                        this.f4972h = 4;
                        return 4;
                    }
                    n0("Unterminated array");
                    throw null;
                }
                v();
            }
        } else if (i3 == 3 || i3 == 5) {
            iArr[i2 - 1] = 4;
            if (i3 == 5 && (X = X(true)) != 44) {
                if (X != 59) {
                    if (X == 125) {
                        this.f4972h = 2;
                        return 2;
                    }
                    n0("Unterminated object");
                    throw null;
                }
                v();
            }
            int X3 = X(true);
            if (X3 == 34) {
                this.f4972h = 13;
                return 13;
            } else if (X3 == 39) {
                v();
                this.f4972h = 12;
                return 12;
            } else if (X3 == 125) {
                if (i3 != 5) {
                    this.f4972h = 2;
                    return 2;
                }
                n0("Expected name");
                throw null;
            } else {
                v();
                this.f4968d--;
                if (Q((char) X3)) {
                    this.f4972h = 14;
                    return 14;
                }
                n0("Expected name");
                throw null;
            }
        } else if (i3 == 4) {
            iArr[i2 - 1] = 5;
            int X4 = X(true);
            if (X4 != 58) {
                if (X4 == 61) {
                    v();
                    if (this.f4968d < this.f4969e || A(1)) {
                        char[] cArr = this.c;
                        int i4 = this.f4968d;
                        if (cArr[i4] == '>') {
                            this.f4968d = i4 + 1;
                        }
                    }
                } else {
                    n0("Expected ':'");
                    throw null;
                }
            }
        } else if (i3 == 6) {
            if (this.b) {
                w();
            }
            this.f4976l[this.m - 1] = 7;
        } else if (i3 == 7) {
            if (X(false) == -1) {
                this.f4972h = 17;
                return 17;
            }
            v();
            this.f4968d--;
        } else if (i3 == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        int X5 = X(true);
        if (X5 == 34) {
            this.f4972h = 9;
            return 9;
        } else if (X5 == 39) {
            v();
            this.f4972h = 8;
            return 8;
        } else {
            if (X5 != 44 && X5 != 59) {
                if (X5 == 91) {
                    this.f4972h = 3;
                    return 3;
                } else if (X5 != 93) {
                    if (X5 != 123) {
                        this.f4968d--;
                        int d0 = d0();
                        if (d0 != 0) {
                            return d0;
                        }
                        int e0 = e0();
                        if (e0 != 0) {
                            return e0;
                        }
                        if (Q(this.c[this.f4968d])) {
                            v();
                            this.f4972h = 10;
                            return 10;
                        }
                        n0("Expected value");
                        throw null;
                    }
                    this.f4972h = 1;
                    return 1;
                } else if (i3 == 1) {
                    this.f4972h = 4;
                    return 4;
                }
            }
            if (i3 != 1 && i3 != 2) {
                n0("Unexpected value");
                throw null;
            }
            v();
            this.f4968d--;
            this.f4972h = 7;
            return 7;
        }
    }

    public void y() throws IOException {
        int i2 = this.f4972h;
        if (i2 == 0) {
            i2 = x();
        }
        if (i2 == 4) {
            int i3 = this.m - 1;
            this.m = i3;
            int[] iArr = this.o;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
            this.f4972h = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + c0() + R());
    }

    public void z() throws IOException {
        int i2 = this.f4972h;
        if (i2 == 0) {
            i2 = x();
        }
        if (i2 == 2) {
            int i3 = this.m - 1;
            this.m = i3;
            this.n[i3] = null;
            int[] iArr = this.o;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
            this.f4972h = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + c0() + R());
    }
}
