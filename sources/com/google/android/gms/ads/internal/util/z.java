package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.internal.ads.zzaco;
import com.google.android.gms.internal.ads.zzacp;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class z implements zzaco {
    private final /* synthetic */ zzacp a;
    private final /* synthetic */ Context b;
    private final /* synthetic */ Uri c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(zzj zzjVar, zzacp zzacpVar, Context context, Uri uri) {
        this.a = zzacpVar;
        this.b = context;
        this.c = uri;
    }

    @Override // com.google.android.gms.internal.ads.zzaco
    public final void zzst() {
        new CustomTabsIntent.Builder(this.a.zzsv()).build().launchUrl(this.b, this.c);
        this.a.zzc((Activity) this.b);
    }

    @Override // com.google.android.gms.internal.ads.zzaco
    public final void zzsu() {
    }
}
