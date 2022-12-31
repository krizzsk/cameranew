package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzabe extends zzaba<Float> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzabe(int i2, String str, Float f2) {
        super(1, str, f2, null);
    }

    @Override // com.google.android.gms.internal.ads.zzaba
    public final /* synthetic */ Float zza(Bundle bundle) {
        String valueOf = String.valueOf(getKey());
        if (bundle.containsKey(valueOf.length() != 0 ? "com.google.android.gms.ads.flag.".concat(valueOf) : new String("com.google.android.gms.ads.flag."))) {
            String valueOf2 = String.valueOf(getKey());
            return Float.valueOf(bundle.getFloat(valueOf2.length() != 0 ? "com.google.android.gms.ads.flag.".concat(valueOf2) : new String("com.google.android.gms.ads.flag.")));
        }
        return zzsb();
    }

    @Override // com.google.android.gms.internal.ads.zzaba
    public final /* synthetic */ Float zzb(JSONObject jSONObject) {
        return Float.valueOf((float) jSONObject.optDouble(getKey(), zzsb().floatValue()));
    }

    @Override // com.google.android.gms.internal.ads.zzaba
    public final /* synthetic */ void zza(SharedPreferences.Editor editor, Float f2) {
        editor.putFloat(getKey(), f2.floatValue());
    }

    @Override // com.google.android.gms.internal.ads.zzaba
    public final /* synthetic */ Float zza(SharedPreferences sharedPreferences) {
        return Float.valueOf(sharedPreferences.getFloat(getKey(), zzsb().floatValue()));
    }
}
