package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import java.io.File;
import java.util.Collections;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@TargetApi(11)
/* loaded from: classes2.dex */
public class zzbff extends zzbee {
    public zzbff(zzbeb zzbebVar, zztu zztuVar, boolean z) {
        super(zzbebVar, zztuVar, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final WebResourceResponse zza(WebView webView, String str, @Nullable Map<String, String> map) {
        String str2;
        if (!(webView instanceof zzbeb)) {
            zzazk.zzex("Tried to intercept request from a WebView that wasn't an AdWebView.");
            return null;
        }
        zzbeb zzbebVar = (zzbeb) webView;
        zzawz zzawzVar = this.zzerf;
        if (zzawzVar != null) {
            zzawzVar.zza(str, map, 1);
        }
        if (!"mraid.js".equalsIgnoreCase(new File(str).getName())) {
            if (map == null) {
                map = Collections.emptyMap();
            }
            return super.zzc(str, map);
        }
        if (zzbebVar.zzacx() != null) {
            zzbebVar.zzacx().zzvx();
        }
        if (zzbebVar.zzacv().zzaeo()) {
            str2 = (String) zzwr.zzqr().zzd(zzabp.zzcnr);
        } else if (zzbebVar.zzadc()) {
            str2 = (String) zzwr.zzqr().zzd(zzabp.zzcnq);
        } else {
            str2 = (String) zzwr.zzqr().zzd(zzabp.zzcnp);
        }
        com.google.android.gms.ads.internal.zzr.zzkr();
        return com.google.android.gms.ads.internal.util.zzj.zzd(zzbebVar.getContext(), zzbebVar.zzabj().zzbrp, str2);
    }
}
