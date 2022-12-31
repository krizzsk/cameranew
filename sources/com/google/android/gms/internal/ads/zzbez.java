package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.google.android.gms.internal.ads.zzbfd;
import com.google.android.gms.internal.ads.zzbfm;
import com.google.android.gms.internal.ads.zzbfo;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@TargetApi(17)
/* loaded from: classes2.dex */
public final class zzbez<WebViewT extends zzbfd & zzbfm & zzbfo> {
    private final zzbfe zzeuh;
    private final WebViewT zzeui;

    public zzbez(WebViewT webviewt, zzbfe zzbfeVar) {
        this.zzeuh = zzbfeVar;
        this.zzeui = webviewt;
    }

    @JavascriptInterface
    public final String getClickSignals(String str) {
        if (TextUtils.isEmpty(str)) {
            com.google.android.gms.ads.internal.util.zzd.zzeb("Click string is empty, not proceeding.");
            return "";
        }
        zzei zzada = this.zzeui.zzada();
        if (zzada == null) {
            com.google.android.gms.ads.internal.util.zzd.zzeb("Signal utils is empty, ignoring.");
            return "";
        }
        zzdy zzca = zzada.zzca();
        if (zzca == null) {
            com.google.android.gms.ads.internal.util.zzd.zzeb("Signals object is empty, ignoring.");
            return "";
        } else if (this.zzeui.getContext() == null) {
            com.google.android.gms.ads.internal.util.zzd.zzeb("Context is null, ignoring.");
            return "";
        } else {
            return zzca.zza(this.zzeui.getContext(), str, this.zzeui.getView(), this.zzeui.zzabe());
        }
    }

    @JavascriptInterface
    public final void notify(final String str) {
        if (TextUtils.isEmpty(str)) {
            zzazk.zzex("URL is empty, ignoring message");
        } else {
            com.google.android.gms.ads.internal.util.zzj.zzeen.post(new Runnable(this, str) { // from class: com.google.android.gms.internal.ads.zzbfb
                private final String zzdjf;
                private final zzbez zzeuj;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzeuj = this;
                    this.zzdjf = str;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzeuj.zzfn(this.zzdjf);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzfn(String str) {
        this.zzeuh.zzj(Uri.parse(str));
    }
}
