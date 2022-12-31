package com.google.android.gms.cloudmessaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.cloudmessaging.zze;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* loaded from: classes2.dex */
final class f implements ServiceConnection {
    @GuardedBy("this")
    int a;
    final Messenger b;
    o c;
    @GuardedBy("this")

    /* renamed from: d  reason: collision with root package name */
    final Queue<p<?>> f3586d;
    @GuardedBy("this")

    /* renamed from: e  reason: collision with root package name */
    final SparseArray<p<?>> f3587e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ e f3588f;

    private f(e eVar) {
        this.f3588f = eVar;
        this.a = 0;
        this.b = new Messenger(new zze(Looper.getMainLooper(), new Handler.Callback(this) { // from class: com.google.android.gms.cloudmessaging.i
            private final f a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
            }

            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.a.d(message);
            }
        }));
        this.f3586d = new ArrayDeque();
        this.f3587e = new SparseArray<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        e.g(this.f3588f).execute(new Runnable(this) { // from class: com.google.android.gms.cloudmessaging.j
            private final f a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                final p<?> poll;
                final f fVar = this.a;
                while (true) {
                    synchronized (fVar) {
                        if (fVar.a != 2) {
                            return;
                        }
                        if (fVar.f3586d.isEmpty()) {
                            fVar.f();
                            return;
                        }
                        poll = fVar.f3586d.poll();
                        fVar.f3587e.put(poll.a, poll);
                        e.g(fVar.f3588f).schedule(new Runnable(fVar, poll) { // from class: com.google.android.gms.cloudmessaging.l
                            private final f a;
                            private final p b;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                this.a = fVar;
                                this.b = poll;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                this.a.b(this.b.a);
                            }
                        }, 30L, TimeUnit.SECONDS);
                    }
                    if (Log.isLoggable("MessengerIpcClient", 3)) {
                        String valueOf = String.valueOf(poll);
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 8);
                        sb.append("Sending ");
                        sb.append(valueOf);
                        Log.d("MessengerIpcClient", sb.toString());
                    }
                    Context b = e.b(fVar.f3588f);
                    Messenger messenger = fVar.b;
                    Message obtain = Message.obtain();
                    obtain.what = poll.c;
                    obtain.arg1 = poll.a;
                    obtain.replyTo = messenger;
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("oneWay", poll.d());
                    bundle.putString("pkg", b.getPackageName());
                    bundle.putBundle("data", poll.f3589d);
                    obtain.setData(bundle);
                    try {
                        fVar.c.a(obtain);
                    } catch (RemoteException e2) {
                        fVar.c(2, e2.getMessage());
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void b(int i2) {
        p<?> pVar = this.f3587e.get(i2);
        if (pVar != null) {
            StringBuilder sb = new StringBuilder(31);
            sb.append("Timing out request: ");
            sb.append(i2);
            Log.w("MessengerIpcClient", sb.toString());
            this.f3587e.remove(i2);
            pVar.b(new zzp(3, "Timed out waiting for response"));
            f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void c(int i2, @Nullable String str) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(str);
            Log.d("MessengerIpcClient", valueOf.length() != 0 ? "Disconnected: ".concat(valueOf) : new String("Disconnected: "));
        }
        int i3 = this.a;
        if (i3 == 0) {
            throw new IllegalStateException();
        }
        if (i3 != 1 && i3 != 2) {
            if (i3 == 3) {
                this.a = 4;
                return;
            } else if (i3 == 4) {
                return;
            } else {
                int i4 = this.a;
                StringBuilder sb = new StringBuilder(26);
                sb.append("Unknown state: ");
                sb.append(i4);
                throw new IllegalStateException(sb.toString());
            }
        }
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Unbinding service");
        }
        this.a = 4;
        ConnectionTracker.getInstance().b(e.b(this.f3588f), this);
        zzp zzpVar = new zzp(i2, str);
        for (p<?> pVar : this.f3586d) {
            pVar.b(zzpVar);
        }
        this.f3586d.clear();
        for (int i5 = 0; i5 < this.f3587e.size(); i5++) {
            this.f3587e.valueAt(i5).b(zzpVar);
        }
        this.f3587e.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean d(Message message) {
        int i2 = message.arg1;
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            StringBuilder sb = new StringBuilder(41);
            sb.append("Received response to request: ");
            sb.append(i2);
            Log.d("MessengerIpcClient", sb.toString());
        }
        synchronized (this) {
            p<?> pVar = this.f3587e.get(i2);
            if (pVar == null) {
                StringBuilder sb2 = new StringBuilder(50);
                sb2.append("Received response for unknown request: ");
                sb2.append(i2);
                Log.w("MessengerIpcClient", sb2.toString());
                return true;
            }
            this.f3587e.remove(i2);
            f();
            Bundle data = message.getData();
            if (data.getBoolean("unsupported", false)) {
                pVar.b(new zzp(4, "Not supported by GmsCore"));
            } else {
                pVar.a(data);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized boolean e(p<?> pVar) {
        int i2 = this.a;
        if (i2 == 0) {
            this.f3586d.add(pVar);
            com.google.android.gms.common.internal.q.m(this.a == 0);
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Starting bind to GmsCore");
            }
            this.a = 1;
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            if (!ConnectionTracker.getInstance().a(e.b(this.f3588f), intent, this, 1)) {
                c(0, "Unable to bind to service");
            } else {
                e.g(this.f3588f).schedule(new Runnable(this) { // from class: com.google.android.gms.cloudmessaging.h
                    private final f a;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.a = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.g();
                    }
                }, 30L, TimeUnit.SECONDS);
            }
            return true;
        } else if (i2 == 1) {
            this.f3586d.add(pVar);
            return true;
        } else if (i2 == 2) {
            this.f3586d.add(pVar);
            a();
            return true;
        } else {
            if (i2 != 3 && i2 != 4) {
                int i3 = this.a;
                StringBuilder sb = new StringBuilder(26);
                sb.append("Unknown state: ");
                sb.append(i3);
                throw new IllegalStateException(sb.toString());
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void f() {
        if (this.a == 2 && this.f3586d.isEmpty() && this.f3587e.size() == 0) {
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
            }
            this.a = 3;
            ConnectionTracker.getInstance().b(e.b(this.f3588f), this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void g() {
        if (this.a == 1) {
            c(1, "Timed out while binding");
        }
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public final void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service connected");
        }
        e.g(this.f3588f).execute(new Runnable(this, iBinder) { // from class: com.google.android.gms.cloudmessaging.k
            private final f a;
            private final IBinder b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.b = iBinder;
            }

            @Override // java.lang.Runnable
            public final void run() {
                f fVar = this.a;
                IBinder iBinder2 = this.b;
                synchronized (fVar) {
                    try {
                        if (iBinder2 == null) {
                            fVar.c(0, "Null service connection");
                            return;
                        }
                        try {
                            fVar.c = new o(iBinder2);
                            fVar.a = 2;
                            fVar.a();
                        } catch (RemoteException e2) {
                            fVar.c(0, e2.getMessage());
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        });
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service disconnected");
        }
        e.g(this.f3588f).execute(new Runnable(this) { // from class: com.google.android.gms.cloudmessaging.m
            private final f a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.c(2, "Service disconnected");
            }
        });
    }
}
