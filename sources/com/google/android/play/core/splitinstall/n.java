package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.x0;
import java.util.List;
/* loaded from: classes2.dex */
class n<T> extends x0 {
    final com.google.android.play.core.tasks.p<T> a;
    final /* synthetic */ av b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(av avVar, com.google.android.play.core.tasks.p<T> pVar) {
        this.b = avVar;
        this.a = pVar;
    }

    @Override // com.google.android.play.core.internal.y0
    public final void a() throws RemoteException {
        com.google.android.play.core.internal.j jVar;
        this.b.b.b();
        jVar = av.c;
        jVar.f("onCompleteInstallForAppUpdate", new Object[0]);
    }

    @Override // com.google.android.play.core.internal.y0
    public final void a(int i2) throws RemoteException {
        com.google.android.play.core.internal.j jVar;
        this.b.b.b();
        jVar = av.c;
        jVar.f("onCompleteInstall(%d)", Integer.valueOf(i2));
    }

    @Override // com.google.android.play.core.internal.y0
    public void a(Bundle bundle) throws RemoteException {
        com.google.android.play.core.internal.j jVar;
        this.b.b.b();
        jVar = av.c;
        jVar.f("onDeferredInstall", new Object[0]);
    }

    @Override // com.google.android.play.core.internal.y0
    public void a(List<Bundle> list) throws RemoteException {
        com.google.android.play.core.internal.j jVar;
        this.b.b.b();
        jVar = av.c;
        jVar.f("onGetSessionStates", new Object[0]);
    }

    @Override // com.google.android.play.core.internal.y0
    public final void b() throws RemoteException {
        com.google.android.play.core.internal.j jVar;
        this.b.b.b();
        jVar = av.c;
        jVar.f("onGetSplitsForAppUpdate", new Object[0]);
    }

    @Override // com.google.android.play.core.internal.y0
    public void b(Bundle bundle) throws RemoteException {
        com.google.android.play.core.internal.j jVar;
        this.b.b.b();
        jVar = av.c;
        jVar.f("onDeferredLanguageUninstall", new Object[0]);
    }

    @Override // com.google.android.play.core.internal.y0
    public void c(Bundle bundle) throws RemoteException {
        com.google.android.play.core.internal.j jVar;
        this.b.b.b();
        jVar = av.c;
        jVar.f("onDeferredLanguageInstall", new Object[0]);
    }

    @Override // com.google.android.play.core.internal.y0
    public void h0(int i2, Bundle bundle) throws RemoteException {
        com.google.android.play.core.internal.j jVar;
        this.b.b.b();
        jVar = av.c;
        jVar.f("onGetSession(%d)", Integer.valueOf(i2));
    }

    @Override // com.google.android.play.core.internal.y0
    public void i(int i2, Bundle bundle) throws RemoteException {
        com.google.android.play.core.internal.j jVar;
        this.b.b.b();
        jVar = av.c;
        jVar.f("onCancelInstall(%d)", Integer.valueOf(i2));
    }

    @Override // com.google.android.play.core.internal.y0
    public void j(Bundle bundle) throws RemoteException {
        com.google.android.play.core.internal.j jVar;
        this.b.b.b();
        jVar = av.c;
        jVar.f("onDeferredUninstall", new Object[0]);
    }

    @Override // com.google.android.play.core.internal.y0
    public final void j0(Bundle bundle) throws RemoteException {
        com.google.android.play.core.internal.j jVar;
        this.b.b.b();
        int i2 = bundle.getInt("error_code");
        jVar = av.c;
        jVar.e("onError(%d)", Integer.valueOf(i2));
        this.a.d(new SplitInstallException(i2));
    }

    public void w0(int i2, Bundle bundle) throws RemoteException {
        com.google.android.play.core.internal.j jVar;
        this.b.b.b();
        jVar = av.c;
        jVar.f("onStartInstall(%d)", Integer.valueOf(i2));
    }
}
