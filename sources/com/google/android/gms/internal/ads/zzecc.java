package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegd;
import java.security.GeneralSecurityException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzecc extends zzeax<zzees> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzecc() {
        super(zzees.class, new zzecf(zzeaq.class));
    }

    @Override // com.google.android.gms.internal.ads.zzeax
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesGcmKey";
    }

    @Override // com.google.android.gms.internal.ads.zzeax
    public final zzegd.zza zzbal() {
        return zzegd.zza.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.ads.zzeax
    public final zzeba<?, zzees> zzbao() {
        return new zzece(this, zzeev.class);
    }

    @Override // com.google.android.gms.internal.ads.zzeax
    public final /* synthetic */ void zzc(zzees zzeesVar) throws GeneralSecurityException {
        zzees zzeesVar2 = zzeesVar;
        zzeiv.zzz(zzeesVar2.getVersion(), 0);
        zzeiv.zzfu(zzeesVar2.zzbbe().size());
    }

    @Override // com.google.android.gms.internal.ads.zzeax
    public final /* synthetic */ zzees zzp(zzejr zzejrVar) throws zzelo {
        return zzees.zzk(zzejrVar, zzeko.zzbhw());
    }
}
