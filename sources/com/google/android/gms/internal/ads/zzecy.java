package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.ECPrivateKeySpec;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzecy extends zzeaz<zzeau, zzefn> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzecy(Class cls) {
        super(cls);
    }

    @Override // com.google.android.gms.internal.ads.zzeaz
    public final /* synthetic */ zzeau zzah(zzefn zzefnVar) throws GeneralSecurityException {
        zzefn zzefnVar2 = zzefnVar;
        zzefk zzbcu = zzefnVar2.zzbdb().zzbcu();
        zzefr zzbcw = zzbcu.zzbcw();
        zzehz zza = zzedh.zza(zzbcw.zzbdj());
        byte[] byteArray = zzefnVar2.zzbbe().toByteArray();
        return new zzehu((ECPrivateKey) zzeie.zzikm.zzhw("EC").generatePrivate(new ECPrivateKeySpec(new BigInteger(1, byteArray), zzehx.zza(zza))), zzbcw.zzbdl().toByteArray(), zzedh.zza(zzbcw.zzbdk()), zzedh.zza(zzbcu.zzbcy()), new zzedj(zzbcu.zzbcx().zzbcr()));
    }
}
