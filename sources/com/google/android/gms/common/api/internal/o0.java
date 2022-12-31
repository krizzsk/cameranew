package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.g;
import java.lang.ref.WeakReference;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public final class o0<R extends com.google.android.gms.common.api.g> extends com.google.android.gms.common.api.k<R> implements com.google.android.gms.common.api.h<R> {
    private com.google.android.gms.common.api.j<? super R, ? extends com.google.android.gms.common.api.g> a;
    private volatile com.google.android.gms.common.api.i<? super R> c;

    /* renamed from: g  reason: collision with root package name */
    private final WeakReference<GoogleApiClient> f3636g;

    /* renamed from: h  reason: collision with root package name */
    private final q0 f3637h;
    private o0<? extends com.google.android.gms.common.api.g> b = null;

    /* renamed from: d  reason: collision with root package name */
    private com.google.android.gms.common.api.e<R> f3633d = null;

    /* renamed from: e  reason: collision with root package name */
    private final Object f3634e = new Object();

    /* renamed from: f  reason: collision with root package name */
    private Status f3635f = null;

    /* renamed from: i  reason: collision with root package name */
    private boolean f3638i = false;

    public o0(WeakReference<GoogleApiClient> weakReference) {
        com.google.android.gms.common.internal.q.k(weakReference, "GoogleApiClient reference must not be null");
        this.f3636g = weakReference;
        GoogleApiClient googleApiClient = weakReference.get();
        this.f3637h = new q0(this, googleApiClient != null ? googleApiClient.d() : Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(com.google.android.gms.common.api.g gVar) {
        if (gVar instanceof com.google.android.gms.common.api.f) {
            try {
                ((com.google.android.gms.common.api.f) gVar).release();
            } catch (RuntimeException e2) {
                String valueOf = String.valueOf(gVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18);
                sb.append("Unable to release ");
                sb.append(valueOf);
                Log.w("TransformedResultImpl", sb.toString(), e2);
            }
        }
    }

    @GuardedBy("mSyncToken")
    private final void g() {
        if (this.a == null && this.c == null) {
            return;
        }
        GoogleApiClient googleApiClient = this.f3636g.get();
        if (!this.f3638i && this.a != null && googleApiClient != null) {
            googleApiClient.e(this);
            this.f3638i = true;
        }
        Status status = this.f3635f;
        if (status != null) {
            m(status);
            return;
        }
        com.google.android.gms.common.api.e<R> eVar = this.f3633d;
        if (eVar != null) {
            eVar.setResultCallback(this);
        }
    }

    @GuardedBy("mSyncToken")
    private final boolean h() {
        return (this.c == null || this.f3636g.get() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(Status status) {
        synchronized (this.f3634e) {
            this.f3635f = status;
            m(status);
        }
    }

    private final void m(Status status) {
        synchronized (this.f3634e) {
            com.google.android.gms.common.api.j<? super R, ? extends com.google.android.gms.common.api.g> jVar = this.a;
            if (jVar != null) {
                Status a = jVar.a(status);
                com.google.android.gms.common.internal.q.k(a, "onFailure must not return null");
                this.b.k(a);
            } else if (h()) {
                this.c.b(status);
            }
        }
    }

    @Override // com.google.android.gms.common.api.h
    public final void a(R r) {
        synchronized (this.f3634e) {
            if (r.getStatus().U()) {
                if (this.a != null) {
                    i0.a().submit(new n0(this, r));
                } else if (h()) {
                    this.c.c(r);
                }
            } else {
                k(r.getStatus());
                f(r);
            }
        }
    }

    @Override // com.google.android.gms.common.api.k
    @NonNull
    public final <S extends com.google.android.gms.common.api.g> com.google.android.gms.common.api.k<S> b(@NonNull com.google.android.gms.common.api.j<? super R, ? extends S> jVar) {
        o0<? extends com.google.android.gms.common.api.g> o0Var;
        synchronized (this.f3634e) {
            boolean z = true;
            com.google.android.gms.common.internal.q.n(this.a == null, "Cannot call then() twice.");
            if (this.c != null) {
                z = false;
            }
            com.google.android.gms.common.internal.q.n(z, "Cannot call then() and andFinally() on the same TransformedResult.");
            o0Var = new o0<>(this.f3636g);
            this.b = o0Var;
            g();
        }
        return o0Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(com.google.android.gms.common.api.e<?> eVar) {
        synchronized (this.f3634e) {
            this.f3633d = eVar;
            g();
        }
    }
}
