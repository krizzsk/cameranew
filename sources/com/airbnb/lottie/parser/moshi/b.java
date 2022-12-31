package com.airbnb.lottie.parser.moshi;

import androidx.annotation.Nullable;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.EOFException;
import java.io.IOException;
import java.util.Objects;
import okio.ByteString;
import okio.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JsonUtf8Reader.java */
/* loaded from: classes.dex */
public final class b extends JsonReader {
    private static final ByteString n = ByteString.encodeUtf8("'\\");
    private static final ByteString o = ByteString.encodeUtf8("\"\\");
    private static final ByteString p = ByteString.encodeUtf8("{}[]:, \n\t\r\f/\\;#=");
    private static final ByteString q = ByteString.encodeUtf8("\n\r");
    private static final ByteString r = ByteString.encodeUtf8("*/");

    /* renamed from: h  reason: collision with root package name */
    private final d f464h;

    /* renamed from: i  reason: collision with root package name */
    private final okio.b f465i;

    /* renamed from: j  reason: collision with root package name */
    private int f466j = 0;

    /* renamed from: k  reason: collision with root package name */
    private long f467k;

    /* renamed from: l  reason: collision with root package name */
    private int f468l;
    @Nullable
    private String m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(d dVar) {
        Objects.requireNonNull(dVar, "source == null");
        this.f464h = dVar;
        this.f465i = dVar.F();
        S(6);
    }

    private void Y() throws IOException {
        if (this.f454e) {
            return;
        }
        X("Use JsonReader.setLenient(true) to accept malformed JSON");
        throw null;
    }

