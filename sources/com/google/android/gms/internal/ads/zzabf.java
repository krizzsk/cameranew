package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzabf extends zzaba<Long> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzabf(int i2, String str, Long l2) {
        super(1, str, l2, null);
    }

    @Override // com.google.android.gms.internal.ads.zzaba
    public final /* synthetic */ Long zza(Bundle bundle) {
        String valueOf = String.valueOf(getKey());
        if (bundle.containsKey(valueOf.length() != 0 ? "com.google.android.gms.ads.flag.".concat(valueOf) : new String("com.google.android.gms.ads.flag."))) {
            String valueOf2 = String.valueOf(getKey());
            return Long.valueOf(bundle.getLong(valueOf2.length() != 0 ? "com.google.android.gms.ads.flag.".concat(valueOf2) : new String("com.google.android.gms.ads.flag.")));
        }
        return zzsb();
    }

    @Override // com.google.android.gms.internal.ads.zzaba
    public final /* synthetic */ Long zzb(JSONObject jSONObject) {
        return Long.valueOf(jSONObject.optLong(getKey(), zzsb().longValue()));
    }

    @Override // com.google.android.gms.internal.ads.zzaba
    public final /* synthetic */ void zza(SharedPreferences.Editor editor, Long l2) {
        editor.putLong(getKey(), l2.longValue());
    }

    @Override // com.google.android.gms.internal.ads.zzaba
    public final /* synthetic */ Long zza(SharedPreferences sharedPreferences) {
        return Long.valueOf(sharedPreferences.getLong(getKey(), zzsb().longValue()));
    }
}
