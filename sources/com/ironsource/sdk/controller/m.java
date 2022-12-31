package com.ironsource.sdk.controller;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.ironsource.sdk.ISNAdView.ISNAdView;
import com.ironsource.sdk.data.ISNEnums$ControllerType;
import com.ironsource.sdk.data.ISNEnums$ProductType;
import java.util.Map;
import org.json.JSONObject;
/* compiled from: NativeController.java */
/* loaded from: classes2.dex */
public class m implements com.ironsource.sdk.controller.j {
    private static final Handler b = new Handler(Looper.getMainLooper());
    private String a = "";

    /* compiled from: NativeController.java */
    /* loaded from: classes2.dex */
    class a implements Runnable {
        final /* synthetic */ d.e.d.n.h.c a;
        final /* synthetic */ JSONObject b;

        a(d.e.d.n.h.c cVar, JSONObject jSONObject) {
            this.a = cVar;
            this.b = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.j(this.b.optString("demandSourceName"), m.this.a);
        }
    }

    /* compiled from: NativeController.java */
    /* loaded from: classes2.dex */
    class b implements Runnable {
        final /* synthetic */ d.e.d.n.h.c a;
        final /* synthetic */ com.ironsource.sdk.data.b b;

        b(d.e.d.n.h.c cVar, com.ironsource.sdk.data.b bVar) {
            this.a = cVar;
            this.b = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.j(this.b.f(), m.this.a);
        }
    }

    /* compiled from: NativeController.java */
    /* loaded from: classes2.dex */
    class c implements Runnable {
        final /* synthetic */ d.e.d.n.h.b a;
        final /* synthetic */ Map b;

        c(d.e.d.n.h.b bVar, Map map) {
            this.a = bVar;
            this.b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.z((String) this.b.get("demandSourceName"), m.this.a);
        }
    }

    /* compiled from: NativeController.java */
    /* loaded from: classes2.dex */
    class d implements Runnable {
        final /* synthetic */ d.e.d.n.h.b a;
        final /* synthetic */ JSONObject b;

        d(d.e.d.n.h.b bVar, JSONObject jSONObject) {
            this.a = bVar;
            this.b = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.z(this.b.optString("demandSourceName"), m.this.a);
        }
    }

    /* compiled from: NativeController.java */
    /* loaded from: classes2.dex */
    class e implements Runnable {
        final /* synthetic */ com.ironsource.sdk.controller.e a;

        e(m mVar, com.ironsource.sdk.controller.e eVar) {
            this.a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.g();
        }
    }

    /* compiled from: NativeController.java */
    /* loaded from: classes2.dex */
    class f implements Runnable {
        final /* synthetic */ d.e.d.n.e a;

        f(d.e.d.n.e eVar) {
            this.a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.onOfferwallInitFail(m.this.a);
        }
    }

    /* compiled from: NativeController.java */
    /* loaded from: classes2.dex */
    class g implements Runnable {
        final /* synthetic */ d.e.d.n.e a;

        g(d.e.d.n.e eVar) {
            this.a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.onOWShowFail(m.this.a);
            this.a.onOfferwallInitFail(m.this.a);
        }
    }

    /* compiled from: NativeController.java */
    /* loaded from: classes2.dex */
    class h implements Runnable {
        final /* synthetic */ d.e.d.n.e a;

        h(d.e.d.n.e eVar) {
            this.a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.onGetOWCreditsFailed(m.this.a);
        }
    }

    /* compiled from: NativeController.java */
    /* loaded from: classes2.dex */
    class i implements Runnable {
        final /* synthetic */ d.e.d.n.h.d a;
        final /* synthetic */ com.ironsource.sdk.data.b b;

        i(d.e.d.n.h.d dVar, com.ironsource.sdk.data.b bVar) {
            this.a = dVar;
            this.b = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.y(ISNEnums$ProductType.RewardedVideo, this.b.f(), m.this.a);
        }
    }

    /* compiled from: NativeController.java */
    /* loaded from: classes2.dex */
    class j implements Runnable {
        final /* synthetic */ d.e.d.n.h.d a;
        final /* synthetic */ JSONObject b;

        j(d.e.d.n.h.d dVar, JSONObject jSONObject) {
            this.a = dVar;
            this.b = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.L(this.b.optString("demandSourceName"), m.this.a);
        }
    }

    /* compiled from: NativeController.java */
    /* loaded from: classes2.dex */
    class k implements Runnable {
        final /* synthetic */ d.e.d.n.h.c a;
        final /* synthetic */ com.ironsource.sdk.data.b b;

        k(d.e.d.n.h.c cVar, com.ironsource.sdk.data.b bVar) {
            this.a = cVar;
            this.b = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.y(ISNEnums$ProductType.Interstitial, this.b.f(), m.this.a);
        }
    }

    /* compiled from: NativeController.java */
    /* loaded from: classes2.dex */
    class l implements Runnable {
        final /* synthetic */ d.e.d.n.h.c a;
        final /* synthetic */ String b;

