package com.google.android.play.core.assetpacks;

import android.os.Bundle;
/* loaded from: classes2.dex */
final class x extends s<e> {
    private final f1 c;

    /* renamed from: d  reason: collision with root package name */
    private final h0 f4823d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(z zVar, com.google.android.play.core.tasks.p<e> pVar, f1 f1Var, h0 h0Var) {
        super(zVar, pVar);
        this.c = f1Var;
        this.f4823d = h0Var;
    }

    @Override // com.google.android.play.core.assetpacks.s, com.google.android.play.core.internal.x1
    public final void i0(Bundle bundle, Bundle bundle2) {
        super.i0(bundle, bundle2);
        this.a.e(e.c(bundle, this.c, this.f4823d));
    }
}
