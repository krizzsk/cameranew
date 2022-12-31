package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegd;
import java.security.GeneralSecurityException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzedn extends zzeax<zzefv> {
    public zzedn() {
        super(zzefv.class, new zzedq(zzebd.class));
    }

    public static void zza(zzefv zzefvVar) throws GeneralSecurityException {
        zzeiv.zzz(zzefvVar.getVersion(), 0);
        if (zzefvVar.zzbbe().size() >= 16) {
            zza(zzefvVar.zzbdo());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }

    @Override // com.google.android.gms.internal.ads.zzeax
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.HmacKey";
    }

    @Override // com.google.android.gms.internal.ads.zzeax
    public final zzegd.zza zzbal() {
        return zzegd.zza.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.ads.zzeax
    public final zzeba<?, zzefv> zzbao() {
        return new zzedp(this, zzefz.class);
    }

    @Override // com.google.android.gms.internal.ads.zzeax
    public final /* synthetic */ void zzc(zzefv zzefvVar) throws GeneralSecurityException {
        zza(zzefvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeax
    public final /* synthetic */ zzefv zzp(zzejr zzejrVar) throws zzelo {
        return zzefv.zzt(zzejrVar, zzeko.zzbhw());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(zzega zzegaVar) throws GeneralSecurityException {
        if (zzegaVar.zzbbj() >= 10) {
            int i2 = zzeds.zzidt[zzegaVar.zzbdu().ordinal()];
            if (i2 == 1) {
                if (zzegaVar.zzbbj() > 20) {
                    throw new GeneralSecurityException("tag size too big");
                }
                return;
            } else if (i2 == 2) {
                if (zzegaVar.zzbbj() > 32) {
                    throw new GeneralSecurityException("tag size too big");
                }
                return;
            } else if (i2 == 3) {
                if (zzegaVar.zzbbj() > 64) {
                    throw new GeneralSecurityException("tag size too big");
                }
                return;
            } else {
                throw new GeneralSecurityException("unknown hash type");
            }
        }
        throw new GeneralSecurityException("tag size too small");
    }
}
