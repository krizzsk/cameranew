package com.facebook.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
/* compiled from: PlatformServiceClient.java */
/* loaded from: classes.dex */
public abstract class u implements ServiceConnection {
    private final Context a;
    private final Handler b;
    private b c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f3086d;

    /* renamed from: e  reason: collision with root package name */
    private Messenger f3087e;

    /* renamed from: f  reason: collision with root package name */
    private int f3088f;

    /* renamed from: g  reason: collision with root package name */
    private int f3089g;

    /* renamed from: h  reason: collision with root package name */
    private final String f3090h;

    /* renamed from: i  reason: collision with root package name */
    private final int f3091i;

    /* compiled from: PlatformServiceClient.java */
    /* loaded from: classes.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (com.facebook.internal.instrument.e.a.c(this)) {
                return;
            }
            try {
                u.this.c(message);
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, this);
            }
        }
    }

    /* compiled from: PlatformServiceClient.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(Bundle bundle);
    }

    public u(Context context, int i2, int i3, int i4, String str) {
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext != null ? applicationContext : context;
        this.f3088f = i2;
        this.f3089g = i3;
        this.f3090h = str;
        this.f3091i = i4;
        this.b = new a();
    }

    private void a(Bundle bundle) {
        if (this.f3086d) {
            this.f3086d = false;
            b bVar = this.c;
            if (bVar != null) {
                bVar.a(bundle);
            }
        }
    }

    private void e() {
        Bundle bundle = new Bundle();
        bundle.putString("com.facebook.platform.extra.APPLICATION_ID", this.f3090h);
        d(bundle);
        Message obtain = Message.obtain((Handler) null, this.f3088f);
        obtain.arg1 = this.f3091i;
        obtain.setData(bundle);
        obtain.replyTo = new Messenger(this.b);
        try {
            this.f3087e.send(obtain);
        } catch (RemoteException unused) {
            a(null);
        }
    }

    public void b() {
        this.f3086d = false;
    }

    protected void c(Message message) {
        if (message.what == this.f3089g) {
            Bundle data = message.getData();
            if (data.getString("com.facebook.platform.status.ERROR_TYPE") != null) {
                a(null);
            } else {
                a(data);
            }
            try {
                this.a.unbindService(this);
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    protected abstract void d(Bundle bundle);

    public void f(b bVar) {
        this.c = bVar;
    }

    public boolean g() {
        Intent m;
        if (this.f3086d || t.w(this.f3091i) == -1 || (m = t.m(this.a)) == null) {
            return false;
        }
        this.f3086d = true;
        this.a.bindService(m, this, 1);
        return true;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f3087e = new Messenger(iBinder);
        e();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f3087e = null;
        try {
            this.a.unbindService(this);
        } catch (IllegalArgumentException unused) {
        }
        a(null);
    }
}
