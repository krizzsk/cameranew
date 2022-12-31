package com.google.zxing.qrcode.detector;

import com.google.zxing.h;
/* compiled from: FinderPattern.java */
/* loaded from: classes2.dex */
public final class d extends h {
    private final float c;

    /* renamed from: d  reason: collision with root package name */
    private final int f5061d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(float f2, float f3, float f4) {
        this(f2, f3, f4, 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f(float f2, float f3, float f4) {
        if (Math.abs(f3 - d()) > f2 || Math.abs(f4 - c()) > f2) {
            return false;
        }
        float abs = Math.abs(f2 - this.c);
        return abs <= 1.0f || abs <= this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d g(float f2, float f3, float f4) {
        int i2 = this.f5061d;
        int i3 = i2 + 1;
        float c = (i2 * c()) + f3;
        float f5 = i3;
        return new d(c / f5, ((this.f5061d * d()) + f2) / f5, ((this.f5061d * this.c) + f4) / f5, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h() {
        return this.f5061d;
    }

    public float i() {
        return this.c;
    }

    private d(float f2, float f3, float f4, int i2) {
        super(f2, f3);
        this.c = f4;
        this.f5061d = i2;
    }
}
