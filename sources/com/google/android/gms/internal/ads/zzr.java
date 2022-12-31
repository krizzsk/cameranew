package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzr implements zzak {
    private int zzab;
    private int zzac;
    private final int zzad;
    private final float zzae;

    public zzr() {
        this(2500, 1, 1.0f);
    }

    @Override // com.google.android.gms.internal.ads.zzak
    public final void zza(zzap zzapVar) throws zzap {
        int i2 = this.zzac + 1;
        this.zzac = i2;
        int i3 = this.zzab;
        this.zzab = i3 + ((int) (i3 * this.zzae));
        if (!(i2 <= this.zzad)) {
            throw zzapVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzak
    public final int zzb() {
        return this.zzab;
    }

    @Override // com.google.android.gms.internal.ads.zzak
    public final int zzc() {
        return this.zzac;
    }

    private zzr(int i2, int i3, float f2) {
        this.zzab = 2500;
        this.zzad = 1;
        this.zzae = 1.0f;
    }
}
