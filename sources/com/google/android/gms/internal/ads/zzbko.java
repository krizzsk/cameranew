package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbko {
    @Nullable
    public static JSONObject zza(zzdmw zzdmwVar) {
        try {
            return new JSONObject(zzdmwVar.zzdwg);
        } catch (JSONException unused) {
            return null;
        }
    }
}
