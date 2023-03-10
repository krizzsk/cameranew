package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegd;
import java.security.GeneralSecurityException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzebv extends zzeax<zzeec> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzebv() {
        super(zzeec.class, new zzebu(zzeaq.class));
    }

    @Override // com.google.android.gms.internal.ads.zzeax
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    }

    @Override // com.google.android.gms.internal.ads.zzeax
    public final zzegd.zza zzbal() {
        return zzegd.zza.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.ads.zzeax
    public final zzeba<?, zzeec> zzbao() {
        return new zzebx(this, zzeef.class);
    }

    @Override // com.google.android.gms.internal.ads.zzeax
    public final /* synthetic */ void zzc(zzeec zzeecVar) throws GeneralSecurityException {
        zzeec zzeecVar2 = zzeecVar;
        zzeiv.zzz(zzeecVar2.getVersion(), 0);
        new zzebw();
        zzebw.zza(zzeecVar2.zzbbm());
        new zzedn();
        zzedn.zza(zzeecVar2.zzbbn());
    }

    @Override // com.google.android.gms.internal.ads.zzeax
    public final /* synthetic */ zzeec zzp(zzejr zzejrVar) throws zzelo {
        return zzeec.zze(zzejrVar, zzeko.zzbhw());
    }
}
