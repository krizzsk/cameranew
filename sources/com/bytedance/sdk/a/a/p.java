package com.bytedance.sdk.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SegmentPool.java */
/* loaded from: classes.dex */
public final class p {
    static o a;
    static long b;

    private p() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static o a() {
        synchronized (p.class) {
            o oVar = a;
            if (oVar != null) {
                a = oVar.f848f;
                oVar.f848f = null;
                b -= 8192;
                return oVar;
            }
            return new o();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(o oVar) {
        if (oVar.f848f == null && oVar.f849g == null) {
            if (oVar.f846d) {
                return;
            }
            synchronized (p.class) {
                long j2 = b;
                if (j2 + 8192 > 65536) {
                    return;
                }
                b = j2 + 8192;
                oVar.f848f = a;
                oVar.c = 0;
                oVar.b = 0;
                a = oVar;
                return;
            }
        }
        throw new IllegalArgumentException();
    }
}
