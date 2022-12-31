package com.google.android.gms.internal.measurement;

import android.util.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzfb extends zzfg<Boolean> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfb(zzfe zzfeVar, String str, Boolean bool, boolean z) {
        super(zzfeVar, str, bool, true, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzfg
    final /* bridge */ /* synthetic */ Boolean zza(Object obj) {
        if (zzei.zzc.matcher(obj).matches()) {
            return Boolean.TRUE;
        }
        if (zzei.zzd.matcher(obj).matches()) {
            return Boolean.FALSE;
        }
        String zzd = super.zzd();
        String str = (String) obj;
        StringBuilder sb = new StringBuilder(String.valueOf(zzd).length() + 28 + str.length());
        sb.append("Invalid boolean value for ");
        sb.append(zzd);
        sb.append(": ");
        sb.append(str);
        Log.e("PhenotypeFlag", sb.toString());
        return null;
    }
}
