package com.google.android.play.core.assetpacks;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.tapjoy.TapjoyConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class k3 implements b {

    /* renamed from: k  reason: collision with root package name */
    private static final com.google.android.play.core.internal.j f4755k = new com.google.android.play.core.internal.j("AssetPackManager");
    private final k0 a;
    private final com.google.android.play.core.internal.k1<x3> b;
    private final e0 c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.android.play.core.splitinstall.p f4756d;

    /* renamed from: e  reason: collision with root package name */
    private final w1 f4757e;

    /* renamed from: f  reason: collision with root package name */
    private final f1 f4758f;

    /* renamed from: g  reason: collision with root package name */
    private final u0 f4759g;

    /* renamed from: h  reason: collision with root package name */
    private final com.google.android.play.core.internal.k1<Executor> f4760h;

    /* renamed from: i  reason: collision with root package name */
    private final Handler f4761i = new Handler(Looper.getMainLooper());

    /* renamed from: j  reason: collision with root package name */
    private boolean f4762j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k3(k0 k0Var, com.google.android.play.core.internal.k1<x3> k1Var, e0 e0Var, com.google.android.play.core.splitinstall.p pVar, w1 w1Var, f1 f1Var, u0 u0Var, com.google.android.play.core.internal.k1<Executor> k1Var2) {
        this.a = k0Var;
        this.b = k1Var;
        this.c = e0Var;
        this.f4756d = pVar;
        this.f4757e = w1Var;
        this.f4758f = f1Var;
        this.f4759g = u0Var;
        this.f4760h = k1Var2;
    }

    private final void p() {
        this.f4760h.a().execute(new Runnable(this) { // from class: com.google.android.play.core.assetpacks.g3
            private final k3 a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.o();
            }
        });
    }

    private final void q() {
        this.f4760h.a().execute(new Runnable(this) { // from class: com.google.android.play.core.assetpacks.h3
            private final k3 a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.k();
            }
        });
        this.f4762j = true;
    }

    @Override // com.google.android.play.core.assetpacks.b
    public final synchronized void a(d dVar) {
        boolean f2 = this.c.f();
        this.c.b(dVar);
        if (f2) {
            return;
        }
        p();
    }

    @Override // com.google.android.play.core.assetpacks.b
    public final com.google.android.play.core.tasks.d<Integer> b(Activity activity) {
        if (this.f4759g.a() == null) {
            return com.google.android.play.core.tasks.f.a(new AssetPackException(-12));
        }
        Intent intent = new Intent(activity, PlayCoreDialogWrapperActivity.class);
        intent.putExtra("confirmation_intent", this.f4759g.a());
        com.google.android.play.core.tasks.p pVar = new com.google.android.play.core.tasks.p();
        intent.putExtra("result_receiver", new i(this, this.f4761i, pVar));
        activity.startActivity(intent);
        return pVar.a();
    }

    @Override // com.google.android.play.core.assetpacks.b
    public final com.google.android.play.core.tasks.d<e> c(List<String> list) {
        Map<String, Long> m = this.a.m();
        ArrayList arrayList = new ArrayList(list);
        arrayList.removeAll(m.keySet());
        ArrayList arrayList2 = new ArrayList(list);
        arrayList2.removeAll(arrayList);
        if (arrayList.isEmpty()) {
            Bundle bundle = new Bundle();
            bundle.putInt(TapjoyConstants.TJC_SESSION_ID, 0);
            bundle.putInt("error_code", 0);
            for (String str : list) {
                bundle.putInt(com.google.android.play.core.internal.p1.f("status", str), 4);
                bundle.putInt(com.google.android.play.core.internal.p1.f("error_code", str), 0);
                bundle.putLong(com.google.android.play.core.internal.p1.f("total_bytes_to_download", str), 0L);
                bundle.putLong(com.google.android.play.core.internal.p1.f("bytes_downloaded", str), 0L);
            }
            bundle.putStringArrayList("pack_names", new ArrayList<>(list));
            bundle.putLong("total_bytes_to_download", 0L);
            bundle.putLong("bytes_downloaded", 0L);
            return com.google.android.play.core.tasks.f.b(e.b(bundle, this.f4758f));
        }
        return this.b.a().a(arrayList2, arrayList, m);
    }

    @Override // com.google.android.play.core.assetpacks.b
    @Nullable
    public final a d(String str) {
        if (!this.f4762j) {
            q();
        }
        if (this.a.h(str)) {
            try {
                return this.a.j(str);
            } catch (IOException unused) {
                return null;
            }
        } else if (this.f4756d.a().contains(str)) {
            return a.a();
        } else {
            return null;
        }
    }

    @Override // com.google.android.play.core.assetpacks.b
    public final void e(d dVar) {
        this.c.e(dVar);
    }

    @Override // com.google.android.play.core.assetpacks.b
    public final com.google.android.play.core.tasks.d<Void> f(final String str) {
        final com.google.android.play.core.tasks.p pVar = new com.google.android.play.core.tasks.p();
        this.f4760h.a().execute(new Runnable(this, str, pVar) { // from class: com.google.android.play.core.assetpacks.h2
            private final k3 a;
            private final String b;
            private final com.google.android.play.core.tasks.p c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.b = str;
                this.c = pVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.m(this.b, this.c);
            }
        });
        return pVar.a();
    }

    @Override // com.google.android.play.core.assetpacks.b
    public final e g(List<String> list) {
        Map<String, Integer> b = this.f4757e.b(list);
        HashMap hashMap = new HashMap();
        for (String str : list) {
            Integer num = b.get(str);
            hashMap.put(str, AssetPackState.b(str, num == null ? 0 : num.intValue(), 0, 0L, 0L, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
        }
        this.b.a().a(list);
        return e.a(0L, hashMap);
    }

    @Override // com.google.android.play.core.assetpacks.b
    public final com.google.android.play.core.tasks.d<e> h(List<String> list) {
        return this.b.a().d(list, new h0(this) { // from class: com.google.android.play.core.assetpacks.g1
            private final k3 a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
            }

            @Override // com.google.android.play.core.assetpacks.h0
            public final int a(int i2, String str) {
                return this.a.i(i2, str);
            }
        }, this.a.m());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int i(int i2, String str) {
        if (this.a.h(str) || i2 != 4) {
            if (!this.a.h(str) || i2 == 4) {
                return i2;
            }
            return 4;
        }
        return 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void k() {
        this.a.u();
        this.a.q();
        this.a.z();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void m(String str, com.google.android.play.core.tasks.p pVar) {
        if (!this.a.v(str)) {
            pVar.b(new IOException(String.format("Failed to remove pack %s.", str)));
            return;
        }
        pVar.c(null);
        this.b.a().a(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void n(boolean z) {
        boolean f2 = this.c.f();
        this.c.d(z);
        if (!z || f2) {
            return;
        }
        p();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void o() {
        com.google.android.play.core.tasks.d<List<String>> a = this.b.a().a(this.a.m());
        k0 k0Var = this.a;
        k0Var.getClass();
        a.e(this.f4760h.a(), i3.a(k0Var));
        a.c(this.f4760h.a(), j3.a);
    }
}
