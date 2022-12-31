package com.facebook.common.c;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import javax.annotation.Nullable;
/* compiled from: WebpSupportStatus.java */
/* loaded from: classes.dex */
public class c {
    public static final boolean a;
    public static final boolean b;
    @Nullable
    public static b c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f2393d;

    /* renamed from: e  reason: collision with root package name */
    private static final byte[] f2394e;

    /* renamed from: f  reason: collision with root package name */
    private static final byte[] f2395f;

    /* renamed from: g  reason: collision with root package name */
    private static final byte[] f2396g;

    /* renamed from: h  reason: collision with root package name */
    private static final byte[] f2397h;

    /* renamed from: i  reason: collision with root package name */
    private static final byte[] f2398i;

    static {
        a = Build.VERSION.SDK_INT <= 17;
        b = e();
        c = null;
        f2393d = false;
        f2394e = a("RIFF");
        f2395f = a("WEBP");
        f2396g = a("VP8 ");
        f2397h = a("VP8L");
        f2398i = a("VP8X");
    }

    private static byte[] a(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("ASCII not found!", e2);
        }
    }

    public static boolean b(byte[] bArr, int i2) {
        return j(bArr, i2 + 12, f2398i) && ((bArr[i2 + 20] & 2) == 2);
    }

    public static boolean c(byte[] bArr, int i2, int i3) {
        return i3 >= 21 && j(bArr, i2 + 12, f2398i);
    }

    public static boolean d(byte[] bArr, int i2) {
        return j(bArr, i2 + 12, f2398i) && ((bArr[i2 + 20] & 16) == 16);
    }

    private static boolean e() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 17) {
            return false;
        }
        if (i2 == 17) {
            byte[] decode = Base64.decode("UklGRkoAAABXRUJQVlA4WAoAAAAQAAAAAAAAAAAAQUxQSAwAAAARBxAR/Q9ERP8DAABWUDggGAAAABQBAJ0BKgEAAQAAAP4AAA3AAP7mtQAAAA==", 0);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(decode, 0, decode.length, options);
            if (options.outHeight != 1 || options.outWidth != 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean f(byte[] bArr, int i2) {
        return j(bArr, i2 + 12, f2397h);
    }

    public static boolean g(byte[] bArr, int i2) {
        return j(bArr, i2 + 12, f2396g);
    }

    public static boolean h(byte[] bArr, int i2, int i3) {
        return i3 >= 20 && j(bArr, i2, f2394e) && j(bArr, i2 + 8, f2395f);
    }

    @Nullable
    public static b i() {
        if (f2393d) {
            return c;
        }
        b bVar = null;
        try {
            bVar = (b) Class.forName("com.facebook.webpsupport.WebpBitmapFactoryImpl").newInstance();
        } catch (Throwable unused) {
        }
        f2393d = true;
        return bVar;
    }

    private static boolean j(byte[] bArr, int i2, byte[] bArr2) {
        if (bArr2 == null || bArr == null || bArr2.length + i2 > bArr.length) {
            return false;
        }
        for (int i3 = 0; i3 < bArr2.length; i3++) {
            if (bArr[i3 + i2] != bArr2[i3]) {
                return false;
            }
        }
        return true;
    }
}
