package com.google.android.gms.internal.ads;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import java.util.HashMap;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzaic implements zzaif<zzbeb> {
    @Override // com.google.android.gms.internal.ads.zzaif
    public final /* synthetic */ void zza(zzbeb zzbebVar, Map map) {
        zzbeb zzbebVar2 = zzbebVar;
        com.google.android.gms.ads.internal.zzr.zzkr();
        DisplayMetrics zza = com.google.android.gms.ads.internal.util.zzj.zza((WindowManager) zzbebVar2.getContext().getSystemService("window"));
        int i2 = zza.widthPixels;
        int i3 = zza.heightPixels;
        int[] iArr = new int[2];
        HashMap hashMap = new HashMap();
        ((View) zzbebVar2).getLocationInWindow(iArr);
        hashMap.put("xInPixels", Integer.valueOf(iArr[0]));
        hashMap.put("yInPixels", Integer.valueOf(iArr[1]));
        hashMap.put("windowWidthInPixels", Integer.valueOf(i2));
        hashMap.put("windowHeightInPixels", Integer.valueOf(i3));
        zzbebVar2.zza("locationReady", hashMap);
        zzazk.zzex("GET LOCATION COMPILED");
    }
}
