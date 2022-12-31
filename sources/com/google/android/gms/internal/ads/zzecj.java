package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzecj extends zzeba<zzeez, zzeew> {
    private final /* synthetic */ zzech zzicz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzecj(zzech zzechVar, Class cls) {
        super(cls);
        this.zzicz = zzechVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeba
    public final /* synthetic */ void zzd(zzeez zzeezVar) throws GeneralSecurityException {
        zzeiv.zzfu(zzeezVar.getKeySize());
    }

    @Override // com.google.android.gms.internal.ads.zzeba
    public final /* synthetic */ zzeew zze(zzeez zzeezVar) throws GeneralSecurityException {
        return (zzeew) ((zzelb) zzeew.zzbcl().zzx(zzejr.zzt(zzeiu.zzft(zzeezVar.getKeySize()))).zzfb(0).zzbiw());
    }

    @Override // com.google.android.gms.internal.ads.zzeba
    public final /* synthetic */ zzeez zzr(zzejr zzejrVar) throws zzelo {
        return zzeez.zzn(zzejrVar, zzeko.zzbhw());
    }
}
