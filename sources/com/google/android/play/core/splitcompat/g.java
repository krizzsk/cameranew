package com.google.android.play.core.splitcompat;

import java.io.IOException;
import java.util.Set;
import java.util.zip.ZipFile;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class g implements i {
    final /* synthetic */ Set a;
    final /* synthetic */ r b;
    final /* synthetic */ l c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(l lVar, Set set, r rVar) {
        this.c = lVar;
        this.a = set;
        this.b = rVar;
    }

    @Override // com.google.android.play.core.splitcompat.i
    public final void a(ZipFile zipFile, Set<k> set) throws IOException {
        this.a.addAll(l.b(this.c, set, this.b, zipFile));
    }
}
