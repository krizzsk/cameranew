package com.bytedance.sdk.a.b.a.e;

import java.io.IOException;
/* compiled from: Http2.java */
/* loaded from: classes.dex */
public final class e {
    static final com.bytedance.sdk.a.a.f a = com.bytedance.sdk.a.a.f.a("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* renamed from: d  reason: collision with root package name */
    private static final String[] f965d = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
    static final String[] b = new String[64];
    static final String[] c = new String[256];

    static {
        String[] strArr;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            String[] strArr2 = c;
            if (i3 >= strArr2.length) {
                break;
            }
            strArr2[i3] = com.bytedance.sdk.a.b.a.c.a("%8s", Integer.toBinaryString(i3)).replace(' ', '0');
            i3++;
        }
        String[] strArr3 = b;
        strArr3[0] = "";
        strArr3[1] = "END_STREAM";
        int[] iArr = {1};
        strArr3[8] = "PADDED";
        for (int i4 = 0; i4 < 1; i4++) {
            int i5 = iArr[i4];
            b[i5 | 8] = strArr[i5] + "|PADDED";
        }
        String[] strArr4 = b;
        strArr4[4] = "END_HEADERS";
        strArr4[32] = "PRIORITY";
        strArr4[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i6 = 0; i6 < 3; i6++) {
            int i7 = iArr2[i6];
            for (int i8 = 0; i8 < 1; i8++) {
                int i9 = iArr[i8];
                String[] strArr5 = b;
                int i10 = i9 | i7;
                strArr5[i10] = strArr5[i9] + '|' + strArr5[i7];
                strArr5[i10 | 8] = strArr5[i9] + '|' + strArr5[i7] + "|PADDED";
            }
        }
        while (true) {
            String[] strArr6 = b;
            if (i2 >= strArr6.length) {
                return;
            }
            if (strArr6[i2] == null) {
                strArr6[i2] = c[i2];
            }
            i2++;
        }
    }

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IllegalArgumentException a(String str, Object... objArr) {
        throw new IllegalArgumentException(com.bytedance.sdk.a.b.a.c.a(str, objArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IOException b(String str, Object... objArr) throws IOException {
        throw new IOException(com.bytedance.sdk.a.b.a.c.a(str, objArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(boolean z, int i2, int i3, byte b2, byte b3) {
        String[] strArr = f965d;
        String a2 = b2 < strArr.length ? strArr[b2] : com.bytedance.sdk.a.b.a.c.a("0x%02x", Byte.valueOf(b2));
        String a3 = a(b2, b3);
        Object[] objArr = new Object[5];
        objArr[0] = z ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Integer.valueOf(i3);
        objArr[3] = a2;
        objArr[4] = a3;
        return com.bytedance.sdk.a.b.a.c.a("%s 0x%08x %5d %-13s %s", objArr);
    }

    static String a(byte b2, byte b3) {
        if (b3 == 0) {
            return "";
        }
        if (b2 != 2 && b2 != 3) {
            if (b2 == 4 || b2 == 6) {
                return b3 == 1 ? "ACK" : c[b3];
            } else if (b2 != 7 && b2 != 8) {
                String[] strArr = b;
                String str = b3 < strArr.length ? strArr[b3] : c[b3];
                if (b2 != 5 || (b3 & 4) == 0) {
                    return (b2 != 0 || (b3 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED");
                }
                return str.replace("HEADERS", "PUSH_PROMISE");
            }
        }
        return c[b3];
    }
}
