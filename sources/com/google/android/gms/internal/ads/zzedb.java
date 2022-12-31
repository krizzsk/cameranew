package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzedb extends zzeba<zzefj, zzefn> {
    private final /* synthetic */ zzecz zzidk;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzedb(zzecz zzeczVar, Class cls) {
        super(cls);
        this.zzidk = zzeczVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeba
    public final /* synthetic */ void zzd(zzefj zzefjVar) throws GeneralSecurityException {
        zzedh.zza(zzefjVar.zzbcu());
    }

    @Override // com.google.android.gms.internal.ads.zzeba
    public final /* synthetic */ zzefn zze(zzefj zzefjVar) throws GeneralSecurityException {
        zzefj zzefjVar2 = zzefjVar;
        KeyPair zza = zzehx.zza(zzehx.zza(zzedh.zza(zzefjVar2.zzbcu().zzbcw().zzbdj())));
        ECPoint w = ((ECPublicKey) zza.getPublic()).getW();
        return (zzefn) ((zzelb) zzefn.zzbdc().zzfe(0).zzb((zzefo) ((zzelb) zzefo.zzbdg().zzff(0).zzc(zzefjVar2.zzbcu()).zzac(zzejr.zzt(w.getAffineX().toByteArray())).zzad(zzejr.zzt(w.getAffineY().toByteArray())).zzbiw())).zzab(zzejr.zzt(((ECPrivateKey) zza.getPrivate()).getS().toByteArray())).zzbiw());
    }

    @Override // com.google.android.gms.internal.ads.zzeba
    public final /* synthetic */ zzefj zzr(zzejr zzejrVar) throws zzelo {
        return zzefj.zzq(zzejrVar, zzeko.zzbhw());
    }
}
