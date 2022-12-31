package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzedq extends zzeaz<zzebd, zzefv> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzedq(Class cls) {
        super(cls);
    }

    @Override // com.google.android.gms.internal.ads.zzeaz
    public final /* synthetic */ zzebd zzah(zzefv zzefvVar) throws GeneralSecurityException {
        zzefv zzefvVar2 = zzefvVar;
        zzeft zzbdu = zzefvVar2.zzbdo().zzbdu();
        SecretKeySpec secretKeySpec = new SecretKeySpec(zzefvVar2.zzbbe().toByteArray(), "HMAC");
        int zzbbj = zzefvVar2.zzbdo().zzbbj();
        int i2 = zzeds.zzidt[zzbdu.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    return new zzeir(new zzeip("HMACSHA512", secretKeySpec), zzbbj);
                }
                throw new GeneralSecurityException("unknown hash");
            }
            return new zzeir(new zzeip("HMACSHA256", secretKeySpec), zzbbj);
        }
        return new zzeir(new zzeip("HMACSHA1", secretKeySpec), zzbbj);
    }
}
