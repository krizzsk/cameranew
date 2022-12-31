package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.RemoteException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class o extends com.google.android.play.core.internal.k {
    final /* synthetic */ int b;
    final /* synthetic */ String c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ com.google.android.play.core.tasks.p f4784d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ int f4785e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ z f4786f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(z zVar, com.google.android.play.core.tasks.p pVar, int i2, String str, com.google.android.play.core.tasks.p pVar2, int i3) {
        super(pVar);
        this.f4786f = zVar;
        this.b = i2;
        this.c = str;
        this.f4784d = pVar2;
        this.f4785e = i3;
    }

    @Override // com.google.android.play.core.internal.k
    protected final void a() {
        com.google.android.play.core.internal.j jVar;
        com.google.android.play.core.internal.t tVar;
        String str;
        Bundle q;
        Bundle v;
        try {
            tVar = this.f4786f.c;
            str = this.f4786f.a;
            q = z.q(this.b, this.c);
            v = z.v();
            ((com.google.android.play.core.internal.v1) tVar.f()).a0(str, q, v, new w(this.f4786f, this.f4784d, this.b, this.c, this.f4785e));
        } catch (RemoteException e2) {
            jVar = z.f4837f;
            jVar.d(e2, "notifyModuleCompleted", new Object[0]);
        }
    }
}
