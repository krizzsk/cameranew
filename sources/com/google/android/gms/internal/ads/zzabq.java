package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzabq {
    private static void zza(List<String> list, zzacx<String> zzacxVar) {
        String str = zzacxVar.get();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        list.add(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<String> zzsg() {
        ArrayList arrayList = new ArrayList();
        zza(arrayList, zzacx.zzh("gad:dynamite_module:experiment_id", ""));
        zza(arrayList, zzadg.zzddj);
        zza(arrayList, zzadg.zzddk);
        zza(arrayList, zzadg.zzddl);
        zza(arrayList, zzadg.zzddm);
        zza(arrayList, zzadg.zzddn);
        zza(arrayList, zzadg.zzddt);
        zza(arrayList, zzadg.zzddo);
        zza(arrayList, zzadg.zzddp);
        zza(arrayList, zzadg.zzddq);
        zza(arrayList, zzadg.zzddr);
        zza(arrayList, zzadg.zzdds);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<String> zzsh() {
        ArrayList arrayList = new ArrayList();
        zza(arrayList, zzadt.zzdey);
        return arrayList;
    }
}
