package com.google.android.play.core.assetpacks;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class w2 {

    /* renamed from: d  reason: collision with root package name */
    private static final com.google.android.play.core.internal.j f4822d = new com.google.android.play.core.internal.j("PatchSliceTaskHandler");
    private final k0 a;
    private final com.google.android.play.core.internal.k1<x3> b;
    private final com.google.android.play.core.common.b c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w2(k0 k0Var, com.google.android.play.core.internal.k1<x3> k1Var, com.google.android.play.core.common.b bVar) {
        this.a = k0Var;
        this.b = k1Var;
        this.c = bVar;
    }

    public final void a(v2 v2Var) {
        File b = this.a.b(v2Var.b, v2Var.c, v2Var.f4808d);
        File file = new File(this.a.k(v2Var.b, v2Var.c, v2Var.f4808d), v2Var.f4812h);
        try {
            InputStream inputStream = v2Var.f4814j;
            if (v2Var.f4811g == 2) {
                inputStream = new GZIPInputStream(inputStream, 8192);
            }
            n0 n0Var = new n0(b, file);
            if (this.c.b()) {
                File c = this.a.c(v2Var.b, v2Var.f4809e, v2Var.f4810f, v2Var.f4812h);
                if (!c.exists()) {
                    c.mkdirs();
                }
                z2 z2Var = new z2(this.a, v2Var.b, v2Var.f4809e, v2Var.f4810f, v2Var.f4812h);
                com.google.android.play.core.internal.t0.j(n0Var, inputStream, new e1(c, z2Var), v2Var.f4813i);
                z2Var.j(0);
            } else {
                File file2 = new File(this.a.B(v2Var.b, v2Var.f4809e, v2Var.f4810f, v2Var.f4812h), "slice.zip.tmp");
                if (file2.getParentFile() != null && !file2.getParentFile().exists()) {
                    file2.getParentFile().mkdirs();
                }
                com.google.android.play.core.internal.t0.j(n0Var, inputStream, new FileOutputStream(file2), v2Var.f4813i);
                if (!file2.renameTo(this.a.y(v2Var.b, v2Var.f4809e, v2Var.f4810f, v2Var.f4812h))) {
                    throw new bv(String.format("Error moving patch for slice %s of pack %s.", v2Var.f4812h, v2Var.b), v2Var.a);
                }
            }
            inputStream.close();
            if (this.c.b()) {
                f4822d.f("Patching and extraction finished for slice %s of pack %s.", v2Var.f4812h, v2Var.b);
            } else {
                f4822d.f("Patching finished for slice %s of pack %s.", v2Var.f4812h, v2Var.b);
            }
            this.b.a().c(v2Var.a, v2Var.b, v2Var.f4812h, 0);
            try {
                v2Var.f4814j.close();
            } catch (IOException unused) {
                f4822d.g("Could not close file for slice %s of pack %s.", v2Var.f4812h, v2Var.b);
            }
        } catch (IOException e2) {
            f4822d.e("IOException during patching %s.", e2.getMessage());
            throw new bv(String.format("Error patching slice %s of pack %s.", v2Var.f4812h, v2Var.b), e2, v2Var.a);
        }
    }
}
