package com.google.android.play.core.assetpacks;

import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class a1 {

    /* renamed from: f  reason: collision with root package name */
    private static final com.google.android.play.core.internal.j f4697f = new com.google.android.play.core.internal.j("ExtractChunkTaskHandler");
    private final byte[] a = new byte[8192];
    private final k0 b;
    private final com.google.android.play.core.internal.k1<x3> c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.android.play.core.internal.k1<e0> f4698d;

    /* renamed from: e  reason: collision with root package name */
    private final f1 f4699e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a1(k0 k0Var, com.google.android.play.core.internal.k1<x3> k1Var, com.google.android.play.core.internal.k1<e0> k1Var2, f1 f1Var) {
        this.b = k0Var;
        this.c = k1Var;
        this.f4698d = k1Var2;
        this.f4699e = f1Var;
    }

    private final File b(z0 z0Var) {
        File c = this.b.c(z0Var.b, z0Var.c, z0Var.f4841d, z0Var.f4842e);
        if (!c.exists()) {
            c.mkdirs();
        }
        return c;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(19:1|(1:3)|4|5|6|(1:8)(2:112|113)|9|(2:11|(12:13|(1:(1:(2:17|(2:82|83))(2:84|85))(2:86|(10:88|(7:21|(4:22|(2:26|(1:35)(4:30|(1:32)|33|34))|36|(1:38)(1:62))|40|41|(1:43)|44|(2:46|(1:48)(2:49|(1:51)(3:52|(2:54|(1:56)(2:58|59))(1:61)|57))))|63|64|(2:76|77)|66|67|68|69|(2:71|72)(1:73))(2:89|90)))(2:91|(4:93|(4:94|(1:96)|97|(1:100)(1:106))|103|(1:105))(2:107|108))|19|(0)|63|64|(0)|66|67|68|69|(0)(0))(2:109|110))|111|(0)|63|64|(0)|66|67|68|69|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x02f0, code lost:
        com.google.android.play.core.assetpacks.a1.f4697f.g("Could not close file for chunk %s of slice %s of pack %s.", java.lang.Integer.valueOf(r23.f4844g), r23.f4842e, r23.b);
     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0294 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0180 A[Catch: all -> 0x032f, TryCatch #3 {IOException -> 0x033b, blocks: (B:6:0x002f, B:89:0x028b, B:9:0x0037, B:11:0x0040, B:13:0x0046, B:15:0x0054, B:19:0x005e, B:51:0x0180, B:52:0x0189, B:54:0x0193, B:56:0x0199, B:58:0x019f, B:60:0x01a5, B:62:0x01c9, B:63:0x01d5, B:64:0x01d9, B:65:0x01e0, B:67:0x01e6, B:69:0x01ec, B:71:0x01f2, B:72:0x0202, B:74:0x0208, B:76:0x020e, B:77:0x0221, B:79:0x0227, B:80:0x0236, B:82:0x023c, B:88:0x027d, B:85:0x0264, B:86:0x026b, B:87:0x026c, B:22:0x0078, B:23:0x0081, B:24:0x0082, B:25:0x009b, B:26:0x009c, B:28:0x00c3, B:29:0x00cf, B:30:0x00d8, B:31:0x00d9, B:33:0x00f7, B:34:0x0109, B:36:0x011e, B:37:0x0123, B:42:0x0132, B:44:0x013b, B:45:0x0153, B:46:0x015c, B:47:0x015d, B:48:0x017c), top: B:116:0x002f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(com.google.android.play.core.assetpacks.z0 r23) {
        /*
            Method dump skipped, instructions count: 885
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.assetpacks.a1.a(com.google.android.play.core.assetpacks.z0):void");
    }
}
