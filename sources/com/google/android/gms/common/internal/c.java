package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.BinderThread;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.internal.common.zzi;
import com.growingio.android.sdk.utils.NetworkUtil;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public abstract class c<T extends IInterface> {
    public static final int CONNECT_STATE_CONNECTED = 4;
    public static final int CONNECT_STATE_DISCONNECTED = 1;
    public static final int CONNECT_STATE_DISCONNECTING = 5;
    public static final String DEFAULT_ACCOUNT = "<<default account>>";
    public static final String KEY_PENDING_INTENT = "pendingIntent";
    final Handler zza;
    private ConnectionResult zzaa;
    private boolean zzab;
    private volatile zzc zzac;
    protected InterfaceC0137c zzb;
    protected AtomicInteger zzc;
    private int zze;
    private long zzf;
    private long zzg;
    private int zzh;
    private long zzi;
    @Nullable
    private volatile String zzj;
    private l0 zzk;
    private final Context zzl;
    private final Looper zzm;
    private final com.google.android.gms.common.internal.h zzn;
    private final GoogleApiAvailabilityLight zzo;
    private final Object zzp;
    private final Object zzq;
    @GuardedBy("mServiceBrokerLock")
    private n zzr;
    @GuardedBy("mLock")
    private T zzs;
    private final ArrayList<h<?>> zzt;
    @GuardedBy("mLock")
    private i zzu;
    @GuardedBy("mLock")
    private int zzv;
    @Nullable
    private final a zzw;
    @Nullable
    private final b zzx;
    private final int zzy;
    @Nullable
    private final String zzz;
    private static final Feature[] zzd = new Feature[0];
    public static final String[] GOOGLE_PLUS_REQUIRED_FEATURES = {"service_esmobile", "service_googleme"};

    /* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
    /* loaded from: classes2.dex */
    public interface a {
        void onConnected(@Nullable Bundle bundle);

        void onConnectionSuspended(int i2);
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
    /* loaded from: classes2.dex */
    public interface b {
        void onConnectionFailed(@NonNull ConnectionResult connectionResult);
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
    /* renamed from: com.google.android.gms.common.internal.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0137c {
        void a(@NonNull ConnectionResult connectionResult);
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
    /* loaded from: classes2.dex */
    protected class d implements InterfaceC0137c {
        public d() {
        }

        @Override // com.google.android.gms.common.internal.c.InterfaceC0137c
        public void a(@NonNull ConnectionResult connectionResult) {
            if (!connectionResult.U()) {
                if (c.this.zzx != null) {
                    c.this.zzx.onConnectionFailed(connectionResult);
                    return;
                }
                return;
            }
            c cVar = c.this;
            cVar.getRemoteService(null, cVar.getScopes());
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
    /* loaded from: classes2.dex */
    public interface e {
        void a();
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
    /* loaded from: classes2.dex */
    private abstract class f extends h<Boolean> {

        /* renamed from: d  reason: collision with root package name */
        private final int f3657d;

        /* renamed from: e  reason: collision with root package name */
        private final Bundle f3658e;

        @BinderThread
        protected f(int i2, Bundle bundle) {
            super(Boolean.TRUE);
            this.f3657d = i2;
            this.f3658e = bundle;
        }

        @Override // com.google.android.gms.common.internal.c.h
        protected final /* synthetic */ void a(Boolean bool) {
            if (bool != null) {
                int i2 = this.f3657d;
                if (i2 == 0) {
                    if (g()) {
                        return;
                    }
                    c.this.zza(1, (int) null);
                    f(new ConnectionResult(8, null));
                    return;
                } else if (i2 != 10) {
                    c.this.zza(1, (int) null);
                    Bundle bundle = this.f3658e;
                    f(new ConnectionResult(this.f3657d, bundle != null ? (PendingIntent) bundle.getParcelable(c.KEY_PENDING_INTENT) : null));
                    return;
                } else {
                    c.this.zza(1, (int) null);
                    throw new IllegalStateException(String.format("A fatal developer error has occurred. Class name: %s. Start service action: %s. Service Descriptor: %s. ", getClass().getSimpleName(), c.this.getStartServiceAction(), c.this.getServiceDescriptor()));
                }
            }
            c.this.zza(1, (int) null);
        }

        @Override // com.google.android.gms.common.internal.c.h
        protected final void b() {
        }

        protected abstract void f(ConnectionResult connectionResult);

        protected abstract boolean g();
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
    /* loaded from: classes2.dex */
    final class g extends zzi {
        public g(Looper looper) {
            super(looper);
        }

        private static void a(Message message) {
            h hVar = (h) message.obj;
            hVar.b();
            hVar.d();
        }

        private static boolean b(Message message) {
            int i2 = message.what;
            return i2 == 2 || i2 == 1 || i2 == 7;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            ConnectionResult connectionResult;
            ConnectionResult connectionResult2;
            if (c.this.zzc.get() != message.arg1) {
                if (b(message)) {
                    a(message);
                    return;
                }
                return;
            }
            int i2 = message.what;
            if ((i2 == 1 || i2 == 7 || ((i2 == 4 && !c.this.enableLocalFallback()) || message.what == 5)) && !c.this.isConnecting()) {
                a(message);
                return;
            }
            int i3 = message.what;
            if (i3 == 4) {
                c.this.zzaa = new ConnectionResult(message.arg2);
                if (!c.this.zzc() || c.this.zzab) {
                    if (c.this.zzaa != null) {
                        connectionResult2 = c.this.zzaa;
                    } else {
                        connectionResult2 = new ConnectionResult(8);
                    }
                    c.this.zzb.a(connectionResult2);
                    c.this.onConnectionFailed(connectionResult2);
                    return;
                }
                c.this.zza(3, (int) null);
            } else if (i3 == 5) {
                if (c.this.zzaa != null) {
                    connectionResult = c.this.zzaa;
                } else {
                    connectionResult = new ConnectionResult(8);
                }
                c.this.zzb.a(connectionResult);
                c.this.onConnectionFailed(connectionResult);
            } else if (i3 == 3) {
                Object obj = message.obj;
                ConnectionResult connectionResult3 = new ConnectionResult(message.arg2, obj instanceof PendingIntent ? (PendingIntent) obj : null);
                c.this.zzb.a(connectionResult3);
                c.this.onConnectionFailed(connectionResult3);
            } else if (i3 != 6) {
                if (i3 == 2 && !c.this.isConnected()) {
                    a(message);
                } else if (b(message)) {
                    ((h) message.obj).c();
                } else {
                    int i4 = message.what;
                    StringBuilder sb = new StringBuilder(45);
                    sb.append("Don't know how to handle message: ");
                    sb.append(i4);
                    Log.wtf("GmsClient", sb.toString(), new Exception());
                }
            } else {
                c.this.zza(5, (int) null);
                if (c.this.zzw != null) {
                    c.this.zzw.onConnectionSuspended(message.arg2);
                }
                c.this.onConnectionSuspended(message.arg2);
                c.this.zza(5, 1, (int) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
    /* loaded from: classes2.dex */
    public abstract class h<TListener> {
        private TListener a;
        private boolean b = false;

        public h(TListener tlistener) {
            this.a = tlistener;
        }

        protected abstract void a(TListener tlistener);

        protected abstract void b();

        public final void c() {
            TListener tlistener;
            synchronized (this) {
                tlistener = this.a;
                if (this.b) {
                    String valueOf = String.valueOf(this);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
                    sb.append("Callback proxy ");
                    sb.append(valueOf);
                    sb.append(" being reused. This is not safe.");
                    Log.w("GmsClient", sb.toString());
                }
            }
            if (tlistener != null) {
                try {
                    a(tlistener);
                } catch (RuntimeException e2) {
                    b();
                    throw e2;
                }
            } else {
                b();
            }
            synchronized (this) {
                this.b = true;
            }
            d();
        }

        public final void d() {
            e();
            synchronized (c.this.zzt) {
                c.this.zzt.remove(this);
            }
        }

        public final void e() {
            synchronized (this) {
                this.a = null;
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
    /* loaded from: classes2.dex */
    public final class i implements ServiceConnection {
        private final int a;

        public i(int i2) {
            this.a = i2;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            n mVar;
            if (iBinder == null) {
                c.this.zza(16);
                return;
            }
            synchronized (c.this.zzq) {
                c cVar = c.this;
                if (iBinder == null) {
                    mVar = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    if (queryLocalInterface != null && (queryLocalInterface instanceof n)) {
                        mVar = (n) queryLocalInterface;
                    } else {
                        mVar = new m(iBinder);
                    }
                }
                cVar.zzr = mVar;
            }
            c.this.zza(0, (Bundle) null, this.a);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            synchronized (c.this.zzq) {
                c.this.zzr = null;
            }
            Handler handler = c.this.zza;
            handler.sendMessage(handler.obtainMessage(6, this.a, 1));
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
    /* loaded from: classes2.dex */
    public static final class j extends l.a {
        private c a;
        private final int b;

        public j(@NonNull c cVar, int i2) {
            this.a = cVar;
            this.b = i2;
        }

        @Override // com.google.android.gms.common.internal.l
        @BinderThread
        public final void A(int i2, @NonNull IBinder iBinder, @NonNull zzc zzcVar) {
            q.k(this.a, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
            q.j(zzcVar);
            this.a.zza(zzcVar);
            u(i2, iBinder, zzcVar.a);
        }

        @Override // com.google.android.gms.common.internal.l
        @BinderThread
        public final void X(int i2, @Nullable Bundle bundle) {
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        }

        @Override // com.google.android.gms.common.internal.l
        @BinderThread
        public final void u(int i2, @NonNull IBinder iBinder, @Nullable Bundle bundle) {
            q.k(this.a, "onPostInitComplete can be called only once per call to getRemoteService");
            this.a.onPostInitHandler(i2, iBinder, bundle, this.b);
            this.a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
    /* loaded from: classes2.dex */
    public final class k extends f {

        /* renamed from: g  reason: collision with root package name */
        private final IBinder f3660g;

        @BinderThread
        public k(int i2, IBinder iBinder, Bundle bundle) {
            super(i2, bundle);
            this.f3660g = iBinder;
        }

        @Override // com.google.android.gms.common.internal.c.f
        protected final void f(ConnectionResult connectionResult) {
            if (c.this.zzx != null) {
                c.this.zzx.onConnectionFailed(connectionResult);
            }
            c.this.onConnectionFailed(connectionResult);
        }

        @Override // com.google.android.gms.common.internal.c.f
        protected final boolean g() {
            try {
                String interfaceDescriptor = this.f3660g.getInterfaceDescriptor();
                if (!c.this.getServiceDescriptor().equals(interfaceDescriptor)) {
                    String serviceDescriptor = c.this.getServiceDescriptor();
                    StringBuilder sb = new StringBuilder(String.valueOf(serviceDescriptor).length() + 34 + String.valueOf(interfaceDescriptor).length());
                    sb.append("service descriptor mismatch: ");
                    sb.append(serviceDescriptor);
                    sb.append(" vs. ");
                    sb.append(interfaceDescriptor);
                    Log.e("GmsClient", sb.toString());
                    return false;
                }
                IInterface createServiceInterface = c.this.createServiceInterface(this.f3660g);
                if (createServiceInterface == null || !(c.this.zza(2, 4, (int) createServiceInterface) || c.this.zza(3, 4, (int) createServiceInterface))) {
                    return false;
                }
                c.this.zzaa = null;
                Bundle connectionHint = c.this.getConnectionHint();
                if (c.this.zzw != null) {
                    c.this.zzw.onConnected(connectionHint);
                    return true;
                }
                return true;
            } catch (RemoteException unused) {
                Log.w("GmsClient", "service probably died");
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
    /* loaded from: classes2.dex */
    public final class l extends f {
        @BinderThread
        public l(int i2, @Nullable Bundle bundle) {
            super(i2, null);
        }

        @Override // com.google.android.gms.common.internal.c.f
        protected final void f(ConnectionResult connectionResult) {
            if (!c.this.enableLocalFallback() || !c.this.zzc()) {
                c.this.zzb.a(connectionResult);
                c.this.onConnectionFailed(connectionResult);
                return;
            }
            c.this.zza(16);
        }

        @Override // com.google.android.gms.common.internal.c.f
        protected final boolean g() {
            c.this.zzb.a(ConnectionResult.RESULT_SUCCESS);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public c(android.content.Context r10, android.os.Looper r11, int r12, com.google.android.gms.common.internal.c.a r13, com.google.android.gms.common.internal.c.b r14, java.lang.String r15) {
        /*
            r9 = this;
            com.google.android.gms.common.internal.h r3 = com.google.android.gms.common.internal.h.b(r10)
            com.google.android.gms.common.GoogleApiAvailabilityLight r4 = com.google.android.gms.common.GoogleApiAvailabilityLight.getInstance()
            com.google.android.gms.common.internal.q.j(r13)
            r6 = r13
            com.google.android.gms.common.internal.c$a r6 = (com.google.android.gms.common.internal.c.a) r6
            com.google.android.gms.common.internal.q.j(r14)
            r7 = r14
            com.google.android.gms.common.internal.c$b r7 = (com.google.android.gms.common.internal.c.b) r7
            r0 = r9
            r1 = r10
            r2 = r11
            r5 = r12
            r8 = r15
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.c.<init>(android.content.Context, android.os.Looper, int, com.google.android.gms.common.internal.c$a, com.google.android.gms.common.internal.c$b, java.lang.String):void");
    }

    @Nullable
    private final String zza() {
        String str = this.zzz;
        return str == null ? this.zzl.getClass().getName() : str;
    }

    private final boolean zzb() {
        boolean z;
        synchronized (this.zzp) {
            z = this.zzv == 3;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zzc() {
        if (this.zzab || TextUtils.isEmpty(getServiceDescriptor()) || TextUtils.isEmpty(getLocalStartServiceAction())) {
            return false;
        }
        try {
            Class.forName(getServiceDescriptor());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public void checkAvailabilityAndConnect() {
        int g2 = this.zzo.g(this.zzl, getMinApkVersion());
        if (g2 != 0) {
            zza(1, (int) null);
            triggerNotAvailable(new d(), g2, null);
            return;
        }
        connect(new d());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void checkConnected() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public void connect(@NonNull InterfaceC0137c interfaceC0137c) {
        q.k(interfaceC0137c, "Connection progress callbacks cannot be null.");
        this.zzb = interfaceC0137c;
        zza(2, (int) null);
    }

    @Nullable
    protected abstract T createServiceInterface(IBinder iBinder);

    public void disconnect(String str) {
        this.zzj = str;
        disconnect();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i2;
        T t;
        n nVar;
        synchronized (this.zzp) {
            i2 = this.zzv;
            t = this.zzs;
        }
        synchronized (this.zzq) {
            nVar = this.zzr;
        }
        printWriter.append((CharSequence) str).append("mConnectState=");
        if (i2 == 1) {
            printWriter.print("DISCONNECTED");
        } else if (i2 == 2) {
            printWriter.print("REMOTE_CONNECTING");
        } else if (i2 == 3) {
            printWriter.print("LOCAL_CONNECTING");
        } else if (i2 == 4) {
            printWriter.print("CONNECTED");
        } else if (i2 != 5) {
            printWriter.print(NetworkUtil.NETWORK_UNKNOWN);
        } else {
            printWriter.print("DISCONNECTING");
        }
        printWriter.append(" mService=");
        if (t == null) {
            printWriter.append("null");
        } else {
            printWriter.append((CharSequence) getServiceDescriptor()).append("@").append((CharSequence) Integer.toHexString(System.identityHashCode(t.asBinder())));
        }
        printWriter.append(" mServiceBroker=");
        if (nVar == null) {
            printWriter.println("null");
        } else {
            printWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(nVar.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.zzg > 0) {
            PrintWriter append = printWriter.append((CharSequence) str).append("lastConnectedTime=");
            long j2 = this.zzg;
            String format = simpleDateFormat.format(new Date(this.zzg));
            StringBuilder sb = new StringBuilder(String.valueOf(format).length() + 21);
            sb.append(j2);
            sb.append(" ");
            sb.append(format);
            append.println(sb.toString());
        }
        if (this.zzf > 0) {
            printWriter.append((CharSequence) str).append("lastSuspendedCause=");
            int i3 = this.zze;
            if (i3 == 1) {
                printWriter.append("CAUSE_SERVICE_DISCONNECTED");
            } else if (i3 == 2) {
                printWriter.append("CAUSE_NETWORK_LOST");
            } else if (i3 != 3) {
                printWriter.append((CharSequence) String.valueOf(i3));
            } else {
                printWriter.append("CAUSE_DEAD_OBJECT_EXCEPTION");
            }
            PrintWriter append2 = printWriter.append(" lastSuspendedTime=");
            long j3 = this.zzf;
            String format2 = simpleDateFormat.format(new Date(this.zzf));
            StringBuilder sb2 = new StringBuilder(String.valueOf(format2).length() + 21);
            sb2.append(j3);
            sb2.append(" ");
            sb2.append(format2);
            append2.println(sb2.toString());
        }
        if (this.zzi > 0) {
            printWriter.append((CharSequence) str).append("lastFailedStatus=").append((CharSequence) com.google.android.gms.common.api.b.a(this.zzh));
            PrintWriter append3 = printWriter.append(" lastFailedTime=");
            long j4 = this.zzi;
            String format3 = simpleDateFormat.format(new Date(this.zzi));
            StringBuilder sb3 = new StringBuilder(String.valueOf(format3).length() + 21);
            sb3.append(j4);
            sb3.append(" ");
            sb3.append(format3);
            append3.println(sb3.toString());
        }
    }

    protected boolean enableLocalFallback() {
        return false;
    }

    @Nullable
    public Account getAccount() {
        return null;
    }

    public Feature[] getApiFeatures() {
        return zzd;
    }

    @Nullable
    public final Feature[] getAvailableFeatures() {
        zzc zzcVar = this.zzac;
        if (zzcVar == null) {
            return null;
        }
        return zzcVar.b;
    }

    public Bundle getConnectionHint() {
        return null;
    }

    public final Context getContext() {
        return this.zzl;
    }

    public String getEndpointPackageName() {
        l0 l0Var;
        if (isConnected() && (l0Var = this.zzk) != null) {
            return l0Var.b();
        }
        throw new RuntimeException("Failed to connect when checking package");
    }

    protected Bundle getGetServiceRequestExtraArgs() {
        return new Bundle();
    }

    @Nullable
    public String getLastDisconnectMessage() {
        return this.zzj;
    }

    @Nullable
    protected String getLocalStartServiceAction() {
        return null;
    }

    public final Looper getLooper() {
        return this.zzm;
    }

    public int getMinApkVersion() {
        return GoogleApiAvailabilityLight.a;
    }

    @WorkerThread
    public void getRemoteService(com.google.android.gms.common.internal.j jVar, Set<Scope> set) {
        Bundle getServiceRequestExtraArgs = getGetServiceRequestExtraArgs();
        GetServiceRequest getServiceRequest = new GetServiceRequest(this.zzy);
        getServiceRequest.a = this.zzl.getPackageName();
        getServiceRequest.f3653d = getServiceRequestExtraArgs;
        if (set != null) {
            getServiceRequest.c = (Scope[]) set.toArray(new Scope[set.size()]);
        }
        if (requiresSignIn()) {
            getServiceRequest.f3654e = getAccount() != null ? getAccount() : new Account(DEFAULT_ACCOUNT, "com.google");
            if (jVar != null) {
                getServiceRequest.b = jVar.asBinder();
            }
        } else if (requiresAccount()) {
            getServiceRequest.f3654e = getAccount();
        }
        getServiceRequest.f3655f = zzd;
        getServiceRequest.f3656g = getApiFeatures();
        try {
            synchronized (this.zzq) {
                n nVar = this.zzr;
                if (nVar != null) {
                    nVar.M(new j(this, this.zzc.get()), getServiceRequest);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e2) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e2);
            triggerConnectionSuspended(3);
        } catch (RemoteException e3) {
            e = e3;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            onPostInitHandler(8, null, null, this.zzc.get());
        } catch (SecurityException e4) {
            throw e4;
        } catch (RuntimeException e5) {
            e = e5;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            onPostInitHandler(8, null, null, this.zzc.get());
        }
    }

    protected Set<Scope> getScopes() {
        return Collections.emptySet();
    }

    public final T getService() throws DeadObjectException {
        T t;
        synchronized (this.zzp) {
            if (this.zzv != 5) {
                checkConnected();
                q.n(this.zzs != null, "Client is connected but service is null");
                t = this.zzs;
            } else {
                throw new DeadObjectException();
            }
        }
        return t;
    }

    @Nullable
    public IBinder getServiceBrokerBinder() {
        synchronized (this.zzq) {
            n nVar = this.zzr;
            if (nVar == null) {
                return null;
            }
            return nVar.asBinder();
        }
    }

    @NonNull
    protected abstract String getServiceDescriptor();

    public Intent getSignInIntent() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    @NonNull
    protected abstract String getStartServiceAction();

    protected String getStartServicePackage() {
        return "com.google.android.gms";
    }

    protected boolean getUseDynamicLookup() {
        return false;
    }

    public boolean isConnected() {
        boolean z;
        synchronized (this.zzp) {
            z = this.zzv == 4;
        }
        return z;
    }

    public boolean isConnecting() {
        boolean z;
        synchronized (this.zzp) {
            int i2 = this.zzv;
            z = i2 == 2 || i2 == 3;
        }
        return z;
    }

    @CallSuper
    protected void onConnectedLocked(@NonNull T t) {
        this.zzg = System.currentTimeMillis();
    }

    @CallSuper
    protected void onConnectionFailed(ConnectionResult connectionResult) {
        this.zzh = connectionResult.Q();
        this.zzi = System.currentTimeMillis();
    }

    @CallSuper
    protected void onConnectionSuspended(int i2) {
        this.zze = i2;
        this.zzf = System.currentTimeMillis();
    }

    protected void onPostInitHandler(int i2, IBinder iBinder, Bundle bundle, int i3) {
        Handler handler = this.zza;
        handler.sendMessage(handler.obtainMessage(1, i3, -1, new k(i2, iBinder, bundle)));
    }

    void onSetConnectState(int i2, T t) {
    }

    public void onUserSignOut(@NonNull e eVar) {
        eVar.a();
    }

    public boolean providesSignIn() {
        return false;
    }

    public boolean requiresAccount() {
        return false;
    }

    public boolean requiresGooglePlayServices() {
        return true;
    }

    public boolean requiresSignIn() {
        return false;
    }

    public void triggerConnectionSuspended(int i2) {
        Handler handler = this.zza;
        handler.sendMessage(handler.obtainMessage(6, this.zzc.get(), i2));
    }

    protected void triggerNotAvailable(@NonNull InterfaceC0137c interfaceC0137c, int i2, @Nullable PendingIntent pendingIntent) {
        q.k(interfaceC0137c, "Connection progress callbacks cannot be null.");
        this.zzb = interfaceC0137c;
        Handler handler = this.zza;
        handler.sendMessage(handler.obtainMessage(3, this.zzc.get(), i2, pendingIntent));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzc zzcVar) {
        this.zzac = zzcVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(int i2, T t) {
        l0 l0Var;
        l0 l0Var2;
        q.a((i2 == 4) == (t != null));
        synchronized (this.zzp) {
            this.zzv = i2;
            this.zzs = t;
            onSetConnectState(i2, t);
            if (i2 != 1) {
                if (i2 == 2 || i2 == 3) {
                    if (this.zzu != null && (l0Var2 = this.zzk) != null) {
                        String a2 = l0Var2.a();
                        String b2 = this.zzk.b();
                        StringBuilder sb = new StringBuilder(String.valueOf(a2).length() + 70 + String.valueOf(b2).length());
                        sb.append("Calling connect() while still connected, missing disconnect() for ");
                        sb.append(a2);
                        sb.append(" on ");
                        sb.append(b2);
                        Log.e("GmsClient", sb.toString());
                        this.zzn.c(this.zzk.a(), this.zzk.b(), this.zzk.c(), this.zzu, zza(), this.zzk.d());
                        this.zzc.incrementAndGet();
                    }
                    this.zzu = new i(this.zzc.get());
                    if (this.zzv == 3 && getLocalStartServiceAction() != null) {
                        l0Var = new l0(getContext().getPackageName(), getLocalStartServiceAction(), true, com.google.android.gms.common.internal.h.a(), false);
                    } else {
                        l0Var = new l0(getStartServicePackage(), getStartServiceAction(), false, com.google.android.gms.common.internal.h.a(), getUseDynamicLookup());
                    }
                    this.zzk = l0Var;
                    if (l0Var.d() && getMinApkVersion() < 17895000) {
                        String valueOf = String.valueOf(this.zzk.a());
                        throw new IllegalStateException(valueOf.length() != 0 ? "Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(valueOf) : new String("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: "));
                    }
                    if (!this.zzn.d(new h.a(this.zzk.a(), this.zzk.b(), this.zzk.c(), this.zzk.d()), this.zzu, zza())) {
                        String a3 = this.zzk.a();
                        String b3 = this.zzk.b();
                        StringBuilder sb2 = new StringBuilder(String.valueOf(a3).length() + 34 + String.valueOf(b3).length());
                        sb2.append("unable to connect to service: ");
                        sb2.append(a3);
                        sb2.append(" on ");
                        sb2.append(b3);
                        Log.e("GmsClient", sb2.toString());
                        zza(16, (Bundle) null, this.zzc.get());
                    }
                } else if (i2 == 4) {
                    onConnectedLocked(t);
                }
            } else if (this.zzu != null) {
                this.zzn.c(this.zzk.a(), this.zzk.b(), this.zzk.c(), this.zzu, zza(), this.zzk.d());
                this.zzu = null;
            }
        }
    }

    public void disconnect() {
        this.zzc.incrementAndGet();
        synchronized (this.zzt) {
            int size = this.zzt.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.zzt.get(i2).e();
            }
            this.zzt.clear();
        }
        synchronized (this.zzq) {
            this.zzr = null;
        }
        zza(1, (int) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context, Looper looper, com.google.android.gms.common.internal.h hVar, GoogleApiAvailabilityLight googleApiAvailabilityLight, int i2, @Nullable a aVar, @Nullable b bVar, @Nullable String str) {
        this.zzj = null;
        this.zzp = new Object();
        this.zzq = new Object();
        this.zzt = new ArrayList<>();
        this.zzv = 1;
        this.zzaa = null;
        this.zzab = false;
        this.zzac = null;
        this.zzc = new AtomicInteger(0);
        q.k(context, "Context must not be null");
        this.zzl = context;
        q.k(looper, "Looper must not be null");
        this.zzm = looper;
        q.k(hVar, "Supervisor must not be null");
        this.zzn = hVar;
        q.k(googleApiAvailabilityLight, "API availability must not be null");
        this.zzo = googleApiAvailabilityLight;
        this.zza = new g(looper);
        this.zzy = i2;
        this.zzw = aVar;
        this.zzx = bVar;
        this.zzz = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context, Handler handler, com.google.android.gms.common.internal.h hVar, GoogleApiAvailabilityLight googleApiAvailabilityLight, int i2, @Nullable a aVar, @Nullable b bVar) {
        this.zzj = null;
        this.zzp = new Object();
        this.zzq = new Object();
        this.zzt = new ArrayList<>();
        this.zzv = 1;
        this.zzaa = null;
        this.zzab = false;
        this.zzac = null;
        this.zzc = new AtomicInteger(0);
        q.k(context, "Context must not be null");
        this.zzl = context;
        q.k(handler, "Handler must not be null");
        this.zza = handler;
        this.zzm = handler.getLooper();
        q.k(hVar, "Supervisor must not be null");
        this.zzn = hVar;
        q.k(googleApiAvailabilityLight, "API availability must not be null");
        this.zzo = googleApiAvailabilityLight;
        this.zzy = i2;
        this.zzw = aVar;
        this.zzx = bVar;
        this.zzz = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zza(int i2, int i3, T t) {
        synchronized (this.zzp) {
            if (this.zzv != i2) {
                return false;
            }
            zza(i3, (int) t);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(int i2) {
        int i3;
        if (zzb()) {
            i3 = 5;
            this.zzab = true;
        } else {
            i3 = 4;
        }
        Handler handler = this.zza;
        handler.sendMessage(handler.obtainMessage(i3, this.zzc.get(), 16));
    }

    protected final void zza(int i2, @Nullable Bundle bundle, int i3) {
        Handler handler = this.zza;
        handler.sendMessage(handler.obtainMessage(7, i3, -1, new l(i2, null)));
    }
}
