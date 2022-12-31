package com.google.zxing;
/* compiled from: ResultPoint.java */
/* loaded from: classes2.dex */
public class h {
    private final float a;
    private final float b;

    public h(float f2, float f3) {
        this.a = f2;
        this.b = f3;
    }

    private static float a(h hVar, h hVar2, h hVar3) {
        float f2 = hVar2.a;
        float f3 = hVar2.b;
        return ((hVar3.a - f2) * (hVar.b - f3)) - ((hVar3.b - f3) * (hVar.a - f2));
    }

    public static float b(h hVar, h hVar2) {
        return com.google.zxing.common.k.a.a(hVar.a, hVar.b, hVar2.a, hVar2.b);
    }

    public static void e(h[] hVarArr) {
        h hVar;
        h hVar2;
        h hVar3;
        float b = b(hVarArr[0], hVarArr[1]);
        float b2 = b(hVarArr[1], hVarArr[2]);
        float b3 = b(hVarArr[0], hVarArr[2]);
        if (b2 >= b && b2 >= b3) {
            hVar = hVarArr[0];
            hVar2 = hVarArr[1];
            hVar3 = hVarArr[2];
        } else if (b3 >= b2 && b3 >= b) {
            hVar = hVarArr[1];
            hVar2 = hVarArr[0];
            hVar3 = hVarArr[2];
        } else {
            hVar = hVarArr[2];
            hVar2 = hVarArr[0];
            hVar3 = hVarArr[1];
        }
        if (a(hVar2, hVar, hVar3) < 0.0f) {
            h hVar4 = hVar3;
            hVar3 = hVar2;
            hVar2 = hVar4;
        }
        hVarArr[0] = hVar2;
        hVarArr[1] = hVar;
        hVarArr[2] = hVar3;
    }

    public final float c() {
        return this.a;
    }

    public final float d() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof h) {
            h hVar = (h) obj;
            if (this.a == hVar.a && this.b == hVar.b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b);
    }

    public final String toString() {
        return "(" + this.a + ',' + this.b + ')';
    }
}
