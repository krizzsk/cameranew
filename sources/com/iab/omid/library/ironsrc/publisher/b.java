package com.iab.omid.library.ironsrc.publisher;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.webkit.WebView;
import com.iab.omid.library.ironsrc.adsession.d;
import com.iab.omid.library.ironsrc.adsession.f;
import com.iab.omid.library.ironsrc.adsession.g;
import d.d.a.a.a.d.e;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends AdSessionStatePublisher {

    /* renamed from: e  reason: collision with root package name */
    private WebView f5316e;

    /* renamed from: f  reason: collision with root package name */
    private Long f5317f = null;

    /* renamed from: g  reason: collision with root package name */
    private Map<String, f> f5318g;

    /* renamed from: h  reason: collision with root package name */
    private final String f5319h;

    /* loaded from: classes2.dex */
    class a implements Runnable {
        private WebView a;

        a() {
            this.a = b.this.f5316e;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.destroy();
        }
    }

    public b(Map<String, f> map, String str) {
        this.f5318g = map;
        this.f5319h = str;
    }

    @Override // com.iab.omid.library.ironsrc.publisher.AdSessionStatePublisher
    public void a() {
        super.a();
        t();
    }

    @Override // com.iab.omid.library.ironsrc.publisher.AdSessionStatePublisher
    public void f(g gVar, d dVar) {
        JSONObject jSONObject = new JSONObject();
        Map<String, f> e2 = dVar.e();
        for (String str : e2.keySet()) {
            d.d.a.a.a.g.b.g(jSONObject, str, e2.get(str));
        }
        g(gVar, dVar, jSONObject);
    }

    @Override // com.iab.omid.library.ironsrc.publisher.AdSessionStatePublisher
    public void j() {
        super.j();
        new Handler().postDelayed(new a(), Math.max(4000 - (this.f5317f == null ? 4000L : TimeUnit.MILLISECONDS.convert(d.d.a.a.a.g.d.a() - this.f5317f.longValue(), TimeUnit.NANOSECONDS)), 2000L));
        this.f5316e = null;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    void t() {
        WebView webView = new WebView(d.d.a.a.a.d.d.a().c());
        this.f5316e = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        c(this.f5316e);
        e.a().j(this.f5316e, this.f5319h);
        for (String str : this.f5318g.keySet()) {
            e.a().d(this.f5316e, this.f5318g.get(str).a().toExternalForm(), str);
        }
        this.f5317f = Long.valueOf(d.d.a.a.a.g.d.a());
    }
}
