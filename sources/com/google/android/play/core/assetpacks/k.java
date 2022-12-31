package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import java.util.Map;
/* loaded from: classes2.dex */
final class k extends com.google.android.play.core.internal.k {
    final /* synthetic */ Map b;
    final /* synthetic */ com.google.android.play.core.tasks.p c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ z f4752d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(z zVar, com.google.android.play.core.tasks.p pVar, Map map, com.google.android.play.core.tasks.p pVar2) {
        super(pVar);
        this.f4752d = zVar;
        this.b = map;
        this.c = pVar2;
    }

    @Override // com.google.android.play.core.internal.k
    protected final void a() {
        com.google.android.play.core.internal.j jVar;
        com.google.android.play.core.internal.t tVar;
        String str;
        try {
            tVar = this.f4752d.c;
            str = this.f4752d.a;
            ((com.google.android.play.core.internal.v1) tVar.f()).Y(str, z.l(this.b), new u(this.f4752d, this.c));
        } catch (RemoteException e2) {
            jVar = z.f4837f;
            jVar.d(e2, "syncPacks", new Object[0]);
            this.c.d(new RuntimeException(e2));
        }
    }
}
