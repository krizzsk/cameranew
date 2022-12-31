package com.google.android.gms.internal.ads;

import com.tapjoy.TJAdUnitConstants;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaqi {
    private final zzbeb zzdjd;
    private final boolean zzdpv;
    private final String zzdpw;

    public zzaqi(zzbeb zzbebVar, Map<String, String> map) {
        this.zzdjd = zzbebVar;
        this.zzdpw = map.get("forceOrientation");
        if (map.containsKey("allowOrientationChange")) {
            this.zzdpv = Boolean.parseBoolean(map.get("allowOrientationChange"));
        } else {
            this.zzdpv = true;
        }
    }

    public final void execute() {
        int zzzc;
        if (this.zzdjd == null) {
            zzazk.zzex("AdWebView is null");
            return;
        }
        if (TJAdUnitConstants.String.PORTRAIT.equalsIgnoreCase(this.zzdpw)) {
            zzzc = 7;
        } else if (TJAdUnitConstants.String.LANDSCAPE.equalsIgnoreCase(this.zzdpw)) {
            zzzc = 6;
        } else {
            zzzc = this.zzdpv ? -1 : com.google.android.gms.ads.internal.zzr.zzkt().zzzc();
        }
        this.zzdjd.setRequestedOrientation(zzzc);
    }
}
