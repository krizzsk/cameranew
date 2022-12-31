package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import java.util.List;
/* loaded from: classes2.dex */
final class y extends s<e> {
    private final List<String> c;

    /* renamed from: d  reason: collision with root package name */
    private final f1 f4825d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(z zVar, com.google.android.play.core.tasks.p<e> pVar, f1 f1Var, List<String> list) {
        super(zVar, pVar);
        this.f4825d = f1Var;
        this.c = list;
    }

    @Override // com.google.android.play.core.assetpacks.s, com.google.android.play.core.internal.x1
    public final void i(int i2, Bundle bundle) {
        super.i(i2, bundle);
        this.a.e(e.d(bundle, this.f4825d, this.c));
    }
}
