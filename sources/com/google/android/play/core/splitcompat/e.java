package com.google.android.play.core.splitcompat;

import java.io.File;
import java.io.IOException;
/* loaded from: classes2.dex */
final class e implements j {
    final /* synthetic */ f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(f fVar) {
        this.a = fVar;
    }

    @Override // com.google.android.play.core.splitcompat.j
    public final void a(k kVar, File file, boolean z) throws IOException {
        this.a.b.add(file);
        if (z) {
            return;
        }
        this.a.c.set(false);
    }
}
