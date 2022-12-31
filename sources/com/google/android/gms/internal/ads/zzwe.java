package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzwe extends zzws<zzavm> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ String zzciu;
    private final /* synthetic */ zzane zzciv;
    private final /* synthetic */ zzwc zzciw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzwe(zzwc zzwcVar, Context context, String str, zzane zzaneVar) {
        this.zzciw = zzwcVar;
        this.val$context = context;
        this.zzciu = str;
        this.zzciv = zzaneVar;
    }

    @Override // com.google.android.gms.internal.ads.zzws
    public final /* synthetic */ zzavm zza(zzxy zzxyVar) throws RemoteException {
        return zzxyVar.zzb(d.z0(this.val$context), this.zzciu, this.zzciv, 204204000);
    }

    @Override // com.google.android.gms.internal.ads.zzws
    protected final /* synthetic */ zzavm zzqj() {
        zzwc.zza(this.val$context, "rewarded");
        return new zzaai();
    }

    @Override // com.google.android.gms.internal.ads.zzws
    public final /* synthetic */ zzavm zzqk() throws RemoteException {
        return zzawc.zzd(this.val$context, this.zzciu, this.zzciv);
    }
}
