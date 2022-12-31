package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzedo extends zzeba<zzedy, zzedx> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzedo(zzedm zzedmVar, Class cls) {
        super(cls);
    }

    @Override // com.google.android.gms.internal.ads.zzeba
    public final /* synthetic */ void zzd(zzedy zzedyVar) throws GeneralSecurityException {
        zzedy zzedyVar2 = zzedyVar;
        zzedm.zza(zzedyVar2.zzbbf());
        zzedm.zzeu(zzedyVar2.getKeySize());
    }

    @Override // com.google.android.gms.internal.ads.zzeba
    public final /* synthetic */ zzedx zze(zzedy zzedyVar) throws GeneralSecurityException {
        zzedy zzedyVar2 = zzedyVar;
        return (zzedx) ((zzelb) zzedx.zzbbg().zzew(0).zzt(zzejr.zzt(zzeiu.zzft(zzedyVar2.getKeySize()))).zzd(zzedyVar2.zzbbf()).zzbiw());
    }

    @Override // com.google.android.gms.internal.ads.zzeba
    public final /* synthetic */ zzedy zzr(zzejr zzejrVar) throws zzelo {
        return zzedy.zzd(zzejrVar, zzeko.zzbhw());
    }
}
