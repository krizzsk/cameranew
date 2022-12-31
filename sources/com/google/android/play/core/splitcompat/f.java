package com.google.android.play.core.splitcompat;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipFile;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class f implements i {
    final /* synthetic */ r a;
    final /* synthetic */ Set b;
    final /* synthetic */ AtomicBoolean c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ l f4872d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(l lVar, r rVar, Set set, AtomicBoolean atomicBoolean) {
        this.f4872d = lVar;
        this.a = rVar;
        this.b = set;
        this.c = atomicBoolean;
    }

    @Override // com.google.android.play.core.splitcompat.i
    public final void a(ZipFile zipFile, Set<k> set) throws IOException {
        this.f4872d.f(this.a, set, new e(this));
    }
}
