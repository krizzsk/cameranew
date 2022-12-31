package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import java.util.ArrayList;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzbqs implements zzbsh, zzbtb {
    private final Context context;
    private final zzarz zzboo;
    private final zzdmw zzesr;

    public zzbqs(Context context, zzdmw zzdmwVar, zzarz zzarzVar) {
        this.context = context;
        this.zzesr = zzdmwVar;
        this.zzboo = zzarzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void onAdLoaded() {
        zzarx zzarxVar = this.zzesr.zzhju;
        if (zzarxVar == null || !zzarxVar.zzdtk) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (!this.zzesr.zzhju.zzdtl.isEmpty()) {
            arrayList.add(this.zzesr.zzhju.zzdtl);
        }
        this.zzboo.zza(this.context, arrayList);
    }

    @Override // com.google.android.gms.internal.ads.zzbsh
    public final void zzcb(@Nullable Context context) {
    }

    @Override // com.google.android.gms.internal.ads.zzbsh
    public final void zzcc(@Nullable Context context) {
    }

    @Override // com.google.android.gms.internal.ads.zzbsh
    public final void zzcd(@Nullable Context context) {
        this.zzboo.detach();
    }
}
