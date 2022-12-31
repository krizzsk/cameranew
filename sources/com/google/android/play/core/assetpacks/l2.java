package com.google.android.play.core.assetpacks;

import androidx.annotation.Nullable;
import java.util.Arrays;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class l2 {
    private byte[] a = new byte[4096];
    private int b;
    private long c;

    /* renamed from: d  reason: collision with root package name */
    private long f4767d;

    /* renamed from: e  reason: collision with root package name */
    private int f4768e;

    /* renamed from: f  reason: collision with root package name */
    private int f4769f;

    /* renamed from: g  reason: collision with root package name */
    private int f4770g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f4771h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private String f4772i;

    public l2() {
        e();
    }

    private final int a(int i2, byte[] bArr, int i3, int i4) {
        int i5 = this.b;
        if (i5 < i2) {
            int min = Math.min(i4, i2 - i5);
            System.arraycopy(bArr, i3, this.a, this.b, min);
            int i6 = this.b + min;
            this.b = i6;
            if (i6 < i2) {
                return -1;
            }
            return min;
        }
        return 0;
    }

    public final int b(byte[] bArr, int i2, int i3) {
        int a = a(30, bArr, i2, i3);
        if (a != -1) {
            if (this.c == -1) {
                long e2 = j2.e(this.a, 0);
                this.c = e2;
                if (e2 == 67324752) {
                    this.f4771h = false;
                    this.f4767d = j2.e(this.a, 18);
                    this.f4770g = j2.g(this.a, 8);
                    this.f4768e = j2.g(this.a, 26);
                    int g2 = this.f4768e + 30 + j2.g(this.a, 28);
                    this.f4769f = g2;
                    int length = this.a.length;
                    if (length < g2) {
                        do {
                            length += length;
                        } while (length < g2);
                        this.a = Arrays.copyOf(this.a, length);
                    }
                } else {
                    this.f4771h = true;
                }
            }
            int a2 = a(this.f4769f, bArr, i2 + a, i3 - a);
            if (a2 == -1) {
                return -1;
            }
            int i4 = a + a2;
            if (!this.f4771h && this.f4772i == null) {
                this.f4772i = new String(this.a, 30, this.f4768e);
            }
            return i4;
        }
        return -1;
    }

    public final f3 c() {
        int i2 = this.b;
        int i3 = this.f4769f;
        if (i2 < i3) {
            return f3.a(this.f4772i, this.f4767d, this.f4770g, true, Arrays.copyOf(this.a, i2), this.f4771h);
        }
        f3 a = f3.a(this.f4772i, this.f4767d, this.f4770g, false, Arrays.copyOf(this.a, i3), this.f4771h);
        e();
        return a;
    }

    public final int d() {
        return this.f4769f;
    }

    public final void e() {
        this.b = 0;
        this.f4768e = -1;
        this.c = -1L;
        this.f4771h = false;
        this.f4769f = 30;
        this.f4767d = -1L;
        this.f4770g = -1;
        this.f4772i = null;
    }
}
