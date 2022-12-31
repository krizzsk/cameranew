package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.BinderThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.signin.internal.zam;
import java.util.Set;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public final class j0 extends com.google.android.gms.signin.internal.d implements GoogleApiClient.a, GoogleApiClient.b {

    /* renamed from: h  reason: collision with root package name */
    private static a.AbstractC0134a<? extends d.c.a.c.a.e, d.c.a.c.a.a> f3628h = d.c.a.c.a.b.c;
    private final Context a;
    private final Handler b;
    private final a.AbstractC0134a<? extends d.c.a.c.a.e, d.c.a.c.a.a> c;

    /* renamed from: d  reason: collision with root package name */
    private Set<Scope> f3629d;

    /* renamed from: e  reason: collision with root package name */
    private com.google.android.gms.common.internal.d f3630e;

    /* renamed from: f  reason: collision with root package name */
    private d.c.a.c.a.e f3631f;

    /* renamed from: g  reason: collision with root package name */
    private m0 f3632g;

    @WorkerThread
    public j0(Context context, Handler handler, @NonNull com.google.android.gms.common.internal.d dVar) {
        this(context, handler, dVar, f3628h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void B0(zam zamVar) {
        ConnectionResult Q = zamVar.Q();
        if (Q.U()) {
            ResolveAccountResponse R = zamVar.R();
            ConnectionResult R2 = R.R();
            if (!R2.U()) {
                String valueOf = String.valueOf(R2);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 48);
                sb.append("Sign-in succeeded with resolve account failure: ");
                sb.append(valueOf);
                Log.wtf("SignInCoordinator", sb.toString(), new Exception());
                this.f3632g.b(R2);
                this.f3631f.disconnect();
                return;
            }
            this.f3632g.c(R.Q(), this.f3629d);
        } else {
            this.f3632g.b(Q);
        }
        this.f3631f.disconnect();
    }

    public final void A0() {
        d.c.a.c.a.e eVar = this.f3631f;
        if (eVar != null) {
            eVar.disconnect();
        }
    }

    @Override // com.google.android.gms.signin.internal.c
    @BinderThread
    public final void D(zam zamVar) {
        this.b.post(new k0(this, zamVar));
    }

    @Override // com.google.android.gms.common.api.internal.e
    @WorkerThread
    public final void onConnected(@Nullable Bundle bundle) {
        this.f3631f.a(this);
    }

    @Override // com.google.android.gms.common.api.internal.l
    @WorkerThread
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        this.f3632g.b(connectionResult);
    }

    @Override // com.google.android.gms.common.api.internal.e
    @WorkerThread
    public final void onConnectionSuspended(int i2) {
        this.f3631f.disconnect();
    }

    @WorkerThread
    public final void z0(m0 m0Var) {
        d.c.a.c.a.e eVar = this.f3631f;
        if (eVar != null) {
            eVar.disconnect();
        }
        this.f3630e.j(Integer.valueOf(System.identityHashCode(this)));
        a.AbstractC0134a<? extends d.c.a.c.a.e, d.c.a.c.a.a> abstractC0134a = this.c;
        Context context = this.a;
        Looper looper = this.b.getLooper();
        com.google.android.gms.common.internal.d dVar = this.f3630e;
        this.f3631f = abstractC0134a.a(context, looper, dVar, dVar.i(), this, this);
        this.f3632g = m0Var;
        Set<Scope> set = this.f3629d;
        if (set != null && !set.isEmpty()) {
            this.f3631f.connect();
        } else {
            this.b.post(new l0(this));
        }
    }

    @WorkerThread
    public j0(Context context, Handler handler, @NonNull com.google.android.gms.common.internal.d dVar, a.AbstractC0134a<? extends d.c.a.c.a.e, d.c.a.c.a.a> abstractC0134a) {
        this.a = context;
        this.b = handler;
        com.google.android.gms.common.internal.q.k(dVar, "ClientSettings must not be null");
        this.f3630e = dVar;
        this.f3629d = dVar.h();
        this.c = abstractC0134a;
    }
}
