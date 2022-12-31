package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzece extends zzeba<zzeev, zzees> {
    private final /* synthetic */ zzecc zzicy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzece(zzecc zzeccVar, Class cls) {
        super(cls);
        this.zzicy = zzeccVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeba
    public final /* synthetic */ void zzd(zzeev zzeevVar) throws GeneralSecurityException {
        zzeiv.zzfu(zzeevVar.getKeySize());
    }

    @Override // com.google.android.gms.internal.ads.zzeba
    public final /* synthetic */ zzees zze(zzeev zzeevVar) throws GeneralSecurityException {
        return (zzees) ((zzelb) zzees.zzbci().zzw(zzejr.zzt(zzeiu.zzft(zzeevVar.getKeySize()))).zzfa(0).zzbiw());
    }

    @Override // com.google.android.gms.internal.ads.zzeba
    public final /* synthetic */ zzeev zzr(zzejr zzejrVar) throws zzelo {
        return zzeev.zzl(zzejrVar, zzeko.zzbhw());
    }
}
