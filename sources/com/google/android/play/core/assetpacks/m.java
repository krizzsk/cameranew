package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.RemoteException;
/* loaded from: classes2.dex */
final class m extends com.google.android.play.core.internal.k {
    final /* synthetic */ int b;
    final /* synthetic */ String c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ String f4778d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ int f4779e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ com.google.android.play.core.tasks.p f4780f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ z f4781g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(z zVar, com.google.android.play.core.tasks.p pVar, int i2, String str, String str2, int i3, com.google.android.play.core.tasks.p pVar2) {
        super(pVar);
        this.f4781g = zVar;
        this.b = i2;
        this.c = str;
        this.f4778d = str2;
        this.f4779e = i3;
        this.f4780f = pVar2;
    }

    @Override // com.google.android.play.core.internal.k
    protected final void a() {
        com.google.android.play.core.internal.j jVar;
        com.google.android.play.core.internal.t tVar;
        String str;
        Bundle v;
        try {
            tVar = this.f4781g.c;
            str = this.f4781g.a;
            Bundle r = z.r(this.b, this.c, this.f4778d, this.f4779e);
            v = z.v();
            ((com.google.android.play.core.internal.v1) tVar.f()).V(str, r, v, new s(this.f4781g, this.f4780f, (char[]) null));
        } catch (RemoteException e2) {
            jVar = z.f4837f;
            jVar.d(e2, "notifyChunkTransferred", new Object[0]);
        }
    }
}
