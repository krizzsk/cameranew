package com.google.android.gms.ads.internal;

import android.os.AsyncTask;
import android.webkit.WebView;
import com.google.android.gms.internal.ads.zzazk;
import com.google.android.gms.internal.ads.zzei;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class f extends AsyncTask<Void, Void, String> {
    private final /* synthetic */ zzl a;

    private f(zzl zzlVar) {
        this.a = zzlVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public final String doInBackground(Void... voidArr) {
        Future future;
        try {
            zzl zzlVar = this.a;
            future = zzlVar.c;
            zzlVar.f3514h = (zzei) future.get(1000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e2) {
            zzazk.zzd("", e2);
        }
        return this.a.K0();
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ void onPostExecute(String str) {
        WebView webView;
        WebView webView2;
        String str2 = str;
        webView = this.a.f3512f;
        if (webView == null || str2 == null) {
            return;
        }
        webView2 = this.a.f3512f;
        webView2.loadUrl(str2);
        VdsAgent.loadUrl(webView2, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ f(zzl zzlVar, e eVar) {
        this(zzlVar);
    }
}
