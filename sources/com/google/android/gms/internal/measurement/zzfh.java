package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import java.util.Iterator;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzfh implements zzer {
    @GuardedBy("SharedPreferencesLoader.class")
    private static final Map<String, zzfh> zza = new ArrayMap();
    private final SharedPreferences zzb;
    private final SharedPreferences.OnSharedPreferenceChangeListener zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzfh zza(Context context, String str) {
        zzfh zzfhVar;
        if (!zzej.zza()) {
            synchronized (zzfh.class) {
                zzfhVar = zza.get(null);
                if (zzfhVar == null) {
                    StrictMode.allowThreadDiskReads();
                    throw null;
                }
            }
            return zzfhVar;
        }
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void zzb() {
        synchronized (zzfh.class) {
            Map<String, zzfh> map = zza;
            Iterator<zzfh> it = map.values().iterator();
            if (!it.hasNext()) {
                map.clear();
            } else {
                zzfh next = it.next();
                SharedPreferences sharedPreferences = next.zzb;
                SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = next.zzc;
                throw null;
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzer
    public final Object zze(String str) {
        throw null;
    }
}
