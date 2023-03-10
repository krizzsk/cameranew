package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegd;
import java.security.GeneralSecurityException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzebw extends zzeax<zzeeg> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzebw() {
        super(zzeeg.class, new zzebz(zzeio.class));
    }

    public static void zza(zzeeg zzeegVar) throws GeneralSecurityException {
        zzeiv.zzz(zzeegVar.getVersion(), 0);
        zzeiv.zzfu(zzeegVar.zzbbe().size());
        zza(zzeegVar.zzbbt());
    }

    @Override // com.google.android.gms.internal.ads.zzeax
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesCtrKey";
    }

    @Override // com.google.android.gms.internal.ads.zzeax
    public final zzegd.zza zzbal() {
        return zzegd.zza.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.ads.zzeax
    public final zzeba<?, zzeeg> zzbao() {
        return new zzeby(this, zzeej.class);
    }

    @Override // com.google.android.gms.internal.ads.zzeax
    public final /* synthetic */ void zzc(zzeeg zzeegVar) throws GeneralSecurityException {
        zza(zzeegVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeax
    public final /* synthetic */ zzeeg zzp(zzejr zzejrVar) throws zzelo {
        return zzeeg.zzg(zzejrVar, zzeko.zzbhw());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(zzeek zzeekVar) throws GeneralSecurityException {
        if (zzeekVar.zzbbz() < 12 || zzeekVar.zzbbz() > 16) {
            throw new GeneralSecurityException("invalid IV size");
        }
    }
}
