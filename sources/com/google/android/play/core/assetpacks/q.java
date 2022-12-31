package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.RemoteException;
/* loaded from: classes2.dex */
final class q extends com.google.android.play.core.internal.k {
    final /* synthetic */ int b;
    final /* synthetic */ String c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ String f4793d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ int f4794e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ com.google.android.play.core.tasks.p f4795f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ z f4796g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(z zVar, com.google.android.play.core.tasks.p pVar, int i2, String str, String str2, int i3, com.google.android.play.core.tasks.p pVar2) {
        super(pVar);
        this.f4796g = zVar;
        this.b = i2;
        this.c = str;
        this.f4793d = str2;
        this.f4794e = i3;
        this.f4795f = pVar2;
    }

    @Override // com.google.android.play.core.internal.k
    protected final void a() {
        com.google.android.play.core.internal.j jVar;
        com.google.android.play.core.internal.t tVar;
        String str;
        Bundle v;
        try {
            tVar = this.f4796g.c;
            str = this.f4796g.a;
            Bundle r = z.r(this.b, this.c, this.f4793d, this.f4794e);
            v = z.v();
            ((com.google.android.play.core.internal.v1) tVar.f()).z(str, r, v, new t(this.f4796g, this.f4795f));
        } catch (RemoteException e2) {
            jVar = z.f4837f;
            jVar.e("getChunkFileDescriptor(%s, %s, %d, session=%d)", this.c, this.f4793d, Integer.valueOf(this.f4794e), Integer.valueOf(this.b));
            this.f4795f.d(new RuntimeException(e2));
        }
    }
}
