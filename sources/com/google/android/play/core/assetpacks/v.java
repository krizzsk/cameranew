package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
final class v extends s<Void> {
    final /* synthetic */ z c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(z zVar, com.google.android.play.core.tasks.p<Void> pVar) {
        super(zVar, pVar);
        this.c = zVar;
    }

    @Override // com.google.android.play.core.assetpacks.s, com.google.android.play.core.internal.x1
    public final void e(Bundle bundle, Bundle bundle2) {
        AtomicBoolean atomicBoolean;
        com.google.android.play.core.internal.j jVar;
        super.e(bundle, bundle2);
        atomicBoolean = this.c.f4840e;
        if (!atomicBoolean.compareAndSet(true, false)) {
            jVar = z.f4837f;
            jVar.g("Expected keepingAlive to be true, but was false.", new Object[0]);
        }
        if (bundle.getBoolean("keep_alive")) {
            this.c.a();
        }
    }
}
