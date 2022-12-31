package com.nostra13.universalimageloader.core.assist;

import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
/* compiled from: ImageSize.java */
/* loaded from: classes3.dex */
public class c {
    private final int a;
    private final int b;

    public c(int i2, int i3) {
        this.a = i2;
        this.b = i3;
    }

    public int a() {
        return this.b;
    }

    public int b() {
        return this.a;
    }

    public c c(float f2) {
        return new c((int) (this.a * f2), (int) (this.b * f2));
    }

    public c d(int i2) {
        return new c(this.a / i2, this.b / i2);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(9);
        sb.append(this.a);
        sb.append("x");
        sb.append(this.b);
        return sb.toString();
    }

    public c(int i2, int i3, int i4) {
        if (i4 % BaseBlurEffect.ROTATION_180 == 0) {
            this.a = i2;
            this.b = i3;
            return;
        }
        this.a = i3;
        this.b = i2;
    }
}
