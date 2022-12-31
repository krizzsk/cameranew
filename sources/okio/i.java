package okio;

import javax.annotation.Nullable;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SegmentPool.java */
/* loaded from: classes3.dex */
public final class i {
    @Nullable
    static h a;
    static long b;

    private i() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(h hVar) {
        if (hVar.f8943f == null && hVar.f8944g == null) {
            if (hVar.f8941d) {
                return;
            }
            synchronized (i.class) {
                long j2 = b;
                if (j2 + 8192 > 65536) {
                    return;
                }
                b = j2 + 8192;
                hVar.f8943f = a;
                hVar.c = 0;
                hVar.b = 0;
                a = hVar;
                return;
            }
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static h b() {
        synchronized (i.class) {
            h hVar = a;
            if (hVar != null) {
                a = hVar.f8943f;
                hVar.f8943f = null;
                b -= 8192;
                return hVar;
            }
            return new h();
        }
    }
}
