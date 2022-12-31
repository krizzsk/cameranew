package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzdr extends zzho<zzds, zzdr> implements zziy {
    private zzdr() {
        super(zzds.zzg());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzdr(zzcs zzcsVar) {
        super(zzds.zzg());
    }

    public final zzdr zza(int i2) {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zzds.zzh((zzds) this.zza, i2);
        return this;
    }

    public final zzdr zzb(Iterable<? extends Long> iterable) {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zzds.zzi((zzds) this.zza, iterable);
        return this;
    }
}
