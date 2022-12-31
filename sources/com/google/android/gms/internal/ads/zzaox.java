package com.google.android.gms.internal.ads;

import com.google.ads.AdRequest$ErrorCode;
import com.google.ads.AdRequest$Gender;
import com.google.ads.mediation.a;
import java.util.Date;
import java.util.HashSet;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaox {
    public static int zza(AdRequest$ErrorCode adRequest$ErrorCode) {
        int i2 = zzaow.zzdok[adRequest$ErrorCode.ordinal()];
        if (i2 != 2) {
            if (i2 != 3) {
                return i2 != 4 ? 0 : 3;
            }
            return 2;
        }
        return 1;
    }

    public static a zza(zzvl zzvlVar, boolean z) {
        AdRequest$Gender adRequest$Gender;
        HashSet hashSet = zzvlVar.zzchp != null ? new HashSet(zzvlVar.zzchp) : null;
        Date date = new Date(zzvlVar.zzchn);
        int i2 = zzvlVar.zzcho;
        if (i2 == 1) {
            adRequest$Gender = AdRequest$Gender.MALE;
        } else if (i2 != 2) {
            adRequest$Gender = AdRequest$Gender.UNKNOWN;
        } else {
            adRequest$Gender = AdRequest$Gender.FEMALE;
        }
        return new a(date, adRequest$Gender, hashSet, z, zzvlVar.zznb);
    }
}
