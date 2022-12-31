package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.c;
import com.google.android.gms.common.stats.ConnectionTracker;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class f8 implements ServiceConnection, c.a, c.b {
    private volatile boolean a;
    private volatile g3 b;
    final /* synthetic */ g8 c;

    /* JADX INFO: Access modifiers changed from: protected */
    public f8(g8 g8Var) {
        this.c = g8Var;
    }

    @WorkerThread
    public final void a(Intent intent) {
        f8 f8Var;
        this.c.f();
        Context zzaw = this.c.a.zzaw();
        ConnectionTracker connectionTracker = ConnectionTracker.getInstance();
        synchronized (this) {
            if (this.a) {
                this.c.a.a().u().a("Connection attempt already in progress");
                return;
            }
            this.c.a.a().u().a("Using local app measurement service");
            this.a = true;
            f8Var = this.c.c;
            connectionTracker.a(zzaw, intent, f8Var, 129);
        }
    }

    @WorkerThread
    public final void b() {
        if (this.b != null && (this.b.isConnected() || this.b.isConnecting())) {
            this.b.disconnect();
        }
        this.b = null;
    }

    @WorkerThread
    public final void c() {
        this.c.f();
        Context zzaw = this.c.a.zzaw();
        synchronized (this) {
            if (this.a) {
                this.c.a.a().u().a("Connection attempt already in progress");
            } else if (this.b != null && (this.b.isConnecting() || this.b.isConnected())) {
                this.c.a.a().u().a("Already awaiting connection attempt");
            } else {
                this.b = new g3(zzaw, Looper.getMainLooper(), this, this);
                this.c.a.a().u().a("Connecting to remote service");
                this.a = true;
                com.google.android.gms.common.internal.q.j(this.b);
                this.b.checkAvailabilityAndConnect();
            }
        }
    }

    @Override // com.google.android.gms.common.internal.c.a
    @MainThread
    public final void onConnected(Bundle bundle) {
        com.google.android.gms.common.internal.q.e("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                com.google.android.gms.common.internal.q.j(this.b);
                this.c.a.c().p(new b8(this, this.b.getService()));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.b = null;
                this.a = false;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.c.b
    @MainThread
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        com.google.android.gms.common.internal.q.e("MeasurementServiceConnection.onConnectionFailed");
        k3 z = this.c.a.z();
        if (z != null) {
            z.p().b("Service connection failed", connectionResult);
        }
        synchronized (this) {
            this.a = false;
            this.b = null;
        }
        this.c.a.c().p(new d8(this));
    }

    @Override // com.google.android.gms.common.internal.c.a
    @MainThread
    public final void onConnectionSuspended(int i2) {
        com.google.android.gms.common.internal.q.e("MeasurementServiceConnection.onConnectionSuspended");
        this.c.a.a().t().a("Service connection suspended");
        this.c.a.c().p(new c8(this));
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        f8 f8Var;
        a3 y2Var;
        com.google.android.gms.common.internal.q.e("MeasurementServiceConnection.onServiceConnected");
        synchronized (this) {
            if (iBinder == null) {
                this.a = false;
                this.c.a.a().m().a("Service connected with null binder");
                return;
            }
            a3 a3Var = null;
            try {
                String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (queryLocalInterface instanceof a3) {
                        y2Var = (a3) queryLocalInterface;
                    } else {
                        y2Var = new y2(iBinder);
                    }
                    a3Var = y2Var;
                    this.c.a.a().u().a("Bound to IMeasurementService interface");
                } else {
                    this.c.a.a().m().b("Got binder with a wrong descriptor", interfaceDescriptor);
                }
            } catch (RemoteException unused) {
                this.c.a.a().m().a("Service connect failed to get IMeasurementService");
            }
            if (a3Var == null) {
                this.a = false;
                try {
                    ConnectionTracker connectionTracker = ConnectionTracker.getInstance();
                    Context zzaw = this.c.a.zzaw();
                    f8Var = this.c.c;
                    connectionTracker.b(zzaw, f8Var);
                } catch (IllegalArgumentException unused2) {
                }
            } else {
                this.c.a.c().p(new z7(this, a3Var));
            }
        }
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public final void onServiceDisconnected(ComponentName componentName) {
        com.google.android.gms.common.internal.q.e("MeasurementServiceConnection.onServiceDisconnected");
        this.c.a.a().t().a("Service disconnected");
        this.c.a.c().p(new a8(this, componentName));
    }
}
