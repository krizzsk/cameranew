package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.RemoteException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class r extends com.google.android.play.core.internal.k {
    final /* synthetic */ com.google.android.play.core.tasks.p b;
    final /* synthetic */ z c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(z zVar, com.google.android.play.core.tasks.p pVar, com.google.android.play.core.tasks.p pVar2) {
        super(pVar);
        this.c = zVar;
        this.b = pVar2;
    }

    @Override // com.google.android.play.core.internal.k
    protected final void a() {
        com.google.android.play.core.internal.j jVar;
        com.google.android.play.core.internal.t tVar;
        String str;
        Bundle v;
        try {
            tVar = this.c.f4839d;
            str = this.c.a;
            v = z.v();
            ((com.google.android.play.core.internal.v1) tVar.f()).R(str, v, new v(this.c, this.b));
        } catch (RemoteException e2) {
            jVar = z.f4837f;
            jVar.d(e2, "keepAlive", new Object[0]);
        }
    }
}
