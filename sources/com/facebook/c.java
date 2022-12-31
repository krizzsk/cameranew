package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.internal.x;
import com.facebook.internal.y;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* compiled from: AccessTokenTracker.java */
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: d  reason: collision with root package name */
    private static final String f2355d = "c";
    private final BroadcastReceiver a;
    private final LocalBroadcastManager b;
    private boolean c = false;

    /* compiled from: AccessTokenTracker.java */
    /* loaded from: classes.dex */
    private class b extends BroadcastReceiver {
        private b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            VdsAgent.onBroadcastReceiver(this, context, intent);
            if ("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED".equals(intent.getAction())) {
                x.Y(c.f2355d, "AccessTokenChanged");
                c.this.c((AccessToken) intent.getParcelableExtra("com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN"), (AccessToken) intent.getParcelableExtra("com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN"));
            }
        }
    }

    public c() {
        y.n();
        this.a = new b();
        this.b = LocalBroadcastManager.getInstance(f.f());
        d();
    }

    private void b() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED");
        this.b.registerReceiver(this.a, intentFilter);
    }

    protected abstract void c(AccessToken accessToken, AccessToken accessToken2);

    public void d() {
        if (this.c) {
            return;
        }
        b();
        this.c = true;
    }
}
