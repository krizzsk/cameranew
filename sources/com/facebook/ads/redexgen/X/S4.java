package com.facebook.ads.redexgen.X;

import android.view.MotionEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
/* loaded from: assets/audience_network.dex */
public class S4 extends AbstractC1045Nk {
    public final /* synthetic */ C1072On A00;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public S4(C1072On c1072On, XT xt) {
        super(xt);
        this.A00 = c1072On;
        getSettings().setAllowFileAccess(true);
        setBackgroundColor(0);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1045Nk
    public final WebChromeClient A0D() {
        return new C1067Oi(this.A00, null);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1045Nk
    public final WebViewClient A0E() {
        return new C1068Oj(this.A00, null);
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        C1009Lz c1009Lz;
        c1009Lz = this.A00.A0B;
        c1009Lz.A06(motionEvent, this, this);
        requestDisallowInterceptTouchEvent(true);
        return super.onTouchEvent(motionEvent);
    }
}
