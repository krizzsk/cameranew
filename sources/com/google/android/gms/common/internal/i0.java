package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.HashMap;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public final class i0 implements ServiceConnection, k0 {
    private final Map<ServiceConnection, ServiceConnection> a = new HashMap();
    private int b = 2;
    private boolean c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private IBinder f3684d;

    /* renamed from: e  reason: collision with root package name */
    private final h.a f3685e;

    /* renamed from: f  reason: collision with root package name */
    private ComponentName f3686f;

    /* renamed from: g  reason: collision with root package name */
    private final /* synthetic */ g0 f3687g;

    public i0(g0 g0Var, h.a aVar) {
        this.f3687g = g0Var;
        this.f3685e = aVar;
    }

    public final void a(ServiceConnection serviceConnection, ServiceConnection serviceConnection2, String str) {
        this.a.put(serviceConnection, serviceConnection2);
    }

    public final void b(ServiceConnection serviceConnection, String str) {
        this.a.remove(serviceConnection);
    }

    public final void c(String str) {
        ConnectionTracker connectionTracker;
        Context context;
        Context context2;
        ConnectionTracker connectionTracker2;
        Context context3;
        Handler handler;
        Handler handler2;
        long j2;
        this.b = 3;
        connectionTracker = this.f3687g.f3678g;
        context = this.f3687g.f3676e;
        h.a aVar = this.f3685e;
        context2 = this.f3687g.f3676e;
        boolean e2 = connectionTracker.e(context, str, aVar.a(context2), this, this.f3685e.e());
        this.c = e2;
        if (e2) {
            handler = this.f3687g.f3677f;
            Message obtainMessage = handler.obtainMessage(1, this.f3685e);
            handler2 = this.f3687g.f3677f;
            j2 = this.f3687g.f3680i;
            handler2.sendMessageDelayed(obtainMessage, j2);
            return;
        }
        this.b = 2;
        try {
            connectionTracker2 = this.f3687g.f3678g;
            context3 = this.f3687g.f3676e;
            connectionTracker2.b(context3, this);
        } catch (IllegalArgumentException unused) {
        }
    }

    public final boolean d() {
        return this.c;
    }

    public final boolean e(ServiceConnection serviceConnection) {
        return this.a.containsKey(serviceConnection);
    }

    public final int f() {
        return this.b;
    }

    public final void g(String str) {
        Handler handler;
        ConnectionTracker connectionTracker;
        Context context;
        handler = this.f3687g.f3677f;
        handler.removeMessages(1, this.f3685e);
        connectionTracker = this.f3687g.f3678g;
        context = this.f3687g.f3676e;
        connectionTracker.b(context, this);
        this.c = false;
        this.b = 2;
    }

    public final boolean h() {
        return this.a.isEmpty();
    }

    @Nullable
    public final IBinder i() {
        return this.f3684d;
    }

    public final ComponentName j() {
        return this.f3686f;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        HashMap hashMap;
        Handler handler;
        hashMap = this.f3687g.f3675d;
        synchronized (hashMap) {
            handler = this.f3687g.f3677f;
            handler.removeMessages(1, this.f3685e);
            this.f3684d = iBinder;
            this.f3686f = componentName;
            for (ServiceConnection serviceConnection : this.a.values()) {
                serviceConnection.onServiceConnected(componentName, iBinder);
            }
            this.b = 1;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        HashMap hashMap;
        Handler handler;
        hashMap = this.f3687g.f3675d;
        synchronized (hashMap) {
            handler = this.f3687g.f3677f;
            handler.removeMessages(1, this.f3685e);
            this.f3684d = null;
            this.f3686f = componentName;
            for (ServiceConnection serviceConnection : this.a.values()) {
                serviceConnection.onServiceDisconnected(componentName);
            }
            this.b = 2;
        }
    }
}
