package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzwm extends zzws<zzxl> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzvs zzcit;
    private final /* synthetic */ String zzciu;
    private final /* synthetic */ zzane zzciv;
    private final /* synthetic */ zzwc zzciw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzwm(zzwc zzwcVar, Context context, zzvs zzvsVar, String str, zzane zzaneVar) {
        this.zzciw = zzwcVar;
        this.val$context = context;
        this.zzcit = zzvsVar;
        this.zzciu = str;
        this.zzciv = zzaneVar;
    }

    @Override // com.google.android.gms.internal.ads.zzws
    public final /* synthetic */ zzxl zza(zzxy zzxyVar) throws RemoteException {
        return zzxyVar.zzb(d.z0(this.val$context), this.zzcit, this.zzciu, this.zzciv, 204204000);
    }

    @Override // com.google.android.gms.internal.ads.zzws
    public final /* synthetic */ zzxl zzqj() {
        zzwc.zza(this.val$context, "interstitial");
        return new zzaac();
    }

    @Override // com.google.android.gms.internal.ads.zzws
    public final /* synthetic */ zzxl zzqk() throws RemoteException {
        zzvj zzvjVar;
        zzvjVar = this.zzciw.zzcix;
        return zzvjVar.zza(this.val$context, this.zzcit, this.zzciu, this.zzciv, 2);
    }
}
