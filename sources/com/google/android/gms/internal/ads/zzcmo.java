package com.google.android.gms.internal.ads;

import android.content.Context;
import android.webkit.CookieManager;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcmo implements zzeqb<zzdzw<String>> {
    private final zzeqo<Context> zzewk;
    private final zzeqo<zzdrj> zzfvi;

    private zzcmo(zzeqo<zzdrj> zzeqoVar, zzeqo<Context> zzeqoVar2) {
        this.zzfvi = zzeqoVar;
        this.zzewk = zzeqoVar2;
    }

    public static zzcmo zzaj(zzeqo<zzdrj> zzeqoVar, zzeqo<Context> zzeqoVar2) {
        return new zzcmo(zzeqoVar, zzeqoVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        final CookieManager zzbf = com.google.android.gms.ads.internal.zzr.zzkt().zzbf(this.zzewk.get());
        return (zzdzw) zzeqh.zza(this.zzfvi.get().zzt(zzdrk.WEBVIEW_COOKIE).zzc(new Callable(zzbf) { // from class: com.google.android.gms.internal.ads.zzcmk
            private final CookieManager zzgny;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgny = zzbf;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                CookieManager cookieManager = this.zzgny;
                if (cookieManager == null) {
                    return "";
                }
                return cookieManager.getCookie((String) zzwr.zzqr().zzd(zzabp.zzcpf));
            }
        }).zza(1L, TimeUnit.SECONDS).zza(Exception.class, zzcmj.zzgnx).zzaxj(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
