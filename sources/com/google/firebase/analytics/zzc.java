package com.google.firebase.analytics;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.measurement.internal.p5;
import com.google.android.gms.measurement.internal.q5;
import com.google.android.gms.measurement.internal.s6;
import java.util.List;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-measurement-api@@18.0.2 */
/* loaded from: classes2.dex */
final class zzc implements s6 {
    final /* synthetic */ zzbr zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzc(zzbr zzbrVar) {
        this.zza = zzbrVar;
    }

    @Override // com.google.android.gms.measurement.internal.s6
    public final void zza(String str, String str2, Bundle bundle) {
        this.zza.zzh(str, str2, bundle);
    }

    public final void zzb(String str, String str2, Bundle bundle, long j2) {
        this.zza.zzi(str, str2, bundle, j2);
    }

    @Override // com.google.android.gms.measurement.internal.s6
    public final Map<String, Object> zzc(@Nullable String str, @Nullable String str2, boolean z) {
        return this.zza.zzB(str, str2, z);
    }

    public final void zzd(p5 p5Var) {
        this.zza.zzd(p5Var);
    }

    public final void zze(q5 q5Var) {
        this.zza.zze(q5Var);
    }

    public final void zzf(q5 q5Var) {
        this.zza.zzf(q5Var);
    }

    @Override // com.google.android.gms.measurement.internal.s6
    public final String zzg() {
        return this.zza.zzz();
    }

    @Override // com.google.android.gms.measurement.internal.s6
    public final String zzh() {
        return this.zza.zzA();
    }

    @Override // com.google.android.gms.measurement.internal.s6
    public final String zzi() {
        return this.zza.zzx();
    }

    @Override // com.google.android.gms.measurement.internal.s6
    public final String zzj() {
        return this.zza.zzw();
    }

    @Override // com.google.android.gms.measurement.internal.s6
    public final long zzk() {
        return this.zza.zzy();
    }

    @Override // com.google.android.gms.measurement.internal.s6
    public final void zzl(String str) {
        this.zza.zzu(str);
    }

    @Override // com.google.android.gms.measurement.internal.s6
    public final void zzm(String str) {
        this.zza.zzv(str);
    }

    @Override // com.google.android.gms.measurement.internal.s6
    public final void zzn(Bundle bundle) {
        this.zza.zzk(bundle);
    }

    @Override // com.google.android.gms.measurement.internal.s6
    public final void zzo(String str, @Nullable String str2, @Nullable Bundle bundle) {
        this.zza.zzl(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.s6
    public final List<Bundle> zzp(@Nullable String str, @Nullable String str2) {
        return this.zza.zzm(str, str2);
    }

    @Override // com.google.android.gms.measurement.internal.s6
    public final int zzq(String str) {
        return this.zza.zzE(str);
    }

    public final Object zzr(int i2) {
        return this.zza.zzH(i2);
    }
}
