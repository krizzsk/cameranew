package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;
import android.webkit.WebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzrr implements Runnable {
    final /* synthetic */ zzrp zzbth;
    private ValueCallback<String> zzbtv = new zzrq(this);
    final /* synthetic */ zzrj zzbtw;
    final /* synthetic */ WebView zzbtx;
    final /* synthetic */ boolean zzbty;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzrr(zzrp zzrpVar, zzrj zzrjVar, WebView webView, boolean z) {
        this.zzbth = zzrpVar;
        this.zzbtw = zzrjVar;
        this.zzbtx = webView;
        this.zzbty = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzbtx.getSettings().getJavaScriptEnabled()) {
            try {
                this.zzbtx.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.zzbtv);
            } catch (Throwable unused) {
                this.zzbtv.onReceiveValue("");
            }
        }
    }
}
