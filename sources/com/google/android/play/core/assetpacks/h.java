package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
final class h extends com.google.android.play.core.internal.k {
    final /* synthetic */ List b;
    final /* synthetic */ Map c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ com.google.android.play.core.tasks.p f4744d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ List f4745e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ z f4746f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(z zVar, com.google.android.play.core.tasks.p pVar, List list, Map map, com.google.android.play.core.tasks.p pVar2, List list2) {
        super(pVar);
        this.f4746f = zVar;
        this.b = list;
        this.c = map;
        this.f4744d = pVar2;
        this.f4745e = list2;
    }

    @Override // com.google.android.play.core.internal.k
    protected final void a() {
        com.google.android.play.core.internal.j jVar;
        com.google.android.play.core.internal.t tVar;
        String str;
        f1 f1Var;
        ArrayList f2 = z.f(this.b);
        try {
            tVar = this.f4746f.c;
            str = this.f4746f.a;
            Bundle l2 = z.l(this.c);
            z zVar = this.f4746f;
            com.google.android.play.core.tasks.p pVar = this.f4744d;
            f1Var = zVar.b;
            ((com.google.android.play.core.internal.v1) tVar.f()).o0(str, f2, l2, new y(zVar, pVar, f1Var, this.f4745e));
        } catch (RemoteException e2) {
            jVar = z.f4837f;
            jVar.d(e2, "startDownload(%s)", this.b);
            this.f4744d.d(new RuntimeException(e2));
        }
    }
}