        l(d.e.d.n.h.c cVar, String str) {
            this.a = cVar;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.m(this.b, m.this.a);
        }
    }

    /* compiled from: NativeController.java */
    /* renamed from: com.ironsource.sdk.controller.m$m  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class RunnableC0218m implements Runnable {
        final /* synthetic */ d.e.d.n.h.c a;
        final /* synthetic */ com.ironsource.sdk.data.b b;

        RunnableC0218m(d.e.d.n.h.c cVar, com.ironsource.sdk.data.b bVar) {
            this.a = cVar;
            this.b = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.m(this.b.f(), m.this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(com.ironsource.sdk.controller.e eVar) {
        b.post(new e(this, eVar));
    }

    @Override // com.ironsource.sdk.controller.j
    public void a() {
    }

    @Override // com.ironsource.sdk.controller.j
    public void b(JSONObject jSONObject) {
    }

    @Override // com.ironsource.sdk.controller.j
    public void c(String str, d.e.d.n.h.c cVar) {
        if (cVar != null) {
            b.post(new l(cVar, str));
        }
    }

    @Override // com.ironsource.sdk.controller.j
    public void d(String str, String str2, Map<String, String> map, d.e.d.n.e eVar) {
        if (eVar != null) {
            b.post(new f(eVar));
        }
    }

    @Override // com.ironsource.sdk.controller.j
    public void destroy() {
    }

    @Override // com.ironsource.sdk.controller.j
    public void e(String str, String str2, d.e.d.n.e eVar) {
        if (eVar != null) {
            b.post(new h(eVar));
        }
    }

    @Override // com.ironsource.sdk.controller.j
    public void f(String str, String str2, com.ironsource.sdk.data.b bVar, d.e.d.n.h.c cVar) {
        if (cVar != null) {
            b.post(new k(cVar, bVar));
        }
    }

    @Override // com.ironsource.sdk.controller.j
    public ISNEnums$ControllerType getType() {
        return ISNEnums$ControllerType.Native;
    }

    @Override // com.ironsource.sdk.controller.j
    public boolean h(String str) {
        return false;
    }

    @Override // com.ironsource.sdk.controller.j
    public void i(String str, String str2, com.ironsource.sdk.data.b bVar, d.e.d.n.h.b bVar2) {
        if (bVar2 != null) {
            bVar2.y(ISNEnums$ProductType.Banner, bVar.f(), this.a);
        }
    }

    @Override // com.ironsource.sdk.controller.j
    public void j(JSONObject jSONObject, d.e.d.n.h.d dVar) {
        if (dVar != null) {
            b.post(new j(dVar, jSONObject));
        }
    }

    @Override // com.ironsource.sdk.controller.j
    public void k(Context context) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(String str) {
        this.a = str;
    }

    @Override // com.ironsource.sdk.controller.j
    public void m(com.ironsource.sdk.data.b bVar, Map<String, String> map, d.e.d.n.h.c cVar) {
        if (cVar != null) {
            b.post(new b(cVar, bVar));
        }
    }

    @Override // com.ironsource.sdk.controller.j
    public void n(Map<String, String> map, d.e.d.n.h.b bVar) {
        if (bVar != null) {
            b.post(new c(bVar, map));
        }
    }

    @Override // com.ironsource.sdk.controller.j
    public void o(Context context) {
    }

    @Override // com.ironsource.sdk.controller.j
    public void p(JSONObject jSONObject, d.e.d.n.h.b bVar) {
        if (bVar != null) {
            b.post(new d(bVar, jSONObject));
        }
    }

    @Override // com.ironsource.sdk.controller.j
    public void q(Map<String, String> map, d.e.d.n.e eVar) {
        if (eVar != null) {
            b.post(new g(eVar));
        }
    }

    @Override // com.ironsource.sdk.controller.j
    public void r(JSONObject jSONObject, d.e.d.n.h.c cVar) {
        if (cVar != null) {
            b.post(new a(cVar, jSONObject));
        }
    }

    @Override // com.ironsource.sdk.controller.j
    public void setCommunicationWithAdView(ISNAdView iSNAdView) {
    }

    @Override // com.ironsource.sdk.controller.j
    public void t(com.ironsource.sdk.data.b bVar, Map<String, String> map, d.e.d.n.h.c cVar) {
        if (cVar != null) {
            b.post(new RunnableC0218m(cVar, bVar));
        }
    }

    @Override // com.ironsource.sdk.controller.j
    public void u() {
    }

    @Override // com.ironsource.sdk.controller.j
    public void v() {
    }

    @Override // com.ironsource.sdk.controller.j
    public void x(String str, String str2, com.ironsource.sdk.data.b bVar, d.e.d.n.h.d dVar) {
        if (dVar != null) {
            b.post(new i(dVar, bVar));
        }
    }
}
