package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzaba<T> {
    private final int zzclu;
    private final T zzclv;
    private final String zzcm;

    private zzaba(int i2, String str, T t) {
        this.zzclu = i2;
        this.zzcm = str;
        this.zzclv = t;
        zzwr.zzqq().zza(this);
    }

    public static zzaba<Boolean> zza(int i2, String str, Boolean bool) {
        return new zzabd(i2, str, bool);
    }

    public static zzaba<Long> zzb(int i2, String str, long j2) {
        return new zzabf(1, str, Long.valueOf(j2));
    }

    public final String getKey() {
        return this.zzcm;
    }

    public final int getSource() {
        return this.zzclu;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract T zza(SharedPreferences sharedPreferences);

    public abstract T zza(Bundle bundle);

    public abstract void zza(SharedPreferences.Editor editor, T t);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract T zzb(JSONObject jSONObject);

    public final T zzsb() {
        return this.zzclv;
    }

    public static zzaba<Integer> zza(int i2, String str, int i3) {
        return new zzabc(1, str, Integer.valueOf(i3));
    }

    public static zzaba<String> zzb(int i2, String str) {
        zzaba<String> zza = zza(1, str, (String) null);
        zzwr.zzqq().zzc(zza);
        return zza;
    }

    public static zzaba<Float> zza(int i2, String str, float f2) {
        return new zzabe(1, str, Float.valueOf(0.0f));
    }

    public static zzaba<String> zza(int i2, String str, String str2) {
        return new zzabh(1, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzaba(int i2, String str, Object obj, zzabd zzabdVar) {
        this(i2, str, obj);
    }
}
