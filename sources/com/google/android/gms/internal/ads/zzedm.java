package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegd;
import java.security.GeneralSecurityException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzedm extends zzeax<zzedx> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzedm() {
        super(zzedx.class, new zzedl(zzebd.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(zzeeb zzeebVar) throws GeneralSecurityException {
        if (zzeebVar.zzbbj() >= 10) {
            if (zzeebVar.zzbbj() > 16) {
                throw new GeneralSecurityException("tag size too long");
            }
            return;
        }
        throw new GeneralSecurityException("tag size too short");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzeu(int i2) throws GeneralSecurityException {
        if (i2 != 32) {
            throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeax
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesCmacKey";
    }

    @Override // com.google.android.gms.internal.ads.zzeax
    public final zzegd.zza zzbal() {
        return zzegd.zza.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.ads.zzeax
    public final zzeba<?, zzedx> zzbao() {
        return new zzedo(this, zzedy.class);
    }

    @Override // com.google.android.gms.internal.ads.zzeax
    public final /* synthetic */ void zzc(zzedx zzedxVar) throws GeneralSecurityException {
        zzedx zzedxVar2 = zzedxVar;
        zzeiv.zzz(zzedxVar2.getVersion(), 0);
        zzeu(zzedxVar2.zzbbe().size());
        zza(zzedxVar2.zzbbf());
    }

    @Override // com.google.android.gms.internal.ads.zzeax
    public final /* synthetic */ zzedx zzp(zzejr zzejrVar) throws zzelo {
        return zzedx.zzc(zzejrVar, zzeko.zzbhw());
    }
}
