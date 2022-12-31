package com.google.android.play.core.review;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.tasks.p;
/* loaded from: classes2.dex */
class i<T> extends com.google.android.play.core.internal.d {
    final com.google.android.play.core.internal.j a;
    final p<T> b;
    final /* synthetic */ h c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, com.google.android.play.core.internal.j jVar, p<T> pVar) {
        this.c = hVar;
        this.a = jVar;
        this.b = pVar;
    }

    @Override // com.google.android.play.core.internal.h
    public void a(Bundle bundle) throws RemoteException {
        this.c.a.b();
        this.a.f("onGetLaunchReviewFlowInfo", new Object[0]);
    }
}
