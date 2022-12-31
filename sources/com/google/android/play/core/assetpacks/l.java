package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
final class l extends com.google.android.play.core.internal.k {
    final /* synthetic */ List b;
    final /* synthetic */ Map c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ com.google.android.play.core.tasks.p f4763d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ h0 f4764e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ z f4765f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(z zVar, com.google.android.play.core.tasks.p pVar, List list, Map map, com.google.android.play.core.tasks.p pVar2, h0 h0Var) {
        super(pVar);
        this.f4765f = zVar;
        this.b = list;
        this.c = map;
        this.f4763d = pVar2;
        this.f4764e = h0Var;
    }

    @Override // com.google.android.play.core.internal.k
    protected final void a() {
        com.google.android.play.core.internal.j jVar;
        com.google.android.play.core.internal.t tVar;
        String str;
        f1 f1Var;
        ArrayList f2 = z.f(this.b);
        try {
            tVar = this.f4765f.c;
            str = this.f4765f.a;
            Bundle l2 = z.l(this.c);
            z zVar = this.f4765f;
            com.google.android.play.core.tasks.p pVar = this.f4763d;
            f1Var = zVar.b;
            ((com.google.android.play.core.internal.v1) tVar.f()).u0(str, f2, l2, new x(zVar, pVar, f1Var, this.f4764e));
        } catch (RemoteException e2) {
            jVar = z.f4837f;
            jVar.d(e2, "getPackStates(%s)", this.b);
            this.f4763d.d(new RuntimeException(e2));
        }
    }
}
