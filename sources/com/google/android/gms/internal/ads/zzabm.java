package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzabm implements zzadx {
    private final /* synthetic */ zzabl zzcmh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzabm(zzabl zzablVar) {
        this.zzcmh = zzablVar;
    }

    @Override // com.google.android.gms.internal.ads.zzadx
    public final String get(String str, String str2) {
        SharedPreferences sharedPreferences;
        sharedPreferences = this.zzcmh.zzcme;
        return sharedPreferences.getString(str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzadx
    public final Long getLong(String str, long j2) {
        SharedPreferences sharedPreferences;
        SharedPreferences sharedPreferences2;
        try {
            sharedPreferences2 = this.zzcmh.zzcme;
            return Long.valueOf(sharedPreferences2.getLong(str, j2));
        } catch (ClassCastException unused) {
            sharedPreferences = this.zzcmh.zzcme;
            return Long.valueOf(sharedPreferences.getInt(str, (int) j2));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadx
    public final Double zza(String str, double d2) {
        SharedPreferences sharedPreferences;
        sharedPreferences = this.zzcmh.zzcme;
        return Double.valueOf(sharedPreferences.getFloat(str, (float) d2));
    }

    @Override // com.google.android.gms.internal.ads.zzadx
    public final Boolean zzf(String str, boolean z) {
        SharedPreferences sharedPreferences;
        sharedPreferences = this.zzcmh.zzcme;
        return Boolean.valueOf(sharedPreferences.getBoolean(str, z));
    }
}
