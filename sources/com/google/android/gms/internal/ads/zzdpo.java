package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdpo implements zzdpl {
    private final Object[] zzhok;

    public zzdpo(zzvl zzvlVar, String str, int i2, String str2, zzvx zzvxVar) {
        HashSet hashSet = new HashSet(Arrays.asList(str2.split(",")));
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        arrayList.add(str);
        if (hashSet.contains("networkType")) {
            arrayList.add(Integer.valueOf(i2));
        }
        if (hashSet.contains("birthday")) {
            arrayList.add(Long.valueOf(zzvlVar.zzchn));
        }
        if (hashSet.contains("extras")) {
            arrayList.add(zzp(zzvlVar.extras));
        } else if (hashSet.contains("npa")) {
            arrayList.add(zzvlVar.extras.getString("npa"));
        }
        if (hashSet.contains("gender")) {
            arrayList.add(Integer.valueOf(zzvlVar.zzcho));
        }
        if (hashSet.contains("keywords")) {
            List<String> list = zzvlVar.zzchp;
            if (list != null) {
                arrayList.add(list.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("isTestDevice")) {
            arrayList.add(Boolean.valueOf(zzvlVar.zzchq));
        }
        if (hashSet.contains("tagForChildDirectedTreatment")) {
            arrayList.add(Integer.valueOf(zzvlVar.zzado));
        }
        if (hashSet.contains("manualImpressionsEnabled")) {
            arrayList.add(Boolean.valueOf(zzvlVar.zzbni));
        }
        if (hashSet.contains("publisherProvidedId")) {
            arrayList.add(zzvlVar.zzchr);
        }
        if (hashSet.contains(FirebaseAnalytics.Param.LOCATION)) {
            Location location = zzvlVar.zznb;
            if (location != null) {
                arrayList.add(location.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("contentUrl")) {
            arrayList.add(zzvlVar.zzcht);
        }
        if (hashSet.contains("networkExtras")) {
            arrayList.add(zzp(zzvlVar.zzchu));
        }
        if (hashSet.contains("customTargeting")) {
            arrayList.add(zzp(zzvlVar.zzchv));
        }
        if (hashSet.contains("categoryExclusions")) {
            List<String> list2 = zzvlVar.zzchw;
            if (list2 != null) {
                arrayList.add(list2.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("requestAgent")) {
            arrayList.add(zzvlVar.zzchx);
        }
        if (hashSet.contains("requestPackage")) {
            arrayList.add(zzvlVar.zzchy);
        }
        if (hashSet.contains("isDesignedForFamilies")) {
            arrayList.add(Boolean.valueOf(zzvlVar.zzchz));
        }
        if (hashSet.contains("tagForUnderAgeOfConsent")) {
            arrayList.add(Integer.valueOf(zzvlVar.zzadp));
        }
        if (hashSet.contains("maxAdContentRating")) {
            arrayList.add(zzvlVar.zzadq);
        }
        if (hashSet.contains("orientation")) {
            if (zzvxVar != null) {
                arrayList.add(Integer.valueOf(zzvxVar.orientation));
            } else {
                arrayList.add(null);
            }
        }
        this.zzhok = arrayList.toArray();
    }

    private static String zzp(@Nullable Bundle bundle) {
        String obj;
        if (bundle == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = new TreeSet(bundle.keySet()).iterator();
        while (it.hasNext()) {
            Object obj2 = bundle.get((String) it.next());
            if (obj2 == null) {
                obj = "null";
            } else if (obj2 instanceof Bundle) {
                obj = zzp((Bundle) obj2);
            } else {
                obj = obj2.toString();
            }
            sb.append(obj);
        }
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzdpl
    public final boolean equals(Object obj) {
        if (obj instanceof zzdpo) {
            return Arrays.equals(this.zzhok, ((zzdpo) obj).zzhok);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzdpl
    public final int hashCode() {
        return Arrays.hashCode(this.zzhok);
    }

    public final String toString() {
        int hashCode = hashCode();
        String arrays = Arrays.toString(this.zzhok);
        StringBuilder sb = new StringBuilder(String.valueOf(arrays).length() + 22);
        sb.append("[PoolKey#");
        sb.append(hashCode);
        sb.append(" ");
        sb.append(arrays);
        sb.append("]");
        return sb.toString();
    }
}
