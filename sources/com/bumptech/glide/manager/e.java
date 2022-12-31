package com.bumptech.glide.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.bumptech.glide.manager.c;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* compiled from: DefaultConnectivityMonitor.java */
/* loaded from: classes.dex */
class e implements c {
    private final Context a;
    private final c.a b;
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f819d;

    /* renamed from: e  reason: collision with root package name */
    private final BroadcastReceiver f820e = new a();

    /* compiled from: DefaultConnectivityMonitor.java */
    /* loaded from: classes.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            VdsAgent.onBroadcastReceiver(this, context, intent);
            boolean z = e.this.c;
            e eVar = e.this;
            eVar.c = eVar.l(context);
            if (z != e.this.c) {
                e.this.b.a(e.this.c);
            }
        }
    }

    public e(Context context, c.a aVar) {
        this.a = context.getApplicationContext();
        this.b = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private void m() {
        if (this.f819d) {
            return;
        }
        this.c = l(this.a);
        this.a.registerReceiver(this.f820e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.f819d = true;
    }

    private void n() {
        if (this.f819d) {
            this.a.unregisterReceiver(this.f820e);
            this.f819d = false;
        }
    }

    @Override // com.bumptech.glide.manager.h
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.manager.h
    public void onStart() {
        m();
    }

    @Override // com.bumptech.glide.manager.h
    public void onStop() {
        n();
    }
}
