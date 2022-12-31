package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@TargetApi(11)
/* loaded from: classes2.dex */
public final class zzbfg extends zzbff {
    public zzbfg(zzbeb zzbebVar, zztu zztuVar, boolean z) {
        super(zzbebVar, zztuVar, z);
    }

    @Override // com.google.android.gms.internal.ads.zzbee, android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return zza(webView, str, (Map<String, String>) null);
    }
}
