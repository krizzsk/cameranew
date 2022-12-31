package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzabc extends zzaba<Integer> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzabc(int i2, String str, Integer num) {
        super(1, str, num, null);
    }

    @Override // com.google.android.gms.internal.ads.zzaba
    public final /* synthetic */ Integer zza(Bundle bundle) {
        String valueOf = String.valueOf(getKey());
        if (bundle.containsKey(valueOf.length() != 0 ? "com.google.android.gms.ads.flag.".concat(valueOf) : new String("com.google.android.gms.ads.flag."))) {
            String valueOf2 = String.valueOf(getKey());
            return Integer.valueOf(bundle.getInt(valueOf2.length() != 0 ? "com.google.android.gms.ads.flag.".concat(valueOf2) : new String("com.google.android.gms.ads.flag.")));
        }
        return zzsb();
    }

    @Override // com.google.android.gms.internal.ads.zzaba
    public final /* synthetic */ Integer zzb(JSONObject jSONObject) {
        return Integer.valueOf(jSONObject.optInt(getKey(), zzsb().intValue()));
    }

    @Override // com.google.android.gms.internal.ads.zzaba
    public final /* synthetic */ void zza(SharedPreferences.Editor editor, Integer num) {
        editor.putInt(getKey(), num.intValue());
    }

    @Override // com.google.android.gms.internal.ads.zzaba
    public final /* synthetic */ Integer zza(SharedPreferences sharedPreferences) {
        return Integer.valueOf(sharedPreferences.getInt(getKey(), zzsb().intValue()));
    }
}
