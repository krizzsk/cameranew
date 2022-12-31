package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzabd extends zzaba<Boolean> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzabd(int i2, String str, Boolean bool) {
        super(i2, str, bool, null);
    }

    @Override // com.google.android.gms.internal.ads.zzaba
    public final /* synthetic */ Boolean zza(Bundle bundle) {
        String valueOf = String.valueOf(getKey());
        if (bundle.containsKey(valueOf.length() != 0 ? "com.google.android.gms.ads.flag.".concat(valueOf) : new String("com.google.android.gms.ads.flag."))) {
            String valueOf2 = String.valueOf(getKey());
            return Boolean.valueOf(bundle.getBoolean(valueOf2.length() != 0 ? "com.google.android.gms.ads.flag.".concat(valueOf2) : new String("com.google.android.gms.ads.flag.")));
        }
        return zzsb();
    }

    @Override // com.google.android.gms.internal.ads.zzaba
    public final /* synthetic */ Boolean zzb(JSONObject jSONObject) {
        return Boolean.valueOf(jSONObject.optBoolean(getKey(), zzsb().booleanValue()));
    }

    @Override // com.google.android.gms.internal.ads.zzaba
    public final /* synthetic */ void zza(SharedPreferences.Editor editor, Boolean bool) {
        editor.putBoolean(getKey(), bool.booleanValue());
    }

    @Override // com.google.android.gms.internal.ads.zzaba
    public final /* synthetic */ Boolean zza(SharedPreferences sharedPreferences) {
        return Boolean.valueOf(sharedPreferences.getBoolean(getKey(), zzsb().booleanValue()));
    }
}
