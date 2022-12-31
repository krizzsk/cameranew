package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import java.util.ArrayList;
import java.util.Collection;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class k extends com.google.android.play.core.internal.k {
    final /* synthetic */ Collection b;
    final /* synthetic */ Collection c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ com.google.android.play.core.tasks.p f4882d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ av f4883e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(av avVar, com.google.android.play.core.tasks.p pVar, Collection collection, Collection collection2, com.google.android.play.core.tasks.p pVar2) {
        super(pVar);
        this.f4883e = avVar;
        this.b = collection;
        this.c = collection2;
        this.f4882d = pVar2;
    }

    @Override // com.google.android.play.core.internal.k
    protected final void a() {
        com.google.android.play.core.internal.j jVar;
        String str;
        ArrayList c = av.c(this.b);
        c.addAll(av.e(this.c));
        try {
            str = this.f4883e.a;
            this.f4883e.b.f().y(str, c, av.d(), new m(this.f4883e, this.f4882d));
        } catch (RemoteException e2) {
            jVar = av.c;
            jVar.d(e2, "startInstall(%s,%s)", this.b, this.c);
            this.f4882d.d(new RuntimeException(e2));
        }
    }
}
