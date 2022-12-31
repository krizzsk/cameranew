package com.airbnb.lottie.w;
/* compiled from: MeanCalculator.java */
/* loaded from: classes.dex */
public class f {
    private float a;
    private int b;

    public void a(float f2) {
        float f3 = this.a + f2;
        this.a = f3;
        int i2 = this.b + 1;
        this.b = i2;
        if (i2 == Integer.MAX_VALUE) {
            this.a = f3 / 2.0f;
            this.b = i2 / 2;
        }
    }
}
