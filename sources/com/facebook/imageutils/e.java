package com.facebook.imageutils;

import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import java.io.IOException;
import java.io.InputStream;
/* compiled from: TiffUtil.java */
/* loaded from: classes.dex */
class e {
    private static final Class<?> a = e.class;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TiffUtil.java */
    /* loaded from: classes.dex */
    public static class b {
        boolean a;
        int b;
        int c;

        private b() {
        }
    }

    e() {
    }

    public static int a(int i2) {
        if (i2 != 3) {
            if (i2 != 6) {
                if (i2 != 8) {
                    return 0;
                }
                return BaseBlurEffect.ROTATION_270;
            }
            return 90;
        }
        return BaseBlurEffect.ROTATION_180;
    }

    private static int b(InputStream inputStream, int i2, boolean z) throws IOException {
        if (i2 >= 10 && d.a(inputStream, 2, z) == 3 && d.a(inputStream, 4, z) == 1) {
            return d.a(inputStream, 2, z);
        }
        return 0;
    }

    private static int c(InputStream inputStream, int i2, boolean z, int i3) throws IOException {
        if (i2 < 14) {
            return 0;
        }
        int a2 = d.a(inputStream, 2, z);
        int i4 = i2 - 2;
        while (true) {
            int i5 = a2 - 1;
            if (a2 <= 0 || i4 < 12) {
                break;
            }
            int i6 = i4 - 2;
            if (d.a(inputStream, 2, z) == i3) {
                return i6;
            }
            inputStream.skip(10L);
            i4 = i6 - 10;
            a2 = i5;
        }
        return 0;
    }

    public static int d(InputStream inputStream, int i2) throws IOException {
        b bVar = new b();
        int e2 = e(inputStream, i2, bVar);
        int i3 = bVar.c - 8;
        if (e2 == 0 || i3 > e2) {
            return 0;
        }
        inputStream.skip(i3);
        return b(inputStream, c(inputStream, e2 - i3, bVar.a, 274), bVar.a);
    }

    private static int e(InputStream inputStream, int i2, b bVar) throws IOException {
        if (i2 <= 8) {
            return 0;
        }
        int a2 = d.a(inputStream, 4, false);
        bVar.b = a2;
        int i3 = i2 - 4;
        if (a2 != 1229531648 && a2 != 1296891946) {
            com.facebook.common.logging.a.d(a, "Invalid TIFF header");
            return 0;
        }
        boolean z = a2 == 1229531648;
        bVar.a = z;
        int a3 = d.a(inputStream, 4, z);
        bVar.c = a3;
        int i4 = i3 - 4;
        if (a3 < 8 || a3 - 8 > i4) {
            com.facebook.common.logging.a.d(a, "Invalid offset");
            return 0;
        }
        return i4;
    }
}
