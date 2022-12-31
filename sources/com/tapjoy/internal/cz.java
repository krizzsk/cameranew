package com.tapjoy.internal;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.provider.Settings;
import android.view.View;
import android.webkit.WebView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class cz extends cs {
    public final ct a;
    public ds c;

    /* renamed from: g  reason: collision with root package name */
    boolean f7356g;

    /* renamed from: h  reason: collision with root package name */
    private final cu f7357h;

    /* renamed from: i  reason: collision with root package name */
    private dq f7358i;
    public final List b = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public boolean f7353d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f7354e = false;

    /* renamed from: f  reason: collision with root package name */
    public String f7355f = UUID.randomUUID().toString();

    /* JADX INFO: Access modifiers changed from: package-private */
    public cz(ct ctVar, cu cuVar) {
        this.a = ctVar;
        this.f7357h = cuVar;
        b(null);
        if (cuVar.f7349f == cv.HTML) {
            this.c = new dt(cuVar.b);
        } else {
            this.c = new du(Collections.unmodifiableList(cuVar.c), cuVar.f7347d);
        }
        this.c.a();
        dd.a().a.add(this);
        ds dsVar = this.c;
        dg a = dg.a();
        WebView c = dsVar.c();
        JSONObject jSONObject = new JSONObject();
        dm.a(jSONObject, "impressionOwner", ctVar.a);
        dm.a(jSONObject, "videoEventsOwner", ctVar.b);
        dm.a(jSONObject, "isolateVerificationScripts", Boolean.valueOf(ctVar.c));
        a.a(c, "init", jSONObject);
    }

    private void b(View view) {
        this.f7358i = new dq(view);
    }

    @Override // com.tapjoy.internal.cs
    public final void a() {
        if (this.f7353d) {
            return;
        }
        this.f7353d = true;
        dd a = dd.a();
        boolean b = a.b();
        a.b.add(this);
        if (!b) {
            dh a2 = dh.a();
            de.a().f7365e = a2;
            final de a3 = de.a();
            a3.b = new BroadcastReceiver() { // from class: com.tapjoy.internal.de.1
                @Override // android.content.BroadcastReceiver
                public final void onReceive(Context context, Intent intent) {
                    KeyguardManager keyguardManager;
                    VdsAgent.onBroadcastReceiver(this, context, intent);
                    if (intent == null) {
                        return;
                    }
                    if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                        de.a(de.this, true);
                    } else if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                        de.a(de.this, false);
                    } else if (!"android.intent.action.SCREEN_ON".equals(intent.getAction()) || (keyguardManager = (KeyguardManager) context.getSystemService("keyguard")) == null || keyguardManager.inKeyguardRestrictedInputMode()) {
                    } else {
                        de.a(de.this, false);
                    }
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            a3.a.registerReceiver(a3.b, intentFilter);
            a3.c = true;
            a3.c();
            if (de.a().b()) {
                dv.a();
                dv.b();
            }
            cp cpVar = a2.b;
            cpVar.b = cpVar.a();
            cpVar.b();
            cpVar.a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, cpVar);
        }
        this.c.a(dh.a().a);
        this.c.a(this, this.f7357h);
    }

    @Override // com.tapjoy.internal.cs
    public final void b() {
        BroadcastReceiver broadcastReceiver;
        if (this.f7354e) {
            return;
        }
        this.f7358i.clear();
        if (!this.f7354e) {
            this.b.clear();
        }
        this.f7354e = true;
        dg.a().a(this.c.c(), "finishSession", new Object[0]);
        dd a = dd.a();
        boolean b = a.b();
        a.a.remove(this);
        a.b.remove(this);
        if (b && !a.b()) {
            dh a2 = dh.a();
            final dv a3 = dv.a();
            dv.c();
            a3.b.clear();
            dv.a.post(new Runnable() { // from class: com.tapjoy.internal.dv.1
                @Override // java.lang.Runnable
                public final void run() {
                    dv.this.f7381h.b();
                }
            });
            de a4 = de.a();
            Context context = a4.a;
            if (context != null && (broadcastReceiver = a4.b) != null) {
                context.unregisterReceiver(broadcastReceiver);
                a4.b = null;
            }
            a4.c = false;
            a4.f7364d = false;
            a4.f7365e = null;
            cp cpVar = a2.b;
            cpVar.a.getContentResolver().unregisterContentObserver(cpVar);
        }
        this.c.b();
        this.c = null;
    }

    public final View c() {
        return (View) this.f7358i.get();
    }

    public final boolean d() {
        return this.f7353d && !this.f7354e;
    }

    @Override // com.tapjoy.internal.cs
    public final void a(View view) {
        if (this.f7354e) {
            return;
        }
        Cdo.a(view, "AdView is null");
        if (c() == view) {
            return;
        }
        b(view);
        this.c.d();
        Collection<cz> unmodifiableCollection = Collections.unmodifiableCollection(dd.a().a);
        if (unmodifiableCollection == null || unmodifiableCollection.size() <= 0) {
            return;
        }
        for (cz czVar : unmodifiableCollection) {
            if (czVar != this && czVar.c() == view) {
                czVar.f7358i.clear();
            }
        }
    }
}
