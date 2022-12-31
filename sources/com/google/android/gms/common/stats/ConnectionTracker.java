package com.google.android.gms.common.stats;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import com.google.android.gms.common.internal.k0;
import com.google.android.gms.common.util.e;
import com.google.android.gms.internal.common.zzn;
import com.google.android.gms.internal.common.zzo;
import java.util.concurrent.ConcurrentHashMap;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public class ConnectionTracker {
    private static volatile ConnectionTracker c;
    private ConcurrentHashMap<ServiceConnection, ServiceConnection> a = new ConcurrentHashMap<>();
    private static final Object b = new Object();

    /* renamed from: d  reason: collision with root package name */
    private static zzo<Boolean> f3695d = zzn.zza(c.a);

    private ConnectionTracker() {
    }

    @SuppressLint({"UntrackedBindService"})
    private static void c(Context context, ServiceConnection serviceConnection) {
        try {
            context.unbindService(serviceConnection);
        } catch (IllegalArgumentException | IllegalStateException e2) {
            Log.w("ConnectionTracker", "Exception thrown while unbinding", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ boolean d() {
        return false;
    }

    @SuppressLint({"UntrackedBindService"})
    private final boolean f(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i2, boolean z) {
        ComponentName component = intent.getComponent();
        if (component == null ? false : e.b(context, component.getPackageName())) {
            Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
            return false;
        } else if (g(serviceConnection)) {
            ServiceConnection putIfAbsent = this.a.putIfAbsent(serviceConnection, serviceConnection);
            if (putIfAbsent != null && serviceConnection != putIfAbsent) {
                Log.w("ConnectionTracker", String.format("Duplicate binding with the same ServiceConnection: %s, %s, %s.", serviceConnection, str, intent.getAction()));
            }
            try {
                boolean bindService = context.bindService(intent, serviceConnection, i2);
                return !bindService ? bindService : bindService;
            } finally {
                this.a.remove(serviceConnection, serviceConnection);
            }
        } else {
            return context.bindService(intent, serviceConnection, i2);
        }
    }

    private static boolean g(ServiceConnection serviceConnection) {
        return f3695d.zza().booleanValue() && !(serviceConnection instanceof k0);
    }

    public static ConnectionTracker getInstance() {
        if (c == null) {
            synchronized (b) {
                if (c == null) {
                    c = new ConnectionTracker();
                }
            }
        }
        return c;
    }

    public boolean a(Context context, Intent intent, ServiceConnection serviceConnection, int i2) {
        return e(context, context.getClass().getName(), intent, serviceConnection, i2);
    }

    @SuppressLint({"UntrackedBindService"})
    public void b(Context context, ServiceConnection serviceConnection) {
        if (g(serviceConnection) && this.a.containsKey(serviceConnection)) {
            try {
                c(context, this.a.get(serviceConnection));
                return;
            } finally {
                this.a.remove(serviceConnection);
            }
        }
        c(context, serviceConnection);
    }

    public final boolean e(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i2) {
        return f(context, str, intent, serviceConnection, i2, true);
    }
}
