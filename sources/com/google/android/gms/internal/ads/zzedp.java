package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzedp extends zzeba<zzefz, zzefv> {
    private final /* synthetic */ zzedn zzidw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzedp(zzedn zzednVar, Class cls) {
        super(cls);
        this.zzidw = zzednVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeba
    public final /* synthetic */ void zzd(zzefz zzefzVar) throws GeneralSecurityException {
        zzefz zzefzVar2 = zzefzVar;
        if (zzefzVar2.getKeySize() >= 16) {
            zzedn.zza(zzefzVar2.zzbdo());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }

    @Override // com.google.android.gms.internal.ads.zzeba
    public final /* synthetic */ zzefv zze(zzefz zzefzVar) throws GeneralSecurityException {
        zzefz zzefzVar2 = zzefzVar;
        return (zzefv) ((zzelb) zzefv.zzbdp().zzfi(0).zzd(zzefzVar2.zzbdo()).zzae(zzejr.zzt(zzeiu.zzft(zzefzVar2.getKeySize()))).zzbiw());
    }

    @Override // com.google.android.gms.internal.ads.zzeba
    public final /* synthetic */ zzefz zzr(zzejr zzejrVar) throws zzelo {
        return zzefz.zzu(zzejrVar, zzeko.zzbhw());
    }
}
