package com.facebook.imageformat;

import com.facebook.common.internal.h;
import java.io.UnsupportedEncodingException;
/* compiled from: ImageFormatCheckerUtils.java */
/* loaded from: classes.dex */
public class d {
    public static byte[] a(String str) {
        h.g(str);
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("ASCII not found!", e2);
        }
    }

    public static boolean b(byte[] bArr, byte[] bArr2, int i2) {
        h.g(bArr);
        h.g(bArr2);
        if (bArr2.length + i2 > bArr.length) {
            return false;
        }
        for (int i3 = 0; i3 < bArr2.length; i3++) {
            if (bArr[i2 + i3] != bArr2[i3]) {
                return false;
            }
        }
        return true;
    }

    public static boolean c(byte[] bArr, byte[] bArr2) {
        return b(bArr, bArr2, 0);
    }
}
