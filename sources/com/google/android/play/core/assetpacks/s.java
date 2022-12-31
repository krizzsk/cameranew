package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.RemoteException;
import com.tapjoy.TapjoyConstants;
import java.util.List;
/* loaded from: classes2.dex */
class s<T> extends com.google.android.play.core.internal.w1 {
    final com.google.android.play.core.tasks.p<T> a;
    final /* synthetic */ z b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(z zVar, com.google.android.play.core.tasks.p<T> pVar) {
        this.b = zVar;
        this.a = pVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(z zVar, com.google.android.play.core.tasks.p pVar, byte[] bArr) {
        this(zVar, pVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(z zVar, com.google.android.play.core.tasks.p pVar, char[] cArr) {
        this(zVar, pVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(z zVar, com.google.android.play.core.tasks.p pVar, int[] iArr) {
        this(zVar, pVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(z zVar, com.google.android.play.core.tasks.p pVar, short[] sArr) {
        this(zVar, pVar);
    }

    @Override // com.google.android.play.core.internal.x1
    public void a() {
        com.google.android.play.core.internal.t tVar;
        com.google.android.play.core.internal.j jVar;
        tVar = this.b.c;
        tVar.b();
        jVar = z.f4837f;
        jVar.f("onCancelDownloads()", new Object[0]);
    }

    @Override // com.google.android.play.core.internal.x1
    public final void a(int i2) {
        com.google.android.play.core.internal.t tVar;
        com.google.android.play.core.internal.j jVar;
        tVar = this.b.c;
        tVar.b();
        jVar = z.f4837f;
        jVar.f("onCancelDownload(%d)", Integer.valueOf(i2));
    }

    @Override // com.google.android.play.core.internal.x1
    public void a(Bundle bundle) {
        com.google.android.play.core.internal.t tVar;
        com.google.android.play.core.internal.j jVar;
        tVar = this.b.c;
        tVar.b();
        int i2 = bundle.getInt("error_code");
        jVar = z.f4837f;
        jVar.e("onError(%d)", Integer.valueOf(i2));
        this.a.d(new AssetPackException(i2));
    }

    @Override // com.google.android.play.core.internal.x1
    public void a(List<Bundle> list) {
        com.google.android.play.core.internal.t tVar;
        com.google.android.play.core.internal.j jVar;
        tVar = this.b.c;
        tVar.b();
        jVar = z.f4837f;
        jVar.f("onGetSessionStates", new Object[0]);
    }

    @Override // com.google.android.play.core.internal.x1
    public void b() {
        com.google.android.play.core.internal.t tVar;
        com.google.android.play.core.internal.j jVar;
        tVar = this.b.c;
        tVar.b();
        jVar = z.f4837f;
        jVar.f("onRemoveModule()", new Object[0]);
    }

    @Override // com.google.android.play.core.internal.x1
    public final void b(int i2) {
        com.google.android.play.core.internal.t tVar;
        com.google.android.play.core.internal.j jVar;
        tVar = this.b.c;
        tVar.b();
        jVar = z.f4837f;
        jVar.f("onGetSession(%d)", Integer.valueOf(i2));
    }

    @Override // com.google.android.play.core.internal.x1
    public void b(Bundle bundle) {
        com.google.android.play.core.internal.t tVar;
        com.google.android.play.core.internal.j jVar;
        tVar = this.b.c;
        tVar.b();
        jVar = z.f4837f;
        jVar.f("onNotifyModuleCompleted(%s, sessionId=%d)", bundle.getString("module_name"), Integer.valueOf(bundle.getInt(TapjoyConstants.TJC_SESSION_ID)));
    }

    @Override // com.google.android.play.core.internal.x1
    public void c(Bundle bundle) {
        com.google.android.play.core.internal.t tVar;
        com.google.android.play.core.internal.j jVar;
        tVar = this.b.c;
        tVar.b();
        jVar = z.f4837f;
        jVar.f("onNotifyChunkTransferred(%s, %s, %d, session=%d)", bundle.getString("module_name"), bundle.getString("slice_id"), Integer.valueOf(bundle.getInt("chunk_number")), Integer.valueOf(bundle.getInt(TapjoyConstants.TJC_SESSION_ID)));
    }

    @Override // com.google.android.play.core.internal.x1
    public void e(Bundle bundle, Bundle bundle2) {
        com.google.android.play.core.internal.t tVar;
        com.google.android.play.core.internal.j jVar;
        tVar = this.b.f4839d;
        tVar.b();
        jVar = z.f4837f;
        jVar.f("onKeepAlive(%b)", Boolean.valueOf(bundle.getBoolean("keep_alive")));
    }

    @Override // com.google.android.play.core.internal.x1
    public void i(int i2, Bundle bundle) {
        com.google.android.play.core.internal.t tVar;
        com.google.android.play.core.internal.j jVar;
        tVar = this.b.c;
        tVar.b();
        jVar = z.f4837f;
        jVar.f("onStartDownload(%d)", Integer.valueOf(i2));
    }

    @Override // com.google.android.play.core.internal.x1
    public void i0(Bundle bundle, Bundle bundle2) {
        com.google.android.play.core.internal.t tVar;
        com.google.android.play.core.internal.j jVar;
        tVar = this.b.c;
        tVar.b();
        jVar = z.f4837f;
        jVar.f("onRequestDownloadInfo()", new Object[0]);
    }

    @Override // com.google.android.play.core.internal.x1
    public void j(Bundle bundle) {
        com.google.android.play.core.internal.t tVar;
        com.google.android.play.core.internal.j jVar;
        tVar = this.b.c;
        tVar.b();
        jVar = z.f4837f;
        jVar.f("onNotifySessionFailed(%d)", Integer.valueOf(bundle.getInt(TapjoyConstants.TJC_SESSION_ID)));
    }

    @Override // com.google.android.play.core.internal.x1
    public void r(Bundle bundle, Bundle bundle2) throws RemoteException {
        com.google.android.play.core.internal.t tVar;
        com.google.android.play.core.internal.j jVar;
        tVar = this.b.c;
        tVar.b();
        jVar = z.f4837f;
        jVar.f("onGetChunkFileDescriptor", new Object[0]);
    }
}
