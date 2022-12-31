package com.google.android.play.core.assetpacks;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.concurrent.Executor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class e0 extends d.c.a.d.a.a.c<AssetPackState> {

    /* renamed from: g  reason: collision with root package name */
    private final w1 f4718g;

    /* renamed from: h  reason: collision with root package name */
    private final c1 f4719h;

    /* renamed from: i  reason: collision with root package name */
    private final com.google.android.play.core.internal.k1<x3> f4720i;

    /* renamed from: j  reason: collision with root package name */
    private final u0 f4721j;

    /* renamed from: k  reason: collision with root package name */
    private final f1 f4722k;

    /* renamed from: l  reason: collision with root package name */
    private final com.google.android.play.core.common.b f4723l;
    private final com.google.android.play.core.internal.k1<Executor> m;
    private final com.google.android.play.core.internal.k1<Executor> n;
    private final Handler o;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e0(Context context, w1 w1Var, c1 c1Var, com.google.android.play.core.internal.k1<x3> k1Var, f1 f1Var, u0 u0Var, com.google.android.play.core.common.b bVar, com.google.android.play.core.internal.k1<Executor> k1Var2, com.google.android.play.core.internal.k1<Executor> k1Var3) {
        super(new com.google.android.play.core.internal.j("AssetPackServiceListenerRegistry"), new IntentFilter("com.google.android.play.core.assetpacks.receiver.ACTION_SESSION_UPDATE"), context);
        this.o = new Handler(Looper.getMainLooper());
        this.f4718g = w1Var;
        this.f4719h = c1Var;
        this.f4720i = k1Var;
        this.f4722k = f1Var;
        this.f4721j = u0Var;
        this.f4723l = bVar;
        this.m = k1Var2;
        this.n = k1Var3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // d.c.a.d.a.a.c
    public final void a(Context context, Intent intent) {
        final Bundle bundleExtra = intent.getBundleExtra("com.google.android.play.core.assetpacks.receiver.EXTRA_SESSION_STATE");
        if (bundleExtra == null) {
            this.a.e("Empty bundle received from broadcast.", new Object[0]);
            return;
        }
        ArrayList<String> stringArrayList = bundleExtra.getStringArrayList("pack_names");
        if (stringArrayList == null || stringArrayList.size() != 1) {
            this.a.e("Corrupt bundle received from broadcast.", new Object[0]);
            return;
        }
        Bundle bundleExtra2 = intent.getBundleExtra("com.google.android.play.core.FLAGS");
        if (bundleExtra2 != null) {
            this.f4723l.a(bundleExtra2);
        }
        final AssetPackState a = AssetPackState.a(bundleExtra, stringArrayList.get(0), this.f4722k, g0.a);
        this.a.c("ListenerRegistryBroadcastReceiver.onReceive: %s", a);
        PendingIntent pendingIntent = (PendingIntent) bundleExtra.getParcelable("confirmation_intent");
        if (pendingIntent != null) {
            this.f4721j.b(pendingIntent);
        }
        this.n.a().execute(new Runnable(this, bundleExtra, a) { // from class: com.google.android.play.core.assetpacks.c0
            private final e0 a;
            private final Bundle b;
            private final AssetPackState c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.b = bundleExtra;
                this.c = a;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.i(this.b, this.c);
            }
        });
        this.m.a().execute(new Runnable(this, bundleExtra) { // from class: com.google.android.play.core.assetpacks.d0
            private final e0 a;
            private final Bundle b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.b = bundleExtra;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.h(this.b);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void h(Bundle bundle) {
        if (this.f4718g.f(bundle)) {
            this.f4719h.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void i(Bundle bundle, AssetPackState assetPackState) {
        if (this.f4718g.k(bundle)) {
            j(assetPackState);
            this.f4720i.a().a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void j(final AssetPackState assetPackState) {
        this.o.post(new Runnable(this, assetPackState) { // from class: com.google.android.play.core.assetpacks.b0
            private final e0 a;
            private final AssetPackState b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.b = assetPackState;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.c(this.b);
            }
        });
    }
}
