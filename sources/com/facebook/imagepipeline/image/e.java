package com.facebook.imagepipeline.image;

import android.graphics.ColorSpace;
import android.util.Pair;
import com.facebook.common.internal.k;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imageutils.HeifExifUtil;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
/* compiled from: EncodedImage.java */
@Immutable
/* loaded from: classes.dex */
public class e implements Closeable {
    private static boolean m;
    @Nullable
    private final com.facebook.common.references.a<PooledByteBuffer> a;
    @Nullable
    private final k<FileInputStream> b;
    private com.facebook.imageformat.c c;

    /* renamed from: d  reason: collision with root package name */
    private int f2809d;

    /* renamed from: e  reason: collision with root package name */
    private int f2810e;

    /* renamed from: f  reason: collision with root package name */
    private int f2811f;

    /* renamed from: g  reason: collision with root package name */
    private int f2812g;

    /* renamed from: h  reason: collision with root package name */
    private int f2813h;

    /* renamed from: i  reason: collision with root package name */
    private int f2814i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private com.facebook.imagepipeline.common.a f2815j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private ColorSpace f2816k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f2817l;

    public e(com.facebook.common.references.a<PooledByteBuffer> aVar) {
        this.c = com.facebook.imageformat.c.b;
        this.f2809d = -1;
        this.f2810e = 0;
        this.f2811f = -1;
        this.f2812g = -1;
        this.f2813h = 1;
        this.f2814i = -1;
        com.facebook.common.internal.h.b(Boolean.valueOf(com.facebook.common.references.a.Q(aVar)));
        this.a = aVar.clone();
        this.b = null;
    }

    private void V() {
        Pair<Integer, Integer> b;
        com.facebook.imageformat.c c = ImageFormatChecker.c(N());
        this.c = c;
        if (com.facebook.imageformat.b.b(c)) {
            b = d0();
        } else {
            b = c0().b();
        }
        if (c == com.facebook.imageformat.b.a && this.f2809d == -1) {
            if (b != null) {
                int b2 = com.facebook.imageutils.c.b(N());
                this.f2810e = b2;
                this.f2809d = com.facebook.imageutils.c.a(b2);
            }
        } else if (c == com.facebook.imageformat.b.f2658k && this.f2809d == -1) {
            int a = HeifExifUtil.a(N());
            this.f2810e = a;
            this.f2809d = com.facebook.imageutils.c.a(a);
        } else if (this.f2809d == -1) {
            this.f2809d = 0;
        }
    }

    public static boolean X(e eVar) {
        return eVar.f2809d >= 0 && eVar.f2811f >= 0 && eVar.f2812g >= 0;
    }

    public static boolean Z(@Nullable e eVar) {
        return eVar != null && eVar.Y();
    }

    private void b0() {
        if (this.f2811f < 0 || this.f2812g < 0) {
            a0();
        }
    }

