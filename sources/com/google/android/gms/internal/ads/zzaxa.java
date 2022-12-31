package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaxa implements SharedPreferences.OnSharedPreferenceChangeListener {
    @GuardedBy("AdMobPlusIdlessListener.class")
    private static zzaxa zzeau;
    private final SharedPreferences zzeav;
    private final com.google.android.gms.ads.internal.util.zzf zzeaw;
    private String zzeax = "";

    private zzaxa(Context context, com.google.android.gms.ads.internal.util.zzf zzfVar) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        this.zzeav = defaultSharedPreferences;
        this.zzeaw = zzfVar;
        defaultSharedPreferences.registerOnSharedPreferenceChangeListener(this);
        onSharedPreferenceChanged(defaultSharedPreferences, "IABTCF_PurposeConsents");
    }

    public static synchronized zzaxa zza(Context context, com.google.android.gms.ads.internal.util.zzf zzfVar) {
        zzaxa zzaxaVar;
        synchronized (zzaxa.class) {
            if (zzeau == null) {
                zzeau = new zzaxa(context, zzfVar);
            }
            zzaxaVar = zzeau;
        }
        return zzaxaVar;
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if ("IABTCF_PurposeConsents".equals(str)) {
            String string = sharedPreferences.getString("IABTCF_PurposeConsents", "");
            if (string.isEmpty() || this.zzeax.equals(string)) {
                return;
            }
            this.zzeax = string;
            boolean z = string.charAt(0) != '1';
            if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcos)).booleanValue()) {
                this.zzeaw.zzar(z);
            }
            ((Boolean) zzwr.zzqr().zzd(zzabp.zzcor)).booleanValue();
        }
    }
}
