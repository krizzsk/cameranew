package com.google.android.gms.internal.measurement;

import java.io.IOException;
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes2.dex */
final class zzjy extends zzjw<zzjx, zzjx> {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzjw
    public final /* bridge */ /* synthetic */ void zza(zzjx zzjxVar, int i2, long j2) {
        zzjxVar.zzh(i2 << 3, Long.valueOf(j2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzjw
    public final /* bridge */ /* synthetic */ zzjx zzb() {
        return zzjx.zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzjw
    public final /* bridge */ /* synthetic */ void zzc(Object obj, zzjx zzjxVar) {
        ((zzhs) obj).zzc = zzjxVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzjw
    public final /* bridge */ /* synthetic */ zzjx zzd(Object obj) {
        return ((zzhs) obj).zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzjw
    public final void zze(Object obj) {
        ((zzhs) obj).zzc.zzd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzjw
    public final /* bridge */ /* synthetic */ zzjx zzf(zzjx zzjxVar, zzjx zzjxVar2) {
        zzjx zzjxVar3 = zzjxVar2;
        return zzjxVar3.equals(zzjx.zza()) ? zzjxVar : zzjx.zzc(zzjxVar, zzjxVar3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzjw
    public final /* bridge */ /* synthetic */ int zzg(zzjx zzjxVar) {
        return zzjxVar.zze();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzjw
    public final /* bridge */ /* synthetic */ int zzh(zzjx zzjxVar) {
        return zzjxVar.zzf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzjw
    public final /* bridge */ /* synthetic */ void zzi(zzjx zzjxVar, zzha zzhaVar) throws IOException {
        zzjxVar.zzi(zzhaVar);
    }
}
