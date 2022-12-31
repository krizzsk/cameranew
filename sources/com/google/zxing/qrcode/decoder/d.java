package com.google.zxing.qrcode.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Map;
/* compiled from: Decoder.java */
/* loaded from: classes2.dex */
public final class d {
    private final com.google.zxing.common.reedsolomon.c a = new com.google.zxing.common.reedsolomon.c(com.google.zxing.common.reedsolomon.a.f5002l);

    private void a(byte[] bArr, int i2) throws ChecksumException {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = bArr[i3] & Draft_75.END_OF_FRAME;
        }
        try {
            this.a.a(iArr, bArr.length - i2);
            for (int i4 = 0; i4 < i2; i4++) {
                bArr[i4] = (byte) iArr[i4];
            }
        } catch (ReedSolomonException unused) {
            throw ChecksumException.getChecksumInstance();
        }
    }

    private com.google.zxing.common.d c(a aVar, Map<DecodeHintType, ?> map) throws FormatException, ChecksumException {
        g e2 = aVar.e();
        ErrorCorrectionLevel d2 = aVar.d().d();
        b[] b = b.b(aVar.c(), e2, d2);
        int i2 = 0;
        for (b bVar : b) {
            i2 += bVar.c();
        }
        byte[] bArr = new byte[i2];
        int i3 = 0;
        for (b bVar2 : b) {
            byte[] a = bVar2.a();
            int c = bVar2.c();
            a(a, c);
            int i4 = 0;
            while (i4 < c) {
                bArr[i3] = a[i4];
                i4++;
                i3++;
            }
        }
        return c.a(bArr, e2, d2, map);
    }

    public com.google.zxing.common.d b(com.google.zxing.common.b bVar, Map<DecodeHintType, ?> map) throws FormatException, ChecksumException {
        ChecksumException e2;
        a aVar = new a(bVar);
        FormatException formatException = null;
        try {
            return c(aVar, map);
        } catch (ChecksumException e3) {
            e2 = e3;
            try {
                aVar.f();
                aVar.g(true);
                aVar.e();
                aVar.d();
                aVar.b();
                com.google.zxing.common.d c = c(aVar, map);
                c.i(new f(true));
                return c;
            } catch (ChecksumException | FormatException unused) {
                if (formatException != null) {
                    throw formatException;
                }
                throw e2;
            }
        } catch (FormatException e4) {
            e2 = null;
            formatException = e4;
            aVar.f();
            aVar.g(true);
            aVar.e();
            aVar.d();
            aVar.b();
            com.google.zxing.common.d c2 = c(aVar, map);
            c2.i(new f(true));
            return c2;
        }
    }
}
