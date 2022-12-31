package com.google.android.play.core.assetpacks;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class d3 {
    private static final com.google.android.play.core.internal.j b = new com.google.android.play.core.internal.j("VerifySliceTaskHandler");
    private final k0 a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d3(k0 k0Var) {
        this.a = k0Var;
    }

    private final void b(c3 c3Var, File file) {
        try {
            File B = this.a.B(c3Var.b, c3Var.c, c3Var.f4710d, c3Var.f4711e);
            if (!B.exists()) {
                throw new bv(String.format("Cannot find metadata files for slice %s.", c3Var.f4711e), c3Var.a);
            }
            try {
                if (!j2.b(b3.a(file, B)).equals(c3Var.f4712f)) {
                    throw new bv(String.format("Verification failed for slice %s.", c3Var.f4711e), c3Var.a);
                }
                b.f("Verification of slice %s of pack %s successful.", c3Var.f4711e, c3Var.b);
            } catch (IOException e2) {
                throw new bv(String.format("Could not digest file during verification for slice %s.", c3Var.f4711e), e2, c3Var.a);
            } catch (NoSuchAlgorithmException e3) {
                throw new bv("SHA256 algorithm not supported.", e3, c3Var.a);
            }
        } catch (IOException e4) {
            throw new bv(String.format("Could not reconstruct slice archive during verification for slice %s.", c3Var.f4711e), e4, c3Var.a);
        }
    }

    public final void a(c3 c3Var) {
        File c = this.a.c(c3Var.b, c3Var.c, c3Var.f4710d, c3Var.f4711e);
        if (!c.exists()) {
            throw new bv(String.format("Cannot find unverified files for slice %s.", c3Var.f4711e), c3Var.a);
        }
        b(c3Var, c);
        File l2 = this.a.l(c3Var.b, c3Var.c, c3Var.f4710d, c3Var.f4711e);
        if (!l2.exists()) {
            l2.mkdirs();
        }
        if (!c.renameTo(l2)) {
            throw new bv(String.format("Failed to move slice %s after verification.", c3Var.f4711e), c3Var.a);
        }
    }
}
