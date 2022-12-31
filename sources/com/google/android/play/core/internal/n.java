package com.google.android.play.core.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.IInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class n extends k {
    final /* synthetic */ t b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(t tVar) {
        this.b = tVar;
    }

    @Override // com.google.android.play.core.internal.k
    public final void a() {
        IInterface iInterface;
        j jVar;
        Context context;
        ServiceConnection serviceConnection;
        iInterface = this.b.f4867k;
        if (iInterface != null) {
            jVar = this.b.b;
            jVar.f("Unbind from service.", new Object[0]);
            context = this.b.a;
            serviceConnection = this.b.f4866j;
            context.unbindService(serviceConnection);
            this.b.f4861e = false;
            this.b.f4867k = null;
            this.b.f4866j = null;
        }
    }
}
