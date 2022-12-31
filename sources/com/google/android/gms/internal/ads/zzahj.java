package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.tapjoy.TJAdUnitConstants;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzahj implements zzaif<Object> {
    private final zzahi zzdgz;

    public zzahj(zzahi zzahiVar) {
        this.zzdgz = zzahiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaif
    public final void zza(Object obj, Map<String, String> map) {
        if (this.zzdgz == null) {
            return;
        }
        String str = map.get("name");
        if (str == null) {
            zzazk.zzew("Ad metadata with no name parameter.");
            str = "";
        }
        Bundle bundle = null;
        if (map.containsKey(TJAdUnitConstants.String.VIDEO_INFO)) {
            try {
                bundle = com.google.android.gms.ads.internal.util.zzbh.zzh(new JSONObject(map.get(TJAdUnitConstants.String.VIDEO_INFO)));
            } catch (JSONException e2) {
                zzazk.zzc("Failed to convert ad metadata to JSON.", e2);
            }
        }
        if (bundle == null) {
            zzazk.zzev("Failed to convert ad metadata to Bundle.");
        } else {
            this.zzdgz.zza(str, bundle);
        }
    }
}
