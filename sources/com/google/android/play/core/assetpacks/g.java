package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.RemoteException;
/* loaded from: classes2.dex */
final class g extends com.google.android.play.core.internal.k {
    final /* synthetic */ String b;
    final /* synthetic */ com.google.android.play.core.tasks.p c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ z f4737d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(z zVar, com.google.android.play.core.tasks.p pVar, String str, com.google.android.play.core.tasks.p pVar2) {
        super(pVar);
        this.f4737d = zVar;
        this.b = str;
        this.c = pVar2;
    }

    @Override // com.google.android.play.core.internal.k
    protected final void a() {
        com.google.android.play.core.internal.j jVar;
        com.google.android.play.core.internal.t tVar;
        String str;
        Bundle q;
        Bundle v;
        try {
            tVar = this.f4737d.c;
            str = this.f4737d.a;
            q = z.q(0, this.b);
            v = z.v();
            ((com.google.android.play.core.internal.v1) tVar.f()).B(str, q, v, new s(this.f4737d, this.c, (short[]) null));
        } catch (RemoteException e2) {
            jVar = z.f4837f;
            jVar.d(e2, "removePack(%s)", this.b);
        }
    }
}
