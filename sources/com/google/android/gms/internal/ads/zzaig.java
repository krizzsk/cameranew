package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.f;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaig implements zzaif<zzbeb> {
    private static final Map<String, Integer> zzdhz = f.e(new String[]{"resize", "playVideo", "storePicture", "createCalendarEvent", "setOrientationProperties", "closeResizedAd", "unload"}, new Integer[]{1, 2, 3, 4, 5, 6, 7});
    private final com.google.android.gms.ads.internal.zza zzdhw;
    private final zzaqg zzdhx;
    private final zzaqt zzdhy;

    public zzaig(com.google.android.gms.ads.internal.zza zzaVar, zzaqg zzaqgVar, zzaqt zzaqtVar) {
        this.zzdhw = zzaVar;
        this.zzdhx = zzaqgVar;
        this.zzdhy = zzaqtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaif
    public final /* synthetic */ void zza(zzbeb zzbebVar, Map map) {
        com.google.android.gms.ads.internal.zza zzaVar;
        zzbeb zzbebVar2 = zzbebVar;
        int intValue = zzdhz.get((String) map.get("a")).intValue();
        if (intValue != 5 && intValue != 7 && (zzaVar = this.zzdhw) != null && !zzaVar.zzjy()) {
            this.zzdhw.zzbk(null);
        } else if (intValue == 1) {
            this.zzdhx.zzg(map);
        } else if (intValue == 3) {
            new zzaql(zzbebVar2, map).execute();
        } else if (intValue == 4) {
            new zzaqf(zzbebVar2, map).execute();
        } else if (intValue == 5) {
            new zzaqi(zzbebVar2, map).execute();
        } else if (intValue == 6) {
            this.zzdhx.zzad(true);
        } else if (intValue != 7) {
            zzazk.zzew("Unknown MRAID command called.");
        } else {
            this.zzdhy.zzvr();
        }
    }
}