    private int Z() throws IOException {
        int[] iArr = this.b;
        int i2 = this.a;
        int i3 = iArr[i2 - 1];
        if (i3 == 1) {
            iArr[i2 - 1] = 2;
        } else if (i3 == 2) {
            int c0 = c0(true);
            this.f465i.A();
            if (c0 != 44) {
                if (c0 != 59) {
                    if (c0 == 93) {
                        this.f466j = 4;
                        return 4;
                    }
                    X("Unterminated array");
                    throw null;
                }
                Y();
            }
        } else if (i3 == 3 || i3 == 5) {
            iArr[i2 - 1] = 4;
            if (i3 == 5) {
                int c02 = c0(true);
                this.f465i.A();
                if (c02 != 44) {
                    if (c02 != 59) {
                        if (c02 == 125) {
                            this.f466j = 2;
                            return 2;
                        }
                        X("Unterminated object");
                        throw null;
                    }
                    Y();
                }
            }
            int c03 = c0(true);
            if (c03 == 34) {
                this.f465i.A();
                this.f466j = 13;
                return 13;
            } else if (c03 == 39) {
                this.f465i.A();
                Y();
                this.f466j = 12;
                return 12;
            } else if (c03 != 125) {
                Y();
                if (b0((char) c03)) {
                    this.f466j = 14;
                    return 14;
                }
                X("Expected name");
                throw null;
            } else if (i3 != 5) {
                this.f465i.A();
                this.f466j = 2;
                return 2;
            } else {
                X("Expected name");
                throw null;
            }
        } else if (i3 == 4) {
            iArr[i2 - 1] = 5;
            int c04 = c0(true);
            this.f465i.A();
            if (c04 != 58) {
                if (c04 == 61) {
                    Y();
                    if (this.f464h.request(1L) && this.f465i.w(0L) == 62) {
                        this.f465i.A();
                    }
                } else {
                    X("Expected ':'");
                    throw null;
                }
            }
        } else if (i3 == 6) {
            iArr[i2 - 1] = 7;
        } else if (i3 == 7) {
            if (c0(false) == -1) {
                this.f466j = 18;
                return 18;
            }
            Y();
        } else if (i3 == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        int c05 = c0(true);
        if (c05 == 34) {
            this.f465i.A();
            this.f466j = 9;
            return 9;
        } else if (c05 == 39) {
            Y();
            this.f465i.A();
            this.f466j = 8;
            return 8;
        } else {
            if (c05 != 44 && c05 != 59) {
                if (c05 == 91) {
                    this.f465i.A();
                    this.f466j = 3;
                    return 3;
                } else if (c05 != 93) {
                    if (c05 != 123) {
                        int f0 = f0();
                        if (f0 != 0) {
                            return f0;
                        }
                        int g0 = g0();
                        if (g0 != 0) {
                            return g0;
                        }
                        if (b0(this.f465i.w(0L))) {
                            Y();
                            this.f466j = 10;
                            return 10;
                        }
                        X("Expected value");
                        throw null;
                    }
                    this.f465i.A();
                    this.f466j = 1;
                    return 1;
                } else if (i3 == 1) {
                    this.f465i.A();
                    this.f466j = 4;
                    return 4;
                }
            }
            if (i3 != 1 && i3 != 2) {
                X("Unexpected value");
                throw null;
            }
            Y();
            this.f466j = 7;
            return 7;
        }
    }

    private int a0(String str, JsonReader.a aVar) {
        int length = aVar.a.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(aVar.a[i2])) {
                this.f466j = 0;
                this.c[this.a - 1] = str;
                return i2;
            }
        }
        return -1;
    }

    private boolean b0(int i2) throws IOException {
        if (i2 == 9 || i2 == 10 || i2 == 12 || i2 == 13 || i2 == 32) {
            return false;
        }
        if (i2 != 35) {
            if (i2 == 44) {
                return false;
            }
            if (i2 != 47 && i2 != 61) {
                if (i2 == 123 || i2 == 125 || i2 == 58) {
                    return false;
                }
                if (i2 != 59) {
                    switch (i2) {
                        case 91:
                        case 93:
                            return false;
                        case 92:
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        Y();
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0025, code lost:
        r6.f465i.X(r3 - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
        if (r1 != 47) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0039, code lost:
        if (r6.f464h.request(2) != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003b, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003c, code lost:
        Y();
        r3 = r6.f465i.w(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0049, code lost:
        if (r3 == 42) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004b, code lost:
        if (r3 == 47) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004d, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004e, code lost:
        r6.f465i.A();
        r6.f465i.A();
        k0();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005c, code lost:
        r6.f465i.A();
        r6.f465i.A();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006a, code lost:
        if (j0() == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006d, code lost:
        X("Unterminated comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0073, code lost:
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0076, code lost:
        if (r1 != 35) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0078, code lost:
        Y();
        k0();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007f, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int c0(boolean r7) throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
        L1:
            r1 = 0
        L2:
            okio.d r2 = r6.f464h
            int r3 = r1 + 1
            long r4 = (long) r3
            boolean r2 = r2.request(r4)
            if (r2 == 0) goto L82
            okio.b r2 = r6.f465i
            long r4 = (long) r1
            byte r1 = r2.w(r4)
            r2 = 10
            if (r1 == r2) goto L80
            r2 = 32
            if (r1 == r2) goto L80
            r2 = 13
            if (r1 == r2) goto L80
            r2 = 9
            if (r1 != r2) goto L25
            goto L80
        L25:
            okio.b r2 = r6.f465i
            int r3 = r3 + (-1)
            long r3 = (long) r3
            r2.X(r3)
            r2 = 47
            if (r1 != r2) goto L74
            okio.d r3 = r6.f464h
            r4 = 2
            boolean r3 = r3.request(r4)
            if (r3 != 0) goto L3c
            return r1
        L3c:
            r6.Y()
            okio.b r3 = r6.f465i
            r4 = 1
            byte r3 = r3.w(r4)
            r4 = 42
            if (r3 == r4) goto L5c
            if (r3 == r2) goto L4e
            return r1
        L4e:
            okio.b r1 = r6.f465i
            r1.A()
            okio.b r1 = r6.f465i
            r1.A()
            r6.k0()
            goto L1
        L5c:
            okio.b r1 = r6.f465i
            r1.A()
            okio.b r1 = r6.f465i
            r1.A()
            boolean r1 = r6.j0()
            if (r1 == 0) goto L6d
            goto L1
        L6d:
            java.lang.String r7 = "Unterminated comment"
            r6.X(r7)
            r7 = 0
            throw r7
        L74:
            r2 = 35
            if (r1 != r2) goto L7f
            r6.Y()
            r6.k0()
            goto L1
        L7f:
            return r1
        L80:
            r1 = r3
            goto L2
        L82:
            if (r7 != 0) goto L86
            r7 = -1
            return r7
        L86:
            java.io.EOFException r7 = new java.io.EOFException
            java.lang.String r0 = "End of input"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.moshi.b.c0(boolean):int");
    }

    private String d0(ByteString byteString) throws IOException {
        StringBuilder sb = null;
        while (true) {
            long H = this.f464h.H(byteString);
            if (H != -1) {
                if (this.f465i.w(H) != 92) {
                    if (sb == null) {
                        String V = this.f465i.V(H);
                        this.f465i.A();
                        return V;
                    }
                    sb.append(this.f465i.V(H));
                    this.f465i.A();
                    return sb.toString();
                }
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append(this.f465i.V(H));
                this.f465i.A();
                sb.append(h0());
            } else {
                X("Unterminated string");
                throw null;
            }
        }
    }

    private String e0() throws IOException {
        long H = this.f464h.H(p);
        return H != -1 ? this.f465i.V(H) : this.f465i.U();
    }

    private int f0() throws IOException {
        int i2;
        String str;
        String str2;
        byte w = this.f465i.w(0L);
        if (w == 116 || w == 84) {
            i2 = 5;
            str = "true";
            str2 = "TRUE";
        } else if (w == 102 || w == 70) {
            i2 = 6;
            str = "false";
            str2 = "FALSE";
        } else if (w != 110 && w != 78) {
            return 0;
        } else {
            i2 = 7;
            str = "null";
            str2 = "NULL";
        }
        int length = str.length();
        int i3 = 1;
        while (i3 < length) {
            int i4 = i3 + 1;
            if (!this.f464h.request(i4)) {
                return 0;
            }
            byte w2 = this.f465i.w(i3);
            if (w2 != str.charAt(i3) && w2 != str2.charAt(i3)) {
                return 0;
            }
            i3 = i4;
        }
        if (this.f464h.request(length + 1) && b0(this.f465i.w(length))) {
            return 0;
        }
        this.f465i.X(length);
        this.f466j = i2;
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x0087, code lost:
        if (b0(r11) != false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0089, code lost:
        if (r6 != 2) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x008b, code lost:
        if (r7 == false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0091, code lost:
        if (r8 != Long.MIN_VALUE) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0093, code lost:
        if (r10 == false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0097, code lost:
        if (r8 != 0) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0099, code lost:
        if (r10 != false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x009b, code lost:
        if (r10 == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x009e, code lost:
        r8 = -r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x009f, code lost:
        r16.f467k = r8;
        r16.f465i.X(r5);
        r16.f466j = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00ab, code lost:
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00ac, code lost:
        if (r6 == 2) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00af, code lost:
        if (r6 == 4) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00b2, code lost:
        if (r6 != 7) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00b5, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00b7, code lost:
        r16.f468l = r5;
        r16.f466j = 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00bd, code lost:
        return 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00be, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int g0() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.moshi.b.g0():int");
    }

    private char h0() throws IOException {
        int i2;
        int i3;
        if (this.f464h.request(1L)) {
            byte A = this.f465i.A();
            if (A == 10 || A == 34 || A == 39 || A == 47 || A == 92) {
                return (char) A;
            }
            if (A != 98) {
                if (A != 102) {
                    if (A != 110) {
                        if (A != 114) {
                            if (A != 116) {
                                if (A != 117) {
                                    if (this.f454e) {
                                        return (char) A;
                                    }
                                    X("Invalid escape sequence: \\" + ((char) A));
                                    throw null;
                                } else if (this.f464h.request(4L)) {
                                    char c = 0;
                                    for (int i4 = 0; i4 < 4; i4++) {
                                        byte w = this.f465i.w(i4);
                                        char c2 = (char) (c << 4);
                                        if (w < 48 || w > 57) {
                                            if (w >= 97 && w <= 102) {
                                                i2 = w - 97;
                                            } else if (w < 65 || w > 70) {
                                                X("\\u" + this.f465i.V(4L));
                                                throw null;
                                            } else {
                                                i2 = w - 65;
                                            }
                                            i3 = i2 + 10;
                                        } else {
                                            i3 = w - 48;
                                        }
                                        c = (char) (c2 + i3);
                                    }
                                    this.f465i.X(4L);
                                    return c;
                                } else {
                                    throw new EOFException("Unterminated escape sequence at path " + getPath());
                                }
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
        X("Unterminated escape sequence");
        throw null;
    }

    private void i0(ByteString byteString) throws IOException {
        while (true) {
            long H = this.f464h.H(byteString);
            if (H != -1) {
                if (this.f465i.w(H) == 92) {
                    this.f465i.X(H + 1);
                    h0();
                } else {
                    this.f465i.X(H + 1);
                    return;
                }
            } else {
                X("Unterminated string");
                throw null;
            }
        }
    }

    private boolean j0() throws IOException {
        d dVar = this.f464h;
        ByteString byteString = r;
        long g2 = dVar.g(byteString);
        boolean z = g2 != -1;
        okio.b bVar = this.f465i;
        bVar.X(z ? g2 + byteString.size() : bVar.size());
        return z;
    }

    private void k0() throws IOException {
        long H = this.f464h.H(q);
        okio.b bVar = this.f465i;
        bVar.X(H != -1 ? H + 1 : bVar.size());
    }

    private void l0() throws IOException {
        long H = this.f464h.H(p);
        okio.b bVar = this.f465i;
        if (H == -1) {
            H = bVar.size();
        }
        bVar.X(H);
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public int A() throws IOException {
        String d0;
        int i2 = this.f466j;
        if (i2 == 0) {
            i2 = Z();
        }
        if (i2 == 16) {
            long j2 = this.f467k;
            int i3 = (int) j2;
            if (j2 == i3) {
                this.f466j = 0;
                int[] iArr = this.f453d;
                int i4 = this.a - 1;
                iArr[i4] = iArr[i4] + 1;
                return i3;
            }
            throw new JsonDataException("Expected an int but was " + this.f467k + " at path " + getPath());
        }
        if (i2 == 17) {
            this.m = this.f465i.V(this.f468l);
        } else if (i2 == 9 || i2 == 8) {
            if (i2 == 9) {
                d0 = d0(o);
            } else {
                d0 = d0(n);
            }
            this.m = d0;
            try {
                int parseInt = Integer.parseInt(d0);
                this.f466j = 0;
                int[] iArr2 = this.f453d;
                int i5 = this.a - 1;
                iArr2[i5] = iArr2[i5] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        } else if (i2 != 11) {
            throw new JsonDataException("Expected an int but was " + R() + " at path " + getPath());
        }
        this.f466j = 11;
        try {
            double parseDouble = Double.parseDouble(this.m);
            int i6 = (int) parseDouble;
            if (i6 == parseDouble) {
                this.m = null;
                this.f466j = 0;
                int[] iArr3 = this.f453d;
                int i7 = this.a - 1;
                iArr3[i7] = iArr3[i7] + 1;
                return i6;
            }
            throw new JsonDataException("Expected an int but was " + this.m + " at path " + getPath());
        } catch (NumberFormatException unused2) {
            throw new JsonDataException("Expected an int but was " + this.m + " at path " + getPath());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public String N() throws IOException {
        String str;
        int i2 = this.f466j;
        if (i2 == 0) {
            i2 = Z();
        }
        if (i2 == 14) {
            str = e0();
        } else if (i2 == 13) {
            str = d0(o);
        } else if (i2 == 12) {
            str = d0(n);
        } else if (i2 == 15) {
            str = this.m;
        } else {
            throw new JsonDataException("Expected a name but was " + R() + " at path " + getPath());
        }
        this.f466j = 0;
        this.c[this.a - 1] = str;
        return str;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public String O() throws IOException {
        String V;
        int i2 = this.f466j;
        if (i2 == 0) {
            i2 = Z();
        }
        if (i2 == 10) {
            V = e0();
        } else if (i2 == 9) {
            V = d0(o);
        } else if (i2 == 8) {
            V = d0(n);
        } else if (i2 == 11) {
            V = this.m;
            this.m = null;
        } else if (i2 == 16) {
            V = Long.toString(this.f467k);
        } else if (i2 == 17) {
            V = this.f465i.V(this.f468l);
        } else {
            throw new JsonDataException("Expected a string but was " + R() + " at path " + getPath());
        }
        this.f466j = 0;
        int[] iArr = this.f453d;
        int i3 = this.a - 1;
        iArr[i3] = iArr[i3] + 1;
        return V;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public JsonReader.Token R() throws IOException {
        int i2 = this.f466j;
        if (i2 == 0) {
            i2 = Z();
        }
        switch (i2) {
            case 1:
                return JsonReader.Token.BEGIN_OBJECT;
            case 2:
                return JsonReader.Token.END_OBJECT;
            case 3:
                return JsonReader.Token.BEGIN_ARRAY;
            case 4:
                return JsonReader.Token.END_ARRAY;
            case 5:
            case 6:
                return JsonReader.Token.BOOLEAN;
            case 7:
                return JsonReader.Token.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonReader.Token.STRING;
            case 12:
            case 13:
            case 14:
            case 15:
                return JsonReader.Token.NAME;
            case 16:
            case 17:
                return JsonReader.Token.NUMBER;
            case 18:
                return JsonReader.Token.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public int T(JsonReader.a aVar) throws IOException {
        int i2 = this.f466j;
        if (i2 == 0) {
            i2 = Z();
        }
        if (i2 < 12 || i2 > 15) {
            return -1;
        }
        if (i2 == 15) {
            return a0(this.m, aVar);
        }
        int P = this.f464h.P(aVar.b);
        if (P != -1) {
            this.f466j = 0;
            this.c[this.a - 1] = aVar.a[P];
            return P;
        }
        String str = this.c[this.a - 1];
        String N = N();
        int a0 = a0(N, aVar);
        if (a0 == -1) {
            this.f466j = 15;
            this.m = N;
            this.c[this.a - 1] = str;
        }
        return a0;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void U() throws IOException {
        if (!this.f455f) {
            int i2 = this.f466j;
            if (i2 == 0) {
                i2 = Z();
            }
            if (i2 == 14) {
                l0();
            } else if (i2 == 13) {
                i0(o);
            } else if (i2 == 12) {
                i0(n);
            } else if (i2 != 15) {
                throw new JsonDataException("Expected a name but was " + R() + " at path " + getPath());
            }
            this.f466j = 0;
            this.c[this.a - 1] = "null";
            return;
        }
        throw new JsonDataException("Cannot skip unexpected " + R() + " at " + getPath());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void V() throws IOException {
        if (!this.f455f) {
            int i2 = 0;
            do {
                int i3 = this.f466j;
                if (i3 == 0) {
                    i3 = Z();
                }
                if (i3 == 3) {
                    S(1);
                } else if (i3 == 1) {
                    S(3);
                } else {
                    if (i3 == 4) {
                        i2--;
                        if (i2 >= 0) {
                            this.a--;
                        } else {
                            throw new JsonDataException("Expected a value but was " + R() + " at path " + getPath());
                        }
                    } else if (i3 == 2) {
                        i2--;
                        if (i2 >= 0) {
                            this.a--;
                        } else {
                            throw new JsonDataException("Expected a value but was " + R() + " at path " + getPath());
                        }
                    } else if (i3 == 14 || i3 == 10) {
                        l0();
                    } else if (i3 == 9 || i3 == 13) {
                        i0(o);
                    } else if (i3 == 8 || i3 == 12) {
                        i0(n);
                    } else if (i3 == 17) {
                        this.f465i.X(this.f468l);
                    } else if (i3 == 18) {
                        throw new JsonDataException("Expected a value but was " + R() + " at path " + getPath());
                    }
                    this.f466j = 0;
                }
                i2++;
                this.f466j = 0;
            } while (i2 != 0);
            int[] iArr = this.f453d;
            int i4 = this.a;
            int i5 = i4 - 1;
            iArr[i5] = iArr[i5] + 1;
            this.c[i4 - 1] = "null";
            return;
        }
        throw new JsonDataException("Cannot skip unexpected " + R() + " at " + getPath());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f466j = 0;
        this.b[0] = 8;
        this.a = 1;
        this.f465i.d();
        this.f464h.close();
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void d() throws IOException {
        int i2 = this.f466j;
        if (i2 == 0) {
            i2 = Z();
        }
        if (i2 == 3) {
            S(1);
            this.f453d[this.a - 1] = 0;
            this.f466j = 0;
            return;
        }
        throw new JsonDataException("Expected BEGIN_ARRAY but was " + R() + " at path " + getPath());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void t() throws IOException {
        int i2 = this.f466j;
        if (i2 == 0) {
            i2 = Z();
        }
        if (i2 == 1) {
            S(3);
            this.f466j = 0;
            return;
        }
        throw new JsonDataException("Expected BEGIN_OBJECT but was " + R() + " at path " + getPath());
    }

    public String toString() {
        return "JsonReader(" + this.f464h + ")";
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void v() throws IOException {
        int i2 = this.f466j;
        if (i2 == 0) {
            i2 = Z();
        }
        if (i2 == 4) {
            int i3 = this.a - 1;
            this.a = i3;
            int[] iArr = this.f453d;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
            this.f466j = 0;
            return;
        }
        throw new JsonDataException("Expected END_ARRAY but was " + R() + " at path " + getPath());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void w() throws IOException {
        int i2 = this.f466j;
        if (i2 == 0) {
            i2 = Z();
        }
        if (i2 == 2) {
            int i3 = this.a - 1;
            this.a = i3;
            this.c[i3] = null;
            int[] iArr = this.f453d;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
            this.f466j = 0;
            return;
        }
        throw new JsonDataException("Expected END_OBJECT but was " + R() + " at path " + getPath());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public boolean x() throws IOException {
        int i2 = this.f466j;
        if (i2 == 0) {
            i2 = Z();
        }
        return (i2 == 2 || i2 == 4 || i2 == 18) ? false : true;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public boolean y() throws IOException {
        int i2 = this.f466j;
        if (i2 == 0) {
            i2 = Z();
        }
        if (i2 == 5) {
            this.f466j = 0;
            int[] iArr = this.f453d;
            int i3 = this.a - 1;
            iArr[i3] = iArr[i3] + 1;
            return true;
        } else if (i2 == 6) {
            this.f466j = 0;
            int[] iArr2 = this.f453d;
            int i4 = this.a - 1;
            iArr2[i4] = iArr2[i4] + 1;
            return false;
        } else {
            throw new JsonDataException("Expected a boolean but was " + R() + " at path " + getPath());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public double z() throws IOException {
        int i2 = this.f466j;
        if (i2 == 0) {
            i2 = Z();
        }
        if (i2 == 16) {
            this.f466j = 0;
            int[] iArr = this.f453d;
            int i3 = this.a - 1;
            iArr[i3] = iArr[i3] + 1;
            return this.f467k;
        }
        if (i2 == 17) {
            this.m = this.f465i.V(this.f468l);
        } else if (i2 == 9) {
            this.m = d0(o);
        } else if (i2 == 8) {
            this.m = d0(n);
        } else if (i2 == 10) {
            this.m = e0();
        } else if (i2 != 11) {
            throw new JsonDataException("Expected a double but was " + R() + " at path " + getPath());
        }
        this.f466j = 11;
        try {
            double parseDouble = Double.parseDouble(this.m);
            if (!this.f454e && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
                throw new JsonEncodingException("JSON forbids NaN and infinities: " + parseDouble + " at path " + getPath());
            }
            this.m = null;
            this.f466j = 0;
            int[] iArr2 = this.f453d;
            int i4 = this.a - 1;
            iArr2[i4] = iArr2[i4] + 1;
            return parseDouble;
        } catch (NumberFormatException unused) {
            throw new JsonDataException("Expected a double but was " + this.m + " at path " + getPath());
        }
    }
}
