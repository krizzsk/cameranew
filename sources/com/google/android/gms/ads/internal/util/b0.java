package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.internal.ads.zzazb;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class b0 implements zzazb {
    private final /* synthetic */ Context a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b0(zzj zzjVar, Context context, String str) {
        this.a = context;
        this.b = str;
    }

    @Override // com.google.android.gms.internal.ads.zzazb
    public final void zzel(String str) {
        com.google.android.gms.ads.internal.zzr.zzkr();
        zzj.zzb(this.a, this.b, str);
    }
}
