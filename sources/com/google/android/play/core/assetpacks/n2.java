package com.google.android.play.core.assetpacks;

import java.io.File;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class n2 {
    private static final com.google.android.play.core.internal.j b = new com.google.android.play.core.internal.j("MergeSliceTaskHandler");
    private final k0 a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n2(k0 k0Var) {
        this.a = k0Var;
    }

    private static void b(File file, File file2) {
        File[] listFiles;
        if (!file.isDirectory()) {
            if (file2.exists()) {
                String valueOf = String.valueOf(file2);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 51);
                sb.append("File clashing with existing file from other slice: ");
                sb.append(valueOf);
                throw new bv(sb.toString());
            } else if (file.renameTo(file2)) {
                return;
            } else {
                String valueOf2 = String.valueOf(file);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 21);
                sb2.append("Unable to move file: ");
                sb2.append(valueOf2);
                throw new bv(sb2.toString());
            }
        }
        file2.mkdirs();
        for (File file3 : file.listFiles()) {
            b(file3, new File(file2, file3.getName()));
        }
        if (file.delete()) {
            return;
        }
        String valueOf3 = String.valueOf(file);
        StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf3).length() + 28);
        sb3.append("Unable to delete directory: ");
        sb3.append(valueOf3);
        throw new bv(sb3.toString());
    }

    public final void a(m2 m2Var) {
        File l2 = this.a.l(m2Var.b, m2Var.c, m2Var.f4782d, m2Var.f4783e);
        if (!l2.exists()) {
            throw new bv(String.format("Cannot find verified files for slice %s.", m2Var.f4783e), m2Var.a);
        }
        File n = this.a.n(m2Var.b, m2Var.c, m2Var.f4782d);
        if (!n.exists()) {
            n.mkdirs();
        }
        b(l2, n);
        try {
            this.a.f(m2Var.b, m2Var.c, m2Var.f4782d, this.a.s(m2Var.b, m2Var.c, m2Var.f4782d) + 1);
        } catch (IOException e2) {
            b.e("Writing merge checkpoint failed with %s.", e2.getMessage());
            throw new bv("Writing merge checkpoint failed.", e2, m2Var.a);
        }
    }
}
