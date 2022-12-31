package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.facebook.common.callercontext.ContextChain;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdbl implements zzdfj<Bundle> {
    private final zzazn zzdtx;
    private final zzvx zzhba;

    public zzdbl(zzvx zzvxVar, zzazn zzaznVar) {
        this.zzhba = zzvxVar;
        this.zzdtx = zzaznVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void zzr(Bundle bundle) {
        Bundle bundle2 = bundle;
        int intValue = ((Integer) zzwr.zzqr().zzd(zzabp.zzcvx)).intValue();
        zzazn zzaznVar = this.zzdtx;
        if (zzaznVar != null && zzaznVar.zzehz >= intValue) {
            bundle2.putString("app_open_version", "2");
        }
        zzvx zzvxVar = this.zzhba;
        if (zzvxVar != null) {
            int i2 = zzvxVar.orientation;
            if (i2 == 1) {
                bundle2.putString("avo", ContextChain.TAG_PRODUCT);
            } else if (i2 == 2) {
                bundle2.putString("avo", "l");
            }
        }
    }
}
