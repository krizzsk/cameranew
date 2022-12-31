package com.google.android.play.core.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class s implements ServiceConnection {
    final /* synthetic */ t a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ s(t tVar) {
        this.a = tVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        j jVar;
        jVar = this.a.b;
        jVar.f("ServiceConnectionImpl.onServiceConnected(%s)", componentName);
        this.a.h(new q(this, iBinder));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        j jVar;
        jVar = this.a.b;
        jVar.f("ServiceConnectionImpl.onServiceDisconnected(%s)", componentName);
        this.a.h(new r(this));
    }
}
