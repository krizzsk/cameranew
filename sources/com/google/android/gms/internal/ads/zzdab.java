package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzug;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public class zzdab {
    private String zzgzy;

    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    public static class zza {
        private String zzgzy;

        public final zza zzgr(String str) {
            this.zzgzy = str;
            return this;
        }
    }

    private zzdab(zza zzaVar) {
        this.zzgzy = zzaVar.zzgzy;
    }

    public final Set<String> zzasv() {
        HashSet hashSet = new HashSet();
        hashSet.add(this.zzgzy.toLowerCase(Locale.ROOT));
        return hashSet;
    }

    public final String zzasw() {
        return this.zzgzy.toLowerCase(Locale.ROOT);
    }

    public final zzug.zza.EnumC0160zza zzasx() {
        String str = this.zzgzy;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1999289321:
                if (str.equals("NATIVE")) {
                    c = 0;
                    break;
                }
                break;
            case -1372958932:
                if (str.equals("INTERSTITIAL")) {
                    c = 1;
                    break;
                }
                break;
            case 543046670:
                if (str.equals("REWARDED")) {
                    c = 2;
                    break;
                }
                break;
            case 1951953708:
                if (str.equals("BANNER")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return zzug.zza.EnumC0160zza.AD_LOADER;
            case 1:
                return zzug.zza.EnumC0160zza.INTERSTITIAL;
            case 2:
                return zzug.zza.EnumC0160zza.REWARD_BASED_VIDEO_AD;
            case 3:
                return zzug.zza.EnumC0160zza.BANNER;
            default:
                return zzug.zza.EnumC0160zza.AD_INITIATER_UNSPECIFIED;
        }
    }
}
