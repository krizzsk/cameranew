package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzwp extends zzws<zzaur> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzane zzciv;
    private final /* synthetic */ zzwc zzciw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzwp(zzwc zzwcVar, Context context, zzane zzaneVar) {
        this.zzciw = zzwcVar;
        this.val$context = context;
        this.zzciv = zzaneVar;
    }

    @Override // com.google.android.gms.internal.ads.zzws
    public final /* synthetic */ zzaur zza(zzxy zzxyVar) throws RemoteException {
        return zzxyVar.zza(d.z0(this.val$context), this.zzciv, 204204000);
    }

    @Override // com.google.android.gms.internal.ads.zzws
    protected final /* synthetic */ zzaur zzqj() {
        zzwc.zza(this.val$context, "rewarded_video");
        return new zzaak();
    }

    @Override // com.google.android.gms.internal.ads.zzws
    public final /* synthetic */ zzaur zzqk() throws RemoteException {
        zzauy zzauyVar;
        zzauyVar = this.zzciw.zzcjb;
        return zzauyVar.zzc(this.val$context, this.zzciv);
    }
}
