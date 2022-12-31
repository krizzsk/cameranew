package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import androidx.work.PeriodicWorkRequest;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.j;
import com.google.android.gms.common.internal.c;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.base.zap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public class f implements Handler.Callback {
    public static final Status n = new Status(4, "Sign-out occurred while this API call was in progress.");
    private static final Status o = new Status(4, "The user must be signed in to make this API call.");
    private static final Object p = new Object();
    @GuardedBy("lock")
    private static f q;

    /* renamed from: d  reason: collision with root package name */
    private final Context f3607d;

    /* renamed from: e  reason: collision with root package name */
    private final GoogleApiAvailability f3608e;

    /* renamed from: f  reason: collision with root package name */
    private final com.google.android.gms.common.internal.i f3609f;
    @GuardedBy("lock")

    /* renamed from: j  reason: collision with root package name */
    private s f3613j;
    private final Handler m;
    private long a = 5000;
    private long b = 120000;
    private long c = 10000;

    /* renamed from: g  reason: collision with root package name */
    private final AtomicInteger f3610g = new AtomicInteger(1);

    /* renamed from: h  reason: collision with root package name */
    private final AtomicInteger f3611h = new AtomicInteger(0);

    /* renamed from: i  reason: collision with root package name */
    private final Map<com.google.android.gms.common.api.internal.b<?>, a<?>> f3612i = new ConcurrentHashMap(5, 0.75f, 1);
    @GuardedBy("lock")

    /* renamed from: k  reason: collision with root package name */
    private final Set<com.google.android.gms.common.api.internal.b<?>> f3614k = new ArraySet();

    /* renamed from: l  reason: collision with root package name */
    private final Set<com.google.android.gms.common.api.internal.b<?>> f3615l = new ArraySet();

    /* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
    /* loaded from: classes2.dex */
    public class a<O extends a.d> implements GoogleApiClient.a, GoogleApiClient.b {
        private final a.f b;
        private final a.b c;

        /* renamed from: d  reason: collision with root package name */
        private final com.google.android.gms.common.api.internal.b<O> f3616d;

        /* renamed from: e  reason: collision with root package name */
        private final r f3617e;

        /* renamed from: h  reason: collision with root package name */
        private final int f3620h;

        /* renamed from: i  reason: collision with root package name */
        private final j0 f3621i;

        /* renamed from: j  reason: collision with root package name */
        private boolean f3622j;
        private final Queue<v> a = new LinkedList();

        /* renamed from: f  reason: collision with root package name */
        private final Set<v0> f3618f = new HashSet();

        /* renamed from: g  reason: collision with root package name */
        private final Map<j.a<?>, f0> f3619g = new HashMap();

        /* renamed from: k  reason: collision with root package name */
        private final List<b> f3623k = new ArrayList();

        /* renamed from: l  reason: collision with root package name */
        private ConnectionResult f3624l = null;

        @WorkerThread
        public a(com.google.android.gms.common.api.c<O> cVar) {
            a.f g2 = cVar.g(f.this.m.getLooper(), this);
            this.b = g2;
            if (g2 instanceof com.google.android.gms.common.internal.s) {
                this.c = ((com.google.android.gms.common.internal.s) g2).c();
            } else {
                this.c = g2;
            }
            this.f3616d = cVar.a();
            this.f3617e = new r();
            this.f3620h = cVar.e();
            if (g2.requiresSignIn()) {
                this.f3621i = cVar.i(f.this.f3607d, f.this.m);
            } else {
                this.f3621i = null;
            }
        }

        private final void A() {
            f.this.m.removeMessages(12, this.f3616d);
            f.this.m.sendMessageDelayed(f.this.m.obtainMessage(12, this.f3616d), f.this.c);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @WorkerThread
        public final void C(Status status) {
            com.google.android.gms.common.internal.q.d(f.this.m);
            h(status, null, false);
        }

        @WorkerThread
        private final void D(v vVar) {
            vVar.d(this.f3617e, d());
            try {
                vVar.c(this);
            } catch (DeadObjectException unused) {
                onConnectionSuspended(1);
                this.b.disconnect();
            } catch (Throwable th) {
                throw new IllegalStateException(String.format("Error in GoogleApi implementation for client %s.", this.c.getClass().getName()), th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @WorkerThread
        public final boolean E(boolean z) {
            com.google.android.gms.common.internal.q.d(f.this.m);
            if (this.b.isConnected() && this.f3619g.size() == 0) {
                if (!this.f3617e.d()) {
                    this.b.disconnect();
                    return true;
                }
                if (z) {
                    A();
                }
                return false;
            }
            return false;
        }

        @WorkerThread
        private final boolean J(@NonNull ConnectionResult connectionResult) {
            synchronized (f.p) {
                if (f.this.f3613j != null && f.this.f3614k.contains(this.f3616d)) {
                    f.this.f3613j.i(connectionResult, this.f3620h);
                    throw null;
                }
            }
            return false;
        }

        @WorkerThread
        private final void K(ConnectionResult connectionResult) {
            for (v0 v0Var : this.f3618f) {
                String str = null;
                if (com.google.android.gms.common.internal.p.a(connectionResult, ConnectionResult.RESULT_SUCCESS)) {
                    str = this.b.getEndpointPackageName();
                }
                v0Var.a(this.f3616d, connectionResult, str);
            }
            this.f3618f.clear();
        }

        private final Status L(ConnectionResult connectionResult) {
            String a = this.f3616d.a();
            String valueOf = String.valueOf(connectionResult);
            StringBuilder sb = new StringBuilder(String.valueOf(a).length() + 63 + String.valueOf(valueOf).length());
            sb.append("API: ");
            sb.append(a);
            sb.append(" is not available on this device. Connection failed with: ");
            sb.append(valueOf);
            return new Status(17, sb.toString());
        }

        @Nullable
        @WorkerThread
        private final Feature f(@Nullable Feature[] featureArr) {
            if (featureArr != null && featureArr.length != 0) {
                Feature[] availableFeatures = this.b.getAvailableFeatures();
                if (availableFeatures == null) {
                    availableFeatures = new Feature[0];
                }
                ArrayMap arrayMap = new ArrayMap(availableFeatures.length);
                for (Feature feature : availableFeatures) {
                    arrayMap.put(feature.getName(), Long.valueOf(feature.Q()));
                }
                for (Feature feature2 : featureArr) {
                    if (!arrayMap.containsKey(feature2.getName()) || ((Long) arrayMap.get(feature2.getName())).longValue() < feature2.Q()) {
                        return feature2;
                    }
                }
            }
            return null;
        }

        @WorkerThread
        private final void g(@NonNull ConnectionResult connectionResult, @Nullable Exception exc) {
            com.google.android.gms.common.internal.q.d(f.this.m);
            j0 j0Var = this.f3621i;
            if (j0Var != null) {
                j0Var.A0();
            }
            x();
            f.this.f3609f.a();
            K(connectionResult);
            if (connectionResult.Q() == 4) {
                C(f.o);
            } else if (this.a.isEmpty()) {
                this.f3624l = connectionResult;
            } else if (exc != null) {
                com.google.android.gms.common.internal.q.d(f.this.m);
                h(null, exc, false);
            } else {
                h(L(connectionResult), null, true);
                if (this.a.isEmpty() || J(connectionResult) || f.this.l(connectionResult, this.f3620h)) {
                    return;
                }
                if (connectionResult.Q() == 18) {
                    this.f3622j = true;
                }
                if (this.f3622j) {
                    f.this.m.sendMessageDelayed(Message.obtain(f.this.m, 9, this.f3616d), f.this.a);
                } else {
                    C(L(connectionResult));
                }
            }
        }

        @WorkerThread
        private final void h(@Nullable Status status, @Nullable Exception exc, boolean z) {
            com.google.android.gms.common.internal.q.d(f.this.m);
            if ((status == null) != (exc == null)) {
                Iterator<v> it = this.a.iterator();
                while (it.hasNext()) {
                    v next = it.next();
                    if (!z || next.a == 2) {
                        if (status != null) {
                            next.b(status);
                        } else {
                            next.e(exc);
                        }
                        it.remove();
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Status XOR exception should be null");
        }

        /* JADX INFO: Access modifiers changed from: private */
        @WorkerThread
        public final void k(b bVar) {
            if (this.f3623k.contains(bVar) && !this.f3622j) {
                if (!this.b.isConnected()) {
                    a();
                } else {
                    u();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @WorkerThread
        public final void q(b bVar) {
            Feature[] g2;
            if (this.f3623k.remove(bVar)) {
                f.this.m.removeMessages(15, bVar);
                f.this.m.removeMessages(16, bVar);
                Feature feature = bVar.b;
                ArrayList arrayList = new ArrayList(this.a.size());
                for (v vVar : this.a) {
                    if ((vVar instanceof s0) && (g2 = ((s0) vVar).g(this)) != null && com.google.android.gms.common.util.b.b(g2, feature)) {
                        arrayList.add(vVar);
                    }
                }
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    v vVar2 = (v) obj;
                    this.a.remove(vVar2);
                    vVar2.e(new UnsupportedApiCallException(feature));
                }
            }
        }

        @WorkerThread
        private final boolean r(v vVar) {
            if (!(vVar instanceof s0)) {
                D(vVar);
                return true;
            }
            s0 s0Var = (s0) vVar;
            Feature f2 = f(s0Var.g(this));
            if (f2 == null) {
                D(vVar);
                return true;
            }
            String name = this.c.getClass().getName();
            String name2 = f2.getName();
            long Q = f2.Q();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 77 + String.valueOf(name2).length());
            sb.append(name);
            sb.append(" could not execute call because it requires feature (");
            sb.append(name2);
            sb.append(", ");
            sb.append(Q);
            sb.append(").");
            Log.w("GoogleApiManager", sb.toString());
            if (s0Var.h(this)) {
                b bVar = new b(this.f3616d, f2, null);
                int indexOf = this.f3623k.indexOf(bVar);
                if (indexOf >= 0) {
                    b bVar2 = this.f3623k.get(indexOf);
                    f.this.m.removeMessages(15, bVar2);
                    f.this.m.sendMessageDelayed(Message.obtain(f.this.m, 15, bVar2), f.this.a);
                    return false;
                }
                this.f3623k.add(bVar);
                f.this.m.sendMessageDelayed(Message.obtain(f.this.m, 15, bVar), f.this.a);
                f.this.m.sendMessageDelayed(Message.obtain(f.this.m, 16, bVar), f.this.b);
                ConnectionResult connectionResult = new ConnectionResult(2, null);
                if (J(connectionResult)) {
                    return false;
                }
                f.this.l(connectionResult, this.f3620h);
                return false;
            }
            s0Var.e(new UnsupportedApiCallException(f2));
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @WorkerThread
        public final void s() {
            x();
            K(ConnectionResult.RESULT_SUCCESS);
            z();
            Iterator<f0> it = this.f3619g.values().iterator();
            while (it.hasNext()) {
                f0 next = it.next();
                if (f(next.a.b()) != null) {
                    it.remove();
                } else {
                    try {
                        next.a.c(this.c, new com.google.android.gms.tasks.h<>());
                    } catch (DeadObjectException unused) {
                        onConnectionSuspended(1);
                        this.b.disconnect();
                    } catch (RemoteException unused2) {
                        it.remove();
                    }
                }
            }
            u();
            A();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @WorkerThread
        public final void t() {
            x();
            this.f3622j = true;
            this.f3617e.f();
            f.this.m.sendMessageDelayed(Message.obtain(f.this.m, 9, this.f3616d), f.this.a);
            f.this.m.sendMessageDelayed(Message.obtain(f.this.m, 11, this.f3616d), f.this.b);
            f.this.f3609f.a();
            for (f0 f0Var : this.f3619g.values()) {
                f0Var.c.run();
            }
        }

        @WorkerThread
        private final void u() {
            ArrayList arrayList = new ArrayList(this.a);
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                v vVar = (v) obj;
                if (!this.b.isConnected()) {
                    return;
                }
                if (r(vVar)) {
                    this.a.remove(vVar);
                }
            }
        }

        @WorkerThread
        private final void z() {
            if (this.f3622j) {
                f.this.m.removeMessages(11, this.f3616d);
                f.this.m.removeMessages(9, this.f3616d);
                this.f3622j = false;
            }
        }

        @WorkerThread
        public final boolean B() {
            return E(true);
        }

        @WorkerThread
        public final void I(@NonNull ConnectionResult connectionResult) {
            com.google.android.gms.common.internal.q.d(f.this.m);
            this.b.disconnect();
            onConnectionFailed(connectionResult);
        }

        public final a.f M() {
            return this.b;
        }

        @WorkerThread
        public final void a() {
            com.google.android.gms.common.internal.q.d(f.this.m);
            if (this.b.isConnected() || this.b.isConnecting()) {
                return;
            }
            try {
                int b = f.this.f3609f.b(f.this.f3607d, this.b);
                if (b != 0) {
                    ConnectionResult connectionResult = new ConnectionResult(b, null);
                    String name = this.c.getClass().getName();
                    String valueOf = String.valueOf(connectionResult);
                    StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 35 + String.valueOf(valueOf).length());
                    sb.append("The service for ");
                    sb.append(name);
                    sb.append(" is not available: ");
                    sb.append(valueOf);
                    Log.w("GoogleApiManager", sb.toString());
                    onConnectionFailed(connectionResult);
                    return;
                }
                f fVar = f.this;
                a.f fVar2 = this.b;
                c cVar = new c(fVar2, this.f3616d);
                if (fVar2.requiresSignIn()) {
                    this.f3621i.z0(cVar);
                }
                try {
                    this.b.connect(cVar);
                } catch (SecurityException e2) {
                    g(new ConnectionResult(10), e2);
                }
            } catch (IllegalStateException e3) {
                g(new ConnectionResult(10), e3);
            }
        }

        public final int b() {
            return this.f3620h;
        }

        final boolean c() {
            return this.b.isConnected();
        }

        public final boolean d() {
            return this.b.requiresSignIn();
        }

        @WorkerThread
        public final void e() {
            com.google.android.gms.common.internal.q.d(f.this.m);
            if (this.f3622j) {
                a();
            }
        }

        @WorkerThread
        public final void l(v vVar) {
            com.google.android.gms.common.internal.q.d(f.this.m);
            if (this.b.isConnected()) {
                if (r(vVar)) {
                    A();
                    return;
                } else {
                    this.a.add(vVar);
                    return;
                }
            }
            this.a.add(vVar);
            ConnectionResult connectionResult = this.f3624l;
            if (connectionResult != null && connectionResult.T()) {
                onConnectionFailed(this.f3624l);
            } else {
                a();
            }
        }

        @WorkerThread
        public final void m(v0 v0Var) {
            com.google.android.gms.common.internal.q.d(f.this.m);
            this.f3618f.add(v0Var);
        }

        @WorkerThread
        public final void o() {
            Status status;
            com.google.android.gms.common.internal.q.d(f.this.m);
            if (this.f3622j) {
                z();
                if (f.this.f3608e.f(f.this.f3607d) == 18) {
                    status = new Status(8, "Connection timed out while waiting for Google Play services update to complete.");
                } else {
                    status = new Status(8, "API failed to connect while resuming due to an unknown error.");
                }
                C(status);
                this.b.disconnect();
            }
        }

        @Override // com.google.android.gms.common.api.internal.e
        public final void onConnected(@Nullable Bundle bundle) {
            if (Looper.myLooper() != f.this.m.getLooper()) {
                f.this.m.post(new y(this));
            } else {
                s();
            }
        }

        @Override // com.google.android.gms.common.api.internal.l
        @WorkerThread
        public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            g(connectionResult, null);
        }

        @Override // com.google.android.gms.common.api.internal.e
        public final void onConnectionSuspended(int i2) {
            if (Looper.myLooper() != f.this.m.getLooper()) {
                f.this.m.post(new x(this));
            } else {
                t();
            }
        }

        @WorkerThread
        public final void v() {
            com.google.android.gms.common.internal.q.d(f.this.m);
            C(f.n);
            this.f3617e.e();
            for (j.a aVar : (j.a[]) this.f3619g.keySet().toArray(new j.a[this.f3619g.size()])) {
                l(new u0(aVar, new com.google.android.gms.tasks.h()));
            }
            K(new ConnectionResult(4));
            if (this.b.isConnected()) {
                this.b.onUserSignOut(new z(this));
            }
        }

        public final Map<j.a<?>, f0> w() {
            return this.f3619g;
        }

        @WorkerThread
        public final void x() {
            com.google.android.gms.common.internal.q.d(f.this.m);
            this.f3624l = null;
        }

        @WorkerThread
        public final ConnectionResult y() {
            com.google.android.gms.common.internal.q.d(f.this.m);
            return this.f3624l;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
    /* loaded from: classes2.dex */
    public class c implements m0, c.InterfaceC0137c {
        private final a.f a;
        private final com.google.android.gms.common.api.internal.b<?> b;
        private com.google.android.gms.common.internal.j c = null;

        /* renamed from: d  reason: collision with root package name */
        private Set<Scope> f3625d = null;

        /* renamed from: e  reason: collision with root package name */
        private boolean f3626e = false;

        public c(a.f fVar, com.google.android.gms.common.api.internal.b<?> bVar) {
            this.a = fVar;
            this.b = bVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @WorkerThread
        public final void g() {
            com.google.android.gms.common.internal.j jVar;
            if (!this.f3626e || (jVar = this.c) == null) {
                return;
            }
            this.a.getRemoteService(jVar, this.f3625d);
        }

        @Override // com.google.android.gms.common.internal.c.InterfaceC0137c
        public final void a(@NonNull ConnectionResult connectionResult) {
            f.this.m.post(new b0(this, connectionResult));
        }

        @Override // com.google.android.gms.common.api.internal.m0
        @WorkerThread
        public final void b(ConnectionResult connectionResult) {
            ((a) f.this.f3612i.get(this.b)).I(connectionResult);
        }

        @Override // com.google.android.gms.common.api.internal.m0
        @WorkerThread
        public final void c(com.google.android.gms.common.internal.j jVar, Set<Scope> set) {
            if (jVar != null && set != null) {
                this.c = jVar;
                this.f3625d = set;
                g();
                return;
            }
            Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
            b(new ConnectionResult(4));
        }
    }

    private f(Context context, Looper looper, GoogleApiAvailability googleApiAvailability) {
        this.f3607d = context;
        zap zapVar = new zap(looper, this);
        this.m = zapVar;
        this.f3608e = googleApiAvailability;
        this.f3609f = new com.google.android.gms.common.internal.i(googleApiAvailability);
        zapVar.sendMessage(zapVar.obtainMessage(6));
    }

    public static f f(Context context) {
        f fVar;
        synchronized (p) {
            if (q == null) {
                HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
                handlerThread.start();
                q = new f(context.getApplicationContext(), handlerThread.getLooper(), GoogleApiAvailability.getInstance());
            }
            fVar = q;
        }
        return fVar;
    }

    @WorkerThread
    private final void g(com.google.android.gms.common.api.c<?> cVar) {
        com.google.android.gms.common.api.internal.b<?> a2 = cVar.a();
        a<?> aVar = this.f3612i.get(a2);
        if (aVar == null) {
            aVar = new a<>(cVar);
            this.f3612i.put(a2, aVar);
        }
        if (aVar.d()) {
            this.f3615l.add(a2);
        }
        aVar.a();
    }

    public final void b(ConnectionResult connectionResult, int i2) {
        if (l(connectionResult, i2)) {
            return;
        }
        Handler handler = this.m;
        handler.sendMessage(handler.obtainMessage(5, i2, 0, connectionResult));
    }

    public final void c(com.google.android.gms.common.api.c<?> cVar) {
        Handler handler = this.m;
        handler.sendMessage(handler.obtainMessage(7, cVar));
    }

    public final <O extends a.d> void d(com.google.android.gms.common.api.c<O> cVar, int i2, com.google.android.gms.common.api.internal.c<? extends com.google.android.gms.common.api.g, a.b> cVar2) {
        t0 t0Var = new t0(i2, cVar2);
        Handler handler = this.m;
        handler.sendMessage(handler.obtainMessage(4, new e0(t0Var, this.f3611h.get(), cVar)));
    }

    public final int h() {
        return this.f3610g.getAndIncrement();
    }

    @Override // android.os.Handler.Callback
    @WorkerThread
    public boolean handleMessage(Message message) {
        a<?> aVar;
        int i2 = message.what;
        long j2 = PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS;
        switch (i2) {
            case 1:
                if (((Boolean) message.obj).booleanValue()) {
                    j2 = 10000;
                }
                this.c = j2;
                this.m.removeMessages(12);
                for (com.google.android.gms.common.api.internal.b<?> bVar : this.f3612i.keySet()) {
                    Handler handler = this.m;
                    handler.sendMessageDelayed(handler.obtainMessage(12, bVar), this.c);
                }
                break;
            case 2:
                v0 v0Var = (v0) message.obj;
                Iterator<com.google.android.gms.common.api.internal.b<?>> it = v0Var.b().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else {
                        com.google.android.gms.common.api.internal.b<?> next = it.next();
                        a<?> aVar2 = this.f3612i.get(next);
                        if (aVar2 == null) {
                            v0Var.a(next, new ConnectionResult(13), null);
                            break;
                        } else if (aVar2.c()) {
                            v0Var.a(next, ConnectionResult.RESULT_SUCCESS, aVar2.M().getEndpointPackageName());
                        } else if (aVar2.y() != null) {
                            v0Var.a(next, aVar2.y(), null);
                        } else {
                            aVar2.m(v0Var);
                            aVar2.a();
                        }
                    }
                }
            case 3:
                for (a<?> aVar3 : this.f3612i.values()) {
                    aVar3.x();
                    aVar3.a();
                }
                break;
            case 4:
            case 8:
            case 13:
                e0 e0Var = (e0) message.obj;
                a<?> aVar4 = this.f3612i.get(e0Var.c.a());
                if (aVar4 == null) {
                    g(e0Var.c);
                    aVar4 = this.f3612i.get(e0Var.c.a());
                }
                if (aVar4.d() && this.f3611h.get() != e0Var.b) {
                    e0Var.a.b(n);
                    aVar4.v();
                    break;
                } else {
                    aVar4.l(e0Var.a);
                    break;
                }
            case 5:
                int i3 = message.arg1;
                ConnectionResult connectionResult = (ConnectionResult) message.obj;
                Iterator<a<?>> it2 = this.f3612i.values().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        a<?> next2 = it2.next();
                        aVar = next2.b() == i3 ? next2 : null;
                    }
                }
                if (aVar != null) {
                    String e2 = this.f3608e.e(connectionResult.Q());
                    String R = connectionResult.R();
                    StringBuilder sb = new StringBuilder(String.valueOf(e2).length() + 69 + String.valueOf(R).length());
                    sb.append("Error resolution was canceled by the user, original error message: ");
                    sb.append(e2);
                    sb.append(": ");
                    sb.append(R);
                    aVar.C(new Status(17, sb.toString()));
                    break;
                } else {
                    StringBuilder sb2 = new StringBuilder(76);
                    sb2.append("Could not find API instance ");
                    sb2.append(i3);
                    sb2.append(" while trying to fail enqueued calls.");
                    Log.wtf("GoogleApiManager", sb2.toString(), new Exception());
                    break;
                }
            case 6:
                if (this.f3607d.getApplicationContext() instanceof Application) {
                    BackgroundDetector.b((Application) this.f3607d.getApplicationContext());
                    BackgroundDetector.getInstance().a(new w(this));
                    if (!BackgroundDetector.getInstance().d(true)) {
                        this.c = PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS;
                        break;
                    }
                }
                break;
            case 7:
                g((com.google.android.gms.common.api.c) message.obj);
                break;
            case 9:
                if (this.f3612i.containsKey(message.obj)) {
                    this.f3612i.get(message.obj).e();
                    break;
                }
                break;
            case 10:
                for (com.google.android.gms.common.api.internal.b<?> bVar2 : this.f3615l) {
                    this.f3612i.remove(bVar2).v();
                }
                this.f3615l.clear();
                break;
            case 11:
                if (this.f3612i.containsKey(message.obj)) {
                    this.f3612i.get(message.obj).o();
                    break;
                }
                break;
            case 12:
                if (this.f3612i.containsKey(message.obj)) {
                    this.f3612i.get(message.obj).B();
                    break;
                }
                break;
            case 14:
                u uVar = (u) message.obj;
                com.google.android.gms.common.api.internal.b<?> a2 = uVar.a();
                if (!this.f3612i.containsKey(a2)) {
                    uVar.b().c(Boolean.FALSE);
                    break;
                } else {
                    uVar.b().c(Boolean.valueOf(this.f3612i.get(a2).E(false)));
                    break;
                }
            case 15:
                b bVar3 = (b) message.obj;
                if (this.f3612i.containsKey(bVar3.a)) {
                    this.f3612i.get(bVar3.a).k(bVar3);
                    break;
                }
                break;
            case 16:
                b bVar4 = (b) message.obj;
                if (this.f3612i.containsKey(bVar4.a)) {
                    this.f3612i.get(bVar4.a).q(bVar4);
                    break;
                }
                break;
            default:
                StringBuilder sb3 = new StringBuilder(31);
                sb3.append("Unknown message id: ");
                sb3.append(i2);
                Log.w("GoogleApiManager", sb3.toString());
                return false;
        }
        return true;
    }

    final boolean l(ConnectionResult connectionResult, int i2) {
        return this.f3608e.t(this.f3607d, connectionResult, i2);
    }

    public final void t() {
        Handler handler = this.m;
        handler.sendMessage(handler.obtainMessage(3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
    /* loaded from: classes2.dex */
    public static class b {
        private final com.google.android.gms.common.api.internal.b<?> a;
        private final Feature b;

        private b(com.google.android.gms.common.api.internal.b<?> bVar, Feature feature) {
            this.a = bVar;
            this.b = feature;
        }

        public final boolean equals(Object obj) {
            if (obj != null && (obj instanceof b)) {
                b bVar = (b) obj;
                if (com.google.android.gms.common.internal.p.a(this.a, bVar.a) && com.google.android.gms.common.internal.p.a(this.b, bVar.b)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return com.google.android.gms.common.internal.p.b(this.a, this.b);
        }

        public final String toString() {
            p.a c = com.google.android.gms.common.internal.p.c(this);
            c.a("key", this.a);
            c.a("feature", this.b);
            return c.toString();
        }

        /* synthetic */ b(com.google.android.gms.common.api.internal.b bVar, Feature feature, w wVar) {
            this(bVar, feature);
        }
    }
}
