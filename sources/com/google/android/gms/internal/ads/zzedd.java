package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzedd extends zzeaz<zzeat, zzefo> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzedd(Class cls) {
        super(cls);
    }

    @Override // com.google.android.gms.internal.ads.zzeaz
    public final /* synthetic */ zzeat zzah(zzefo zzefoVar) throws GeneralSecurityException {
        zzefo zzefoVar2 = zzefoVar;
        zzefk zzbcu = zzefoVar2.zzbcu();
        zzefr zzbcw = zzbcu.zzbcw();
        return new zzeht(zzehx.zza(zzedh.zza(zzbcw.zzbdj()), zzefoVar2.zzbde().toByteArray(), zzefoVar2.zzbdf().toByteArray()), zzbcw.zzbdl().toByteArray(), zzedh.zza(zzbcw.zzbdk()), zzedh.zza(zzbcu.zzbcy()), new zzedj(zzbcu.zzbcx().zzbcr()));
    }
}
