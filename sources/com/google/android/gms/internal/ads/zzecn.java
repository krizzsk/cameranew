package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegd;
import java.security.GeneralSecurityException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzecn extends zzeax<zzegp> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzecn() {
        super(zzegp.class, new zzecm(zzeaq.class));
    }

    @Override // com.google.android.gms.internal.ads.zzeax
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.KmsAeadKey";
    }

    @Override // com.google.android.gms.internal.ads.zzeax
    public final zzegd.zza zzbal() {
        return zzegd.zza.REMOTE;
    }

    @Override // com.google.android.gms.internal.ads.zzeax
    public final zzeba<?, zzegp> zzbao() {
        return new zzecp(this, zzegs.class);
    }

    @Override // com.google.android.gms.internal.ads.zzeax
    public final /* synthetic */ void zzc(zzegp zzegpVar) throws GeneralSecurityException {
        zzeiv.zzz(zzegpVar.getVersion(), 0);
    }

    @Override // com.google.android.gms.internal.ads.zzeax
    public final /* synthetic */ zzegp zzp(zzejr zzejrVar) throws zzelo {
        return zzegp.zzv(zzejrVar, zzeko.zzbhw());
    }
}
