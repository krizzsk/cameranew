package com.facebook.ads.redexgen.X;

import android.view.View;
import android.webkit.WebView;
/* loaded from: assets/audience_network.dex */
public class NT implements View.OnClickListener {
    public final /* synthetic */ NW A00;

    public NT(NW nw) {
        this.A00 = nw;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WebView webView;
        WebView webView2;
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            webView = this.A00.A08;
            if (!webView.canGoForward()) {
                return;
            }
            webView2 = this.A00.A08;
            webView2.goForward();
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }
}
