package com.google.android.play.core.internal;

import java.io.File;
import java.util.Set;
import us.pinguo.androidsdk.pgedit.PGEditResultActivity2;
/* loaded from: classes2.dex */
final class o0 implements x {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(ClassLoader classLoader, Set<File> set) {
        j0.d(classLoader, set, new m0());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d(ClassLoader classLoader, File file, File file2, boolean z) {
        return e0.e(classLoader, file, file2, z, j0.c(), PGEditResultActivity2.PATH, new n0());
    }

    @Override // com.google.android.play.core.internal.x
    public final void a(ClassLoader classLoader, Set<File> set) {
        c(classLoader, set);
    }

    @Override // com.google.android.play.core.internal.x
    public final boolean b(ClassLoader classLoader, File file, File file2, boolean z) {
        return d(classLoader, file, file2, z);
    }
}
