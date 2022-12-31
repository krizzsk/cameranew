package com.google.android.gms.internal.measurement;

import android.util.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzfa extends zzfg<Long> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfa(zzfe zzfeVar, String str, Long l2, boolean z) {
        super(zzfeVar, str, l2, true, null);
    }

    @Override // com.google.android.gms.internal.measurement.zzfg
    final /* bridge */ /* synthetic */ Long zza(Object obj) {
        try {
            return Long.valueOf(Long.parseLong((String) obj));
        } catch (NumberFormatException unused) {
            String zzd = super.zzd();
            String str = (String) obj;
            StringBuilder sb = new StringBuilder(String.valueOf(zzd).length() + 25 + str.length());
            sb.append("Invalid long value for ");
            sb.append(zzd);
            sb.append(": ");
            sb.append(str);
            Log.e("PhenotypeFlag", sb.toString());
            return null;
        }
    }
}
