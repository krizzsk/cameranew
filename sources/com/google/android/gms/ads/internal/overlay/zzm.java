package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.common.util.o;
import com.google.android.gms.internal.ads.zzvc;
import us.pinguo.androidsdk.PGImageSDK;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzm {
    public static void zza(Context context, AdOverlayInfoParcel adOverlayInfoParcel, boolean z) {
        if (adOverlayInfoParcel.zzdta == 4 && adOverlayInfoParcel.zzdsv == null) {
            zzvc zzvcVar = adOverlayInfoParcel.zzchd;
            if (zzvcVar != null) {
                zzvcVar.onAdClicked();
            }
            com.google.android.gms.ads.internal.zzr.zzkp();
            if (adOverlayInfoParcel.zzdsu.zzdsg) {
                context = adOverlayInfoParcel.zzdjd.zzabe();
            }
            zzd zzdVar = adOverlayInfoParcel.zzdsu;
            zzb.zza(context, zzdVar, adOverlayInfoParcel.zzdsz, zzdVar.zzdif);
            return;
        }
        Intent intent = new Intent();
        intent.setClassName(context, AdActivity.CLASS_NAME);
        intent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", adOverlayInfoParcel.zzbpn.zzeia);
        intent.putExtra("shouldCallOnOverlayOpened", z);
        AdOverlayInfoParcel.zza(intent, adOverlayInfoParcel);
        if (!o.h()) {
            intent.addFlags(524288);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(PGImageSDK.SDK_STATUS_CREATE);
        }
        com.google.android.gms.ads.internal.zzr.zzkr();
        com.google.android.gms.ads.internal.util.zzj.zza(context, intent);
    }
}
