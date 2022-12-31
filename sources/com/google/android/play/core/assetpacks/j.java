package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
final class j extends com.google.android.play.core.internal.k {
    final /* synthetic */ List b;
    final /* synthetic */ com.google.android.play.core.tasks.p c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ z f4751d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(z zVar, com.google.android.play.core.tasks.p pVar, List list, com.google.android.play.core.tasks.p pVar2) {
        super(pVar);
        this.f4751d = zVar;
        this.b = list;
        this.c = pVar2;
    }

    @Override // com.google.android.play.core.internal.k
    protected final void a() {
        com.google.android.play.core.internal.j jVar;
        com.google.android.play.core.internal.t tVar;
        String str;
        Bundle v;
        ArrayList f2 = z.f(this.b);
        try {
            tVar = this.f4751d.c;
            str = this.f4751d.a;
            v = z.v();
            ((com.google.android.play.core.internal.v1) tVar.f()).q0(str, f2, v, new s(this.f4751d, this.c, (byte[]) null));
        } catch (RemoteException e2) {
            jVar = z.f4837f;
            jVar.d(e2, "cancelDownloads(%s)", this.b);
        }
    }
}
