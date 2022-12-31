package com.google.zxing.qrcode.detector;

import com.google.zxing.h;
/* compiled from: AlignmentPattern.java */
/* loaded from: classes2.dex */
public final class a extends h {
    private final float c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(float f2, float f3, float f4) {
        super(f2, f3);
        this.c = f4;
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
    public a g(float f2, float f3, float f4) {
        return new a((c() + f3) / 2.0f, (d() + f2) / 2.0f, (this.c + f4) / 2.0f);
    }
}
