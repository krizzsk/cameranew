package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
/* loaded from: classes2.dex */
public final class k0 extends d.c.a.d.a.a.c<d> {
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private static k0 f4884i;

    /* renamed from: g  reason: collision with root package name */
    private final Handler f4885g;

    /* renamed from: h  reason: collision with root package name */
    private final w f4886h;

    public k0(Context context, w wVar) {
        super(new com.google.android.play.core.internal.j("SplitInstallListenerRegistry"), new IntentFilter("com.google.android.play.core.splitinstall.receiver.SplitInstallUpdateIntentService"), context);
        this.f4885g = new Handler(Looper.getMainLooper());
        this.f4886h = wVar;
    }

    public static synchronized k0 i(Context context) {
        k0 k0Var;
        synchronized (k0.class) {
            if (f4884i == null) {
                f4884i = new k0(context, l.a);
            }
            k0Var = f4884i;
        }
        return k0Var;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // d.c.a.d.a.a.c
    public final void a(Context context, Intent intent) {
        Bundle bundleExtra = intent.getBundleExtra("session_state");
        if (bundleExtra == null) {
            return;
        }
        d a = d.a(bundleExtra);
        this.a.c("ListenerRegistryBroadcastReceiver.onReceive: %s", a);
        x a2 = this.f4886h.a();
        if (a.m() != 3 || a2 == null) {
            c(a);
        } else {
            a2.a(a.e(), new i0(this, a, intent, context));
        }
    }
}
