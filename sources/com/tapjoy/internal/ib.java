package com.tapjoy.internal;
/* loaded from: classes3.dex */
public final class ib {
    public float a;
    public int b;

    public static ib a(String str) {
        if (jq.c(str)) {
            return null;
        }
        try {
            ib ibVar = new ib();
            int length = str.length() - 1;
            char charAt = str.charAt(length);
            if (charAt == 'w') {
                ibVar.a = Float.valueOf(str.substring(0, length)).floatValue();
                ibVar.b = 1;
            } else if (charAt == 'h') {
                ibVar.a = Float.valueOf(str.substring(0, length)).floatValue();
                ibVar.b = 2;
            } else {
                ibVar.a = Float.valueOf(str).floatValue();
                ibVar.b = 0;
            }
            return ibVar;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public final float a(float f2, float f3) {
        int i2 = this.b;
        if (i2 == 1) {
            return (this.a * f2) / 100.0f;
        }
        if (i2 == 2) {
            return (this.a * f3) / 100.0f;
        }
        return this.a;
    }
}
