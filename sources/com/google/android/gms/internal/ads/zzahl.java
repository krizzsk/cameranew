package com.google.android.gms.internal.ads;

import com.tapjoy.TJAdUnitConstants;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzahl implements zzaif<Object> {
    private final zzahk zzdha;

    public zzahl(zzahk zzahkVar) {
        this.zzdha = zzahkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaif
    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get("name");
        if (str == null) {
            zzazk.zzex("App event with no name parameter.");
        } else {
            this.zzdha.onAppEvent(str, map.get(TJAdUnitConstants.String.VIDEO_INFO));
        }
    }
}
