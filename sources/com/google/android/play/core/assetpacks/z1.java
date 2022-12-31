package com.google.android.play.core.assetpacks;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class z1 {

    /* renamed from: d  reason: collision with root package name */
    private static final com.google.android.play.core.internal.j f4849d = new com.google.android.play.core.internal.j("ExtractorTaskFinder");
    private final w1 a;
    private final k0 b;
    private final r0 c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z1(w1 w1Var, k0 k0Var, r0 r0Var) {
        this.a = w1Var;
        this.b = k0Var;
        this.c = r0Var;
    }

    private final boolean b(t1 t1Var, u1 u1Var) {
        k0 k0Var = this.b;
        s1 s1Var = t1Var.c;
        return k0Var.y(s1Var.a, t1Var.b, s1Var.b, u1Var.a).exists();
    }

    private static boolean c(u1 u1Var) {
        int i2 = u1Var.f4807f;
        return i2 == 1 || i2 == 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x040f, code lost:
        if (r0 != null) goto L150;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0218, code lost:
        r0 = com.google.android.play.core.assetpacks.z1.f4849d;
        r4 = new java.lang.Object[r8];
        r4[r7] = java.lang.Integer.valueOf(r6.a);
        r4[1] = r6.c.a;
        r4[2] = r10.a;
        r0.c("Found extraction task for patch for session %s, pack %s, slice %s.", r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0235, code lost:
        r11 = r34.b;
        r4 = r6.c;
        r0 = new java.io.FileInputStream(r11.y(r4.a, r6.b, r4.b, r10.a));
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x024c, code lost:
        r9 = r6.a;
        r11 = r6.c;
        r4 = new com.google.android.play.core.assetpacks.z0(r9, r11.a, r6.b, r11.b, r10.a, 0, 0, 1, r11.f4799d, r11.c, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x027b, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x02a1, code lost:
        throw new com.google.android.play.core.assetpacks.bv(java.lang.String.format("Error finding patch, session %s packName %s sliceId %s", java.lang.Integer.valueOf(r6.a), r6.c.a, r10.a), r0, r6.a);
     */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.play.core.assetpacks.y1 a() {
        /*
            Method dump skipped, instructions count: 1067
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.assetpacks.z1.a():com.google.android.play.core.assetpacks.y1");
    }
}
