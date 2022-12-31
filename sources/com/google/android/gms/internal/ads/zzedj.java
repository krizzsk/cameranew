package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeec;
import java.security.GeneralSecurityException;
import java.util.Arrays;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzedj implements zzehr {
    private final String zzido;
    private final int zzidp;
    private zzees zzidq;
    private zzeec zzidr;
    private int zzids;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzedj(zzegg zzeggVar) throws GeneralSecurityException {
        String zzbdx = zzeggVar.zzbdx();
        this.zzido = zzbdx;
        if (zzbdx.equals(zzebs.zzick)) {
            try {
                zzeev zzl = zzeev.zzl(zzeggVar.zzbdy(), zzeko.zzbhw());
                this.zzidq = (zzees) zzebm.zzb(zzeggVar);
                this.zzidp = zzl.getKeySize();
            } catch (zzelo e2) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", e2);
            }
        } else if (zzbdx.equals(zzebs.zzicj)) {
            try {
                zzeef zzf = zzeef.zzf(zzeggVar.zzbdy(), zzeko.zzbhw());
                this.zzidr = (zzeec) zzebm.zzb(zzeggVar);
                this.zzids = zzf.zzbbq().getKeySize();
                this.zzidp = this.zzids + zzf.zzbbr().getKeySize();
            } catch (zzelo e3) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e3);
            }
        } else {
            String valueOf = String.valueOf(zzbdx);
            throw new GeneralSecurityException(valueOf.length() != 0 ? "unsupported AEAD DEM key type: ".concat(valueOf) : new String("unsupported AEAD DEM key type: "));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzehr
    public final int zzbbd() {
        return this.zzidp;
    }

    @Override // com.google.android.gms.internal.ads.zzehr
    public final zzeaq zzm(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length == this.zzidp) {
            if (this.zzido.equals(zzebs.zzick)) {
                return (zzeaq) zzebm.zza(this.zzido, (zzees) ((zzelb) zzees.zzbci().zza(this.zzidq).zzw(zzejr.zzi(bArr, 0, this.zzidp)).zzbiw()), zzeaq.class);
            } else if (this.zzido.equals(zzebs.zzicj)) {
                byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, this.zzids);
                byte[] copyOfRange2 = Arrays.copyOfRange(bArr, this.zzids, this.zzidp);
                zzeec.zza zzc = zzeec.zzbbo().zzex(this.zzidr.getVersion()).zzc((zzeeg) ((zzelb) zzeeg.zzbbu().zza(this.zzidr.zzbbm()).zzu(zzejr.zzt(copyOfRange)).zzbiw()));
                return (zzeaq) zzebm.zza(this.zzido, (zzeec) ((zzelb) zzc.zzc((zzefv) ((zzelb) zzefv.zzbdp().zza(this.zzidr.zzbbn()).zzae(zzejr.zzt(copyOfRange2)).zzbiw())).zzbiw()), zzeaq.class);
            } else {
                throw new GeneralSecurityException("unknown DEM key type");
            }
        }
        throw new GeneralSecurityException("Symmetric key has incorrect length");
    }
}
