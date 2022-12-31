package com.google.android.gms.common.api.internal;

import androidx.annotation.WorkerThread;
import com.google.android.gms.common.api.GoogleApiClient;
import java.lang.ref.WeakReference;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
final class n0 implements Runnable {
    private final /* synthetic */ com.google.android.gms.common.api.g a;
    private final /* synthetic */ o0 b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n0(o0 o0Var, com.google.android.gms.common.api.g gVar) {
        this.b = o0Var;
        this.a = gVar;
    }

    @Override // java.lang.Runnable
    @WorkerThread
    public final void run() {
        q0 q0Var;
        q0 q0Var2;
        WeakReference weakReference;
        WeakReference weakReference2;
        com.google.android.gms.common.api.j jVar;
        q0 q0Var3;
        q0 q0Var4;
        WeakReference weakReference3;
        try {
            try {
                ThreadLocal<Boolean> threadLocal = BasePendingResult.zadr;
                threadLocal.set(Boolean.TRUE);
                jVar = this.b.a;
                com.google.android.gms.common.api.e b = jVar.b(this.a);
                q0Var3 = this.b.f3637h;
                q0Var4 = this.b.f3637h;
                q0Var3.sendMessage(q0Var4.obtainMessage(0, b));
                threadLocal.set(Boolean.FALSE);
                o0 o0Var = this.b;
                o0.f(this.a);
                weakReference3 = this.b.f3636g;
                GoogleApiClient googleApiClient = (GoogleApiClient) weakReference3.get();
                if (googleApiClient != null) {
                    googleApiClient.f(this.b);
                }
            } catch (RuntimeException e2) {
                q0Var = this.b.f3637h;
                q0Var2 = this.b.f3637h;
                q0Var.sendMessage(q0Var2.obtainMessage(1, e2));
                BasePendingResult.zadr.set(Boolean.FALSE);
                o0 o0Var2 = this.b;
                o0.f(this.a);
                weakReference = this.b.f3636g;
                GoogleApiClient googleApiClient2 = (GoogleApiClient) weakReference.get();
                if (googleApiClient2 != null) {
                    googleApiClient2.f(this.b);
                }
            }
        } catch (Throwable th) {
            BasePendingResult.zadr.set(Boolean.FALSE);
            o0 o0Var3 = this.b;
            o0.f(this.a);
            weakReference2 = this.b.f3636g;
            GoogleApiClient googleApiClient3 = (GoogleApiClient) weakReference2.get();
            if (googleApiClient3 != null) {
                googleApiClient3.f(this.b);
            }
            throw th;
        }
    }
}
