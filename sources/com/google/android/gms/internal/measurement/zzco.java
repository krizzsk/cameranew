package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzco extends zzho<zzcp, zzco> implements zziy {
    private zzco() {
        super(zzcp.zzm());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzco(zzcl zzclVar) {
        super(zzcp.zzm());
    }

    public final int zza() {
        return ((zzcp) this.zza).zzf();
    }

    public final zzcn zzb(int i2) {
        return ((zzcp) this.zza).zzg(i2);
    }

    public final zzco zzc(int i2, zzcm zzcmVar) {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zzcp.zzn((zzcp) this.zza, i2, zzcmVar.zzaA());
        return this;
    }

    public final List<zzbu> zzd() {
        return Collections.unmodifiableList(((zzcp) this.zza).zzh());
    }

    public final zzco zze() {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zzcp.zzo((zzcp) this.zza);
        return this;
    }
}
