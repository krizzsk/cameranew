package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes2.dex */
final class zzgu extends zzgv {
    private final byte[] zza;
    private int zzb;
    private int zzc;
    private int zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzgu(byte[] bArr, int i2, int i3, boolean z, zzgt zzgtVar) {
        super(null);
        this.zzd = Integer.MAX_VALUE;
        this.zza = bArr;
        this.zzb = 0;
    }

    public final int zza(int i2) throws zzic {
        int i3 = this.zzd;
        this.zzd = 0;
        int i4 = this.zzb + this.zzc;
        this.zzb = i4;
        if (i4 > 0) {
            this.zzc = i4;
            this.zzb = 0;
        } else {
            this.zzc = 0;
        }
        return i3;
    }
}
