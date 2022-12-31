package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.RemoteException;
/* loaded from: classes2.dex */
final class p extends com.google.android.play.core.internal.k {
    final /* synthetic */ int b;
    final /* synthetic */ com.google.android.play.core.tasks.p c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ z f4788d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(z zVar, com.google.android.play.core.tasks.p pVar, int i2, com.google.android.play.core.tasks.p pVar2) {
        super(pVar);
        this.f4788d = zVar;
        this.b = i2;
        this.c = pVar2;
    }

    @Override // com.google.android.play.core.internal.k
    protected final void a() {
        com.google.android.play.core.internal.j jVar;
        com.google.android.play.core.internal.t tVar;
        String str;
        Bundle p;
        Bundle v;
        try {
            tVar = this.f4788d.c;
            str = this.f4788d.a;
            p = z.p(this.b);
            v = z.v();
            ((com.google.android.play.core.internal.v1) tVar.f()).w(str, p, v, new s(this.f4788d, this.c, (int[]) null));
        } catch (RemoteException e2) {
            jVar = z.f4837f;
            jVar.d(e2, "notifySessionFailed", new Object[0]);
        }
    }
}