    private com.facebook.imageutils.b c0() {
        InputStream inputStream;
        try {
            inputStream = N();
        } catch (Throwable th) {
            th = th;
            inputStream = null;
        }
        try {
            com.facebook.imageutils.b b = com.facebook.imageutils.a.b(inputStream);
            this.f2816k = b.a();
            Pair<Integer, Integer> b2 = b.b();
            if (b2 != null) {
                this.f2811f = ((Integer) b2.first).intValue();
                this.f2812g = ((Integer) b2.second).intValue();
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
            }
            return b;
        } catch (Throwable th2) {
            th = th2;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    @Nullable
    private Pair<Integer, Integer> d0() {
        Pair<Integer, Integer> g2 = com.facebook.imageutils.f.g(N());
        if (g2 != null) {
            this.f2811f = ((Integer) g2.first).intValue();
            this.f2812g = ((Integer) g2.second).intValue();
        }
        return g2;
    }

    @Nullable
    public static e e(@Nullable e eVar) {
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    public static void h(@Nullable e eVar) {
        if (eVar != null) {
            eVar.close();
        }
    }

    public com.facebook.imageformat.c A() {
        b0();
        return this.c;
    }

    @Nullable
    public InputStream N() {
        k<FileInputStream> kVar = this.b;
        if (kVar != null) {
            return kVar.get();
        }
        com.facebook.common.references.a w = com.facebook.common.references.a.w(this.a);
        if (w != null) {
            try {
                return new com.facebook.common.memory.g((PooledByteBuffer) w.A());
            } finally {
                com.facebook.common.references.a.y(w);
            }
        }
        return null;
    }

    public InputStream O() {
        InputStream N = N();
        com.facebook.common.internal.h.g(N);
        return N;
    }

    public int Q() {
        b0();
        return this.f2809d;
    }

    public int R() {
        return this.f2813h;
    }

    public int S() {
        com.facebook.common.references.a<PooledByteBuffer> aVar = this.a;
        if (aVar != null && aVar.A() != null) {
            return this.a.A().size();
        }
        return this.f2814i;
    }

    public int T() {
        b0();
        return this.f2811f;
    }

    protected boolean U() {
        return this.f2817l;
    }

    public boolean W(int i2) {
        com.facebook.imageformat.c cVar = this.c;
        if ((cVar == com.facebook.imageformat.b.a || cVar == com.facebook.imageformat.b.f2659l) && this.b == null) {
            com.facebook.common.internal.h.g(this.a);
            PooledByteBuffer A = this.a.A();
            return A.D(i2 + (-2)) == -1 && A.D(i2 - 1) == -39;
        }
        return true;
    }

    public synchronized boolean Y() {
        boolean z;
        if (!com.facebook.common.references.a.Q(this.a)) {
            z = this.b != null;
        }
        return z;
    }

    public void a0() {
        if (!m) {
            V();
        } else if (this.f2817l) {
        } else {
            V();
            this.f2817l = true;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a.y(this.a);
    }

    @Nullable
    public e d() {
        e eVar;
        k<FileInputStream> kVar = this.b;
        if (kVar != null) {
            eVar = new e(kVar, this.f2814i);
        } else {
            com.facebook.common.references.a w = com.facebook.common.references.a.w(this.a);
            if (w == null) {
                eVar = null;
            } else {
                try {
                    eVar = new e(w);
                } finally {
                    com.facebook.common.references.a.y(w);
                }
            }
        }
        if (eVar != null) {
            eVar.i(this);
        }
        return eVar;
    }

    public void e0(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.f2815j = aVar;
    }

    public void f0(int i2) {
        this.f2810e = i2;
    }

    public void g0(int i2) {
        this.f2812g = i2;
    }

    public void h0(com.facebook.imageformat.c cVar) {
        this.c = cVar;
    }

    public void i(e eVar) {
        this.c = eVar.A();
        this.f2811f = eVar.T();
        this.f2812g = eVar.z();
        this.f2809d = eVar.Q();
        this.f2810e = eVar.x();
        this.f2813h = eVar.R();
        this.f2814i = eVar.S();
        this.f2815j = eVar.v();
        this.f2816k = eVar.w();
        this.f2817l = eVar.U();
    }

    public void i0(int i2) {
        this.f2809d = i2;
    }

    public void j0(int i2) {
        this.f2813h = i2;
    }

    public void k0(int i2) {
        this.f2811f = i2;
    }

    public com.facebook.common.references.a<PooledByteBuffer> t() {
        return com.facebook.common.references.a.w(this.a);
    }

    @Nullable
    public com.facebook.imagepipeline.common.a v() {
        return this.f2815j;
    }

    @Nullable
    public ColorSpace w() {
        b0();
        return this.f2816k;
    }

    public int x() {
        b0();
        return this.f2810e;
    }

    public String y(int i2) {
        com.facebook.common.references.a<PooledByteBuffer> t = t();
        if (t == null) {
            return "";
        }
        int min = Math.min(S(), i2);
        byte[] bArr = new byte[min];
        try {
            PooledByteBuffer A = t.A();
            if (A == null) {
                return "";
            }
            A.b(0, bArr, 0, min);
            t.close();
            StringBuilder sb = new StringBuilder(min * 2);
            for (int i3 = 0; i3 < min; i3++) {
                sb.append(String.format("%02X", Byte.valueOf(bArr[i3])));
            }
            return sb.toString();
        } finally {
            t.close();
        }
    }

    public int z() {
        b0();
        return this.f2812g;
    }

    public e(k<FileInputStream> kVar) {
        this.c = com.facebook.imageformat.c.b;
        this.f2809d = -1;
        this.f2810e = 0;
        this.f2811f = -1;
        this.f2812g = -1;
        this.f2813h = 1;
        this.f2814i = -1;
        com.facebook.common.internal.h.g(kVar);
        this.a = null;
        this.b = kVar;
    }

    public e(k<FileInputStream> kVar, int i2) {
        this(kVar);
        this.f2814i = i2;
    }
}
