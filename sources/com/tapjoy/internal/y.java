package com.tapjoy.internal;
/* loaded from: classes3.dex */
public final class y {
    public static Object a(bb bbVar) {
        int i2 = 1;
        while (true) {
            try {
                return bbVar.call();
            } catch (OutOfMemoryError e2) {
                if (i2 < 10) {
                    System.gc();
                    i2++;
                } else {
                    throw e2;
                }
            }
        }
    }
}
