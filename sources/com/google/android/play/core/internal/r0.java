package com.google.android.play.core.internal;

import java.io.File;
import java.util.Set;
import us.pinguo.androidsdk.pgedit.PGEditResultActivity2;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class r0 implements x {
    @Override // com.google.android.play.core.internal.x
    public final void a(ClassLoader classLoader, Set<File> set) {
        o0.c(classLoader, set);
    }

    @Override // com.google.android.play.core.internal.x
    public final boolean b(ClassLoader classLoader, File file, File file2, boolean z) {
        return e0.e(classLoader, file, file2, z, j0.c(), PGEditResultActivity2.PATH, new q0());
    }
}
