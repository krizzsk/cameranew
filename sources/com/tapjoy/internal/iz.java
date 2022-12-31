package com.tapjoy.internal;
/* loaded from: classes3.dex */
final class iz {
    static iy a;
    static long b;

    private iz() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static iy a() {
        synchronized (iz.class) {
            iy iyVar = a;
            if (iyVar != null) {
                a = iyVar.f7735f;
                iyVar.f7735f = null;
                b -= 8192;
                return iyVar;
            }
            return new iy();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(iy iyVar) {
        if (iyVar.f7735f == null && iyVar.f7736g == null) {
            if (iyVar.f7733d) {
                return;
            }
            synchronized (iz.class) {
                long j2 = b;
                if (j2 + 8192 > 65536) {
                    return;
                }
                b = j2 + 8192;
                iyVar.f7735f = a;
                iyVar.c = 0;
                iyVar.b = 0;
                a = iyVar;
                return;
            }
        }
        throw new IllegalArgumentException();
    }
}
