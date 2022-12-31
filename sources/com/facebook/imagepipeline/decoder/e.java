package com.facebook.imagepipeline.decoder;

import com.facebook.common.internal.h;
import com.facebook.common.internal.m;
import java.io.IOException;
import java.io.InputStream;
/* compiled from: ProgressiveJpegParser.java */
/* loaded from: classes.dex */
public class e {
    private int a;
    private int b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private int f2797d;

    /* renamed from: e  reason: collision with root package name */
    private int f2798e;

    /* renamed from: f  reason: collision with root package name */
    private int f2799f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f2800g;

    /* renamed from: h  reason: collision with root package name */
    private final com.facebook.common.memory.a f2801h;

    public e(com.facebook.common.memory.a aVar) {
        h.g(aVar);
        this.f2801h = aVar;
        this.c = 0;
        this.b = 0;
        this.f2797d = 0;
        this.f2799f = 0;
        this.f2798e = 0;
        this.a = 0;
    }

    private boolean a(InputStream inputStream) {
        int read;
        int i2 = this.f2798e;
        while (this.a != 6 && (read = inputStream.read()) != -1) {
            try {
                int i3 = this.c + 1;
                this.c = i3;
                if (this.f2800g) {
                    this.a = 6;
                    this.f2800g = false;
                    return false;
                }
                int i4 = this.a;
                if (i4 != 0) {
                    if (i4 != 1) {
                        if (i4 != 2) {
                            if (i4 != 3) {
                                if (i4 == 4) {
                                    this.a = 5;
                                } else if (i4 != 5) {
                                    h.i(false);
                                } else {
                                    int i5 = ((this.b << 8) + read) - 2;
                                    com.facebook.common.util.c.a(inputStream, i5);
                                    this.c += i5;
                                    this.a = 2;
                                }
                            } else if (read == 255) {
                                this.a = 3;
                            } else if (read == 0) {
                                this.a = 2;
                            } else if (read == 217) {
                                this.f2800g = true;
                                f(i3 - 2);
                                this.a = 2;
                            } else {
                                if (read == 218) {
                                    f(i3 - 2);
                                }
                                if (b(read)) {
                                    this.a = 4;
                                } else {
                                    this.a = 2;
                                }
                            }
                        } else if (read == 255) {
                            this.a = 3;
                        }
                    } else if (read == 216) {
                        this.a = 2;
                    } else {
                        this.a = 6;
                    }
                } else if (read == 255) {
                    this.a = 1;
                } else {
                    this.a = 6;
                }
                this.b = read;
            } catch (IOException e2) {
                m.a(e2);
                throw null;
            }
        }
        return (this.a == 6 || this.f2798e == i2) ? false : true;
    }

    private static boolean b(int i2) {
        if (i2 == 1) {
            return false;
        }
        return ((i2 >= 208 && i2 <= 215) || i2 == 217 || i2 == 216) ? false : true;
    }

    private void f(int i2) {
        int i3 = this.f2797d;
        if (i3 > 0) {
            this.f2799f = i2;
        }
        this.f2797d = i3 + 1;
        this.f2798e = i3;
    }

    public int c() {
        return this.f2799f;
    }

    public int d() {
        return this.f2798e;
    }

    public boolean e() {
        return this.f2800g;
    }

    public boolean g(com.facebook.imagepipeline.image.e eVar) {
        if (this.a != 6 && eVar.S() > this.c) {
            com.facebook.common.memory.e eVar2 = new com.facebook.common.memory.e(eVar.O(), this.f2801h.get(16384), this.f2801h);
            try {
                try {
                    com.facebook.common.util.c.a(eVar2, this.c);
                    return a(eVar2);
                } catch (IOException e2) {
                    m.a(e2);
                    throw null;
                }
            } finally {
                com.facebook.common.internal.b.b(eVar2);
            }
        }
        return false;
    }
}
