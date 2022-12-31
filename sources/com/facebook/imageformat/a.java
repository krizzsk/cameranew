package com.facebook.imageformat;

import com.coremedia.iso.boxes.FileTypeBox;
import com.facebook.common.internal.f;
import com.facebook.common.internal.h;
import com.facebook.imageformat.c;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import javax.annotation.Nullable;
/* compiled from: DefaultImageFormatChecker.java */
/* loaded from: classes.dex */
public class a implements c.a {
    private static final byte[] c;

    /* renamed from: d  reason: collision with root package name */
    private static final int f2642d;

    /* renamed from: e  reason: collision with root package name */
    private static final byte[] f2643e;

    /* renamed from: f  reason: collision with root package name */
    private static final int f2644f;

    /* renamed from: g  reason: collision with root package name */
    private static final byte[] f2645g;

    /* renamed from: h  reason: collision with root package name */
    private static final byte[] f2646h;

    /* renamed from: i  reason: collision with root package name */
    private static final byte[] f2647i;

    /* renamed from: j  reason: collision with root package name */
    private static final int f2648j;

    /* renamed from: k  reason: collision with root package name */
    private static final byte[] f2649k;

    /* renamed from: l  reason: collision with root package name */
    private static final int f2650l;
    private static final byte[] m;
    private static final byte[][] n;
    private static final byte[] o;
    private static final byte[] p;
    private static final int q;
    final int a = f.a(21, 20, f2642d, f2644f, 6, f2648j, f2650l, 12);
    private boolean b = false;

    static {
        byte[] bArr = {-1, -40, -1};
        c = bArr;
        f2642d = bArr.length;
        byte[] bArr2 = {-119, 80, 78, 71, Draft_75.CR, 10, 26, 10};
        f2643e = bArr2;
        f2644f = bArr2.length;
        f2645g = d.a("GIF87a");
        f2646h = d.a("GIF89a");
        byte[] a = d.a("BM");
        f2647i = a;
        f2648j = a.length;
        byte[] bArr3 = {0, 0, 1, 0};
        f2649k = bArr3;
        f2650l = bArr3.length;
        m = d.a(FileTypeBox.TYPE);
        n = new byte[][]{d.a("heic"), d.a("heix"), d.a("hevc"), d.a("hevx"), d.a("mif1"), d.a("msf1")};
        byte[] bArr4 = {73, 73, 42, 0};
        o = bArr4;
        p = new byte[]{77, 77, 0, 42};
        q = bArr4.length;
    }

    private static c c(byte[] bArr, int i2) {
        h.b(Boolean.valueOf(com.facebook.common.c.c.h(bArr, 0, i2)));
        if (com.facebook.common.c.c.g(bArr, 0)) {
            return b.f2653f;
        }
        if (com.facebook.common.c.c.f(bArr, 0)) {
            return b.f2654g;
        }
        if (com.facebook.common.c.c.c(bArr, 0, i2)) {
            if (com.facebook.common.c.c.b(bArr, 0)) {
                return b.f2657j;
            }
            if (com.facebook.common.c.c.d(bArr, 0)) {
                return b.f2656i;
            }
            return b.f2655h;
        }
        return c.b;
    }

    private static boolean d(byte[] bArr, int i2) {
        byte[] bArr2 = f2647i;
        if (i2 < bArr2.length) {
            return false;
        }
        return d.c(bArr, bArr2);
    }

    private static boolean e(byte[] bArr, int i2) {
        return i2 >= q && (d.c(bArr, o) || d.c(bArr, p));
    }

    private static boolean f(byte[] bArr, int i2) {
        if (i2 < 6) {
            return false;
        }
        return d.c(bArr, f2645g) || d.c(bArr, f2646h);
    }

    private static boolean g(byte[] bArr, int i2) {
        if (i2 >= 12 && bArr[3] >= 8 && d.b(bArr, m, 4)) {
            for (byte[] bArr2 : n) {
                if (d.b(bArr, bArr2, 8)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private static boolean h(byte[] bArr, int i2) {
        byte[] bArr2 = f2649k;
        if (i2 < bArr2.length) {
            return false;
        }
        return d.c(bArr, bArr2);
    }

    private static boolean i(byte[] bArr, int i2) {
        byte[] bArr2 = c;
        return i2 >= bArr2.length && d.c(bArr, bArr2);
    }

    private static boolean j(byte[] bArr, int i2) {
        byte[] bArr2 = f2643e;
        return i2 >= bArr2.length && d.c(bArr, bArr2);
    }

    @Override // com.facebook.imageformat.c.a
    @Nullable
    public final c a(byte[] bArr, int i2) {
        h.g(bArr);
        if (!this.b && com.facebook.common.c.c.h(bArr, 0, i2)) {
            return c(bArr, i2);
        }
        if (i(bArr, i2)) {
            return b.a;
        }
        if (j(bArr, i2)) {
            return b.b;
        }
        if (this.b && com.facebook.common.c.c.h(bArr, 0, i2)) {
            return c(bArr, i2);
        }
        if (f(bArr, i2)) {
            return b.c;
        }
        if (d(bArr, i2)) {
            return b.f2651d;
        }
        if (h(bArr, i2)) {
            return b.f2652e;
        }
        if (g(bArr, i2)) {
            return b.f2658k;
        }
        if (e(bArr, i2)) {
            return b.f2659l;
        }
        return c.b;
    }

    @Override // com.facebook.imageformat.c.a
    public int b() {
        return this.a;
    }
}
