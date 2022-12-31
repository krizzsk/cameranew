package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes2.dex */
public class zzgq extends zzgp {
    protected final byte[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgq(byte[] bArr) {
        Objects.requireNonNull(bArr);
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.measurement.zzgs
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzgs) && zzc() == ((zzgs) obj).zzc()) {
            if (zzc() == 0) {
                return true;
            }
            if (obj instanceof zzgq) {
                zzgq zzgqVar = (zzgq) obj;
                int zzm = zzm();
                int zzm2 = zzgqVar.zzm();
                if (zzm == 0 || zzm2 == 0 || zzm == zzm2) {
                    int zzc = zzc();
                    if (zzc <= zzgqVar.zzc()) {
                        if (zzc <= zzgqVar.zzc()) {
                            if (zzgqVar instanceof zzgq) {
                                byte[] bArr = this.zza;
                                byte[] bArr2 = zzgqVar.zza;
                                zzgqVar.zzd();
                                int i2 = 0;
                                int i3 = 0;
                                while (i2 < zzc) {
                                    if (bArr[i2] != bArr2[i3]) {
                                        return false;
                                    }
                                    i2++;
                                    i3++;
                                }
                                return true;
                            }
                            return zzgqVar.zze(0, zzc).equals(zze(0, zzc));
                        }
                        int zzc2 = zzgqVar.zzc();
                        StringBuilder sb = new StringBuilder(59);
                        sb.append("Ran off end of other: 0, ");
                        sb.append(zzc);
                        sb.append(", ");
                        sb.append(zzc2);
                        throw new IllegalArgumentException(sb.toString());
                    }
                    int zzc3 = zzc();
                    StringBuilder sb2 = new StringBuilder(40);
                    sb2.append("Length too large: ");
                    sb2.append(zzc);
                    sb2.append(zzc3);
                    throw new IllegalArgumentException(sb2.toString());
                }
                return false;
            }
            return obj.equals(this);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzgs
    public byte zza(int i2) {
        return this.zza[i2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzgs
    public byte zzb(int i2) {
        return this.zza[i2];
    }

    @Override // com.google.android.gms.internal.measurement.zzgs
    public int zzc() {
        return this.zza.length;
    }

    protected int zzd() {
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzgs
    public final zzgs zze(int i2, int i3) {
        int zzn = zzgs.zzn(0, i3, zzc());
        return zzn == 0 ? zzgs.zzb : new zzgm(this.zza, 0, zzn);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzgs
    public final void zzf(zzgh zzghVar) throws IOException {
        ((zzgx) zzghVar).zzp(this.zza, 0, zzc());
    }

    @Override // com.google.android.gms.internal.measurement.zzgs
    protected final String zzg(Charset charset) {
        return new String(this.zza, 0, zzc(), charset);
    }

    @Override // com.google.android.gms.internal.measurement.zzgs
    public final boolean zzh() {
        return zzkn.zzb(this.zza, 0, zzc());
    }

    @Override // com.google.android.gms.internal.measurement.zzgs
    protected final int zzi(int i2, int i3, int i4) {
        return zzia.zzh(i2, this.zza, 0, i4);
    }
}
