package com.tapjoy.internal;

import android.os.Handler;
import android.webkit.WebView;
import java.util.List;
/* loaded from: classes3.dex */
public final class du extends ds {

    /* renamed from: f  reason: collision with root package name */
    WebView f7372f;

    /* renamed from: g  reason: collision with root package name */
    private List f7373g;

    /* renamed from: h  reason: collision with root package name */
    private final String f7374h;

    public du(List list, String str) {
        this.f7373g = list;
        this.f7374h = str;
    }

    @Override // com.tapjoy.internal.ds
    public final void a() {
        super.a();
        WebView webView = new WebView(df.a().a);
        this.f7372f = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        a(this.f7372f);
        dg.a();
        dg.a(this.f7372f, this.f7374h);
        for (cy cyVar : this.f7373g) {
            String externalForm = cyVar.b.toExternalForm();
            dg.a();
            WebView webView2 = this.f7372f;
            if (externalForm != null) {
                dg.a(webView2, "var script=document.createElement('script');script.setAttribute(\"type\",\"text/javascript\");script.setAttribute(\"src\",\"%SCRIPT_SRC%\");document.body.appendChild(script);".replace("%SCRIPT_SRC%", externalForm));
            }
        }
    }

    @Override // com.tapjoy.internal.ds
    public final void b() {
        super.b();
        new Handler().postDelayed(new Runnable() { // from class: com.tapjoy.internal.du.1
            private WebView b;

            {
                this.b = du.this.f7372f;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.b.destroy();
            }
        }, 2000L);
        this.f7372f = null;
    }
}
