package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
final class zzdwm extends zzdwo {
    private final /* synthetic */ zzdwn zzhwc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdwm(zzdwn zzdwnVar, zzdwk zzdwkVar, CharSequence charSequence) {
        super(zzdwkVar, charSequence);
        this.zzhwc = zzdwnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdwo
    final int zzen(int i2) {
        return this.zzhwc.zzhwd.zza(this.zzhwe, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzdwo
    final int zzeo(int i2) {
        return i2 + 1;
    }
}
