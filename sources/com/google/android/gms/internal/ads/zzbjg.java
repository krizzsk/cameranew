package com.google.android.gms.internal.ads;

import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbjg implements zzdyu<zzdnl, zzdnl> {
    private Map<String, zzbjf> zzfqz;

    public zzbjg(Map<String, zzbjf> map) {
        this.zzfqz = map;
    }

    @Override // com.google.android.gms.internal.ads.zzdyu
    public final /* synthetic */ zzdzw<zzdnl> zzf(zzdnl zzdnlVar) throws Exception {
        zzdnl zzdnlVar2 = zzdnlVar;
        for (zzdni zzdniVar : zzdnlVar2.zzhks.zzhkq) {
            if (this.zzfqz.containsKey(zzdniVar.name)) {
                this.zzfqz.get(zzdniVar.name).zzm(zzdniVar.zzhko);
            }
        }
        return zzdzk.zzag(zzdnlVar2);
    }
}
