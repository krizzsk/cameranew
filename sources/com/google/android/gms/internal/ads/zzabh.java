package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzabh extends zzaba<String> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzabh(int i2, String str, String str2) {
        super(1, str, str2, null);
    }

    @Override // com.google.android.gms.internal.ads.zzaba
    public final /* synthetic */ String zza(Bundle bundle) {
        String valueOf = String.valueOf(getKey());
        if (bundle.containsKey(valueOf.length() != 0 ? "com.google.android.gms.ads.flag.".concat(valueOf) : new String("com.google.android.gms.ads.flag."))) {
            String valueOf2 = String.valueOf(getKey());
            return bundle.getString(valueOf2.length() != 0 ? "com.google.android.gms.ads.flag.".concat(valueOf2) : new String("com.google.android.gms.ads.flag."));
        }
        return zzsb();
    }

    @Override // com.google.android.gms.internal.ads.zzaba
    public final /* synthetic */ String zzb(JSONObject jSONObject) {
        return jSONObject.optString(getKey(), zzsb());
    }

    @Override // com.google.android.gms.internal.ads.zzaba
    public final /* synthetic */ void zza(SharedPreferences.Editor editor, String str) {
        editor.putString(getKey(), str);
    }

    @Override // com.google.android.gms.internal.ads.zzaba
    public final /* synthetic */ String zza(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString(getKey(), zzsb());
    }
}
