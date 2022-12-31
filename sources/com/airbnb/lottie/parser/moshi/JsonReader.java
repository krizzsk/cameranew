package com.airbnb.lottie.parser.moshi;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import okio.ByteString;
import okio.d;
import okio.f;
/* loaded from: classes.dex */
public abstract class JsonReader implements Closeable {

    /* renamed from: g  reason: collision with root package name */
    private static final String[] f452g = new String[128];
    int a;
    int[] b = new int[32];
    String[] c = new String[32];

    /* renamed from: d  reason: collision with root package name */
    int[] f453d = new int[32];

    /* renamed from: e  reason: collision with root package name */
    boolean f454e;

    /* renamed from: f  reason: collision with root package name */
    boolean f455f;

    /* loaded from: classes.dex */
    public enum Token {
        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL,
        END_DOCUMENT
    }

    /* loaded from: classes.dex */
    public static final class a {
        final String[] a;
        final f b;

        private a(String[] strArr, f fVar) {
            this.a = strArr;
            this.b = fVar;
        }

        public static a a(String... strArr) {
            try {
                ByteString[] byteStringArr = new ByteString[strArr.length];
                okio.b bVar = new okio.b();
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    JsonReader.W(bVar, strArr[i2]);
                    bVar.A();
                    byteStringArr[i2] = bVar.Q();
                }
                return new a((String[]) strArr.clone(), f.e(byteStringArr));
            } catch (IOException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    static {
        for (int i2 = 0; i2 <= 31; i2++) {
            f452g[i2] = String.format("\\u%04x", Integer.valueOf(i2));
        }
        String[] strArr = f452g;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    public static JsonReader Q(d dVar) {
        return new b(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void W(okio.c r7, java.lang.String r8) throws java.io.IOException {
        /*
            java.lang.String[] r0 = com.airbnb.lottie.parser.moshi.JsonReader.f452g
            r1 = 34
            r7.q(r1)
            int r2 = r8.length()
            r3 = 0
            r4 = 0
        Ld:
            if (r3 >= r2) goto L36
            char r5 = r8.charAt(r3)
            r6 = 128(0x80, float:1.794E-43)
            if (r5 >= r6) goto L1c
            r5 = r0[r5]
            if (r5 != 0) goto L29
            goto L33
        L1c:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L23
            java.lang.String r5 = "\\u2028"
            goto L29
        L23:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L33
            java.lang.String r5 = "\\u2029"
        L29:
            if (r4 >= r3) goto L2e
            r7.l(r8, r4, r3)
        L2e:
            r7.k(r5)
            int r4 = r3 + 1
        L33:
            int r3 = r3 + 1
            goto Ld
        L36:
            if (r4 >= r2) goto L3b
            r7.l(r8, r4, r2)
        L3b:
            r7.q(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.moshi.JsonReader.W(okio.c, java.lang.String):void");
    }

    public abstract int A() throws IOException;

    public abstract String N() throws IOException;

    public abstract String O() throws IOException;

    public abstract Token R() throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void S(int i2) {
        int i3 = this.a;
        int[] iArr = this.b;
        if (i3 == iArr.length) {
            if (i3 != 256) {
                this.b = Arrays.copyOf(iArr, iArr.length * 2);
                String[] strArr = this.c;
                this.c = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                int[] iArr2 = this.f453d;
                this.f453d = Arrays.copyOf(iArr2, iArr2.length * 2);
            } else {
                throw new JsonDataException("Nesting too deep at " + getPath());
            }
        }
        int[] iArr3 = this.b;
        int i4 = this.a;
        this.a = i4 + 1;
        iArr3[i4] = i2;
    }

    public abstract int T(a aVar) throws IOException;

    public abstract void U() throws IOException;

    public abstract void V() throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final JsonEncodingException X(String str) throws JsonEncodingException {
        throw new JsonEncodingException(str + " at path " + getPath());
    }

    public abstract void d() throws IOException;

    public final String getPath() {
        return com.airbnb.lottie.parser.moshi.a.a(this.a, this.b, this.c, this.f453d);
    }

    public abstract void t() throws IOException;

    public abstract void v() throws IOException;

    public abstract void w() throws IOException;

    public abstract boolean x() throws IOException;

    public abstract boolean y() throws IOException;

    public abstract double z() throws IOException;
}
