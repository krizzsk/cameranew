package com.iab.omid.library.ironsrc.publisher;

import android.webkit.WebView;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.growingio.android.sdk.monitor.marshaller.json.JsonMarshaller;
import com.iab.omid.library.ironsrc.adsession.c;
import com.iab.omid.library.ironsrc.adsession.d;
import com.iab.omid.library.ironsrc.adsession.f;
import com.iab.omid.library.ironsrc.adsession.g;
import d.d.a.a.a.d.e;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class AdSessionStatePublisher {
    private d.d.a.a.a.h.b a;
    private com.iab.omid.library.ironsrc.adsession.a b;
    private a c;

    /* renamed from: d  reason: collision with root package name */
    private long f5314d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public enum a {
        AD_STATE_IDLE,
        AD_STATE_VISIBLE,
        AD_STATE_NOTVISIBLE
    }

    public AdSessionStatePublisher() {
        r();
        this.a = new d.d.a.a.a.h.b(null);
    }

    public void a() {
    }

    public void b(float f2) {
        e.a().c(p(), f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(WebView webView) {
        this.a = new d.d.a.a.a.h.b(webView);
    }

    public void d(com.iab.omid.library.ironsrc.adsession.a aVar) {
        this.b = aVar;
    }

    public void e(c cVar) {
        e.a().h(p(), cVar.c());
    }

    public void f(g gVar, d dVar) {
        g(gVar, dVar, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(g gVar, d dVar, JSONObject jSONObject) {
        String n = gVar.n();
        JSONObject jSONObject2 = new JSONObject();
        d.d.a.a.a.g.b.g(jSONObject2, JsonMarshaller.ENVIRONMENT, "app");
        d.d.a.a.a.g.b.g(jSONObject2, "adSessionType", dVar.b());
        d.d.a.a.a.g.b.g(jSONObject2, "deviceInfo", d.d.a.a.a.g.a.d());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        d.d.a.a.a.g.b.g(jSONObject2, "supports", jSONArray);
        JSONObject jSONObject3 = new JSONObject();
        d.d.a.a.a.g.b.g(jSONObject3, "partnerName", dVar.g().b());
        d.d.a.a.a.g.b.g(jSONObject3, "partnerVersion", dVar.g().c());
        d.d.a.a.a.g.b.g(jSONObject2, "omidNativeInfo", jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        d.d.a.a.a.g.b.g(jSONObject4, "libraryVersion", "1.3.12-Ironsrc");
        d.d.a.a.a.g.b.g(jSONObject4, RemoteConfigConstants.RequestFieldKey.APP_ID, d.d.a.a.a.d.d.a().c().getApplicationContext().getPackageName());
        d.d.a.a.a.g.b.g(jSONObject2, "app", jSONObject4);
        if (dVar.c() != null) {
            d.d.a.a.a.g.b.g(jSONObject2, "contentUrl", dVar.c());
        }
        if (dVar.d() != null) {
            d.d.a.a.a.g.b.g(jSONObject2, "customReferenceData", dVar.d());
        }
        JSONObject jSONObject5 = new JSONObject();
        for (f fVar : dVar.h()) {
            d.d.a.a.a.g.b.g(jSONObject5, fVar.b(), fVar.c());
        }
        e.a().e(p(), n, jSONObject2, jSONObject5, jSONObject);
    }

    public void h(String str, long j2) {
        if (j2 >= this.f5314d) {
            this.c = a.AD_STATE_VISIBLE;
            e.a().l(p(), str);
        }
    }

    public void i(boolean z) {
        if (m()) {
            e.a().n(p(), z ? "foregrounded" : "backgrounded");
        }
    }

    public void j() {
        this.a.clear();
    }

    public void k(String str, long j2) {
        if (j2 >= this.f5314d) {
            a aVar = this.c;
            a aVar2 = a.AD_STATE_NOTVISIBLE;
            if (aVar != aVar2) {
                this.c = aVar2;
                e.a().l(p(), str);
            }
        }
    }

    public com.iab.omid.library.ironsrc.adsession.a l() {
        return this.b;
    }

    public boolean m() {
        return this.a.get() != null;
    }

    public void n() {
        e.a().b(p());
    }

    public void o() {
        e.a().k(p());
    }

    public WebView p() {
        return this.a.get();
    }

    public void q() {
        e.a().m(p());
    }

    public void r() {
        this.f5314d = d.d.a.a.a.g.d.a();
        this.c = a.AD_STATE_IDLE;
    }
}
