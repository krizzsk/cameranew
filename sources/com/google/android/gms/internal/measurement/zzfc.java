package com.google.android.gms.internal.measurement;

import android.util.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzfc extends zzfg<Double> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfc(zzfe zzfeVar, String str, Double d2, boolean z) {
        super(zzfeVar, "measurement.test.double_flag", d2, true, null);
    }

    @Override // com.google.android.gms.internal.measurement.zzfg
    final /* bridge */ /* synthetic */ Double zza(Object obj) {
        try {
            return Double.valueOf(Double.parseDouble((String) obj));
        } catch (NumberFormatException unused) {
            String zzd = super.zzd();
            String str = (String) obj;
            StringBuilder sb = new StringBuilder(String.valueOf(zzd).length() + 27 + str.length());
            sb.append("Invalid double value for ");
            sb.append(zzd);
            sb.append(": ");
            sb.append(str);
            Log.e("PhenotypeFlag", sb.toString());
            return null;
        }
    }
}
